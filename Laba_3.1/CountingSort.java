import java.util.List;

public class CountingSort implements Sorting<Integer> {
    @Override
    public void sort(List<Integer> nums) {
        if (nums.isEmpty()) {
            return;
        }
        int[] countArr = new int[128];
        for (int i = 0; i < nums.size(); i++) {
            countArr[nums.get(i)]++;
        }
        int arrPoint = 0;
        int listPoint = 0;
        while (listPoint != nums.size()) {
            while (countArr[arrPoint] == 0){ //бежим по нулевым ячейкам счётчика
                arrPoint++;
            }
            nums.set(listPoint, arrPoint);
            countArr[arrPoint]--;
            listPoint++;
        }
    }
}