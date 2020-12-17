package pack2Partziala;

import java.util.LinkedList;
import java.util.Queue;

public class RadixSortS {

        public void ordRaiz(String[] a, int maxLetras){
            //pre: maxLetras indica el número de letras de las palabras a ordenar, y tdas las letras son minusculas
            //     entre la 'a' y 'z'.
            //post: a está ordenado ascendentemente
            Queue<String>[] ilara = (LinkedList<String>[]) new LinkedList[26];
            for (int i=0; i<ilara.length;i++){
                ilara[i]=new LinkedList<>();
            }
            int kont=0;
            for (int k=0; k<maxLetras; k++){
                for (String s:a){
                    ilara[posChar(s.charAt(maxLetras-1-k))].add(s);
                }
                kont=0;
                for (int j=0; j< ilara.length; j++){
                    while(!ilara[j].isEmpty()){
                        a[kont]=ilara[j].remove();
                        kont++;
                    }
                }
            }
            printEma(a);
        }
        private void printEma(String[] a){
            for (String s:a){
                System.out.println(s);
            }
        }
        private int posChar(char c){
            if (c == 'a'){
                return 0;
            }
            if (c == 'b'){
                return 1;
            }
            if (c == 'c'){
                return 2;
            }
            if (c == 'd'){
                return 3;
            }
            if (c == 'e'){
                return 4;
            }
            if (c == 'f'){
                return 5;
            }
            if (c == 'g'){
                return 6;
            }
            if (c == 'h'){
                return 7;
            }
            if (c == 'i'){
                return 8;
            }
            if (c == 'j'){
                return 9;
            }
            if (c == 'k'){
                return 10;
            }
            if (c == 'l'){
                return 11;
            }
            if (c == 'm'){
                return 12;
            }
            if (c == 'n'){
                return 13;
            }
            if (c == 'o'){
                return 14;
            }
            if (c == 'p'){
                return 15;
            }
            if (c == 'q'){
                return 16;
            }
            if (c == 'r'){
                return 17;
            }
            if (c == 's'){
                return 18;
            }
            if (c == 't'){
                return 19;
            }
            if (c == 'u'){
                return 20;
            }
            if (c == 'v'){
                return 21;
            }
            if (c == 'w'){
                return 22;
            }
            if (c == 'x'){
                return 23;
            }
            if (c == 'y'){
                return 24;
            }
            else{
                return 25;
            }
        }
        public static void main(String[] args) {
            System.out.println(" ");
            System.out.println("Aitor y Leire");
            System.out.println(" ");
            RadixSortS r= new RadixSortS();
            String[]s= {"aye","yea","aya","yay","eda","aca","bea","cae"};
            System.out.println("Lista ordenatu gabe");
            r.printEma(s);
            System.out.println(" ");
            System.out.println("Lista ordenatuta");
            r.ordRaiz(s,3);
        }

}


