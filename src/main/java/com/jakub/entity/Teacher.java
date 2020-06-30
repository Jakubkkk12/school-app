package com.jakub.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "teacher")
public class Teacher
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer   id;
    
    @Column(name = "name")
    private String    name;
    
    @Column(name = "surname")
    private String    surname;
    
    @Column(name = "password")
    private String    password;
    
    @Column(name = "phoneNumber")
    private Integer   phoneNumber;
    
    @Column(name = "emailAddress")
    private String    emailAddress;
    
    @Column(name = "AccessType", columnDefinition = "varchar(1) default 'T'", nullable = false)
    private Character accessType = 'T';

    Teacher() {
        
    }
    
    Teacher(String name, String surname, String password, Integer phoneNumber, String emailAddress, Character accessType) {
        super();
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.accessType = accessType;
    }
    
    public Character getAccessType()
    {
        return accessType;
    }

    public void setAccessType(Character accessType)
    {
        this.accessType = accessType;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public Integer getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress()
    {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress)
    {
        this.emailAddress = emailAddress;
    }

}
