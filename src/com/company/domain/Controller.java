package com.company.domain;
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

        ui.printMessage("Is the member active(a) or passive(p)?");
        ui.stringInput(); //avoid scanner bug
        String activeOrPassive = ui.stringInput();

        if(activeOrPassive.equals("p")){
            activeOrPassive = "passive";
        }
        if(activeOrPassive.equals("a")){
            activeOrPassive = "active";
            ui.printMessage("Is the member an exerciser(e) or competitor(c)?");
            exerciserOrCompetitor = ui.stringInput();

            if(exerciserOrCompetitor.equals("e")){
                exerciserOrCompetitor = "exerciser";

            } if (exerciserOrCompetitor.equals("c")){
                exerciserOrCompetitor = "Competitor";
                //TODO: make arraylist of competitors
                //TODO: should something even happen here?
                //TODO: the different disciplines maybe idk???
            }
        }
        Member member = new Member(name, age, ageRange, activeOrPassive, exerciserOrCompetitor);
        fh.saveUser(member);
        //TODO: add member to arraylist
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

    public void exit() {

        running = false;
    }

    // ************
    //
    // METHODS IN METHODS.
    //
    // ************


    //TODO: move to member class???
    public String ageRange(int age){
        String ageRange = "";
        if(age < 18){
            ageRange = "Junior";
        }else if(age >= 18){
            ageRange = "Senior";
        }
        return ageRange;
    }

}
