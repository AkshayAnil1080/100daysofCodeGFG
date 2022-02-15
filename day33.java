PS: https://practice.geeksforgeeks.org/problems/anagram-of-string/1#
Anagrams of string

TC:  O(n)
SC: O(26)
class GfG
{
	public int remAnagrams(String s,String s1)
        {
        //add code here.
       int ch[] = new int[26];
        for( int i =0; i<s.length();i++)
        {
            int index= s.charAt(i)-'a';
            ch[index]++;
        }
         for( int i =0; i<s1.length();i++)
        {
            int index= s1.charAt(i)-'a';
            ch[index]--;
        }
        int ans=0;
          for( int i =0; i<26;i++)
          {
              if(ch[i]!=0)
              ans=ans+Math.abs(ch[i]);
          }
          return ans;
        }
}

Input:
S1 = bcadeh
S2 = hea
Output: 3
Explanation: We need to remove b, c
and d from S1.
