public class GeometricObject
{
private String color = "Yellow";
private Boolean filled = true;

public String getColor( )
{   
return color;
}
	
public void setColor(String color)  
{   
this.color = color; 
}

public boolean isFilled( )
{ 
return filled; 
}

public void setFilled(boolean filled)
{   
this.filled = filled; 
}


public String toStrings( ) 
{   
return  " Color: " + color + " and filled: " + filled;
}

}

