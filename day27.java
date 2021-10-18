https://practice.geeksforgeeks.org/problems/segregate-even-and-odd-nodes-in-a-linked-list5035/1#

Time Complexity : O(2n)
Space Complexity : O(n)



class Solution{
    Node divide(int N, Node head){
        // code here
       ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();


        Node ptr =  head;
        while(ptr!=null)
        {
            if(ptr.data%2==0)
           {
              even.add(ptr.data);
           }

            else  if(ptr.data%2!=0)
            {
                odd.add(ptr.data);
            }
            ptr = ptr.next;
        }
        even.addAll(odd);

       Node curr=  head;
        for( int i =0; i<even.size(); i++)
        {
             curr.data = even.get(i);
             curr=curr.next;
            //  System.out.println(even.get(i));

        }
        return head;
    }
}
