package sydac.intranet.applications.lms.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import sydac.intranet.applications.lms.entity.AttendanceRecord;
import sydac.intranet.applications.lms.entity.Employee;

@Repository
@Transactional
public class AttendanceDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(AttendanceDAO.class);

	/**
	 * Save the user in the database.
	 */
	
	//@Transactional(TxType.NEVER)
	public void create(AttendanceRecord attendanceRecords) {
		try {
			entityManager.persist(attendanceRecords);
		} catch (Exception ex) {
			LOGGER.error("Error adding the Attendance Record.", ex);
		}
		return;
	}

	/**
	 * Return all the users stored in the database.
	 */
	@SuppressWarnings("unchecked")
	public List<Employee> getAll() {
		return entityManager.createQuery("from User").getResultList();
	}

	/**
	 * Return the user having the passed id.
	 */
	public Employee getById(int id) {
		return entityManager.find(Employee.class, id);
	}

	/**
	 * Return the attendance of users selected date.
	 * @throws ParseException 
	 */
	public List<AttendanceRecord> getAttByDate(int empId, Date fromDate, Date toDate) {

		Query query2 = entityManager
				.createQuery(
						"FROM AttendanceRecord WHERE empId = :empId AND attendanceDate between :fromDate and :toDate")
				.setParameter("empId", empId).setParameter("fromDate", fromDate).setParameter("toDate", toDate);

		List<AttendanceRecord> empList = query2.getResultList();
		for (AttendanceRecord attendanceRecord : empList) {

			System.err.println(attendanceRecord.toString());
		}

		return empList;
	}
	
	/**
	 * Return the attendance of users selected date.
	 * @throws ParseException 
	 */
	public List<AttendanceRecord> getAttByMonth(int empId, String month) {

		Query query2 = entityManager
				.createQuery(
						"FROM AttendanceRecord WHERE empId = :empId AND to_char(attendanceDate,'Mon') = :month ORDER BY attendanceDate ASC")
				.setParameter("empId", empId).setParameter("month", month);

		List<AttendanceRecord> empList = query2.getResultList();
		for (AttendanceRecord attendanceRecord : empList) {
			System.out.println("AttendanceDAO.getAttByMonth()");
			System.err.println(attendanceRecord.toString());
		}

		return empList;
	}
	
	/**
	 * Return the attendance of users selected date.
	 * @throws ParseException 
	 */
	public List<AttendanceRecord> getAttByMonth(int empId, String month, String year) {
		
		Query query2 = entityManager
				.createQuery(
						"FROM AttendanceRecord WHERE empId = :empId AND "
						+ "to_char(attendanceDate,'Mon') = :month AND "
						+ "to_char(attendanceDate,'YYYY') = :year ORDER BY attendanceDate ASC")
				.setParameter("empId", empId)
				.setParameter("month", month)
				.setParameter("year", year);
		
		List<AttendanceRecord> empList = query2.getResultList();

		
		for (AttendanceRecord attendanceRecord : empList) {
			System.out.println("AttendanceDAO.getAttByMonth()"+attendanceRecord.toString());
		}
		return empList;
	}
	
	
	/**
	 * Return the attendance of users by date.
	 * @throws ParseException 
	 */
	public List<AttendanceRecord> getAttByDate(int id)  {
		
		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<AttendanceRecord> criteriaQuery = criteriaBuilder.createQuery(AttendanceRecord.class);
		Root<AttendanceRecord> root = criteriaQuery.from(AttendanceRecord.class);
		
		Predicate conjunction = criteriaBuilder.conjunction();
		
		criteriaQuery.where(criteriaBuilder.and(criteriaBuilder.equal(root.get("empId"), id)
				, criteriaBuilder.greaterThan(root.get("attendanceDate"),   new Date())));
		
		final TypedQuery<AttendanceRecord> query = entityManager.createQuery(criteriaQuery);
		List<AttendanceRecord> empList = query.getResultList();
		
		for (AttendanceRecord attendanceRecord : empList) {
			
			System.err.println(attendanceRecord.toString());
		}
		
		return empList;
	}

	public List<AttendanceRecord> getAllAtt() {
		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

		// Create criteria query and pass the value object which needs to be
		// populated as result
		final CriteriaQuery<AttendanceRecord> criteriaQuery = criteriaBuilder.createQuery(AttendanceRecord.class);
		Root<AttendanceRecord> root = criteriaQuery.from(AttendanceRecord.class);
		criteriaQuery.select(root);
		final TypedQuery<AttendanceRecord> query = entityManager.createQuery(criteriaQuery);
		List<AttendanceRecord> empList = query.getResultList();
		for (AttendanceRecord attendanceRecord : empList) {

			System.err.println(attendanceRecord.toString());
		}
		return empList;
	}

	/**
	 * Update the passed user in the database.
	 */
	public void update(Employee emp) {
		entityManager.merge(emp);
		return;
	}

	// ------------------------
	// PRIVATE FIELDS
	// ------------------------

	// An EntityManager will be automatically injected from entityManagerFactory
	// setup on DatabaseConfig class.
	@PersistenceContext
	private EntityManager entityManager;
}
