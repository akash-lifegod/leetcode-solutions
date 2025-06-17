import java.util.*;
class Solution {
    public int sumOfPower(int[] nums) {
        long mod = 1000_000_007;
        Arrays.sort(nums);

        long s = 0, r = 0;
        for(int x : nums){
            r = (r + (s+x) * x%mod * x%mod)%mod;
            s = (s*2 + x)%mod;
        }
        return (int)r;
    }
}

// Since we just consider "combination" instead of "permutation", sorting doesn't affect the final result.

// After sorting, we try to enumerate all (minimum a(i), maximum a(j)) pairs, guarantee that i<j.
// For each pair, all elements between i and j can be independently selected to be included or not. 
// So there will be 2^(j−i−1) different combinations with minimum ai and maximum a(j).

// The contribution of pair(ai, aj) to the answer will be
// c(i, j) = (aj)^2 * ai * 2^(j−i−1)

// As a result, the contribution of aj is the sum of all valid (i,j)'s contribution:
// c(j)= (i=0 ∑ j) c(i,j)
// In step 2, we have discussed the case i<j. And obviously, when i=j, the contribution is:
// c(j,j)=aj^3

// So the total contribution of j is:
// c(j)=c(j,j) + (i=0 ∑ j-1) c(i,j) = aj^3 + aj^2 * (i=0 ∑ j-1) ai * 2^(j−i−1)


// Let's set S(j)= (i=0 ∑ j-1) ai * 2^(j−i−1) , so the c(j) changes to:
// c(j)=aj^2 * [aj + S(j)]
// Now, our task is to calculate S(j) in a low average time, such as O(1).

// Obviously there is a sense that it is possible to recursively derive S(j) from S(j−1).
// We can easily get that:
// S(0)=0

// S(j)=a(j−1)+ 2 * (i=0 ∑ j-2) ai * 2^(j−i−2) = a(j-1) + 2S(j-1), j>0
// (That's because from j−1 to j, a(j−1) will be included for all i, so it offers a new independent choice.)


// Therefore, sort firstly, then traverse the array from front to back, and constantly maintain S(j) and count.


// https://leetcode.com/problems/power-of-heroes/solutions/3520233/c-java-python-sort-and-enumerate-each-maximum-value