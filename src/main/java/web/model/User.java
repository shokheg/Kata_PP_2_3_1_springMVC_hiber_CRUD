package web.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author shokhalevich
 */

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name", nullable = false, length = 60)
    @Size(max = 60, message = "First name should be max 60 characters.")
    private String firstName;
    @Column(name = "last_name", nullable = false, length = 80)
    @Size(max = 80, message = "Last name should be max 80 characters.")
    private String lastName;
    @Column(name = "age", nullable = false)
    @Size(min = 1, max = 200)
    private int age;
    @Column(name = "email", nullable = false)
    @Email(message = "Email should not be empty")
    private String email;

    public User() {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
