package com.company.domain;
import com.company.data.FileHandler;
import com.company.ui.UserInterface;
import java.util.Collections;

public class Controller {

    private UserInterface ui = new UserInterface();
    private FileHandler fh = new FileHandler();
    private boolean running = true;

    public void start() {

        ui.printWelcomeMessage();
        while (running) {
            ui.startMenu();
            int input = ui.intInput();

            switch (input) {
                case 1 -> logIn();
                case 2 -> createMember();
                case 3 ->showMemberList();
                case 4 -> checkDelinquentStatus(); //Check what members have not paid their fees.
                case 5 -> scoreBoard(); //Comp. swimmer's best results and dates.
                case 6 -> compSwimmingSchedule(); //place, time and registration for competitions.
                case 7 -> swimmerTierList(); //top 5 swimmers in every category.
                case 0 -> exit();
                default -> ui.printError();
            }
        }
    }

    // ************
    //
    // DIRECT METHODS.
    //
    // ************

    //TODO: find out where methods should be placed (not all belong in controller)

    public void logIn() {
        ui.printMessage("Are you logging in as the admin, cashier or trainer?");
        String role = ui.stringInput();
        ui.printMessage("Type in user name: ");
        String name = ui.stringInput();
        ui.printMessage("Type in password: ");
        String password = ui.stringInput();

        boolean user = fh.authenticated(name, password, role);
        if(user){
            ui.printMessage("Welcome " + role + " " + name);
        } else {
            ui.printMessage("User not found");
        }
    }

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

        fh.addNewMember(member);
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
        fh.addNewCompetitor(competitor);
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

    public void checkDelinquentStatus() {
    }

    public void scoreBoard() {
    }

    public void compSwimmingSchedule() {
    }

    public void swimmerTierList() {
    }

    public void exit() {
        running = false;
    }

    // ************
    //
    // METHODS IN METHODS.
    //
    // ************


    //TODO: move to member class???
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
        Collections.sort(fh.getMemberList());

        /*// loops through ArrayList and prints info.
        for (Member member : fh.getMemberList()){
            ui.printMessage(member.toString());
        }*/
        ui.printMessage(fh.makeStringMember("data/members.txt"));
    }

    private void fullCompetitorList() {

        ui.printMessage(fh.makeStringMember("data/competitors.txt"));
    }

    private void juniorMemberList() {
        Collections.sort(fh.getMemberList());

        for (Member member : fh.getMemberList()) {
            if (member.getAgeRange().equals("Junior")) {
                ui.printMessage(member.toString());
            }
        }
    }

    public void seniorMemberList() {
        Collections.sort(fh.getMemberList());

        for (Member member : fh.getMemberList()) {
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
}
