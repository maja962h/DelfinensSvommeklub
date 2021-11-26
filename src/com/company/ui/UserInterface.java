package com.company.ui;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);

    public void printWelcomeMessage(){
        //TODO: find dolphin code drawing thingy XD
        // TODO: Add source
        printMessage("""
                 __      __         .__                                         __                __   .__                 ________           .__           .__         \s
                /  \\    /  \\  ____  |  |    ____   ____    _____    ____      _/  |_  ____      _/  |_ |  |__    ____      \\______ \\    ____  |  |  ______  |__|  ____  \s
                \\   \\/\\/   /_/ __ \\ |  |  _/ ___\\ /  _ \\  /     \\ _/ __ \\     \\   __\\/  _ \\     \\   __\\|  |  \\ _/ __ \\      |    |  \\  /  _ \\ |  |  \\____ \\ |  | /    \\ \s
                 \\        / \\  ___/ |  |__\\  \\___(  <_> )|  Y Y  \\\\  ___/      |  | (  <_> )     |  |  |   Y  \\\\  ___/      |    `   \\(  <_> )|  |__|  |_> >|  ||   |  \\\s
                  \\__/\\  /   \\___  >|____/ \\___  >\\____/ |__|_|  / \\___  >     |__|  \\____/      |__|  |___|  / \\___  >    /_______  / \\____/ |____/|   __/ |__||___|  /\s
                       \\/        \\/            \\/              \\/      \\/                                   \\/      \\/             \\/               |__|             \\/ \s
                """);
    }

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

    public void memberListMenu(){
        printMessage("""
                Which list would you like to view?
                (1) Full member list.
                (2) Full competitor list.
                (3) Junior member list.
                (4) Senior memberList.
                """);
    }

    public void disciplineMenu(){
        printMessage("""
                Choose which disciplines you want:
                (1) Butterfly.
                (2) Crawl.
                (3) Back crawl.
                (4) Breaststroke.
                """);
    }

    public void printMessage(String message){
        System.out.println(message);
    }

    public void printError(){
        System.out.println("The input was invalid, please try again.");
    }

    public String stringInput(){
        return scanner.nextLine();
    }

    public int intInput(){
        int input = scanner.nextInt();
        scanner.nextLine(); //Scanner bug fix
        return input;
    }

    public void printArray(List list){
        System.out.println(list);
    }

}
