package org.example;

public interface Grid {
    void seed(double seedPercentage);
    void update();
    void print();
    boolean isAllDead();
    int getRows();
    int getColumns();
    Cell getCellAt(int row, int col);
}
