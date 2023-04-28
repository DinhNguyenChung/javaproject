package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
//import javax.swing.border.EtcheSQLorder;
import javax.swing.JComboBox;
//import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.NumberFormatter;

import com.toedter.calendar.JDateChooser;

import bus.tour_bus;
import connectDB.ConnectDB;
import cre.ChiTietHoaDon_CRE;
import cre.HoaDon_CRE;
import cre.NhanVien_CRE;
import dao.*;
import entity.HoaDon;
import entity.ChiTietHoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.Tour;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
//import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Point;
import javax.swing.JTextField;
//import javax.swing.border.TitleSQLorder;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;
//import javax.swing.border.CompounSQLorder;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import java.awt.Button;

public class DatTour extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel modelDatTour;
	private JScrollPane pane;
	private JTextField txtTenNV;
	private JTextField txtTongTien;
	private JTextField txtTenKH;
	private JTextField txtMaHD;
	private JTextField txtSLKhach;
	private JTextField txtDiaChi;
	private JTextField txtGia;
	private JTextField txtTenTour;
	
	private KhachHang_DAO khdao;
	private NhanVien_DAO nvdao;
	private Tour_DAO tourdao;
	private Hoadon_DAO hoadondao;
	private ChiTietHoaDon_DAO cthoadondao;

	private HoaDon_CRE hdcre;
	private ChiTietHoaDon_CRE cthdcre;
	
	
	private ArrayList<KhachHang> listKH = new ArrayList<KhachHang>();
	private ArrayList<Tour> listTour = new ArrayList<Tour>();
	private ArrayList<NhanVien> listNV = new ArrayList<NhanVien>();
	private ArrayList<HoaDon> listHD = new ArrayList<HoaDon>();
	private ArrayList<ChiTietHoaDon> listCTHD = new ArrayList<ChiTietHoaDon>();
	private JTable table_1;
	private DefaultTableModel model;
	private JDateChooser cbNgayBan;
	private JComboBox cbMaKH;
	private JComboBox cbMaNV;
	private JTextField txtMess;
	private JComboBox cbMaTour;
	private ChiTietHoaDon_DAO CTHD_dao;
	private tour_bus tour_bus;
	

	

	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatTour frame = new DatTour();
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
	public DatTour() {
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(0, 204, 204));
		setTitle("ĐẶT TOUR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));https://www.youtube.com/watch?v=j6ij_wAOZzk
//		contentPane.setBorder(new TitleSQLorder(null, "", TitleSQLorder.LEADING, TitleSQLorder.TOP, null, null));
		
		setLocationRelativeTo(null);
		setUndecorated(true);
//Khởi tạo kết nối đến cơ sở dữ liệu:
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		khdao = new KhachHang_DAO();
		nvdao = new NhanVien_DAO();
		tourdao = new Tour_DAO();
		hoadondao = new Hoadon_DAO();
		cthoadondao = new ChiTietHoaDon_DAO();
		tour_bus = new tour_bus();
		hdcre = new HoaDon_CRE();
		cthdcre = new ChiTietHoaDon_CRE();
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
//		panel_1.setBorder(new EtcheSQLorder(EtcheSQLorder.LOWERED, null, null));
		panel_1.setBackground(SystemColor.menu);
		panel_1.setBounds(10, 76, 980, 614);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(SystemColor.textHighlight);
		panel_2.setBackground(Color.WHITE);
//		panel_2.setBorder(new EtcheSQLorder(EtcheSQLorder.LOWERED, null, null));
		panel_2.setBounds(10, 10, 596, 164);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblMaNV = new JLabel("Mã nhân viên");
		lblMaNV.setForeground(SystemColor.textHighlight);
		lblMaNV.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblMaNV.setBounds(10, 10, 138, 23);
		panel_2.add(lblMaNV);
		
		JLabel lblTenNV = new JLabel("Tên nhân viên");
		lblTenNV.setForeground(SystemColor.textHighlight);
		lblTenNV.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblTenNV.setBounds(10, 50, 97, 23);
		panel_2.add(lblTenNV);
		
		txtTenNV = new JTextField();
		txtTenNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		txtTenNV.setEnabled(false);
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(115, 50, 160, 25);
		panel_2.add(txtTenNV);
		
		cbMaKH = new JComboBox();
		cbMaKH.setFont(new Font("Segoe UI", Font.BOLD, 11));
		cbMaKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ma = (String) cbMaKH.getSelectedItem();
				ArrayList<KhachHang> listKH = khdao.getkhachhangTheoMaKH(ma);
				for(KhachHang kh : listKH) {
					txtTenKH.setText(kh.getTenKh());
					txtDiaChi.setText(kh.getDiachi());
				}
			}
		});
		cbMaKH.setToolTipText("");
		cbMaKH.setBounds(426, 10, 160, 25);
		panel_2.add(cbMaKH);
		
		//Đổ dữ liệu vào JComboBox MÃ KHÁCH HÀNG
		DefaultComboBoxModel<String> dataModelKH = new DefaultComboBoxModel<String>();
		dataModelKH.addElement("Chọn mã khách hàng");
		ArrayList<KhachHang> listKH = khdao.getallkhachhang();
		if(listKH != null) {
			for(KhachHang kh : listKH) {
				dataModelKH.addElement(kh.getMaKh());
			}
		}else {
			dataModelKH.addElement("Không có dữ liệu");
		}
		cbMaKH.setModel(dataModelKH);

		JLabel lblMaKH = new JLabel("Mã khách hàng");
		lblMaKH.setForeground(SystemColor.textHighlight);
		lblMaKH.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblMaKH.setBounds(315, 10, 104, 23);
		panel_2.add(lblMaKH);
		
		JLabel lblTenKH = new JLabel("Tên khách hàng");
		lblTenKH.setForeground(SystemColor.textHighlight);
		lblTenKH.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblTenKH.setBounds(315, 50, 110, 23);
		panel_2.add(lblTenKH);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ");
		lblDiaChi.setForeground(SystemColor.textHighlight);
		lblDiaChi.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblDiaChi.setBounds(315, 90, 132, 23);
		panel_2.add(lblDiaChi);
		
		JLabel lblSLKhach = new JLabel("Số lượng khách");
		lblSLKhach.setForeground(SystemColor.textHighlight);
		lblSLKhach.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblSLKhach.setBounds(315, 130, 110, 23);
		panel_2.add(lblSLKhach);
		
		
		cbMaNV = new JComboBox();
		cbMaNV.setFont(new Font("Segoe UI", Font.BOLD, 11));
		cbMaNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ma = (String) cbMaNV.getSelectedItem();
				listNV = nvdao.getNhanVienTheoMaNV(ma);
				for(NhanVien nv : listNV) {
					txtTenNV.setText(nv.getTenNV());
				}
			}
		});
		cbMaNV.setToolTipText("");
		cbMaNV.setBounds(115, 10, 160, 25);
		panel_2.add(cbMaNV);
		
		//Đổ dữ liệu vào JComboBox MÃ NHÂN VIÊN
		DefaultComboBoxModel<String> dataModelNV = new DefaultComboBoxModel<String>();
		dataModelNV.addElement("Chọn mã nhân viên");
		ArrayList<NhanVien> listNV = nvdao.getallNhanVien();
		if(listNV != null) {
			for(NhanVien nv : listNV) {
				dataModelNV.addElement(nv.getMaNV());
			}
		}else {
			dataModelKH.addElement("Không có dữ liệu");
		}
		cbMaNV.setModel(dataModelNV);
		
		txtTenKH = new JTextField();
