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

            for (JsonNode jn : root){
                System.out.println(jn.get("id").asInt() + " " +jn.get("title").asText());
                for (JsonNode lesson : jn.get("lessons")){
                    System.out.println(lesson.get("title").asText());
                }
            }
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}
