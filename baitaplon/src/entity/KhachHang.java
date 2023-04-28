package entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class KhachHang implements Serializable {
	private String maKh;
	private String tenKh;
	private Date ngsinh;
	private String diachi;
	private String sdt;
	private String email;
	private String cmnd;
//	private Tour maTour ;
	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KhachHang(String maKH) {
		this(maKH,"",null,"","","","");
	}
	public KhachHang(String maKh, String tenKh, java.util.Date ngaysinh, String diachi, String sdt, String email, String cmnd) {
		super();
		this.maKh = maKh;
		this.tenKh = tenKh;
		this.ngsinh =  (java.sql.Date)ngaysinh;
		this.diachi = diachi;
		this.sdt = sdt;
		this.email = email;
		this.cmnd = cmnd;
//		this.maTour = maTour;
	}
	public String getMaKh() {
		return maKh;
	}
	public void setMaKh(String maKh) {
		this.maKh = maKh;
	}
	public String getTenKh() {
		return tenKh;
	}
	public void setTenKh(String tenKh) {
		this.tenKh = tenKh;
	}
	public Date getNgsinh() {
		return ngsinh;
	}
	public void setNgsinh(Date ngsinh) {
		this.ngsinh = ngsinh;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCmnd() {
		return cmnd;
	}
	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}
//	public Tour getMaTour() {
//		return maTour;
//	}
//	public void setMaTour(Tour maTour) {
//		this.maTour = maTour;
//	}
	@Override
	public int hashCode() {
		return Objects.hash(maKh);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		return Objects.equals(maKh, other.maKh);
	}
	@Override
	public String toString() {
		return  maKh + ";" + tenKh + ";" + ngsinh + ";" + diachi + ";"
				+ sdt + ";" + email + ";" + cmnd;
	}
	
	
}
