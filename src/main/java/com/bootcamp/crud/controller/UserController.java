package com.bootcamp.crud.controller;

import com.bootcamp.crud.Service.UserService;
import com.bootcamp.crud.model.User;
import com.bootcamp.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @GetMapping("")
    List<User> tampilkanSemuaUser() {
        return userRepository.findAll();
    }

    @PostMapping("/insert")
    public User masukkanUser(@RequestBody User dataUser){
        User hasil;
        hasil = userRepository.save(dataUser);
        return hasil;
    }

    @DeleteMapping("/delete")
    Map<String, Object> deleteUser(@RequestParam long id){
        Map<String, Object> hasil = new HashMap<>();
        if (userService.hapusUser(id)){
            hasil.put("success", true);
            hasil.put("message", "data berhasil dihapus");
        } else {
            hasil.put("success", false);
            hasil.put("message", "data gagal dihapus");
        }
        return hasil;
    }

    @PutMapping("/update")
    Map<String, Object> updateUser (@RequestBody User data){
        Map<String, Object> respon = new HashMap<>();
        if (userService.updateUser(data)){
            respon.put("success", true);
            respon.put("message", "data berhasil diupdate");
        } else {
            respon.put("success", false);
            respon.put("message", "data gagal diupdate");
        }
        return respon;
    }

}
