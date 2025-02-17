package org.example;

public class AliveCell implements ICell{
    @Override
    public ICell nextState(int aliveNeighbours) {
        if (aliveNeighbours < 2 || aliveNeighbours > 3) {
            return new DeadCell();
        }
        return this;
    }


}
