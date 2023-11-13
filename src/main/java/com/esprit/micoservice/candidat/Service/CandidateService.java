package com.esprit.micoservice.candidat.Service;

import com.esprit.micoservice.candidat.Repository.CandidateRepository;
import com.esprit.micoservice.candidat.entity.candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;
    public candidate addCandidat(candidate candidate) {
        return candidateRepository.save(candidate);
    }


    public candidate updateCandidat(int id, candidate newCandidat) {
        if (candidateRepository.findById(id).isPresent()) {
            candidate existingCandidat = candidateRepository.findById(id).get();
            existingCandidat.setNom(newCandidat.getNom());
            existingCandidat.setPrenom(newCandidat.getPrenom());
            existingCandidat.setEmail(newCandidat.getEmail());
            return candidateRepository.save(existingCandidat);
        } else
            return null;
    }
    public String deleteCandidat(int id) {
        if (candidateRepository.findById(id).isPresent()) {
            candidateRepository.deleteById(id);
            return "candidat supprimé";
        } else
            return "candidat non supprimé";
    }
}
