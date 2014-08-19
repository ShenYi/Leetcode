public class InterleavingString {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        InterleavingString instance = new InterleavingString();
        System.out.println(instance.isInterleave(
                "abbbbbbcabbacaacccababaabcccabcacbcaabbbacccaaaaaababbbacbb",
                "ccaacabbacaccacababbbbabbcacccacccccaabaababacbbacabbbbabc",
                "cacbabbacbbbabcbaacbbaccacaacaacccabababbbababcccbabcabbaccabcccacccaabbcbcaccccaaaaabaaaaababbbbacbbabacbbacabbbbabc"));
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s1.length() == 0) {
            if (s2 == null && s3 == null) {
                return true;
            } else if (s2.equals(s3)) {
                return true;
            } else {
                return false;
            }
        } else if (s2 == null || s2.length() == 0) {
            if (s1.equals(s3)) {
                return true;
            } else {
                return false;
            }
        } else if (s3 == null || s3.length() == 0) {
            return false;
        } else if ((s1.length() + s2.length()) == s3.length()) {
            boolean bs1 = (s1.charAt(0) == s3.charAt(0)) && isInterleave(s1.substring(1), s2, s3.substring(1));
            boolean bs2 = (s2.charAt(0) == s3.charAt(0)) && isInterleave(s1, s2.substring(1), s3.substring(1));
            return bs1 || bs2;
        }

        return false;
    }
}
