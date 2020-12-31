class Solution {
    public String reformatNumber(String number) {
        number = number.replace(" ", "").replace("-", "");
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (; i < number.length() - 4; i+=3) {
            sb.append(number.substring(i, i + 3)).append('-');
        }
        switch (number.length() - i) {
            case 2:
            case 3:
                sb.append(number.substring(i));
                break;
            case 4:
                sb.append(number.substring(i, i + 2)).append('-').append(number.substring(i + 2));
        }
        return sb.toString();
    }
}
