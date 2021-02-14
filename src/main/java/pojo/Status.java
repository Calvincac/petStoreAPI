package pojo;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Locale;

public enum  Status {
    AVAILABLE,
    PENDING,
    SOLD;


    /**
     * Serialises to and from lower case for jackson.
     *
     * @return lower case Status name.
     */
    @JsonValue
    public String toLower() {
        return this.toString().toLowerCase(Locale.ENGLISH);
    }
}
