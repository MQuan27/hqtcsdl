package hcmuaf.edu.vn.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class ChiTietXuatKhoPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private VatTu maVT;
	private XuatKho soPX;

	@ManyToOne
	public VatTu getMaVT() {
		return maVT;
	}

	public void setMaVT(VatTu maVT) {
		this.maVT = maVT;
	}

	@ManyToOne
	public XuatKho getSoPX() {
		return soPX;
	}

	public void setSoPX(XuatKho soPX) {
		this.soPX = soPX;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maVT == null) ? 0 : maVT.hashCode());
		result = prime * result + ((soPX == null) ? 0 : soPX.hashCode());
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
		ChiTietXuatKhoPK other = (ChiTietXuatKhoPK) obj;
		if (maVT == null) {
			if (other.maVT != null)
				return false;
		} else if (!maVT.equals(other.maVT))
			return false;
		if (soPX == null) {
			if (other.soPX != null)
				return false;
		} else if (!soPX.equals(other.soPX))
			return false;
		return true;
	}

}
