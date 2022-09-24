package array.P721_AccountsMerge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> parents = new HashMap<>();
        Map<String, String> owners = new HashMap<>();
        Map<String, TreeSet<String>> unions = new HashMap<>();
        
        for (List<String> a: accounts) {
            for (int i = 0; i < a.size(); i++) {
                parents.put(a.get(i), a.get(i)); // email -> email
                owners.put(a.get(i), a.get(0)); // email -> name
            }
        }
        
        for (List<String> a: accounts) {
            String p = find(a.get(1), parents); // find parent
            for (int i = 1; i < a.size(); i++) {
                parents.put(find(a.get(i), parents), p); // assign it as parent of the ith email
            }
        }
        
        for (List<String> a: accounts) {
            String p = find(a.get(1), parents);
            unions.putIfAbsent(p, new TreeSet<>());
            for (int i = 1; i < a.size(); i++) {
                unions.get(p).add(a.get(i));
            }
        }
        
        List<List<String>> res = new ArrayList<>();
        
        for (String p: unions.keySet()) {
            List<String> a = new ArrayList<>(unions.get(p));
            a.add(0, owners.get(p));
            res.add(a);
        }
        
        return res;
    }
    
    private String find(String s, Map<String, String> parents) {
        return parents.get(s) == s ? s : find(parents.get(s), parents);
    }
}

// use simple union find
// consider a root email for each account
// build email's parent relationship graph in parents Map; use find to find paretn for each email
// owners Map stores the name for each email
// build unions Map by iterating on accounts; finding root account's parent to add emails to it
