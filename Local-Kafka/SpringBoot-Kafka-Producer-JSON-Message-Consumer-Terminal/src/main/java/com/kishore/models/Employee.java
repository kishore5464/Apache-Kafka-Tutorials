package com.kishore.models;

public class Employee {

	private String name;
	private String company;
	private Integer teamSize;

	public Employee() {

	}

	public Employee(String name, String company, Integer teamSize) {
		super();
		this.name = name;
		this.company = company;
		this.teamSize = teamSize;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Integer getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(Integer teamSize) {
		this.teamSize = teamSize;
	}

}
