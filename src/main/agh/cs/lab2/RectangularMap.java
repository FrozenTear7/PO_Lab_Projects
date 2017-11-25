package agh.cs.lab2;

import java.util.ArrayList;
import java.util.HashMap;

public class RectangularMap extends AbstractWorldMap {
    private int width;
    private int height;
    private MapVisualizer visualizer = new MapVisualizer();

    public RectangularMap(int width, int height) {
        super();
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean canMoveTo(Position position) {
        if(position.smaller(new Position(width, height)) && position.larger(new Position(0, 0)) && !isOccupied(position))
            return true;
        else
            return false;
    }

    @Override
    public boolean isOccupied(Position position) {
        for(HashMap.Entry<Position, Car> entry : carMap.entrySet()) {
            Car car = entry.getValue();

            if(car.getPosition().equals(position))
                return true;
        }

        return false;
    }

    @Override
    public Object objectAt(Position position) {
        for(HashMap.Entry<Position, Car> entry : carMap.entrySet()) {
            Car car = entry.getValue();

            if(car.getPosition().equals(position))
                return car;
        }
        return null;
    }

    @Override
    public String toString() {
        return visualizer.dump(this, new Position(0, 0), new Position(width, height));
    }
}