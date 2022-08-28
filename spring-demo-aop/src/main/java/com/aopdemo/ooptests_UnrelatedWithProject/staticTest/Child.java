package com.aopdemo.ooptests_UnrelatedWithProject.staticTest;

public class Child extends Parent{
    public static void greeting(){
        System.out.println("hello from the Child");
    }

    public static void method1()
    {
        System.out.println("Method-1 of the Child class is executed.");
    }


    @Override
    public void overridable(){
        System.out.println("overridable from child");
    }

    public static void main(String[] args){
        Parent myHuman = new Child();
        Child.greeting();
        Child.method1();
        System.out.println("--------------");
        myHuman.greeting();
        myHuman.method1();
        myHuman.overridable();

    }
}
