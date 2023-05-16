package infiniteGalaxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Gamer {
	
	private Color color;
	private int spaceships;
	private int civilizationMarker;
	private int energyMarker;
	private int empireMarker;
	private int victoryPoint;
	public List<Actions> currentActions = new ArrayList<>();
	public static final Random rnd = new Random();
	public static final Scanner actionScan = new Scanner(System.in);
	
	
	
	public Gamer(Color color, int spaceships, int civilizationMarker, int energyMarker, int empireMarker,
			int victoryPoint) {
		super();
		this.color = color;
		setSpaceships(spaceships);
		setCivilizationMarker(civilizationMarker);
		setEnergyMarker(energyMarker);
		setEmpireMarker(empireMarker);
		setVictoryPoint(victoryPoint);
	}
	



	public Gamer(Color color) {
		this(color, 2, 1, 2, 1, 0);
	}



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


	public void setSpaceships(int spaceships) {
		if (spaceships > 4) {
			this.spaceships = 4;
		}
		else if (spaceships <2) {
			this.spaceships = 2;
		}
		this.spaceships = spaceships;
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
	



	public Color getColor() {
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
				this.currentActions.add(Actions.MoveShips);
				break;
			case 2:
				currentActions.add(Actions.CollectEnergy);
				break;
			case 3:
				currentActions.add(Actions.CollectCivilization);
				break;
			case 4:
				currentActions.add(Actions.Diplomacy);
				break;
			case 5:
				currentActions.add(Actions.Economy);
				break;
			case 6:
				currentActions.add(Actions.UsePlanet);
				break;

			default:
				break;
			}
		}
		
	}
	
	public void ChooseAction(List<Actions> currentActions) {
		System.out.println(colorize(this.color) + "Választható Akciók");
		int counter = 1;
		for (Actions actions : currentActions) {
			System.out.println(colorize(this.color)+ counter + ". " + actions);
			counter ++;
		}
		int scanner = actionScan.nextInt();
		switch (scanner) {
		case 1:
			
			break;

		default:
			break;
		}
		
		
	}
	private String colorize(Color color) {
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
	
	
	
	
	
	}
	
	

	
	
	
	
	
	

