package pack1Partziala;// EGILEA: MARTIN AMEZOLA
// 2020 AZTERKETA LEHEN PARTZIALA LISTAK

public class HasieratuAzterketa {
    public static void main(String[] args) {
        System.out.println("");


        

        String[] s1 = new String[3];
        s1[0] = "col";
        s1[1] = "oir";
        s1[2] = "pan";


        String[] s2 = new String[5];
        s2[0] = "ama";
        s2[1] = "gas";
        s2[2] = "mar";
        s2[3] = "rio";
        s2[4] = "zar";


        // Estruktura hasieratuta.

        System.out.println(" Batu beharreko bi listak hauek dira, s1 eta s2:");

        System.out.print("s1: ");
        printeatuStringArray(s1);
        System.out.println("");
        System.out.print("s2: ");
        printeatuStringArray(s2);


        System.out.println("");
        System.out.println("");
        System.out.println("");

        System.out.println("Orain, listak fusionatu eta gero, emaitza honako hau izan behar da: ");
        System.out.println(" ama  col  gas  mar  oir  pan  rio  zar");
        System.out.println("");
        System.out.println("");
        System.out.println("Eta zure emaitza:");
        DoubleCircularLinkedList listanagusi = new DoubleCircularLinkedList();
        listanagusi.sekuentziakFusionatu(s1, s2);
        listanagusi.printeatuLista();
        System.out.println("");
    }

    public static void printeatuStringArray(String[] si)
    {
        int x = 0;

        while (x < si.length)
        {
            System.out.print(" " + si[x] + " ");
            x++;
        }
    }
}