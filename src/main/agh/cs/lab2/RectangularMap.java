package agh.cs.lab2;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap {
    private int width;
    private int height;
    private MapVisualizer visualizer;
    private List<Car> carList;

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
    public void run(MoveDirection[] directions) {

    }

    public void run2(ArrayList<MoveDirection> directions) {

    }

    @Override
    public boolean isOccupied(Position position) {
        if((Boolean) objectAt(position))
            return false;
        else
            return true;
    }

    @Override
    public Object objectAt(Position position) {
        for(Car car : carList) {
            if(car.getPosition().equals(position))
                return car;
        }
    }

    @Override
    public String toString() {
        return visualizer.dump(map, new Position(0, 0), new Position(width, height));
    }
}