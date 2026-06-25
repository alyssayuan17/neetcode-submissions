class DynamicArray {

    private int[] arr;
    private int size; 
    private int capacity;

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.arr = new int[capacity];
    }

    // returns element at index i
    public int get(int i) {
        return arr[i];
    }

    // sets the element at index i to n 
    public void set(int i, int n) {
        arr[i] = n;
    }

    // if arr is full, resize first to avoid crash
    public void pushback(int n) {
        if (size == capacity) {
            resize();
        }

        arr[size] = n;
        size++;
    }

    // pops and returns the element at the end of arr
    public int popback() {
        int last = arr[size - 1]; 
        size--;
        return last;
    }

    // doubles capacity of arr
    private void resize() {
        capacity *= 2;
        int[] newArr = new int[capacity];

        for (int j = 0; j < size; j++) {
            newArr[j] = arr[j];
        }

        arr = newArr;
    }

    // returns size of array
    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
}
