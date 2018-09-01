package validator;

public class DataValidator {
	public boolean validateId(String id)
	{
		if(id.matches("[1-9]\\d*"))
			return true;
		
		return false;
	}
	public boolean validateTitle(String title)
	{
		if(title.length()<3)
			return false;
		
		for(int i=0;i<title.length();i++)
		{
			if(!Character.isAlphabetic(title.charAt(i)) && !(title.charAt(i)==' '))
				return false;
			
		}
		return true;
		
	}
}
