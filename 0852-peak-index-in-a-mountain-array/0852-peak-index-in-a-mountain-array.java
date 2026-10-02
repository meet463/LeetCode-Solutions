class Solution {
    public int peakIndexInMountainArray(int[] arr) {
       int start = 0;
        int end = arr.length -1;
        
        while (start < end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] > arr[mid+1]) {
                // you are in the decreasing part of array
                // this may be the ans, but look at left

                end = mid; // this is why end != mid -1
            } else {
                // you are in ascending part of array
                start = mid + 1; // we know mid+1 ele > mid ele
            }
        }
        // in the end, start == end and pointing to the lasgest number becoz of the 2checks above
        // start and end are always trying to find the max element in the above 2 checks
        // hence when they arer pointing to just one element, this is the max one becox that was check says

        return start; // return end as both are equal
    } 
}