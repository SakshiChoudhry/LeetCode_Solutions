import java.util.TreeMap;

class Solution846 {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) {
            return false;
        }

        TreeMap<Integer, Integer> m = new TreeMap<>();
        for (int card : hand) {
            m.put(card, m.getOrDefault(card, 0) + 1);
        }

        while (!m.isEmpty()) {
            int start = m.firstKey(); // smallest available card
            for (int i = 0; i < groupSize; i++) {
                int curr = start + i;
                if (!m.containsKey(curr)) {
                    return false;  // missing a needed card
                }
                m.put(curr, m.get(curr) - 1);
                if (m.get(curr) == 0) {
                    m.remove(curr);
                }
            }
        }
        return true;
    }
}
