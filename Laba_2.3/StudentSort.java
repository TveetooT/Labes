import java.util.List;
import java.util.ArrayList;

public class StudentSort implements Sorting<Student> {
    @Override
    public void sort(List<Student> students) {
        if (students.lenght() == 0) {
            return;
        }
        List<Student> first_sort = new ArrayList<>();
        first_sort.add(students.get(0));
        for (int i = 1; i < students.size(); i++) {
            Student stud = students.get(i);
            for (int j = first_sort.size() - 1; ; j--) {
                if (j == -1) {
                    first_sort.add(0, stud);
                    break;
                }
                if (first_sort.get(j).getAge() < stud.getAge()) {
                    first_sort.add(j + 1, stud);
                    break;
                }
            }
        }
        for (int i = 0; i < first_sort.size(); i++) {
            students.set(i, first_sort.get(i));
        }
        List<Student> second_sort = new ArrayList<>();
        second_sort.add(students.get(0));
        for (int i = 1; i < students.size(); i++) {
            Student stud = students.get(i);
            for (int j = second_sort.size(); ; j--) {
                if (j == -1) {
                    second_sort.add(0, stud);
                    break;
                }
                if (isNameBetter(second_sort.get(j).getName(), stud.getName())) {
                    second_sort.add(j+1, stud);
                    break;
                }
            }
        }
        for (int i = 0; i < students.size(); i++) {
            students.set(i, second_sort.get(i));
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

