package com.feroliapps.models;

public class CarAbstract implements CarInterface {

    public void open() {
        System.out.println("Open");
    }

    public void close() {
        System.out.println("Close");
    }

}
