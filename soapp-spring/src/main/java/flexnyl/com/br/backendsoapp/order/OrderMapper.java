package flexnyl.com.br.backendsoapp.order;

public class OrderMapper {

    public static Order mapToOrder (OrderDTO orderDTO){
        return new Order(
            orderDTO.getId(),
            orderDTO.getIssueData(),
            orderDTO.getCompletionData(),
            orderDTO.getObservations(),
            orderDTO.getAnalysis(),
            orderDTO.getUser(),
            orderDTO.getEquipment(),
            orderDTO.getSignatureResponsible(),
            orderDTO.getSignatureMechanical()
            );
    }

    public static OrderDTO mapToOrderDTO(Order order){
        return new OrderDTO(
            order.getId(),
            order.getIssueData(),
            order.getCompletionData(),
            order.getObservations(),
            order.getAnalysis(),
            order.getUser(),
            order.getEquipment(),
            order.getSignatureResponsible(),
            order.getSignatureMechanical()
        );
    }

}
