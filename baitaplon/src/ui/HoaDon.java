package ui;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import bus.hoadon_bus;
import connectDB.ConnectDB;

import entity.KhachHang;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HoaDon extends JFrame {

	private JPanel contentPane;
	private static JTextField txtMaHD;
	private static JTextField txtMaKH;
	private static JTextField txtMaNV;
	private static JTextField txtTongTien;
	private static JTextField txtNgay;

	private com.toedter.calendar.JDateChooser date_NgayHD;
	private static JTable table;
	private  static DefaultTableModel model;
	private static hoadon_bus hd_bus;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HoaDon frame = new HoaDon();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HoaDon() {
		
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		hd_bus = new hoadon_bus();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setBounds(EXIT_ON_CLOSE, ABORT, 1000, 700);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 10, 980, 80);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("HÓA ĐƠN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(10, 10, 960, 60);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "TH\u00D4NG TIN H\u00D3A \u0110\u01A0N", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 100, 980, 143);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblMaHD = new JLabel("Mã hóa đơn :");
		lblMaHD.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaHD.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMaHD.setBounds(10, 22, 120, 25);
		panel_1.add(lblMaHD);
		
		JLabel lblMaKH = new JLabel("Mã khách hàng :");
		lblMaKH.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaKH.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMaKH.setBounds(173, 22, 121, 25);
		panel_1.add(lblMaKH);
		
		JLabel lblMaTour = new JLabel("Mã Nhân Viên");
		lblMaTour.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaTour.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMaTour.setBounds(349, 22, 120, 25);
		panel_1.add(lblMaTour);
		
		JLabel lblNgay = new JLabel("Ngày :");
		lblNgay.setHorizontalAlignment(SwingConstants.CENTER);
		lblNgay.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNgay.setBounds(518, 22, 105, 25);
		panel_1.add(lblNgay);
		
		JLabel lblGiaHD = new JLabel("Tổng Tiền:");
		lblGiaHD.setHorizontalAlignment(SwingConstants.CENTER);
		lblGiaHD.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGiaHD.setBounds(651, 22, 105, 25);
		panel_1.add(lblGiaHD);
		
		txtMaHD = new JTextField();
		txtMaHD.setBounds(10, 57, 120, 25);
		panel_1.add(txtMaHD);
		txtMaHD.setColumns(10);
		txtMaHD.setEditable(false);
		
		txtMaKH = new JTextField();
		txtMaKH.setColumns(10);
		txtMaKH.setBounds(173, 57, 121, 25);
		panel_1.add(txtMaKH);
		txtMaKH.setEditable(false);
		
		txtMaNV = new JTextField();
		txtMaNV.setColumns(10);
		txtMaNV.setBounds(349, 57, 120, 25);
		panel_1.add(txtMaNV);
		txtMaNV.setEditable(false);
		
		txtTongTien = new JTextField();
		txtTongTien.setColumns(10);
		txtTongTien.setBounds(651, 57, 120, 25);
		panel_1.add(txtTongTien);
		txtTongTien.setEditable(false);
		
		date_NgayHD = new JDateChooser();
		date_NgayHD.setBounds(518, 57, 123, 25);
		panel_1.add(date_NgayHD);
		date_NgayHD.setEnabled(false);
		
		JButton btnThem = new JButton("THÊM");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DatTour dt = new DatTour();
				dt.setVisible(true);
				setVisible(false);
			}
		});
		btnThem.setForeground(SystemColor.window);
		btnThem.setBackground(SystemColor.textHighlight);
		btnThem.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnThem.setBounds(550, 103, 120, 30);
		panel_1.add(btnThem);
		
		JButton btnXoaRong = new JButton("Xóa rỗng");
		btnXoaRong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMaHD.setText("");
				txtMaKH.setText("");
				txtMaNV.setText("");
				date_NgayHD.setDate(null);
				txtTongTien.setText("");
			}
		});
		btnXoaRong.setBackground(SystemColor.textHighlight);
		btnXoaRong.setForeground(SystemColor.window);
		btnXoaRong.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXoaRong.setBounds(680, 102, 120, 30);
		panel_1.add(btnXoaRong);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.setForeground(SystemColor.window);
		btnThoat.setBackground(Color.RED);
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrangChu tc = new TrangChu();
				tc.setVisible(true);
				setVisible(false);
			}
		});
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThoat.setBounds(810, 102, 139, 30);
		panel_1.add(btnThoat);
		
		JButton btnNewButton_1 = new JButton("THỐNG KÊ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThongKe tk = new ThongKe();
				tk.frame.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnNewButton_1.setBackground(SystemColor.textHighlight);
		btnNewButton_1.setBounds(810, 22, 139, 42);
		panel_1.add(btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "DANH S\u00C1CH H\u00D3A \u0110\u01A0N", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 253, 980, 400);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 23, 960, 366);
		panel_2.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				txtMaHD.setText(model.getValueAt(row, 0).toString());
				txtMaKH.setText(model.getValueAt(row, 2).toString());
				txtMaNV.setText(model.getValueAt(row, 3).toString());
				date_NgayHD.setDate((Date)model.getValueAt(row, 1));
				txtTongTien.setText(model.getValueAt(row, 4).toString());
			}
		});
		table.setModel(model= new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 H\u00F3a \u0110\u01A1n", "Ng\u00E0y L\u1EADp H\u00F3a \u0110\u01A1n", "M\u00E3 Kh\u00E1ch H\u00E0ng", "M\u00E3 Nh\u00E2n Vi\u00EAn", "T\u1ED5ng Ti\u1EC1n"
			}
		));
		table.getColumnModel().getColumn(4).setPreferredWidth(80);
		scrollPane.setViewportView(table);
		DocDuLieuTrentable();
	}
//	private int getSLTourdadat(String maTour) {
//		List<HoaDon> list = hd_bus.getallkhachhang();
//		for(HoaDon kh:list) {
////			modelkhachhang.addRow(new Object[] {kh.getMaKh(),kh.getTenKh(),kh.getNgsinh(),kh.getDiachi(),kh.getSdt(),kh.getEmail(),kh.getCmnd()});
//			if(kh.getMaKh().equals(maTour)) count++;
//		}
//	}
	
	private static void DocDuLieuTrentable() {
		ArrayList<entity.HoaDon> listHD = hd_bus.getAllHoaDon();
			for(entity.HoaDon hd : listHD) {
			model.addRow(new Object[] {hd.getMaHD(), hd.getNgayLap(), hd.getKhachHang().getMaKh(), hd.getNhanVien().getMaNV(), hd.getTongTien()});
		}
		
	}
}
