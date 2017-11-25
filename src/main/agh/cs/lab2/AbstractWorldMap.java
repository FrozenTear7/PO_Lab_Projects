package agh.cs.lab2;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class AbstractWorldMap implements IPositionChangeObserver, IWorldMap {
    protected HashMap<Position, Car> carMap = new HashMap<>();
    protected ArrayList<Car> carList = new ArrayList<>();

    public void run(ArrayList<MoveDirection> directions) {
        for(int i = 0; i < directions.size(); i++) {
            carList.get(i%carList.size()).move(directions.get(i));
            System.out.println(carList.get(i%carList.size()));
        }
    }

    public boolean place(Car newCar) {
        for(HashMap.Entry<Position, Car> entry : carMap.entrySet()) {
            Car car = entry.getValue();

            if(car.getPosition().equals(newCar.getPosition()))
                throw new IllegalArgumentException(newCar.getPosition() + " is not legal car position");
        }

        carMap.put(newCar.getPosition(), newCar);
        carList.add(newCar);
        newCar.addObserver(this);
        return true;
    }

    @Override
    public void positionChanged(Position oldPosition, Position newPosition) {
        Car tempCar = carMap.get(oldPosition);
        carMap.remove(oldPosition);
        carMap.put(newPosition, tempCar);
    }
}
