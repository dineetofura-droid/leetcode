class MyCircularDeque {

    int[] arr;
    int front;
    int rear;
    int size;
    int k;

    public MyCircularDeque(int k) {
        this.k = k;
        arr = new int[k];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean insertFront(int value) {
        if (size == k)
            return false;

        front = (front - 1 + k) % k;
        arr[front] = value;

        if (size == 0)
            rear = front;

        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (size == k)
            return false;

        rear = (rear + 1) % k;
        arr[rear] = value;

        if (size == 0)
            front = rear;

        size++;
        return true;
    }

    public boolean deleteFront() {
        if (size == 0)
            return false;

        front = (front + 1) % k;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (size == 0)
            return false;

        rear = (rear - 1 + k) % k;
        size--;
        return true;
    }

    public int getFront() {
        if (size == 0)
            return -1;

        return arr[front];
    }

    public int getRear() {
        if (size == 0)
            return -1;

        return arr[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == k;
    }
}