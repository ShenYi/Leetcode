import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/palindrome-partitioning/
 * 
 * @author yishen
 * 
 */
public class PalindromePartitioning {
    private List<List<String>> result;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        PalindromePartitioning instance = new PalindromePartitioning();
        // System.out.println(instance.partition1("aaba"));
        long t = System.currentTimeMillis();

        System.out
                .println(instance
                        .partition("ltsqjodzeriqdtyewsr"
                                + "pfscozbyrpidadvsmlylqrviu"
                                + "qiynbscgmhulkvdzdicgdwvquigoep"
                                + "iwxjlydogpxdfiowhofhweuiohfuiowewofiweiofjiowehjfiowhiofhiowehjfiowehjiofhiowehfiohweuiorcoiwecroiweruofhywioehfiowehjfiowefwahyfhdnljshgjeprsvg"
                                + "ctgnfgqtnfsqizonirdtcvbl"
                                + "ehcwbzedsmrxtjsipkyxk"));
        System.out.println(instance.result.size());
        t = System.currentTimeMillis() - t;
        // System.out.println(t);
    }

    public List<List<String>> partition1(String s) {
        result = new ArrayList<List<String>>();
        dfs(s, new ArrayList<String>());
        return result;
    }

    public void dfs(String s, List<String> temp) {
        if (s.length() == 0) {
            result.add(new ArrayList<>(temp));
        }
        for (int i = 0; i < s.length(); i++) {
            final String sub = s.substring(0, i + 1);

            if (isPalindrome(sub)) {
                temp.add(sub);
                dfs(s.substring(i + 1), temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {

        if (s == null || s.length() == 0) {
            return null;
        }

        result = new ArrayList<List<String>>();

        List<String> firstElement = new ArrayList<>();
        firstElement.add(Character.toString(s.charAt(0)));
        result.add(firstElement);

        for (int i = 1; i < s.length(); i++) {
            result = constructNext(result, String.valueOf(s.charAt(i)));
        }

        Iterator<List<String>> it = result.iterator();
        while (it.hasNext()) {
            List<String> current = it.next();
            if (!isPalindrome(current.get(current.size() - 1))) {
                it.remove();
            }
        }

        return result;
    }

    public List<List<String>> constructNext(List<List<String>> prev, String c) {
        List<List<String>> result = new ArrayList<List<String>>();
        Iterator<List<String>> it = prev.iterator();
        while (it.hasNext()) {
            List<String> current = it.next();
            List<String> temp1 = new ArrayList<String>();
            List<String> temp2 = new ArrayList<String>();

            if (isPalindrome(current.get(current.size() - 1))) {
                temp1.addAll(current);
                temp1.add(c);
                result.add(temp1);
            }
            if (current.size() > 1) {
                temp2.addAll(current.subList(0, current.size() - 1));
            }
            temp2.add(current.get(current.size() - 1) + c);
            result.add(temp2);
        }

        return result;
    }

    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }

        return true;
    }
}
