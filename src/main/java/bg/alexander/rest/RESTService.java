package bg.alexander.rest;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import bg.alexander.model.Employee;
import bg.alexander.model.Order;
import bg.alexander.service.EmployeeService;
import bg.alexander.service.OrdersService;

@Path("/")
@Stateless
public class RESTService {

	@PersistenceContext
	private EntityManager em;
	
	@Inject
	private OrdersService ordersService;
	
	@Inject
	private EmployeeService employeeService;

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
	
	@GET
	@Produces("application/json")
	@Path("/order/before")
	public List<Order> getOrdersBefore(@QueryParam("date") LocalDate date) {
		List<Order> listResult = ordersService.getOrdersOrdered(date);
		return listResult;
	}
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/user/add")
	public Response addEmployee(@Valid Employee employee) {
		if(employeeService.addEmployee(employee)){
			return Response.ok().build();
		}
		return Response.serverError().build();
	}
}
