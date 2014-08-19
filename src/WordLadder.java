import java.util.*;

/**
 * http://oj.leetcode.com/problems/word-ladder/
 * 
 * @author yishen
 *
 */
public class WordLadder {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        HashSet<String> a = new HashSet<String>();
        a.addAll(Arrays.asList("hot", "dot", "dog", "lot", "log"));
        System.out.println(ladderLength2("hit", "cog", a));
    }

    public static int ladderLength2(String start, String end,
            HashSet<String> dict) {
        // return when not valid input
        if (start == null || end == null) {
            return 0;
        }
        int d = diff(start, end);
        // return when direct path exists
        if (d == 0 || d == 1) {
            return 2;
        }
        // return when not ladder
        if (dict == null || dict.size() == 0) {
            return 0;
        }

        Queue<String> q = new LinkedList<String>();
        q.add(start);
        Map<String, Integer> dist = new HashMap<String, Integer>();
        dist.put(start, 1);

        while (!q.isEmpty()) {
            String cur = q.poll();
            char[] m = cur.toCharArray();
            int curDist = dist.get(cur);
            for (int i = 0; i < m.length; i++) {
                for (char j = 'a'; j <= 'z'; j++) {
                    if (j == m[i])
                        continue;
                    m[i] = j;
                    String mm = new String(m);
                    if (end.equals(mm))
                        return curDist + 1;
                    if (dict.contains(mm) && !dist.containsKey(mm)) {
                        dist.put(mm, curDist + 1);
                        q.add(mm);
                    }
                }
                m[i] = cur.charAt(i);
            }
        }

        return 0;
    }

    @SuppressWarnings("unused")
    public static int ladderLength(String start, String end,
            HashSet<String> dict) {
        // return when not valid input
        if (start == null || end == null) {
            return 0;
        }
        int d = diff(start, end);
        // return when direct path exists
        if (d == 0 || d == 1) {
            return 1;
        }
        // return when not ladder
        if (dict == null || dict.size() == 0) {
            return 0;
        }

        String[] dd = dict.toArray(new String[dict.size()]);
        int[] dist = new int[dd.length];
        // mark all valid elements
        for (int i = 0; i < dist.length; i++) {
            d = diff(start, dd[i]);
            if (d == 1) {
                dist[i] = 1;
                if (diff(end, dd[i]) == 1) {
                    return 3;
                }
            } else if (d != 0) {
                // valid for next loop
                dist[i] = -1;
            }
        }

        int curLength = 1;
        while (curLength <= dist.length + 3) {
            for (int i = 0; i < dist.length; i++) {
                if (dist[i] == curLength) {
                    for (int j = 0; j < dist.length; j++) {
                        if (j != i && dist[j] == -1) {
                            d = diff(dd[i], dd[j]);

                            if (d == 1) {
                                dist[j] = curLength + 1;
                                if (diff(end, dd[j]) == 1) {
                                    return curLength + 3;
                                }
                            }
                        }
                    }
                }
            }
            curLength++;
        }

        return 0;
    }

    public static int diff(String s1, String s2) {
        int j = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                j++;
            }
        }
        return j;
    }

}
