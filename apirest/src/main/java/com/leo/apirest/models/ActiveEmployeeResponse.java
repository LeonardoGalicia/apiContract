package com.leo.apirest.models;

import java.io.Serializable;

public class ActiveEmployeeResponse implements Serializable {
    private String fullName;
    private String taxIdNumber;
    private String email;
    private String contractTypeName;
    private String contractDateFrom;
    private String contractDateTo;
    private double contractSalaryPerDay;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getTaxIdNumber() {
        return taxIdNumber;
    }

    public void setTaxIdNumber(String taxIdNumber) {
        this.taxIdNumber = taxIdNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContractTypeName() {
        return contractTypeName;
    }

    public void setContractTypeName(String contractTypeName) {
        this.contractTypeName = contractTypeName;
    }

    public String getContractDateFrom() {
        return contractDateFrom;
    }

    public void setContractDateFrom(String contractDateFrom) {
        this.contractDateFrom = contractDateFrom;
    }

    public String getContractDateTo() {
        return contractDateTo;
    }

    public void setContractDateTo(String contractDateTo) {
        this.contractDateTo = contractDateTo;
    }

    public double getContractSalaryPerDay() {
        return contractSalaryPerDay;
    }

    public void setContractSalaryPerDay(double contractSalaryPerDay) {
        this.contractSalaryPerDay = contractSalaryPerDay;
    }
}
