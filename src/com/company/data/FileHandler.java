package com.company.data;

import com.company.domain.Member;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class FileHandler {

    public void saveUser(Member member){
        File file = new File("data/members.txt");
        PrintStream ps = null;
        try{
            ps = new PrintStream(new FileOutputStream(file, true));
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        ps.println(member.toString());
    }


}
