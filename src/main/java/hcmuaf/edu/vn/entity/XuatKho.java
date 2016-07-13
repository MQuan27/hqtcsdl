package hcmuaf.edu.vn.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "XUATKHO")
public class XuatKho {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SOPX", unique = true, nullable = false)
	private int soPX;
	
	@Column(name = "NGAYXUAT")
	private Date ngayXuat;
	
    @OneToOne(cascade=CascadeType.ALL)  
    @JoinColumn(name="MACT")
	private CongTrinh maCT;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.soPX", cascade=CascadeType.ALL)
	private Set<ChiTietXuatKho> cTXuatKho = new HashSet<ChiTietXuatKho>(0);

	public int getSoPX() {
		return soPX;
	}

	public void setSoPX(int soPX) {
		this.soPX = soPX;
	}

	public Date getNgayXuat() {
		return ngayXuat;
	}

	public void setNgayXuat(Date ngayXuat) {
		this.ngayXuat = ngayXuat;
	}

	public CongTrinh getMaCT() {
		return maCT;
	}

	public void setMaCT(CongTrinh maCT) {
		this.maCT = maCT;
	}

	public Set<ChiTietXuatKho> getcTXuatKho() {
		return cTXuatKho;
	}

	public void setcTXuatKho(Set<ChiTietXuatKho> cTXuatKho) {
		this.cTXuatKho = cTXuatKho;
	}

}
