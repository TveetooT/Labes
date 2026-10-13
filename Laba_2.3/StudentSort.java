import java.util.List;
import java.util.ArrayList;

public class StudentSort implements Sorting<Student> {
    @Override
    public void sort(List<Student> students) {
        if (students.isEmpty()) {
            return;
        }
        for (int i = 1; i < students.size(); i++) {
            Student stud = students.get(i);
            for (int j = i - 1; ; j--) {
                if (j == -1) {
                    students.remove(i);
                    students.add(0, stud);
                    break;
                }
                if (students.get(j).getAge() < stud.getAge()) {
                    students.remove(i);
                    students.add(j + 1, stud);
                    break;
                }
            }
        }
        for (int i = 1; i < students.size(); i++) {
            Student stud = students.get(i);
            for (int j = students.size(); ; j--) {
                if (j == -1) {
                    students.remove(i);
                    students.add(0, stud);
                    break;
                }
                if (isNameBetter(students.get(j).getName(), stud.getName())) {
                    students.remove(i);
                    students.add(j+1, stud);
                    break;
                }
            }
        }
        for (int i = 0; i < students.size(); i++) {
            students.set(i, students.get(i));
        }
    }
    boolean isNameBetter(String first, String second) {
        for (int i = 0; i < Math.min(first.length(), second.length()); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                if ((int) first.charAt(i) < (int) second.charAt(i)) {
                    return true;
                }
                return false;
            }
        }
        if (first.length() <= second.length()) {
            return true;
        }
        return false;
    }
}

