import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("seating");
        Scanner s = new Scanner(inputFile);
        ArrayList<ArrayList<Student>> oldSeating = new ArrayList<ArrayList<Student>>();
        ArrayList<ArrayList<Student>> newSeating = new ArrayList<ArrayList<Student>>();

        HashMap<Integer, Student> students = new HashMap<Integer, Student>();

        while (s.hasNext()) {
            String line = s.nextLine();
            System.out.println(line);
            if (line.contains("—")) {
                oldSeating.add(new ArrayList<Student>());
            } else {
                int studentNum = Integer.parseInt(line.substring(0, line.indexOf(":")));
                String studentName = line.substring(line.indexOf(" ")+1);
                ArrayList<Student> row = oldSeating.get(oldSeating.size()-1);
                row.add(new Student(studentName, studentNum));
                students.put(studentNum, row.get(row.size()-1));
            }

        }

        for (ArrayList<Student> row : oldSeating) {
            for (Student stud : row) {
                System.out.println(stud);
                stud.getNeighbors(students);
            }
        }

        System.out.println("_________________");

        newSeating = MazeManip.getShuffledMaze(oldSeating);

        for (ArrayList<Student> row : newSeating) {
            for (Student stud : row) {
                System.out.println(stud);
                stud.getNeighbors(students);
            }
        }


    }
}