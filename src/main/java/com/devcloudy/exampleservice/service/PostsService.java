package com.devcloudy.exampleservice.service;

import com.devcloudy.exampleservice.entity.Posts;
import com.devcloudy.exampleservice.mapper.PostsMapper;
import com.devcloudy.exampleservice.posts.PostsCreateDto;
import com.devcloudy.exampleservice.posts.PostsDto;
import com.devcloudy.exampleservice.posts.PostsUpdateDto;
import com.devcloudy.exampleservice.repository.PostsRepository;
import com.devcloudy.exampleservice.validation.EditPostsAccessDeniedException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostsService {

    private final PostsRepository repository;
    private final PostsMapper mapper;

    private static final int DEFAULT_PAGE_SIZE = 10;

    public List<PostsDto> getPosts(Integer limit) {
        return repository.findAll(PageRequest.of(0, limit == null ? DEFAULT_PAGE_SIZE : limit)).stream()
                .map(mapper::postToPostDto).collect(Collectors.toList());
    }

    public PostsDto getPostById(Long id) {
        return mapper.postToPostDto(repository.findById(id).orElse(null));
    }

    public PostsDto create(PostsCreateDto request) {
        Posts posts = mapper.toPost(request, getCurrentUsername());
        posts.setAuthor(getCurrentUsername());
        log.info(getCurrentUsername() + " creating a post...");
        repository.save(posts);
        return mapper.postToPostDto(posts);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public PostsDto update(PostsUpdateDto request, Long id) {
        Posts post = mapper.postsUpdateRequestToPostsView(request, id, getCurrentUsername());
        repository.save(post);
        return mapper.postToPostDto(post);
    }

    private String getCurrentUsername() {
        return (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    private boolean isCurrentUserAdmin() {
        return getCurrentUserRoles().contains("ADMIN");
    }

    private void checkEditTaskPermission(Long id) {
        repository.findById(id).ifPresent(posts -> {
            if (!posts.getAuthor().equals(getCurrentUsername()) && !isCurrentUserAdmin()) {
                throw new EditPostsAccessDeniedException();
            }
        });
    }

    private List<String> getCurrentUserRoles() {
        return SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority).collect(Collectors.toList());
    }

}
