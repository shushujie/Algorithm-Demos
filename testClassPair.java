class Pair {
    int left, right;
    public Pair(int left,int right) {
        this.left = left;
        this.right = right;
    }
}

class Solution {

    public boolean validPalindrome(String s) {
        if (s == null) return false;

        Pair pointerPair = checkPalindrome(s, 0, s.length()-1);
        if (pointerPair.left >= pointerPair.right) return true;


        Pair pointerPair2 = checkPalindrome(s,pointerPair.left+1, pointerPair.right);
        if (pointerPair2.left >= pointerPair2.right) return true;

        pointerPair2 = checkPalindrome(s, pointerPair.left, pointerPair.right-1);
        if (pointerPair2.left >= pointerPair2.right) return true;

        return false;




    }

    private Pair checkPalindrome(String s, int left, int right) {
        while( left < right && s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            }
        return new Pair(left, right);


    }
}