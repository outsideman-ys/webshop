package com.example.servingwebcontent.repo;

import com.example.servingwebcontent.models.UserData;
import org.springframework.data.repository.CrudRepository;

public interface UserDataRepository extends CrudRepository<UserData, Long> {
    
    

}
