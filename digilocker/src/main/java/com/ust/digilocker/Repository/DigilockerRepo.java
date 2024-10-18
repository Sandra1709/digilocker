package com.ust.digilocker.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ust.digilocker.model.Govdoc;
import com.ust.digilocker.model.User;
@Repository
public interface DigilockerRepo  extends JpaRepository<User,Long>{

	List<Govdoc> save(Govdoc govdoc);

	//User getByName(String username);

}
