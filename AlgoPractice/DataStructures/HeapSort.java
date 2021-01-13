package DataStructures;

import java.util.Arrays;

// #1) Heap Sort algorithm to sort in ascending order:

// Create a max heap for the given array to be sorted.
// Delete the root (maximum value in the input array) and move it to the sorted array. Place the last element in the array at the root.
// Heapify the new root of the heap.
// Repeat steps 1 and 2 till the entire array is sorted.
public class HeapSort {

    public void performHeapSort(int[] nums){

        //make heap
        for(int i = nums.length/2 - 1; i >= 0; i--){
            heapifyDown(nums, nums.length, i);
        }

        //get max item
        for(int i = nums.length - 1; i > 0; i--){
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;

            //heapify down from root as delete root
            heapifyDown(nums, i, 0);
        }
    }
    private int parent(int idx){
        return (idx-1)/2;
    }
    private int leftChild(int idx){
        return 2*idx+1;
    }
    private int rightChild(int idx){
        return 2*idx+2;
    }

    private void heapifyDown(int[] nums, int heapSize, int pos){
        
        int largestIdx=pos;
               
        if(leftChild(pos)<heapSize && nums[leftChild(pos)] > nums[largestIdx])
            largestIdx = leftChild(pos);
        if(rightChild(pos)<heapSize && nums[rightChild(pos)] > nums[largestIdx])
            largestIdx = rightChild(pos);

        if(nums[largestIdx] > nums[pos]){
            int temp = nums[pos];
            nums[pos] = nums[largestIdx];
            nums[largestIdx] = temp;

            heapifyDown(nums, heapSize, largestIdx);
        }
    }

    public void printHeap(int[] heap){
        System.out.print("Heap= ");
        for(int i=0;i<heap.length;i++)
            System.out.print(heap[i] +" ");
        System.out.println();
    }

    
    public void printHeapStructure(int[] heap){
        System.out.println("MinHeap is:");
        System.out.println("PARENT NODE"+"\t"+"LEFT NODE"+"\t"+"RIGHT NODE");
        for(int i=0;i<heap.length/2;i++)
            System.out.println(" "+heap[i]+"\t\t"
                                +" "
                                +(leftChild(i)<heap.length?heap[leftChild(i)]:-1)
                                +"\t\t"
                                +" "
                                +(rightChild(i)<heap.length?heap[rightChild(i)]:-1));
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {6,2,9,4,10,15,1,13};
        Arrays.stream(nums).forEach(n->System.out.print(n+" "));
        System.out.println(); 

        HeapSort hs = new HeapSort();
        hs.performHeapSort(nums);
        Arrays.stream(nums).forEach(n->System.out.print(n+" "));
        System.out.println(); 

        // hs.printHeap(nums);
        // hs.printHeapStructure(nums);         
        
    }

}
