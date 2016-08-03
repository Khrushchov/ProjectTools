package my.goit.java;

import java.util.Arrays;
import java.util.List;

public class Bootstrap {
    public static void main(String[] args) {
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
