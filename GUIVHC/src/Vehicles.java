
public class Vehicles {
	private String carMake;
	private String carModel;
	private int carYear;
	private String licensePlate;
	private int residencyTime;

	public Vehicles(String cMake, String cModel, int cYear, String licensePlateNumber, int residencyTime) {
		this.carMake = cMake;
		this.carModel = cModel;
		this.carYear = cYear;
		this.licensePlate = licensePlateNumber;
		this.residencyTime = residencyTime;
	}

	public String getCarMake() {
		return carMake;
	}

	public String getCarModel() {
		return carModel;
	}

	public int getCarYear() {
		return carYear;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public int getResidencyTime() {
		return residencyTime;
	}

}