package com.leo.apirest.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "contracttype")
public class ContractType implements Serializable {

    @Id
    @Column(name = "idContractType")
    private Integer idContractType;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "isActive")
    private boolean isActive;

    @Column(name = "dateCreated")
    private String dateCreated;

    public Integer getIdContractType() {
        return idContractType;
    }

    public void setIdContractType(Integer idContractType) {
        this.idContractType = idContractType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }



}
