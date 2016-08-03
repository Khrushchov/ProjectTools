package my.goit.java;

public interface Task<E> {
    void execute();

    E getResult();

}
