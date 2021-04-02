package web.api;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import web.data.EmployeeBuildingRepository;
import web.data.EmployeeCompanyRepository;
import web.data.ServiceRepository;
import web.model.EmployeeBuilding;
import web.model.EmployeeCompany;
import web.model.Service;


@RestController
@RequestMapping(path = "/employeeBuilding", produces = "application/json")
@CrossOrigin(origins = "*")
public class EmployeeBuildingController {
	private EmployeeBuildingRepository Employee_BuildingRepo;
//	@Autowired
//	EntityLinks entityLinks;

	public EmployeeBuildingController(EmployeeBuildingRepository Employee_BuildingRepo) {
		this.Employee_BuildingRepo = Employee_BuildingRepo;
	}

	@GetMapping
	public Iterable<EmployeeBuilding> getAllEmployee_Buildings() {
		return Employee_BuildingRepo.findAll();
	}

	@GetMapping("/{id}")
	public EmployeeBuilding Employee_BuildingById(@PathVariable("id") int id) {
		Optional<EmployeeBuilding> optEmployee_Building = Employee_BuildingRepo.findById(id);
		if (optEmployee_Building.isPresent()) {
			return optEmployee_Building.get();
		}
		return null;
	}
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public EmployeeBuilding createEmployeeBuilding(@RequestBody EmployeeBuilding employeeBuilding) {
		return Employee_BuildingRepo.save(employeeBuilding);
	}
	@PutMapping("/{id}")
	public EmployeeBuilding changeEmployeeBuilding(@RequestBody EmployeeBuilding employeeBuilding) {
		return Employee_BuildingRepo.save(employeeBuilding);
	}
	@Transactional
	@DeleteMapping("/{id}")
	public void deleteEmployeeBuilding(@PathVariable("id") int id) {
		try {
			Employee_BuildingRepo.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
		}
	}
}