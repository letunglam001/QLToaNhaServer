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

import web.data.EmployeeCompanyRepository;
import web.data.ServiceRepository;
import web.model.EmployeeCompany;
import web.model.Service;


@RestController
@RequestMapping(path = "/employeeCompany", produces = "application/json")
@CrossOrigin(origins = "*")
public class EmployeeCompanyController {
	private EmployeeCompanyRepository Employee_CompanyRepo;
	@Autowired
	EntityLinks entityLinks;

	public EmployeeCompanyController(EmployeeCompanyRepository Employee_CompanyRepo) {
		this.Employee_CompanyRepo = Employee_CompanyRepo;
	}

	@GetMapping
	public Iterable<EmployeeCompany> getAllEmployee_Companys() {
		return Employee_CompanyRepo.findAll();
	}

	@GetMapping("/{id}")
	public EmployeeCompany Employee_CompanyById(@PathVariable("id") String id) {
		Optional<EmployeeCompany> optEmployee_Company = Employee_CompanyRepo.findById(id);
		if (optEmployee_Company.isPresent()) {
			return optEmployee_Company.get();
		}
		return null;
	}
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public EmployeeCompany createEmployeeCompany(@RequestBody EmployeeCompany employeeCompany) {
		return Employee_CompanyRepo.save(employeeCompany);
	}
	@PutMapping("/{CMT}")
	public EmployeeCompany changeEmployeeCompany(@RequestBody EmployeeCompany employeeCompany) {
		return Employee_CompanyRepo.save(employeeCompany);
	}
	@Transactional
	@DeleteMapping("/{CMT}")
	public void deleteEmployeeCompany(@PathVariable("CMT") String CMT) {
		try {
			Employee_CompanyRepo.deleteById(CMT);
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
		}
	}
}