package packAfariaBiltzarrean;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Afaria<T> {
    int numVertices;
    T[] vertices;
    ArrayList<Integer>[]adjList;

    public boolean ahalDaAfaria(){
        //zabaleran:
        Queue<Integer> aztertuGabeak = new LinkedList<>();
        boolean ondoGoaz = true;
        boolean[] aztertuak = new boolean[numVertices];
        boolean[] jangela = new boolean[numVertices];

        for(int k=0; k<aztertuak.length;k++) aztertuak[k] = false;
        aztertuGabeak.add(0); //aztertuGabeen ilararen bukaeran sartu
        aztertuak[0]= true; //aztertuen array-an true jarri
        jangela[0]= false;

        while( ondoGoaz && !aztertuGabeak.isEmpty()){
            int unekoa= aztertuGabeak.remove();

            for (int biziLag : adjList[unekoa]){
                if (!aztertuak[biziLag]) {//ez bada tratatua izan
                    aztertuak[biziLag] = true;
                    aztertuGabeak.add(biziLag);
                    jangela[biziLag]=!jangela[unekoa];
                }
                else if (jangela[biziLag]!=jangela[unekoa]){ }
                else{
                    ondoGoaz=false;
                }
            }
        }
        return ondoGoaz;
    }


}
