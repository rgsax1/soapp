package flexnyl.com.br.backendsoapp.order;

public class OrderMapper {
    public static Order mapToOrder(OrderDTO orderDTO){
        return new Order(
                orderDTO.getId(),
                orderDTO.getUserOperator(),
                orderDTO.getIssueDate(),
                orderDTO.getStartServiceDate(),
                orderDTO.getFinishServiceDate(),
                orderDTO.getDefect(),
                orderDTO.getActivityPerformed(),
                orderDTO.getUserResponsible()
        );
    }

    public static OrderDTO mapToOrderDTO(Order order){
        return new OrderDTO(
                order.getId(),
                order.getUserOperator(),
                order.getIssueDate(),
                order.getStartServiceDate(),
                order.getFinishServiceDate(),
                order.getDefect(),
                order.getActivityPerformed(),
                order.getUserResponsible()
        );
    }
}
