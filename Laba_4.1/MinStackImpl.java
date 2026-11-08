public class MinStackImpl implements MinStack<Integer> {
    private Node head = null;

    @Override
    public void push(Integer value) {
        Integer min;
        if (head == null) {
            min = Integer.MAX_VALUE;
        }
        else {
            min = head.min();
        }
        head = new Node(value, Integer.min(value, min), head);
    }

    @Override
    public Integer pop() {
        Integer temp = head.num();
        head = head.next();
        return temp;
    }

    @Override
    public Integer top() {
        return head.num();
    }

    @Override
    public Integer min() {
        return head.min();
    }
} 