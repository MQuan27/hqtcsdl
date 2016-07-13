package hcmuaf.edu.vn.entity;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "CT_XUATKHO")
@AssociationOverrides({ @AssociationOverride(name = "pk.maVT", joinColumns = @JoinColumn(name = "MAVT")),
		@AssociationOverride(name = "pk.soPX", joinColumns = @JoinColumn(name = "SOPX")) })
public class ChiTietXuatKho {

	private ChiTietXuatKhoPK pk = new ChiTietXuatKhoPK();
	
	@Column(name = "SOLG")
	private int soLg;
	
	@Column(name = "DONGIA")
	private double donGia;

	@EmbeddedId
	public ChiTietXuatKhoPK getPk() {
		return pk;
	}

	public void setPk(ChiTietXuatKhoPK pk) {
		this.pk = pk;
	}

	@Transient
	public VatTu getVatTu() {
		return getPk().getMaVT();
	}

	public void setVatTu(VatTu vatTu) {
		getPk().setMaVT(vatTu);
	}

	@Transient
	public XuatKho getXuatKho() {
		return getPk().getSoPX();
	}

	public void setXuatKho(XuatKho category) {
		getPk().setSoPX(category);
	}

	public int getSoLg() {
		return soLg;
	}

	public void setSoLg(int soLg) {
		this.soLg = soLg;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pk == null) ? 0 : pk.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietXuatKho other = (ChiTietXuatKho) obj;
		if (pk == null) {
			if (other.pk != null)
				return false;
		} else if (!pk.equals(other.pk))
			return false;
		return true;
	}

}
