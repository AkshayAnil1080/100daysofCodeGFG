Count distinct elements in every window
https://practice.geeksforgeeks.org/problems/count-distinct-elements-in-every-window/1#
Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

idea:
s


class Solution
{
    ArrayList<Integer> countDistinct(int A[], int n, int B)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> al  = new ArrayList<>();
        // int ind =0;
        for(int i=0; i<B;i++)
        {
            map.put(A[i], map.getOrDefault(A[i],0)+1);
        }
        // ans[ind++]=map.size();
        al.add(map.size());

        for( int i=B; i<A.length; i++)
        {
            map.replace(A[i-B],map.get(A[i-B])-1);  // decrease the ferq of A[i-B] , and if becomes 0 remove it from map;
            if(map.get(A[i-B])==0)
            map.remove(A[i-B]);

             map.put(A[i], map.getOrDefault(A[i],0)+1);  // add the new ele

            al.add(map.size());
        }
        return al;
    }
}
