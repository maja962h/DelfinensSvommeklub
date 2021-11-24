package com.company.data;
import com.company.domain.Member;

import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    private ArrayList<Member> memberList = new ArrayList<>();


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

    public ArrayList<Member> getMemberList() {
        return memberList;
    }
}
