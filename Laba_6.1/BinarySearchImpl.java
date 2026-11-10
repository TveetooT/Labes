import java.util.ArrayList;

public class BinarySearchImpl implements BinarySearch<Integer>{
    @Override
    public Integer search(ArrayList<Integer> array, Integer key) {
        if (array.isEmpty()) {
            return null;
        }
        Integer left = 0;
        Integer right = array.size() - 1;
        if (key < array.get(left)) {
            return array.get(left);
        }
        if (key > array.get(right)) {
            return array.get(right);
        }
        while (left <= right) {
            Integer mid = (left + right) / 2;
            Integer mid_value = array.get(mid);
            if (mid_value.equals(key)) {
                return mid_value;
            }
            if (mid_value < key) {
                left = mid + 1;
            }
            if (mid_value > key) {
                right = mid - 1;
            }
        }
        if (Math.abs(array.get(left) - key) < Math.abs(array.get(right) - key)) {
                return array.get(left);
            }
            return array.get(right);
    }
}
