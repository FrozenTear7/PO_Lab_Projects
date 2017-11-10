package agh.cs.lab2;

import java.util.ArrayList;

public abstract class AbstractWorldMap {
    protected ArrayList<Car> carList = new ArrayList<>();

    public void run(ArrayList<MoveDirection> directions) {
        for(int i = 0; i < directions.size(); i++) {
            carList.get(i%carList.size()).move(directions.get(i));
            System.out.println(carList.get(i%carList.size()));
        }
    }

    public boolean place(Car car) {
        carList.add(car);
        return true;
    }
}
