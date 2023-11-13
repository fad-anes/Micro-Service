package com.esprit.microservice.job.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
@Entity
public class Job implements Serializable {

    private static final long serialverionUID=6;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String service;
    private Boolean etat;

    public String getService() {
        return service;
    }

    public void setEtat(Boolean etat) {
        this.etat = etat;
    }

    public Job() {
    }

    public Boolean getEtat() {
        return etat;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Job(Integer id,String service,Boolean etat) {
        super();
        this.id = id;
        this.service = service;
        this.etat = etat;
    }

    public Integer getId() {
        return id;
    }
}
