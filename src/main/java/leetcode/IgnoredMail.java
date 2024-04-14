package leetcode;

import java.util.HashSet;
import java.util.Set;

public class IgnoredMail {

    public static void main(String[] args) {
        String[] emails = {"mammadali.alizade+alex@infosys.com"};
        numUniqueEmails(emails);
    }


    public static int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet();
        for (String email : emails) {
            StringBuilder name = new StringBuilder();
            email = email.replace(".", "");
            name.append(email);
//            System.out.println(email);
            for (int i = 0; i < email.length(); i++) {
                if (email.charAt(i) == '+') {
                    break;
                }
                name.append(email.charAt(i));
                System.out.println(name);
            }
            StringBuilder domain = new StringBuilder();
            for (int i = email.length(); i > 0; i--) {
                if (email.charAt(i) != '@') {
                    domain.append(email.charAt(i));
                }

            }
            System.out.println(domain);
        }
        return 0;
    }
}
