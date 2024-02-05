package org.launchcode.codingevents.models;

import javax.persistence.Entity;
import jakarta.validation.constraints.*;

import java.util.Objects;

@Entity
public class Event {
    @Id
    @GeneratedValue
    private int id;
    @NotBlank(message = "Name is required")
    @Size(min=3, max=30, message = "Name must be in between 3 and 30 characters")
    private String name;

    @Size(max=500, message = "Description too long")
    private String description;

    @NotBlank(message = "Email is required")
    @Email(message="Invalid email. Try again")
    private String contactEmail;

    @NotBlank(message = "Location cannot be left blank.")
    @NotNull
    private String location;

    @NotBlank(message = "Attendees must be registered")
    private String registered;

    @NotBlank(message = "Number of attendees cannot be left blank")
    @Min(value = 1, message = "Minimum number of attendees is 1")
    private int numAttendees;
    private EventType type;

    public Event(String name, String description, String contactEmail, EventType type, String location, String registered, int numAttendees) {
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.type = type;
        this.location = location;
        this.registered = registered;
        this.numAttendees = numAttendees;

    }

    public Event() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNumAttendees() {
        return numAttendees;
    }

    public void setNumAttendees(int numAttendees) {
        this.numAttendees = numAttendees;
    }

    public String getRegistered() {
        return registered;
    }

    public void setRegistered(String registered) {
        this.registered = registered;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
