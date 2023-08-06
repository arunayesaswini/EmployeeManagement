package com.greatlearning.EmployeeManagementApi.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class User {

	   @Id
	   @Column(name = "user_id")
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private Long id;
	   @Column(unique=true,nullable=false)
	   private String username;
	   @Column(nullable=false)
	   private String password;
	    
	   @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	   @JoinTable(
	           name = "users_roles",
	           joinColumns = @JoinColumn(name = "user_id"),
	           inverseJoinColumns = @JoinColumn(name = "role_id")
	           )
	   private List<Role> roles = new ArrayList<>();

}
