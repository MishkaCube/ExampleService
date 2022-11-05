package com.devcloudy.exampleservice.mapper;

import com.devcloudy.exampleservice.entity.Posts;
import com.devcloudy.exampleservice.posts.PostsCreateDto;
import com.devcloudy.exampleservice.posts.PostsDto;
import com.devcloudy.exampleservice.posts.PostsUpdateDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostsMapper {

    PostsDto postToPostDto(Posts entity);

    Posts toPost(PostsCreateDto dto, String author);

    Posts postsUpdateRequestToPostsView(PostsUpdateDto dto, Long id, String author);
    // Excursion excursionUpdateRequestToExcurisonView(ExcursionUpdate dto, Long id);


}
