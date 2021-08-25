package com.dio.scpa.controller;

import com.dio.scpa.model.Calendario;
import com.dio.scpa.service.CalendarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calendario")
public class CalendarioController {

    @Autowired
    CalendarioService calendarioService;

    @PostMapping
    public Calendario createCalendario(@RequestBody Calendario calendario) {
        return calendarioService.saveCalendario(calendario);
    }

    @GetMapping
    public List<Calendario> getCalendarioList() {
        return calendarioService.findAll();
    }

    @GetMapping("/{idCalendario}")
    public ResponseEntity<Calendario> getCalendarioById(@PathVariable("idCalendario") Long idCalendario) throws Exception {
        return ResponseEntity.ok(calendarioService.getById(idCalendario).orElseThrow(() -> new Exception("Calendario não encontrada.")));
    }

    @PutMapping
    public Calendario updateCalendario(@RequestBody Calendario calendario) {
        return calendarioService.updateCalendario(calendario);
    }

    @DeleteMapping("/{idCalendario}")
    public ResponseEntity deleteById(@PathVariable("idCalendario") Long idCalendario) throws Exception {
        try {
            calendarioService.deleteCalendario(idCalendario);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<Calendario>) ResponseEntity.ok();
    }
}
