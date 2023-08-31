package next.school.cesar.desafio.entities;


import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import next.school.cesar.desafio.enumerated.MaritalStatus;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity

public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column (nullable = false)
    private String name;
    @Column (nullable = false)
    private int age; //calcular a data com Date* de acordo com a data do update
    @Column (nullable = false)
    private int dependents; 
    @Column (nullable = false)
    private double income;
    @Column (nullable = false)   
    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;
    @Column (nullable = false)    
    private LocalDate createdAt;
    @Column (nullable = false)
    private LocalDate updatedAt;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, mappedBy = "client")
    private List<Vehicle> listVehicles;
    
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, mappedBy = "client")
    private List<House> listHouses;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, mappedBy = "client")
    private List<Insurance> listInsurance;

    
}
