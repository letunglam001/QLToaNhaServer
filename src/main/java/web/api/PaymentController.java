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
import web.data.PaymentRepository;
import web.data.ServiceRepository;
import web.model.EmployeeBuilding;
import web.model.EmployeeCompany;
import web.model.Payment;
import web.model.Service;


@RestController
@RequestMapping(path = "/payment", produces = "application/json")
@CrossOrigin(origins = "*")
public class PaymentController { 
	private PaymentRepository PaymentRepo;
	@Autowired
	EntityLinks entityLinks;

	public PaymentController(PaymentRepository PaymentRepo) {
		this.PaymentRepo = PaymentRepo;
	}

	@GetMapping
	public Iterable<Payment> getAllPayments() {
		return PaymentRepo.findAll();
	}

	@GetMapping("/{id}")
	public Payment PaymentById(@PathVariable("id") int id) {
		Optional<Payment> optPayment = PaymentRepo.findById(id);
		if (optPayment.isPresent()) {
			return optPayment.get();
		}
		return null;
	}
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Payment createPayment(@RequestBody Payment payment) {
		return PaymentRepo.save(payment);
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