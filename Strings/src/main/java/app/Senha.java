package app;

public class Senha {
    public static void main(String[] args){

        System.out.println(validatePassword("amerca1@"));
        System.out.println(validatePassword("amrca154682"));
    }

    public static Boolean validatePassword(String str){
        if (str.length() < 8){
            return false;
        }
        for(int i = 0; i < str.length(); i++) {
            if (!hasLetter(str)){
                return false;
            }
            if (!hasDigit(str)){
                return false;
            }
            if (!hasSpecialCharacteres(str)){
                return false;
            }
        }

        return true;
    }

    public static boolean hasLetter(String str){
        char[] arr = str.toCharArray();
        for(int i = 0; i < str.length(); i++) {
            if ((arr[i] >= 'a' && arr[i] <= 'z') || (arr[i] >= 'A' && arr[i] <= 'Z')){
                return true;
            }
        }
        return false;
    }

    public static boolean hasDigit(String str){
        char[] arr = str.toCharArray();
        for(int i = 0; i < str.length(); i++) {
            if ((arr[i] >= '0' && arr[i] <= '9')){
                return true;
            }
        }
        return false;
    }

    public static boolean hasSpecialCharacteres(String str){
        char[] arr = str.toCharArray();
        for(int i = 0; i < str.length(); i++) {
            if (arr[i] == '@' || arr[i] == '#'|| arr[i] == '&'){
                return true;
            }
        }
        return false;
    }
}
