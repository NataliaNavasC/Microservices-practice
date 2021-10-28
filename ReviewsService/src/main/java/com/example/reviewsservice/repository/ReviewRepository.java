package com.example.reviewsservice.repository;

import com.example.reviewsservice.model.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Integer> {
}
