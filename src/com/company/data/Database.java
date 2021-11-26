package com.company.data;

import com.company.domain.User;

public interface Database {

    public User findUser(String name, String password);

}
