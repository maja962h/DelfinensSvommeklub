package com.company.data;
import com.company.domain.Competitor;
import com.company.domain.Member;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {

    private ArrayList<Member> memberList = new ArrayList<>();
    private ArrayList<Competitor> competitors = new ArrayList<>();


    public void addNewMember(String name, int age, String ageRange, String activeStatus, String competitiveStatus){
        Member member = new Member(name, age, ageRange, activeStatus, competitiveStatus);
        memberList.add(member);
    }

    public void addOneMember(Member member){
        memberList.add((member));
    }
    public void saveMember(){
        File file = new File("data/members.txt");

        try{
            FileWriter fileWriter = new FileWriter(file, true);

            for(Member member : memberList){
                fileWriter.append(member.toString());
                fileWriter.append("\n");
            }
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void saveCompetitor(){
        File file = new File("data/competitors.txt");

        try{
            FileWriter fileWriter = new FileWriter(file, true);

            for(Member member : competitors){
                fileWriter.append(member.toString());
                fileWriter.append("\n");
            }
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void readFile(){
        File myObj = new File("data/members.txt");
        try {
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


    public ArrayList<Member> getMemberList() {
        return memberList;
    }

    public ArrayList<Competitor> getCompetitors() {
        return competitors;
    }
    public void addNewCompetitor(String name, int age, String ageRange, String activeStatus, String competitiveStatus, String disciplines){
        Competitor competitor = new Competitor(name, age, ageRange, activeStatus, competitiveStatus, disciplines);
        competitors.add(competitor);
    }
}
