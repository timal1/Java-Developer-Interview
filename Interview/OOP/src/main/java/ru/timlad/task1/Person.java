package ru.timlad.task1;

public class Person {

    private String firstName;
    private String lastName;
    private String middleName;
    private String country;
    private String address;
    private String phone;
    private int age;
    private String gender;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Person() {
    }

    public static Builder createBuilder() {
        return new Builder();
    }

    public static class Builder {

        private Person person;

        private Builder() {
            this.person = new Person();
        }

        public Builder addFirstName(String firstName) {
            this.person.firstName = firstName;
            return this;
        }

        public Builder addLastName(String lastName) {
            this.person.lastName = lastName;
            return this;
        }

        public Builder addMiddleName(String middleName) {
            this.person.middleName = middleName;
            return this;
        }

        public Builder addCountry(String country) {
            this.person.country = country;
            return this;
        }

        public Builder addAddress(String address) {
            this.person.address = address;
            return this;
        }

        public Builder addPhone(String phone) {
            this.person.phone = phone;
            return this;
        }

        public Builder addAge(int age) {
            this.person.age = age;
            return this;
        }

        public Builder addGender(String gender) {
            this.person.gender = gender;
            return this;
        }

        public Person build() {
            return this.person;
        }

    }
}
