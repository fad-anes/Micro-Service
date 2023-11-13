package com.esprit.microservice.job.Repository;
import com.esprit.microservice.job.Entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {

}