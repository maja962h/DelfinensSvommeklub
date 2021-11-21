package com.company.domain;

public class Member {

    private int age;
    private String activeStatus; //active or passive?
    private String ageRange; //junior or senior?
    private String competitiveStatus; //competitive or non-competitive?

    public Member(int age, String activeStatus, String ageRange, String competitiveStatus){
        this.age = age;
        this.activeStatus = activeStatus;
        this.ageRange = ageRange;
        this.competitiveStatus = competitiveStatus;

    }




}
