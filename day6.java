// https://practice.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1#

class Solution {

    int search(String pat, String txt) {
        // code here

        //1. calculate unquie hash for substring
        //2. do the comparsion - sliding window
        // O(txt.length())
        int res =0;
        if(txt.length() < pat.length())
        return 0;

        int h1 =0;
        for( int i =0; i<pat.length();i++)
        {
            int a = (int)(pat.charAt(i)-'a');
            h1 += a*(int)Math.pow(2,a);
        }
         int h2 =0;
          for( int i =0; i<pat.length();i++)
        {
            int b = (int)(txt.charAt(i)-'a');
            h2 += b*(int)Math.pow(2,b);
        }
        if(h1==h2)
        res=1;

        for( int i =pat.length(); i<txt.length(); i++)
        {
            int a = (int)(txt.charAt(i)-'a');
             h2 += a*(int)Math.pow(2,a);  //updating with next ch of window
            int b= (int) (txt.charAt(i-pat.length())-'a'); // removing the first ch of prev window
            h2 -= b*(int)Math.pow(2,b);

            if(h1==h2)
            res++;
        }
        return res;


    }

}
