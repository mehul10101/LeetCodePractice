class FirstAndLastPositionInArray {
    
    //https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
    public static void main(String[] args) {
        int[] arr = new int[]{ 7};
        int k = 8;
        if(arr.length == 0){
            //return new int[]{-1,-1};
            return;
        }
        System.out.println(getFirstIndex(arr, k) + ", " +
                getLastIndex(arr, k));
    }

    // there will be two functions getFirstIndex and getLastIndex it will be implemented on concept of binary search

    private static int getFirstIndex(int[] arr, int target) {
        int start = 0, end = arr.length - 1, index = -1;
        while(start<=end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                // we can't stop here because there can be index smaller than mid which will have target value
                // ex if array was 5,8,8,8,8,10, so we have to go till the end
                if(index == -1 || mid < index) {
                    index = mid;
                    end = mid-1;
                }
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else if(arr[mid] > target){
                end = mid - 1;
            }
        }
        return index;
    }

    private static int getLastIndex(int[] arr, int target) {
        int start = 0, end = arr.length - 1, index = -1;
        while(start<=end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                // we can't stop here because there can be index smaller than mid which will have target value
                // ex if array was 5,8,8,8,8,10, so we have to go till the end
                if(index == -1 || mid > index) {
                    index = mid;
                    start = mid+1;
                }
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else if(arr[mid] > target){
                end = mid - 1;
            }
        }
        return index;
    }

}
