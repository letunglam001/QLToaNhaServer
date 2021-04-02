package web.api;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.Query;
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

import web.data.CompanyRepository;
import web.model.Company;


@RestController
@RequestMapping(path = "/company", produces = "application/json")
@CrossOrigin(origins = "*")
public class CompanyController {
	private CompanyRepository CompanyRepo;
	@Autowired
	EntityLinks entityLinks;

	public CompanyController(CompanyRepository CompanyRepo) {
		this.CompanyRepo = CompanyRepo;
	}
	@GetMapping
	public Iterable<Company> getAllCompanys() {
		return CompanyRepo.findAll();
	}
	@GetMapping("/{id}")
	public Company CompanyById(@PathVariable("id") String id) {
		Optional<Company> optCompany = CompanyRepo.findById(id);
		if (optCompany.isPresent()) {
			return optCompany.get();
		}
		return null;
	}
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Company createCompany(@RequestBody Company company) {
//		double price=0;
//		if(company.getTotalEmployee()<10&&company.getArea()<100) price=
		return CompanyRepo.save(company);
		
	}
	@PutMapping("/{id}")
	public Company changeCompany(@RequestBody Company company) {
		return CompanyRepo.save(company);
	}
	@DeleteMapping("/{id}")
	public void deleteCompany(@PathVariable("id") String id) {
		try {
			CompanyRepo.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
		}
	}
}