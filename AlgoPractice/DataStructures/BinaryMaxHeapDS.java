package DataStructures;

import java.util.NoSuchElementException;
import java.util.*;

/* 
A binary heap is a complete binary tree. In a complete binary tree, all the levels except the last level are completely filled. At the last level, the keys are as far as left as possible.
It satisfies the heap property. The binary heap can be max or min-heap depending on the heap property it satisfies.
*/

// MAX heap
public class BinaryMaxHeapDS {

    private int heapSize;
    private int[] heap;

    BinaryMaxHeapDS(int capacity){
        heapSize = 0;
        heap = new int[capacity+1];
        Arrays.fill(heap, -1);
    }

    private int parent(int idx){
        return (idx-1)/2;
    }

    private boolean isEmpty(){
        if(0 == heap.length)
            return true;
        else
            return false;
    }
    private boolean isFull(){
        if(heapSize == heap.length)
            return true;
        else
            return false;
    }

    public void insert(int item){
        if(isFull())
            throw new NoSuchElementException("Heap is full, No space available to insert new item");
        heap[heapSize++] = item;
        heapifyUp(heapSize-1);
    }

    private void heapifyUp(int pos){
        int newItem = heap[pos];
        while (pos > 0 && newItem > heap[parent(pos)]){
            heap[pos] = heap[parent(pos)];
            pos = parent(pos);
        }
        heap[pos] = newItem;
    }

    public int delete(int pos){
        if(isEmpty())
            throw new NoSuchElementException("Heap is Empty, No item available to delete item");    
        int deletedItem = heap[pos];
        heap[pos] = heap[--heapSize];
        heap[heapSize] = -1;
        heapifyDown(pos);
        return deletedItem;
    }

    private void heapifyDown(int pos){
        int movedChild = heap[pos];
        int selectedChildIdx;
        // int leftChild = 2*pos+1 ;
        // int rightChild = 2*pos+2;
        while(2*pos+1 < heapSize){
            if(2*pos+2 < heapSize)
                selectedChildIdx = heap[2*pos+1]>heap[2*pos+2]? 2*pos+1: 2*pos+2;
            else selectedChildIdx = 2*pos+1;
                
            if(movedChild < heap[selectedChildIdx])
                heap[pos] = heap[selectedChildIdx];
            else 
                break;
            
            pos = selectedChildIdx;
        }
        heap[pos] = movedChild;
    }

    public void printHeap(){
        System.out.print("Heap= ");
        for(int i=0;i<heapSize;i++)
            System.out.print(heap[i] +" ");
        System.out.println();
    }

    
    public static void main(String[] args) {
        BinaryMaxHeapDS maxHeap = new BinaryMaxHeapDS(10);

        maxHeap.insert(1);
        maxHeap.insert(3);
        maxHeap.insert(9);
        maxHeap.insert(5);
        maxHeap.insert(7);
        maxHeap.insert(11);
        maxHeap.insert(12);
        maxHeap.printHeap();

        maxHeap.delete(0);
        maxHeap.printHeap();       
    }
}