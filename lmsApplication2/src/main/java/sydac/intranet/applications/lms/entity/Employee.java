package sydac.intranet.applications.lms.entity;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="EMPLOYEE", uniqueConstraints = {@UniqueConstraint(columnNames = "EMAIL") })
public class Employee
{
	@Id
	@Column(name="EMP_NUMBER", nullable=false, unique=true, length=10)
	private int empNumber;
	
	@Column(name="NAME", length=20, nullable=true)
	private String name;
	
	@Column(name="ROLE_ID", length=20, nullable=true)
	private String roleId;
	
	@Column(name="EMAIL", length=60, nullable=true)
	private String email;
	
	@Column(name="MANAGER_ID", length=10, nullable=false)
	private int managerId;
	
	@Column(name="JOINING_DATE", length=10, nullable=false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	//@Temporal(TemporalType.TIMESTAMP)
	private Date joiningDate;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name="EMPLOYEE_LEAVEBALANCE", joinColumns={ @JoinColumn(name = "EMP_ID")}, inverseJoinColumns = { @JoinColumn(name = "LEAVEBALANCE_ID") })
	private List<LeaveBalance> leaveBalance;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name="EMPLOYEE_LEAVETRAN", joinColumns={ @JoinColumn(name = "EMP_ID")}, inverseJoinColumns = { @JoinColumn(name = "ID") })
	private List<LeaveTransaction> leaveTransactions;
	
	public int getEmpNumber() {
		return empNumber;
	}

	public void setEmpNumber(int empNumber) {
		this.empNumber = empNumber;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}


	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public List<LeaveBalance> getLeaveBalance() {
		return leaveBalance;
	}

	public void setLeaveBalance(List<LeaveBalance> leaveBalance) {
		this.leaveBalance = leaveBalance;
	}

	public List<LeaveTransaction> getLeaveTransactions() {
		return leaveTransactions;
	}

	public void setLeaveTransactions(List<LeaveTransaction> leaveTransactions) {
		this.leaveTransactions = leaveTransactions;
	}

	@Override
	public String toString() {
		return "Employee [empNumber=" + empNumber + ", name=" + name + ", roleId=" + roleId + ", email=" + email
				+ ", managerId=" + managerId + ", joiningDate=" + joiningDate + ", leaveBalance=" + leaveBalance
				+ ", leaveTransactions=" + leaveTransactions + "]";
	}
}