package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import bus.thongke_bus;
import connectDB.ConnectDB;
import dao.ThongKe_DAO;

import javax.swing.JButton;
import java.awt.SystemColor;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class ThongKe {

	public JFrame frame;
	private static JTable table;
	private static JTextField txtDT;
	private static JDateChooser dateBD;
	private static JDateChooser dateKT;
	private static ThongKe_DAO tk_dao;
	private static DefaultTableModel model;
	private static thongke_bus tk_bus;
	private static Date ngayBD;
	private static Date ngayKT;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThongKe window = new ThongKe();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ThongKe() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(true);
		tk_bus = new thongke_bus();
		tk_dao = new ThongKe_DAO();
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaptionBorder);
		panel.setBounds(10, 11, 964, 81);
		frame.getContentPane().add(panel);
		frame.setLocationRelativeTo(null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("THỐNG KÊ DOANH THU");
		lblNewLabel.setBackground(SystemColor.scrollbar);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 944, 56);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaptionBorder);
		panel_1.setBounds(10, 103, 964, 547);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 11, 944, 89);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Thống Kê Từ Ngày:");
		lblNewLabel_1.setBounds(10, 37, 108, 25);
		panel_2.add(lblNewLabel_1);
		
		 dateBD = new JDateChooser();
		 dateBD.addPropertyChangeListener(new PropertyChangeListener() {
		 	public void propertyChange(PropertyChangeEvent evt) {
		 		Tim();
		 	}
		 });
		dateBD.setBounds(123, 37, 123, 25);
		panel_2.add(dateBD);
		
		JLabel lblNewLabel_1_1 = new JLabel("Thống Kê Đến Ngày:");
		lblNewLabel_1_1.setBounds(267, 37, 123, 25);
		panel_2.add(lblNewLabel_1_1);
		
		 dateKT = new JDateChooser();
		 dateKT.addPropertyChangeListener(new PropertyChangeListener() {
		 	public void propertyChange(PropertyChangeEvent evt) {
		 		Tim();
		 	}
		 });
		dateKT.setBounds(394, 37, 123, 25);
		panel_2.add(dateKT);
		
		txtDT = new JTextField();
		txtDT.setHorizontalAlignment(SwingConstants.CENTER);
		txtDT.setBounds(672, 16, 149, 67);
		panel_2.add(txtDT);
		
		txtDT.setColumns(10);
		txtDT.setEditable(false);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Doanh Thu");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(570, 16, 92, 62);
		panel_2.add(lblNewLabel_2);
		
		JButton btnThoat = new JButton("THOÁT");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				TrangChu tc = new TrangChu();
//				tc.setVisible(true);
				HoaDon hd = new HoaDon();
				hd.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnThoat.setBackground(Color.RED);
		btnThoat.setForeground(SystemColor.window);
		btnThoat.setBounds(845, 55, 89, 28);
		panel_2.add(btnThoat);
		
		JButton btnDS = new JButton("LÀM MỚI");
		btnDS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				XoaDuLieutrenModel();
