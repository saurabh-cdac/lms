package sydac.intranet.applications.lms.entity;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ATTENDANCE_STATUS")
public class AttendanceStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ATTENDANCE_STATUS_ID", nullable = false, unique = true, length = 2)
	private int attendanceStatusId;

	@Column(name = "STATUS_CODE", nullable = false)
	private String statusCode;

	@Column(name = "STATUS_DESCRIPTION", nullable = true, length = 50)
	private Time statusDescription;

	public int getAttendanceStatusId() {
		return attendanceStatusId;
	}

	public void setAttendanceStatusId(int attendanceStatusId) {
		this.attendanceStatusId = attendanceStatusId;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public Time getStatusDescription() {
		return statusDescription;
	}

	public void setStatusDescription(Time statusDescription) {
		this.statusDescription = statusDescription;
	}

	@Override
	public String toString() {
		return "AttendanceStatus [attendanceStatusId=" + attendanceStatusId + ", statusCode=" + statusCode
				+ ", statusDescription=" + statusDescription + "]";
	}
	
	
}