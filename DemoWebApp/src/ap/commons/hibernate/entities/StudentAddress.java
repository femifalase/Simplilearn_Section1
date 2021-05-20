package ap.commons.hibernate.entities;

import javax.persistence.Embeddable;

@Embeddable
public class StudentAddress {

	private String street;

	private String city;

	private String state;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Student Address [street=" + street + ", city=" + city + ", state=" + state + "]";
	}

}
