package infiniteGalaxy;


import java.util.ArrayList;
import java.util.List;


public class GamePlay {
	/*Feladata: 
	 * 1. Jatekosok előkészítése
	 * 2.Véget ér ha valaki eléri a 21 v. több pontot
	 * 3. Körök futtása - start
	 * 	3.1 Dobokockák számának meghatározása
	 * 	3.2 Dobás
	 * 	3.3 Kockák aktiválása
	 * 	3.4 Kockák újradobása
	 * 	3.5	Másik játékos követése
	 * 	3.6 Győzelmipontok ellenőrzése
	 * */
	
	
	List<Gamer> gamerList = new ArrayList<>();
	

	public void runTurns() {
		//adattagok
		
		
		
		//Előkészítés
		gamerList.add(new Gamer(Color.Blue));
		gamerList.add(new Gamer(Color.Green));
		
		//Játék
		for (Gamer gamer : gamerList) {
			int rollDiceNumbers = calculateRollDiceNumber(gamer);
			gamer.throwDice(rollDiceNumbers);
			while (gamer.currentActions.size() != 0) {
				gamer.ChooseAction(gamer.currentActions);
			}
			
			
		}
		
		
		
		
	}

	

	public void checkVicoryPoints() {
		// TODO Auto-generated method stub
		
	}

	public void followPlayer() {
		// TODO Auto-generated method stub
		
	}

	public void reRollDices() {
		// TODO Auto-generated method stub
		
	}

	public void activateDiceses() {
		// TODO Auto-generated method stub
		
	}

	public int calculateRollDiceNumber(Gamer gamer) {
		int diceNumbers;
		switch (gamer.getEmpireMarker()) {
		case 2:
			diceNumbers = 5;
			gamer.setSpaceships(2);
			break;
		case 3:
			diceNumbers = 5;
			gamer.setSpaceships(3);
			break;
		case 4:
			diceNumbers = 6;
			gamer.setSpaceships(3);
			break;
		case 5:
			diceNumbers = 6;
			gamer.setSpaceships(4);
			break;
		case 6:
			diceNumbers = 7;
			gamer.setSpaceships(4);
			break;

		default:
			diceNumbers = 4;
			gamer.setSpaceships(2);
			break;
		}
		return diceNumbers;
		
	}

	

}
