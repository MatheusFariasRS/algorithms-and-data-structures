package app;

import java.util.Arrays;

public class PrefixoComum {

    public static void main(String[] args){

       String[] prefix = {"flowers","flow","flight"};
       System.out.printf("'%s'", longestCommonPrefix(prefix));


        String[] prefix2 = {"dog","racecar","car"};
        System.out.printf("%n'%s'", longestCommonPrefix(prefix2));
    }

    public static String longestCommonPrefix(String[] v){

        Arrays.sort(v);
        String first = v[0];
        String last = v[v.length -1];

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)){
                return sb.toString();
            }
            sb.append(first.charAt(i));
        }


        return sb.toString();
    }
}
