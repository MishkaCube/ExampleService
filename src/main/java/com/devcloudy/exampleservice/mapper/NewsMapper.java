package com.devcloudy.exampleservice.mapper;

import com.devcloudy.exampleservice.entity.News;
import com.devcloudy.exampleservice.news.NewsCreateDto;
import com.devcloudy.exampleservice.news.NewsDto;
import com.devcloudy.exampleservice.news.NewsUpdateDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NewsMapper {

    NewsDto newsToNewsDto(News entity);
    News toNews(NewsCreateDto dto);
    News newsUpdateRequestToNewsView(NewsUpdateDto dto, Long id);


}
