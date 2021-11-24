package com.company.domain;

public class Member implements Comparable{

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

    public Member(){

    }


    @Override
    public String toString() {
        return name + ": " + age + " år, " + ageRange + ". " + competitiveStatus + ".\n";
    }

    @Override
    public int compareTo(Object other) {
        Member anotherMember = (Member) other; // Typecasting
        return name.compareTo(anotherMember.name);
    }
}
