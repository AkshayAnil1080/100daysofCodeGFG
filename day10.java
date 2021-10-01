https://practice.geeksforgeeks.org/problems/print-a-binary-tree-in-vertical-order/1#
class Pair
{
 Node node;
 int hd;
 Pair(Node node, int hd) { this.node =node ; this.hd=hd; }
}

class Solution
{
 //Function to find the vertical order traversal of Binary Tree.

static ArrayList <Integer> verticalOrder(Node root)
 {
     // add your code here
      ArrayList <Integer> ans = new ArrayList <Integer>();

      // idea : do leveloreder traversal and need to make a Pair class(to add node along with is horz distance)
     Queue<Pair> q = new LinkedList<>();
     Map<Integer, ArrayList<Integer>> mp= new TreeMap<>();

     q.add(new Pair(root,0));

     while(!q.isEmpty())
     {
         Pair p = q.poll(); Node curr=p.node; int hd =p.hd;

         // putting in map
         if(mp.containsKey(hd))
         mp.get(hd).add(curr.data);

         else
         {
             ArrayList<Integer> al = new ArrayList<>();
             al.add(curr.data);
             mp.put(hd,al);
         }

         if(curr.left!=null) q.add(new Pair(curr.left , hd-1));
         if(curr.right!=null) q.add(new Pair(curr.right, hd+1));
     }
     // traversing
     for(Map.Entry<Integer,ArrayList<Integer>> p : mp.entrySet())
     {
         ArrayList<Integer> al = p.getValue();
         for( int x :al)
         {
             ans.add(x);
         }
     }

     return ans;
 }
}
