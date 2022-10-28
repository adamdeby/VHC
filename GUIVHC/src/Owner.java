
public class Owner {

	private String iD;
	private String firstName;
	private String lastName;
	private int arrivalTime;
	private int departureTime;
	
	public Owner(String iD,String firstName, String lastName, int arrivalTime,int departureTime) 
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.iD = iD;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
	}
	
	
	public String getiD() {
		return iD;
	}
	public void setiD(String iD) {
		this.iD = iD;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public int getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(int departureTime) {
		this.departureTime = departureTime;
	}

	
	void addVeichle() {
		//
	}

	
	
}
