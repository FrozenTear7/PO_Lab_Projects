package agh.cs.lab2;

public class CarSystem {
    public static void main (String args[]) {
        /*
        Position position1 = new Position(1,2);
        System.out.println(position1);
        Position position2 = new Position(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
        */

        Car car = new Car();
        System.out.println(car);
        car.move(MoveDirection.Right);
        System.out.println(car);
        car.move(MoveDirection.Forward);
        System.out.println(car);
        car.move(MoveDirection.Forward);
        System.out.println(car);
        car.move(MoveDirection.Forward);
        System.out.println(car);
    }
}
