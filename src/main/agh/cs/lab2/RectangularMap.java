package agh.cs.lab2;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap {
    private int width;
    private int height;
    private MapVisualizer visualizer;
    private ArrayList<Car> carList = new ArrayList<>();

    public RectangularMap(int width, int height) {
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
    public boolean place(Car car) {
        carList.add(car);
        return true;
    }

    @Override
    public void run(ArrayList<MoveDirection> directions) {
        for(int i = 0; i < directions.size(); i++) {
            carList.get(i%carList.size()).move(directions.get(i));
        }
    }

    @Override
    public boolean isOccupied(Position position) {
        if(objectAt(position) == null)
            return true;
        else
            return false;
    }

    @Override
    public Object objectAt(Position position) {
        for(Car car : carList) {
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