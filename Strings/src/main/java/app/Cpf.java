package app;

public class Cpf {
    public static void main(String[] arg){

        System.out.println("Remover não digitos com Regex");
        System.out.println(removeNonDigitsRegex("874.092.172-93"));

        System.out.println("\nRemover não digitos sem Regex");
        System.out.println(removeNonDigits("874.092.172-93"));

    }

    public static String removeNonDigitsRegex(String str){
        return str.replaceAll("\\D", "");
    }

    public static String removeNonDigits(String str){

        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        char[] arr = str.toCharArray();

        for (int i = 0; i < length; i++) {
            char c = arr[i];
            if(c >= '0' && c <= '9') {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
