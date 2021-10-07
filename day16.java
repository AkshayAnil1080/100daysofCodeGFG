elixir of life
https://practice.geeksforgeeks.org/problems/20290dc4188d384ae1f17d6a14bd2c95ea7012a8/1#
class Sol
{
    int maxFrequency(String S)
    {
    	//code here.
    	//1. checking the smallest prefix == suffix
    	String s1="", s2="";
    	for( int i =0, j=S.length()-1; i<j; i++, j--)
        {
            s1 += S.charAt(i);
            s2 = S.charAt(j)+s2;
            if(s1.equals(s2))
            {
                break;
            }
        }
        if( s1.equals(s2)==false || S.length()==1)  // traversed the whole string but mila sirf 1 length ka aisa string
        return 1;

        return funcount(S, s1); // 2. count the frequency of this resultant string
    }
  int  funcount(String S, String s1)
    {
        int ans =0;
        String curr="";
        for( int i =0; i<=S.length()-s1.length(); i++)
        {
            curr = S.substring(i,s1.length()+i);
            if(curr.equals(s1))
            ans++;
        }
        return ans;
    }
}
tc : O(S.length())
Sc : O(S.length())