//		txtTenKH.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtTenKH.setEnabled(false);
//		txtTenKH.setDisabledTextColor(SystemColor.controlText); // Đặt màu chữ thành màu xám
//		txtTenKH.setBackground(SystemColor.control);
		txtTenKH.setForeground(SystemColor.desktop);
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(426, 50, 160, 25);
	
		panel_2.add(txtTenKH);
		
		txtSLKhach = new JTextField();
		txtSLKhach.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				tinhTongTien();
			}
		});
		txtSLKhach.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					tinhTongTien();
				}
			}
		});
		txtSLKhach.setColumns(10);
		txtSLKhach.setBounds(426, 130, 160, 25);
		panel_2.add(txtSLKhach);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setEnabled(false);
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(426, 90, 160, 25);
		panel_2.add(txtDiaChi);
		
		cbNgayBan = new JDateChooser() ;
		cbNgayBan.setBounds(115, 128, 160, 25);
		panel_2.add(cbNgayBan);
		cbNgayBan.setBackground(new Color(255, 255, 255));
		cbNgayBan.setDate(new java.util.Date());
		cbNgayBan.setEnabled(false);
		cbNgayBan.setToolTipText("");
		
		JLabel lblNgayBan = new JLabel("Ngày lập");
		lblNgayBan.setBounds(10, 128, 104, 23);
		panel_2.add(lblNgayBan);
		lblNgayBan.setForeground(SystemColor.textHighlight);
		lblNgayBan.setFont(new Font("Segoe UI", Font.BOLD, 13));
		
		txtMaHD = new JTextField();
		txtMaHD.setBounds(115, 89, 160, 25);
		panel_2.add(txtMaHD);
		txtMaHD.setFont(new Font("Segoe UI", Font.BOLD, 10));
		txtMaHD.setBackground(new Color(255, 255, 255));
		txtMaHD.setEnabled(false);
		txtMaHD.setColumns(10);
		
		JLabel lblMaHD = new JLabel("Mã hóa đơn");
		lblMaHD.setBounds(10, 90, 91, 23);
		panel_2.add(lblMaHD);
		lblMaHD.setForeground(SystemColor.textHighlight);
		lblMaHD.setBackground(SystemColor.textHighlight);
		lblMaHD.setFont(new Font("Segoe UI", Font.BOLD, 13));
		
		JPanel panel_3 = new JPanel();
