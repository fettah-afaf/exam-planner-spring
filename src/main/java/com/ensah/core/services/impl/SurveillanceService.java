package com.ensah.core.services.impl;

import com.ensah.core.bo.Salle;
import com.ensah.core.bo.Surveillance;
import com.ensah.core.reposetory.ISalleRepository;
import com.ensah.core.reposetory.ISurveillanceRepository;
import com.ensah.core.services.ISurveillanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
@Transactional
public class SurveillanceService implements ISurveillanceService {
    @Autowired
    private ISurveillanceRepository surveillanceRepository;

    @Autowired
    ISalleRepository salleRepository;
@Override
    public void setSalleForSurveillance(Long surveillanceId, Long salleId) {
        Optional<Surveillance> surveillanceOpt = surveillanceRepository.findById(surveillanceId);
        Optional<Salle> salleOpt = salleRepository.findById(salleId);

        if (surveillanceOpt.isPresent() && salleOpt.isPresent()) {
            Surveillance surveillance = surveillanceOpt.get();
            Salle salle = salleOpt.get();
            surveillance.setSalle(salle);
            surveillanceRepository.save(surveillance);
        } else {
            throw new IllegalArgumentException("Invalid surveillance or salle ID");
        }
    }
    public void addSurveillance(Surveillance surveillance) {
        surveillanceRepository.save(surveillance);
    }
}
