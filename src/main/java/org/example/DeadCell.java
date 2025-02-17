package org.example;

public class DeadCell implements ICell{
    @Override
    public ICell nextState(int aliveNeighbours) {
        if (aliveNeighbours == 3) {
            return new AliveCell();
        }
        return this;
    }
}
