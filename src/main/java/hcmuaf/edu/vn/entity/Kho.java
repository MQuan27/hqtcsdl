package hcmuaf.edu.vn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "KHO")
public class Kho {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MAKHO", unique = true, nullable = false)
	private int maKho;
	
	@Column(name = "TENKHO")
	private String tenKho;
	
	@Column(name = "DCKHO")
	private String diaChiKho;
	
	@Column(name = "SLTON")
	private int sLTon;
	
	@Column(name = "TGTON")
	private int tGTon;
	
	public int getMaKho() {
		return maKho;
	}

	public void setMaKho(int maKho) {
		this.maKho = maKho;
	}

	public String getTenKho() {
		return tenKho;
	}

	public void setTenKho(String tenKho) {
		this.tenKho = tenKho;
	}

	public String getDiaChiKho() {
		return diaChiKho;
	}

	public void setDiaChiKho(String diaChiKho) {
		this.diaChiKho = diaChiKho;
	}

	public int getsLTon() {
		return sLTon;
	}

	public void setsLTon(int sLTon) {
		this.sLTon = sLTon;
	}

	public int gettGTon() {
		return tGTon;
	}

	public void settGTon(int tGTon) {
		this.tGTon = tGTon;
	}
}
