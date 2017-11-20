class MyCalendarTwo {
    List<int[]> list;
    
    public MyCalendarTwo() {
        list = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        int[] is;
        for (int i = 0; i < list.size(); i++) {
            is = list.get(i);
            
            if (Math.max(start, is[0]) < Math.min(end, is[1])) {
                if (checkDoubleBooking(Math.max(start, is[0]), Math.min(end, is[1]), i + 1)) {
                    return false;
                }
            }
        }
        list.add(new int[]{start, end});
        return true;
    }

    public boolean checkDoubleBooking(int start, int end, int startIndex) {
        int[] is;
        for (int i = startIndex; i < list.size(); i++) {
            is = list.get(i);
            if (end <= is[0] || start >= is[1]) {
                continue;
            }
            return true;
        }
        return false;
    }
}


/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
