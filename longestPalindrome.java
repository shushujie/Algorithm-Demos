class Solution {
    public String longestPalindrome(String s) {
        if (s == null) return "";
        String odd = longest(s,0);
        String even = longest(s,1);

        return (odd.length() >= even.length() )? odd : even;

    }
    // even can only be 0 or 1;
    private String longest(String s, int even) {

        if (even != 0 && even !=1) return "";
        //System.out.println("To deal with s with length of: "+ s.length());

        int longest = 0;
        String longPalindrome = "";
        for (int i = 0; i < s.length() ; i++) {
            int left = i, right = i + even;//distinguish odd and even cases
            while (left >= 0 && right < s.length()) {
                if(s.charAt(left) == s.charAt(right)) {
                    left--;
                    right++;
                }

                else break;
            }
            System.out.println("now the length is: "+(right - left -1));

            if (longest < right - left -1) {
                longest = right - left -1;
                longPalindrome = s.substring(left + 1, right);
                System.out.println(s.substring(left + 1, right));
            }
        }

        return longPalindrome;


    }




}
