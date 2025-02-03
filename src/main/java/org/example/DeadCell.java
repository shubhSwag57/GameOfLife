package org.example;

public class DeadCell implements  Cell{
    @Override
    public  boolean isAlive(){
        return false;
    }
}
