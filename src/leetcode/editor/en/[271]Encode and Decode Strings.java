//Design an algorithm to encode a list of strings to a string. The encoded strin
//g is then sent over the network and is decoded back to the original list of stri
//ngs. 
//
// Machine 1 (sender) has the function: 
//
// 
//string encode(vector<string> strs) {
//  // ... your code
//  return encoded_string;
//} 
//Machine 2 (receiver) has the function:
//
// 
//vector<string> decode(string s) {
//  //... your code
//  return strs;
//}
// 
//
// So Machine 1 does: 
//
// 
//string encoded_string = encode(strs);
// 
//
// and Machine 2 does: 
//
// 
//vector<string> strs2 = decode(encoded_string);
// 
//
// strs2 in Machine 2 should be the same as strs in Machine 1. 
//
// Implement the encode and decode methods. 
//
// 
//
// Note: 
//
// 
// The string may contain any possible characters out of 256 valid ascii charact
//ers. Your algorithm should be generalized enough to work on any possible charact
//ers. 
// Do not use class member/global/static variables to store states. Your encode 
//and decode algorithms should be stateless. 
// Do not rely on any library method such as eval or serialize methods. You shou
//ld implement your own encode/decode algorithm. 
// 
// Related Topics String


//leetcode submit region begin(Prohibit modification and deletion)
public class Codec {

    private String lenToStr(String s) {
        int len = s.length();
        int mask = 0xff;
        char[] bytes = new char[4];
        for (int i = 3; i >= 0; i--) {
            bytes[3 - i] = (char) (len >> (i * 8) & mask);
        }
        return new String(bytes);
    }
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            String header = lenToStr(str);
            sb.append(header);
            sb.append(str);
        }
        return sb.toString();
    }

    private int strToLen(String header) {
        int len = 0;
        int result = 0;
        for (char c : header.toCharArray()) {
            result = (result << 8) + (int) c;
        }
        return result;
    }
    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> ret = new LinkedList<>();
        int start = 0;
        int end = s.length();
        while (start < end) {
            String header = s.substring(start, start+4);
            int len = strToLen(header);
            ret.add(s.substring(start+4, start + 4 + len));
            start += 4 + len;
        }

        return ret;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
//leetcode submit region end(Prohibit modification and deletion)
