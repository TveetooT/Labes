import java.util.ArrayList;
import java.util.List;

public class MergeSort implements Sorting<Integer> {
    private void slice(List<Integer> nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int middle = start + (end - start) / 2;
        slice(nums, start, middle);
        slice(nums, middle + 1, end);
        merge(nums, start, middle, end);
    }
    private void merge(List<Integer> nums, int start, int middle, int end) {
        List<Integer> levo  = new ArrayList<>(nums.subList(start, middle + 1));
        List<Integer> pravo = new ArrayList<>(nums.subList(middle + 1, end + 1));
        int i = 0;
        int j = 0;
        int k = start;
        while (i < levo.size() && j < pravo.size()) {
            if (levo.get(i) <= pravo.get(j)) {
                nums.set(k++, levo.get(i++));
            } else {
                nums.set(k++, pravo.get(j++));
            }
        }
        while (i < levo.size()) {
            nums.set(k++, levo.get(i++));
        }
        while (j < pravo.size()) {
            nums.set(k++, pravo.get(j++));
        }
    }
    @Override
    public void sort(List<Integer> nums) {
        slice(nums, 0, nums.size() - 1);
    }
}