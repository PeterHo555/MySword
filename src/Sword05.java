public class Sword05 {
    public String replaceSpace(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.toString();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ')
                stringBuffer.append("%20");
            else
                stringBuffer.append(s.charAt(i));
        }
        return stringBuffer.toString();
    }
}
