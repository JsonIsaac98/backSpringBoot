package com.example.backend.repository;

import com.example.backend.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NewsRepository extends JpaRepository <News, Long> {

    List<News> findTop5ByOrderByPublishDateDesc();

    @Query("SELECT n FROM News n WHERE n.category.id = :categoryId ORDER BY n.publishDate DESC")
    List<News> findByCategoryId(@Param("categoryId") Long categoryId);

    @Query(value = "SELECT * FROM news n WHERE n.id != :newsId ORDER BY RAND() LIMIT 3", nativeQuery = true)
    List<News> findRandomRecommendedNews(@Param("newsId") Long newsId);

}
