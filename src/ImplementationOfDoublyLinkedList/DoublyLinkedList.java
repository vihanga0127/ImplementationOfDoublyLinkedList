package ImplementationOfDoublyLinkedList;

public class DoublyLinkedList {

    // Node class represents a single element in the list
    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    // Head and tail of the doubly linked list
    private Node head;
    private Node tail;

    // Method to add a new node at the beginning of the list (prepend)
    public void push(int newData) {
        Node newNode = new Node(newData);
        newNode.next = head;
        if (head != null) {
            head.prev = newNode;
        } else {
            tail = newNode; // If the list was empty, newNode is also the tail
        }
        head = newNode;
    }

    // Method to add a new node at the end of the list (append)
    public void append(int newData) {
        Node newNode = new Node(newData);
        if (tail == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // Method to delete the first occurrence of a given value
    public void delete(int key) {
        Node temp = head;

        // Search for the key to be deleted
        while (temp != null && temp.data != key) {
            temp = temp.next;
        }

        // If the key was not present in the list
        if (temp == null) {
            return;
        }

        // If the node to be deleted is the head node
        if (temp == head) {
            head = temp.next;
        }

        // If the node to be deleted is the tail node
        if (temp == tail) {
            tail = temp.prev;
        }

        // Unlink the node from the list
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
    }

    // Method to search for a node with a specific value
    public boolean search(int key) {
        Node current = head;
        while (current != null) {
            if (current.data == key) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Method to print the contents of the linked list from head to tail
    public void printListForward() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Method to print the contents of the linked list from tail to head
    public void printListBackward() {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }

    // Main method to create a sample doubly linked list and test methods
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        list.push(56);
        list.push(34);
        list.push(73);
        list.append(41);
        list.append(50);

        System.out.println("Created Doubly Linked List (Forward): ");
        list.printListForward();

        System.out.println("Created Doubly Linked List (Backward): ");
        list.printListBackward();

        System.out.println("Deleting 3 from Doubly Linked List:");
        list.delete(34);
        list.printListForward();

        System.out.println("Searching for 2 in Doubly Linked List: " + list.search(41));
        System.out.println("Searching for 10 in Doubly Linked List: " + list.search(10));
    }
}
