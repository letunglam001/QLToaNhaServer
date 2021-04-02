package web.data;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import web.model.Access;
import web.model.EmployeeCompany;

public interface AccessRepository extends CrudRepository<Access, String>{
	Optional<Access> findById(int id);
}
