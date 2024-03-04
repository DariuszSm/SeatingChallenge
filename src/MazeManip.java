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
            // seat 5 specific assignment
            int exchangeSeat = 5;
            if (row == 0) {
                int emptyInd = findEmptySeatInd(currentRow);
                Student moveStud = currentRow.get(exchangeSeat-1);
                moveStud.setNewSeat(emptyInd+1);
                currentRow.set(exchangeSeat-1, currentRow.remove(emptyInd));
                currentRow.get(exchangeSeat-1).setNewSeat(exchangeSeat);
                currentRow.add(emptyInd+1, currentRow.remove(emptyInd));
            }

            // swap first and last seat of each row
            Student swapStudent = currentRow.get(0);
            int swapSeat = swapStudent.getNewSeat();
            currentRow.set(0, currentRow.remove(currentRow.size()-1));

            // seat # assignment
            swapStudent.setNewSeat(currentRow.get(0).getNewSeat());
            currentRow.get(0).setNewSeat(swapSeat);

            currentRow.add(swapStudent);
        }

        return seating;
    }
}
