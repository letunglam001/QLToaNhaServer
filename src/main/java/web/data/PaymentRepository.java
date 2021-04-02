package web.data;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import web.model.EmployeeBuilding;
import web.model.EmployeeCompany;
import web.model.Payment;

public interface PaymentRepository extends CrudRepository<Payment, String>{
	Optional<Payment> findById(int id);
}
