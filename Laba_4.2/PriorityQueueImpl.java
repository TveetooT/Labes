import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PriorityQueueImpl implements PriorityQueue<Integer> {
    private List<QueueNode> tree = new ArrayList<>();
    private Map<Long, Integer> hash = new HashMap<>();
    private long operations = 1;

    @Override
    public void enqueue(Integer num) {
        tree.addLast(new QueueNode(num, operations));
        hash.put(operations, tree.size()-1);
        operations++;
        siftUp(tree.size()-1);
    }

    @Override
    public Integer dequeueMax() {
        if (tree.isEmpty()) {
            return null;
        }
        swap(0, tree.size()-1);
        Integer temp = tree.get(tree.size()-1).getNum();
        hash.remove(tree.remove(tree.size()-1).getOp()); //O(1)
        siftDown(0);
        return temp;
    }

    @Override
    public void increment(long operation, Integer addition) {
        Integer index = hash.get(operation);
        if (index == null) {
            return;
        }
        tree.get(index).add(addition);
        if (addition > 0) {
            siftUp(index);
        } else if (addition < 0) {
            siftDown(index);
        }

    }

    private void siftUp(Integer num) { //ПРИНИМАЕТ ИНДеКСЫ
        while (num > 0) {
            Integer par = ((num-1)/2);
            if (tree.get(num).getNum() >= tree.get(par).getNum()) {
                swap(num, par);
                num = par;
                continue;
            }
            return;
        }
    }

    private void siftDown(Integer num) {
    while (true) {
        Integer c1 = 2 * num + 1;
        Integer c2 = c1 + 1;

        if (c1 >= tree.size()) {
            return;
        }

        Integer larger = c1;
        if (c2 < tree.size()
                && tree.get(c2).getNum() > tree.get(c1).getNum()) {
            larger = c2;
        }

        if (tree.get(num).getNum() >= tree.get(larger).getNum()) {
            return;
        }

        swap(num, larger);
        num = larger;
    }
}

    private void swap(Integer i, Integer j) {
        QueueNode temp = tree.get(i);
        hash.put(tree.get(i).getOp(), j);
        hash.put(tree.get(j).getOp(), i);
        tree.set(i, tree.get(j));
        tree.set(j, temp);
    }
} 