package packOrdenagailuenSarea;

import java.util.LinkedList;
import java.util.Queue;

public class RedDeOrdenadores {

    protected Boolean[][] adjMatrix = {
            // 0       1     2      3      4      5      6      7      8      9      10
            {false, false, true,  true,  false, false, false, false, false, false, false}, // 0 -> 2, 3
            {false, false, false, false, false, false, false, false, true,  true,  false}, // 1 -> 8, 9
            {false, false, false, false, true,  false, false, false, false, false, false}, // 2 -> 4
            {false, false, false, false, false, false, false, true,  false, false, true }, // 3 -> 7, 10
            {false, false, false, false, false, true,  false, false, false, false, false}, // 4 -> 5
            {false, true,  false, false, false, false, false, true,  false, false, false}, // 5 -> 1, 7
            {false, false, false, false, false, false, false, false, false, false, false}, // 6
            {false, false, false, false, false, false, false, false, false, false, true }, // 7 -> 10
            {false, false, false, false, false, false, false, false, false, false, false}, // 8
            {false, false, false, false, false, false, false, false, false, false, false}, // 9
            {false, false, false, false, false, false, false, false, false, false, false}  // 10
    };



    /**
     * @return For each i (in the range 0 .. number of nodes in the graph), this method calculates
     * the minimum distance from node 0 to i
     */
    public int[] obtenerCostes() { //solución con aitor
        //kostua n^2, n izanik nodo kopurua

        int[] costes = new int[adjMatrix[0].length];
        boolean[] visitados = new boolean[adjMatrix[0].length];
        Queue<Integer> porExaminar = new LinkedList<Integer>(); //zabaleran errekorritu

        for(int k=0; k<visitados.length;k++){
            visitados[k]=false;
        }

        porExaminar.add(0);
        visitados[0]= true;
        costes[0]=0;

        int uneko=0;

        while(!porExaminar.isEmpty()){
            uneko= porExaminar.remove();
            for (int i=0; i<adjMatrix[0].length; i++){
                if(adjMatrix[uneko][i]){
                    if(!visitados[i]){
                        porExaminar.add(i);
                        visitados[i]= true;
                        costes[i]=costes[uneko]+1;
                    }
                }
            }
        }
        return costes;
    }

   /**koldoren soluzioa

     public int[] obtenerCostes() {

        int[] costes = new int[adjMatrix[0].length];
         boolean[] visitados = new boolean[adjMatrix[0].length];

         Queue<Integer> porExaminar = new LinkedList<Integer>();

         visitados[0] = true;
        costes[0] = 0;
        porExaminar.add(0);

         while (!porExaminar.isEmpty()){
            Integer x = porExaminar.remove();
            for (int i = 0; i < costes.length; i++){
                if ((adjMatrix[x][i]) && (!visitados[i])){
                    visitados[i] = true;
                    costes[i] = costes[x] + 1;
                    porExaminar.add(i);
                }
            }
        }
     return costes;
     }
     */


    public static void main(String[] args){
        int[] r = new RedDeOrdenadores().obtenerCostes();
        int j = 0;
        for (Integer a: r){
            System.out.println(j + ": " + a);
            j++;
        }
    }

}
