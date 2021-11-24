package com.company.domain;

public class Competitor extends Member {

    private String disciplines;


    public Competitor(String name, int age, String ageRange, String activeStatus, String competitiveStatus, String discipline){
        super(name, age, ageRange, activeStatus, competitiveStatus);
        this.disciplines = discipline;

    }

    @Override
    public String toString() {
        return name + ": " + age + " år, " + ageRange + ". Discipline(s): " + disciplines +  "\n";
    }
}
