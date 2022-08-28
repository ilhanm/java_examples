package com.aopdemo.ooptests_UnrelatedWithProject.abstractTest;

public abstract class GraphicObject {
    int x,y;
    void moveTo(int newX, int newY){
        System.out.println("moving on X:"+newX +" and Y:"+newY);
    }
    abstract void draw();
    abstract void resize();
}
