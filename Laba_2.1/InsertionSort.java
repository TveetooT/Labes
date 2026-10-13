import java.util.List;
import java.util.ArrayList;

public class InsertionSort implements Sorting<Integer> {
    @Override
    public void sort(List<Integer> nums) {
        if (nums.isEmpty()) {
            return;
        }
        for (int i = 1; i < nums.size(); i++) {
            int num = nums.get(i);
            for (int j = i - 1; ; j--) {
                if (j == -1 ) {
                    nums.remove(i);
                    nums.add(0, num);
                    break;
                }
                if (nums.get(j) < num) {
                    nums.remove(i);
                    nums.add(j+1, num);
                    break;
                }
            }
        }
    }
}