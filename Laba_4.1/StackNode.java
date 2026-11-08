public interface StackNode<T extends Number> {
    T num();
    T min();
    StackNode<T> next();
}
