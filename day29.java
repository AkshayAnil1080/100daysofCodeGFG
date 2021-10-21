implement queue using arrays
// to implemet push and pop fun

// https://practice.geeksforgeeks.org/problems/implement-queue-using-array/1

class MyQueue {

    int front, size;
	int arr[] = new int[100005];

    MyQueue()
	{
		front=0;
		size=0;
	}

	//Function to push an element x in a queue.
	void push(int x)
	{
	    // Your code here
	    if(size==100005)
	    return;

	  int rear  = front+size-1;
	    rear  = (rear+1)%100005;
	    arr[rear]= x;
	    size++;

	}

    //Function to pop an element from queue and return that element.
	int pop()
	{
		// Your code here
		if ( size==0)
		return -1;

       int temp  = front;
       front = (front+1)%100005;
       size--;

       return arr[temp];

	}
}
