package app;
import java.util.ArrayList;
import java.util.List;
public class Transacoes {
    public static void main(String[] args){
        System.out.println(invalidTransactions(new String[]{"alice,20,800,mtv", "alice,50,100,beijing" }));
        System.out.println(invalidTransactions(new String[] { "alice,20,800,mtv", "alice,50,1200,mtv" }));
        System.out.println(invalidTransactions(new String[] { "alice,20,800,mtv", "bob,50,1200,mtv" }));
    }
    public static List<String> invalidTransactions(String[] transactions) {

        class Transactions {
            String name;
            int time;
            int amount;
            String city;
            public Transactions(String csv) {
                String[] parts = csv.split(",");
                name = parts[0];
                time = Integer.parseInt(parts[1]);
                amount = Integer.parseInt(parts[2]);
                city = parts[3];
            }
            @Override
            public String toString() {
                return "Transactions:\n"  +
                        "name: " + name +
                        ", time: " + time +
                        ", amount: " + amount +
                        ", city: " + city;
            }
        }

        List<String> result = new ArrayList<>();

        boolean[] invalidArray = new boolean[transactions.length];

        for(int i=0; i < transactions.length; i++){

            Transactions ti = new Transactions(transactions[i]);

            if (ti.amount > 1000){
                invalidArray[i] = true;
            }

            for (int j = i + 1; j < transactions.length; j++) {

                Transactions tj = new Transactions(transactions[j]);

                if (ti.name.equals(tj.name) && Math.abs(ti.time - tj.time) <= 60 && !ti.city.equals(tj.city)){
                    invalidArray[i] = true;
                    invalidArray[j] = true;
                }
            }

        }

        for (int i = 0; i < transactions.length; i++) {
            if (invalidArray[i]) result.add(transactions[i]);
        }
        return result;
    }
}

