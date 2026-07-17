public class MostWater {
    public static int findMost(int[] arr){
        int left=0, right=arr.length-1, mWater = 0;
        while(left<right){
            int width = right-left;
            int height = Math.min(arr[left],arr[right]);
            mWater = Math.max(mWater, width*height);
            if(arr[left]<arr[right]) left++;
            else right--;
        }
        return mWater;
    }
