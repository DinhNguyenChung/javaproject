CREATE database QLTTTour

go
USE  QLTTTour
go

CREATE TABLE Tour(
	maTour VARCHAR(10) primary key,
	tenTour NVARCHAR(30) NULL,
	diaDiemDen NVARCHAR(50) NULL,
	ngayKhoiHanh date NULL,
	ngayKetThuc date NULL,
	giaTour MONEY null,
	soLuongKhach int NULL,
);


CREATE TABLE KhachHang(
   maKH  VARCHAR (10) primary key,
   tenKH NVARCHAR (50) NULL, 
   ngaySinh date  null,
   diaChi NVARCHAR(50) null,
   sdt varchar(12)  null,
   email VARCHAR(50) NULL,
   cmnd VARCHAR (12)  NULL,
);

CREATE TABLE NhanVien(
   maNV  VARCHAR (10) primary key,
   tenNV NVARCHAR (50) NULL, 
   ngaySinh date  null,
   diaChi NVARCHAR(50) null,
   sdt varchar(12)  null,
   email VARCHAR(50) NULL,
   cmnd VARCHAR (12)  NULL,
);


CREATE TABLE HoaDon(
	maHD VARCHAR(10) primary key,
	ngayLap date null,
	maKH VARCHAR (10) null,
	Constraint F_KH_HD Foreign key(maKH) references KhachHang(maKH),
	maNV VARCHAR (10) null,
	Constraint F_NV_HD Foreign key(maNV) references NhanVien(maNV),
	tongTien money null,
);

CREATE TABLE ChiTietHoaDon(
	maCTHD VARCHAR(10) primary key,
	maHD VARCHAR (10) null,
	Constraint F_HD_CTHD Foreign key(maHD) references HoaDon(maHD),
	maTour VARCHAR (10) null,
	Constraint F_T_CTHD Foreign key(maTour) references Tour(maTour),
	soLuongKhach int null,
	donGia money null,
	thanhTien money null,
);


INSERT Tour([maTour], [tenTour],[diaDiemDen],[ngayKhoiHanh],[ngayKetThuc],[giaTour],[soLuongKhach]) 
VALUES ('MT001', N'Tour Đà Lạt',N'Lâm Đồng','2023-04-30','2023-05-02',3000000,35)

INSERT Tour([maTour], [tenTour],[diadiemden],[ngayKhoihanh],[ngayketthuc],[giaTour],[soLuongKhach]) 
VALUES ('MT002', N'Tour Hà Giang',N'Hà Giang','2023-05-1','2023-05-03',5000000,30)

INSERT KhachHang([maKH],[tenKH],[ngaySinh],[diaChi],[sdt],[email],[cmnd])
VALUES ('KH001',N'Nguyễn Văn Nam','2000-02-02',N'Hà Nội','0334657483','nam@gmail.com','223344551')

INSERT KhachHang([maKH],[tenKH],[ngaySinh],[diaChi],[sdt],[email],[cmnd])
VALUES ('KH002',N'Nguyễn Thị Minh','2003-04-24',N'Kiên Giang','0331157483','minh@gmail.com','211674551')

INSERT NhanVien([maNV],[tenNV],[ngaySinh],[diaChi],[sdt],[email],[cmnd])
Values ('NV001',N'Nguyễn Văn Xuân','2000-04-20',N'Ninh Bình','0334756454','xuan@gmail.com','123543254342')
INSERT NhanVien([maNV],[tenNV],[ngaySinh],[diaChi],[sdt],[email],[cmnd])
Values ('NV002',N'Nguyễn Thị Ánh','2000-03-20',N'Cà Mau','0334756454','anh@gmail.com','223243254342')



INSERT HoaDon([maHD],[ngayLap],[maKH],[maNV],[tongTien])
VALUES ('HD001','2023-04-10','KH001','NV001',250000)

INSERT HoaDon([maHD],[ngayLap],[maKH],[maNV],[tongTien])
VALUES ('HD002','2023-04-11','KH002','NV002',150000)

INSERT ChiTietHoaDon([maCTHD],[maHD],[maTour],[soLuongKhach],[donGia],[thanhTien])
VALUES ('CTHD001','HD001','MT001',20,3000000,60000000)

INSERT ChiTietHoaDon([maCTHD],[maHD],[maTour],[soLuongKhach],[donGia],[thanhTien])
VALUES ('CTHD002','HD002','MT002',25,5000000,125000000)

