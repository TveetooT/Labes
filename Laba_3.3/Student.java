public class Student implements Comparable<Student> {
    private final String name;
    private final int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Student other) {
        int nameCompare = compareName(other);
        if (nameCompare != 0) {
            return nameCompare;
        }
        return compareAge(other);
    }

    public int compareName(Student other) {
        return name.compareTo(other.name);
    }

    public int compareAge(Student other) {
        return Integer.compare(age, other.age);
    }
}
