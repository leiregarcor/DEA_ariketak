package packPaisesYCiudades;

public class Ciudad {
    String nom;
    int hab;
    Ciudad sig;

    public Ciudad(String pNom, int pHab, Ciudad pSig) {
        this.nom = pNom;
        this.hab = pHab;
        this.sig = pSig;
    }
}
