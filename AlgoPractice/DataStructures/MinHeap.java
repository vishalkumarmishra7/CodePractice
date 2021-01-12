package DataStructures;

import java.util.*;


public class MinHeap {
    
    private int heapSize = 0;
    private int[] heap;

    public MinHeap(int capacity){
        this.heapSize = 0;
        this.heap = new int[capacity+1];
        Arrays.fill(heap, -1);
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

    private int parent(int idx){
        return (idx-1)/2;
    }
    private int leftChild(int idx){
        return 2*idx+1;
    }
    private int rightChild(int idx){
        return 2*idx+2;
    }

    public void insert(int item){
        if(isFull())
            throw new NoSuchElementException("Heap is full, No space available to insert new item");
        heap[heapSize++] = item;
        
        minHeapifyUp(heapSize-1);
    }

    private void minHeapifyUp(int pos){
        int newItem = heap[pos];
        while (pos > 0 && newItem < heap[parent(pos)]){
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

        minHeapifyDown(pos);
        return deletedItem;
    }

    private void minHeapifyDown(int pos){
        int movedChild = heap[pos];
        int selectedChildIdx;
        // int leftChild = 2*pos+1 ;
        // int rightChild = 2*pos+2;
        while(leftChild(pos) < heapSize){
            if(rightChild(pos) < heapSize)
                selectedChildIdx = heap[leftChild(pos)]<heap[rightChild(pos)]? leftChild(pos): rightChild(pos);
            else selectedChildIdx = leftChild(pos);
                
            if(movedChild > heap[selectedChildIdx])
                {heap[pos] = heap[selectedChildIdx];
                heap[selectedChildIdx] = -1;}
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

    
    public void printHeapStructure(){
        System.out.println("MinHeap is:");
        System.out.println("PARENT NODE"+"\t"+"LEFT NODE"+"\t"+"RIGHT NODE");
        for(int i=0;i<heapSize/2;i++)
            System.out.println(" "+heap[i]+"\t\t"
                                +" "+heap[leftChild(i)]+"\t\t"
                                +" "+heap[rightChild(i)]);
        System.out.println();
    }


    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(7);

        minHeap.insert(1);
        minHeap.insert(3);
        minHeap.insert(9);
        minHeap.insert(5);
        minHeap.insert(7);
        minHeap.insert(11);
        minHeap.insert(12);
        minHeap.printHeap();
        minHeap.printHeapStructure();  
        minHeap.delete(0);
        minHeap.printHeap();
        minHeap.printHeapStructure();       
    }


    
}
