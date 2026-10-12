import java.util.List;
import java.util.ArrayList;

public class InsertionSort implements Sorting<Integer> {
    @Override
    public void sort(List<Integer> nums) {
        List<Integer> arr = new ArrayList<>();
        arr.add(nums.get(0));
        for (int i = 1; i < nums.size(); i++) {
            var num = nums.get(i);
            for (int j = arr.size() - 1; ; j--) {
                if (j == -1 ) {
                    arr.add(0, num);
                    break;
                }
                if (arr.get(j) < num) {
                    arr.add(j+1, num);
                    break;
                }
            }
        }
        for (int i = 0; i < nums.size(); i++) {
            nums.set(i, arr.get(i));
        }
    }
}