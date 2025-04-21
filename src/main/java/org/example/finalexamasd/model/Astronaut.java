package org.example.finalexamasd.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Astronaut {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 2, max = 20)
    private String firstName;

    @NotBlank
    @Size(min = 2, max = 20)
    private String lastName;

    @Min(0)
    @Max(50)
    private int experienceYears;

    @ManyToMany
    @JoinTable(
            name = "astronaut_satellites",
            joinColumns = @JoinColumn(name = "astronaut_id"),
            inverseJoinColumns = @JoinColumn(name = "satellite_id")
    )
    private List<Satellite> satellites;

    // Getters and setters
    // (Optional: use Lombok @Getter, @Setter, @NoArgsConstructor)
}

