package pl.coderslab.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 1, message = "{name.min}")
    private String firstName;

    @Size(min = 1, message = "{name.min}")
    private String lastName;

    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

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
}
