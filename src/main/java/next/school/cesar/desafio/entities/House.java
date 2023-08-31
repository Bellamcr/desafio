package next.school.cesar.desafio.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import next.school.cesar.desafio.enumerated.OwnershipStatus;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity

public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column (nullable = false)
    @Enumerated(EnumType.STRING)
    private OwnershipStatus ownership_status;
    @Column (nullable = false)
    private String location;
    @Column (nullable = false)
    private String zipcode;

    @ManyToOne
    @JoinColumn(name="client_id", nullable = false)
    private Client client;
   
}
