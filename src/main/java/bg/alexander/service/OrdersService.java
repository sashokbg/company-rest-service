package bg.alexander.service;

import java.util.List;
import java.time.LocalDate;

import bg.alexander.model.Order;

public interface OrdersService {
	public List<Order> getOrdersOrdered(LocalDate before);
}
