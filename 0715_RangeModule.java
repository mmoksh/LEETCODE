import java.util.*;
class RangeModule {
    ArrayList<int[]> list = new ArrayList<>();
    
    public RangeModule() {
        
    }
    
    public void addRange(int left, int right) {
        int s, e;
        for (int i = 0; i < list.size(); i++) {
            s = list.get(i)[0];
            e = list.get(i)[1];
            if (left <= s && right >= e) {
                list.get(i)[0] = left;
                list.get(i)[1] = right;
                return;
            } else if (left >= s && right <= e) {
                return;
            } else if (right < s || left > e) {
            } else if (right <= e) {
                list.get(i)[0] = left;
                return;
            } else {
                list.get(i)[1] = right;
                return;
            }
        }
        list.add(new int[]{left, right});
    }
    
    public boolean queryRange(int left, int right) {
        int s, e;
        for (int i = 0; i < list.size(); i++) {
            s = list.get(i)[0];
            e = list.get(i)[1];
            if (right < s || left > e) {
            } else if (left <= s && right >= e) {
                return queryRange(left, s) && queryRange(e, right);
            } else if (left >= s && right <= e) {
                return true;
            } else if (right < e) {
                right = s;
            } else {
                left = e;
            }
        }
        return false;
    }
    
    public void removeRange(int left, int right) {
        int s, e;
        for (int i = 0; i < list.size(); i++) {
            s = list.get(i)[0];
            e = list.get(i)[1];
            if (right <= s || left >= e) {
            } else if (left <= s && right >= e) {
                list.remove(i);
                i--;
            } else if (left > s && right < e) {
                list.get(i)[1] = left;
                list.add(new int[]{right, e});
            } else if (right < e) {
                list.get(i)[0] = right;
            } else {
                list.get(i)[1] = left;
            }
        }
    }
}


/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */
