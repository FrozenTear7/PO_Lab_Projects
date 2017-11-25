package agh.cs.lab2;

import java.util.ArrayList;
import java.util.HashMap;

public class UnboundedMap extends AbstractWorldMap {
    private MapVisualizer visualizer = new MapVisualizer();
    private HashMap<Position, HayStack> hayStackMap;
    private Position downLeftCorner, upRightCorner;

    public UnboundedMap (HashMap<Position, HayStack> newHayStackMap) {
        super();
        this.hayStackMap = newHayStackMap;
    }

    @Override
    public boolean canMoveTo(Position position) {
        if(!isOccupied(position))
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

        for(HashMap.Entry<Position, HayStack> entry : hayStackMap.entrySet()) {
            HayStack hayStack = entry.getValue();

            if(hayStack.getPosition().equals(position))
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

        for(HashMap.Entry<Position, HayStack> entry : hayStackMap.entrySet()) {
            HayStack hayStack = entry.getValue();

            if(hayStack.getPosition().equals(position))
                return hayStack;
        }

        return null;
    }

    private void setCorners() {
        int maxUp = Integer.MIN_VALUE, maxDown = Integer.MAX_VALUE, maxLeft = Integer.MAX_VALUE, maxRight = Integer.MIN_VALUE;

        for(HashMap.Entry<Position, Car> entry : carMap.entrySet()) {
            Car car = entry.getValue();

            if(car.getPosition().x > maxRight)
                maxRight = car.getPosition().x;
            if(car.getPosition().x < maxLeft)
                maxUp = car.getPosition().x;
            if(car.getPosition().y > maxUp)
                maxUp = car.getPosition().y;
            if(car.getPosition().y < maxDown)
                maxDown = car.getPosition().y;
        }

        for(HashMap.Entry<Position, HayStack> entry : hayStackMap.entrySet()) {
            HayStack hayStack = entry.getValue();

            if(hayStack.getPosition().x > maxRight)
                maxRight = hayStack.getPosition().x;
            if(hayStack.getPosition().x < maxLeft)
                maxLeft = hayStack.getPosition().x;
            if(hayStack.getPosition().y > maxUp)
                maxUp = hayStack.getPosition().y;
            if(hayStack.getPosition().y < maxDown)
                maxDown = hayStack.getPosition().y;
        }

        downLeftCorner = new Position(maxLeft, maxDown);
        upRightCorner = new Position(maxRight, maxUp);
    }

    @Override
    public String toString() {
        setCorners();
        return visualizer.dump(this, downLeftCorner, upRightCorner);
    }
}
