package com.company.ui;
import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);

    //TODO: make start menu.
    public void startMenu(){
        System.out.println("""
                """);
    }


    public void printMessage(String message){
        System.out.println(message);
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
