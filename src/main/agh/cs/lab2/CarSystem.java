package agh.cs.lab2;

import java.util.ArrayList;

public class CarSystem {
    public static void main (String args[]) {
        /*
        Position position1 = new Position(1,2);
        System.out.println(position1);
        Position position2 = new Position(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
        */
        /*
        Car car = new Car();
        List<MoveDirection> directionList = OptionsParser.parse(args);
        for(int i = 0; i < directionList.size(); i++) {
            car.move(directionList.get(i));
            System.out.println(car);
        }*/

        ArrayList<MoveDirection> directionList = OptionsParser.parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        map.place(new Car(map,3,4));
        map.run(directionList);
        System.out.println(map.toString());
    }
}
