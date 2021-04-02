package web.data;

import org.springframework.data.repository.CrudRepository;

import web.model.Company;
public interface CompanyRepository extends CrudRepository<Company, String>{
} 