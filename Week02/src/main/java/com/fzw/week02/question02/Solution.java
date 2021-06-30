package com.fzw.week02.question02;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author fzw
 * @description 811. 子域名访问计数
 * @date 2021-06-30
 **/
public class Solution {

    private Map<String, Integer> map = new HashMap<>();

    public List<String> subdomainVisits(String[] cpdomains) {
        for (String cpdomain : cpdomains) {
            String[] split = cpdomain.split(" ");
            Integer time = Integer.valueOf(split[0]);
            String[] domains = split[1].split("\\.");
            String domain = null;
            for (int i = domains.length - 1; i >= 0; i--) {
                if (domain == null) {
                    domain = domains[i];
                } else {
                    domain = domains[i] + "." + domain;
                }
                if (map.containsKey(domain)) {
                    map.put(domain, map.get(domain) + time);
                } else {
                    map.put(domain, time);
                }
            }
        }
        return map.entrySet().stream().map(entry -> entry.getValue() + " " + entry.getKey()).collect(Collectors.toList());
    }

}
