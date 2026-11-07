import java.util.List;

public class ComparableSort<T extends Comparable<? super T>> implements Sorting<T> {
    @Override //сортировка всталявлянием
    public void sort(List<T> nums) {
        for (int i = 1; i < nums.size(); i++) {
            T value = nums.get(i);
            int j = i - 1;
            while (j >= 0 && nums.get(j).compareTo(value) > 0) {
                j--;
            }
            if (j + 1 != i) {
                nums.remove(i);
                nums.add(j + 1, value);
            }
        }
    }
}