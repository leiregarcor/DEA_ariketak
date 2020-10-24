package packErrobota;

import java.util.ArrayList;


public class Bidea {
    Node first;

    public Bidea() {
        first = null;
    }


    public CircularLinkedList<String> lortuKoordenatuak( ArrayList<String> ekintzak ){
        // pre:  “ekintzak” zerrendak gutxienez elementu bat du, eta errobotak
        //       egingo dituen mugimenduak adierazten ditu
        //       Mugimenduek ez dute inoiz errorerik emango (errobota sekula ez da saiatuko null erreferentzia bat jarraitzen)
        // post: zerrenda bat bueltatuko du, errobotak jarraitu dituen koordenatuekina

        CircularLinkedList<String> ema= new CircularLinkedList<String>();
        Node unekoa= first;
        ema.gehitu(unekoa.koord);
        System.out.println("Hasierako koordenatua: " + unekoa.koord);
        for (int i=0; i< ekintzak.size(); i++){
            if ( ekintzak.get(i).equals("left") ){
                unekoa = unekoa.left;
            }
            else if (ekintzak.get(i).equals("right")) {
                unekoa = unekoa.right;
            }
            else if (ekintzak.get(i).equals("next")){
                unekoa= unekoa.next;
            }
            System.out.println("Hartutako bidea: " + ekintzak.get(i) + " bere koordenatua: " + unekoa.koord);
            ema.gehitu(unekoa.koord);
        }

        return ema;
    }


    public static void main(String[] args) {
        Bidea b = new Bidea();

        Node bat = new Node();
        Node bi = new Node();
        Node hiru = new Node();
        Node lau = new Node();
        Node bost = new Node();
        Node sei = new Node();
        Node zazpi = new Node();
        Node zortzi = new Node();
        Node bederatzi = new Node();

        bat.koord = "3-5-9";
        bi.koord = "2-4-5";
        hiru.koord = "9-5-9";
        lau.koord = "8-5-9";
        bost.koord = "5-9-3";
        sei.koord = "9-8-4";
        zazpi.koord = "1-5-7";
        zortzi.koord = "1-5-9";
        bederatzi.koord = "1-2-7";

        bat.next = sei;
        bat.left = bi;

        bi.next = hiru;
        bi.right = zazpi;

        hiru.next = lau;

        lau.next = bost;

        sei.next = zazpi;

        zazpi.next = zortzi;
        zazpi.left = lau;

        zortzi.next = bederatzi;
        zortzi.left = bost;

        b.first = bat;

        ArrayList<String>ekintzak = new ArrayList<String>();
        ekintzak.add("left");
        ekintzak.add("right");
        ekintzak.add("left");
        ekintzak.add("next");

        b.lortuKoordenatuak(ekintzak);
    }
}




