package com.company.domain;

public class Member implements Comparable{

    protected String name;
    protected int age;
    protected String activeStatus; //active or passive?
    protected String ageRange; //junior or senior?
    protected String competitiveStatus; //competitive or non-competitive?



    public Member(String name, int age, String ageRange, String activeStatus, String competitiveStatus){
        this.name = name;
        this.age = age;
        this.activeStatus = activeStatus;
       this.ageRange = ageRange;
        this.competitiveStatus = competitiveStatus;

    }



    public String getAgeRange() {
        return ageRange;
    }


    @Override
    public String toString() {
        return name + ": " + age + " år, " + ageRange + ". " + activeStatus + " " + competitiveStatus + "\n";
    }

    @Override
    public int compareTo(Object other) {
        Member anotherMember = (Member) other; // Typecasting
        return name.compareTo(anotherMember.name);
    }
}
