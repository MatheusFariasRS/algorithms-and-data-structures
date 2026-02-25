package app;

public class Data2 {
    public static void main(String[] args){

        System.out.println(formatDate(21, 7, 2010));

    }

    public static String formatDate(int day, int month, int year){
        return String.format("%02d/%02d/%d", day, month, year);
    }


}
