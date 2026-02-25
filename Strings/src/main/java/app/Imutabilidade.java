package app;

public class Imutabilidade {
    public static void main(String[] args){
        String str = "Hello, world!";
        System.out.println(str);
        char[] arr = str.toCharArray(); // Converte a string em um array de caracteres
        arr[7] = 'W'; // Modifica um caracter específico
        str = new String(arr); // Converte o array de volta para string
        System.out.println(str);
    }
}
