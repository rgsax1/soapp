package flexnyl.com.br.backendsoapp.order;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import flexnyl.com.br.backendsoapp.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

	@Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        Order order = OrderMapper.mapToOrder(orderDTO);
        Order savedOrder = orderRepository.save(order);
        return OrderMapper.mapToOrderDTO(savedOrder);
    }

    @Override
    public OrderDTO getOrderById(long id) {
    	Order order = orderRepository.findById(id)
    			.orElseThrow(()-> new ResourceNotFoundException("Order with id: "+ id + "not found"));
    	return OrderMapper.mapToOrderDTO(order);
    }

    @Override
    public List<OrderDTO> getAllOrder() {
    	List<Order>orders = orderRepository.findAll();
    	return orders.stream().map(OrderMapper::mapToOrderDTO)
    			.collect(Collectors.toList());
    }

@Override
public OrderDTO updateOrder(long id, OrderDTO updatedOrder) {
    Order order = orderRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Order with id: " + id + " not found"));
    order.setUserOperator(updatedOrder.getUserOperator());
    order.setIssueDate(updatedOrder.getIssueDate());
    order.setStartServiceDate(updatedOrder.getStartServiceDate());
    order.setFinishServiceDate(updatedOrder.getFinishServiceDate());
    order.setDefect(updatedOrder.getDefect());
    order.setActivityPerformed(updatedOrder.getActivityPerformed());
    order.setUserResponsible(updatedOrder.getUserResponsible());
    Order updatedOrderObj = orderRepository.save(order);
    return OrderMapper.mapToOrderDTO(updatedOrderObj);
}


    @Override
    public void deleteOrder(long id) {
    	orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order with id: "+id+ "not found"));
    	orderRepository.deleteById(id);
    }
    
}
