package agh.cs.lab2;

public class Car {
    private MapDirection orientation;
    private Position currentPosition;
    public Car() {
        this.orientation = MapDirection.North;
        this.currentPosition = new Position(2, 2);
    }

    public String toString() {
        return "Position: " + currentPosition + ", direction: " + orientation;
    }

    public void move(MoveDirection direction) {
        switch(direction) {
            case Left:
                orientation = orientation.previous();
                return;
            case Right:
                orientation = orientation.next();
                return;
            case Forward:
                switch (orientation) {
                    case North:
                        if(currentPosition.add(new Position(0, 1)).y <= 4)
                            currentPosition = currentPosition.add(new Position(0, 1));
                            return;
                    case South:
                        if(currentPosition.add(new Position(0, -1)).y >= 0)
                            currentPosition = currentPosition.add(new Position(0, -1));
                            return;
                    case East:
                        if(currentPosition.add(new Position(1, 0)).x <= 4)
                            currentPosition = currentPosition.add(new Position(1, 0));
                            return;
                    case West:
                        if(currentPosition.add(new Position(-1, 0)).y >= 0)
                            currentPosition = currentPosition.add(new Position(-1, 0));
                            return;
                }
            case Backwards:
                switch (orientation) {
                    case North:
                        if(currentPosition.add(new Position(0, -1)).y >= 0)
                            currentPosition = currentPosition.add(new Position(0, -1));
                            return;
                    case South:
                        if(currentPosition.add(new Position(0, 1)).y <= 4)
                            currentPosition = currentPosition.add(new Position(0, 1));
                            return;
                    case East:
                        if(currentPosition.add(new Position(-1, 0)).x >= 0)
                            currentPosition = currentPosition.add(new Position(-1, 0));
                            return;
                    case West:
                        if(currentPosition.add(new Position(1, 0)).y <= 4)
                            currentPosition = currentPosition.add(new Position(1, 0));
                            return;
                }
        }
    }
}
