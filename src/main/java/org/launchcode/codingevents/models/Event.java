package org.launchcode.codingevents.models;

import javax.validation.constraints.*;
import java.util.Objects;

public class Event {

    private int id;
    private static int nextId = 1;

    @NotBlank(message = "Event name is required.")
    @Size(min = 3, max = 50, message = "Description must be between 3 and 50 characters.")
    private String name;

    @Size(max = 500, message = "Description must be less than 500 characters.")
    private String description;

    @Email(message = "Invalid Email.")
    @NotBlank(message = "Contact email is required.")
    private String contactEmail;

    @Size(max = 500)
    @NotBlank(message = "Event Address is required.")
    private String address;

    @AssertTrue(message = "Registration is required for all events")
    private boolean registrationRequired;

    @Positive(message = "Events must have at least one registered attendee")
    @NotNull(message = "Number of event attendees is required.")
    private int attendeeNum;

    private EventType type;

    public Event(){
        this.id = nextId;
        nextId++;
    }

    public Event(String name, String description, String contactEmail, String address, boolean registrationRequired, int attendeeNum, EventType type) {
        this();
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.address = address;
        this.registrationRequired = registrationRequired;
        this.attendeeNum = attendeeNum;
        this.type = type;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public boolean isRegistrationRequired() {
        return registrationRequired;
    }

    public void setRegistrationRequired(boolean registrationRequired) {
        this.registrationRequired = registrationRequired;
    }

    public int getAttendeeNum() {
        return attendeeNum;
    }

    public void setAttendeeNum(int attendeeNum) {
        this.attendeeNum = attendeeNum;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
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
