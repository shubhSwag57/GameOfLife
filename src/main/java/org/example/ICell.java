package org.example;

public interface ICell {
    ICell nextState(int aliveNeighbours);
}
