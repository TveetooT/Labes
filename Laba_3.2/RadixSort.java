import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class RadixSort implements Sorting<BigInteger> {
    private static final BigInteger[] POW = new BigInteger[20];
    private final List<ArrayDeque<BigInteger>> temp = new ArrayList<>(10);

    @Override
    public void sort(List<BigInteger> nums) {
        for (int i = 0; i<20; i++) { //итер по цифрам
            for (var q : temp) { //чистка темпа
                q.clear(); //кьюуе
            }
            for (BigInteger num : nums) { //подсчёт (в темп)
                temp.get(getDigit(num, POW[i])).addLast(num);
            }
            int index = 0;
            for (int j = 0; j < 10; j++) { //выписываем в оригинальный массив
                ArrayDeque<BigInteger> q = temp.get(j); //очередь цифры
                while (!q.isEmpty()) { 
                    nums.set(index++, q.removeFirst());
                }
            }
        }
    }

    private int getDigit(BigInteger num, BigInteger pow) {
        return num
        .divide(pow) //без остатка
        .remainder(BigInteger.TEN) //остаток
        .intValue(); 
    }

    public RadixSort() { //конструктор
        for (int i = 0; i < 10; i++) { // степени десяти
            temp.add(new ArrayDeque<>());
        }
    }
    
    static {
        for (int i = 0; i < 20; i++) { //конструктор 2 (спросить)
            POW[i] = BigInteger.TEN.pow(i);
        } 
    }
}

