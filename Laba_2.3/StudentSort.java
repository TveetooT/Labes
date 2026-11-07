import java.util.List;

public class StudentSort implements Sorting<Student> {
    @Override
    public void sort(List<Student> students) {
        sortByAge(students);
        sortByName(students);
    }

    private void sortByAge(List<Student> students) {
        for (int i = 1; i < students.size(); i++) {
            Student stud = students.get(i);
            int j = i - 1;
            while (j >= 0) {
                Student prev = students.get(j);
                if (prev.compareAge(stud) <= 0) {
                    break;
                }
                students.set(j + 1, prev);
                j--;
            }
            students.set(j + 1, stud);
        }
    }

    private void sortByName(List<Student> students) {
        for (int i = 1; i < students.size(); i++) {
            Student stud = students.get(i);
            int j = i - 1;
            while (j >= 0) {
                Student prev = students.get(j);
                if (prev.compareName(stud) <= 0) {
                    break;
                }
                students.set(j + 1, prev);
                j--;
            }
            students.set(j + 1, stud);
        }
    }
}
