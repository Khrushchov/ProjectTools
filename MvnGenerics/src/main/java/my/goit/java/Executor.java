package my.goit.java;

import java.util.List;

public interface Executor<E> {
    void addTask(Task<? extends E> task);
    void addTask(Task<? extends E> task, Validator<? super E> validator);
    void execute();
    List<E> getValidResults();
    List<E> getInvalidResults();
}
