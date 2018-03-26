package sydac.intranet.applications.lms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LEAVE_CONFIGURATION")
public class LeaveConfiguration {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	private int id;
	
	@Column(name = "LEAVE_TYPE_ID", nullable = false)
	private int leaveTypeId;

	@Column(name = "CREDIT_FREQUENCY", nullable = false)
	private int creditFrequency;

	@Column(name = "CREDIT_VALUE", nullable = false)
	private int creditValue;

	@Column(name = "CARRY_FORWARD", nullable = false)
	private boolean carryForward;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
		
	public int getLeaveTypeId() {
		return leaveTypeId;
	}

	public void setLeaveTypeId(int leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}

	public int getCreditFrequency() {
		return creditFrequency;
	}

	public void setCreditFrequency(int creditFrequency) {
		this.creditFrequency = creditFrequency;
	}

	public int getCreditValue() {
		return creditValue;
	}

	public void setCreditValue(int creditValue) {
		this.creditValue = creditValue;
	}

	public boolean getCarryForward() {
		return carryForward;
	}

	public void setCarryForward(boolean carryForward) {
		this.carryForward = carryForward;
	}
}