package com.example.toyzee.repository;

import com.example.toyzee.model.AgeRestriction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgeRestrictionRepository extends JpaRepository<AgeRestriction, Long> {
}