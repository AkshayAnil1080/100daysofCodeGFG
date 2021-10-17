Minimum operations to convert array A to B
https://practice.geeksforgeeks.org/problems/minimum-insertions-to-make-two-arrays-equal/1#


/// idea to convert one string a to another, find longestcs and return m-l + n-1;
// here recursive and dp memo , we know,   here need to solve in nlogn(given Array B[] is sorted and all its elements are distinct.) , thats it.


Expected Time Complexity: O(NlogN)
Expected Auxiliary Space: O(N)

//User function Template for Java

// class Solution {
//     static int minInsAndDel(int[] A, int[] B, int M, int N) {
//         // code here
//         Arrays.sort(A);
//         String str1 =""; String str2="";
//         for( int i=0; i<M;i++)
//         {
//             str1 =  str1 + String.valueOf(A[i]);
//         }
//         for( int i=0; i<N;i++)
//         {
//             str2 =  str2 + String.valueOf(B[i]);
//         }
//         int res = lcs(M, N, str1, str2);
//         return (M+N-2*res);

//     }

//      static int lcs(int m, int n, String s1, String s2)
//     {
//         // your code here

//         int dp[][] = new int[m+1][n+1];

//         for( int i = 0; i<=m; i++)  // first row 0; comparing with empty string
//         dp[i][0] =0;

//          for( int i = 0; i<=n; i++)
//         dp[0][i] =0;                // first column 0; comparing with empty string

//         for( int i =1 ; i<=m ;i++)
//         {
//             for( int j =1; j<=n;j++)
//             {
//                 if( s1.charAt(i-1)==s2.charAt(j-1) )
//                     dp[i][j] = 1+dp[i-1][j-1];

//                 else
//                     dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
//             }
//         }

//         return dp[m][n];
//     }
// };
/// idea to convert one string a to another, find longestcs and return m-l + n-1;
// here recursive and dp memo , we know,   here need to solve in nlogn(given Array B[] is sorted and all its elements are distinct.) , thats it.
class Solution {
   static int minInsAndDel(int[] A, int[] B, int N, int M) {
       // code here
       List<Integer> a = new ArrayList<>();
       Set<Integer> set = new HashSet<>();
       for(int i=0;i<M;i++)
       {
           set.add(B[i]);
       }
       for(int i=0;i<N;i++){
           if(set.contains(A[i]) ){
               a.add(A[i]);    // arraylist // 1 5 3 1
           }
       }
    //   System.out.println(a);
    //   int ans[]= new int[a.size()];
       int l = LIS(a.stream().mapToInt(Integer::intValue).toArray()); // converting arraylist to array ans passing to lcs fun
    //   ans = a.stream().mapToInt(Integer::intValue).toArray();
    //   for( int i =0;i<ans.length; i++)
    //   System.out.println(ans[i]);

       return N-l+M-l;
   }
     static int LIS(int arr[]) {
       if (arr.length == 0) {
           return 0;

       }
       int[] tail = new int[arr.length];
       int len = 1;
       tail[0] = arr[0];

       for (int i = 1; i < arr.length; i++) {
           if (arr[i] > tail[len - 1]) {
               tail[len++] = arr[i];
           } else {
               int id = Arrays.binarySearch(tail, 0, len-1, arr[i]); // returns the index , if not poss,returns -length of arr
               if (id < 0) {
                   id = -1*id - 1;
               }
               tail[id] = arr[i];
           }
       }
       return len;
   }
};
