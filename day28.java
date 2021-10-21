
maximu are in histogram
//1. store left smaller position
//2. store right smaller position
//3 one loop to update max differecne of value at i th pos in each arrays
TC :  O(3n)
SC : O(2n)

class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long hist[], long n)
    {
        long maxAns = 0;
        int ps[] = previousSmaller(hist); //1.
        int ns[] = nextSmaller(hist);   //2.
        for(int i=0; i<hist.length; i++){ //3.
            long cur = ((ns[i]-ps[i])-1)*hist[i];
            maxAns = Math.max(cur,maxAns);
        }
        return maxAns;
    }
    public static int[] previousSmaller(long hist[]){
        int[] ps = new int[hist.length];
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<hist.length; i++){
            while(!s.isEmpty() && hist[s.peek()] >= hist[i]){
                s.pop();
            }
            if(s.isEmpty()){
                ps[i] = -1;
            }else{
                ps[i] = s.peek();
            }
            s.push(i);
        }
        return ps;
    }
    public static int[] nextSmaller(long hist[]){
        int[] ns = new int[hist.length];
        Stack<Integer> s = new Stack<>();
        for(int i=hist.length-1; i>=0; i--){
            while(!s.isEmpty() && hist[s.peek()] >= hist[i]){
                s.pop();
            }
            if(s.isEmpty()){
                ns[i] = hist.length;
            }else{
                ns[i] = s.peek();
            }
            s.push(i);
        }
        return ns;


    }

}
