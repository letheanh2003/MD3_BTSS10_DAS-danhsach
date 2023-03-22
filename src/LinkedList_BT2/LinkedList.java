package LinkedList_BT2;

import java.util.Arrays;

public class LinkedList {
    public static <S> void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<String>(10);
        list.add(0, "The Anh");
        list.add(0, "Thang Xoai");
        list.add(0, "Anh Khoa");
        System.out.println(Arrays.asList(list));
        list.addFirst("The Anh");
        System.out.println(Arrays.asList(list));
        list.addLast("The Anh");
        System.out.println(Arrays.asList(list));
        list.remove(1);
        System.out.println(Arrays.asList(list));
        list.removeElement("Chinh");
        System.out.println(Arrays.asList(list));
        System.out.println("Size = " + list.size());
        MyLinkedList<String>cloneList=(MyLinkedList<String>)list.clone();
        System.out.println("array clone = " + Arrays.asList(cloneList));
        list.getFirst();
        list.getLast();
        list.clear();
        System.out.println(Arrays.asList(list));

    }
}
