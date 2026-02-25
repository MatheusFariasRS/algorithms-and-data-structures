package app;

import java.util.Arrays;

public class EvenNumber {
    public static void main(String[] args){

        int[] nums = new int[]{12,345,2,6,7896};
        System.out.println(findEvenNumber(nums));

        int[] nums2 = new int[]{555,901,482,1771};
        System.out.println("\n" + findEvenNumber(nums2));
    }

    public static int findEvenNumber(int[] nums){

        int sumEvenNumber  = 0;

        for (int i = 0; i < nums.length; i++) {
            int count = String.valueOf(nums[i]).length();
            if (count % 2 == 0){
                sumEvenNumber++;
            }
        }

        return sumEvenNumber;
    }
}
