package app;

public class SenhaRegex {
    public static void main(String[] args){

        System.out.println(validatePassword("amerca1@"));
        System.out.println(validatePassword("amrca154682"));
    }

    public static Boolean validatePassword(String str){
        return str.matches("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@&#]).{8,}$");
    }

}
