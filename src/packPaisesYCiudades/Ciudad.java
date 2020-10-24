package packPaisesYCiudades;

public class Ciudad {
    String nom;
    int hab;
    Ciudad next;

    public Ciudad(String pNom, int pHab, Ciudad pNext) {
        this.nom = pNom;
        this.hab = pHab;
        this.next = pNext;
    }
}
