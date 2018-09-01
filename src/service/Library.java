package service;

import java.util.ArrayList;

import bean.MediaItem;
import exception.ItemException;

public interface Library {
	public void addItem(MediaItem item);//add new item to arraylist
	int searchItemById(int id) throws ItemException;//search item using unique item id
	public ArrayList<MediaItem> getItems();//return all items arraylist
	
	//overloaded updateItem to update different members easily
	void updateItem(int idx,String tt) throws ItemException;//updates title
	void updateItem(int idx,Double d) throws ItemException;//updates price
	void updateItem(int idx,int yr) throws ItemException;//updates yr
	boolean deleteItem(int id) throws ItemException;
	public ArrayList<MediaItem> samePrice(Double price);
	public ArrayList<MediaItem> sameYear(int year);
}
