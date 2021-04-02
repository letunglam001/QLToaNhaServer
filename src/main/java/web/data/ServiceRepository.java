package web.data;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import web.model.Service;
import web.model.Service.Type;

public interface ServiceRepository extends CrudRepository<Service, String>{
//	Optional<Service> findById(int id);
//	Optional<Service> deleteById(int id);
	Optional<Service> findByName(String name);
} 