package hcmuaf.edu.vn.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CONGTRINH")
public class CongTrinh {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MACT", unique = true, nullable = false)
	private int maCT;

	@Column(name = "TENCT")
	private String tenCT;

	@Column(name = "DCCT")
	private String diaChiCT;

	public int getMaCT() {
		return maCT;
	}

	public void setMaCT(int maCT) {
		this.maCT = maCT;
	}

	public String getTenCT() {
		return tenCT;
	}

	public void setTenCT(String tenCT) {
		this.tenCT = tenCT;
	}

	public String getDiaChiCT() {
		return diaChiCT;
	}

	public void setDiaChiCT(String diaChiCT) {
		this.diaChiCT = diaChiCT;
	}

}
