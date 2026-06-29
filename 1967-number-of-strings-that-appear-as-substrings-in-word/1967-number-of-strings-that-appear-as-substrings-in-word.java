class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int cnt = 0;
        for(String s : patterns )
            if(word.indexOf(s) != -1) cnt ++;
            return cnt;
        }
}