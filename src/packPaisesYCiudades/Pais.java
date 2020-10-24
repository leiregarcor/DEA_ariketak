package packPaisesYCiudades;

public class Pais {
    String nom;
    Ciudad capi, prime;
    Pais next;

    public Pais(String pNom, Ciudad pCapi, Ciudad pPrime, Pais pNext) {
        this.nom = pNom;
        this.capi = pCapi;
        this.prime = pPrime;
        this.next = pNext;
    }

    //eriakitzailea


}

