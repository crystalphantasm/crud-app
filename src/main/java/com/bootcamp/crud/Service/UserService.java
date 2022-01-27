package com.bootcamp.crud.Service;

import com.bootcamp.crud.model.User;
import com.bootcamp.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public boolean hapusUser (long id){
        User hasil;
        hasil = userRepository.findById(id);
        if(hasil != null){
            userRepository.delete(hasil);
            return true;
        } else {
            return false;
        }
    }

    public boolean updateUser(User data) {
        User hasil = userRepository.findById(data.getId());
        if (hasil != null){
            userRepository.save(data);
            return true;
        } else {
            return false;
        }
    }
}
