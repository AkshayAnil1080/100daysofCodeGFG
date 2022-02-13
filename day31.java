Link https://practice.geeksforgeeks.org/problems/largest-value-in-each-level/1#

// idea: use level order traversal
// TC: O(n)
// SC: O(width)

class Solution
{
    public ArrayList<Integer> largestValues(Node root)
    {
        //code here
        ArrayList<Integer> al = new ArrayList<>();

        Queue<Node> q=  new LinkedList<>();
        if(root==null)
        return al;

        q.add(root);


        while(!q.isEmpty())
        {
            int count = q.size();
            int max = Integer.MIN_VALUE;

            for( int i =0; i<count;i++)
            {
                // int max = q.peek();
                Node curr=q.poll();
                max = Math.max(curr.data, max);

                if(curr.left!=null)
                {
                q.add(curr.left);
                }

                if(curr.right!=null)
                {
                    q.add(curr.right);
                }
            }
            al.add(max);
        }
        return al;

    }
}
