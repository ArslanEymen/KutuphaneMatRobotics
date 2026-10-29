package MatRobotics;
import java.util.Scanner;
import java.util.ArrayList;

class Books{
	String bookName;
	String author;
	int id;
	boolean isfree;

	
	Books(String bookName,String author,int id,boolean isfree){
		this.bookName = bookName;
		this.author = author;
		this.id = id;
		this.isfree=isfree;

		
	}
	
	public class kutuphaneMatRobotics{
		public static void main(String[] args) {
			Scanner input = new Scanner(System.in);
			
			
			
			int num=-1;
			
			Books sefiller = new Books("Sefiller","Victor Hugo",17,true);
			Books zenginBaba = new Books("Zengin Baba Yoksul Baba","Robert Kiyosaki",21,true);
			Books fareler = new Books("Fareler ve İnsanlar","John Steinbeck",36,false);
			
			
			ArrayList<Books> kitaplar = new ArrayList();
			
			kitaplar.add(sefiller);
			kitaplar.add(zenginBaba);
			kitaplar.add(fareler);
			
			
			while(num != 0) {
				System.out.print("==== Kütüphane ====\n\n1 - Kitapları Listele\n2 - Kitap Ekle\n3 - Kitap Ödünç Al\n4 - Kitap İade Et\n5 - Kitap Ara\n6 - Çıkış\n\nSeçiminiz: ");
				num = Integer.parseInt(input.nextLine());
			
			if(num == 1) {
				for(Books book:kitaplar) {
					
					System.out.println("\nKitap Adı: "+book.bookName+"\nKitap Yazarı: "+book.author+"\nKitap ID: "+book.id+"\nMüsaitlik: "+(book.isfree ? "Müsait\n":"Ödünçte\n"));
					System.out.println("-".repeat(15));
				}
			}
			
			if(num==2) {
				System.out.println("-".repeat(15));
				
				System.out.print("\nKitap Adı: ");
				String addingName = input.nextLine(); 
				
				System.out.print("Kitap Yazarı: ");
				String addingAuthor = input.nextLine();
				
				System.out.print("ID ekle: ");
				int addingId = Integer.parseInt(input.nextLine());
				
				System.out.println("Kitap Eklendi!");
				
				System.out.println("-".repeat(15));
				boolean idisfull = false;
				for(Books book:kitaplar) {
					if(book.id == addingId) {
						idisfull = true;
					}
				}
					
				if(idisfull) {
					System.out.println("Bu ID'ye Sahip Kitap Zaten Bulunuyor!");
				}else {
					Books eklenenKitap = new Books(addingName,addingAuthor,addingId,true);
					kitaplar.add(eklenenKitap);
					}	
					
			}
			if(num == 3) {
				System.out.println("\nÖdünç Almak İstediğiniz Kitaın ID'si: ");
				int borrowId = Integer.parseInt(input.nextLine());
				
				boolean isBorrow = false;
				
				
				
				for(Books book:kitaplar) {
					if(book.id == borrowId) {
						isBorrow=true;
						
						if(book.isfree) {
							book.isfree=false;
							System.out.println("Kitap Ödünç Alındı!");
						}else {
							System.out.println("Kitap Zaten Ödünç Alınmış!");
						}
						break;
					}	
				}
			if(!isBorrow) {
			System.out.println("ID'ye Ait Kitap Bulunamadı!");
			}
								
				}
			if(num==4) {
			System.out.println("İade Etmek İstediğiniz Kitabın ID'si: ");
			int returnedId =  Integer.parseInt(input.nextLine());
			boolean isReturned = false;
			
			for(Books book:kitaplar) {
				if(book.id==returnedId) {
					if(book.isfree) {
						System.out.println("Kitap Zaten Kütüphanede!");
						isReturned=true;
					}else{
						System.out.println("Kitap İade Alındı");
						book.isfree=true;
						isReturned=true;
					}
				}
				
				
				}
			if(!isReturned) {
				System.out.println("Kitap ID'si Bulunamadı!");
			}
			}
			if(num==5) {
				System.out.print("Aramak istediğiniz Kitap/Yazar Adını Giriniz: ");
				String nameof = input.nextLine();
				
				for(Books book:kitaplar) {
					if(book.bookName.contains(nameof) || book.author.contains(nameof)) {
						System.out.println("\nKitap Adı: "+book.bookName+"\nKitap Yazarı: "+book.author+"\nKitap ID: "+book.id+"\nMüsaitlik: "+(book.isfree ? "Müsait\n":"Ödünçte\n"));
					}
				}
			}
				
				
			
			if(num == 0) {
				System.out.println("ÇIKIŞ YAPILDI");
				
			}
}
			
		}
	}
}