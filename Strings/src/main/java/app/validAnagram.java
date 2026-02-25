package app;

import java.util.Arrays;

public class validAnagram {
    public static void main(String[] args){
        System.out.println(isAnagramV1("anagram","nagaram"));
        System.out.println(isAnagramV1("rat","car"));

        System.out.println(isAnagramV2("anagram","nagaram"));
        System.out.println(isAnagramV2("rat","car"));
    }

    public static boolean isAnagramV1(String s, String t){

        if (s.length() != t.length()) return false;

        String[] sArray = s.split("");
        String[] tArray = t.split("");

        Arrays.sort(sArray);
        Arrays.sort(tArray);

        String a = Arrays.toString(sArray);
        String b = Arrays.toString(tArray);

        return a.equals(b);
    }

    public static boolean isAnagramV2(String s, String t){

        if (s.length() != t.length()) return false;

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);

        return Arrays.equals(sArray, tArray);
    }
}
