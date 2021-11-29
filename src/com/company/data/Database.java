package com.company.data;
import com.company.Member.Member;
import com.company.domain.Competitor;
import com.company.domain.User;

import java.util.ArrayList;

public class Database {

    private ArrayList<Member> memberList = new ArrayList<>();
    private ArrayList<Competitor> competitors = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();

    public void addNewMember(Member member){
        memberList.add(member);
    }

    public ArrayList<Member> getMemberList() {
        return memberList;
    }

    public ArrayList<Competitor> getCompetitors() {
        return competitors;
    }


    public void addNewCompetitor(Competitor competitor){
        competitors.add(competitor);
    }


    public User findUser(String name, String password) {
        for (User user: users) {
            if(user.getName().equals(name) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }


}
