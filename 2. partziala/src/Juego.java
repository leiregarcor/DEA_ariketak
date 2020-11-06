package azt;

import java.util.ArrayList;
import java.util.Stack;

public class Juego {
	
	public int jokatu(int jokKopurua, int billeteak, ArrayList<Pago> ordainketak) {
		// Precondición:  2 <=  nJugadores <= 20
		//                nBilletesInicial >= 1
		//                Todos los pagos de la lista “pagos” son correctos,
		//                 es decir, un jugador siempre tiene los billetes 
		//                 necesarios para realizar sus pagos 
		// Postcondición: el resultado es el número de billetes verdaderos 
		//                 del jugador 0 al acabar la partida

		
		Stack<Boolean>[] jokalariak = (Stack<Boolean>[]) new Stack[jokKopurua];

		
		// Partidaren hasieraketa
		boolean lehena;
		for (int i = 0; i < jokalariak.length; i++)
		{
			jokalariak[i] = new Stack<Boolean>();
			lehena = true;
			for (Stack<Boolean> jok : jokalariak)
			{
				for (int j = 1; j<=billeteak; j++)
				{
					if (lehena)
					{
						jok.push(false);
					}
					else
					{
						jok.push(true);
					}
				}
			}
			lehena = false;
		}
		
		// hasieraketen amaiera
		
		
		// ordainketak egiteko buklea
		for (Pago ord: ordainketak)
		{
			for (int i = 1; i<=ord.cantidad; i++)
			{
				boolean b = jokalariak[ord.pagador].pop();
				jokalariak[ord.cobrador].push(b);
			}
		}
		// ordainketen amaiera
	
		// kontatu 0-garren jokalariaren billete onen kopurua (buklea)
		int billeteonkop = 0;
		
		// falta por rellenar este kode
		
		// kontaketaren amaiera
		return billeteonkop;

		
		
		// KOSTUA:
		// n = jokalari kopurua
		// o = ordainketa kopurua
		// b = hasierako billete kopurua
		// p = billete kopurua ordainketa bakoitzeko (batazbesteko zenbat gastatzen du partida bakoitzean)
		
		
		
		// O (n + n*b + o*p + b) 
		// Ez dauka klasifikaziorik, hau da, ez dakigu koadratikoa den edo zer, orduan honela uzten dugu.
	}
}
