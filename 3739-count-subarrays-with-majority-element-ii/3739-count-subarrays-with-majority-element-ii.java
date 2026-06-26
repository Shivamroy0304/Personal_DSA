class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int num = nums.length;
        int preq = num;

        int[] freq = new int[2*num + 1];
        freq[num] = 1;

        long less = 0;
        long ans = 0;



        for(int number : nums){
            if(number == target){
                less += freq[preq];
                preq++;
            } else {
                preq--;
                less -= freq[preq];
            }

            freq[preq]++;
            ans += less;

        }
        return ans;
        
    }

}