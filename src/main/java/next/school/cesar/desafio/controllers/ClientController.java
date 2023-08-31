package next.school.cesar.desafio.controllers;

import java.time.LocalDate;
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
import next.school.cesar.desafio.entities.Client;
import next.school.cesar.desafio.repositories.ClientRepository;

@RestController
@RequestMapping("/clients")
@AllArgsConstructor(onConstructor = @__(@Autowired))

public class ClientController {
    
    private ClientRepository clientRepository;
    ArrayList<Client> listClient = new ArrayList<Client>();
    int contador = 1;
    
    
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Client findById(@PathVariable Long id) throws Exception {
        return clientRepository.findById(id).orElseThrow();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client create(@RequestBody @Validated Client client) throws Exception {
        client.setCreatedAt(LocalDate.now());
        return clientRepository.save(client);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client client){
        Optional<Client> resOptional = clientRepository.findById(id);
        if (resOptional.isPresent()){
            Client clientExist = resOptional.get();
            clientExist.setName(client.getName());
            clientExist.setAge(client.getAge());
            clientExist.setMarital_status(client.getMarital_status());
            clientExist.setDependents(client.getDependents());
            clientExist.setIncome(client.getIncome());

            client.setUpdatedAt(LocalDate.now());
            clientRepository.save(clientExist);
            return new ResponseEntity<>(clientExist, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Client> delete(@PathVariable(value = "id") Long id) {
        for (int i = 0; i < listClient.size(); i++) {
            if (listClient.get(i).getId() == id) {
                this.listClient.remove(this.listClient.get(i));
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping
    public List<Client> listAll() {
        return clientRepository.findAll();
    }
}
