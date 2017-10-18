package agh.cs.lab2;

public class Position {
    public final int x, y;

    public Position (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString () {
        return "(" + this.x + ", " + this.y + ")";
    }

    public boolean smaller (Position position) {
        return (position.x >= this.x && position.y >= this.y);
    }

    public boolean larger (Position position) {
        return (position.x <= this.x && position.y <= this.y);
    }

    public Position add (Position position) {
        return new Position(this.x+position.x, this.y+position.y);
    }

    public boolean equals (Position position) {
        return (position.x == this.x && position.y == this.y);
    }
}
