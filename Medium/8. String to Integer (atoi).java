class Solution8 {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) return 0;
        int n = s.length();
        int sign = 1;
        int i = 0;
        long sum = 0;

        if (s.charAt(0) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(0) == '+') {
            i++;
        }

        while (i < n) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') break;
            sum = sum * 10 + (s.charAt(i) - '0');

            // Overflow check
            if (sign == 1 && sum > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign == -1 && -sum < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }

        return (int) (sign * sum);
    }
}
