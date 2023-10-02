package com.example.main_pract1.tables;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;


@Entity
@Data
@Table(name = "talabalar")
public class Students implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long ids;

    @Column
    public String name;

    @Column
    public String surname;

    @Column
    public int years;

    @Column
    public String address;

    @Column
    public char gender;

    public Students() {
    }

    public Students(long ids, String name, String surname, int years, String address, char gender) {
        this.ids = ids;
        this.name = name;
        this.surname = surname;
        this.years = years;
        this.address = address;
        this.gender = gender;
    }


    public long getIds() {
        return ids;
    }

    public void setIds(long ids) {
        this.ids = ids;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
}
