package com.ensah.core.services;

import com.ensah.core.bo.Surveillance;

public interface ISurveillanceService {

    public void setSalleForSurveillance(Long surveillanceId, Long salleId);
    public void addSurveillance(Surveillance surveillance);
}
