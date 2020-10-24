package packPaisesYCiudades;

public class Ciudad {
    String nom;
    int hab;
    Ciudad next;

    //eriakitzailea
    public Ciudad(String pNom, int pHab) {
        this.nom = pNom;
        this.hab = pHab;
        this.next = null;
    }

    public void imprimirCiudad(){
        System.out.println(" CIUDAD: "+ nom + " NUM HABITANTES: ");
    }



}
