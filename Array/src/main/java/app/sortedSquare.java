package app;

import java.util.Arrays;

public class sortedSquare{
    public static void main(String[] args) {

        int[] nums = new int[]{-4,-1,0,3,10};

        System.out.println(Arrays.toString(sortedSquares(nums)));

    }

    public static int[] sortedSquares(int[] nums){

        int n = nums.length;
        int[] result = new int[n];

        int left = 0;
        int right = n - 1;
        int pos = n - 1;

        while(left <= right) {
            int leftSq = nums[left] * nums[left];
            int rightSq = nums[right] * nums[right];

            if (leftSq > rightSq){
                result[pos] = leftSq;
                left++;
            }else {
                result[pos] = rightSq;
                right--;
            }
            pos--;
        }
        return  result;
    }
}

/*

    - i = num [i]
 */