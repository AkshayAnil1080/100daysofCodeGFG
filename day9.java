
https://practice.geeksforgeeks.org/problems/2caf0501a39567d653197364a2b5c8a9f5943b7e/1#
class Solution{
    static int candies(int m, int n)
    {
        // Your code goes here

        int max = Math.max(m,n);
        int min = Math.min(m,n);

        if(max%2==0)
        {
            return ((max-1)*(min/2));
        }
        else
        return ((min-1)*(max/2));
    }
}
