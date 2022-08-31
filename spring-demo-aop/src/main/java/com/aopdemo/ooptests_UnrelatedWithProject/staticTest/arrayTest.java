package com.aopdemo.ooptests_UnrelatedWithProject.staticTest;

import java.util.ArrayList;
import java.util.List;

public class arrayTest {
    public static void main(String[] args){
        String[] myArr = new String[5];
        myArr[0]="deneme";
        myArr[1]="ilhan";
        System.out.println(myArr);
        List<String> myList = new ArrayList<String>();
        myList.add("ilhan");
        myList.add("mert");
        myList.add(Integer.toString(1));
        System.out.println(myList);
        Integer myInt = Integer.parseInt(myList.get(2));
        Integer myOtherInt = 1;
        System.out.println(myInt);
        System.out.println(myList.get(2));
        System.out.println(myInt == myOtherInt);
        System.out.println(myInt.equals(myOtherInt));
        System.out.println("---------------------------------------");
        //test2
        Integer int1 = new Integer(1);
        System.out.println(myInt == int1);
        System.out.println(myInt.equals(int1));
    }
}
