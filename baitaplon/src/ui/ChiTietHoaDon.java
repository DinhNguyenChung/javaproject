package ui;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import bus.chitiethoadon_bus;
import bus.hoadon_bus;
import connectDB.ConnectDB;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChiTietHoaDon {

	public JFrame frame;
	private static hoadon_bus hd_bus;
	private static JTable table;
	private static DefaultTableModel model;
	private static chitiethoadon_bus cthd_bus;
	private static JTextField txtMaCTHD;
	private static JTextField txtMaHD;
	private static JTextField txtMaTour;
	private static JTextField txtSL;
	private static JTextField txtDG;
	private static JTextField txtTT;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChiTietHoaDon window = new ChiTietHoaDon();
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
	public ChiTietHoaDon() {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 1000, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);
		
		
		cthd_bus = new chitiethoadon_bus();
		hd_bus = new hoadon_bus();
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 11, 964, 83);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CHI TIẾT HÓA ĐƠN");
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 944, 64);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 105, 964, 545);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 91, 944, 411);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				txtMaCTHD.setText(model.getValueAt(row, 0).toString());
				txtMaHD.setText(model.getValueAt(row, 1).toString());
				txtMaTour.setText(model.getValueAt(row, 2).toString());
				txtSL.setText(model.getValueAt(row, 3).toString());
				txtDG.setText(model.getValueAt(row, 4).toString());
				txtTT.setText(model.getValueAt(row, 5).toString());
			}
		});
		table.setModel( model =new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 CTHD", "M\u00E3 H\u00F3a \u0110\u01A1n", "M\u00E3 Tour", "S\u1ED1 l\u01B0\u1EE3ng Kh\u00E1ch", "\u0110\u01A1n Gi\u00E1", "Th\u00E0nh Ti\u1EC1n"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("Mã CTHD");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(34, 11, 120, 14);
		panel_1.add(lblNewLabel_1);
		
		txtMaCTHD = new JTextField();
		txtMaCTHD.setHorizontalAlignment(SwingConstants.CENTER);
		txtMaCTHD.setBounds(34, 40, 120, 28);
		panel_1.add(txtMaCTHD);
		txtMaCTHD.setColumns(10);
		txtMaCTHD.setEditable(false);
		
		JButton btnXoa = new JButton("XÓA");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Xoa();
			}
		});
		btnXoa.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnXoa.setForeground(SystemColor.window);
		btnXoa.setBackground(SystemColor.textHighlight);
		btnXoa.setBounds(814, 11, 120, 30);
		panel_1.add(btnXoa);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mã Hóa Đơn");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(164, 11, 120, 14);
		panel_1.add(lblNewLabel_1_1);
		
		txtMaHD = new JTextField();
		txtMaHD.setHorizontalAlignment(SwingConstants.CENTER);
		txtMaHD.setColumns(10);
		txtMaHD.setBounds(164, 40, 120, 28);
		panel_1.add(txtMaHD);
		txtMaHD.setEditable(false);
		
		txtMaTour = new JTextField();
		txtMaTour.setHorizontalAlignment(SwingConstants.CENTER);
		txtMaTour.setColumns(10);
		txtMaTour.setBounds(294, 40, 120, 28);
		panel_1.add(txtMaTour);
		txtMaTour.setEditable(false);
		
		txtSL = new JTextField();
		txtSL.setHorizontalAlignment(SwingConstants.CENTER);
		txtSL.setColumns(10);
		txtSL.setBounds(424, 40, 120, 28);
		panel_1.add(txtSL);
		txtSL.setEditable(false);
		
		txtDG = new JTextField();
		txtDG.setHorizontalAlignment(SwingConstants.CENTER);
		txtDG.setColumns(10);
		txtDG.setBounds(554, 40, 120, 28);
		panel_1.add(txtDG);
		txtDG.setEditable(false);
		
		txtTT = new JTextField();
		txtTT.setHorizontalAlignment(SwingConstants.CENTER);
		txtTT.setColumns(10);
		txtTT.setBounds(684, 40, 120, 28);
		panel_1.add(txtTT);
		txtTT.setEditable(false);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Mã Tour");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setBounds(294, 11, 120, 14);
		panel_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Số lượng Khách");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setBounds(424, 11, 120, 14);
		panel_1.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Đơn Giá");
		lblNewLabel_1_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_3.setBounds(554, 11, 120, 14);
		panel_1.add(lblNewLabel_1_1_3);
		
		JLabel lblNewLabel_1_1_4 = new JLabel("Thành Tiền");
		lblNewLabel_1_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_4.setBounds(684, 11, 115, 14);
		panel_1.add(lblNewLabel_1_1_4);
		
		JButton btnThoat = new JButton("THOÁT");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DatTour dt = new DatTour();
				dt.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnThoat.setForeground(Color.WHITE);
		btnThoat.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnThoat.setBackground(Color.RED);
		btnThoat.setBounds(814, 50, 120, 30);
		panel_1.add(btnThoat);
		DocDuLieuTrenTable();
	}
	private static void DocDuLieuTrenTable() {
		ArrayList<entity.ChiTietHoaDon> list = cthd_bus.getAllCTHoaDon();
		for(entity.ChiTietHoaDon ct: list) {
			model.addRow(new Object[] {
					ct.getMaCTHD(),ct.getMaHD().getMaHD(),ct.getMaTour().getMaTour(),ct.getSoLuongKhach(),ct.getDonGia(),ct.getThanhTien()
			} );
		}
	}
	
	private static void Xoa() {
		try {
			int row = table.getSelectedRow();
			ArrayList<entity.ChiTietHoaDon> list = cthd_bus.getCTHoaDonTheoMaCTHD(model.getValueAt(row, 0).toString());
			
			int hoi = JOptionPane.showConfirmDialog(null,"Bạn có chắc Xóa Không ?","Chú Ý",JOptionPane.YES_NO_OPTION);
			if(hoi == JOptionPane.YES_NO_OPTION) {
				for(entity.ChiTietHoaDon ct : list ) {
					cthd_bus.delete(ct);
				}
				model.removeRow(row);
			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Vui lòng chọn bảng để Xóa");
		}
	}
	public void HienTableTheoMaHD(String ma) {
		ArrayList<entity.ChiTietHoaDon> list = cthd_bus.getCTHoaDonTheoMaHD(ma);
		for(entity.ChiTietHoaDon ct:list) {
			txtMaCTHD.setText(ct.getMaCTHD());
			txtMaHD.setText(ct.getMaHD().getMaHD());
			txtMaTour.setText(ct.getMaTour().getMaTour());
			txtSL.setText(String.valueOf(ct.getSoLuongKhach()));
			txtDG.setText(String.valueOf(ct.getDonGia()));
			txtTT.setText(String.valueOf(ct.getThanhTien()));
		}
	}
}
