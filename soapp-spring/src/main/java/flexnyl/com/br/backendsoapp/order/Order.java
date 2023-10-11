package flexnyl.com.br.backendsoapp.order;

import java.util.Calendar;
import flexnyl.com.br.backendsoapp.equipment.Equipment;
import flexnyl.com.br.backendsoapp.user.User;
import jakarta.persistence.*;

@Table (name = "service_order")
@Entity
public class Order {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	private Calendar issueData;
	private Calendar completionData;
	private String observations;
	private String analysis;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private User user;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Equipment equipment;
	private String signatureResponsible;
	private String signatureMechanical;
	
	public Order(long id, Calendar issueData, Calendar completionData, String observations, String analysis, User user,
			Equipment equipment, String signatureResponsible, String signatureMechanical) {
		super();
		this.id = id;
		this.issueData = issueData;
		this.completionData = completionData;
		this.observations = observations;
		this.analysis = analysis;
		this.user = user;
		this.equipment = equipment;
		this.signatureResponsible = signatureResponsible;
		this.signatureMechanical = signatureMechanical;
	}
	
	public Order() {
		
	}

	public long getId() {
		return id;
	}

	public Calendar getIssueData() {
		return issueData;
	}

	public void setIssueData(Calendar issueData) {
		this.issueData = issueData;
	}

	public Calendar getCompletionData() {
		return completionData;
	}

	public void setCompletionData(Calendar completionData) {
		this.completionData = completionData;
	}

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	public String getAnalysis() {
		return analysis;
	}

	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	public String getSignatureResponsible() {
		return signatureResponsible;
	}

	public void setSignatureResponsible(String signatureResponsible) {
		this.signatureResponsible = signatureResponsible;
	}

	public String getSignatureMechanical() {
		return signatureMechanical;
	}

	public void setSignatureMechanical(String signatureMechanical) {
		this.signatureMechanical = signatureMechanical;
	}
}
