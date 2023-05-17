package infiniteGalaxy;

public class Ships {
	private int iD;
	private String landPosition;
	private String colonizePosition;
	private int colonizeMarker;
	
	
	public Ships(int iD) {
		this(iD, "Galaxy", "" ,0);
	}


	public Ships(int iD, String landPosition, String colonizePosition, int colonizeMarker) {
		super();
		this.iD = iD;
		this.landPosition = landPosition;
		this.colonizePosition = colonizePosition;
		this.colonizeMarker = colonizeMarker;
	}
	

	
	public int getiD() {
		return iD;
	}

	public int getColonizeMarker() {
		return colonizeMarker;
	}


	public void setColonizeMarker(int colonizeMarker) {
		this.colonizeMarker = colonizeMarker;
	}


	public String getLandPosition() {
		return landPosition;
	}


	public void setLandPosition(String landPosition) {
		this.landPosition = landPosition;
	}


	public String getColonizePosition() {
		return colonizePosition;
	}


	public void setColonizePosition(String colonizePosition) {
		this.colonizePosition = colonizePosition;
	}


	@Override
	public String toString() {
		return "Ships [iD=" + iD + ", landPosition=" + landPosition + ", colonizePosition=" + colonizePosition
				+ ", colonizeMarker=" + colonizeMarker + "]";
	}
	
	
	
}


