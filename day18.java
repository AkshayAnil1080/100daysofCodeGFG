// spiral matrix


class Solution
{

	public int findK(int arr[][], int r, int c, int k)
	{
	    // Your code goes here
	   ArrayList<Integer> al  = new ArrayList<>();
	   int top=0, left=0, bottom =r-1, right =c-1;
	   while(top<=bottom && left<=right)
	   {
    	   for( int i =left; i<=right; i++)
    	   {
    	       al.add(arr[top][i]);
    	   }
    	   top++;
    	   for( int i =top; i<=bottom; i++)
    	   {
    	       al.add(arr[i][right]);

    	   }
    	    right--;
    	   if(top<=bottom){
        	   for( int i =right; i>=left; i--)
        	   {
        	       al.add(arr[bottom][i]);

        	   }
        	   bottom--;
    	   }
    	   if(left<=right)
        	  { for( int i =bottom; i>=top; i--)
        	   {
        	       al.add(arr[i][left]);

        	   }
        	     left++;

        	  }
	   }
	   return al.get(k-1);
	}

}
