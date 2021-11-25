package com.company.domain;

public class Competitor extends Member {

    private String discipline;
    private boolean doesCrawl = false;
    private boolean doesBreast = false;
    private boolean doesButterfly = false;
    private boolean doesBack = false;



    public Competitor(String name, int age, String ageRange, String activeStatus, String competitiveStatus, String discipline){
        super(name, age, ageRange, activeStatus, competitiveStatus);
        this.discipline = discipline;
    }

    public void getCompetetorsSwimStatus(){
        System.out.println("Does this person do crawl? " + doesCrawl);
        System.out.println("Does this person do breast? " + doesBreast);
        System.out.println("Does this person do butterfly? " + doesButterfly);
        System.out.println("Does this person do crawl? " + doesCrawl);
    }

    public void changeCrawl(){
        doesCrawl = !doesCrawl;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    @Override
    public String toString() {
        return name + ": " + age + " år, " + ageRange + ". Discipline(s): " + discipline +  "\n";
    }
}
