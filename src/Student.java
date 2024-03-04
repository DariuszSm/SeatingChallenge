import java.util.ArrayList;
import java.util.HashMap;

public class Student {
    private String name;
    private ArrayList<Student> previousNeighbors;
    private int origSeat;
    private int newSeat;
    private boolean empty;

    public Student(String name, int origSeat) {
        this.name = name;
        this.origSeat = origSeat;
    }

    public ArrayList<Student> getNeighbors(HashMap<Integer, Student> students) {
        ArrayList<Student> seatNeighbors = new ArrayList<Student>();
        if (students.get(origSeat-1) != null && (!students.get(origSeat-1).getName().equals("N/A"))) {
            seatNeighbors.add(students.get(origSeat-1));
        }
        if (students.get(origSeat+1) != null && (!students.get(origSeat+1).getName().equals("N/A"))) {
            seatNeighbors.add(students.get(origSeat+1));
        }
        return seatNeighbors;
    }

    public void setNewSeat(int newSeat) {
        this.newSeat = newSeat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Student> getPreviousNeighbors() {
        return previousNeighbors;
    }

    public void setPreviousNeighbors(ArrayList<Student> previousNeighbors) {
        this.previousNeighbors = previousNeighbors;
    }

    public int getOrigSeat() {
        return origSeat;
    }

    public void setOrigSeat(int origSeat) {
        this.origSeat = origSeat;
    }

    public int getNewSeat() {
        return newSeat;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public String toString() {
        String assemble = "";

        assemble += "Student: " + name + ", Original Num: " + origSeat + ", New Num: " + newSeat;

        return assemble;
    }
}
