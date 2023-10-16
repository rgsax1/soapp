package flexnyl.com.br.backendsoapp.order;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {
	private final OrderService orderService;
	
	public OrderController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}

	@PostMapping
	public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDTO){
		OrderDTO savedOrder = orderService.createOrder(orderDTO);
		return new ResponseEntity<OrderDTO>(savedOrder,HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<OrderDTO>> getAllOrders(){
		List<OrderDTO> orders = orderService.getAllOrder();
		return ResponseEntity.ok(orders);
	}
    
    @GetMapping("{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable("id") Long id){
        OrderDTO orderDTO = orderService.getOrderById(id);
        return ResponseEntity.ok(orderDTO);
    }

    @PutMapping("{id}")
    public ResponseEntity<OrderDTO> updateOrder(@PathVariable("id") Long id, @RequestBody OrderDTO updatedOrder){
        OrderDTO orderDTO = orderService.updateOrder(id, updatedOrder);
        return ResponseEntity.ok(orderDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable("id") Long id){
        orderService.deleteOrder(id);
        return ResponseEntity.ok("Order deleted successfully!");
    }
	
	
}
