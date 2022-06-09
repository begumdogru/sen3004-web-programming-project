package sen3004.app4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sen3004.app4.dao.App4Repository;
import sen3004.app4.model.SampleObject;

@Service
public class App4Service {

	@Autowired
	App4Repository repositor;
	
	public List<SampleObject> findAll(){
		return repositor.findAll();
	}
	public void create(SampleObject product) {
		repositor.create(product);
	}
	
	public void delete( String name) {
		repositor.delete(name);
	}
}

