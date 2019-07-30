package ru.mironenko.learning.extratask;

/**
 * Created by nikita on 31.07.2017.
 */
//Дан класс(однонаправленный список) и последовательность:
//class Node {
//    Node next;
//    T value;
//}
//1 > 2 >3
//необходимо перевернуть последовательность в обратном порядке 3 > 2 > 1

public class Node<T> {

    Node next;
    T value;

    public Node(T value, Node next) {
        this.next = next;
        this.value = value;
    }


    public boolean hasNext() {
        return next != null;
    }

    private void reverseAll(Node previos) {
        if(this.hasNext()) {
            this.next.reverseAll(this);
        }
        this.next = previos;
    }

}
