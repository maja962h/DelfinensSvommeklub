package com.company.domain;
import com.company.Member.MemberController;
import com.company.data.FileHandler;
import com.company.ui.UserInterface;


public class Controller {

    private UserInterface ui = new UserInterface();
    private FileHandler fh = new FileHandler();
    private MemberController mc = new MemberController();
    private boolean running = true;

    public void start() {

        ui.printWelcomeMessage();
        while (running) {
            ui.startMenu();
            int input = ui.intInput();

            switch (input) {
                case 1 -> logIn();
                case 2 -> mc.createMember();
                case 3 -> mc.showMemberList();
                case 4 -> checkDelinquentStatus(); //Check what members have not paid their fees.
                case 5 -> scoreBoard(); //Comp. swimmer's best results and dates.
                case 6 -> compSwimmingSchedule(); //place, time and registration for competitions.
                case 7 -> swimmerTierList(); //top 5 swimmers in every category.
                case 0 -> exit();
                default -> ui.printError();
            }
        }
    }

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


}
