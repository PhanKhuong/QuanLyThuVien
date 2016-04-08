package qLiThuVien;

import java.io.IOException;
import java.lang.management.ThreadMXBean;
import java.util.Scanner;

public class IUThuVien {
	//CÁC THUỘC TÍNH CỦA CLASS
	private Scanner input = new Scanner(System.in);
	private int check;
	private int num;
	
	//GIAO DIỆN MENU CHÍNH
	public void MenuChinh() throws IOException{
		System.out.println("HỆ THỐNG QUẢN LÍ THƯ VIỆN");
		System.out.println("     \t  *****");
		System.out.println("1. Đọc giả");
		System.out.println("2. Sách");
		System.out.println("0. Thoát ứng dụng!");
		
		//KIỂM TRA DỮ LIỆU NHẬP VÀO ĐÚNG VỚI CÁC SỐ CÓ SẴN HAY KHÔNG? NẾU KHÔNG NHẬP LẠI
		while(true)
		{
			System.out.print("***NHẬP GIÁ TRỊ TƯƠNG ỨNG ĐỂ CHỌN ĐỐI TƯỢNG MUỐN TRUY CẬP, CHỈ NHẬN GIÁ TRỊ ĐÚNG: ");
			while(true)
			{
		        while (!input.hasNextInt())
		        {
		        	input.next();	
		        }
		        	num = input.nextInt();
		        if(num == 1 || num == 2 || num == 0)
		        {
		        	check = num;
		        	break;
		        }
			}			
			
			//KIỂM TRA SWITCH CASE
			switch (check) {
			case 1:
				for (int i = 0; i < 50; ++i) System.out.println();
				this.DocGia();
				break;
			case 2:
				for (int i = 0; i < 50; ++i) System.out.println();
				this.Sach();
				break;
			case 0:
				System.exit(0);
			}
		}
		
	}
	
	//GIAO DIỆN CỦA ĐỌC GIẢ
	public void DocGia() throws IOException{
		while(true){
			System.out.println("1. Thêm đọc giả vào thư viện");
			System.out.println("2. Xem đọc giả trong thư viện");
			System.out.println("3. Sửa thông tin đọc giả trong thư viện");
			System.out.println("4. Xóa đọc giả khỏi thư viện");
			System.out.println("5. Tìm kiếm đọc giả theo tên");
			System.out.println("6. Tìm kiếm đọc giả theo ngày đăng kí");
			System.out.println("7. Trở về");
			System.out.println("0. Thoát ứng dụng!");
			
			//KIỂM TRA DỮ LIỆU NHẬP VÀO ĐÚNG VỚI CÁC SỐ CÓ SẴN HAY KHÔNG? NẾU KHÔNG NHẬP LẠI
			
				System.out.print("***NHẬP GIÁ TRỊ TƯƠNG ỨNG ĐỂ CHỌN ĐỐI TƯỢNG MUỐN TRUY CẬP, CHỈ NHẬN GIÁ TRỊ ĐÚNG: ");
				while(true){
			        while (!input.hasNextInt()){
			        	input.next();
			        }
			        	num = input.nextInt();
			        if(num == 1 || num == 2 || num == 3 || num == 4 || num == 5 || num == 6 || num == 7 || num == 0){
			        	check = num;
			        	break;
			        }
			    }
				
				//KIỂM TRA SWITCH CASE
				switch (check) {
				case 1:
					for (int i = 0; i < 50; ++i) System.out.println();
					NhapXuatThongTin.GhiDocGia();
					break;
				case 2:
					for (int i = 0; i < 50; ++i) System.out.println();
					NhapXuatThongTin.XuatDocGia();
					break;
				case 3:
					for (int i = 0; i < 50; ++i) System.out.println();
					NhapXuatThongTin.SuaDocGia();
					break;
				case 4:
					for (int i = 0; i < 50; ++i) System.out.println();
					break;
				case 5:
					for (int i = 0; i < 50; ++i) System.out.println();
					break;
				case 6:
					for (int i = 0; i < 50; ++i) System.out.println();
					break;
				case 7:
					for (int i = 0; i < 50; ++i) System.out.println();
					this.MenuChinh();
					break;
				case 0:
					System.exit(0);
				}
		}
	}
	
	//GIAO DIỆN CỦA SÁCH
	public void Sach(){
		System.out.println("1. Xem sách trong thư viện");
		System.out.println("2. Thêm sách vào thư viện");
		System.out.println("3. Sửa thông tin sách trong thư viện");
		System.out.println("4. Xóa sách khỏi thư viện");
		System.out.println("5. Tìm kiếm sách theo tên");
		System.out.println("6. Tìm kiếm sách theo mã sách");
		System.out.println("7. Trở về");
		System.out.println("0. Thoát ứng dụng!");
	}
}
