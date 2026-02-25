package app;

public class maxConsecutiveOnes {
    public static void main(String[] args){

        int[] nums = new int[]{1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(nums));
        int[] nums2 = new int[]{1,0,1,1,0,1};
        System.out.println(findMaxConsecutiveOnes(nums2));
    }

    public static int findMaxConsecutiveOnes(int[] nums){

        int countOnes = 0;
        int maxOnes = 0;

        for (int num : nums) {
            if (num == 1) {
                countOnes++;
            }
            if (num != 1 && countOnes > 0){
                maxOnes = Math.max(maxOnes, countOnes);
                countOnes = 0;
            }
        }
        maxOnes = Math.max(maxOnes, countOnes);
        return maxOnes;
    }

}