//				DocDuLieu();
				dateBD.setDate(null);
				dateKT.setDate(null);
			}
		});
		btnDS.setBackground(SystemColor.textHighlight);
		btnDS.setForeground(SystemColor.window);
		btnDS.setBounds(845, 16, 89, 28);
		panel_2.add(btnDS);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 125, 944, 396);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 924, 374);
		panel_3.add(scrollPane);
		
		table = new JTable();
		table.setModel(model =new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"T\u00EAn Tour", "S\u1ED1 L\u1EA7n \u0110\u1EB7t", "SLKH \u0111\u00E3 \u0111i", "Gi\u00E1 Tour", "T\u1ED5ng Ti\u1EC1n"
			}
		));
		scrollPane.setViewportView(table);
		DocDuLieu();
	}
	
	private static void DocDuLieu() {
		ArrayList<entity.ThongKe> list = tk_bus.getAllThongKe();
		for(entity.ThongKe tk:list) {
			model.addRow(new Object[] {tk.getTentour(),tk.getSolandat(),tk.getSolandi(),tk.getGiatour(),tk.getTongtien()});
		}
	}
	private static void XoaDuLieutrenModel() {
		DefaultTableModel dm = (DefaultTableModel) table.getModel();
		dm.getDataVector().removeAllElements();
	}
	private static double getTong() {
		double sum=0;

		
		 try {
			 ngayBD = new java.sql.Date(dateBD.getDate().getTime());
			 ngayKT = new java.sql.Date(dateKT.getDate().getTime());
		} catch (Exception e) {
			// TODO: handle exception
			ngayBD=null;
			ngayKT=null;
		}
		
		if(ngayBD==null && ngayKT ==null) {
			ArrayList<entity.ThongKe> list = tk_bus.getAllThongKe();
			for(entity.ThongKe tk:list) {
				sum+=tk.getTongtien();
			}
		}
		if(ngayBD!=null && ngayKT !=null) {
			
			 ArrayList<entity.ThongKe> list = tk_bus.getThongKeTheo2ngay(ngayBD, ngayKT);
			for(entity.ThongKe tk:list) {
				sum+=tk.getTongtien();
			}
		}
		if(ngayBD!=null && ngayKT ==null) {
			XoaDuLieutrenModel();
			 ArrayList<entity.ThongKe>list = tk_bus.getThongKeTheoNgayBD(ngayBD);
			for(entity.ThongKe tk:list) {
				sum+=tk.getTongtien();
			}
		}
		if(ngayBD==null && ngayKT !=null) {
			
			 ArrayList<entity.ThongKe> list = tk_bus.getThongKeTheoNgayKT(ngayKT);
			for(entity.ThongKe tk:list) {
				sum+=tk.getTongtien();
			}
		}
		return sum;
	}
	
	private static void Tim() {
		try {
			txtDT.setText(String.valueOf(getTong()));
			 try {
				 ngayBD = new java.sql.Date(dateBD.getDate().getTime());
				 ngayKT = new java.sql.Date(dateKT.getDate().getTime());
			} catch (Exception e) {
				// TODO: handle exception
				ngayBD=null;
				ngayKT=null;
			}
			 ArrayList<entity.ThongKe> list = new ArrayList<>();
			
			if(ngayBD==null && ngayKT ==null) {
				XoaDuLieutrenModel();
				DocDuLieu();
			}
			if(ngayBD!=null && ngayKT !=null) {
				XoaDuLieutrenModel();
				 list = tk_bus.getThongKeTheo2ngay(ngayBD, ngayKT);
				for(entity.ThongKe tk:list) {
					model.addRow(new Object[] {tk.getTentour(),tk.getSolandat(),tk.getSolandi(),tk.getGiatour(),tk.getTongtien()});
				}
			}
			if(ngayBD!=null && ngayKT ==null) {
				XoaDuLieutrenModel();
				 list = tk_bus.getThongKeTheoNgayBD(ngayBD);
				for(entity.ThongKe tk:list) {
					model.addRow(new Object[] {tk.getTentour(),tk.getSolandat(),tk.getSolandi(),tk.getGiatour(),tk.getTongtien()});
				}
			}
			if(ngayBD==null && ngayKT !=null) {
				XoaDuLieutrenModel();
				list = tk_bus.getThongKeTheoNgayKT(ngayKT);
				for(entity.ThongKe tk:list) {
					model.addRow(new Object[] {tk.getTentour(),tk.getSolandat(),tk.getSolandi(),tk.getGiatour(),tk.getTongtien()});
				}
			}
			if(list ==null) {
				JOptionPane.showMessageDialog(null, "Không hóa đơn nào ngày này !");
			}
		} catch (Exception e) {
			// TODO: handle exception
			
		}
	}
}
