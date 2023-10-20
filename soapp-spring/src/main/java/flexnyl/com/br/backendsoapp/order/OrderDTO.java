package flexnyl.com.br.backendsoapp.order;

import java.util.Calendar;
import flexnyl.com.br.backendsoapp.equipment.Equipment;
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
	private Calendar issueData;
	private Calendar completionData;
	private String observations;
	private String analysis;
	private User user; 
	private Equipment equipment;
	private String signatureResponsible;
	private String signatureMechanical;
	
	
	
}
