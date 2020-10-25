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
        System.out.println(" // MAPA // " );
        Pais unekoa= first;
        while(unekoa.next!=null){
            unekoa.imprimirPais();
            unekoa=unekoa.next;
        }
        unekoa.imprimirPais();
    }

    public static void main(String[] args) {
        //capiatl
            //francia
        Ciudad c1= new Ciudad("Paris", 0); //capital
            //bulgaria
        Ciudad c2= new Ciudad("Sofia", 666); //capital
        Ciudad c3 = new Ciudad("Ruse", 45); //se va a eliminar
        Ciudad c8= new Ciudad("Varna", 100);
        //no capital
            //españa
        Ciudad c4= new Ciudad("Bilbo", 0); // es el primero y se va a eliminar
        Ciudad c5= new Ciudad("Zaragoza", 100);
        Ciudad c6= new Ciudad("Sevilla", 18); //se va a eliminar
        Ciudad c7= new Ciudad("Barcelona", 50);
            //portugal
        Ciudad c9= new Ciudad("Oporto", 500); //es el primero y no se elimina
        Ciudad c10= new Ciudad("Lisboa", 35); //se elimina
        Ciudad c11= new Ciudad("Lagos", 416);
            //Italia
        Ciudad c12= new Ciudad("Milan", 26); //se elimina
        Ciudad c13= new Ciudad("Roma", 35); //se elimina
        Ciudad c14= new Ciudad("Verona", 42); //se elimina



        //c1.next es null por el eraikitzaile
        //ciudades de bulgaria
        c2.next=c3;
        c3.next= c8; //c8 next es null por el eraikitzaile
        //ciudades de España
        c4.next=c5;
        c5.next=c6;
        c6.next=c7; //c7 next es null por el eraikitzaile
        //ciudades de portugal
        c9.next=c10;
        c10.next=c11; //c11 next es null por el eraikitzaile
        //ciudades italia
        c12.next=c13;
        c13.next= c14; //c14 next es null por el eraikitzaile


        //capital == first (no se eliminara la capital)->
        Pais p1= new Pais("Francia",c1,c1);//capital (no supera N) y es el único elemneto
        Pais p2= new Pais("Bulgaria",c2, c2 ); //capital (supera N) y hay más elementos
        //no hay capital->
        Pais p3= new Pais("España",null,c4);// first no supera N (es eliminada)
        Pais p4= new Pais("Portugal",null,c9);// first supera N (no es eliminado)
        Pais p5= new Pais ("Italia", null, c12);//se queda sin ciudaes y se elimina
        Pais p6= new Pais ("Suiza", null, null);//no tenia ciudades y se elimina


        Mapa m= new Mapa();
        m.first=p1;

        p1.next=p2;
        p2.next=p3;
        p3.next= p4;
        p4.next= p5;
        p5.next= p6; //p6 next es null por el eraikitzaile


        System.out.println("############ MAPA ANTES DE LLAMAR A METODO ############" );
        System.out.println("");
        m.imprimirMapa();
        System.out.println("");
        int pN= 50;
        m.eliminaCiudadesQueNoSuperanNHabitantes(m, pN);
        System.out.println("");
        System.out.println("############ MAPA DESPUÉS DE LLAMAR A METODO ############" );
        System.out.println("");
        m.imprimirMapa();

    }

}
