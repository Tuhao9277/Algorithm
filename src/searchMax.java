public class searchMax {
    public static int getMax(int[] arr,int l,int r){
        if (l == r){
            return arr[l];
        }
        int mid = (l+r)/2;
        int leftMax = getMax(arr,l,mid);
        int rightMax = getMax(arr,mid+1,r);
        return Math.max(leftMax,rightMax);
    }
    public static void main(String[] args){
        int arr[] = {2,3,4,6,9};
        System.out.println(getMax(arr,0,arr.length-1));

    }

}