//		panel_3.setBorder(new EtcheSQLorder(EtcheSQLorder.LOWERED, null, null));
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(608, 10, 348, 164);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		cbMaTour = new JComboBox();
		cbMaTour.setFont(new Font("Segoe UI", Font.BOLD, 11));
		cbMaTour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ma = (String) cbMaTour.getSelectedItem();
				listTour = tourdao.getTourTheoMaTour(ma);
				for(Tour t : listTour) {
					txtTenTour.setText(t.getTenTour());
					txtGia.setText(Double.toString(t.getGiatien()));
					
				}
			}
		});
		cbMaTour.setToolTipText("");
		cbMaTour.setBounds(121, 10, 160, 25);
		panel_3.add(cbMaTour);

		//Đổ dữ liệu vào JComboBox MÃ TOUR
		DefaultComboBoxModel<String> dataModelTour = new DefaultComboBoxModel<String>();
		dataModelTour.addElement("Chọn mã tour");
		ArrayList<Tour> listTour = tourdao.getalltbTour();
		for(Tour t : listTour) {
			dataModelTour.addElement(t.getMaTour());
		}
		cbMaTour.setModel(dataModelTour);
		
		JLabel lblMaTour = new JLabel("Mã tour");
		lblMaTour.setForeground(SystemColor.textHighlight);
		lblMaTour.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblMaTour.setBounds(10, 10, 104, 23);
		panel_3.add(lblMaTour);
		
		JLabel lblTenTour = new JLabel("Tên tour");
		lblTenTour.setForeground(SystemColor.textHighlight);
		lblTenTour.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblTenTour.setBounds(10, 50, 110, 23);
		panel_3.add(lblTenTour);
		
		JLabel lblGia = new JLabel("Đơn giá");
		lblGia.setForeground(SystemColor.textHighlight);
		lblGia.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblGia.setBounds(10, 90, 132, 23);
		panel_3.add(lblGia);
		
		JLabel lblTongTien = new JLabel("Tổng tiền");
		lblTongTien.setForeground(SystemColor.textHighlight);
		lblTongTien.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblTongTien.setBounds(10, 130, 97, 23);
		panel_3.add(lblTongTien);

	
		txtTongTien = new JTextField();
		txtTongTien.setEnabled(false);
		txtTongTien.setColumns(10);
		txtTongTien.setBounds(121, 130, 160, 25);
		panel_3.add(txtTongTien);
		
		txtGia = new JTextField();
		txtGia.setEnabled(false);
		txtGia.setColumns(10);
		txtGia.setBounds(121, 91, 160, 25);
		panel_3.add(txtGia);
		
		txtTenTour = new JTextField();
		txtTenTour.setEnabled(false);
		txtTenTour.setColumns(10);
		txtTenTour.setBounds(121, 51, 160, 25);
		panel_3.add(txtTenTour);
		
		JPanel panel_5 = new JPanel();
