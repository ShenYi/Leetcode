import java.util.*;

public class PalindromePartitioningII {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        PalindromePartitioningII instance = new PalindromePartitioningII();
        long t = System.currentTimeMillis();

        System.out.println(instance.minCut("ccaacabacb"));
        t = System.currentTimeMillis() - t;
        // System.out.println(t);
    }

    public int minCut(String s) {
        int strLen = s.length();
        boolean[][] pa = new boolean[strLen][strLen];

        Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();

        for (int i = strLen - 1; i >= 0; i--) {
            List<Integer> adj = new ArrayList<Integer>();

            for (int j = i; j < strLen; j++) {
                boolean b = false;
                if (i == j) {
                    b = true;
                } else if (i + 1 == j) {
                    b = (s.charAt(i) == s.charAt(j));
                } else {
                    b = pa[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
                }
                if (b) {
                    adj.add(j);
                }
                pa[i][j] = b;
            }
            graph.put(i, adj);
        }

        Integer[] dist = new Integer[strLen];
        Queue<Integer> q = new LinkedList<Integer>();
        dist[0] = 0;
        q.add(0);

        while (!q.isEmpty()) {
            int a = q.poll();
            for (int b : graph.get(a)) {
                if (b == strLen - 1) {
                    return dist[a];
                }
                if (dist[b] == null) {
                    dist[b] = dist[a];
                }
                if (dist[b + 1] == null) {
                    dist[b + 1] = dist[a] + 1;
                    q.add(b + 1);
                }
            }
        }

        return strLen - 1;
    }

}
