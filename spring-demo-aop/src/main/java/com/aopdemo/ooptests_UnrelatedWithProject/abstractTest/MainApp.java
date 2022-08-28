package com.aopdemo.ooptests_UnrelatedWithProject.abstractTest;

public class MainApp {
    public static void main(String[] args){
        GraphicObject myCircle = new Circle();
        myCircle.x=5;
        myCircle.y=10;
        myCircle.draw();
        Circle myCircleObj = new Circle();
        myCircleObj.x=10;
        myCircleObj.y=20;
        myCircleObj.setRadius(3);
        myCircleObj.draw();
    }
}
