package com.comparison.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Employee implements Comparable<Employee> {
	@Id
	@Column(name="Id")
	private Integer Id;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Email")
	private String Email;

	@Override
	public int compareTo(Employee o) {
		return this.getId().compareTo(o.getId());
	}

}
