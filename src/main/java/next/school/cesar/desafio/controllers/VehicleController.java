package next.school.cesar.desafio.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import next.school.cesar.desafio.entities.Vehicle;
import next.school.cesar.desafio.repositories.VehicleRepository;

@RestController
@RequestMapping("/vehicles")
@AllArgsConstructor(onConstructor = @__(@Autowired))

public class VehicleController {
    private VehicleRepository vehicleRepository;
    ArrayList<Vehicle> listVehicle = new ArrayList<Vehicle>();
    int contador = 1;

//Cria um novo veiculo.
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Vehicle create(@RequestBody @Validated Vehicle vehicle) throws Exception {
        return vehicleRepository.save(vehicle);
    }

//Cria uma associação entre cliente e veículo.
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Vehicle update(@RequestBody @Validated Vehicle client) throws Exception {
        return vehicleRepository.save(client);
    }
    

//Remover uma associação entre veiculo e cliente e exclui o veiculo por ID.
    @DeleteMapping("/{id}")
    public ResponseEntity<Vehicle> delete(@PathVariable(value = "id") Long id) {
        for (int i = 0; i < listVehicle.size(); i++) {
            if (listVehicle.get(i).getId() == id) {
                this.listVehicle.remove(this.listVehicle.get(i));
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
