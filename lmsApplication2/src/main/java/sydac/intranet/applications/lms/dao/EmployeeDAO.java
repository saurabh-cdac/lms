package sydac.intranet.applications.lms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import sydac.intranet.applications.lms.entity.Employee;

@Repository
@Transactional
public class EmployeeDAO {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDAO.class);

	/**
     * Fetched Employee by Employee Number.
     * @param empNo
     * @return
     */
     public Employee getByEmployeeName(String empNo)
     {
            final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            
          // Create criteria query and pass the value object which needs to be populated as result
          final CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
          Root<Employee> root = criteriaQuery.from(Employee.class);
          criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("name"), empNo));
          final TypedQuery<Employee> query = entityManager.createQuery(criteriaQuery);
          List<Employee> empList =  query.getResultList();
          
          Employee emp = null;
          
          if(!CollectionUtils.isEmpty(empList)) {
             emp = empList.get(0);
          }
          return emp;
     }

	
	/**
	 * Save the user in the database.
	 */
	public void create(Employee emp) {
		try {
			entityManager.persist(emp);
		} catch (Exception ex) {
			LOGGER.error("Error creating the user.", ex);
		}
		return;
	}

	/**
	 * Delete the user from the database.
	 */
	public void delete(Employee emp) {
		if (entityManager.contains(emp))
			entityManager.remove(emp);
		else
			entityManager.remove(entityManager.merge(emp));
		return;
	}

	/**
	 * Return all the users stored in the database.
	 */
	@SuppressWarnings("unchecked")
	public List<Employee> getAll() {
		 final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
         
         // Create criteria query and pass the value object which needs to be populated as result
         final CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
         Root<Employee> root = criteriaQuery.from(Employee.class);
         final TypedQuery<Employee> query = entityManager.createQuery(criteriaQuery);
         List<Employee> empList =  query.getResultList();
         return empList;
	}

	/**
	 * Return the user having the passed id.
	 */
	public Employee getByEmpNumber(int empNumber) {
		return entityManager.find(Employee.class, empNumber);
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
