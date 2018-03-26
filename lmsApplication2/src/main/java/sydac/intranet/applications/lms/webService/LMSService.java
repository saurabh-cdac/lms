package sydac.intranet.applications.lms.webService;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sydac.intranet.applications.lms.dao.EmployeeDAO;
import sydac.intranet.applications.lms.entity.AttendanceRecord;
import sydac.intranet.applications.lms.entity.Employee;
import sydac.intranet.applications.lms.processors.AttendanceProcessor;
import sydac.intranet.applications.lms.webServiceModel.AttendanceDataModel;
import sydac.intranet.applications.lms.webServiceModel.AttendanceObject;

@RestController
@RequestMapping("/lmsService")
public class LMSService {

	@Autowired
	private EmployeeDAO empDao;

	@Autowired
	private AttendanceProcessor leaveProcessor;

	@Autowired
	private AttendanceProcessor attendanceProcessor;

	@RequestMapping(value = "/fetchempdetails", method = RequestMethod.GET)
	public Employee fetchEmployeeDetails(@RequestParam(value = "empNumber") String empId) {
		System.out.println("Inside fetch");
		return empDao.getByEmpNumber(Integer.valueOf(empId));

	}

	@RequestMapping(value = "/fetchEmployeeTestDetails", method = RequestMethod.GET)
	public Employee fetchEmployeeTestDetails(@RequestParam(value = "empNumber") String empId) {
		return empDao.getByEmployeeName(empId);

	}

	@RequestMapping(value = "/fetchAllEmployeeDetails", method = RequestMethod.GET)
	public List<Employee> fetchAllEmployeeTestDetails() {
		return empDao.getAll();

	}

	@RequestMapping(value = "/fetchAllAttendanceDetails", method = RequestMethod.GET)
	public List<AttendanceRecord> fetchAllAttendanceDetails() {
		return attendanceProcessor.fetchAllAtt();
	}

	@RequestMapping(value = "/fetchAttRecordByDuration", method = RequestMethod.GET)
	public List<AttendanceRecord> fetchAttRecordByMonth(@RequestParam(value = "empId") String empId,
			@RequestParam(value = "start") String fromDate, @RequestParam(value = "end") String toDate) {
		return attendanceProcessor.getAttByDate(Integer.valueOf(empId), fromDate, toDate);
	}
	
	@RequestMapping(value = "/fetchAttendanceRecordByDuration", method = RequestMethod.GET)
	public List<AttendanceDataModel> fetchAttendanceByDate(@RequestParam(value = "empId") String empId,
			@RequestParam(value = "start") String fromDate, @RequestParam(value = "end") String toDate,  @RequestParam(value = "_") String ignore) {
		return attendanceProcessor.getAttendanceByDates(Integer.parseInt(empId), fromDate, toDate);
	}

	@RequestMapping(value = "/fetchAttRecordByMonthYear", method = RequestMethod.GET)
	public List<AttendanceObject> fetchAttRecordByMonth(@RequestParam(value = "empId") String empId,
			@RequestParam(value = "mon") String mon, @RequestParam(value = "year") int year) {
		return attendanceProcessor.getAttByMonth(Integer.valueOf(empId), mon, year);
	}

	@RequestMapping(value = "/fetchAttRecordByMonth", method = RequestMethod.GET)
	public List<AttendanceObject> fetchAttRecordByMonth(@RequestParam(value = "empId") String empId,
			@RequestParam(value = "mon") String mon) {
		return attendanceProcessor.getAttByMonth(Integer.valueOf(empId), mon);
	}

	@RequestMapping(value = "/createEmp", method = RequestMethod.POST)
	public void createEmp( @ModelAttribute("createEmp") Employee employee ) {

		/*		for (int i = 0; i < 50; i++) {
			Employee employee = new Employee();
			employee.setJoiningDate(new Date());
			employee.setManagerId(i);
			employee.setName("ABC 1" + i);
			employee.setRoleId("1");
			employee.setEmpNumber(i);
*/		
			empDao.create(employee);
		
	}

	@RequestMapping(value = "/createAttRec", method = RequestMethod.GET)
	public void createAttRec(@ModelAttribute("createAttRec") AttendanceRecord attendanceRecord) {
		
		
		
/*		AttendanceRecord attendanceRecord = new AttendanceRecord();
		attendanceRecord.setEmpId(123);
		attendanceRecord.setInTime(new Date());
		attendanceRecord.setOutTime(new Date());
		attendanceRecord.setAttendanceDate(new Date());
		attendanceRecord.setAttendanceStatusId("Ok");
		attendanceRecord.setId(3);
		attendanceProcessor.addAttRec(attendanceRecord);

		AttendanceRecord attendanceRecord1 = new AttendanceRecord();
		attendanceRecord1.setEmpId(2);
		attendanceRecord1.setInTime(new Date());
		attendanceRecord1.setOutTime(new Date());
		attendanceRecord1.setAttendanceDate(new Date());
		attendanceRecord1.setAttendanceStatusId("Ok");
		attendanceRecord1.setId(4);
		attendanceProcessor.addAttRec(attendanceRecord1);
*/	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(LMSService.class, args);
	}
}
