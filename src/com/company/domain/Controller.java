package com.company.domain;


import com.company.data.Database;
import com.company.data.FileHandler;
import com.company.ui.UserInterface;

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
            }

        }


    }

    private void exit() {
        running = false;
    }

    //TODO: find out where methods should be placed (not all belong in controller)

    //TODO: does not save name to file!
    public void createMember() {
        String exerciserOrCompetitor = "";
        String name;
        ui.printMessage("Please enter the members full name: ");
        ui.stringInput(); //TODO BUG FIX PLZ
        name = ui.stringInput();

        ui.printMessage("Please enter the members age: ");
        String age = ui.stringInput();

        ui.printMessage("Is the member active or passive?");
        String activeOrPassive = ui.stringInput();
        if(activeOrPassive.equals("active")){
            ui.printMessage("Is the member an exerciser or competitor?");
            exerciserOrCompetitor = ui.stringInput();
            if(exerciserOrCompetitor.equals("competitor")){
                //TODO: should something even happen here?
                //TODO: the different disciplines maybe idk???
            }
        }
        Member member = new Member(name, age, activeOrPassive, exerciserOrCompetitor);
        fh.saveUser(member);
    }

    public void showMemberList() {
    }

    public void checkDelinquentStatus() {
    }

    public void scoreBoard() {
    }

    public void compSwimmingSchedule() {
    }

    public void swimmerTierList() {
    }



}
