package packBlokeenJokoa;

import java.util.Stack;

public class Jokoa {


    public static class Bloke {
        int puntuak;
        int jauzia; // 0 eta 6 arteko balioa
        String norabidea; // ‘i’ -> ezkerra, ‘d’ -> eskuina

        public Bloke(int puntuak, int jauzia, String norabidea) {
            this.puntuak = puntuak;
            this.jauzia = jauzia;
            this.norabidea = norabidea;
        }
    }

    Stack<Bloke>[] taula; // pilen array-a
    public static int ZUTABEKOP = 7;
    public Jokoa() { // eraikitzailea
        taula = (Stack<Bloke>[]) new Stack[ZUTABEKOP];
        for (int i = 0; i <= ZUTABEKOP - 1; i++) {
            taula[i] = new Stack<Bloke>();
        }
        Bloke b = new Bloke(5,3,"d");
        for (int i=0; i<3; i++){
            taula[0].push(b); //d3
            taula[2].push(b); //d3
            taula[6].push(b); //d3
        }
        taula[1].push(b); //d3
        Bloke b1= new Bloke(5,1,"i");
        taula[1].push(b1); //i1
        taula[1].push(b); //d3

        b1= new Bloke(5,3,"i");
        taula[3].push(b1); //i3

        taula[4].push(b); //d3
        taula[4].push(b); //d3
        taula[4].push(b1); //i


        b1 = new Bloke(5,0,"d");
        taula[3].push(b1); //d0
        b1 = new Bloke(5,2,"d");
        taula[3].push(b1); //d2

        taula[5].push(b); //d3
        b1= new Bloke(5,2,"i");
        taula[5].push(b1); //d2
        b1= new Bloke(5,3,"i");
        taula[5].push(b1); //i3

    }
    public int jokatu() {
        // Aurre: jokoa hasieratua izan da (hasierako blokeak sortu dira)
        // Post: partida bat jokatu da. Bola erdiko zutabean hasten da.
        // Emaitza lortutako puntu-kopurua izango da, jokoa gainditu
        // baldin bada, eta -1 bestela
        int ema=0;
        int pos=3;
        boolean bukaera= false;
        Bloke b;
        while (!bukaera ){
            b= taula[pos].pop();
            ema = ema + b.puntuak;
            if (b.norabidea.equals("i")){
                pos=pos - b.jauzia;
            }
            else{
                pos = pos + b.jauzia;
            }
            if(pos<0 || pos>6){
                bukaera=true;
                ema=-1;
            }
            else if(taula[pos].isEmpty()){
                bukaera = true;
            }
        }
        System.out.println(" ");
        System.out.println(ema);
        System.out.println(" ");
        return ema;
    }

    public static void main(String[] args) {
        Jokoa j = new Jokoa();
        j.jokatu();


    }
}
