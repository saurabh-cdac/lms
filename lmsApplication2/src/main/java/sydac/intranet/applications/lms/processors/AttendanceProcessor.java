package sydac.intranet.applications.lms.processors;

import java.util.List;

import sydac.intranet.applications.lms.entity.AttendanceRecord;
import sydac.intranet.applications.lms.webServiceModel.AttendanceDataModel;
import sydac.intranet.applications.lms.webServiceModel.AttendanceObject;

public interface AttendanceProcessor 
{
	List<AttendanceRecord> getAttByDate(int empId,String fromDate, String toDate);
	
	List<AttendanceDataModel> getAttendanceByDates(int empId,String fromDate, String toDate);
	
	List<AttendanceRecord> fetchAllAtt();
		
	void addAttRec(AttendanceRecord attendanceRecords);
	
	List<AttendanceObject> getAttByMonth(int empId, String month, int year);
	
	List<AttendanceObject> getAttByMonth(int empId, String month);
}
