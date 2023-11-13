package com.esprit.microservice.job.Service;

import com.esprit.microservice.job.Entity.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esprit.microservice.job.Repository.JobRepository;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    private JobRepository JobRepository;

    public List<Job> RetrieveAllJobs(){
        return JobRepository.findAll();
    }
    public Optional<Job> RetrieveJobById(Integer id){
        return JobRepository.findById(id);
    }
    public String UpdateEtatJob(Integer id){
        Optional<Job> Jopopt=JobRepository.findById(id);
        if(Jopopt.isPresent()){
            Job j=Jopopt.get();
            Boolean etat=j.getEtat();
            j.setEtat(!etat);
            JobRepository.save(j);
            return "l'Etat du cette job a ete modifier";
        }
        return "Job n'existe pas";
    }
}
