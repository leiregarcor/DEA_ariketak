package pack1Partziala;// EGILEA: MARTIN AMEZOLA
// 2020 AZTERKETA LEHEN PARTZIALA LISTAK

public class DoubleCircularLinkedList {
    DoubleNode<String> first;

    public DoubleCircularLinkedList ()
    {
        this.first = null;
    }




    public void txertatu(String s)
    {
        if (this.first == null) // Lista hutsa denean
        {
            this.first = new DoubleNode<>(s); // en el examen me he dejado el <>
            this.first.next = this.first;
            this.first.prev = this.first;
        }else // Lehen elementua ez bada
        {
            DoubleNode a = this.first.prev;
            a.next = new DoubleNode<>(s);
            a.next.prev = a;
            a.next.next = this.first;
            this.first.prev = a.next;
        }
    }
    public void sekuentziakFusionatu(String[] s1, String[] s2)
    {
        // Aurrebaldintza: s1.lenght eta s2.lenght ez dira 0.
        // PostBald: Bueltatuko du lista ordenatua

        int l1 = 0;
        int l2 = 0;

        while ((l1 < s1.length)&&(l2 < s2.length))
        {
            if (s1[l1].compareTo(s2[l2]) > 0) // s1 handiagoa da
            {
                txertatu(s2[l2]);
                l2++;
            }else if (s1[l1].compareTo(s2[l2]) < 0)
            {
                txertatu(s1[l1]);
                l1++;
            }else
            {
                txertatu(s1[l1]);
                txertatu(s2[l2]);
                l1++;
                l2++;
            }
        }
        if ((l1 >= s1.length)&&(l2 < s2.length))
            {
                while (l2 < s2.length)
                {
                    txertatu(s2[l2]);
                    l2++;
                }
            }else if ((l2 >= s2.length)&&(l1 < s1.length))
            {
                while (l1 < s1.length)
                {
                    txertatu(s1[l1]);
                    l1++;
                }
            }
    }

    public void printeatuLista()
    {
        DoubleNode<String> a = this.first;
        if (this.first != null)
        {
            do{
                System.out.print(" " + a.data + " ");
                a = a.next;
            }while(a != this.first);
        }
    }
}
