/**
 * http://oj.leetcode.com/submissions/detail/6564778/
 * 
 * @author yishen
 *
 */
public class ReverseWordsInAString {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(new ReverseWordsInAString().reverseWords("a"));
        System.out.println(new ReverseWordsInAString().reverseWords("a "));
        System.out.println(new ReverseWordsInAString().reverseWords(" a"));
        System.out.println(new ReverseWordsInAString().reverseWords(" a "));
        System.out.println(new ReverseWordsInAString().reverseWords(" a a   a "));
    }

    public String reverseWords(String s) {
        if (s == null || s.length() == 0)
            return s;

        char[] c = s.toCharArray();
        // reverse the whole array
        reverse(c, 0, c.length);

        int low = 0;
        int hi = c.length - 1;
        while (low <= hi) {
            if (c[low] == ' ') {
                low++;
            } else {
                break;
            }
        }
        while (low <= hi) {
            if (c[hi] == ' ') {
                hi--;
            } else {
                break;
            }
        }

        // now low and hi all point to non-empty character
        if (low > hi) {
            return "";
        }

        // indicate where to copy the characters to
        int pos = 0;
        while (low <= hi) {
            int i = low;
            // found the next space
            while (i <= hi && c[i] != ' ') {
                i++;
            }
            // reverse the word
            reverse(c, low, i);
            // copy the result
            while (low < i) {
                c[pos++] = c[low++];
            }

            // add delimiter space
            if (low <= hi) {
                c[pos++] = ' ';
            }
            // found next non-empty character
            while (low <= hi && c[low] == ' ') {
                low++;
            }
        }

        return new String(c, 0, pos);
    }

    public void reverse(char[] s, int i, int j) {
        if (s == null || s.length == 0 || i >= j) {
            return;
        }

        int low = i;
        int hi = j - 1;
        while (low <= hi) {
            char temp = s[low];
            s[low] = s[hi];
            s[hi] = temp;
            low++;
            hi--;
        }
    }

}
