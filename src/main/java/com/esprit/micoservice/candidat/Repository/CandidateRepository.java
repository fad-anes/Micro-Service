package com.esprit.micoservice.candidat.Repository;

import com.esprit.micoservice.candidat.entity.candidate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends JpaRepository<candidate, Integer> {

    @Query("select c from candidate c where c.nom like :name")
    public Page<candidate> candidatByNom(@Param("name") String n, Pageable pageable);
}
