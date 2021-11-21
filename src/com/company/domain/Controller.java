package com.company.domain;


import com.company.ui.UserInterface;

public class Controller {

     private UserInterface ui = new UserInterface();
     private boolean running = true;

    public void start(){
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

    public void createMember() {
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
