package package1;

public class testen2 {

	static int[][] spielfeld = {
			{1, 0, 0},
			{0, 1, 1},
 			{1, 1, 0}
	};
	
	static int[][] zweiteGen = new int[spielfeld.length][spielfeld[spielfeld.length - 1].length];
	
	public static void main(String[] args) {

		// 1 = Eine Generation, 3 = Drei Generationen
		generationen(1);
		neueGen();
	}
	
	public static void generationen(int gen) {
		for(int schritt = 0; schritt < gen; schritt++) {
			System.out.println("Generation: " + (schritt + 1));
			
			// jedes Feld durchgehen
			felderPruefen(spielfeld);
			System.out.print("\n");
		}
	}
	
	public static void felderPruefen(int[][] feld) {
		for(int reihe = 0; reihe < feld.length; reihe++) {
			for(int zeile = 0; zeile < feld[feld.length - 1].length; zeile++) {
				
				System.out.println("Zeile: " + zeile + " Reihe: " + reihe);
				
				// 3x3 Feld prüfen
				feldPruefen(reihe, zeile);
			}
			// System.out.print("\n");
		}
	}
	
	public static void feldPruefen(int reihe, int zeile) {
		
		// Tote Zelle: 		3 Nachbarn 				> wiederbelebt
		// Lebende Zelle: 	wengier als 2 Nachbarn 	> stirbt
		// Lebende Zelle: 	2 oder 3 Nachbarn 		> lebt weiter
		// Lebende Zelle: 	mehr als 3 Nachbarn 	> stirbt
		// Für jede Regeln neu überprüfen ...?
		
		boolean lebendig = false;
		int nachbarAnzahl = 0;
		
		// 3x3 Feld prüfen
		for(int i = -1; i <= 1; i++) {			
			for(int j = -1; j <= 1; j++) {
				
				// nachbarAnzahl addieren
				try {
					if(!(i == 0 && j == 0)) {
						nachbarAnzahl += spielfeld[reihe + j][zeile + i];
					}
				} catch(Exception ex) {
					// nichts
				}
				
				try {
					// Mitterle Zelle überprüfen
					if(i == 0 && j == 0) {
						
						if(spielfeld[reihe][zeile] < 1) {
							// Wenn Zelle tot dann '-'
							// System.out.print('-'); // Tote Zelle
							lebendig = false;
						} else {
							// Wenn mittlere Zelle lebendig, dann '+'
							// System.out.print('+'); // Lebende Zelle
							lebendig = true;
						}
						
					} else {
						// Sonst normale Zahlen ausgeben
						// System.out.print(spielfeld[reihe + i][zeile + j]);
					}
					
				} catch (Exception ex) {
					// Wenn kein Zahl gibt (ausserhalb von Spielfeld)
					// System.out.print('x'); // '0' ?
				}
			}
			// System.out.print("\n");
		}
		System.out.println("Nachbarn: " + nachbarAnzahl);
		
		zelleStatus(lebendig, nachbarAnzahl, reihe, zeile);
		
		// wieder auf Standard zurücksetzen
		nachbarAnzahl = 0;
		lebendig = false;
	}
	
	public static void zelleStatus(boolean lebendig, int nachbarAnzahl, int reihe, int zeile) {
		// Tote Zelle: 		3 Nachbarn 				> wiederbelebt
		if((lebendig == false) && nachbarAnzahl == 3) {
			System.out.println("Zelle wiederbelebt");
			zweiteGen[reihe][zeile] = 1;
		}
		
		// Lebende Zelle: 	wengier als 2 Nachbarn 	> stirbt
		// Lebende Zelle: 	mehr als 3 Nachbarn 	> stirbt
		if((lebendig == true) && (nachbarAnzahl < 2 || nachbarAnzahl > 3)) {
			System.out.println("Zelle stirbt");
			zweiteGen[reihe][zeile] = 0;
		}
		
		// Lebende Zelle: 	2 oder 3 Nachbarn 		> lebt weiter
		if((lebendig == true) && (nachbarAnzahl == 2) || (nachbarAnzahl == 3)) {
			System.out.println("Zelle lebt weiter");
			zweiteGen[reihe][zeile] = 1;
		}
		
		// nicht nötig, nur für die Ausgabe
		if((lebendig == false) && (nachbarAnzahl < 3 || nachbarAnzahl > 3)) {
			System.out.println("Passiert nichts");
			zweiteGen[reihe][zeile] = 0; //?
		}
	}
	
	public static void neueGen() {
		
		System.out.println("Zweite Generation");
		for(int i = 0; i < zweiteGen.length; i++) {
			for(int j = 0; j < zweiteGen[zweiteGen.length - 1].length; j++) {
				System.out.print(zweiteGen[i][j]);
			}
			System.out.print("\n");
		}
	}
}
