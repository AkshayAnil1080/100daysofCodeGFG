PS: https://practice.geeksforgeeks.org/problems/find-missing-and-repeating2512/1
5 ways
1. sort and traverse (nlogn)
2. create a temp boolean array, if not present mark true, if already there => repeating ele.
 travere again in temp, if(any arr[i]==false) => i is the missine ele.
TC and SC both O(n)
3. use ele as index and mark the vis places(v.v good thought)
1st traveresal - i got one ele, find its abs just in case ele in negative, need to convert in pos(indexes are from 0-n)
  so, i got an ele, take abs, now check arr[abs-1]>0 , make it -ve =>
  for(i=0; i<n;i++)  // 1 3 3
  {
    int abs = Math.abs(arr[i]);
    if(arr[abs-1]>0) // eg ele is 3, at index 1
    {
      arr[abs-1] = -arr[abs-1]; // -1 3 -3
    }
    else // mtlb that ele is repeating
    print(abs);
  }

  2nd traversal to find missing ele, if (arr[i]>0) print(i+1); // here arr[1]>0 => 2 is missing

  4. Make two equations , let x be missing and y be repeating
  //TC: o(n^2)
use for loop to find calculated SUM and PRODUCT
calculated SUM =  n(n+1)/2 -x+y - >eq 1.
calculated PRODUCT = 1*2*3...n*y/x;  -> eq 2.

two eq and two unknown, solve it.
Disadv -  may cause aithematic overflow we calculate product and sum of all array elements.


5. XOR method, let x be missing and  y be repeating
// TC : O(n)
step1 .xor1 = xor of all elem. - 1st for lopp
        xor1 =  xor1 ^ (ele from 1..N) - 2nd foor loop

step 2
now xor1 = xor of repeating and missing num
xor1=  xor1 & -xor1

step 3
cateogorize (1..N) into two grps
1st grp of num where xor1&num==0 and another group of xor1&num==0
XOR OF NUM FROM EACH SET => REPEATING AND MISSING ?

STEP 4 how to decide which one is which?
for i in loop(1...N)
if(x==i) { x is repeating and y is missing}
if(y==i) { y is repeating and y  is missning}


6, using Hashmap<Integer, Boolean>
// TC : O(n), SC: O(n)
traverse in arr - > if(map.get(arr[i])==null) {map.put(i,true);}
                    else{ print(arr[i])} /// repeating ele

traverse again from 1;<=n
if(map.get(i)==null) => print(i) // missing num

7. Make two eqn using sum and sum of sqaures
// TC:O(N)
S=n(n+1)/2
S_sq = N(n+1)(2n+1)/6  // use BigInteger in Java
for loop from i=1..N
S-=A[i]
S_sq -=(A[i]*A[i])
 => x-y =  S and x^2 - y^2=S_sq   --eq1

 get x+y as = S_sq/S ----eq2

Solve x and y.


I used the 3rd way myself

class Solve {
    int[] findTwoElement(int arr[], int n) {
        // code here
        int ans[] = new int[2];
        boolean ismiss[] = new boolean[n+1];


        for( int i =0; i<n; i++)
        {
            if(ismiss[arr[i]]==false)
            {
                ismiss[arr[i]] = true;
                // continue;
            }
            else
            {
                ans[0]=arr[i];
            }
        }
        for(int i =1;i<n+1;i++)

        {
            if(ismiss[i]==false)
            ans[1]=i;
        }
        return ans;


    }
}
