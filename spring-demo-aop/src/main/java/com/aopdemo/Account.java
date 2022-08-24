package com.aopdemo;

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
        return name;
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
}
