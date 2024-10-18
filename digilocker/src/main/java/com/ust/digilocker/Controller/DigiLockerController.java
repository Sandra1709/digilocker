package com.ust.digilocker.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.digilocker.model.Govdoc;
import com.ust.digilocker.model.User;
import com.ust.digilocker.service.DigilockerService;

@RestController
@RequestMapping("/digi/locker1.0")

public class DigiLockerController {
	@Autowired
	private DigilockerService serv;
	
	@GetMapping("/allinfo")//all datas will be accessed
	public List<User> getData()
	{
		return serv.getalldata();
	}
	@GetMapping("/user/{userid}")//data accessed using id
	public ResponseEntity<Optional<User>> getByUserName(@PathVariable long userid)
	{
		Optional<User> use =serv.getByUserid(userid);
		if(use!=null)
		{
			return ResponseEntity.ok(use);
    } else {
        return ResponseEntity.notFound().build();
    }
	//	------------------------------------------------------GetMapping----------------------------------
		
	}
	//-------------------------------------POST-MAPPING --ADDING ALL DATA ------------------------------
	@PostMapping("/addData")
	public User addData(@RequestBody User user)
	{
		return serv.addDetails(user);
	//---------------------------------------------------------------------------------------------------------	
	}
	//------------------------------------------DELETE MAPPING USING ID----------------------------------------------------
	@DeleteMapping(value="/delete/{userid}")
	public void  removeProduct(@PathVariable long userid)
	{
		serv.removeDataById(userid);
	    
			
	}
//-----------------------------------------------------------------------------------------------------------------------

	@PutMapping(value="/govdoc/{userid}/{govid}")
	public  ResponseEntity<String>  updategov(@RequestBody User user,@PathVariable long userid,@PathVariable long govid)
	{
		String msg = serv.updategov(user,userid,govid);
		if(msg!= null)
			return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(msg);
		else
			return ResponseEntity.status(HttpStatusCode.valueOf(404)).body("No data with that id is found");
		
	}






}
