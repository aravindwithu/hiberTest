package projects.wsaudit;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TestEntity 
{
	@Id
	private int keySet;
	private String valueSet;
	
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
}