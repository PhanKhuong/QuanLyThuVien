package qLiThuVien;

import java.io.InputStream;
import java.util.Scanner;
import java.io.Serializable;

public class DocGia implements Serializable {
	//CÁC THUỘC TÍNH CỦA ĐỌC GIẢ
	  static String tendocgia;
	  static String maDocGia;
	  static int soSachmuon;
	  static int thoiGianMuonSach;
	
	//CONSTRUCTOR
	public DocGia(String ten, String maDocGia, int soSachmuon, int thoiGianMuonSach) {
		this.tendocgia = ten;
		this.maDocGia = maDocGia;
		this.soSachmuon = soSachmuon;
		this.thoiGianMuonSach = thoiGianMuonSach;
	}
	public DocGia()
	{
		this.tendocgia="";
		this.maDocGia="";
		this.soSachmuon=0;
		this.thoiGianMuonSach=0;
	}
	public String getTendocgia() {
		return tendocgia;
	}

	public void setTendocgia(String tendocgia) {
		DocGia.tendocgia = tendocgia;
	}

	public int getSoSachmuon() {
		return soSachmuon;
	}

	public void setSoSachmuon(int soSachmuon) {
		DocGia.soSachmuon = soSachmuon;
	}

	public int getThoiGianMuonSach() {
		return thoiGianMuonSach;
	}

	public void setThoiGianMuonSach(int thoiGianMuonSach) {
		DocGia.thoiGianMuonSach = thoiGianMuonSach;
	}

	public void setMaDocGia(String maDocGia) {
		DocGia.maDocGia = maDocGia;
	}

	public String getMaDocGia() {
		return maDocGia;
	}

	//HÀM TRẢ VỀ THÔNG TIN MỘT ĐỌC GIẢ
	public DocGia NhapDocGia(){
		Scanner input = new Scanner(System.in);
		System.out.print("Nhập tên đọc giả: ");
		tendocgia = input.nextLine();
		System.out.print("Nhập mã đọc giả: ");
		maDocGia = input.nextLine();
		System.out.print("Nhập số sách mượn: ");
		soSachmuon = input.nextInt();
		System.out.print("Nhập thời gian mượn sách: ");
		thoiGianMuonSach = input.nextInt();
		return( new DocGia(tendocgia, maDocGia, soSachmuon, thoiGianMuonSach));
	}
	
	//HÀM IN RA THÔNG TIN MỘT ĐỌC GIẢ
	public void XuatDocGia(){
		System.out.println(tendocgia);
		System.out.println(maDocGia);
		System.out.println(soSachmuon);
		System.out.println(thoiGianMuonSach);
	}
	
	
}
