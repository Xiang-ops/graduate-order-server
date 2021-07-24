package com.xx.order.service;

import com.xx.order.mapper.TestMapper;
import com.xx.order.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private TestMapper testMapper;

    public int verifyPassword(String username, String password) {
        return testMapper.verifyPassword(username,password);
    }
    public List<User> allUser(){
        return testMapper.allUser();
    }



}
