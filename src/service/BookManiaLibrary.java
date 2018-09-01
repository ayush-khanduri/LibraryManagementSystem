package service;

import java.util.ArrayList;

import bean.Audio;
import bean.Book;
import bean.MediaItem;
import exception.ItemException;

public class BookManiaLibrary implements Library {
	ArrayList<MediaItem> mitem;	//Arraylist of all mediaitem objects kinda
	
	//Constructor to initialize two items in Library
	public BookManiaLibrary() {
		mitem = new ArrayList<MediaItem>();
		Book b1 = new Book();
		b1.setAuthor("Akchamp");
		b1.setPrice(2000);
		b1.setTitle("How to become champ");
		b1.setYear(2018);
		mitem.add(b1);
		Audio a1 = new Audio();
		a1.setArtist("Ayush");
		a1.setTitle("How to become a singer");
		a1.setPrice(10000);
		a1.setYear(2018);
		mitem.add(a1);
	}
	
	//add new item to arraylist
	@Override
	public void addItem(MediaItem item) {
		mitem.add(item);
	}
	
	//search among existing items and return index
	@Override
	public int searchItemById(int id) throws ItemException {
		for(int i=0;i<mitem.size();i++)
		{
			if(mitem.get(i).getId()==id)
				return i;
		}
		return -1;
	}
	
	//returns all available items in arraylist
	@Override
	public ArrayList<MediaItem> getItems() {
		return mitem;
	}
	
	//update title using index in arraylist
	@Override
	public void updateItem(int idx, String tt) throws ItemException {
		mitem.get(idx).setTitle(tt);
	}
	
	//update price using index in arraylist
	@Override
	public void updateItem(int idx, Double d) throws ItemException {
		mitem.get(idx).setPrice(d);
	}
	
	//update year using index in arraylist
	@Override
	public void updateItem(int idx, int yr) throws ItemException {
		mitem.get(idx).setYear(yr);
	}
	
	//update title using index in arraylist
	@Override
	public boolean deleteItem(int idx) throws ItemException {
		mitem.remove(idx);
		/*for(int i=0;i<mitem.size();i++)
		{
			if(mitem.get(i).getId()==id)
			{
				
				return true;
			}
		}*/
		return true;
	}
	//returns items at a given price
	@Override
	public ArrayList<MediaItem> samePrice(Double price) {
		ArrayList<MediaItem> smprice=new ArrayList<MediaItem>();
		for(int i=0;i<mitem.size();i++)
		{
			if(mitem.get(i).getPrice()==price)
			{
				smprice.add(mitem.get(i));
			}
		}
		return smprice;
	}
	//returns items from a given year
	@Override
	public ArrayList<MediaItem> sameYear(int year) {
		ArrayList<MediaItem> smyear=new ArrayList<MediaItem>();
		for(int i=0;i<mitem.size();i++)
		{
			if(mitem.get(i).getYear()==year)
			{
				smyear.add(mitem.get(i));
			}
		}
		return smyear;
	}	
}
