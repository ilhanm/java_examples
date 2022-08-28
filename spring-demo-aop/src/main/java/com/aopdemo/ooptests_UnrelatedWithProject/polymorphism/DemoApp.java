package com.aopdemo.ooptests_UnrelatedWithProject.polymorphism;

public class DemoApp {
    public static void main(String[] args){
        Animal myDog = new Dog();
        myDog.animalSound();
        System.out.println("-end-");
    }
}
