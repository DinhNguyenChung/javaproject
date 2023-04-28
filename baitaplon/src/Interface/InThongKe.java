package Interface;

import java.sql.Date;
import java.util.ArrayList;


public interface InThongKe {
//	public ArrayList<ThongKe> getAllThongKe();
	public ArrayList<Object[]> getAllThongKe();
	
	public ArrayList<Object[]> getThongKeTheo2ngay(Date ngBD,Date ngayKT);
	public ArrayList<Object[]> getThongKeTheoNgayBD(Date ngBD);
	public ArrayList<Object[]> getThongKeTheoNgayKT(Date ngKT);
	
	
}
