import java.util.ArrayList;
import java.util.List;

public class Program{
    public void main(String[] args) {
        System.out.println("тест");
        List<Integer> arr = new ArrayList<>(List.of(0,2,6,6,1,0,4,6));
        int val = 6;
        KVKVP(arr, val);
    }

    public int removeElementInplace(List<Integer> arr, int val) {
        for (int i = 0; i < arr.size(); i++){
            if (arr.get(i) == val){
                arr.remove(i);
                i--;
            }
        }
        return arr.size();
    }
    void KVKVP(List<Integer> arr, int val){
        int size = arr.size();
        System.out.print("Input: arr = [");
        V(arr);
        System.out.print("], val = ");
        System.out.println(val);
        System.out.print("Output: ");
        System.out.print(removeElementInplace(arr, val));
        System.out.print(", arr = [");
        V(arr);
        if (arr.size() != size){
            System.out.print(",");
            for (int i = 0; i < size - arr.size()-1; i++){
                System.out.print("_,");
            }
            System.out.print("_");
        }
        System.out.print("]");
    }
    void V(List<Integer> arr){
        for (int i = 0; i < arr.size()-1; i++){
            System.out.print(arr.get(i));
            System.out.print(",");
        }
        System.out.print(arr.get(arr.size()-1));
    }
}
