package sydac.intranet.applications.lms.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LEAVE_TRANSACTION")
public class LeaveTransaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	private int id;
	
	@Column(name = "EMP_ID", nullable = false)
	private int empId;

	@Column(name = "LEAVE_TYPE_ID", nullable = false)
	private int leaveTypeId;

	@Column(name = "FROM_DATE", nullable = false)
	private Date fromDate;

	@Column(name = "TO_DATE", nullable = false)
	private Date toDate;

	@Column(name = "REMARK", nullable = false, length = 50)
	private int remark;

	@Column(name = "LEAVE_STATUS", nullable = false)
	private int leaveStatus;

	@Column(name = "NO_OF_LEAVES", nullable = false)
	private int noOfLeaves;

	@Column(name = "MANAGER_ID", nullable = false)
	private int managerId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
		
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getLeaveTypeId() {
		return leaveTypeId;
	}

	public void setLeaveTypeId(int leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public int getRemark() {
		return remark;
	}

	public void setRemark(int remark) {
		this.remark = remark;
	}

	public int getLeaveStatus() {
		return leaveStatus;
	}

	public void setLeaveStatus(int leaveStatus) {
		this.leaveStatus = leaveStatus;
	}

	public int getNoOfLeaves() {
		return noOfLeaves;
	}

	public void setNoOfLeaves(int noOfLeaves) {
		this.noOfLeaves = noOfLeaves;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	@Override
	public String toString() {
		return "LeaveTransaction [id=" + id + ", empId=" + empId + ", leaveTypeId=" + leaveTypeId + ", fromDate="
				+ fromDate + ", toDate=" + toDate + ", remark=" + remark + ", leaveStatus=" + leaveStatus
				+ ", noOfLeaves=" + noOfLeaves + ", managerId=" + managerId + "]";
	}
	
	
}