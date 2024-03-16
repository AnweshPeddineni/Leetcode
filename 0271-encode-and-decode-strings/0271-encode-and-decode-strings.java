public class Codec {

    public String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();
        for (String s : strs) {
            encodedString.append(s.replace("/", "//")).append("/:");
        }

        return encodedString.toString();
    }

  
    public List<String> decode(String s) {
        List<String> decodedStrings = new ArrayList<>();
        StringBuilder currentString = new StringBuilder();
        int i = 0;
        
        while (i < s.length()) {
         
            if (i + 1 < s.length() && s.charAt(i) == '/' && s.charAt(i + 1) == ':') {
                decodedStrings.add(currentString.toString());
                currentString = new StringBuilder();
                i += 2;
            }
            else if (i + 1 < s.length() && s.charAt(i) == '/' && s.charAt(i + 1) == '/') {
                currentString.append('/');
                i += 2;
            }
          
            else {
                currentString.append(s.charAt(i));
                i++;
            }
        }

        return decodedStrings;
    }
}