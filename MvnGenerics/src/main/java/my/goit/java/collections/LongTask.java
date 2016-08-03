package my.goit.java.collections;

public class LongTask implements Task<Long> {
    private long value;

    public LongTask(long value) {
        this.value = value;
    }

    @Override
    public void execute(){
    }
    @Override
    public Long getResult() {
        return getValue();
    }



    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}
