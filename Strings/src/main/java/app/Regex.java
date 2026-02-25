package app;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static void main(String[] args) {

        System.out.println("CEP é valido");
        System.out.println(validateCEP("12345-678"));
        System.out.println(validateCEP("12345678"));
        System.out.println(validateCEP("1234-5678"));

        System.out.println("\nRemover de um CPF qualquer caractere que não seja um dígito");
        System.out.println(removeNonDigits("94923784799"));
        System.out.println(removeNonDigits("213.445.034-82"));

        System.out.println("\nverifique se um dado domínio termina com .br");
        System.out.println(validateBrDomain("batata.com.br"));
        System.out.println(validateBrDomain("banana.com"));

        System.out.println("\nencontre todos endereços de email em um texto.");
        String text = "Para mais informações, contate-nos em contato@exemplo.com ou suporte@exemplo.com.br.";

        String[] emails = findEmails(text);

        if (emails.length > 0) {
            System.out.println("Emails encontrados:");
            for (String str : emails) {
                System.out.println(str);
            }
        } else {
            System.out.println("Nenhum email encontrado");
        }


        System.out.println(validateTelefone("+55 51 99402-1578"));

        System.out.println(validateSimpleDate("1998-02-31"));




}

    //CEP é valido
    public static boolean validateCEP(String cep) {
        return cep.matches("^\\d{5}-?\\d{3}$");
    }

    //remover de um CPF qualquer caractere que não seja um dígito
    public static String removeNonDigits(String text) {
        return text.replaceAll("\\D", "");
    }

    //verifique se um dado domínio termina com .br
    public static boolean validateBrDomain(String domain) {
        return domain.matches(".*\\.br$");
    }

    //encontre todos endereços de email em um texto.
    public static String[] findEmails(String text){
        String regex = ("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\\b");
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        String [] temp = new String[10];
        int count = 0;

        while (matcher.find()) {
            temp[count++] = matcher.group();
        }

        String[] result = new String[count];
        for (int i =0; i<count; i++) {
            result[i] = temp[i];
        }
        return result;
    }

    //Telefone brasileiro
    public static boolean validateTelefone(String numberPhone){
        return numberPhone.matches("^(?:\\+55\\s?)?(?:\\([1-9]{2}\\)|[1-9]{2})\\s?(?:9\\s?)?[6789][0-9]{3}\\s?-?\\s?[0-9]{4}$");
    }

    //Data no formato aaaa-mm-dd (simplificada) n verifica 31/02
    public static boolean validateSimpleDate(String date){
        return date.matches("^\\d{4}-\\d{2}-\\d{2}$");
    }


}