package com.example.app.questionsservice.control;

import com.example.app.questionsservice.model.Question;
import com.example.app.questionsservice.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class QuestionsServiceController {
    @Autowired
    Environment env;

    @Autowired
    private QuestionRepository repo;

    @RequestMapping(
            value = "/questions/status",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String getStatus(){
        String port = env.getProperty("local.server.port");
        return "Server is up on port " + port;
    }
    @GetMapping("/questions")
    public List<Question> getQuestions(@RequestParam(name = "serviceID") int serviceId) {
        List<Question> questions = new ArrayList<>();
        repo.findAll().forEach(q -> {
            if(q.getServiceId() == serviceId)
                questions.add(q);
        });
        return questions;
    }

    @PostMapping("/questions")
    public Question postQuestion(@RequestBody Question question) {
        return repo.save(new Question(question.getServiceId(), question.getUsername(), question.getDescription(), question.getResponse()));
    }
}
