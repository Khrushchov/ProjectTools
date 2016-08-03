package my.goit.java.collections;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ExecutorImplTest {

    @Test
    public void test() {
        List<IntegerTask> intTasks = Arrays.asList(new IntegerTask(10), new IntegerTask(20));

        Executor<Number> numberExecutor = new ExecutorImpl<>();

        for (Task<Integer> intTask : intTasks) {
            numberExecutor.addTask(intTask);
        }
        numberExecutor.addTask(new LongTask(10L), new NumberValidator());

        numberExecutor.execute();

        System.out.println("Valid results:");
        for (Number number : numberExecutor.getValidResults()) {
            System.out.println(number);
        }
        System.out.println("Invalid results:");
        for (Number number : numberExecutor.getInvalidResults()) {
            System.out.println(number);
        }
    }

}