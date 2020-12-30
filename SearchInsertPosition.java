//https://leetcode.com/problems/search-insert-position/
class SearchInsertPosition {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,6};
        int target = 7;
        System.out.println(getInsertOption(arr, target));
    }

    private static int getInsertOption(int[] arr, int target) {
        int start = 0, end = arr.length-1, mid;
        while (start <= end){
            mid = (start + end)/2;
            if(arr[mid] == target){
                return mid;
            } else if(arr[mid] < target){
                start = mid+1;
            } else if(arr[mid] > target){
                end = mid - 1;
            }
        }
        // here it is confirm value is not found in the array
        // if the value at start is less than target we will that position + 1
        if(start < arr.length && arr[start] < target) {
            return start + 1;
        }else { // if the value at start is grater than target we will that position
            return start;
        }
    }
}
