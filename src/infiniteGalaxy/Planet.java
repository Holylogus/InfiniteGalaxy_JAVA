package infiniteGalaxy;

public class Planet {
	private String name;
	
	private int colonizeSize;
	private PlanetColonizeType planetColonizeType;
	private PlanetResourceType planetResourceType;
	private Runnable specialAbility;
	private int victoryPoint;
	
	public Planet(String name, PlanetResourceType planetResourceType, PlanetColonizeType planetColonizeType, int colonizeSize, int victoryPoint, Runnable specialAbility) {
        this.name = name;
        this.planetResourceType = planetResourceType;
        this.planetColonizeType = planetColonizeType;
        this.specialAbility = specialAbility;
        this.victoryPoint = victoryPoint;
        this.colonizeSize = colonizeSize;
    }
	

    public String getName() {
		return name;
	}

	public PlanetResourceType getResourceType() {
        return planetResourceType;
    }
    
    public PlanetColonizeType getPlanetColonizeType() {
		return planetColonizeType;
	}
    
	public int getColonizeSize() {
		return colonizeSize;
	}
	

	public int getVictoryPoint() {
		return victoryPoint;
	}
	

	public void useSpecialAbility() {
        specialAbility.run();
    }


	@Override
	public String toString() {
		return "Planet [name=" + name + ", colonizeSize=" + colonizeSize + ", planetColonizeType=" + planetColonizeType
				+ ", planetResourceType=" + planetResourceType + ", specialAbility=" + specialAbility
				+ ", victoryPoint=" + victoryPoint + "]";
	}
	
}







