public class Sword58_2 {
    public String reverseLeftWords(String s, int n) {
        StringBuilder ans = new StringBuilder();
        ans.append(s.substring(n, s.length()));
        ans.append(s.substring(0, n));
        return ans.toString();
    }
}
