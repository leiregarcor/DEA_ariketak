package packEzabatuAzpilista;

public class DoubleLinkedList<T> {
	DoubleNode<T> first;
	
	
	public void ezabatuLista(DoubleLinkedList<T> azpilista) {
		/*
		 * pre: "azpilista" uneko listaren zati bat da "azpilista" zerrendako elementuak ordena berean daude lista nagusian
		 * post: "azpilista" osoa kendu egin da zerrendatik
		 */
		boolean pasata=false;
		DoubleNode<T> lag1= azpilista.first;
		DoubleNode<T> lag2= first;
		if(lag1==null || lag2==null) {
			
		}else {
			while(!pasata && lag2!=null) {
				if(lag1.data==lag2.data) {
					if(lag2==first) {
						first=lag2.next;
					}
					if(lag2.next==lag2) {
						first=null;
						lag2=null;
					}else {
						lag2.next.prev= lag2.prev;
						lag2.prev.next= lag2.next;
						lag2=lag2.next;
						lag1=lag1.next;
					}
				}else {
					lag2=lag2.next;
				}
				if(lag1==azpilista.first) {
					pasata=true;
				}
			}
		}
	}
	
	public void imprimatuLista() {
		boolean pasata=false;
		DoubleNode<T> aux=first;
		if(aux==null) {
			
		}else {
			while(!pasata) {
				System.out.println(aux.data);
				aux=aux.next;
				if(aux==first) {
					pasata=true;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		//Lista eta sublista tamaina desberdinekoak dira
		
		DoubleLinkedList<String> l1= new DoubleLinkedList<String>();
		DoubleLinkedList<String> l2= new DoubleLinkedList<String>();
		
		DoubleNode<String> n1= new DoubleNode<String>("Ana");
		DoubleNode<String> n2= new DoubleNode<String>("Jon");
		DoubleNode<String> n3= new DoubleNode<String>("Amaia");
		DoubleNode<String> n4= new DoubleNode<String>("Leire");
		
		DoubleNode<String> n11= new DoubleNode<String>("Ana");
		DoubleNode<String> n12= new DoubleNode<String>("Jon");
		DoubleNode<String> n13= new DoubleNode<String>("Amaia");
		
		n1.next=n2;
		n1.prev=n4;
		n2.next=n3;
		n2.prev=n1;
		n3.next=n4;
		n3.prev=n2;
		n4.next=n1;
		n4.prev=n3;
		
		n11.next=n12;
		n11.prev=n13;
		n12.next=n13;
		n12.prev=n11;
		n13.next=n11;
		n13.prev=n12;
		
		l1.first=n1;
		l2.first=n11;
		
		// Lista eta sublista tamaina berekoak dira
		
		DoubleLinkedList<String> l3= new DoubleLinkedList<String>();
		
		DoubleNode<String> n21= new DoubleNode<String>("Ana");
		DoubleNode<String> n22= new DoubleNode<String>("Jon");
		DoubleNode<String> n23= new DoubleNode<String>("Amaia");
		DoubleNode<String> n24= new DoubleNode<String>("Leire");
		
		n21.next=n22;
		n21.prev=n24;
		n22.next=n23;
		n22.prev=n21;
		n23.next=n24;
		n23.prev=n22;
		n24.next=n21;
		n24.prev=n23;
		
		l3.first=n21;
		
		DoubleLinkedList<String> l4= new DoubleLinkedList<String>();
		
		DoubleNode<String> n31= new DoubleNode<String>("Ana");
		DoubleNode<String> n32= new DoubleNode<String>("Jon");
		DoubleNode<String> n33= new DoubleNode<String>("Amaia");
		DoubleNode<String> n34= new DoubleNode<String>("Leire");
		
		n31.next=n32;
		n31.prev=n34;
		n32.next=n33;
		n32.prev=n31;
		n33.next=n34;
		n33.prev=n32;
		n34.next=n31;
		n34.prev=n33;
	
		l4.first=n31;
		
		DoubleLinkedList<String> l5= new DoubleLinkedList<String>();
		l5.first=null;
		
		DoubleLinkedList<String> l6= new DoubleLinkedList<String>();
		l6.first=null;
		
		System.out.println("Bi listak null direnean, lehen:");
		l5.imprimatuLista();
		System.out.println("Emaitza");
		l5.ezabatuLista(l6);
		l5.imprimatuLista();
		
		System.out.println("Azpilista null denean, lehen:");
		l1.imprimatuLista();
		System.out.println("Emaitza");
		l1.ezabatuLista(l6);
		l1.imprimatuLista();
		
		
		System.out.println("Azpilista lista baino txikiagoa denean, lehen");
		l1.imprimatuLista();
		System.out.println("Emaitza");
		l1.ezabatuLista(l2);
		l1.imprimatuLista();
		
		
		System.out.println("Azpilista lista bezain handia denean, lehen");
		l3.imprimatuLista();
		System.out.println("Emaitza");
		l3.ezabatuLista(l4);
		l3.imprimatuLista();
		
		
		
		
	}
	
	
	
}
