package packRadixSort;

import java.util.LinkedList;

public class RadixSortMart {
    public void radixSort(Integer[] a, int maxCifras) {
        // Pre: maxCifras indica el número de cifras del elemento mayor de a



        // Crear la lista de colas.
        LinkedList<Integer>[] ilarak = (LinkedList<Integer>[]) new LinkedList[10];

        // Inicializar las colas
        for (int i = 0; i < ilarak.length; i++) {
            ilarak[i] = new LinkedList<Integer>();
        }




        // Recorremos el array a y vamos metiendo los valores

        int x;
        int pot = 1;
        for (int it = 0; it< maxCifras; it++)
        {
            if (it == 0){ // La primera vez, cargamos los datos en la tabla
                for(int balioa:a)
                {
                    ilarak[balioa%10].add(balioa);
                }
            }else // Despues, trabajamos solo con la tabla
            {
                // Crear la lista de colas.
                LinkedList<Integer>[] auxiliar = (LinkedList<Integer>[]) new LinkedList[10];

                // Inicializar las colas
                for (int i = 0; i < auxiliar.length; i++) {
                    auxiliar[i] = new LinkedList<Integer>();
                }



                for (int index = 0; index < ilarak.length; index++)
                {
                    while (!ilarak[index].isEmpty())
                    {
                        x = ilarak[index].poll();
                        auxiliar[(x/pot)%10].add(x);
                    }
                }
                ilarak = auxiliar;
            }
            pot *= 10;
        }

        // Ahora, metemos las cifras ordenadas en el Array de vuelta.

        int pos = 0;
        for (int ilara = 0; ilara < ilarak.length; ilara++)
        {
            while(!ilarak[ilara].isEmpty())
            {
                a[pos] = ilarak[ilara].poll();
                pos++;
            }
        }


    }




    public static void main(String[] args) { // prueba radix sort con palabras


        Integer[] a = {101, 207, 198, 713, 542, 23, 78, 2, 966, 205};


        System.out.println("Bektorea ordenatu gabe honakoa da:");
        for (int i = 0; i < a.length; i++) {
            System.out.print("     " + a[i]);
        }


        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");

        System.out.println("Eta RadixSort metodoarekin ordenatuz, honakoa daukagu.");
        new RadixSortMart
                ().radixSort(a, 3);
        for (int i = 0; i < a.length; i++) {
            System.out.print("     " + a[i]);
        }




    }
}
