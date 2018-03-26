package sydac.intranet.applications.lms.processors;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sydac.intranet.applications.lms.dao.AttendanceDAO;
import sydac.intranet.applications.lms.entity.AttendanceRecord;
import sydac.intranet.applications.lms.webServiceModel.AttendanceDataModel;
import sydac.intranet.applications.lms.webServiceModel.AttendanceObject;

@Component
public class AttendanceProcessorImpl implements AttendanceProcessor {
	
	@Autowired
	AttendanceDAO attendanceDao;

	public void addAttRec(AttendanceRecord attendanceRecords)
	{
		attendanceDao.create(attendanceRecords);
	}

	@Override
	public List<AttendanceRecord> fetchAllAtt() {
		return attendanceDao.getAllAtt();
	}

	@Override
	public List<AttendanceRecord> getAttByDate(int empId, String fromDate, String toDate) {
		SimpleDateFormat f = new SimpleDateFormat("dd-MMM-yy");
		
		Date fromDate1 = null, toDate1 = null;
		try {
			fromDate1 = f.parse(fromDate);
			toDate1 = f.parse(toDate);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return attendanceDao.getAttByDate(empId,fromDate1,toDate1);
	}
	
	
	
	@Override
	public List<AttendanceDataModel> getAttendanceByDates(int empId, String fromDate, String toDate) {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");

		Date fromDate1 = null, toDate1 = null;
		try {
			fromDate1 = f.parse(fromDate);
			toDate1 = f.parse(toDate);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<AttendanceRecord> recordList = attendanceDao.getAttByDate(empId, fromDate1, toDate1);
		AttendanceDataModel dataModel;
		List<AttendanceDataModel> dataModelsList = new ArrayList<>();
		for (AttendanceRecord attendanceRecord : recordList) {
			dataModel = new AttendanceDataModel();

			dataModel.setTitle(attendanceRecord.getAttendanceStatusId());
			dataModel.setStart(attendanceRecord.getAttendanceDate().toString());
			dataModelsList.add(dataModel);

			dataModel = new AttendanceDataModel();
			dataModel.setTitle("In");
			dataModel.setStart(attendanceRecord.getAttendanceDate() + "T" + attendanceRecord.getInTime());
			dataModelsList.add(dataModel);

			dataModel = new AttendanceDataModel();
			dataModel.setTitle("Out");
			dataModel.setStart(attendanceRecord.getAttendanceDate() + "T" + attendanceRecord.getOutTime());
			dataModelsList.add(dataModel);

		}
		return dataModelsList;
	}

	@Override
	public List<AttendanceObject>  getAttByMonth(int empId, String month, int year) {
		AttendanceObject attendanceObject ;
		List<AttendanceObject> attendanceObjects = new ArrayList<>();
		List<AttendanceRecord> attendanceRecords = attendanceDao.getAttByMonth(empId,month,Integer.toString(year));
		for (AttendanceRecord attendanceRecord : attendanceRecords) {
			attendanceObject = new AttendanceObject();
			attendanceObject.setAttendanceStatus(attendanceRecord.getAttendanceStatusId());
			attendanceObject.setInTimeArray(convertDateToArray(attendanceRecord.getAttendanceDate(), attendanceRecord.getInTime()));
			attendanceObject.setOutTimeArray(convertDateToArray(attendanceRecord.getAttendanceDate(), attendanceRecord.getOutTime()));
			attendanceObjects.add(attendanceObject);
		}
		return attendanceObjects;
	}
	
	private int[] convertDateToArray(Date attendanceDate, Date inTime) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(inTime);
		int hours = calendar.get(Calendar.HOUR_OF_DAY);
		int minutes = calendar.get(Calendar.MINUTE);
		
		calendar.setTime(attendanceDate);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int month = calendar.get(Calendar.MONTH) + 1;
		int year = calendar.get(Calendar.YEAR);

		int[] timeArray = {year, month, day, hours, minutes};
		return timeArray;
	}

	@Override
	public List<AttendanceObject> getAttByMonth(int empId, String month) {
		int year = Calendar.getInstance().get(Calendar.YEAR);
		return getAttByMonth(empId,month,year);
	}
}
