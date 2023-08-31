package next.school.cesar.desafio.entities;

import java.util.Date;

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
import next.school.cesar.desafio.enumerated.InsuranceAnalysis;
import next.school.cesar.desafio.enumerated.InsuranceType;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity

public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column (nullable = false)
    @Enumerated(EnumType.STRING)
    private InsuranceType type;
    @Column (nullable = false)
    private int risk;
    @Column (nullable = false)
    @Enumerated(EnumType.STRING)
    private InsuranceAnalysis analysis;
    @Column (nullable = false)
    private String observation;
    @Column (nullable = false)
    private Date createdAt;
    @Column (nullable = false)
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name="client_id", nullable = false)
    private Client client;
    
   
}
