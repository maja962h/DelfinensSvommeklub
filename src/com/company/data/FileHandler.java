package com.company.data;
import com.company.domain.Member;

import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    private ArrayList<Member> memberList = new ArrayList<>();

    /*public void saveUser(Member member){
        File file = new File("data/members.txt");
        PrintStream ps = null;
        try{
            ps = new PrintStream(new FileOutputStream(file, true));
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        ps.println(member.toString());
    }*/

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
            // Clears ArrayList after writing to file, when an account is saved.
            //clearMemberCache();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void clearMemberCache(){
        memberList.clear();
    }

    public ArrayList<Member> getMemberList() {
        return memberList;
    }
}
