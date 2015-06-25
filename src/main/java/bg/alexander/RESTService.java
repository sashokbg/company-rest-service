package bg.alexander;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import bg.alexander.model.Employee;
import bg.alexander.model.Order;

@Path("/")
public class RESTService {

	@PersistenceContext
	private EntityManager em;

	@GET
	@Produces("application/json")
	@Path("/employee/{id}")
	public Employee getEmployee(@PathParam("id") int id) {
		Employee emplyoee = em.find(Employee.class, id);
		return emplyoee;
	}

	@GET
	@Produces("application/json")
	@Path("/order/{id}")
	public Order getOrders(@PathParam("id") int id) {
		Order order = em.find(Order.class, id);
		return order;
	}
}
