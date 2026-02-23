package app;

public class Data1 {
    public static void main(String[] args) {

        System.out.println(extractDateData("21/07/2010"));

        System.out.println(extractDateDataSubstring("21/07/2010"));
    }

    public static DateInfo extractDateData(String date) {

        String[] parts = date.split("/");

        Integer day = Integer.valueOf(parts[0]);
        Integer month = Integer.valueOf(parts[1]);
        Integer year = Integer.valueOf(parts[2]);

        return new DateInfo(day, month, year);
    }

    public static DateInfo extractDateDataSubstring(String date) {


        Integer day = Integer.valueOf(date.substring(0, 2));
        Integer month = Integer.valueOf(date.substring(3, 5));
        Integer year = Integer.valueOf(date.substring(6));


        return new DateInfo(day, month, year);
    }

    public static class DateInfo{

        private Integer day;
        private Integer month;
        private Integer year;

        public DateInfo() {
        }

        public DateInfo(Integer day, Integer month, Integer year) {
            this.day = day;
            this.month = month;
            this.year = year;
        }

        public Integer getDay() {
            return day;
        }

        public void setDay(Integer day) {
            this.day = day;
        }

        public Integer getMonth() {
            return month;
        }

        public void setMonth(Integer month) {
            this.month = month;
        }

        public Integer getYear() {
            return year;
        }

        public void setYear(Integer year) {
            this.year = year;
        }

        @Override
        public String toString() {
            return String.format(
                    "Dia: %02d%nMes: %02d%nAno: %d",
                    day, month, year
            );
        }

    }
}
