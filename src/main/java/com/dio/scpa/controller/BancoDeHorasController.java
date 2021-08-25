package com.dio.scpa.controller;

import com.dio.scpa.model.BancoDeHoras;
import com.dio.scpa.service.BancoDeHorasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bancoDeHoras")
public class BancoDeHorasController {

    @Autowired
    BancoDeHorasService bancoDeHorasService;

    @PostMapping
    public BancoDeHoras createBancoDeHoras(@RequestBody BancoDeHoras bancoDeHoras) {
        return bancoDeHorasService.saveBancoDeHoras(bancoDeHoras);
    }

    @GetMapping
    public List<BancoDeHoras> getBancoDeHorasList() {
        return bancoDeHorasService.findAll();
    }

    @GetMapping("/{idBancoDeHoras}")
    public ResponseEntity<BancoDeHoras> getBancoDeHorasById(@PathVariable("idBancoDeHoras") Long idBancoDeHoras) throws Exception {
        return ResponseEntity.ok(bancoDeHorasService.getById(idBancoDeHoras).orElseThrow(() -> new Exception("Banco de Horas não encontrada.")));
    }

    @PutMapping
    public BancoDeHoras updateBancoDeHoras(@RequestBody BancoDeHoras bancoDeHoras) {
        return bancoDeHorasService.updateBancoDeHoras(bancoDeHoras);
    }

    @DeleteMapping("/{idBancoDeHoras}")
    public ResponseEntity deleteById(@PathVariable("idBancoDeHoras") Long idBancoDeHoras) throws Exception {
        try {
            bancoDeHorasService.deleteBancoDeHoras(idBancoDeHoras);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<BancoDeHoras>) ResponseEntity.ok();
    }
}
