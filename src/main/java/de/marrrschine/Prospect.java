package de.marrrschine;

import javax.xml.bind.annotation.XmlRootElement;

public class Prospect {
	private int rank;

	private String firstname;

	private String lastname;

	private String pos;

	private int posRank;

	private String school;

	private String classYear;

	private String height;

	private int weight;

	private String projRnd;

	public Prospect(int rank, String name, String pos, int posRank, String school, String classYear, String height,
			int weight) {
		super();
		this.rank = rank;
		this.firstname = name.split(" ")[0];
		this.lastname = name.split(" ")[1];
		this.pos = pos;
		this.posRank = posRank;
		this.school = school;
		this.classYear = classYear;
		this.height = height;
		this.weight = weight;
	}

	public Prospect(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public String getProjRnd() {
		return projRnd;
	}

	public void setProjRnd(String projRnd) {
		this.projRnd = projRnd;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public boolean equals(Prospect other) {
		if ((this.lastname.equalsIgnoreCase(other.lastname)) && (this.firstname.equalsIgnoreCase(other.firstname))) {
			return true;
		} else {
			return false;
		}
	}

}
