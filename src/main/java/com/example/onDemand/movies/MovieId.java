package com.example.onDemand.movies;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Data
@Embeddable
public class MovieId implements Serializable {
    private static final long serialVersionUID = 0L;
    @Column(name = "ID")
    @Type(type = "pg-uuid")
    private UUID value;

    public MovieId() {
    }

    public MovieId(UUID value) {
        this.value = value;
    }

    public UUID getValue() {
        return value;
    }

    public void setValue(UUID value) {
        this.value = value;
    }
}
