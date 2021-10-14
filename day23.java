Swap all odd and even bits
https://practice.geeksforgeeks.org/problems/swap-all-odd-and-even-bits-1587115621/1#
Expected Time Complexity: O(1).
Expected Auxiliary Space: O(1).


class Solution
{
    //Function to swap odd and even bits.

    //idea
    //a. preserve even place bits by & with 1 at even position -> threrefore mask used 1010 8 times for 32 bit
    //b. preserve odd place bits by & with 1 at odd position -> threrefore mask used 0101 8 times for 32 bit
    // want bits swapped now.
    //c. now lets move one bit ahead for all even place bits, -> right shoft by 1
    // and move one bit behind for all odd preserved bit -? left shift by 1.
    // return their sum(this is req by program)
    public static int swapBits(int n)
    {
	    // Your code
      // ox____ is format for representing hexadeciaml
	    int mask1 = 0xAAAAAAAA; // 8times 1010
	    int mask2 = 0x55555555; // 8 times 0101

	    // ebs - even_bits_preseved , obs - odd_bits_preseved
	    int ebs = (n&mask1)>>1;
	    int obs = (n&mask2)<<1;

	    return (ebs|obs);
	}

}
