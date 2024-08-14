package repositories;

import models.Gate;

import java.util.HashMap;
import java.util.Optional;

public class GateRepository {

    HashMap<Long,Gate> gates = new HashMap<>();


    public Optional<Gate> findGateById(Long gateId){
        return Optional.of(gates.get(gateId));
    }


}
