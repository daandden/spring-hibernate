package com.luv2code.hibernate.demo.enity;

import java.io.Serializable;
import java.util.Objects;

public class InstructorDto implements Serializable {
    private String firstName;
    private String lastName;

    public InstructorDto() {
    }

    public InstructorDto(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InstructorDto entity = (InstructorDto) o;
        return Objects.equals(this.firstName, entity.firstName) && Objects.equals(this.lastName, entity.lastName);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" + "firstName = " + firstName + ", " + "lastName = " + lastName + ")";
    }
}
