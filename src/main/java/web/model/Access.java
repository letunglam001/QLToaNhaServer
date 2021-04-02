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
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@Table(name="access")
public class Access {
	@Id
	public final int id; 
	public final Date TimeIn;
	public final Date TimeOut;
	public final String locationIn; 
	public final String locationOut;
//	public static enum Location{
//		Tang1,HamB1,HamB2
//	}
	@ManyToMany(targetEntity = EmployeeCompany.class) 
	public List<EmployeeCompany> employeeCompany;
}
