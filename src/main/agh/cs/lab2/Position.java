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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (x != position.x) return false;
        return y == position.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    public boolean larger (Position position) {
        return (position.x <= this.x && position.y <= this.y);
    }

    public Position add (Position position) {
        return new Position(this.x+position.x, this.y+position.y);
    }

}
