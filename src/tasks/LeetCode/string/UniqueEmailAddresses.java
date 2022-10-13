package tasks.LeetCode.string;

import java.util.HashSet;
import java.util.Set;

/**
 * 929. Unique Email Addresses
 * https://leetcode.com/problems/unique-email-addresses/
 */
public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            StringBuilder cleanEmail = new StringBuilder();
            for (int i = 0; i < email.length(); i++) {
                char c = email.charAt(i);
                if (c == '+' || c == '@') break;
                if (c != '.') cleanEmail.append(c);
            }
            StringBuilder domainName = new StringBuilder();
            for (int i = email.length() - 1; i >= 0; i--) {
                char c = email.charAt(i);
                domainName.append(c);
                if (c == '@') break;
            }

            domainName.reverse();
            cleanEmail.append(domainName);
            set.add(cleanEmail.toString());
        }
        return set.size();
    }
}
