package web.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.AccessLevel;

@Data
@RequiredArgsConstructor
//@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@Entity
@Table(name="Company")
public class Company{
	@Id
	@Column(name="code")
	public String code;
	@Column(name="name")
	public String name;
	@Column(name="characterCapital")
	public double characterCapital;
	@Column(name="field")
	public String field;
	@Column(name="totalEmployee")
	public int totalEmployee;
	@Column(name="address")
	public String address;
	@Column(name="phoneNumber")
	public String phoneNumber;
	@Column(name="area")
	public double area;
	@ManyToMany(targetEntity=EmployeeCompany.class)
	public List<EmployeeCompany> employees;
	@ManyToMany(targetEntity = Service.class) 
	public List<Service> services;
//	public Payment payment; 
}
