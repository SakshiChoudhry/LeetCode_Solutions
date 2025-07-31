class Solution796 {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()) return false;
        String r=s+s;
        return r.contains(goal);
    }
}