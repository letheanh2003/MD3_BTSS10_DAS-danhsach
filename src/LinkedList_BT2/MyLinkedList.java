package LinkedList_BT2;

import java.util.StringJoiner;

public class MyLinkedList<S> {

    private  Node head;
    private  int numNodes;

    public MyLinkedList(Object data) {
        head = new Node(data);
    }

    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Node.class.getSimpleName() + "[", "]")
                    .add("next=" + next)
                    .add("data=" + data)
                    .toString();
        }
    }
    public Boolean add(int index,Object data) {
        Node temp = head;
        Node holder;
        for (int i = 0; i < index-1 && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(data);
        temp.next.next = holder;
        numNodes++;
        return true;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MyLinkedList.class.getSimpleName() + "[", "]")
                .add("head=" + head)
                .add("numNodes=" + numNodes)
                .toString();
    }
    public int size() {
        return numNodes;
    }
    public void addFirst(Object data) {
        Node temp = head;
        head = new Node(data);
        head.next = temp;
        numNodes++;
    }
    public void addLast(Object data) {
        Node temp = head;
        while (temp.next!= null) {
            temp = temp.next;
        }
        temp.next = new Node(data);
        numNodes++;
    }
    public void remove(int index){
        Node temp = head;
        for (int i = 0; i < index-1 && temp.next!= null; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        numNodes--;
    }
    public boolean removeElement(Object data){
        Node temp = head;
        while (temp.next!= null) {
            if (temp.next.data.equals(data)) {
                temp.next = temp.next.next;
                numNodes--;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    public Object clone(){
        Node temp = head;
        while (temp.next!= null) {
            Node temp2 = new Node(temp.next.data);
            temp2.next = temp.next.next;
            temp = temp2;
        }
        return null;
    }
    public void constaisns(Object data){
        Node temp = head;
        while (temp.next!= null) {
            temp.next.data = data;
            temp = temp.next;
        }
    }
    public boolean indexOf(Object data){
        Node temp = head;
        while (temp.next!= null) {
            if (temp.next.data.equals(data)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    public void ensureCapacity(int capacity){
        Node temp = head;
        while (temp.next!= null) {
            Node temp2 = new Node(temp.next.data);
            temp2.next = temp.next.next;
            temp = temp2;
        }
        Node temp2 = new Node(null);
        temp2.next = head;
        head = temp2;
    }
    public Object get(int index){
        Node temp = head;
        for (int i = 0; i < index-1 && temp.next!= null; i++) {
            temp = temp.next;
        }
        return temp.next.data;
    }
    public void getFirst(){
        Node temp = head;
        while (temp.next!= null) {
            System.out.println(temp.next.data);
            temp = temp.next;
        }
    }
    public void getLast(){
        Node temp = head;
        while (temp.next!= null) {
            System.out.println(temp.next.data);
            temp = temp.next;
        }
    }
    public void clear(){
        head = new Node(null);
        numNodes = 0;
    }
}