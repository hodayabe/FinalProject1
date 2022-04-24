package Person;

import java.time.LocalDate;

public class Person {

	//fields
	private String firstName;
	private String lastName;
	private long PhoneNumber;
	private LocalDate bitrthDate;

	//constuctors

	public Person() {
		this("Hodaya","David",05002514,LocalDate.of(2020, 1, 8));
	}


	public Person(String firstName,String lastName,long phoneNumber,LocalDate bitrthDate) {
		setFirstName(firstName);
		setLastName(lastName);
		setPhoneNumber(phoneNumber);
		setBitrthDate(bitrthDate);
	}



	//getters and setters
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
	public long getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public LocalDate getBitrthDate() {
		return bitrthDate;
	}
	public void setBitrthDate(LocalDate bitrthDate) {
		this.bitrthDate = bitrthDate;
	}


	//methods
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", PhoneNumber=" + PhoneNumber
				+ ", bitrthDate=" + bitrthDate + "]";
	}













}
