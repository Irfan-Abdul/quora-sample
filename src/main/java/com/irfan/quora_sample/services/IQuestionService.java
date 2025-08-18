package com.irfan.quora_sample.services;

import com.irfan.quora_sample.dto.QuestionRequestDTO;
import com.irfan.quora_sample.dto.QuestionResponseDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IQuestionService {
    public Mono<QuestionResponseDTO> createQuestion(QuestionRequestDTO questionRequestDTO);


    Mono<QuestionResponseDTO> findQuestionById(String id);

    Flux<QuestionResponseDTO> findAllQuestions();

    Mono<Void> deleteQuestionById(String id);

    Flux<QuestionResponseDTO> searchQuestions(String query, String lastId, int size);
}
