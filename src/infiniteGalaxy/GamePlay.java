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
	List<Planet> planettList = new ArrayList<>();
	

	public void runTurns() {
		//Előkészítés
		planettList.add(new Planet("Gordius",PlanetResourceType.Civilization,PlanetColonizeType.Economy, 2, 1, ()-> System.out.println("Itt lesz a bolgyó képessége")));
		planettList.add(new Planet("Palangus",PlanetResourceType.Energy,PlanetColonizeType.Economy, 5, 5, ()-> System.out.println("Itt lesz a bolgyó képessége")));
		planettList.add(new Planet("Tatoine",PlanetResourceType.Civilization,PlanetColonizeType.Economy, 6, 7, ()-> System.out.println("Itt lesz a bolgyó képessége")));
		planettList.add(new Planet("Corusant",PlanetResourceType.Civilization,PlanetColonizeType.Economy, 6, 7, ()-> System.out.println("Itt lesz a bolgyó képessége")));
		planettList.add(new Planet("Naboo",PlanetResourceType.Energy,PlanetColonizeType.Economy, 6, 7, ()-> System.out.println("Itt lesz a bolgyó képessége")));
		planettList.add(new Planet("Navarro",PlanetResourceType.Civilization,PlanetColonizeType.Economy, 3, 2, ()-> System.out.println("Itt lesz a bolgyó képessége")));
		planettList.add(new Planet("Havok",PlanetResourceType.Energy,PlanetColonizeType.Diplomacy, 5, 5, ()-> System.out.println("Itt lesz a bolgyó képessége")));
		planettList.add(new Planet("Endor",PlanetResourceType.Energy,PlanetColonizeType.Diplomacy, 3, 2, ()-> System.out.println("Itt lesz a bolgyó képessége")));
		planettList.add(new Planet("Javyn",PlanetResourceType.Energy,PlanetColonizeType.Economy, 5, 5, ()-> System.out.println("Itt lesz a bolgyó képessége")));
		
		
		gamerList.add(new Gamer(ColorEnums.Blue));
		System.out.println(gamerList.get(0).toString());
		System.out.println(gamerList.get(0).gamerShips);
		gamerList.add(new Gamer(ColorEnums.Green));
		System.out.println(gamerList.get(1).toString());
		System.out.println(gamerList.get(1).gamerShips);
		//Játék
		for (Gamer gamer : gamerList) {
			int rollDiceNumbers = calculateRollDiceNumber(gamer);
			gamer.throwDice(rollDiceNumbers);
			while (gamer.currentActions.size() != 0) {
				gamer.ChooseAction(gamer.currentActions, planettList);
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
			gamer.addSpaceships(2);
			break;
		case 3:
			diceNumbers = 5;
			gamer.addSpaceships(3);
			break;
		case 4:
			diceNumbers = 6;
			gamer.addSpaceships(3);
			break;
		case 5:
			diceNumbers = 6;
			gamer.addSpaceships(4);
			break;
		case 6:
			diceNumbers = 7;
			gamer.addSpaceships(4);
			break;

		default:
			diceNumbers = 4;
			gamer.addSpaceships(2);
			break;
		}
		return diceNumbers;
		
	}

	

}
