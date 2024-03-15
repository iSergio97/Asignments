package com.sgd.tap.model;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
@Builder
@Table(name = "DISPENSER_SPENDING_LINE")
@NoArgsConstructor
@AllArgsConstructor
public class DispenserSpendingLine implements Serializable {

    @Serial
    private static final long serialVersionUID = 939357561482497238L;

    @Column(name = "ID")
    private UUID id;

    @Column(name = "STATUS")
    @Pattern(regexp = "^(OPEN|CLOSE)$")
    private String status;

    @Column(name = "OPENED_AT")
    private Date openedAt;

    @Column(name = "CLOSED_AT")
    private Date closedAt;

    // --- Relations ---
    @ManyToOne
    @JoinColumn(name = "DISPENSER_ID")
    private Dispenser dispenser;
}
