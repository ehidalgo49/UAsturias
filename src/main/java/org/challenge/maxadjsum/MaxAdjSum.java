package org.challenge.maxadjsum;

public class MaxAdjSum {
    public int calculate(int[] arr) {
        int maxSum=0;
        for (int i=0; i < arr.length - 1; i++) {
            int currentSum= arr[i] + arr[i+1];
            if (currentSum> maxSum) {
                maxSum=currentSum;
            }
        }
        return maxSum;
    }

    public void init(){

        int[] numbers = {3, 6, -2, -5, 7, 8};
        System.out.println(calculate(numbers));
        // Output: 10
    }
}
