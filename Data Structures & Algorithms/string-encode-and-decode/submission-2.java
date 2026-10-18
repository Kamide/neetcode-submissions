class Solution {
    public String encode(List<String> strs) {
        var sb = new StringBuilder();

        for (var str : strs) {
            var length = str.length();

            sb.append((char) (length >>> 24));
            sb.append((char) (length >>> 16 & 0xff));
            sb.append((char) (length >>> 8 & 0xff));
            sb.append((char) (length & 0xff));

            sb.append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        var strs = new ArrayList<String>();

        for (var index = 0; index < str.length(); ) {
            var length = (str.charAt(index) << 24)
                | (str.charAt(index + 1) << 16)
                | (str.charAt(index + 2) << 8)
                | (str.charAt(index + 3));

            index += 4;

            strs.add(str.substring(index, index + length));

            index += length;
        }

        return strs;
    }
}
