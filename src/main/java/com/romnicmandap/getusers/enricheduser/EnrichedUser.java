package com.romnicmandap.getusers.enricheduser;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
@Table(name="enriched_user")
public class EnrichedUser {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @NotBlank(message="name => must not be blank")
    @Size(max=255, message="name => must not exceed 255 characters")
    @Column(name="name", nullable=false)
    private String name;

    @NotBlank(message="email => must not be blank")
    @Size(max=255, message="email => must not exceed 255 characters")
    @Email(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "email  => must be valid")
    @Column(name="email", nullable=false)
    private String email;

    @NotBlank(message="department => must not be blank")
    @Size(max=255, message="department => must not exceed 255 characters")
    @Column(name="department", nullable=false)
    private String department;

    @Column(name="last_updated")
    private LocalDateTime lastUpdated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString() {
        return "EnrichedUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", department='" + department + '\'' +
                ", lastUpdated=" + lastUpdated +
                '}';
    }

    /*
id
name -> c255, not blank
email -> valid format, 255, not blank
department -> 255, not blank
lastUpdated -> time of creation

 */

}
