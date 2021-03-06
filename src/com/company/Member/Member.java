package com.company.Member;

import com.company.data.FileHandler;

public class Member implements Comparable{

    protected String name;
    protected int age;
    protected String activeStatus; //active or passive?
    protected String ageRange; //junior or senior?
    protected String competitiveStatus; //competitive or non-competitive?
    private FileHandler fh = new FileHandler();



    public Member(String name, int age, String ageRange, String activeStatus, String competitiveStatus){
        this.name = name;
        this.age = age;
        this.activeStatus = activeStatus;
        this.ageRange = ageRange;
        this.competitiveStatus = competitiveStatus;

    }

    public Member(String name, int age, String ageRange){
        this.name = name;
        this.age = age;
        this.ageRange = ageRange;
    }

    public Member(String name, String ageRange, String activeStatus, String competitiveStatus){
        this.name = name;
        this.ageRange = ageRange;
        this.activeStatus = activeStatus;
        this.competitiveStatus = competitiveStatus;
    }

    public Member(){

    }

    public String getAgeRange() {
        return ageRange;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getActiveStatus() {
        return activeStatus;
    }

    public String getCompetitiveStatus() {
        return competitiveStatus;
    }

    public void setActiveStatus(String activeStatus) {
        this.activeStatus = activeStatus;
    }

    public void setCompetitiveStatus(String competitiveStatus) {
        this.competitiveStatus = competitiveStatus;
    }

    public String makeStringMember() {

        //Initializing a StringBuilder object.
        StringBuilder stringBuilder = new StringBuilder();

        //Loops through the list of members.
        for (Member member : fh.readFile()) {

            stringBuilder.append(member.getName()).append(" ");

            stringBuilder.append(member.getAgeRange()).append(" ");

            stringBuilder.append(member.getActiveStatus()).append(" ");

            stringBuilder.append(member.getCompetitiveStatus()).append("\n");

        }
        return stringBuilder.toString();
    }



    @Override
    public String toString() {
        return name + ": " + ageRange + ". " + activeStatus + " " + competitiveStatus + "\n";
    }

    @Override
    public int compareTo(Object other) {
        Member anotherMember = (Member) other; // Typecasting
        return name.compareTo(anotherMember.name);
    }

}
