/*
1 6 3 9 8 5
1st smallest = 1
2nd smallest = 3
nth order smallest = 
*/
class Solution{

    public static int min(int[] arr) {
        int min = arr[0];
        int min2 = arr[1];

        for(int i=0; i<arr.length; i++){
            if(arr[i]<min){
                min2 = min;
                min = arr[i];                
            } else if(arr[i] < min2){
                min2 = arr[i];
            }
        }
        return min2;
    }

    public static void main(String[] args) {
        int[] input = {3, 2, 5, 6, 10, 21, 15};
        System.out.println(min(input));
    }
}













