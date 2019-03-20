package com.comparison.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Student implements Comparable<Student> {
	@Id
	@Column(name = "Id")
	private Integer id;

	@Column(name = "Name")
	private String name;

	@Column(name = "Email")
	private String email;

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Employee) {
			Employee emp = (Employee) obj;

			if (obj == null) {
				return false;
			} else if (getId() != emp.getId()) {
				System.out.println("\nId is not same in two tables");
				return false;
			} else if (!getName().equals(emp.getName())) {
				System.out.println("\nName is not same in two tables");
				return false;
			} else if (!getEmail().equals(emp.getEmail())) {
				System.out.println("\nEmail is not same in two tables");
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public int compareTo(Student o) {
		return this.getId().compareTo(o.getId());
	}

}
