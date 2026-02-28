package app;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Seller {
    public static void main(String[] args)  throws IOException {

        findMaxSellerAmount();
    }

    public static void findMaxSellerAmount(){

        try(InputStream inputStream = Seller.class.
                getClassLoader().
                getResourceAsStream("seller.json")) {
            if(inputStream == null){
                throw new RuntimeException("seller.json not found in classpath");
            }

            JsonNode root = new ObjectMapper().readTree(inputStream);

            double maxAmount = 0.0;
            String seller = "";
            for (JsonNode jn : root){

                if (jn.get("amount").asDouble() > maxAmount){
                    maxAmount = jn.get("amount").asDouble();
                    seller = jn.get("name").asText();
                }
            }
            System.out.println("name: " + seller + "\namount: " + maxAmount);
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}
