
public class Scoreboard {

	static Integer pointA = 0;
	static Integer pointB = 0;
	static Integer gameA = 0,gameB = 0;
	static Integer setA = 0,setB = 0;
	static Integer matchA = 0,matchB = 0;
	
	
	public static void main(String[] args) {
		String input = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		updateScoreboard(input);
		
	}

	private static void updateScoreboard(String input) {
		for(char ch : input.toCharArray()) {
			updatePoint(ch);
			printScoreboard();
			checkAndPrintWin();
		}
	}

	private static void checkAndPrintWin() {
		if(matchA ==1)
			p("A WON THE MATCH !!\n");
		else if(matchB == 1)
			p("B WON THE MATCH !!\n");
	}
	private static void printScoreboard() {

		p("     SET       GAME      POINT   \n");
		p("---------------------------------\n");
		p("A :\t"+setA+"\t"+gameA+"\t"+pointA+"\n");
		p("B :\t"+setB+"\t"+gameB+"\t"+pointB+"\n");
		p("---------------------------------\n");
		
	}

	public static void p(Object o) {
		System.out.print(o);
	}
	
	private static void updatePoint(char ch) {
		
		if(ch == 'A') {
			pointA = pointA + 1;
			if((pointA >= 4) && (pointA-pointB >= 2)){
					pointA = pointB = 0;
					updateGame(ch);
					return;
				}	
			}
		else {
			pointB = pointB + 1;
			if((pointB >= 4) && (pointB-pointA >= 2)){
				pointA = pointB = 0;
				updateGame(ch);
				return;
			}	
		}
		
		
	}

	private static void updateGame(char ch) {
		
		if(ch == 'A') {
			gameA = gameA + 1;
			if((gameA >= 6) && (gameA-gameB >= 2)){
					gameA = gameB = 0;
					updateSet(ch);
					return;
				}	
			}
		else {
			gameB = gameB + 1;
			if((gameB >= 6) && (gameB-gameA >= 2)){
				gameA = gameB = 0;
				updateSet(ch);
				return;
			}	
		}
		
		
	}

	private static void updateSet(char ch) {
		
		if(ch == 'A') {
			setA = setA + 1;
			if(setA == 2)
				matchA++;
		}
		else {
			setB = setB + 1;
			if(setB == 2)
				matchB++;
			}	
	}
	
	
}
