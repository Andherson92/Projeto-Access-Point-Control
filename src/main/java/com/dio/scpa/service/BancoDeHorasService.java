package com.dio.scpa.service;

import com.dio.scpa.model.BancoDeHoras;
import com.dio.scpa.repository.BancoDeHorasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BancoDeHorasService {

    BancoDeHorasRepository bancoDeHorasRepository;

    @Autowired
    public BancoDeHorasService(BancoDeHorasRepository bancoDeHorasRepository) {
        this.bancoDeHorasRepository = bancoDeHorasRepository;
    }

    public BancoDeHoras saveBancoDeHoras(BancoDeHoras bancoDeHoras) {
        return bancoDeHorasRepository.save(bancoDeHoras);
    }

    public List<BancoDeHoras> findAll() {
        return bancoDeHorasRepository.findAll();
    }

    public Optional<BancoDeHoras> getById(Long idBancoDeHoras) {
        return bancoDeHorasRepository.findById(idBancoDeHoras);
    }

    public BancoDeHoras updateBancoDeHoras(BancoDeHoras bancoDeHoras) {
        return bancoDeHorasRepository.save(bancoDeHoras);
    }

    public void deleteBancoDeHoras(Long idBancoDeHoras) {
        bancoDeHorasRepository.deleteById(idBancoDeHoras);
    }
}
