package ui;
import java.util.*;
import bean.Audio;
import bean.Book;
import exception.ItemException;
import service.BookManiaLibrary;
import validator.DataValidator;

public class Client {
	//all static as used in multiple function including main
	static Scanner sc = new Scanner(System.in);
	static DataValidator dv = new DataValidator();
	static BookManiaLibrary bml = new BookManiaLibrary();
	//main class controls everything
	public static void main(String args[])
	{
		int option;
		char ch;
		do 
		{
			System.out.println("Choose option");
			System.out.println("1. Insert Details");
			System.out.println("2. Search Item by id");
			System.out.println("3. Update Item");
			System.out.println("4. Display Items");
			System.out.println("5. Delete");
			System.out.println("6. Search Item by price");
			System.out.println("7. Search Item by year");
			System.out.println("8. Exit");
			System.out.println("************************************************************");
			option = sc.nextInt();
			switch(option)
			{
				case 1:insert();												break;
				
				case 2:searchById();											break;
				
				case 3:update();												break;
				
				case 4:display();												break;
				
				case 5:delete();												break;
				
				case 6:searchByPrice();											break;
				
				case 7:searchByYear();											break;
				
				case 8:System.out.println("Exiting..\nBye Bye.");				return;
				
				default:System.out.println("Invalid i/p");
			}
			System.out.println("Do you want to continue? (Y/y)/(N/n)");
			ch = sc.next().charAt(0);
		}while(ch=='y' || ch=='Y');
		sc.close();
	}
	//insert new MediaItem
	public static void insert()
	{
		int option;
		String tt;
		System.out.println("What do you want to add?");
		System.out.println("1. Audio");
		System.out.println("2. Book");
		option = sc.nextInt();
		sc.nextLine();
		if(option == 1)
		{
			Audio a1 = new Audio();
			System.out.println("Enter Title of Audio");
			tt = sc.nextLine();
			if(!validateTitle(tt))
				return;
			a1.setTitle(tt);
			System.out.println("Enter Artist Name");
			a1.setArtist(sc.nextLine());
			System.out.println("Enter Price");
			a1.setPrice(sc.nextDouble());
			System.out.println("Enter Year");
			a1.setYear(sc.nextInt());
			bml.addItem(a1);
		}
		else if(option == 2)
		{
			Book b1 = new Book();
			System.out.println("Enter Title of book");
			tt = sc.nextLine();
			if(!validateTitle(tt))
				return;
			b1.setTitle(tt);
			System.out.println("Enter Author Name");
			b1.setAuthor(sc.nextLine());
			System.out.println("Enter Price");
			b1.setPrice(sc.nextDouble());
			System.out.println("Enter Year");
			b1.setYear(sc.nextInt());
			bml.addItem(b1);
		}
	}
	
	public static void searchById()
	{
		int idx,id;
		System.out.println("Enter Id to search..");
		String id_str;
		id_str=sc.next();
		id=validateId(id_str);
		if(id<1)
		{
			return;
		}
		try
		{
			id=Integer.parseInt(id_str);
			idx = bml.searchItemById(id);
			if(idx>=0)
			{
				System.out.println("Fetching Item...");
				System.out.println(bml.getItems().get(idx));
			}
			else
				throw new ItemException("Id does not exist");
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
	}
	//update data of items like title, price and year using item id 
	public static void update()
	{
		int id,idx,option,yr;
		Double price;
		String tt;
		System.out.println("Enter Id to update");
		String id_str;
		id_str=sc.next();
		id=validateId(id_str);
		if(id<1)
		{
			return;
		}
		try
		{
			idx=bml.searchItemById(id);
			if(idx>=0)
			{
				System.out.println("Choose data to update");
				System.out.println("1. Title");
				System.out.println("2. Price");
				System.out.println("3. Year");
				option = sc.nextInt();
				if(option==1)
				{
					System.out.println("Enter New Title");
					sc.nextLine();
					tt=sc.nextLine();
					if(!validateTitle(tt))
						return;
					bml.updateItem(idx,tt);
				}
				else if(option==2)
				{
					System.out.println("Enter New Price");
					price=sc.nextDouble();
					bml.updateItem(idx,price);
				}
				else if(option==3)
				{
					System.out.println("Enter New Price");
					yr=sc.nextInt();
					bml.updateItem(idx,yr);
				}
				else
				{
					System.out.println("Enter valid option");
					return;
				}
				System.out.println("Data updated..");
			}
			else
				throw new ItemException("Id does not exist");
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
	}
	//display list of all available items
	public static void display()
	{
		try
		{
			if(bml.getItems().size()!=0)
			{
				System.out.println(bml.getItems());
			}
			else
			{
				throw new ItemException("No Item to Display");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	//delete a MediaItem using id
	public static void delete()
	{
		int id=0,idx;
		System.out.println("Enter Id to delete");
		String id_str;
		id_str=sc.next();
		id=validateId(id_str);
		if(id<1)
		{
			return;
		}
		try
		{
			idx=bml.searchItemById(id); //find index of the corres id if exists
			if(idx>=0 && bml.deleteItem(idx))
			{
				System.out.println("Item Deleted.");
			}
			else
				throw new ItemException("Id does not exist");
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
	}
	//search using price
	public static void searchByPrice()
	{
		System.out.println("Enter price to search");
		Double price=sc.nextDouble();
		try
		{
			if(bml.samePrice(price).size()!=0)
			{
				System.out.println(bml.samePrice(price));
			}
			else
			{
				throw new ItemException("No Item to Display at "+ price);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	//search using year
	public static void searchByYear()
	{
		System.out.println("Enter year to search");
		int year=sc.nextInt();
		try
		{
			if(bml.sameYear(year).size()!=0)
			{
				System.out.println(bml.sameYear(year));
			}
			else
			{
				throw new ItemException("No Item to Display in "+year);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	//validate title string min 3 char and alphabetic
	public static boolean validateTitle(String s)
	{
		try
		{
			if(dv.validateTitle(s))//call DataValidator to do the main check
				return true;
			else
				throw new ItemException("Enter Title with min 3 characters and alphabets only.");
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}
	
	//validate and try catch input id to be numeric >=1
	public static int validateId(String id_str)
	{
		if(dv.validateId(id_str))
		{
			return Integer.parseInt(id_str);
		}
		System.out.println("Please Enter valid id..");
		return -1;
	}

}
