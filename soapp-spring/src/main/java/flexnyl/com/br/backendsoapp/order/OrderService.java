package flexnyl.com.br.backendsoapp.order;

import java.util.List;

public interface OrderService {

    OrderDTO createOrder(OrderDTO orderDTO);

    OrderDTO getOrderById(long id);

    List<OrderDTO> getAllOrder();

    OrderDTO updateOrder(long id, OrderDTO order);

    void deleteOrder(long id);

}
