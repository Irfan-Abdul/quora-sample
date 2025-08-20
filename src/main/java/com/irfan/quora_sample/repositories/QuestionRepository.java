package com.irfan.quora_sample.repositories;

import com.irfan.quora_sample.dto.QuestionResponseDTO;
import com.irfan.quora_sample.models.Questions;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Scanner;

@Repository
public interface QuestionRepository extends ReactiveMongoRepository<Questions,String> {



    @Query("{'title':{$regex: ?0, $options: 'i'}}")
    Flux<QuestionResponseDTO> findByTitleFirstPage(String query, Pageable pageable);

    @Query("{'title' :{$regex: ?0, $options: 'i'}, 'createdAt' :{$lt: ?1}}")
    Flux<QuestionResponseDTO> findByTitleAfterId(String query, LocalDateTime cursor, Pageable pageable);


    //Flux<Questions> findByLatest(org.springframework.data.mongodb.core.query.Query query, Class<Questions> questionsClass);
}
