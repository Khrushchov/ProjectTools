package my.goit.java.collections;

public class NumberValidator implements Validator<Number>{
    @Override
    public boolean isValid(Number result) {
        return (result != null) && (result.intValue()%2==0);
    }
}
