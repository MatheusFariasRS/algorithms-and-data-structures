package app;

public class ArrayProduct {
    public static void main(String[] args){

        int[] arr1 = new int[]{1,0,0,2,3};
        int[] arr2 = new int[]{0,3,0,4,0};

        System.out.println(findArrayProduct(arr1, arr2));

        int[] arr3 = new int[]{0,1,0,0,0};
        int[] arr4 = new int[]{0,0,0,0,2};

        System.out.println("\n" + findArrayProduct(arr3, arr4));

        int[] arr5 = new int[]{0,1,0,0,2,0,0};
        int[] arr6 = new int[]{1,0,0,0,3,0,4};

        System.out.println("\n" + findArrayProduct(arr5, arr6));
    }

    public static int findArrayProduct(int[] arr1, int[] arr2){
        int num = 0;
        for (int i = 0; i < arr1.length; i++) {
                num += arr1[i] * arr2[i];
        }
        return num;
    }
}
