package package1;

public class Main {

	public static void main(String[] args) {
//		char[][] spielfeld = spielfeldErstellen(3, 3);
//		spielfeldAnzeigen(spielfeld);
		
		
		
		int[][] feld = new int[5][5];
		feld[1][1] = 1;
		
		for (int i = 0; i < feld.length; i++) {
			System.out.print("|");
			for (int j = 0; j < feld[i].length; j++) {
//				if (i == 0 && j == 0) System.out.println("#");
				System.out.print(feld[i][j]);
			}
			System.out.println("|");
		}
	}
	
	public static char[][] spielfeldErstellen(int felderH, int felderV) {
		
		int grenzeH = felderH + 1;
		int grenzeV = felderV + 1;
		
		// [Vertikal][Horizontal]
		char[][] spielfeld = new char[felderV][felderH];
		
		// Vertikal
		for(int v = 0; v <= grenzeV; v++) {
			
			// Horizontal
			for(int h = 0; h <= grenzeH; h++) {
				
				if(
						// Links Oben +
						(h == 0 && v == 0) || 
						
						// Links Unten +
						((v == grenzeV) && ( h == 0)) ||
						
						// Rechts Oben +
						((h == grenzeV) && (v == 0)) ||
						
						// Rechts Unten +
						((v == grenzeV) && (h == grenzeH))
						) {
					//System.out.print("+");
					spielfeld[v][h] = '+';
				} else {
					// An den Rändern Striche | ausgeben
					if((h == 0) || (h == grenzeH)) {
						//System.out.print("|");
						spielfeld[v][h] = '|';
					}
					// An den Rändern Striche - ausgeben
					if((v == 0) || (v == grenzeV)) {
						//System.out.print("-");
						spielfeld[v][h] = '-';
					}
				}
			}
			System.out.print("\n");
		}
		return spielfeld;
	}
	
	public static void spielfeldAnzeigen(char[][] spielfeld) {
		
	}
}