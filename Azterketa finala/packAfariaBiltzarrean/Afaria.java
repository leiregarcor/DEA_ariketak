package packAfariaBiltzarrean;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Afaria<T> {
    int numVertices;
    T[] vertices = (T[]) new Object[]{"jon", "ana", "kepa", "peio", "luis", "maria"};
    ArrayList<Integer>[]adjList; //nork dago haserretuta norekin (grafoaren loturak)

    public Afaria() {
        this.numVertices = 6;
        this.adjList = new ArrayList[numVertices];
    }

    public boolean ahalDaAfaria(){
        //zabaleran:
        Queue<Integer> aztertuGabeak = new LinkedList<>();
        boolean ondoGoaz = true;
        boolean[] aztertuak = new boolean[numVertices];
        boolean[] jangela = new boolean[numVertices]; //pertsona bakoitzak ze jangelan egongo den gordetzeko

        for(int k=0; k<aztertuak.length;k++) { //hasieratu false-ra
            aztertuak[k] = false;
        }
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
                else if (jangela[biziLag]!=jangela[unekoa]){ //ondoz ondoko bi nodoen jangelak desberdinak badira ezer ez
                }
                else{ //ondoz ondoko bi nodoen jangelak berdinak badira false
                        ondoGoaz=false;
                }
            }
        }
        return ondoGoaz;
    }


    public static void main(String[] args) {
        Afaria a = new Afaria<String>();
        //vertices sortutzen da eraikitzailean, orain adjList bete behar dugu
        //"jon", "ana", "kepa", "peio", "luis", "maria"
        // 0      1        2       3       4       5
        a.adjList[0]=new ArrayList();
        a.adjList[0].add(3);
        a.adjList[0].add(1);
        a.adjList[0].add(2);
        a.adjList[0].add(4);

        a.adjList[1]=new ArrayList();
        a.adjList[1].add(0);
        a.adjList[1].add(2);

        a.adjList[2]=new ArrayList();
        a.adjList[2].add(4);
        a.adjList[2].add(1);
        a.adjList[2].add(0);

        a.adjList[3]=new ArrayList();
        a.adjList[3].add(5);
        a.adjList[3].add(0);

        a.adjList[4]=new ArrayList();
        a.adjList[4].add(2);
        a.adjList[4].add(0);

        a.adjList[5]=new ArrayList();
        a.adjList[5].add(3);

        System.out.println(a.ahalDaAfaria());
    }
}
