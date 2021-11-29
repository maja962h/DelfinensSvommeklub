package com.company.Member;
import com.company.data.Database;
import com.company.data.FileHandler;
import com.company.domain.Competitor;
import com.company.ui.UserInterface;

import java.util.Collections;


public class MemberController {

    UserInterface ui = new UserInterface();
    FileHandler fh = new FileHandler();
    Database dc = new Database();

    public void createMember() {
        ui.printMessage("Please enter the members full name: ");
        String name = ui.stringInput();

        ui.printMessage("Please enter the members age: ");
        int age = ui.intInput();
        String ageRange = ageRange(age);

        ui.printMessage("Is the member active(a) or passive(p)?");
        String input = ui.stringInput();

        Member member = new Member(name, age, ageRange);
        isActiveOrPassive(member, input);

        dc.addNewMember(member);
        fh.saveMember();
    }

    public void isActiveOrPassive(Member member, String input){
        switch (input){
            case "a":
                member.setActiveStatus("active");
                ui.printMessage("Is the member an exerciser(e) or competitor(c)?");
                String eOrc = ui.stringInput();
                isCompetitorOrExerciser(member, eOrc);
                break;
            case "p":
                member.setActiveStatus("passive");
                member.setCompetitiveStatus("none");
                break;
            default:
                ui.printMessage("try again");
                break;
        }
    }

    public void isCompetitorOrExerciser(Member member, String input){
        switch (input){
            case "c":
                member.setCompetitiveStatus("Competitor");
                chooseDisciplines(member);
                break;
            case "e":
                member.setCompetitiveStatus("Exerciser");
                break;
            default:
                ui.printMessage("try again");
                break;
        }
    }

    public void chooseDisciplines(Member member) {
        boolean keepAdding = true;
        String discipline = "";

        while (keepAdding) {
            //Print status for alle kategorier
            //TODO: how to not override disciplines? array???
            ui.disciplineMenu();
            int disciplineInput = ui.intInput();
            discipline = getDisciplines(disciplineInput);
            ui.printMessage("do you want to add another discipline? yes(y) or no(n)");
            String addAnotherDiscipline = ui.stringInput();
            keepAdding = continueAddingDisciplines(addAnotherDiscipline, discipline);
        }
        Competitor competitor = new Competitor(member.getName(), member.getAge(), member.getAgeRange(), member.getActiveStatus(), member.competitiveStatus, discipline);
        dc.addNewCompetitor(competitor);
        fh.saveCompetitor();
        //TODO: can only add one discipline, this needs to be fixed.
    }

    // You are able to view different member lists
    public void showMemberList() {
        ui.memberListMenu();
        int listInput = ui.intInput();

        switch (listInput) {
            case 1 -> fullMemberList();
            case 2 -> fullCompetitorList();
            case 3 -> juniorMemberList();
            case 4 -> seniorMemberList();
            default -> ui.printError();
        }
    }

    private String ageRange(int age) {
        String ageRange = "";
        if (age < 18) {
            ageRange = "Junior";
        } else if (age >= 18) {
            ageRange = "Senior";
        }
        return ageRange;
    }

    private void fullMemberList() {
        Collections.sort(dc.getMemberList());
        ui.printMessage(makeStringMember("data/members.txt"));
    }

    private void fullCompetitorList() {
        ui.printMessage(makeStringMember("data/competitors.txt"));
    }

    private void juniorMemberList() {
        Collections.sort(dc.getMemberList());

        for (Member member : dc.getMemberList()) {
            if (member.getAgeRange().equals("Junior")) {
                ui.printMessage(member.toString());
            }
        }
    }

    public void seniorMemberList() {
        Collections.sort(dc.getMemberList());

        for (Member member : dc.getMemberList()) {
            if (member.getAgeRange().equals("Senior")) {
                ui.printMessage(member.toString());
            }
        }
    }

    public String getDisciplines(int input) {
        String discipline = "";
        if (input == 1) {
            discipline = "Butterfly";
        } else if (input == 2) {
            discipline = "Crawl";
        } else if (input == 3) {
            discipline = "Back crawl";
        } else if (input == 4) {
            discipline = "Breaststroke";
        }
        return discipline;
    }

    public boolean continueAddingDisciplines(String input, String discipline) {
        if(input.equals("y")){
            return true;
        }else if(input.equals("n")){
            return false;
        }else
            return false;
    }

    public String makeStringMember(String file){

        //Initializing a StringBuilder object.
        StringBuilder stringBuilder = new StringBuilder();

        //Loops through the list of members.
        for (Member member : fh.readFile(file)) {

            stringBuilder.append(member.getName()).append(" ");

            stringBuilder.append(member.getAgeRange()).append(" ");

            stringBuilder.append(member.getActiveStatus()).append(" ");

            stringBuilder.append(member.getCompetitiveStatus()).append("\n");

        }
        return stringBuilder.toString();
    }


}
