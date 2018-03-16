package jp.toastkid.til.int_array_calc;

import org.junit.Test;

/**
 * @author toastkidjp
 */
public class IntArrayCalculation {

    /**
     * <pre>
     * max = 10
     * min = 2
     * sum = 32
     * average = 5.333333333333333
     * </pre>
     */
    @Test
    public void test() {
        final int[] numbers = {3, 2, 10, 4, 7, 6};
        int max = Integer.MIN_VALUE;
        for (final int n : numbers) {
            if (max < n) {
                max = n;
            }
        }

        int min = Integer.MAX_VALUE;
        for (final int n : numbers) {
            if (min > n) {
                min = n;
            }
        }

        int sum = 0;
        for (final int n : numbers) {
            sum += n;
        }

        final double average = (double) sum / (double) numbers.length;

        System.out.println("max = " + max);
        System.out.println("min = " + min);
        System.out.println("sum = " + sum);
        System.out.println("average = " + average);
    }
}
