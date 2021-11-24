package com.company.domain;
import com.company.data.FileHandler;
import com.company.ui.UserInterface;
import java.util.Collections;

public class Controller {

     private UserInterface ui = new UserInterface();
     private FileHandler fh = new FileHandler();
     private boolean running = true;


    public void start(){
        ui.printWelcomeMessage();
        while(running){
            ui.startMenu();
            int input = ui.intInput();

            switch (input) {
                case 1 -> createMember();
                case 2 -> showMemberList();
                case 3 -> checkDelinquentStatus(); //Check what members have not paid their fees.
                case 4 -> scoreBoard(); //Comp. swimmer's best results and dates.
                case 5 -> compSwimmingSchedule(); //place, time and registration for competitions.
                case 6 -> swimmerTierList(); //top 5 swimmers in every category.
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

    public void createMember() {
        String exerciserOrCompetitor = "";
        ui.printMessage("Please enter the members full name: ");
        ui.stringInput(); //avoid scanner bug
        String name = ui.stringInput();

        ui.printMessage("Please enter the members age: ");
        int age = ui.intInput();
        String ageRange = ageRange(age);
        ui.stringInput(); //avoid scanner bug

        ui.printMessage("Is the member active(a) or passive(p)?");
        String activeOrPassive = ui.stringInput();

        if(activeOrPassive.equals("p") || activeOrPassive.equals("passive")){
            activeOrPassive = "passive";
        }
        if(activeOrPassive.equals("a") || activeOrPassive.equals("active")){
            activeOrPassive = "active";
            ui.printMessage("Is the member an exerciser(e) or competitor(c)?");
            exerciserOrCompetitor = ui.stringInput();

            if(exerciserOrCompetitor.equals("e") || exerciserOrCompetitor.equals("exerciser")){
                exerciserOrCompetitor = "exerciser";

            } if (exerciserOrCompetitor.equals("c") || exerciserOrCompetitor.equals("competitor")){
                exerciserOrCompetitor = "Competitor";

                String disciplines = "";
                ui.disciplineMenu();
                int disciplineInput = ui.intInput();
                String discipline = getDisciplines(disciplineInput, disciplines);
                //TODO: should something even happen here?
                //TODO: the different disciplines maybe idk???
                fh.addNewCompetitor(name, age, ageRange, activeOrPassive, exerciserOrCompetitor, discipline);
                fh.saveCompetitor();
            }
        }
        fh.addNewMember(name, age, ageRange, activeOrPassive, exerciserOrCompetitor);
        fh.saveMember();
    }

    // You are able to view different member lists
    public void showMemberList() {
        ui.memberListMenu();
        int listInput = ui.intInput();

        switch (listInput) {
        case 1 -> fullMemberList();
        case 2 -> juniorMemberList();
        case 3 -> seniorMemberList();
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
    private String ageRange(int age){
        String ageRange = "";
        if(age < 18){
            ageRange = "Junior";
        }else if(age >= 18){
            ageRange = "Senior";
        }
        return ageRange;
    }

    private void fullMemberList(){
        Collections.sort(fh.getMemberList());

        // loops through ArrayList and prints info.
        for (Member member : fh.getMemberList()){
            ui.printMessage(member.toString());
        }
    }

    private void juniorMemberList(){
        Collections.sort(fh.getMemberList());

        for (Member member : fh.getMemberList()){
            if (member.getAgeRange().equals("Junior")){
                ui.printMessage(member.toString());
            }
        }
    }

    public void seniorMemberList(){
        Collections.sort(fh.getMemberList());

        for (Member member : fh.getMemberList()){
            if (member.getAgeRange().equals("Senior")){
                ui.printMessage(member.toString());
            }
        }
    }

    public String getDisciplines(int input, String discipline){
        if (input == 1){
            discipline = "Butterfly";
        } else if (input == 2){
            discipline = "Freestyle";
        } else if (input == 3){
            discipline = "Backstroke";
        } else if (input == 4){
            discipline = "Breaststroke";
        }
        return discipline;
    }


}
