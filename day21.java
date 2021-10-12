// count triplets with sum smaller than X.
two pointer algo, 


class Solution
{
    long countTriplets(long arr[], int n,int sum)
    {
        Arrays.sort(arr);

        long ans =0;
        for( int i =0; i <n-2; i++)
        {
            int j=i+1; int k=n-1;
            while(j<k)
            {
                if(arr[i]+arr[j]+arr[k]>=sum)
                k--;

                else
                {
                    ans += (k-j); // for every poss i and j , therw will be k-j possible triplets
                    j++;
                }
            }
        }

        return ans;
    }
}
