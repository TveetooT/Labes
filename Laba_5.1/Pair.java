public interface Pair<I,J> {
    I getKey();
    J getValue();
    void setValue(J value);
}