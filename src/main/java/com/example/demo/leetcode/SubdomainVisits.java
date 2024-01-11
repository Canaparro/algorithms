package com.example.demo.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SubdomainVisits {

    public List<String> subdomainVisits(String[] cpdomains) {

        // have a map to store <domain, visits>
        // break the strings on first space to get n.visits + the domain
        // iterate over the domain name breaking it into subdomains by dot one by one and adding it to the map adding the visit count
        // repeat the interaction until no more dots exist in the domain

        Map<String, Integer> domainWithVisitMap = new HashMap<>();

        for (String cpdomain : cpdomains) {
            String[] visitsAndDomain = cpdomain.split(" ", 2);
            int visits = Integer.parseInt(visitsAndDomain[0]);

            // discuss.leetcode.com
            addVisitsTosubDomain(domainWithVisitMap, visits, visitsAndDomain[1]);
        }
        List<String> list = new LinkedList<>();
        for (Map.Entry<String, Integer> entry : domainWithVisitMap.entrySet()) {
            list.add(entry.getValue() + " " + entry.getKey());
        }
        return list;
    }

    private static void addVisitsTosubDomain(Map<String, Integer> domainWithVisitMap, int visits, String domain) {
        domainWithVisitMap.put(domain, domainWithVisitMap.getOrDefault(domain, 0) + visits);
        if(domain.contains(".")) {
            String remainingDomain = domain.substring(domain.indexOf('.') + 1);
            addVisitsTosubDomain(domainWithVisitMap, visits, remainingDomain);
        }
    }
}
