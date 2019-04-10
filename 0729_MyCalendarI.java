class MyCalendar {
    List<int[]> list;
    public MyCalendar() {
        list = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        int count = 0;
        for (int[] is : list) {
            if (end <= is[0] || start >= is[1]) {
                continue;
            }
            return false;
        }
        list.add(new int[] {start, end});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
