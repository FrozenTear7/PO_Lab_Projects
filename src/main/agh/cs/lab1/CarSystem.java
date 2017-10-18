package agh.cs.lab1;

public class CarSystem {
    private static void run (Direction args[]) {
        for(int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case Forward:
                    System.out.println("Samochod jedzie do przodu");
                    break;
                case Backwards:
                    System.out.println("Samochod jedzie do tylu");
                    break;
                case Right:
                    System.out.println("Samochod skreca w prawo");
                    break;
                case Left:
                    System.out.println("Samochod skreca w lewo");
                    break;
                default:
                    System.out.println("Samochod wybucha czaisz");
            }
        }
    }

    private static Direction[] convert(String args[]) {
        Direction dirArgs[] = new Direction[args.length];
        for(int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "f":
                    dirArgs[i] = Direction.Forward;
                    break;
                case "b":
                    dirArgs[i] = Direction.Backwards;
                    break;
                case "r":
                    dirArgs[i] = Direction.Left;
                    break;
                case "l":
                    dirArgs[i] = Direction.Right;
                    break;
                default:
                    break;
            }
        }

        return dirArgs;
    }

    public static void main(String args[]) {
        System.out.println("Samochody startuja");
        run(convert(args));
        System.out.println("Samochody juz nie");
    }
}
