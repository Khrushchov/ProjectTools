package my.goit.java;

public class Main {
    public static void main(String[] args) {
        SquareSumImpl squareSum = new SquareSumImpl();
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        System.out.println(squareSum.getSquareSum(values, 8));
    }
}
