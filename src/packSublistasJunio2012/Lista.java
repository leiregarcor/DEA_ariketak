package packSublistasJunio2012;

public class Lista {
    public Node first;

    public boolean esSublista(Lista l1){
        //KOSTE DEL ALGORITMO N/2
        /** pre: l1 y l2 están ordenadas
         * post: true si l1 es sublista de la lista q llama al metodo, false si no.
         */
        Boolean ema = true;
        Node lag1 = l1.first;
        Node lag2 = this.first;
        while (ema && lag1 != null && lag2!=null){
            if (lag1.zenb < lag2.zenb){
                ema = false; //sale del while pq no es sublista
            }
            else if (lag1.zenb > lag2.zenb){
                //actulizamos punteros lag2
                lag2= lag2.next;
            }
            else {
                //si son iguales actualizamos los dos
                lag2= lag2.next;
                lag1= lag1.next;
            }
        }
        if (lag1 != null && lag2 == null) {/**
         * si l2 es hutsa y l1 no lo es o si l2 es hutsa y l1 no lo es
         **/
            ema= false;
        }
        System.out.println(ema);
        return ema;
    }


    public static void main(String[] args) {
        /** PROBA KASUAK
         *   l1        l2       ema
         *   ----------------------
         *   null      null     true
         *   null      !null    true
         *   !null     null     false
         *   (1,2)     (1,3,4)  false
         *   (1,3)     (1,3,4)  true
         *   (1,5)     (1,3,4)  false
         */

        Node n11 = new Node(5);
        Node n12 = new Node(17);
        Node n13 = new Node(20);

        Node n21 = new Node(5);
        Node n22 = new Node(10);
        Node n23 = new Node(17);
        Node n24 = new Node(20);

        Node n51 = new Node(5);
        Node n52 = new Node(17);
        Node n53 = new Node(20);
        Node n54 = new Node(12);

        Node n61 = new Node(5);
        Node n62 = new Node(17);
        Node n63 = new Node(20);
        Node n64 = new Node(30);


        n11.next = n12;
        n12.next= n13;

        n21.next = n22;
        n22.next = n23;
        n23.next = n24;

        n51. next = n54;
        n54.next = n52;
        n52.next = n53;

        n61.next= n62;
        n62.next= n63;
        n63.next= n64;


        Lista l1= new Lista(); //es sublista de l2
        Lista l2 = new Lista();

        l1.first=n11;
        l2.first= n21;

        Lista l3= new Lista();
        Lista l4 = new Lista();

        l3.first=null;
        l4.first=null;

        Lista l5= new Lista();
        Lista l6 = new Lista();

        l5.first= n51;
        l6.first=n61;

        System.out.println("l1 es sublista de l2");
        l2.esSublista(l1);

        System.out.println("l3 null y l4 null");
        l4.esSublista(l3);

        System.out.println("l3 null es  sublista de l2");
        l2.esSublista(l3);

        System.out.println("l1 no es sublista de l4 null");
        l4.esSublista(l1);

        System.out.println("un elemento de l5 no está en l2");
        l2.esSublista(l5);

        System.out.println("l6 es mayor que l2");
        l2.esSublista(l6);





    }
}
