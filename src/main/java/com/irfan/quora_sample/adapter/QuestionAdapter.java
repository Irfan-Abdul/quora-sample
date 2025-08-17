package com.irfan.quora_sample.adapter;

import com.irfan.quora_sample.dto.QuestionRequestDTO;
import com.irfan.quora_sample.dto.QuestionResponseDTO;
import com.irfan.quora_sample.models.Questions;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

public class QuestionAdapter {

    public static Questions toQuestion(QuestionRequestDTO requestDTO){
        return Questions.builder()
                .title(requestDTO.getTitle())
                .content(requestDTO.getContent())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    public static QuestionResponseDTO toQuestionResponseDTO(Questions question){
        return QuestionResponseDTO.builder()
                .title(question.getTitle())
                .content(question.getContent())
                .id(question.getId())
                .createdAt(question.getCreatedAt())
                .build();
    }
}
