package web.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Table(name="Employee_Company")
public class EmployeeCompany {
	@Id
	public final String CMT;
	public final String name;
	public final Date dateOfBirth;
	public final String phoneNumber; 
}
