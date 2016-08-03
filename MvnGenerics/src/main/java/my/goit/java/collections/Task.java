package my.goit.java.collections;

public interface Task<E> {
    void execute();

    E getResult();

}
