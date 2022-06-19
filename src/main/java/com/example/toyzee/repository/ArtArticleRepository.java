package com.example.toyzee.repository;

import com.example.toyzee.model.ArtArticle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtArticleRepository extends JpaRepository<ArtArticle, Long> {
}