//		panel_5.setBorder(new TitleSQLorder(new EtcheSQLorder(EtcheSQLorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "DANH S\u00C1CH H\u00D3A \u0110\u01A0N", TitleSQLorder.LEADING, TitleSQLorder.TOP, null, new Color(0, 0, 0)));
		panel_5.setBackground(SystemColor.menu);
		panel_5.setBounds(10, 238, 946, 362);
		panel_1.add(panel_5);
		panel_5.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 26, 926, 324);
		panel_5.add(scrollPane);
		
		table_1 = new JTable();
//		table_1.setBorder(new EtcheSQLorder(EtcheSQLorder.LOWERED, null, null));
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		table_1.setForeground(new Color(0, 0, 0));
		table_1.setBackground(SystemColor.window);
		table_1.setModel(model = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 h\u00F3a \u0111\u01A1n", "Ng\u00E0y l\u1EADp", "M\u00E3 kh\u00E1ch h\u00E0ng", "M\u00E3 nh\u00E2n vi\u00EAn", "T\u1ED5ng ti\u1EC1n"
			}
		));
		scrollPane.setViewportView(table_1);
		
		JButton btnThem = new JButton("ĐẶT TOUR");
		btnThem.setSelectedIcon(null);
		btnThem.setForeground(SystemColor.text);
		btnThem.setBackground(SystemColor.textHighlight);
		btnThem.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Kiểm tra biểu thức chính quy
				//Lấy dữ liệu từ JTextField,tạo 1 hóa đơn
				if(validData()) {
					HoaDon hd = getSelectedDataHDTable();
					ChiTietHoaDon cthd = getSelectedDataCTHDTable();
					//Lưu vào database
					int select = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn đặt tour?","Chú Ý",JOptionPane.YES_NO_OPTION);
					if(select == JOptionPane.YES_OPTION) {
						try {
							hoadondao.create(hd);
							cthoadondao.create(cthd);
							model.addRow(new Object[] {hd.getMaHD(), hd.getNgayLap(), hd.getKhachHang().getMaKh(), hd.getNhanVien().getMaNV(), hd.getTongTien()});
							txtMess.setText("");
							JOptionPane.showMessageDialog(null, "Đặt tour thành công!");
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "Đặt tour thất bại!");
							e2.printStackTrace();
						}
					}
				}
			}
		});
		btnThem.setBounds(618, 203, 100, 25);
		panel_1.add(btnThem);
		
		JButton btnThoat = new JButton("THOÁT");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int select = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn thoát?","Cảnh Báo",JOptionPane.YES_NO_OPTION);
				if(select == JOptionPane.YES_OPTION) {
					TrangChu tc = new TrangChu();
					tc.setVisible(true);
					dispose();
			}
		}
	});
		
		btnThoat.setForeground(new Color(255, 255, 255));
		btnThoat.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnThoat.setBackground(Color.RED);
		btnThoat.setBounds(856, 203, 100, 25);
		panel_1.add(btnThoat);
		
		JButton btnNewButton = new JButton("XEM HÓA ĐƠN CHI TIẾT");
		btnNewButton.setForeground(SystemColor.window);
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table_1.getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(null, "Bạn chưa chọn hóa đơn nào.");
                    return;
                }
                String maHoaDon = table_1.getValueAt(row, 0).toString();

                // Hiển thị hóa đơn chi tiết
                ui.ChiTietHoaDon ct = new ui.ChiTietHoaDon();
                ct.frame.setVisible(true);
                ct.HienTableTheoMaHD(maHoaDon);;
                setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnNewButton.setBounds(10, 203, 200, 25);
		panel_1.add(btnNewButton);
		
		txtMess = new JTextField();
		txtMess.setForeground(Color.RED);
		txtMess.setFont(new Font("Arial", Font.BOLD, 13));
		txtMess.setEditable(false);
		txtMess.setBorder(null);
		txtMess.setBounds(20, 175, 328, 18);
		panel_1.add(txtMess);
		txtMess.setColumns(10);
		
		JButton btnLamMoi = new JButton("LÀM MỚI");
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbMaNV.setSelectedIndex(0);
				txtTenNV.setText("");
				cbMaKH.setSelectedIndex(0);
				txtTenKH.setText("");
				txtDiaChi.setText("");
				txtSLKhach.setText("");
				cbMaTour.setSelectedIndex(0);
				txtTenTour.setText("");
				txtGia.setText("");
				txtTongTien.setText("");
				
				cbMaNV.requestDefaultFocus();
			}
		});
		btnLamMoi.setForeground(Color.WHITE);
		btnLamMoi.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnLamMoi.setBackground(SystemColor.textHighlight);
		btnLamMoi.setBounds(738, 203, 100, 25);
		panel_1.add(btnLamMoi);
		
		JLabel lblNewLabel = new JLabel("ĐẶT TOUR");
		lblNewLabel.setBackground(new Color(0, 120, 215));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 35));
		lblNewLabel.setBounds(10, 0, 966, 78);
		contentPane.add(lblNewLabel);
		
		DocDuLieuTuSQLVaoTable();
		
	}


	protected HoaDon getSelectedDataHDTable() {
		String maHD = getMaHD();
		java.sql.Date ngayLap=  new java.sql.Date(cbNgayBan.getDate().getTime());
		String maKH = (String) cbMaKH.getSelectedItem();
		KhachHang kh = new KhachHang(maKH);
		String maNV = (String) cbMaNV.getSelectedItem();
		NhanVien nv = new NhanVien(maNV);
		double tongTien = Double.parseDouble(txtTongTien.getText());
		HoaDon hd = new HoaDon(maHD, ngayLap, kh, nv, tongTien);
		return hd;
	}
	
	protected ChiTietHoaDon getSelectedDataCTHDTable() {
		String maCTHD = getMaCTHD();
		String maHD = getMaHD();
		HoaDon hd = new HoaDon(maHD);
		String maTour = (String) cbMaTour.getSelectedItem();
		Tour t = new Tour(maTour);
		int soLuongKhach = Integer.parseInt(txtSLKhach.getText());
		double donGia = Double.parseDouble(txtGia.getText());
		double thanhTien = Double.parseDouble(txtTongTien.getText());
		
		ChiTietHoaDon cthd = new ChiTietHoaDon(maCTHD, hd, t, soLuongKhach, donGia, thanhTien);
		return cthd;
	}
	
	

	protected boolean validData() {
		String sl = txtSLKhach.getText().trim();
		if(!isJComboBoxNotEmpty(cbMaNV)) {
			showMessageCB("Vui lòng chọn mã nhân viên!", cbMaNV);
			return false;
		}
		
		if(!isJComboBoxNotEmpty(cbMaKH)) {
			showMessageCB("Vui lòng chọn mã khách hàng!", cbMaKH);
			return false;
		}
		
		
		
		if(!isJComboBoxNotEmpty(cbMaTour)) {
			showMessageCB("Vui lòng chọn mã tour!", cbMaTour);
			return false;
		}
		
		if(sl.length() > 0) {
			try {
				int SL = Integer.parseInt(sl);
				if(SL < 0 || SL > 30) {
					showMessageTXT("Số lượng khách từ 1-30", txtSLKhach);
					return false;
				}
				else {
					List<Tour> list = tour_bus.getTourTheoMaTour(cbMaTour.getSelectedItem().toString());
					int slt = 0;
					for(Tour tour: list) {
						slt =tour.getSoluong() - getSLTTour(tour.getMaTour());
				}
					if(SL >slt) {
//						JOptionPane.showMessageDialog(null, "Hiện tại Tour này chỉ còn "+slt+" Vé");
						txtMess.setText("Hiện tại Tour này chỉ còn "+slt+" Vé");
						return false;
					}
				}
					
			}catch (NumberFormatException e) {
				// TODO: handle exception
				showMessageTXT("Số lượng khách phải là số nguyên dương, txtSLKhach",txtSLKhach);
				return false;
			}
		}else {
			showMessageTXT("Vui lòng nhập số lượng khách sẽ tham gia tour", txtSLKhach);
			return false;
		}
		return true;
	}
	
	public boolean isJComboBoxNotEmpty(JComboBox comboBox) {
		 return comboBox.getSelectedIndex() != 0;
	}

	private void DocDuLieuTuSQLVaoTable() {
		// TODO Auto-generated method stub
		ArrayList<HoaDon> listHD = hoadondao.getAllHoaDon();
		for(HoaDon hd : listHD) {
			model.addRow(new Object[] {hd.getMaHD(), hd.getNgayLap(), hd.getKhachHang().getMaKh(), hd.getNhanVien().getMaNV(), hd.getTongTien()});
		}
		
	}

	private void tinhTongTien() {
		// TODO Auto-generated method stub
		try {
			int sl = Integer.parseInt(txtSLKhach.getText());
			if(sl > 0) {
				double donGia = Double.parseDouble(txtGia.getText());
				double tongTien = donGia * sl;
				txtTongTien.setText(String.valueOf(tongTien));
			}
			else {
				showMessageTXT("Số lượng khách không hợp lệ", txtSLKhach);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	private void showMessageCB(String message, JComboBox cb) {
		cb.requestFocus();
		txtMess.setText(message);
	}
	
	private  void showMessageTXT(String message, JTextField txt) {
		txt.requestFocus();
		txtMess.setText(message);
	}
	private String getMaHD() {
		int maCuoi = Integer.parseInt(hdcre.getfivemacuoiHD());
		String maHD = "HD";
		String maCuoiHD = String.valueOf(maCuoi+1);
		int numZero = 3 - maCuoiHD.length();
		for (int i = 0; i < numZero; i++)
		{
			maHD += "0";
		}
		maHD += maCuoiHD;
		return maHD; 
	}
	
	private String getMaCTHD() {
		int maCuoi = Integer.parseInt(cthdcre.getfivemacuoiCTHD());
		String maCTHD = "CTHD";
		String maCuoiCTHD = String.valueOf(maCuoi+1);
		int numZero = 3 - maCuoiCTHD.length();
		for (int i = 0; i < numZero; i++)
		{
			maCTHD += "0";
		}
		maCTHD += maCuoiCTHD;
		return maCTHD; 
	}
	public boolean getMaTourInTrangChu(String maTour) {
		ArrayList<Tour> listTour = tourdao.getalltbTour();
		if(listTour != null) {
			for(Tour t : listTour) {
				//dataModelNV.addElement(nv.getMaNV());
				if(t.getMaTour().equals(maTour)) {
					cbMaTour.setSelectedItem(t.getMaTour());
					return true;
				}
			}
		}
		return false;
	}
	public int getSLTTour(String ma) {
		CTHD_dao = new ChiTietHoaDon_DAO();
		return CTHD_dao.SLTourdadat(ma);
	
	}
}
