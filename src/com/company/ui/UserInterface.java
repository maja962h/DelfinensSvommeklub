package com.company.ui;
import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);

    //TODO: make start menu.
    public void startMenu(){
        printMessage("""
                Type (1) to create a member.
                Type (2) to get the list of members.
                Type (3) to check which members haven't paid their fees.
                Type (4) to see the swimmer's best results and dates.
                Type (5) to register an event, time and location for the swimmers that have participated.
                Type (6) to see the top 5 swimmers in each category.
                Type (0) to exit the program.
                """);
    }


    public void printMessage(String message){
        System.out.println(message);
    }

    public void printWelcomeMessage(){
        //TODO: find dolphin code drawing thingy XD
        printMessage("""
                Welcome to the Dolphin!
                """);
    }

    // TODO: formulate versatile error message.
    public void printError(){
        System.out.println();
    }


    public String stringInput(){
        return scanner.next();
    }

    public int intInput(){
        return scanner.nextInt();
    }

}
