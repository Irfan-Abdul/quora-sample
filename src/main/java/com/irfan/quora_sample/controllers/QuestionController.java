package com.irfan.quora_sample.controllers;

import com.irfan.quora_sample.dto.QuestionRequestDTO;
import com.irfan.quora_sample.dto.QuestionResponseDTO;
import com.irfan.quora_sample.services.IQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.*;

@RestController
@RequestMapping("/question")
@RequiredArgsConstructor
public class QuestionController {

    private final IQuestionService questionService;

    @PostMapping
    public Mono<QuestionResponseDTO> createQuestion(@Validated @RequestBody QuestionRequestDTO questionRequestDTO){
        return questionService.createQuestion(questionRequestDTO);
    }

    @GetMapping("/{id}")
    public Mono<QuestionResponseDTO> findQuestionById(@PathVariable String id){
        return questionService.findQuestionById(id);
    }

    @GetMapping(value = "/", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<QuestionResponseDTO> findAllQestions(@RequestParam(required = false)  String cursor,
                                                     @RequestParam(defaultValue = "2") int size){
        return questionService.findAllQuestions(cursor,size);
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)

    @DeleteMapping("/{id}")
    public Mono<Void> deleteQuestionByID(@PathVariable String id){
        return questionService.deleteQuestionById(id);
    }

    @GetMapping(value = "/search", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<QuestionResponseDTO> searchQuestions(@RequestParam String query,
                                                     @RequestParam(required = false) String cursor,
                                                     @RequestParam(defaultValue = "10") int size){
        return questionService.searchQuestions(query,cursor,size);
    }
}
