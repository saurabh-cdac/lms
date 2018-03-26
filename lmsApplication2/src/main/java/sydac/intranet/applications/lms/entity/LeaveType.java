package sydac.intranet.applications.lms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LEAVE_TYPE" )
public class LeaveType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "LEAVE_TYPE_ID", nullable = false, unique = true, length = 2)
	private int leaveTypeId;

	@Column(name = "LEAVE_TYPE", length = 20, nullable = false)
	private String leaveType;

	@Column(name = "LEAVE_TYPE_DESCRIPTION", length = 50, nullable = true)
	private String leaveTypeDescription;
	

	public int getLeaveTypeId() {
		return leaveTypeId;
	}

	public void setLeaveTypeId(int leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public String getLeaveTypeDescription() {
		return leaveTypeDescription;
	}

	public void setLeaveTypeDescription(String leaveTypeDescription) {
		this.leaveTypeDescription = leaveTypeDescription;
	}

	@Override
	public String toString() {
		return "LeaveType [leaveTypeId=" + leaveTypeId + ", leaveType=" + leaveType + ", leaveTypeDescription="
				+ leaveTypeDescription + "]";
	}
	
	
}