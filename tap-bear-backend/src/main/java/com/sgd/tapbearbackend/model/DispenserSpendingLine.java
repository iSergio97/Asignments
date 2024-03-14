package com.sgd.tapbearbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;


@Data
@Entity
@Table(name = "DISPENSER_SPENDING_LINE")
@NoArgsConstructor
@AllArgsConstructor
public class DispenserSpendingLine implements Serializable {

    @Serial
    private static final long serialVersionUID = 2731425376306184746L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private UUID id;

    @Column(name = "OPENED_AT")
    private Date openedAt;

    @Column(name = "CLOSED_AT")
    private Date closedAt;

    @Transient
    private Double totalSpending;

    // Relation
    @ManyToOne(targetEntity = Dispenser.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "DISPENSER_ID")
    private Dispenser dispenser;

//    public Double getTotalSpending() {
//        if (this.openedAt != null && this.closedAt != null && this.dispenser != null && this.dispenser.getVolumen() != null) {
//            long diffInMillies = Math.abs(this.closedAt.getTime() - this.openedAt.getTime());
//            long diffInSeconds = TimeUnit.SECONDS.convert(diffInMillies, TimeUnit.MILLISECONDS);
//            this.totalSpending = diffInSeconds * this.dispenser.getVolumen();
//        }
//        return this.totalSpending;
//    }
}
