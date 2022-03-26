package problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem93 {

    public static void main(String[] args) {
        List<String> strings = new Problem93().restoreIpAddresses("101023");
        System.out.println(Arrays.toString(strings.toArray(new String[]{})));
    }

    public List<String> restoreIpAddresses(String s) {
        List<List<String>> partOfIP = findPartOfIP(s, 1);
        return partOfIP.stream()
                .map(t -> String.join(".", t))
                .collect(Collectors.toList());
    }

    //25525511135
    private List<List<String>> findPartOfIP(String s, int currDepth) {
        if (s.isEmpty()) {
            return Collections.emptyList();
        }
        char[] chars = s.toCharArray();
        if (currDepth == 4) {
            if (chars[0] == '0') {
                return chars.length > 1 ? Collections.emptyList() : Arrays.asList(new ArrayList<>() {{
                    add(s);
                }});
            } else {
                if (s.length() > 3) {
                    return Collections.emptyList();
                }
                int i1 = Integer.parseInt(s);
                if (i1 <= 255) {
                    return Collections.singletonList(new ArrayList<>() {{
                        add(s);
                    }});
                }
            }
        }
        if (chars[0] == '0') {
            List<List<String>> partOfIP = findPartOfIP(s.substring(1), currDepth + 1);
            for (List<String> strings : partOfIP) {
                strings.add(0, "0");
            }
            return partOfIP;
        } else {
            List<List<String>> results = new ArrayList<>();
            for (int i = 1; i < chars.length && i < 4; i++) {
                String substring = s.substring(0, i);
                int i1 = Integer.parseInt(substring);
                if (i1 <= 255) {
                    String substring1 = s.substring(i);
                    List<List<String>> partOfIP = findPartOfIP(substring1, currDepth + 1);
                    for (List<String> strings : partOfIP) {
                        strings.add(0, substring);
                    }
                    results.addAll(partOfIP);
                }
            }
            return results;
        }
    }
}
