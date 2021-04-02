package web.data;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import web.model.EmployeeBuilding;

public interface EmployeeBuildingRepository extends CrudRepository<EmployeeBuilding, String>{
	Optional<EmployeeBuilding> findById(int id);
	Optional<EmployeeBuilding> deleteById(int id);
} 