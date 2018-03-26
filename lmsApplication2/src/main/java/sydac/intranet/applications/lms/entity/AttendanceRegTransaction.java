package sydac.intranet.applications.lms.entity;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ATTENDANCE_REG_TRANSACTION")
public class AttendanceRegTransaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	private int id;
	
	@Column(name = "EMP_ID", nullable = false)
	private int empId;

	@Column(name = "ATTENDANCE_REG_DATE", nullable = false)
	private Date attendanceRegDate;

	@Column(name = "OLD_IN_TIME", nullable = true)
	private Time oldInTime;

	@Column(name = "OLD_OUT_TIME", nullable = true)
	private Time oldOutTime;

	@Column(name = "NEW_IN_TIME", nullable = false)
	private Time newInTime;

	@Column(name = "NEW_OUT_TIME", nullable = false)
	private Time newOutTime;

	@Column(name = "STATUS", nullable = false)
	private boolean status;

	@Column(name = "MANAGER_ID", nullable = false)
	private String managerId;

	@Column(name = "SUBMITTED_ON", nullable = false)
	private Date submittedOn;

	@Column(name = "APPROVED_ON", nullable = false)
	private Date approvedOn;

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

	public Date getAttendanceRegDate() {
		return attendanceRegDate;
	}

	public void setAttendanceRegDate(Date attendanceRegDate) {
		this.attendanceRegDate = attendanceRegDate;
	}

	public Time getOldInTime() {
		return oldInTime;
	}

	public void setOldInTime(Time oldInTime) {
		this.oldInTime = oldInTime;
	}

	public Time getOldOutTime() {
		return oldOutTime;
	}

	public void setOldOutTime(Time oldOutTime) {
		this.oldOutTime = oldOutTime;
	}

	public Time getNewInTime() {
		return newInTime;
	}

	public void setNewInTime(Time newInTime) {
		this.newInTime = newInTime;
	}

	public Time getNewOutTime() {
		return newOutTime;
	}

	public void setNewOutTime(Time newOutTime) {
		this.newOutTime = newOutTime;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public Date getSubmittedOn() {
		return submittedOn;
	}

	public void setSubmittedOn(Date submittedOn) {
		this.submittedOn = submittedOn;
	}

	public Date getApprovedOn() {
		return approvedOn;
	}

	public void setApprovedOn(Date approvedOn) {
		this.approvedOn = approvedOn;
	}

	@Override
	public String toString() {
		return "AttendanceRegTransaction [id=" + id + ", empId=" + empId + ", attendanceRegDate=" + attendanceRegDate
				+ ", oldInTime=" + oldInTime + ", oldOutTime=" + oldOutTime + ", newInTime=" + newInTime
				+ ", newOutTime=" + newOutTime + ", status=" + status + ", managerId=" + managerId + ", submittedOn="
				+ submittedOn + ", approvedOn=" + approvedOn + "]";
	}
	
	

}