package sydac.intranet.applications.lms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LEAVE_BALANCE")
public class LeaveBalance {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	private int id;
	
	@Column(name = "EMP_ID", nullable = false)
	private int empid;

	@Column(name = "LEAVE_TYPE_ID", nullable = false)
	private int leaveTypeId;

	@Column(name = "CURRENT_BALANCE", nullable = false)
	private int currentBalance;

	@Column(name = "OPENING_BALANCE", nullable = false)
	private int openingBalance;

	@Column(name = "FINANCIAL_YEAR", nullable = false)
	private int financicalYear;

	@Column(name = "LEAVE_USED", nullable = false)
	private int leaveUsed;

	@Column(name = "IS_VISIBLE", nullable = false)
	private boolean isVisible;
	
	@OneToOne(fetch = FetchType.LAZY)
	private LeaveType leaveType;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public int getLeaveTypeId() {
		return leaveTypeId;
	}

	public void setLeaveTypeId(int leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}

	public int getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(int currentBalance) {
		this.currentBalance = currentBalance;
	}

	public int getOpeningBalance() {
		return openingBalance;
	}

	public void setOpeningBalance(int openingBalance) {
		this.openingBalance = openingBalance;
	}

	public int getFinancicalYear() {
		return financicalYear;
	}

	public void setFinancicalYear(int financicalYear) {
		this.financicalYear = financicalYear;
	}

	public int getLeaveUsed() {
		return leaveUsed;
	}

	public void setLeaveUsed(int leaveUsed) {
		this.leaveUsed = leaveUsed;
	}

	public boolean isVisible() {
		return isVisible;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

	public LeaveType getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(LeaveType leaveType) {
		this.leaveType = leaveType;
	}

	@Override
	public String toString() {
		return "LeaveBalance [id=" + id + ", empid=" + empid + ", leaveTypeId=" + leaveTypeId + ", currentBalance="
				+ currentBalance + ", openingBalance=" + openingBalance + ", financicalYear=" + financicalYear
				+ ", leaveUsed=" + leaveUsed + ", isVisible=" + isVisible + ", leaveType=" + leaveType + "]";
	}
	
}
