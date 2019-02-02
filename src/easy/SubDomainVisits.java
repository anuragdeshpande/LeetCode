package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    A website domain like "discuss.leetcode.com" consists of various subdomains.
    At the top level, we have "com", at the next level, we have "leetcode.com", and at the lowest level,
    "discuss.leetcode.com". When we visit a domain like "discuss.leetcode.com", we will also visit the parent
    domains "leetcode.com" and "com" implicitly.

    Now, call a "count-paired domain" to be a count (representing the number of visits this domain received),
    followed by a space, followed by the address.
    An example of a count-paired domain might be "9001 discuss.leetcode.com".
    We are given a list cp-domains of count-paired domains. We would like a list of count-paired domains,
    (in the same format as the input, and in any order), that explicitly counts the
    number of visits to each sub-domain.

    Example 1:
    Input:
    ["9001 discuss.leetcode.com"]
    Output:
    ["9001 discuss.leetcode.com", "9001 leetcode.com", "9001 com"]
    Explanation:
    We only have one website domain: "discuss.leetcode.com". As discussed above, the sub-domain "leetcode.com" and "com" will also be visited. So they will all be visited 9001 times.

    Example 2:
    Input:
    ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
    Output:
    ["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
    Explanation:
    We will visit "google.mail.com" 900 times, "yahoo.com" 50 times, "intel.mail.com" once and "wiki.org" 5 times. For the subdomains, we will visit "mail.com" 900 + 1 = 901 times, "com" 900 + 50 + 1 = 951 times, and "org" 5 times.

    Notes:
    The length of cp-domains will not exceed 100.
    The length of each domain name will not exceed 100.
    Each address will have either 1 or 2 "." characters.
    The input count in any count-paired domain will not exceed 10000.
    The answer output can be returned in any order.
 */

public class SubDomainVisits {
    public static void main(String[] args) {
        SubDomainVisits tester = new SubDomainVisits();
        List<String> strings = tester.subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"});
        System.out.println(strings.stream().map(Object::toString)
                .collect(Collectors.joining(", ")));
    }

    /*
        Algorithm:
        * Init HashMap to store domain as key and its count as value
        * Init ArrayList of Strings to return the final strings as required in the question

        1. For each given string in the main array
            1.a split on space to get count and the actual domain to work on
            1.b save the count and the domain as key and value in the hash-map
            1.c reverse the domain string to ease the process of splitting the domain names (google.com -> moc.elgoog)
            1.d split the reverse string on dot(.)
            1.e for each contact on the split domain (moc, moc.elgoog)
                1.e.a return the reverse of the concatenation (com, com.google)
                1.e.b check the availability of the return string in the hash map
                       If already present increment the count
                       else put in hash map
           1.f for each key and value in the hash map
                1.f.a concat the count (value) with domain (key) with a space.
                1.f.b add to the finalArrayList
           1.g return the finalArrayList as result

     */
    private List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> visitCount = new HashMap<>();
        ArrayList<String> finalDomainCount = new ArrayList<>();
        for (String fullDomain : cpdomains) {
            String[] parts = fullDomain.split(" ");
            int count = Integer.valueOf(parts[0]);
            String domain = parts[1];

            // main domain
            updateDomainCount(visitCount, domain, count);

            // subDomains
            StringBuilder builder = new StringBuilder();
            builder.append(domain).reverse();

            String[] subdomains = builder.toString().split("\\.");
            for (int i = 0; i < subdomains.length - 1; i++) {
                String currentSubDomain = concatSubDomainsToLength(subdomains, i);
                updateDomainCount(visitCount, currentSubDomain, count);
            }
        }

        for (Map.Entry<String, Integer> domainEntry : visitCount.entrySet()) {
            finalDomainCount.add(String.valueOf(domainEntry.getValue()).concat(" ").concat(domainEntry.getKey()));
        }

        return finalDomainCount;
    }

    private void updateDomainCount(HashMap<String, Integer> visitCount, String domain, int count) {
        if (visitCount.containsKey(domain)) {
            int currentCount = visitCount.get(domain);
            currentCount += count;
            visitCount.put(domain, currentCount);
        } else {
            visitCount.put(domain, count);
        }
    }

    private String concatSubDomainsToLength(String[] subDomains, int length) {
        StringBuilder domain = new StringBuilder();
        for (int i = 0; i < length + 1; i++) {
            domain.append(subDomains[i]).append(".");
        }

        return domain.reverse().substring(1);
    }
}
