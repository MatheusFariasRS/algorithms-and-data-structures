package app;

import java.util.Arrays;

public class validAnagramArray {
    public static void main(String[] args) {

        System.out.println(isAnagram("anagram","nagaram"));
        System.out.println(isAnagram("rat","car"));

    }

    public static boolean isAnagram(String s, String t){

        if (s.length() != t.length()) return false;  // verifica se  os string são do mesmo tamanho, se n forem já retorna falso

        int[] count = new int[26]; //cria um array de 26 posições com inteiros
        Arrays.fill(count, 0); //preenche as 26 posições com 0

        for(int i = 0; i < s.length(); i++){ // for  do tamanho do string s
            int index =  s.charAt(i) - 'a'; //variavel index do tipo int recebe o valor unicode que está na posição (i) menos o valor unicode de 'a'
            count[index]++; //count na posição referente ao valor de index soma 1
        }

        for(int i = 0; i < t.length(); i++){ // for  do tamanho do string t
            int index =  t.charAt(i) - 'a'; //variavel index do tipo int recebe o valor unicode que está na posição (i) menos o valor unicode de 'a'
            count[index]--;  //count na posição referente ao valor de index subtrai 1
        }

        for(int val : count){ // val que é do mesmo tipo do array count vai percorrer as posições de count
            if(val != 0) return false; // se em alguma posição que val recebe o valor da posição de count for diferente de 0 retorna falso
        }

        return true; // se nada retornou falso, retorna verdadeiro
    }
}
