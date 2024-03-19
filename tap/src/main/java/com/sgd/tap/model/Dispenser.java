package com.sgd.tap.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@Table(name = "DISPENSER")
@NoArgsConstructor
@AllArgsConstructor
public class Dispenser implements Serializable {

    @Serial
    private static final long serialVersionUID = 2731425376306184746L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private UUID id;

    @Column(name = "VOLUMEN")
    @NotNull
    @Min(0)
    private Double volumen;

}
