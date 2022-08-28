package com.aopdemo.ooptests_UnrelatedWithProject.abstractTest;

public class Circle extends GraphicObject {

    private double radius;

    @Override
    void draw() {
        System.out.println("Drawing " + getClass().getSimpleName() +
                " which is located on (x,y): " + x + "," +y +
                " and radius is " +getRadius());
    }
    @Override
    void resize() {
        System.out.println("Resizing "+ getClass().getSimpleName());
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
