package my.goit.java;

public interface Validator<E> {
    boolean isValid(E result);
}
