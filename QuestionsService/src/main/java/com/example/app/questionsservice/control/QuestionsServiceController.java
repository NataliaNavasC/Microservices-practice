package com.example.app.questionsservice.control;

import com.example.app.questionsservice.model.Question;
import com.example.app.questionsservice.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class QuestionsServiceController {
    @Autowired
    Environment env;

    @Autowired
    private QuestionRepository repo;

    @GetMapping("/services/{id}/questions")
    public List<Question> getQuestions(@PathVariable("id") int serviceId) {
        List<Question> questions = new ArrayList<>();

        //TODO: Consumir un servicio de ServicesService que verifique que el servicio existe en la BD

        repo.findAll().forEach(q -> {
            if(q.getServiceId() == serviceId)
                questions.add(q);
        });

        //TODO: Retornar un 404 NOT FOUND si el servicio no existe

        return questions;
    }

    @PostMapping("/services/{id}/questions")
    public Question postQuestion(@PathVariable("id") int serviceId, @RequestBody Question question) {

        //TODO: Consumir un servicio de ServicesService que verifique que el servicio existe en la BD

        //Si el servicio si existe se agrega la nueva pregunta con ese serviceId
        return repo.save(new Question(serviceId, question.getDescription(), question.getResponse()));

        //TODO: Retornar un 404 NOT FOUND si el servicio no existe
    }
}
