package packPaisesYCiudades;

public class Pais {
    String nom;
    Ciudad capi, first;
    Pais next;

    //eriakitzailea
    public Pais(String pNom, Ciudad pCapi, Ciudad pFirst) {
        this.nom = pNom;
        this.capi = pCapi;
        this.first = pFirst;
        this.next = null;
    }

    public void imprimirPais(){
        System.out.println("/// CIUDAD ///: " + nom );
        Ciudad unekoa=first;
        System.out.println(" CAPITAL: " + capi );
        while(unekoa.next!=null){
            unekoa.imprimirCiudad();
            unekoa=unekoa.next;
        }
    }



}

