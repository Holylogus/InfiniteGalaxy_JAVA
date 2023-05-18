package infiniteGalaxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Gamer {
	
	private static int gamers;
	private ColorEnums color;
	private int spaceships;
	private int civilizationMarker;
	private int energyMarker;
	private int empireMarker;
	private int victoryPoint;
	public List<ActionsEnums> currentActions = new ArrayList<>();
	public List<ActionsEnums> constatnActions = new ArrayList<>();
	public List<Ships> gamerShips = new ArrayList<>();
	public List<Planet> ownedPlanets = new ArrayList<>();
	public static final Random rnd = new Random();
	public static final Scanner actionScan = new Scanner(System.in);
	
	
	//Constructors
	public Gamer(ColorEnums color, int spaceships, int civilizationMarker, int energyMarker, int empireMarker,
			int victoryPoint) {
		super();
		this.color = color;
		addSpaceships(spaceships);
		setCivilizationMarker(civilizationMarker);
		setEnergyMarker(energyMarker);
		setEmpireMarker(empireMarker);
		setVictoryPoint(victoryPoint);
		gamers++;
	}
	
	public Gamer(ColorEnums color) {
		this(color, 0, 1, 2, 1, 0);
	}
	
	//Getters&Setters
	public int getCivilizationMarker() {
		return civilizationMarker;
	}

	public void setCivilizationMarker(int civilizationMarker) {
		if (civilizationMarker > 7) {
			this.civilizationMarker = 7;
		}
		else if (civilizationMarker < 0) {
			this.civilizationMarker = 0;
		}
		this.civilizationMarker = civilizationMarker;
		
	}

	public int getEmpireMarker() {
		return empireMarker;
	}

	public void setEmpireMarker(int empireMarker) {
		this.empireMarker = empireMarker;
	}
	
	public int getSpaceships() {
		return spaceships;
	}

	public void addSpaceships(int spaceships) {
		if (gamerShips.size() > 4) {
			this.spaceships = 0;
			System.out.println("nem lehet több hajód");
		}
		else if (gamerShips.size() <2) {
			this.spaceships = 2;
		}
		else {
			this.spaceships = spaceships;
		}
		for (int i = 0; i < this.spaceships; i++) {
			this.gamerShips.add(gamerShips.size(), new Ships(gamerShips.size()));
		}
		
		
	}

	public int getEnergyMarker() {
		return energyMarker;
	}

	public void setEnergyMarker(int energyMarker) {
		if (energyMarker > 7) {
			this.energyMarker = 7;
		}
		else if (energyMarker < 0) {
			this.energyMarker = 0;
		}
		this.energyMarker = energyMarker;
	}

	public int getVictoryPoint() {
		return victoryPoint;
	}

	public void setVictoryPoint(int victoryPoint) {
		this.victoryPoint = victoryPoint;
	}
	
	public ColorEnums getColor() {
		return color;
	}
	
	@Override
	public String toString() {
		return "Jatekos [color=" + color + ", spaceships=" + spaceships + ", civilizationMarker=" + civilizationMarker
				+ ", energyMarker=" + energyMarker + ", empireMarker=" + empireMarker + ", victoryPoint=" + victoryPoint
				+ "]";
	}
	
	//usable methods	
	public void throwDice(int diceNumbers) {
		for (int i = 0; i < diceNumbers; i++) {
			int throwDice = rnd.nextInt(6)+1;
			switch (throwDice) {
			case 1:
				this.currentActions.add(ActionsEnums.MoveShips);
				break;
			case 2:
				currentActions.add(ActionsEnums.CollectEnergy);
				break;
			case 3:
				currentActions.add(ActionsEnums.CollectCivilization);
				break;
			case 4:
				currentActions.add(ActionsEnums.Diplomacy);
				break;
			case 5:
				currentActions.add(ActionsEnums.Economy);
				break;
			case 6:
				currentActions.add(ActionsEnums.UsePlanet);
				break;

			default:
				break;
			}
		}
		
	}
	
	public void ChooseAction(List<ActionsEnums> currentActions, List<Planet> planets) {
		
		System.out.println(colorize(this.color) + "Választható Akciók");
		int index = 0;
		for (ActionsEnums actions : currentActions) {	
			System.out.println(colorize(this.color)+ index + ". " + actions);
			index ++;
		}
		int scanner = actionScan.nextInt();
		while (scanner >= currentActions.size() || scanner < 0) {
			System.out.println("A listából válasszon!");
			scanner = actionScan.nextInt();
		}
		if (this.currentActions.get(scanner) == ActionsEnums.CollectCivilization) {
			collectCivilization(gamerShips, planets);
			this.currentActions.remove(scanner);
			this.toString();
		}
		else if (this.currentActions.get(scanner) == ActionsEnums.CollectEnergy) {
			colletEnergy(gamerShips, planets);
			this.currentActions.remove(scanner);
			this.toString();
		}
		else if (this.currentActions.get(scanner) == ActionsEnums.MoveShips) {
			moveShip(ChoosePlanets(planets));
			this.currentActions.remove(scanner);
		}
		else if (this.currentActions.get(scanner) == ActionsEnums.Diplomacy) {
			useDiplomacy(gamerShips, planets);
			this.currentActions.remove(scanner);
		}
		else if (this.currentActions.get(scanner) == ActionsEnums.Economy) {
			useEconomy(gamerShips, planets);
			this.currentActions.remove(scanner);
		}
		else if (this.currentActions.get(scanner) == ActionsEnums.UsePlanet) {
			usePlanet();
			this.currentActions.remove(scanner);
		}
		else if (this.currentActions.get(scanner) == ActionsEnums.DiceChanger) {
			diceChanger();
		}
		else if (this.currentActions.get(scanner) == ActionsEnums.IncreaseEmipreLevel) {
			increaseEmipreLevel();
		}
		else if (this.currentActions.get(scanner) == ActionsEnums.EndTurn) {
			this.currentActions.clear();
		}
		
		
	}

	private void increaseEmipreLevel() {
		// TODO Auto-generated method stub
		
	}

	private void diceChanger() {
		// TODO Auto-generated method stub
		
	}

	private void usePlanet() {
		// TODO Auto-generated method stub
		
	}

	private void useEconomy(List<Ships> ships, List<Planet> planets) {
		List<Planet> choosablePlanets = new ArrayList<>();
		for (Ships ship : ships) {
			for (Planet planet : planets) {
				if (ship.getColonizePosition() == planet.getName() && planet.getPlanetColonizeType() == PlanetColonizeType.Economy) {
					
					choosablePlanets.add(planet);
				}
			}
		}
		System.out.println(colorize(this.getColor()) + "Melyik bolgyón akarsz előre lépni?");
		Planet choosedPLanet = ChoosePlanets(choosablePlanets);
		for (Ships ships2 : ships) {
			if (ships2.getColonizePosition() == choosedPLanet.getName() ) {
				ships2.setColonizeMarker(ships2.getColonizeMarker()+1);
				if (ships2.getColonizeMarker() == choosedPLanet.getColonizeSize()) {
					for (int i = 0; i < planets.size(); i++) {
						if (planets.get(i).getName() == choosedPLanet.getName()) {
							planets.remove(i);
							this.ownedPlanets.add(choosedPLanet);
							System.out.println("Megszerezted a "+choosedPLanet.getName() + " nevű bolygót!"); 
						}
					}
					}
				}
				shipDataDisplay(ships2);
			}
		}

	private void useDiplomacy(List<Ships> ships, List<Planet> planets) {
		// Meg kell vizsgálni, hogy mely hajók állnak diplomácia bolgyón (megjelenités is)
		//Hajó választás érték növeléshez
		//gyarmatosítási mutató növelése
		List<Planet> choosablePlanets = new ArrayList<>();
		for (Ships ship : ships) {
			for (Planet planet : planets) {
				if (ship.getColonizePosition() == planet.getName() && planet.getPlanetColonizeType() == PlanetColonizeType.Diplomacy) {
					
					choosablePlanets.add(planet);
				}
			}
		}
		System.out.println(colorize(this.getColor()) + "Melyik bolgyón akarsz előre lépni?");
		Planet choosedPLanet = ChoosePlanets(choosablePlanets);
		for (Ships ships2 : ships) {
			if (ships2.getColonizePosition() == choosedPLanet.getName() ) {
				ships2.setColonizeMarker(ships2.getColonizeMarker()+1);
				if (ships2.getColonizeMarker() == choosedPLanet.getColonizeSize()) {
					for (int i = 0; i < planets.size(); i++) {
						if (planets.get(i).getName() == choosedPLanet.getName()) {
							planets.remove(i);
							this.ownedPlanets.add(choosedPLanet);
							System.out.println("Megszerezted a "+choosedPLanet.getName() + " nevű bolygót!"); 
						}
					}
					}
				}
				shipDataDisplay(ships2);
			}
		}
		
	//MoveShip - átnézendő
	private void moveShip(Planet planet) {
		System.out.println(colorize(this.getColor()) + "Válaszd ki melyik hajód mozogjon.");
		for (int i = 0; i < this.gamerShips.size(); i++) {
			System.out.println(colorize(this.getColor()) + this.gamerShips.get(i).getiD() + ". hajó");
			
		}
		int scanner = actionScan.nextInt();
		while (scanner > gamerShips.size() || scanner < 0) {
			scanner = actionScan.nextInt();
		}
		System.out.println(colorize(this.getColor()) + "Válasz az alábbi lehetőségek közül.");
		System.out.println(colorize(this.getColor()) + "1. Gyarmatosítás");
		System.out.println(colorize(this.getColor()) + "2. Landolás");
		int landScan = actionScan.nextInt();
		while (landScan < 1 && landScan > 2) {
			System.out.println(colorize(this.getColor()) + "A felsorolt lehetőségek közül válassz");
			landScan = actionScan.nextInt();
		}
		if (landScan == 1) {
			gamerShips.get(scanner).setColonizeMarker(0);
			gamerShips.get(scanner).setColonizePosition(planet.getName());
			gamerShips.get(scanner).setLandPosition(null);
			System.out.println(gamerShips.get(scanner));
		}
		else if (landScan == 2) {
			gamerShips.get(scanner).setLandPosition(planet.getName());
			gamerShips.get(scanner).setColonizePosition(null);
			planet.useSpecialAbility();
		}
	}

	private void colletEnergy(List<Ships> shipLocations, List<Planet> planets) {
		for (Ships ships : shipLocations) {
			for (Planet planet : planets) {
				if (ships.getColonizePosition() == planet.getName() && planet.getResourceType() == PlanetResourceType.Energy) {
					this.energyMarker++;
				}
			}
			for (Planet planet : planets) {
				if (ships.getLandPosition() == planet.getName() && planet.getResourceType() == PlanetResourceType.Energy) {
					this.energyMarker++;
				}
			}
			if (ships.getLandPosition() == "Galaxy") {
				this.energyMarker++;
			}
			
		}
		playerDataDisplay(this);
	}

	private void collectCivilization(List<Ships> shipLocations, List<Planet> planets) {
		//Ellenőrizni kell a hajók helyzetét, hogy azok mely bolgyón tartózkodnak .
		//Amelyik bolgyón van hajónk meg kell vizsgálni add e cilivizació erőforrást
		//Ha add akkor a jatekos erőforrását növelni kell a bolygón lévő hajók számával.
		for (Ships ships : shipLocations) {
			for (Planet planet : planets) {
				if (ships.getColonizePosition() == planet.getName() && planet.getResourceType() == PlanetResourceType.Civilization) {
					this.civilizationMarker++;
				}
			}
			for (Planet planet : planets) {
				if (ships.getLandPosition() == planet.getName() && planet.getResourceType() == PlanetResourceType.Civilization) {
					this.civilizationMarker++;
				}
			}
		}
		playerDataDisplay(this);
	}

	//SubMethods
	private String colorize(ColorEnums color) {
		switch (color) {
		case Blue:
			return "\u001B[34m";
			
		case Green:
			return "\u001B[32m";
			
		case Red:
			return "\u001B[31m";
		
		case Yellow:
			return "\u001B[33m";
			
			
		default:
			return "\u001B[30m";
		}
		
	}
	
	
	private Planet ChoosePlanets(List<Planet> planets) {
		int displayPlanets;
		if (planets.size() > 6) {
			if (gamers * 2 > 6) {
				displayPlanets = 6;
			}
			else {
				displayPlanets = gamers * 2;
			}		
		}
		else {
			displayPlanets = planets.size();
		}
		for (int i = 0; i < displayPlanets ; i++) {
			System.out.println("Válasz Bolygót");
			System.out.println(colorize(this.getColor())+ i + ". " + planets.get(i));
		}
		int scanner = actionScan.nextInt();
		while (scanner > 5 || scanner < 0) {
			System.out.println("A listából válasszon!");
			scanner = actionScan.nextInt();
		}
		return planets.get(scanner);
		
	}
	
	private void playerDataDisplay(Gamer gamer) {
		System.out.println("Jelenlegi Satuszod: " + gamer);
		
	}
	
	private void shipDataDisplay(Ships ship) {
		System.out.println("Jelenlegi Satuszod: " + ship);
		
	}
}
	
	

	
	
	
	
	
	

