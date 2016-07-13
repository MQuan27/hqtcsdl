package hcmuaf.edu.vn.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "VATTU")
public class VatTu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MAVT", unique = true, nullable = false)
	private int maVT;
	
	@Column(name = "TENVT")
	private String tenVT;
	
	@Column(name = "DVT")
	private String dVT;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.maVT", cascade=CascadeType.ALL)
	private Set<ChiTietXuatKho> cTXuatKho = new HashSet<ChiTietXuatKho>(0);
	
	public Set<ChiTietXuatKho> getcTXuatKho() {
		return cTXuatKho;
	}
	public void setcTXuatKho(Set<ChiTietXuatKho> cTXuatKho) {
		this.cTXuatKho = cTXuatKho;
	}
	public int getMaVT() {
		return maVT;
	}
	public void setMaVT(int maVT) {
		this.maVT = maVT;
	}
	public String getTenVT() {
		return tenVT;
	}
	public void setTenVT(String tenVT) {
		this.tenVT = tenVT;
	}
	public String getdVT() {
		return dVT;
	}
	public void setdVT(String dVT) {
		this.dVT = dVT;
	}
	
}
