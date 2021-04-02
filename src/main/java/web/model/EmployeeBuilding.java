package web.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
@Data
@RequiredArgsConstructor
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Table(name="Employee_Building")
public class EmployeeBuilding {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	public final int id;
	@Size (min=2,message="Ten phai co it nhat 2 ky tu")
	public final String name;
	@NotNull(message="Phải có ngày sinh")
	public final Date dateOfBirth;
	@NotNull(message="Phai nhap dia chi")
	public final String address;
	@Size (min=10,max=11,message="So dien thoai phai co it nhat 10 so")
	public final String phoneNumber;
	@NotNull(message="Phai nhap thu hang")
	public final int ranking;
	@NotNull(message="Phai nhap vi tri")
	public final String position;
	@ManyToMany(targetEntity = Service.class) 
	@Size(min=1,message="Phai chon it nhat 1 dich vu")
	public final List<Service> services; 
	public final double salary;
}	
