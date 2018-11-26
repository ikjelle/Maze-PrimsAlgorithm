package sample;// Java program for linked-list implementation of queue

// A linked list (LL) node to store a queue entry 
class QNode<T>
{
    T data;
    QNode next;

    // constructor to create a new linked list node 
    public QNode(T data) {
        this.data = data;
        this.next = null;
    }
}

// A class to represent a queue 
//The queue, front stores the front node of LL and rear stores ths 
//last node of LL 
class Queue<T>
{
    QNode<T> front, rear;

    public Queue() {
        this.front = this.rear = null;
    }

    // Method to add an key to the queue.   
    void enqueue(T data)
    {

        // Create a new LL node 
        QNode temp = new QNode(data);

        // If queue is empty, then new node is front and rear both 
        if (this.rear == null)
        {
            this.front = this.rear = temp;
            return;
        }

        // Add the new node at the end of queue and change rear 
        this.rear.next = temp;
        this.rear = temp;
    }

    // Method to remove an key from queue.   
    T dequeue()
    {
        // If queue is empty, return NULL. 
        if (this.front == null)
            return null;

        // Store previous front and move front one node ahead 
        QNode temp = this.front;
        this.front = this.front.next;

        // If front becomes NULL, then change rear also as NULL 
        if (this.front == null)
            this.rear = null;
        return (T) temp.data;
    }

    public int length() {
        if (front == null)
            return 0;
        int num = 0;
        QNode<T> node = front;
        while(node!= null) {
            num++;
            node = node.next;
        }
        return num;
    }
}