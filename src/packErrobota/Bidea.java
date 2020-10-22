package packErrobota;

import java.util.ArrayList;


public class Bidea {
    Node first;

    public Bidea() {
    }


    public CircularLinkedList<String> lortuKoordenatuak( ArrayList<String> ekintzak ){
        // pre:  “ekintzak” zerrendak gutxienez elementu bat du, eta errobotak
        //       egingo dituen mugimenduak adierazten ditu
        //       Mugimenduek ez dute inoiz errorerik emango (errobota sekula ez da saiatuko null erreferentzia bat jarraitzen)
        // post: zerrenda bat bueltatuko du, errobotak jarraitu dituen koordenatuekina

        CircularLinkedList<String> ema= new CircularLinkedList<String>();
        Node unekoa= first;
        ema.gehitu(unekoa.koord);
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

            ema.gehitu(unekoa.koord);
        }

        return ema;
    }
}




