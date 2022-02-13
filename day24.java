wAll Unique Permutations of an Arrays
https://practice.geeksforgeeks.org/problems/all-unique-permutations-of-an-array/1

Given an array arr[] of length n. Find all possible unique permutations of the array.


Example 1:

Input:
n = 3
arr[] = {1, 2, 1}
Output:
1 1 2
1 2 1
2 1 1
Explanation:
These are the only possible unique permutations
for the given array.

code link: https://practice.geeksforgeeks.org/viewSol.php?subId=262b000cae2149b24bfb6044a3d6d86e&pid=707348&user=akshayanil

class Solution {
   static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr , int n)
   {
       // code here
       Collections.sort(arr);
       ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();

       permute(arr,0,n-1,res);

       Collections.sort(res, new Comparator<ArrayList<Integer>>() {
       @Override
       public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
           //return o1.get(0).compareTo(o2.get(0));
           int k=0;
           while(o1.get(k)==o2.get(k))
           k++;
           return o1.get(k).compareTo(o2.get(k));
       }
       });
       return res;
   }
   public static void permute(ArrayList<Integer> arr ,int cur,int n,ArrayList<ArrayList<Integer>> res)
   {
      // System.out.println(arr);
       if(cur==n)
       {
           //System.out.println(arr);
           ArrayList<Integer> temp=new ArrayList<>(arr);
           //hs.add(temp);
           res.add(temp);
           return;
       }
       HashSet<Integer> hset=new HashSet<>();
       for(int i=cur;i<=n;i++)
       {
           //System.out.print(i+" ");
           swap(arr,cur,i);
           //String str=Arrays.toString(arr.toArray());

           if(!hset.contains(arr.get(cur)))
           {
               hset.add(arr.get(cur));
               permute(arr,cur+1,n,res);
           }
           swap(arr,cur,i);
       }
       //System.out.println(hset+" HSET");
       hset.clear();
       return;
   }
   public static void swap(ArrayList<Integer> arr,int i,int j)
   {
       int temp=arr.get(i);
       arr.set(i,arr.get(j));
       arr.set(j,temp);
       return;
   }
};
