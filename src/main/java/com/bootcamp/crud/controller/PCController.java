package com.bootcamp.crud.controller;

import com.bootcamp.crud.Service.PCService;
import com.bootcamp.crud.model.PC;
import com.bootcamp.crud.repository.PCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController // Use class as controller class
public class PCController {
    @Autowired
    PCRepository pcRepo;

    @Autowired
    PCService pcService;

    @GetMapping("PC") // Get method. Use this to get all the data from chosen table
    List<PC> getPCData() {
        return pcRepo.findAll();
    }

    @PostMapping("PC/insert") // Post a data
    public PC insertPCData(@RequestBody PC PCData){
        PC result = pcRepo.save(PCData);
        return result;
    }

    @DeleteMapping("/PC/delete")
    Map<String, Object> deletePCData(@RequestParam long id){
        Map<String, Object> respond = new HashMap<>();
        if (pcService.deletePCData(id)){
            respond.put("success", true);
            respond.put("message", "Data successfully deleted");
        } else {
            respond.put("success", false);
            respond.put("message", "Unable to delete data");
        }
        return respond;
    }

    @PutMapping("PC/update")
    Map<String, Object> updatePCData (@RequestBody PC data){
        Map<String, Object> respond = new HashMap<>();
        if (pcService.updatePCData(data)) {
            respond.put("success", true);
            respond.put("message", "Data successfully updated");
        } else {
            respond.put("success", false);
            respond.put("message", "Data failed to update");
        } return respond;
    }

}
