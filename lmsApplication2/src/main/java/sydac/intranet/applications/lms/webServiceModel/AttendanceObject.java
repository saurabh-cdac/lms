package sydac.intranet.applications.lms.webServiceModel;

import java.util.Arrays;

public class AttendanceObject {

	String attendanceStatus;
	
	int inTimeArray[] = new int[5];
	
	int outTimeArray[] = new int[5];  	

	public String getAttendanceStatus() {
		return attendanceStatus;
	}

	public void setAttendanceStatus(String attendanceStatus) {
		this.attendanceStatus = attendanceStatus;
	}

	public int[] getInTimeArray() {
		return inTimeArray;
	}

	public void setInTimeArray(int[] inTimeArray) {
		this.inTimeArray = inTimeArray;
	}

	public int[] getOutTimeArray() {
		return outTimeArray;
	}

	public void setOutTimeArray(int[] outTimeArray) {
		this.outTimeArray = outTimeArray;
	}

	@Override
	public String toString() {
		return "AttendanceObject [attendanceStatus=" + attendanceStatus + ", inTimeArray="
				+ Arrays.toString(inTimeArray) + ", outTimeArray=" + Arrays.toString(outTimeArray) + "]";
	}

	
	
}