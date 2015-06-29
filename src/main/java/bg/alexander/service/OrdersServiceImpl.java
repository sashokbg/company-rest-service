package bg.alexander.service;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import bg.alexander.model.Order;

@SessionScoped
public class OrdersServiceImpl implements OrdersService,Serializable{
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Order> getOrdersOrdered(LocalDate before) {
		
		Query findOrdersQuery = em.createQuery("SELECT o FROM Order o WHERE o.orderDate < :compareDate", Order.class)
			    .setParameter("compareDate", before)
			    .setMaxResults(10);
		
		return findOrdersQuery.getResultList();
	}

	
}
