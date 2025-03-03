package com.example.backend.controller;


import com.example.backend.dto.NewsDTO;
import com.example.backend.dto.NewsDetailsDTO;
import com.example.backend.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/news")
@RequiredArgsConstructor
public class NewsController {

    private final NewsService newsService;

    @GetMapping("/latest")
    public ResponseEntity<List<NewsDTO>> getLatestNews() {
        List<NewsDTO> latestNews = newsService.getLatestNews();
        return ResponseEntity.ok(latestNews);
    }

    @GetMapping("/all")
    public ResponseEntity<List<NewsDTO>> getAllNews() {
        List<NewsDTO> allNews = newsService.getAllNews();
        return ResponseEntity.ok(allNews);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NewsDetailsDTO> getNewsById(@PathVariable Long id) {
        NewsDetailsDTO newsDetailsDTO = newsService.getNewsById(id);
        return ResponseEntity.ok(newsDetailsDTO);
    }

    @GetMapping("/{newsId}/recommended")
    public ResponseEntity<List<NewsDTO>> getRecomendedNews(@PathVariable Long newsId) {
        List<NewsDTO> recomendedNews = newsService.getRecomendedNews(newsId);
        return ResponseEntity.ok(recomendedNews);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<NewsDTO>> getNewsByCategory(@PathVariable Long categoryId) {
        List<NewsDTO> newsByCategory = newsService.getNewsByCategory(categoryId);
        return ResponseEntity.ok(newsByCategory);
    }

}
