package next.school.cesar.desafio.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import next.school.cesar.desafio.entities.House;
import next.school.cesar.desafio.repositories.HouseRepository;


@RestController
@RequestMapping("/houses")
@AllArgsConstructor(onConstructor = @__(@Autowired))

public class HouseController {
    
    private HouseRepository houseRepository;
    ArrayList<House> listHouse = new ArrayList<House>();
    int contador = 1;
    
    //Listar todas as casas, Filtrar casas por zipcode.
    @GetMapping("/{zipcode}")
    public ResponseEntity<List<House>>getHousebyzipcode(@PathVariable String zipcode) {
        List<House> houseByZipcode = houseRepository.findByzipcode(zipcode);
        if (houseByZipcode.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(houseByZipcode, HttpStatus.OK);
        }
    }

    //Cria uma nova casa e adiciona ao cliente.
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public House create(@RequestBody @Validated House client) throws Exception {
        return houseRepository.save(client);
    }

    //Atualizar uma casa por ID.
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<House> update(@PathVariable Long id, @RequestBody House house){
        Optional<House> resOptional = houseRepository.findById(id);
        if (resOptional.isPresent()){
            House houseExist = resOptional.get();
            houseExist.setOwnership_status(house.getOwnership_status());
            houseExist.setLocation(house.getLocation());
            houseExist.setZipcode(house.getZipcode());            

            houseRepository.save(houseExist);
            return new ResponseEntity<>(houseExist, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Exclui uma casa por ID.
    @DeleteMapping("/{id}")
    public ResponseEntity<House> delete(@PathVariable(value = "id") Long id) {
        for (int i = 0; i < listHouse.size(); i++) {
            if (listHouse.get(i).getId() == id) {
                this.listHouse.remove(this.listHouse.get(i));
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

