package my.goit.java;

import java.util.concurrent.*;

public class SquareSumImpl implements SquareSum {
    private static final Phaser PHASER = new Phaser(1);
    private int[] values;

    @Override
    public long getSquareSum(int[] values, int numberOfThreads) {
        this.values = values;
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);
        long results = 0;
        int start = 0;
        int part = values.length / numberOfThreads;
        int finish = start + part;

        for (int i = 1; i <= numberOfThreads; i++) {
            if (i == numberOfThreads) {
                finish = values.length;
            }
            Future<Long> future = executor.submit(new Counter(start, finish));
            start += part;
            finish += part;
            try {
                System.out.println(future.get());
                results += future.get();
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
        return results;
    }

    public class Counter implements Callable {
        private int start;
        private int finish;

        public Counter(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }

        @Override
        public Long call() throws Exception {
            long result = 0;
            for (int i = start; i < finish; i++) {
                result += Math.pow(values[i], 2);
            }
            System.out.printf("Поток со стартовым индексом %d посчитал квадраты и передал " +
                    "результат. \n", start);
            PHASER.arriveAndDeregister();

            return result;
        }
    }
}
