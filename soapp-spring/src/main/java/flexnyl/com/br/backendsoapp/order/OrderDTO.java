package flexnyl.com.br.backendsoapp.order;

import flexnyl.com.br.backendsoapp.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private long id;
    private User userOperator;
    private String issueDate;
    private String startServiceDate;
    private String finishServiceDate;
    private String defect;
    private String activityPerformed;
    private User userResponsible;
}
