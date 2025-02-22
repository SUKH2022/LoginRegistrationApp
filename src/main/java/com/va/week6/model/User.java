package com.va.week6.model;

/*
 * @author - Sukhpreet Saini
 * @date - 10/2/2025
 * Description - Assignment2.2_webdynimicApp 
 * 
 */

public class User {
    private String username;
    private String password;
    private String company;
    private Integer payRoll;
    private String fullName;
    private String referenceIndicator;
    private String jobTitle;
    private String functionField;
    private String subFunction;
    private String section;
    private String location;
    private String building;
    private String room;
    private Integer requesterTel;

    // Temporary fields for decryption
    // Making both the field transient for security
    // The transient keyword is a modifier that tells Java to ignore an attribute when serializing an object.
    private transient String originalFullName;
    private transient String originalPayRoll;
    private transient String originalRequesterTel;
    		
    // Add getters and setters for all fields
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getPayRoll() {
        return payRoll;
    }

    public void setPayRoll(Integer payRoll) {
        this.payRoll = payRoll;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getReferenceIndicator() {
        return referenceIndicator;
    }

    public void setReferenceIndicator(String referenceIndicator) {
        this.referenceIndicator = referenceIndicator;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getFunctionField() {
        return functionField;
    }

    public void setFunctionField(String functionField) {
        this.functionField = functionField;
    }

    public String getSubFunction() {
        return subFunction;
    }

    public void setSubFunction(String subFunction) {
        this.subFunction = subFunction;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Integer getRequesterTel() {
        return requesterTel;
    }

    public void setRequesterTel(Integer requesterTel) {
        this.requesterTel = requesterTel;
    }

    public String getOriginalPayRoll() {
        return originalPayRoll;
    }

    public void setOriginalPayRoll(String originalPayRoll) {
        this.originalPayRoll = originalPayRoll;
    }

    public String getOriginalRequesterTel() {
        return originalRequesterTel;
    }

    public void setOriginalRequesterTel(String originalRequesterTel) {
        this.originalRequesterTel = originalRequesterTel;
    }

    public String getOriginalFullName() {
        return originalFullName;
    }

    public void setOriginalFullName(String originalFullName) {
        this.originalFullName = originalFullName;
    }
}