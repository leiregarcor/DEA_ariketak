package packEzabatuAgerpenGuztiakEkaina;

public class SimpleLinkedList<T> {

    Node<T> first;
    public void ezabatuGuztiak(T elem) {
        // Post: “elem” balioaren berdinak diren elementuak kendu dira zerrendatik
    }

    private class Node<T> {
        public T data;
        public Node<T> next;

        public Node(T elem){
            this.data = elem;
            this.next = null;
        }
    }
}
