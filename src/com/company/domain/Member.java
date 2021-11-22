package com.company.domain;

public class Member {

    private String name;
    private int age;
    private String activeStatus; //active or passive?
    private String ageRange; //junior or senior?
    private String competitiveStatus; //competitive or non-competitive?

    public Member(String name, int age, String ageRange, String activeStatus, String competitiveStatus){
        this.name = name;
        this.age = age;
        this.activeStatus = activeStatus;
       this.ageRange = ageRange;
        this.competitiveStatus = competitiveStatus;

    }


    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", activeStatus='" + activeStatus + '\'' +
                ", ageRange='" + ageRange + '\'' +
                ", competitiveStatus='" + competitiveStatus + '\'' +
                '}';
    }
}
