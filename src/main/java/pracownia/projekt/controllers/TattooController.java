package pracownia.projekt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import pracownia.projekt.entities.Tattoo;
import pracownia.projekt.services.TattooService;
import javax.validation.Valid;


@RestController
@RequestMapping("/api")
public class TattooController {

    @Autowired
    private TattooService tattooService;


    @GetMapping(value = "/tattoos", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Tattoo> list() {
        return tattooService.listAllTattoos();
    }

    @GetMapping(value = "/tattoo/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tattoo> getById(@PathVariable("id") int id) {
        Tattoo tattoo = tattooService.getTattooById(id).orElse(null);
        if (tattoo == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(tattoo);
    }

    @GetMapping(value = "/tattoo", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tattoo> getByParamId(@RequestParam("id") int id) {
        Tattoo tattoo = tattooService.getTattooById(id).orElse(null);
        if (tattoo == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(tattoo);
    }


    @PostMapping(value = "/tattoo")
    public ResponseEntity<Tattoo> create(@RequestBody @NonNull @Valid Tattoo tattoo) {
        if (tattooService.checkIfExist(tattoo.getId()))
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        tattooService.saveTattoo(tattoo);
        return ResponseEntity.ok(tattoo);
    }


    @PutMapping(value = "/tattoo")
    public ResponseEntity<Tattoo> edit(@RequestBody @NonNull @Valid Tattoo tattoo) {
        tattooService.saveTattoo(tattoo);
        if (tattooService.checkIfExist(tattoo.getId()))
            return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @DeleteMapping(value = "/tattoo/{id}")
    public ResponseEntity<Tattoo> delete(@PathVariable int id) {
        Tattoo tattoo = tattooService.getTattooById(id).orElse(null);
        if (tattoo == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        tattooService.deleteTattoo(id);
        return ResponseEntity.ok(tattoo);
    }

    @DeleteMapping(value = "/tattoo")
    public ResponseEntity<Tattoo> deleteByParamId(@RequestParam("id") int id) {
        Tattoo tattoo = tattooService.getTattooById(id).orElse(null);
        if (tattoo == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        tattooService.deleteTattoo(id);
        return ResponseEntity.ok(tattoo);
    }
}
