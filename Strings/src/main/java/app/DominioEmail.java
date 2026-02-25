package app;

public class DominioEmail {
    public static void main(String[] args){

        System.out.println(extractEmailInformation("joao.silva23@yahoo.com.br"));
    }

    public static EmailInfo extractEmailInformation(String email) {
        String[] parts = email.split("@");

        String user = parts[0];
        String domain = parts[1];

        return new EmailInfo(user, domain);
    }

    /* OUTRA VERSÃO
    public static EmailInfo extractEmailInformation(String email) {
    int atIndex = email.indexOf('@');

    String user = email.substring(0, atIndex);
    String domain = email.substring(atIndex + 1);

    return new EmailInfo(user, domain);
}
     */

    public static class EmailInfo {

        private  String user;
        private  String domain;

        public EmailInfo(String user, String domain) {
            this.user = user;
            this.domain = domain;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getDomain() {
            return domain;
        }

        public void setDomain(String domain) {
            this.domain = domain;
        }

        public boolean isBrazilian() {
            return domain.endsWith(".br");
        }

        @Override
        public String toString() {
            return "Usuario: " + user +
                    "\nDominio: " + domain +
                    "\nBrasileiro: " + (isBrazilian() ? "sim" : "nao");
        }
    }
}
