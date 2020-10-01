import java.util.HashMap;
import java.util.Map;

public class Sword50 {
    public char firstUniqChar(String s) {
        if (s == null)
            return ' ';
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            // getOrDefault意思就是当Map集合中有这个key时，就使用这个key值，如果没有就使用默认值defaultValue
            // 此处存入的是每个元素出现的次数
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // 按照字符出现顺序，查找出现近一次的字符。用foreach 顺序不对
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1)
                return s.charAt(i);
        }
        return ' ';
    }
}
