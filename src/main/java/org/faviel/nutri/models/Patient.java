package org.faviel.nutri.models;

import java.time.LocalDate;
import java.time.Period;

public class Patient {

    private Integer id;
    private String name;
    private String patLastname;
    private String matLastname;
    private String gender;
    private LocalDate birth;
    private Integer age;
    private Integer height;
    private Double weight;
    private String organization;
    private String telCountryCode;
    private String tel;
    private String email;
    private String address;
    private String city;
    private String region;
    private String country;

    public Patient() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatLastname() {
        return patLastname;
    }

    public void setPatLastname(String patLastname) {
        this.patLastname = patLastname;
    }

    public String getMatLastname() {
        return matLastname;
    }

    public void setMatLastname(String matLastname) {
        this.matLastname = matLastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public Integer getAge() {
        if (birth == null) return null;
        return Period.between(birth, LocalDate.now()).getYears();
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getTelCountryCode() {
        return telCountryCode;
    }

    public void setTelCountryCode(String telCountryCode) {
        this.telCountryCode = telCountryCode;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", patLastname='" + patLastname + '\'' +
                ", matLastname='" + matLastname + '\'' +
                ", gender='" + gender + '\'' +
                ", birth=" + birth +
                ", height=" + height +
                ", weight=" + weight +
                ", organization='" + organization + '\'' +
                ", telCountryCode='" + telCountryCode + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
