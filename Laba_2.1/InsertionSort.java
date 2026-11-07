import java.util.List;

public class InsertionSort implements Sorting<Integer> {
    @Override
    public void sort(List<Integer> nums) {
        for (int i = 1; i < nums.size(); i++) {
            int num = nums.get(i);
            int j = i - 1;
            while (j >= 0 && nums.get(j) > num) {
                j--;
            }
            if (j + 1 != i) {
                nums.remove(i);
                nums.add(j + 1, num);
            }
        }
    }
}
