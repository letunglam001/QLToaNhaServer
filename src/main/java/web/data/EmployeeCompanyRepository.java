package web.data;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import web.model.EmployeeCompany;

public interface EmployeeCompanyRepository extends CrudRepository<EmployeeCompany, String>{
} 