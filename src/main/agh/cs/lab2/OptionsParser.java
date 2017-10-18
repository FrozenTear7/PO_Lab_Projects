package agh.cs.lab2;

import java.util.ArrayList;

public class OptionsParser {
    public static ArrayList<MoveDirection> parse (String R[]) {
        ArrayList<MoveDirection> R_List = new ArrayList<>();
        for(int i = 0; i < R.length; i++) {
            switch (R[i]) {
                case "f":
                    R_List.add(MoveDirection.Forward);
                    break;
                case "forward":
                    R_List.add(MoveDirection.Forward);
                    break;
                case "b":
                    R_List.add(MoveDirection.Backwards);
                    break;
                case "backwards":
                    R_List.add(MoveDirection.Backwards);
                    break;
                case "l":
                    R_List.add(MoveDirection.Left);
                    break;
                case "left":
                    R_List.add(MoveDirection.Left);
                    break;
                case "r":
                    R_List.add(MoveDirection.Right);
                    break;
                case "right":
                    R_List.add(MoveDirection.Right);
                    break;
                default:
                    return null;
            }
        }

        return R_List;
    }
}
