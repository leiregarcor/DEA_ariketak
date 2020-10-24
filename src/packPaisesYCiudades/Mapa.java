package packPaisesYCiudades;

public class Mapa {
    Pais first;

    public void eliminaCiudadesQueNoSuperanNHabitantes(Mapa pM, int pN){
       /*       pre: el mapa tiene almenos un elemento.
        *
        *       post: elimina todas las ciudades (las capitales no) que no superen N miles de habitantes.
        *       Si la capital de un pais no figurara en la lista de ciudades,
        *       el puntero correspondiente tendrá valor null.
        *       Si un pais se quedara sin ciudades debería ser eliminado del mapa.
        */

        Pais pUnekoa= pM.first;
        Pais pAurrekoa= null;
        Ciudad cUnekoa=null;
        Ciudad cAurrekoa= null;

        while (pUnekoa.next != null){//para recorrer la lista de paises
            cUnekoa=pUnekoa.first;
            while (cUnekoa.next!=null){//para recorrer las ciudades de cada pais
                if (cUnekoa!=pUnekoa.capi) {//se eliminará la ciudad si no es una capital
                    if (cUnekoa.hab < pN) {//si los paises no superan N miles de habitantes serán eliminadas
                        if (cUnekoa == pUnekoa.first) {//si es la primera ciudad del pais
                            first = first.next;
                            cUnekoa = cUnekoa.next;
                        } else {//si una ciudad que no es la primera del pais
                            cAurrekoa.next = cUnekoa.next;
                            cUnekoa = cUnekoa.next;
                        }
                    }
                    else {//actualizar punteros para la siguiente iteración
                        cAurrekoa = cUnekoa;
                        cUnekoa = cUnekoa.next;
                    }
                }
                else{//actualizar punteros para la siguiente iteración
                    cAurrekoa = cUnekoa;
                    cUnekoa = cUnekoa.next;
                }
            }//fin while ciudades

            if (pUnekoa.first==null){     //si un pais no tiene ciudades se eliminará del mapa
                if (pM.first==pUnekoa){   //si el primer país del mapa es el que no tiene ciudades
                    first= first.next;
                    pUnekoa=pUnekoa.next;
                }
                else{  //si un pais, q no es el primero, no tiene ciudades
                    pAurrekoa.next=pUnekoa.next;
                    pUnekoa=pUnekoa.next;
                }
            }
            else {//actualizar punteros para la siguiente iteración
                pAurrekoa = pUnekoa;
                pUnekoa = pUnekoa.next;
            }
        }//fin while paises
    }

    public void imprimirMapa(){
        System.out.println(" \/\ MAPA \/\ " );
        Pais unekoa= first;
        while(unekoa.next!=null){
            unekoa.imprimirPais();
            unekoa=unekoa.next;
        }
    }

    public static void main(String[] args) {
        Ciudad c1= new Ciudad("Paris", 0);//francia
        Ciudad c2= new Ciudad("Sofia", 0); //bulgaria
        Ciudad c3 = new Ciudad("")
        Ciudad c4= new Ciudad("Bilbo", 0); //españa
        Ciudad c5= new Ciudad("Zaragoza", 10); //españa
        Ciudad c6= new Ciudad("Sevilla", 110); //españa
        Ciudad c7= new Ciudad("Barcelona", 50); //españa




        c1.next=c2;

        Pais p1= new Pais("Francia",c1,c1);//capital y first son el mismo y es el único elemneto
        Pais p2= new Pais("Bulgaria",c2, c2 ); //capital y first son el mismo pero hay más elementos
        Pais p3= new Pais("España",null,c4);//capital es null

        this.imprimirMapa();

    }

}
