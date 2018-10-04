package projects.wsaudit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.sql.Timestamp;

@Entity
public class TestEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "keySet", updatable=false, nullable = false)
	private int keySet;
	private String valueSet;
	private String description;
	private Timestamp t1;
	
	public int getKeySet() {
		return keySet;
	}
	public void setKeySet(int keySet) {
		this.keySet = keySet;
	}
	public String getValueSet() {
		return valueSet;
	}
	public void setValueSet(String valueSet) {
		this.valueSet = valueSet;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Timestamp getT1() {
		return t1;
	}
	public void setT1(Timestamp t1) {
		this.t1 = t1;
	}
}