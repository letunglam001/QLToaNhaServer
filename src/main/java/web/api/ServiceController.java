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

import web.data.ServiceRepository;
import web.model.Company;
import web.model.Service;
import web.model.Service.Type;


@RestController
@RequestMapping(path = "/service", produces = "application/json")
@CrossOrigin(origins = "*")
public class ServiceController {
	private ServiceRepository ServiceRepo;
	@Autowired
	EntityLinks entityLinks;

	public ServiceController(ServiceRepository ServiceRepo) {
		this.ServiceRepo = ServiceRepo;
	}

	@GetMapping
	public Iterable<Service> getAllServices() {
		return ServiceRepo.findAll();
	}
	@GetMapping("/get/{name}")
	public Service ServiceByType(@PathVariable("name") String name) {
		Optional<Service> optService = ServiceRepo.findByName(name);
		if (optService.isPresent()) {
			return optService.get();
		}
		return null;
	}
	@GetMapping("/{id}")
	public Service ServiceById(@PathVariable("id") String id) {
		Optional<Service> optService = ServiceRepo.findById(id);
		if (optService.isPresent()) {
			return optService.get();
		}
		return null;
	}
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Service createService(@RequestBody Service service) {
		return ServiceRepo.save(service);
	}
	@PutMapping("/{id}")
	public Service changeService(@RequestBody Service service) {
		return ServiceRepo.save(service);
	}
	@Transactional
	@DeleteMapping("/{id}")
	public void deleteService(@PathVariable("id") String id) {
		try {
			ServiceRepo.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
		}
	}
}