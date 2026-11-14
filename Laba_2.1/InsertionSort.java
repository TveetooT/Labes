import java.util.List;

public class InsertionSort implements Sorting<Integer> {
    @Override
    public void sort(List<Integer> nums) {
        for (int i = 1; i < nums.size(); i++) {
            for (int j = i; j > 0; j--) {
                if (nums.get(j) < nums.get(j - 1)) {
                    swap(j, j - 1, nums);
                }
                else {
                    break;
                }
            }
        }
    }
    private void swap(int i, int j, List<Integer> nums) {
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }
}
