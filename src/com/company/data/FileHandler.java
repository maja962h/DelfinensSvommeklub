package com.company.data;
import com.company.domain.Competitor;
import com.company.Member.Member;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler{

    private ArrayList<Member> memberList = new ArrayList<>();
    private ArrayList<Competitor> competitors = new ArrayList<>();


    public ArrayList<Member> getMemberList() {
        return memberList;
    }

    public void saveMember(){
        File file = new File("data/members.txt");

        try{
            FileWriter fileWriter = new FileWriter(file, true);

            for(Member member : memberList){
                fileWriter.append(member.getName() + ";");
                fileWriter.append(member.getAgeRange() + ";");
                fileWriter.append(member.getActiveStatus() + ";");
                fileWriter.append(member.getCompetitiveStatus());
                fileWriter.append("\n");
            }
            fileWriter.close();
            memberList.clear();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void saveCompetitor(){
        File file = new File("data/competitors.txt");

        try{
            FileWriter fileWriter = new FileWriter(file, true);

            for(Competitor competitor : competitors){
                fileWriter.append(competitor.getName() + ";");
                fileWriter.append(competitor.getAgeRange() + ";");
                fileWriter.append(competitor.getActiveStatus() + ";");
                fileWriter.append(competitor.getDiscipline());
                fileWriter.append("\n");
            }
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Member> readFile(){
        File myObj = new File("data/members.txt");
        try {
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] test = data.split(";");
                Member member = new Member(test[0], test[1], test[2], test[3]);
                memberList.add(member);
            }
            return memberList;

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return null;
    }

    public boolean authenticated(String name, String password, String role){
        boolean isAuthenticated = false;

        File file = new File("data/users.txt");

        try{
            Scanner myReader = new Scanner(file);

            while(myReader.hasNextLine()){
                String line = myReader.nextLine();
                String[] values = line.split(";");

                if(values[0].equals(name) && values[1].equals(password) && values[2].equals(role)){
                    isAuthenticated = true;
                }
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        return isAuthenticated;
    }

    // Turns arraylist into string, so it can be printed to console.



}
