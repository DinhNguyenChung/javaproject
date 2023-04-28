package bus;

import java.sql.Date;

import java.util.ArrayList;

import Interface.InThongKe;
import dao.ThongKe_DAO;
public class thongke_bus implements InThongKe {
	ThongKe_DAO tk_dao = new ThongKe_DAO();
//	@Override
//	public ArrayList<ThongKe> getAllThongKe() {
//		// TODO Auto-generated method stub
//		return tk_dao.getAllThongKe();
//	}
	@Override
	public ArrayList<Object[]> getThongKeTheo2ngay(Date ngBD, Date ngayKT) {
		// TODO Auto-generated method stub
		return tk_dao.getThongKeTheo2ngay(ngBD, ngayKT);
	}
	@Override
	public ArrayList<Object[]> getThongKeTheoNgayBD(Date ngBD) {
		// TODO Auto-generated method stub
		return tk_dao.getThongKeTheoNgayBD(ngBD);
	}
	@Override
	public ArrayList<Object[]> getThongKeTheoNgayKT(Date ngKT) {
		// TODO Auto-generated method stub
		return tk_dao.getThongKeTheoNgayKT(ngKT);
	}
	@Override
	public ArrayList<Object[]> getAllThongKe() {
		// TODO Auto-generated method stub
		return tk_dao.getAllThongKe();
	}

}
