package sydac.intranet.applications.lms.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ATTENDANCE_RECORD")
public class AttendanceRecord {
	@Id
	@Column(name = "ID", nullable = false)
	private int id;
	
	@Column(name = "EMP_ID", nullable = false)
	private int empId;

	@Temporal(TemporalType.DATE)
	@Column(name = "ATTENDANCE_DATE", nullable = false)
	private Date attendanceDate;

	@Temporal(TemporalType.TIME)
	@Column(name = "IN_TIME", nullable = true)
	private Date inTime;

	@Temporal(TemporalType.TIME)
	@Column(name = "OUT_TIME", nullable = true)
	private Date outTime;

	@Column(name = "ATTENDANCE_STATUS_ID", length = 60, nullable = false)
	private String attendanceStatusId;

	
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public Date getAttendanceDate() {
		return attendanceDate;
	}

	public void setAttendanceDate(Date attendanceDate) {
		this.attendanceDate = attendanceDate;
	}

	public Date getInTime() {
		return inTime;
	}

	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}

	public Date getOutTime() {
		return outTime;
	}

	public void setOutTime(Date outTime) {
		this.outTime = outTime;
	}

	public String getAttendanceStatusId() {
		return attendanceStatusId;
	}

	public void setAttendanceStatusId(String attendanceStatusId) {
		this.attendanceStatusId = attendanceStatusId;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "AttendanceRecord [empId=" + empId + ", attendanceDate=" + attendanceDate + ", inTime=" + inTime
				+ ", outTime=" + outTime + ", attendanceStatusId=" + attendanceStatusId + "]";
	}

	
	
	

}