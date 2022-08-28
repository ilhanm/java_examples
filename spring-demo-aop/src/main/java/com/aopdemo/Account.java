package com.aopdemo;

import org.springframework.stereotype.Component;

@Component
public class Account {
    private String name="ilhan";
    private String level;

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getLevel(){
        return level;
    }

    public void setLevel(String level){
        this.level = level;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", level='" + level + '\'' +
                '}';
    }

    public void accountInfo(){
        System.out.println("This is an account object of "+ getName() +" which is level of " + getLevel());
    }

}
