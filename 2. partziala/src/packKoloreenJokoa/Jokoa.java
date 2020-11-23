package packKoloreenJokoa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Jokoa {

    public class Jokaldi {
        int dado1;
        int dado2;
    }

    Queue<Integer>[] jokalariak = new Queue[6];
    // Fitxen koloreak balio osokoen bidez adierazten dira: beltzak 0 eta
    // beste jokalarien kolorea bere posizioarekin bat etorriko da (hau da,
    // 1 jokalariak 1 kolorea, ...)
    Stack<Integer> mahaia;


    public Jokoa() {
        for(int i=0; i<jokalariak.length; i++){
            jokalariak[i]= new LinkedList<>();
        }
        this.mahaia = new Stack<>();
    }

    public int jokoa( ArrayList<Jokaldi> jokaldiak) {
        // aurre: n jokalari bakoitzaren hasierako fitxa-kopurua da
        // “jokaldiak” zerrendak partida bateko jokaldiak ditu
        // post: emaitza irabazlearen zenbakia da
        int ema=0;
        for(Jokaldi j: jokaldiak){
            if(j.dado1==6) {
                //dado1 6 bada
            }
            else if(j.dado1%2==0) {
                //dado1 bikoitia bada
                if(!jokalariak[j.dado2-1].isEmpty())
                    mahaia.push(jokalariak[j.dado2-1].remove());
            }
            else{
                //dado2 bakoitia bada
                if(!mahaia.isEmpty())
                    jokalariak[j.dado2-1].add(mahaia.pop());
            }
        }
        int oraingoB=0;
        int emaB=0;

        for(int i=1; i<jokalariak.length; i++){
            while(!jokalariak[i].isEmpty()){
                if(jokalariak[i].remove()==0){
                    oraingoB++;
                }
            }
            if(oraingoB>emaB){
                emaB=oraingoB;
                ema= i;
            }
        }
        return ema;
    }

    public static void main(String[] args) {

    }
}