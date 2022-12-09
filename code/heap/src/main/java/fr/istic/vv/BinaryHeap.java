package fr.istic.vv;

import java.util.Comparator;

public class BinaryHeap<T> {

    private T[] heap;
    private int size;
    private Comparator<T> comparator;

    public BinaryHeap(Comparator<T> comparator) {
        this.comparator = comparator;
        this.heap = (T[]) new Object[10];
        this.size = 0;
    }

    private void swap(int index1, int index2) {
        T temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }
    
    private void siftDown(int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        if (left >= size) {
            return;
        }
        int min = left;
        if (right < size && comparator.compare(heap[right], heap[left]) < 0) {
            min = right;
        }
        if (comparator.compare(heap[index], heap[min]) > 0) {
            swap(index, min);
            siftDown(min);
        }
    }
    
    public T pop() {
        T result = heap[0];
        heap[0] = heap[size - 1];
        heap[size - 1] = null;
        size--;
        siftDown(0);
        return result;
    }

    public T peek() {
        return heap[0];
    }
    
    private void grow() {
        T[] newHeap = (T[]) new Object[heap.length * 2];
        System.arraycopy(heap, 0, newHeap, 0, heap.length);
        heap = newHeap;
    }
    
    private void siftUp(int index) {
        if (index == 0) {
            return;
        }
        int parent = (index - 1) / 2;
        if (comparator.compare(heap[index], heap[parent]) < 0) {
            swap(index, parent);
            siftUp(parent);
        }
    }

    public void push(T element) {
        if (size == heap.length) {
            grow();
        }
        heap[size] = element;
        siftUp(size);
        size++;
    }

    public int count() {
        return size;
    }

}
