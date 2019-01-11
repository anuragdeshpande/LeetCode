package easy;

import java.util.HashSet;

/*
Every email consists of a local name and a domain name, separated by the @ sign.

For example, in alice@leetcode.com, alice is the local name, and leetcode.com is the domain name.

Besides lowercase letters, these emails may contain '.'s or '+'s.

If you add periods ('.') between some characters in the local name part of an email address, mail sent there will be forwarded to the same address without dots in the local name.  For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.  (Note that this rule does not apply for domain names.)

If you add a plus ('+') in the local name, everything after the first plus sign will be ignored. This allows certain emails to be filtered, for example m.y+name@email.com will be forwarded to my@email.com.  (Again, this rule does not apply for domain names.)

It is possible to use both of these rules at the same time.

Given a list of emails, we send one email to each address in the list.  How many different addresses actually receive mails?



Example 1:

Input: ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
Output: 2
Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails


Note:

1 <= emails[i].length <= 100
1 <= emails.length <= 100
Each emails[i] contains exactly one '@' character.
 */

public class UniqueEmailAddresses {

    public static void main(String[] args) {
        UniqueEmailAddresses tester = new UniqueEmailAddresses();
        System.out.println(tester.numUniqueEmails(new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"}));
    }

    /*
    Algorithm:
        Loop the array and for each string
            1. split on "@"
            2. Extract the last index of split as domain into a string as none of the special rules apply to it
            3. Extract the First index as local name
                3.a replace all instances of dot(.) with nothing
                3.b substring to the first instance of '+'
            4. append the formatted localname +'@' + domain and add it to a set to remove duplicates if any
            5. return the count of the set.
     */
    private int numUniqueEmails(String[] emails) {
        HashSet<String> emailSet = new HashSet<>();

        for (String email: emails){
            String[] split = email.split("@");
            String localName = split[0].replaceAll("\\.", "");
            String domain = split[1];

            if(localName.contains("+")){
                String plusVoidEmail = localName.substring(0, localName.indexOf('+'));
                plusVoidEmail  = plusVoidEmail+"@"+domain;
                emailSet.add(plusVoidEmail);
                System.out.println(plusVoidEmail);
            } else {
                emailSet.add(localName+"@"+domain);
            }

        }

        return emailSet.size();
    }
}
