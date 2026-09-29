import java.util.ArrayList;
import java.util.List;

public class Program{
    public void main(String[] args) {
        System.out.println("тест");
        List<Integer> arr = new ArrayList<>(List.of(4,5,5,4));
        int val = 4;
        KVKVP(arr, val);
    }

    public int removeElementInplace(List<Integer> arr, int val) {
        int reader = 0;
        int writer = 0;
        int size = arr.size();
        while (true){
            if (reader == arr.size()){
                break;
            }
            if (arr.get(reader) != val){
                arr.set(writer, arr.get(reader));
                writer += 1;
                reader += 1;
            }
            else{
                reader += 1;
            }
        }
        return writer;
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
