package my.goit.java;

import java.util.ArrayList;
import java.util.List;

public class ExecutorImpl<T> implements Executor<T> {
    List<Task<? extends T>> validTasks = new ArrayList<>();
    List<Task<? extends T>> invalidTasks = new ArrayList<>();
    List<T> validResults = new ArrayList<>();
    List<T> invalidResults = new ArrayList<>();
    private boolean executeFlag = false;

    @Override
    public void addTask(Task<? extends T> task) {
        try {
            if (isExecuteFlag()) {
                throw new Exception();
            }
            validTasks.add(task);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void addTask(Task<? extends T> task, Validator<? super T> validator) {
        try {
            if (isExecuteFlag()) {
                throw new Exception();
            }
            if (validator.isValid(task.getResult())) {
                validTasks.add(task);
            } else {
                invalidTasks.add(task);
            }
            task.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void execute() {
        for (Task<? extends T> validTask : validTasks) {
            validResults.add(validTask.getResult());
        }

        for (Task<? extends T> invalidTask : invalidTasks) {
            invalidResults.add(invalidTask.getResult());
        }
        setExecuteFlag(true);
    }

    @Override
    public List getValidResults() {
        try {
            if (!isExecuteFlag()) {
                throw new Exception();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return validResults;
    }

    @Override
    public List getInvalidResults() {
        try {
            if (!isExecuteFlag()) {
                throw new Exception();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return invalidResults;
    }

    public boolean isExecuteFlag() {
        return executeFlag;
    }

    public void setExecuteFlag(boolean executeFlag) {
        this.executeFlag = executeFlag;
    }
}
