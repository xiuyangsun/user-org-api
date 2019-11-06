package com.user.org.demo.userorgapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Organization {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private String address;

	private String phone;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	@JoinTable(name = "user_org", joinColumns = @JoinColumn(name = "org_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> users;

	public Organization(String name, String address, String phone, List<User> users) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.users = users;
	}

	public void addUser(User user) {
		if (users == null) {
			users = new ArrayList<>();
		}
		users.add(user);
	}
}
