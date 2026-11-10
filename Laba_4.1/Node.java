public class Node implements StackNode<Integer> {
    private final Integer num;
    private final Integer min;
    private final Node next_node;

    @Override
    public Integer num() {
        return num;
    }

    @Override 
    public Integer min() {
        return min;
    }

    @Override 
    public Node next() {
        return next_node;
    }

    public Node(Integer n, Integer m, Node nn) {
        this.num = n;
        this.min = m;
        this.next_node = nn;
    }
}

