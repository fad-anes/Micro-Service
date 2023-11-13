package com.esprit.microservice.job.Controlleur;

import com.esprit.microservice.job.Entity.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.esprit.microservice.job.Service.JobService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jobs")
public class JobControlleur {

    @Autowired
    private JobService JobService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Job> retrievealljobs(){
        return JobService.RetrieveAllJobs();
    }

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Optional<Job> retrievejobbyId(@PathVariable(value = "id") Integer id){
        return JobService.RetrieveJobById(id);

    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> updateEtatJob(@PathVariable(value = "id") Integer id){
        return new ResponseEntity<>(JobService.UpdateEtatJob(id),
                HttpStatus.OK);
    }
}
