package com.irfan.quora_sample.services;

import com.irfan.quora_sample.adapter.QuestionAdapter;
import com.irfan.quora_sample.dto.QuestionRequestDTO;
import com.irfan.quora_sample.dto.QuestionResponseDTO;
import com.irfan.quora_sample.models.Questions;
import com.irfan.quora_sample.repositories.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class QuestionService implements IQuestionService{

    private final QuestionRepository questionRepository;
    @Override
    public Mono<QuestionResponseDTO> createQuestion(QuestionRequestDTO questionRequestDTO) {
        return questionRepository.save(QuestionAdapter.toQuestion(questionRequestDTO))
                .map(QuestionAdapter::toQuestionResponseDTO)
                .doOnSuccess(response-> System.out.println("Question created successfully: "+response))
                .doOnError(error-> System.out.println("error in creating the question: "+error));
    }

    @Override
    public Mono<QuestionResponseDTO> findQuestionById(String id) {
        return questionRepository.findById(id)
                .map(QuestionAdapter::toQuestionResponseDTO)
                .doOnError(error-> System.out.println("|||||| error occured: "+error));
    }

    @Override
    public Flux<QuestionResponseDTO> findAllQuestions() {
        return questionRepository.findAll().skip(0).take(5).map(QuestionAdapter::toQuestionResponseDTO);
    }

    @Override
    public Mono<Void> deleteQuestionById(String id) {
        return questionRepository.deleteById(id);
    }

    @Override
    public Flux<QuestionResponseDTO> searchQuestions(String query, int page, int size) {

        return questionRepository.findByTitleContaining (query).skip(page*size).take(size).map(QuestionAdapter::toQuestionResponseDTO);
    }
}
