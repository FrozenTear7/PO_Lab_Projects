package agh.cs.lab2;

public class Car {
    private MapDirection orientation;
    private Position currentPosition;
    private IWorldMap map;

    private Car() {
    }

    public Car(IWorldMap map) {
        this.map = map;
        this.currentPosition = new Position(2, 2);
        this.orientation = MapDirection.North;
    }

    public Car(IWorldMap map, int x, int y) {
        this.map = map;
        this.currentPosition = new Position(x, y);
        this.orientation = MapDirection.North;
    }

    public Position getPosition() {
        return currentPosition;
    }

    public String toString() {
        switch (orientation) {
            case North:
                return "N";
            case South:
                return "S";
            case West:
                return "W";
            case East:
                return "E";
            default:
                return "brak tu typie";
        }
    }

    public void move(MoveDirection direction) {
        Position newPosition;

        switch (direction) {
            case Left:
                orientation = orientation.previous();
                return;
            case Right:
                orientation = orientation.next();
                return;
            case Forward:
                switch (orientation) {
                    case North:
                        newPosition = new Position(0, 1);
                        break;
                    case South:
                        newPosition = new Position(0, -1);
                        break;
                    case East:
                        newPosition = new Position(1, 0);
                        break;
                    case West:
                        newPosition = new Position(-1, 0);
                        break;
                    default:
                        newPosition = new Position(0, 0);
                }
                if (map.canMoveTo(currentPosition.add(newPosition)))
                    currentPosition = currentPosition.add(newPosition);
                break;
            case Backwards:
                switch (orientation) {
                    case North:
                        newPosition = new Position(0, -1);
                        break;
                    case South:
                        newPosition = new Position(0, 1);
                        break;
                    case East:
                        newPosition = new Position(-1, 0);
                        break;
                    case West:
                        newPosition = new Position(1, 0);
                        break;
                    default:
                        newPosition = new Position(0, 0);
                }
                if (map.canMoveTo(currentPosition.add(newPosition)))
                    currentPosition = currentPosition.add(newPosition);
                break;
        }
    }
}