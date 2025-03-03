package com.example.backend.service;

import com.example.backend.dto.NewsDTO;
import com.example.backend.dto.NewsDetailsDTO;
import com.example.backend.model.News;
import com.example.backend.repository.NewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NewsService {

    private final NewsRepository newsRepository;

    public List<NewsDTO> getAllNews() {
        List<News> allNews = newsRepository.findAll();
        return mapToNewDTOList(allNews);
    }

    public List<NewsDTO> getLatestNews() {
        List<News> latestNews = newsRepository.findTop5ByOrderByPublishDateDesc();
        return mapToNewDTOList(latestNews);
    }

    public NewsDetailsDTO getNewsById(Long id) {
        News news = newsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Noticia no encontrada"));
        return mapToNewsDetailsDTO(news);
    }

    public List<NewsDTO> getRecomendedNews(Long newsId) {
        List<News> recomendedNews = newsRepository.findRandomRecommendedNews(newsId);
        return mapToNewDTOList(recomendedNews);
    }

    public List<NewsDTO> getNewsByCategory(Long categoryId) {
        List<News> newsByCategory = newsRepository.findByCategoryId(categoryId);
        return mapToNewDTOList(newsByCategory);
    }

    private List<NewsDTO> mapToNewDTOList(List<News> newsList) {
        return newsList.stream()
                .map(this::mapToNewDTO)
                .collect(Collectors.toList());
    }

    private NewsDTO mapToNewDTO(News news) {
        return NewsDTO.builder()
                .id(news.getId())
                .title(news.getTitle())
                .description(news.getDescription())
                .imageUrl(news.getImageUrl())
                .publishDate(news.getPublishDate())
                .categoryName(news.getCategory() != null ? news.getCategory().getName() : null)
                .build();
    }

    private NewsDetailsDTO mapToNewsDetailsDTO(News news) {
        List<String> tagNames = news.getTags().stream()
                .map(tag -> tag.getName())
                .collect(Collectors.toList());

        return NewsDetailsDTO.builder()
                .id(news.getId())
                .title(news.getTitle())
                .description(news.getDescription())
                .imageUrl(news.getImageUrl())
                .publishDate(news.getPublishDate())
                .categoryName(news.getCategory() != null ? news.getCategory().getName() : null)
                .tags(tagNames)
                .build();
    }
}