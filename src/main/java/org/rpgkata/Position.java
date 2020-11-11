package org.rpgkata;

public class Position {
    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getDistance(Position point) {
        int xDiff = Math.abs(this.x - point.getX());
        xDiff = xDiff * xDiff;
        int yDiff = Math.abs(this.y - point.getY());
        yDiff = yDiff * yDiff;
        return (int) Math.sqrt(xDiff + yDiff);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


}
