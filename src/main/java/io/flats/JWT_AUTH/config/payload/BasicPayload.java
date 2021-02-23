package io.flats.JWT_AUTH.config.payload;

public abstract class BasicPayload {
    public abstract String getUsername();

    public abstract String getEmail();

    public abstract String getLastName();

    public abstract String getFirstName();

    public abstract String getPhoneNumber();

    public abstract String getSecondName();
}
