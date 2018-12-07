package com.fanatics.beans;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity //registers class as entity in DB
@Table(name="USERS")//allows further configuration of Table in DB
public class User {

	@Id //necessary for Hibernate to identify objects
	@Column(name="USER_ID")
	@SequenceGenerator(name="U_SEQ_GEN", sequenceName="U_SEQ")
	@GeneratedValue(generator="U_SEQ_GEN", strategy=GenerationType.SEQUENCE)
    private int id;
	
	@Column(unique=true,nullable=false,name="USER_NAME")
    private String username;
	
	@Column(nullable=false,name="PASSWORD")
    private String password;
	
	@Column(name="FIRST_NAME")
    private String firstname;
	
	@Column(name="LAST_NAME")
    private String lastname;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="BIO")
    private String bio;
	
	@Column(nullable=false,name="IS_ADMIN")
	private String isAdmin;
    
	@Column(nullable=false,name="JOIN_DATE")
	private Timestamp joinDate;
	
	@Column(nullable=false,name="IS_VERIFIED")
	private int isVerified;
    
    public User() {}
    
    public User(int id, String username, String password, String firstname, String lastname, String email, String bio,
			String isAdmin, Timestamp joinDate, int isVerified) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.bio = bio;
		this.isAdmin = isAdmin;
		this.joinDate = joinDate;
		this.isVerified = isVerified;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Timestamp getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Timestamp joinDate) {
		this.joinDate = joinDate;
	}

	public int getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(int isVerified) {
		this.isVerified = isVerified;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
	
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
    
    @Override
    public String toString() {
        return "User [username=" + username + ", password=" + password + ", firstname=" + firstname + ", lastname="
                + lastname + ", id=" + id + ", bio=" + bio + "]\n";
    }
	
}