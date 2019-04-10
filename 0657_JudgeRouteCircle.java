class Solution {
    public boolean judgeCircle(String moves) {
        int LR = 0, UD = 0;
        char c;
        for (int i = 0; i < moves.length(); i++) {
            c = moves.charAt(i);
            switch (c) {
                case 'L':
                    LR--;
                    break;
                case 'R':
                    LR++;
                    break;
                case 'U':
                    UD--;
                    break;
                case 'D':
                    UD++;
            }
        }
        return LR == 0 && UD == 0;
    }
}
