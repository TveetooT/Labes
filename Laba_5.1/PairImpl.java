public class PairImpl implements Pair<String, String>{
    private final String key;
    private String value;
    @Override
    public String getKey() {
        return this.key;
    }
    @Override 
    public String getValue() {
        return this.value;
    }
    @Override 
    public void setValue(String v) {
        this.value = v;
    }
    public PairImpl(String k) {
        this.key = k;
    }
}
