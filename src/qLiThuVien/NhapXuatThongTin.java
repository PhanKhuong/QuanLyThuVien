package qLiThuVien;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class NhapXuatThongTin 
{
	
	//HÀM ĐIẾM SỐ DÒNG CỦA 1 FILE
	public static int DemSoDong(String path) throws IOException
	{
		 InputStream is = new BufferedInputStream(new FileInputStream(path));
		    try {
		        byte[] c = new byte[1024];
		        int count = 0;
		        int readChars = 0;
		        boolean empty = true;
		        while ((readChars = is.read(c)) != -1) {
		            empty = false;
		            for (int i = 0; i < readChars; ++i) {
		                if (c[i] == '\n') {
		                    ++count;
		                }
		            }
		        }
		        return (count == 0 && !empty) ? 1 : count;
		    } finally {
		        is.close();
		    }
	}
	
	//HÀM LẤY RA MẢNG ĐỌC GIẢ
	public static ArrayList<DocGia> getMangDocGia()
	{
		ArrayList<DocGia> listDocGia = new ArrayList<>();
		
		return null;
	}
	//HÀM GHI ĐỌC GIẢ XUỐNG FILE
	public static void GhiDocGia() throws IOException
	{
		//tạo file và kiểm tra file
		File fileDocGia = new File("fileDocGia.txt");
		PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileDocGia, true)));
		if(fileDocGia.exists()== false)
		{
			fileDocGia.createNewFile();
		}
		else
		{
			//GHI ĐỌC GIẢ
			DocGia docGia = null;
			int luachon = 0;
			int soDongFile;
			Scanner input = new Scanner(System.in);
			while(true)
			{
				//TÍNH SỐ ĐỌC GIẢ HIỆN TẠI
				soDongFile = DemSoDong("fileDocGia.txt");
				printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileDocGia, true)));
				if(soDongFile == 0)
				{
					System.out.println("Đọc giả thứ: 1");
				}
				else
				{
					int soDocGia = (soDongFile/4) +1 ;
					System.out.println("Đọc giả thứ: " + soDocGia);
				}
				docGia.NhapDocGia();
				printWriter.println(DocGia.tendocgia);
				printWriter.println(DocGia.maDocGia);
				printWriter.println(DocGia.soSachmuon);
				printWriter.println(DocGia.thoiGianMuonSach);
				System.out.println("Tiếp tục thêm không? 1. có  2. không");
				luachon = input.nextInt();
					if(luachon == 2)
				{
					break;
				}
				printWriter.close();
			}
			printWriter.close();
		}
	}
	
	//HÀM IN TẤT CẢ THÔNG TIN ĐỌC GIẢ TỪ FILE
	public static ArrayList<DocGia> XuatDocGia() throws IOException
	{
		ArrayList<DocGia> listDocGia = new ArrayList<>();
		File fileDocGia = new File("fileDocGia.txt");
		if(fileDocGia.exists() == false)
		{
			System.out.println("Chưa có đọc giả nào trong thư viện");
		}
		else
		{
			BufferedReader br = new BufferedReader(new FileReader("fileDocGia.txt"));     
			if (br.readLine() == null) 
			{
			    System.out.println("Chưa có đọc giả nào trong thư viện");
			}
			else
			{
				int soDong = DemSoDong("fileDocGia.txt");
				int dongHienTai = 0;
				Scanner fileScanner = new Scanner(fileDocGia);
				DocGia docGia = new DocGia ();
				for(int i = 0, z = 0;;i++, z++)
				{
					System.out.println("***Đọc giả thứ: " + (i+1));
					docGia.tendocgia = fileScanner.nextLine();
					if(i >= 1)
					{
						docGia.tendocgia = fileScanner.nextLine();
					}
					docGia.maDocGia = fileScanner.nextLine();
					docGia.soSachmuon = fileScanner.nextInt();
					docGia.thoiGianMuonSach = fileScanner.nextInt();
					listDocGia.add(docGia);
					docGia.XuatDocGia();
					dongHienTai += 4;
					if(dongHienTai == soDong)
					{
						fileScanner.close();
						break;
					}
				}
			}
		}
		return listDocGia;
	}
	
	//HÀM SỮA THÔNG TIN ĐỌC GỈA
	public static void SuaDocGia() throws IOException
	{
		File fileDocGia = new File("fileDocGia.txt");
		if(fileDocGia.exists()== false)
		{
			System.out.println("Chưa có đọc giả nào trong thư viện");
		}
		else
		{
			BufferedReader br = new BufferedReader(new FileReader("fileDocGia.txt"));     
			if (br.readLine() == null) 
			{
			    System.out.println("Chưa có đọc giả nào trong thư viện");
			}
			else
			{
				ArrayList<DocGia> listDocGia = new ArrayList<>();
				listDocGia = XuatDocGia();
				for(int i = 0;i<listDocGia.size();i++)
				{
					listDocGia.get(i).XuatDocGia();
				}
				Scanner input = new Scanner(System.in);
				System.out.println("Nhập mã đọc giả muốn chỉnh sửa: ");
				String Ma = input.nextLine();
				for(int i = 0; i<listDocGia.size(); i++)
				{
					if(Objects.equals(Ma, listDocGia.get(i).getMaDocGia()) == true)
					{
						System.out.println("Chọn phần bạn muốn chỉnh sửa: ");
						System.out.println("1. Tên đọc giả ");
						System.out.println("2. Số mượn sách");
						System.out.println("3. Thời gian mượn(Ngày)");
						int chon = 0;
						chon = input.nextInt();
						switch (chon) 
						{
						case 1:
							System.out.println("Nhập tên đọc giả mới: ");
							listDocGia.get(i).setMaDocGia(input.nextLine());
							System.out.println("Đã cập nhật!");
							break;
						case 2:
							System.out.println("Nhập số sách mượn mới: ");
							listDocGia.get(i).setSoSachmuon(input.nextInt());
							System.out.println("Đã cập nhật!");
							break;
						case 3:
							System.out.println("Nhập thời gian mượn sách mới: ");
							listDocGia.get(i).setThoiGianMuonSach(input.nextInt());
							System.out.println("Đã cập nhật!");
							break;
						default:
							break;
						}
					}
				}
				
				//GHI ĐỌC GIẢ TRỞ LẠI
				fileDocGia.delete();
				for(DocGia docGia : listDocGia)
				{
					PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileDocGia, true)));
					printWriter.println(DocGia.tendocgia);
					printWriter.println(DocGia.maDocGia);
					printWriter.println(DocGia.soSachmuon);
					printWriter.println(DocGia.thoiGianMuonSach);
					System.out.println("Tiếp tục thêm không? 1. có  2. không");
					int luachon = input.nextInt();
						if(luachon == 2)
						printWriter.close();
						break;
					}
				}
			}
		}
	}
