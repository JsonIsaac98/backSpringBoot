package com.example.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewsDetailsDTO {
    private Long id;
    private String title;
    private String description;
    private String content;
    private String imageUrl;
    private LocalDateTime publishDate;
    private String categoryName;
    private List<String> tags;
}
