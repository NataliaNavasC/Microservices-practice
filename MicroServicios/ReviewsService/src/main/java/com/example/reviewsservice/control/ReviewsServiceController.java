package com.example.reviewsservice.control;

import com.example.reviewsservice.model.Review;
import com.example.reviewsservice.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ReviewsServiceController {
    @Autowired
    Environment env;

    @Autowired
    private ReviewRepository repo;

    @RequestMapping(
            value = "/status",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String getStatus(){
        String port = env.getProperty("local.server.port");
        return "Server is up on port " + port;
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Review> getReviews(@RequestParam(name = "serviceID") int serviceId) {
        List<Review> reviews = new ArrayList<>();
        repo.findAll().forEach(r -> {
            if(r.getServiceId() == serviceId)
                reviews.add(r);
        });
        return reviews;
    }

    @PostMapping("/")
    public Review postReview(@RequestBody Review review) {
        return repo.save(new Review(review.getServiceId(), review.getUsername(), review.getComment()));
    }

//    @PutMapping("/response")
//    public Review respondReview(@RequestBody Review review) {
//        Review reviewToUpdate = repo.findById(review.getId()).get();
//        reviewToUpdate.setResponse(review.getResponse());
//        return  repo.save(reviewToUpdate);
//    }
}
