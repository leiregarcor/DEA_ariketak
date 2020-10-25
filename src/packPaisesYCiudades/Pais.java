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
        System.out.println("/// PAIS ///: " + this.nom );
        Ciudad unekoa=first;
        if(unekoa!=null){ //si hay elementos en la lista
            if (this.capi!=null) {
                System.out.println(" CAPITAL: " + this.capi.getNom());
            }
            while(unekoa.next!=null){
                unekoa.imprimirCiudad();
                unekoa=unekoa.next;
            }
            unekoa.imprimirCiudad();
        }
    }



}

