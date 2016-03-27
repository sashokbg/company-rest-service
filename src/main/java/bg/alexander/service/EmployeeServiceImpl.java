package bg.alexander.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import bg.alexander.model.Employee;

@Stateless
public class EmployeeServiceImpl implements EmployeeService{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Employee getBy(Long id) {
		return em.find(Employee.class, id);
	}

}
