package ua.training.system_what_where_when.service;

import org.springframework.stereotype.Service;
import ua.training.system_what_where_when.model.AnsweredQuestion;
import ua.training.system_what_where_when.model.User;
import ua.training.system_what_where_when.repository.AnsweredQuestionRepository;

@Service
public class AnsweredQuestionService {

    private AnsweredQuestionRepository answeredQuestionRepository;

    public AnsweredQuestionService(AnsweredQuestionRepository answeredQuestionRepository) {
        this.answeredQuestionRepository = answeredQuestionRepository;
    }

    public AnsweredQuestion findAnsweredQuestionById(Long id) {
        return answeredQuestionRepository.findById(id).get();
    }
}
