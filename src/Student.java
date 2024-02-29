import java.util.ArrayList;

public class Student {
    private String name;
    private ArrayList<Student> neighbors;
    private int origSeat;
    private int newSeat;

    public Student(String name, int origSeat) {
        this.name = name;
        this.origSeat = origSeat;
    }

    public ArrayList<Student> getNeighbors(ArrayList<ArrayList<Student>> seating) {
        ArrayList<Student> seatNeighbors = new ArrayList<Student>();
        for (int r = 0; r < seating.size(); r++) {
            for (int c = 0; c < seating.get(r).size(); c++) {

            }
        }
    }
}
