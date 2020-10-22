package packErrobota;

public class CircularLinkedList<T> {
    // zerrenda zirkularra azkenaren erreferentziarekin
    NodeCircularLinkedList<T> last;

    public CircularLinkedList( ) {
        this.last = null;
    }


    public void gehitu(T pKoord){
        NodeCircularLinkedList<T> berria = new NodeCircularLinkedList<T> ();
        berria.data= pKoord;
        if (last==null){
            last= berria;
            last.next= berria; //zerrenda zirkularra delako
        }
        else{
            berria.next= last.next;   //balio berria lehenego balioa apuntau
            last.next= berria;  	//azkenengo aurreko balioa amaierako balio berria apuntau
            last = berria;            //last eguneratu balio berrira
        }
    }

}
