package com.esprit.micoservice.candidat;

import com.esprit.micoservice.candidat.Repository.CandidateRepository;
import com.esprit.micoservice.candidat.entity.candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CandidateApplication {

    public static void main(String[] args) {
        SpringApplication.run(CandidateApplication.class, args);
    }
    @Autowired
    private CandidateRepository repository;
    @Bean
    ApplicationRunner init() {
        return (args) -> {
            repository.save(new candidate("Mariem", "Ch", "ma@esprit.tn"));
            repository.save(new candidate("Sarra", "ab", "sa@esprit.tn"));
            repository.save(new candidate("Mohamed", "ba", "mo@esprit.tn"));
            repository.findAll().forEach(System.out::println);
        };
    }
}
