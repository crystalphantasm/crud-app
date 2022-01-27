package com.bootcamp.crud.Service;

import com.bootcamp.crud.model.PC;
import com.bootcamp.crud.repository.PCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Use this class as service class
public class PCService {
    @Autowired
    PCRepository pcRepo;

    public boolean deletePCData (long id){
        PC result = pcRepo.findById(id);
        if (result != null) {
            pcRepo.delete(result);
            return true;
        } else {
            return false;
        }
    }

    public boolean updatePCData (PC data) {
        PC result = pcRepo.findById(data.getId());
        if (result != null) {
            pcRepo.save(data);
            return true;
        } else {
            return false;
        }
    }
}
