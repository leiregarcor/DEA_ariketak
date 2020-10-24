package packEnero2013;

public class DoubleLinkedList<T> {
	DoubleNode<T> first;
	
	public T obtenerSupervivientes(Integer salto) {
		/* pre:  la lista tiene almenos un elemento
		 * 
		 * post: devueleve un elemento, resultado de eleminar un elemento de la lista 
		 * correspondiente a salto (en le sentido de las agujas del reloj) hasat que 
		 * solo quede un elemento
		*/
		DoubleNode<T> unekoa=first;
		int kont;
		while(unekoa!=unekoa.next) {
			kont=0;
			
			
			while(kont<salto-1) { //empieza en la posicion 0 que se cuenta
				unekoa=unekoa.next;
				kont ++;
			}
			if(unekoa==first) {
				first=unekoa.next; //para no perder la lista
			}
			unekoa.prev.next= unekoa.next;
			unekoa.next.prev=unekoa.prev;
			unekoa=first;
		}
		return first.data;
	}
	
	
	
	public DoubleLinkedList(){//eraikitzailea
		first=null;
	}
	
	public static void main(String[] args) {
		DoubleLinkedList<String> d= new DoubleLinkedList<String>();
		
		DoubleNode<String> ana= new DoubleNode<String>();
		DoubleNode<String> jon= new DoubleNode<String>();
		DoubleNode<String> amaia= new DoubleNode<String>();
		DoubleNode<String> luis= new DoubleNode<String>();
		DoubleNode<String> ander= new DoubleNode<String>();
		
		ana.data= "Ana";
		ana.next= jon;
		ana.prev= ander;
		
		jon.data= "Jon";
		jon.next= amaia;
		jon.prev= ana;
		
		amaia.data= "Amaia";
		amaia.next= luis;
		amaia.prev= jon;
		
		luis.data= "Luis";
		luis.next= ander;
		luis.prev= amaia;
		
		ander.data= "Ander";
		ander.next= ana;
		ander.prev= luis;
		
		d.first=ana;
		
		Object ema=d.obtenerSupervivientes(4);
		System.out.println(ema);
		
		
	}
}
