package packSakoneranGrafoa;

import packSakoneranGrafoa.GraphADT;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class GraphAL<T> implements GraphADT<T> {
    protected final int DEFAULT_CAPACITY = 10;
    protected int numVertices; // number of vertices in the graph
    protected LinkedList<Integer>[] adjList; // adjacency list
    protected T[] vertices; // values of vertices

    public GraphAL() { // Constructora
        numVertices = 0;
        this.adjList = new LinkedList[DEFAULT_CAPACITY];
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            adjList[i] = new LinkedList<Integer>();
        }
        ; // lista vacía
        this.vertices = (T[]) (new Object[DEFAULT_CAPACITY]);
    }

    public void addVertex(T vertex) {
        // pre: el elemento no pertenece al grafo
        vertices[numVertices] = vertex;
        numVertices++;
    }

    public void removeVertex(T vertex) {
        // TODO Auto-generated method stub

    }

    public void addEdge(T vertex1, T vertex2) {
        int i1 = buscarVertice(vertex1);
        int i2 = buscarVertice(vertex2);
        adjList[i1].add(i2);
    }

    public void removeEdge(T vertex1, T vertex2) {
        // TODO Auto-generated method stub

    }

    public Iterator iteratorBFS(T startVertex) {
        // TODO Auto-generated method stub
        return null;
    }

    public Iterator iteratorDFS(T startVertex) {
        // TODO Auto-generated method stub
        return null;
    }

    public Iterator iteratorShortestPath(T startVertex, T targetVertex) {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean isConnected() {
        // TODO Auto-generated method stub
        return false;
    }

    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    public boolean connected(T a, T b) { //ZABALERAN, HAU DA, ILARA BATEKIN

        boolean[] marcados = new boolean[numVertices];
        for (int i = 0; i < marcados.length; i++) {
            marcados[i] = false;
        }

        int u = buscarVertice(a);
        int v = buscarVertice(b);

        Queue<Integer> porExaminar = new LinkedList<Integer>();

        porExaminar.add(u);
        marcados[u] = true;
        boolean enc = false;

        while (!porExaminar.isEmpty() & !enc) {
            int act = porExaminar.remove();
            if (act == v)
                enc = true;
            else
                for (Integer nodo : this.adjList[act]) {
                    if (!marcados[nodo]) {
                        marcados[nodo] = true;
                        porExaminar.add(nodo);
                    }
                }
        }
        return enc;
    }

    public boolean connectedRec(T a, T b) { //SAKONERAN, ERREKURTSIBOKI

        boolean[] marcados = new boolean[numVertices];
        for (int i = 0; i < marcados.length; i++) {
            marcados[i] = false;
        }
        int u = buscarVertice(a);
        int v = buscarVertice(b);
        return connectedRec(u, v, marcados);
    }

    private boolean connectedRec(int x, int y, boolean[] marcados) { ////SAKONERAN, ERREKURTSIBOKI
        if(x==y){ return true;}
        else {
            boolean ema= false;
            marcados[x]=true;
            for(int xn:adjList[x]){
                if(!marcados[xn]){
                    ema= connectedRec(xn, y, marcados);
                    if(ema){
                        return true;
                    }
                }
            }
            return false;
        }
    }




    public ArrayList<T> connected2(T a, T b) {

        boolean[] marcados = new boolean[numVertices];
        int[] camino = new int[numVertices];
        for (int i = 0; i < marcados.length; i++) {
            marcados[i] = false;
            camino[i] = -1;
        }

        int u = buscarVertice(a);
        int v = buscarVertice(b);

        Queue<Integer> porExaminar = new LinkedList<Integer>();

        porExaminar.add(u);
        marcados[u] = true;
        camino[u] = -1;
        boolean enc = false;

        while (!porExaminar.isEmpty() & !enc) {
            int act = porExaminar.remove();
            if (act == v)
                enc = true;
            else
                for (Integer nodo : this.adjList[act]) {
                    if (!marcados[nodo]) {
                        marcados[nodo] = true;
                        camino[nodo] = act;
                        porExaminar.add(nodo);
                    }
                }
        }

        // buscar el camino desde u hasta v
        ArrayList<T> result = new ArrayList<T>();
        if (enc) {
            int pos = v;
            while (pos != -1) {
                result.add(0, vertices[pos]);
                pos = camino[pos];
            }
        }

        return result;
    }

    public ArrayList<T> connectedRec2(T a, T b) {

        boolean[] marcados = new boolean[numVertices];
        int[]     camino   = new int[numVertices];
        for (int i = 0; i < marcados.length; i++) {
            marcados[i] = false;
            camino[i] = -1;
        }
        int u = buscarVertice(a);
        int v = buscarVertice(b);
        boolean enc = connectedRec2(u, v, marcados, camino);

        // buscar el camino desde u hasta v
        ArrayList<T> result = new ArrayList<T>();
        if (enc) {
            int pos = v;
            while (pos != -1) {
                result.add(0, vertices[pos]);
                pos = camino[pos];
            }
        }

        return result;
    }

    private boolean connectedRec2(int x, int y, boolean[] marcados,
                                  int[] camino) {
        if (x == y) return true;
        else {
            marcados[x] = true;
            for (int n: adjList[x]) {
                if (!marcados[n]) {
                    camino[n] = x;
                    boolean res = connectedRec2(n, y, marcados, camino);
                    if (res) return true;
                }
            }
        }
        return false;
    }




    private int buscarVertice(T x) {
        for (int i = 0; i < vertices.length; i++)
            if (vertices[i].equals(x))
                return i;
        return -1;
    }

    public static void main(String[] args){
        GraphAL<String> g = new GraphAL<String>();
        g.addVertex("a");
        g.addVertex("b");
        g.addVertex("c");
        g.addVertex("d");
        g.addVertex("e");
        g.addVertex("f");
        g.addEdge("a", "b");
        g.addEdge("a", "c");
        g.addEdge("b", "c");
        g.addEdge("c", "a");
        g.addEdge("c", "d");
        g.addEdge("d", "e");
        g.addEdge("e", "c");
        g.addEdge("e", "f");

        System.out.println("connected(a, e) deberia dar true:  " +  g.connected("a", "e"));
        System.out.println("connected2(a, e) deberia dar [a, c, d, e]:" + g.connected2("a", "e").toString());
                System.out.println("connected(d, b) deberia dar true:  " + g.connected("d", "b"));
        System.out.println("connected2(d, b) deberia dar [d, e, c, a, b]:  " + g.connected2("d", "b").toString());
        System.out.println("connected(f, b) deberia dar false: " + g.connected("f", "b"));
        System.out.println("connected2(f, b) deberia dar []:  " + g.connected2("f", "b").toString());

        System.out.println("connectedRec(a, e) deberia dar true:  " + g.connectedRec("a", "e"));
        System.out.println("connectedRec2(a, e) deberia dar [a, b, c, d, e]:  " + g.connectedRec2("a", "e").toString());
        System.out.println("connectedRec(d, b) deberia dar true:  " +
                g.connectedRec("d", "b"));
        System.out.println("connectedRec2(d, b) deberia dar [d, e, c, a, b]:  " + g.connectedRec2("d", "b").toString());

        System.out.println("connectedRec(f, b) deberia dar false: " + g.connectedRec("f", "b"));
        System.out.println("connectedRec2(f, b) deberia dar []:  " +  g.connectedRec2("f", "b").toString());

    }
}