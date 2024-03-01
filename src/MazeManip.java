import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class MazeManip {

    public static int findEmptySeatInd(ArrayList<Student> row) {
        for (int i = 0; i < row.size(); i++) {
            if (row.get(i).getName().equals("N/A")) {
                return i;
            }
        }
        return -1;
    }

    public static ArrayList<ArrayList<Student>> getShuffledMaze(ArrayList<ArrayList<Student>> oldSeating) {
        ArrayList<ArrayList<Student>> seating = new ArrayList<ArrayList<Student>>();
        int currSeat = 1;
        for (int row = 0; row < oldSeating.size(); row++) {
            ArrayList<Student> studentRow = oldSeating.get(row);
            seating.add(new ArrayList<Student>());
            ArrayList<Student> currentRow = seating.get(seating.size()-1);
            for (int i = 0; i < 2; i++) {
                for (int stud = i; stud < studentRow.size(); stud += 2) {
                    currentRow.add(studentRow.get(stud));
                    currentRow.get(currentRow.size()-1).setNewSeat(currSeat);
                    currSeat++;
                }
            }
            if (row == 0) {
                currentRow.set(4, currentRow.remove(findEmptySeatInd(currentRow)));
            }
        }

        return seating;
    }
}
