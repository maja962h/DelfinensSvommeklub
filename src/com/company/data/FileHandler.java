package com.company.data;
import com.company.domain.Member;

import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    private ArrayList<Member> memberList = new ArrayList<>();
    private ArrayList<Member> competitors = new ArrayList<>();


    public void addNewMember(String name, int age, String ageRange, String activeStatus, String competitiveStatus){
        Member member = new Member(name, age, ageRange, activeStatus, competitiveStatus);
        memberList.add(member);
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
    public ArrayList<Member> getMemberList() {
        return memberList;
    }

    public ArrayList<Member> getCompetitors() {
        return competitors;
    }
    public void addNewCompetitor(String name, int age, String ageRange, String activeStatus, String competitiveStatus, String disciplines){
        Member member = new Member(name, age, ageRange, activeStatus, competitiveStatus, disciplines);
        competitors.add(member);
    }
}
