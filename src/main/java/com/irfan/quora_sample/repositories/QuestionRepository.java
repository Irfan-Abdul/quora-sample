package com.irfan.quora_sample.repositories;

import com.irfan.quora_sample.models.Questions;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.Optional;

@Repository
public interface QuestionRepository extends ReactiveMongoRepository<Questions,String> {

    Flux<Questions> findByTitleContaining(String query);
}
