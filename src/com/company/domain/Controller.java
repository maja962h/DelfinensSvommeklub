package com.company.domain;


import com.company.ui.UserInterface;

public class Controller {

    UserInterface ui = new UserInterface();

    public void Start(){
        boolean running = true;

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
            }

        }


    }

    //TODO: find out where methods should be placed (not all belong in controller)

    private void createMember() {
    }

    private void showMemberList() {
    }

    private void checkDelinquentStatus() {
    }

    private void scoreBoard() {
    }

    private void compSwimmingSchedule() {
    }

    private void swimmerTierList() {
    }



}
