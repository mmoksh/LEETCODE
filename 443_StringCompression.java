class Solution {
    public int compress(char[] chars) {
        int index = 0, counter = 1;
        char current = chars[0];
        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            if (c == current) {
                counter++;
            } else {
                chars[index++] = current;
                if (counter == 1000) {
                    chars[index++] = '1';
                    chars[index++] = '0';
                    chars[index++] = '0';
                    chars[index++] = '0';
                } else if (counter > 99) {
                    chars[index + 2] = (char)(counter % 10 + '0'); counter /= 10;
                    chars[index + 1] = (char)(counter % 10 + '0'); counter /= 10;
                    chars[index] = (char)(counter + '0');
                    index += 3;
                } else if (counter > 9) {
                    chars[index + 1] = (char)(counter % 10 + '0'); counter /= 10;
                    chars[index] = (char)(counter + '0'); counter = 0;
                    index += 2;
                } else if (counter > 1) {
                    chars[index++] = (char)(counter + '0'); counter = 0;
                }
                current = c;
                counter = 1;
            }
        }
        chars[index++] = current;
        if (counter == 1000) {
            chars[index++] = '1';
            chars[index++] = '0';
            chars[index++] = '0';
            chars[index++] = '0';
        } else if (counter > 99) {
            chars[index + 2] = (char)(counter % 10 + '0'); counter /= 10;
            chars[index + 1] = (char)(counter % 10 + '0'); counter /= 10;
            chars[index] = (char)(counter + '0');
            index += 3;
        } else if (counter > 9) {
            chars[index + 1] = (char)(counter % 10 + '0'); counter /= 10;
            chars[index] = (char)(counter + '0'); counter = 0;
            index += 2;
        } else if (counter > 1) {
            chars[index++] = (char)(counter + '0'); counter = 0;
        }
        return index;
    }
}
