public class QueueNode{
    private Integer num;
    private final long operation;
    
    public Integer getNum() {
        return this.num;
    }
    public long getOp() {
        return this.operation;
    }
    public void add(Integer n) {
        this.num += n;
    }
    public QueueNode(Integer n, long o) {
        this.num = n;
        this.operation = o;
    }
}