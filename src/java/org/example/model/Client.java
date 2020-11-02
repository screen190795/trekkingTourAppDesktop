package org.example.model;

public class Client {
    int id;
    String name;
    String surname;
    String patronimic;
    int age;
    int passportSerial;
    double passportNumber;
    String phone;

    @Override
    public String toString() {
        return "Клиент{" +
                "id=" + id +
                ", Имя:'" + name + '\'' +
                ", Фамилия:'" + surname + '\'' +
                ", Отчество:'" + patronimic + '\'' +
                ", Возраст:" + age +
                ", Серия паспорта:" + passportSerial +
                ", Номер паспорта:" + passportNumber +
                ", Телефон:" + phone + '\'' +
                ", email:" + email + '\'' +
                ", Дополнительные сведения:" + description + '\'' +
                '}';
    }

    String email;
    String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPatronimic() {
        return patronimic;
    }

    public void setPatronimic(String patronimic) {
        this.patronimic = patronimic;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPassportSerial() {
        return passportSerial;
    }

    public void setPassportSerial(int passportSerial) {
        this.passportSerial = passportSerial;
    }

    public double getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(double passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
