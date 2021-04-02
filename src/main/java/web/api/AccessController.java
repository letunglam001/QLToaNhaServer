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

import web.data.AccessRepository;
import web.data.EmployeeBuildingRepository;
import web.data.EmployeeCompanyRepository;
import web.data.PaymentRepository;
import web.data.ServiceRepository;
import web.model.Access;
import web.model.EmployeeBuilding;
import web.model.EmployeeCompany;
import web.model.Payment;
import web.model.Service;


@RestController
@RequestMapping(path = "/access", produces = "application/json")
@CrossOrigin(origins = "*")
public class AccessController { 
	private AccessRepository AccessRepo;
	@Autowired
	EntityLinks entityLinks;

	public AccessController(AccessRepository AccessRepo) {
		this.AccessRepo = AccessRepo;
	}

	@GetMapping
	public Iterable<Access> getAllAccesss() {
		return AccessRepo.findAll();
	}

	@GetMapping("/{id}")
	public Access AccessById(@PathVariable("id") int id) {
		Optional<Access> optAccess= AccessRepo.findById(id);
		if (optAccess.isPresent()) {
			return optAccess.get();
		}
		return null;
	}
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Access createAccess(@RequestBody Access access) {
		return AccessRepo.save(access);
	}
//	@PutMapping("/{id}")
//	public Payment changePayment(@RequestBody Payment payment) {
//		return PaymentRepo.save(payment);
//	}
//	@Transactional
//	@DeleteMapping("/{id}")
//	public void deleteEmployeeBuilding(@PathVariable("id") int id) {
//		try {
//			Employee_BuildingRepo.deleteById(id);
//		} catch (EmptyResultDataAccessException e) {
//			e.printStackTrace();
//		}
//	}
}