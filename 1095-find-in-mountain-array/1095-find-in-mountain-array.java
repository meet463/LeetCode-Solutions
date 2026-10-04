
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = peakIndexInMountainArray(mountainArr);

        // first search in the ascending half
        int firstTry = OrderAgnostic(mountainArr, target, 0, peak);

        if (firstTry != -1) {
            return firstTry;
        }

        // if not found, search in the descending half
        return OrderAgnostic(mountainArr, target, peak + 1, mountainArr.length() - 1);
    }

    public int peakIndexInMountainArray(MountainArray arr) {
        int start = 0;
        int end = arr.length() - 1;

        // find the highest element in the mountain
        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr.get(mid) > arr.get(mid + 1)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    static int OrderAgnostic(MountainArray arr, int target, int start, int end) {
        // check whether this part is sorted in ascending order
        boolean isAsc = arr.get(start) < arr.get(end);

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr.get(mid) == target) {
                return mid;
            }

            // adjust the search range based on the order
            if (isAsc) {
                if (target < arr.get(mid)) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > arr.get(mid)) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        return -1;
    }
}

