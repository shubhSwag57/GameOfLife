package org.example;

public class Cell {
    private boolean isAlive;
    public Cell(boolean isAlive){
        this.isAlive = isAlive;
    }
    // to create a dead cell by deafult

    public boolean isAlive(){
        return isAlive;
    }

    public void setAlive(boolean isAlive){
        this.isAlive = isAlive;
    }

    // cell to have

}
