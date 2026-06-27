class Solution {
    public int maximumLength(int[] nums) {
        Map<Long, Integer> freq = new HashMap<>();
        for (int n : nums) freq.merge((long) n, 1, Integer::sum);

        int one = freq.getOrDefault(1L, 0);
        int res = (one - 1) | 1;
        freq.remove(1L);

        for (long f : freq.keySet()) {
            int len = 0;
            long x = f;
            while (freq.containsKey(x) && freq.get(x) > 1) 
            {
                len += 2;
                x = (long) Math.pow(x, 2);
            }

            int has = 0;
            if (freq.containsKey(x)) has = 1;
            res = Math.max(res, len + ((has << 1) - 1));
        }

        return res;
    }
}