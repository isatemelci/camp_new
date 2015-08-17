package tr.org.lkd.lyk2015.camp.models;

import javax.persistence.Entity;

@Entity
public class Admin extends AbstractUser {

	private Integer lkdNo;

	public Integer getLkdNo() {
		return lkdNo;
	}

	public void setLkdNo(Integer lkdNo) {
		this.lkdNo = lkdNo;
	}

}
