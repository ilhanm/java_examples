package com.aopdemo.ooptests_UnrelatedWithProject;

public class DemoTestApp {
    static void fun() throws IllegalAccessException
    {
        System.out.println("Inside fun(). ");
        throw new IllegalAccessException("demo");
    }

    public static void main(String[] args)  {
        System.out.println("Hello Geeks");
        String[] myarr = new String[3];
        myarr[0] = "ilhan";
        myarr[1] = "mert";
        myarr[2] = "alan";

        String[] myotherarr;
        myotherarr = myarr.clone();
        myotherarr[1] = "murat";

        for(int i=0;i<myarr.length;i++){
            System.out.println(myarr[i]);
        }
        try{
            fun();
        }catch (IllegalAccessException exception){
            System.out.println("caught");
        }
    }
}
