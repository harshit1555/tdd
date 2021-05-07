package com.example.demo;

public class StringCal 
{
	public int add(String str) throws NegativeNumberExeption
	{
		int tot=0;
		if(str.length()==0)
		{
		return 0;
		}
		String[] ch=str.split("[\n,;%*]");
		if(ch.length==1)
		{
			if(Integer.parseInt(ch[0])<0)
			{
				throw new NegativeNumberExeption("Negative numbers not allowed");
			}
			if(Integer.parseInt(ch[0])<1000)
			{
				tot=Integer.parseInt(ch[0]);	
			}
			
		}
		else if(ch.length>1)
		{
			for(int i=0;i<ch.length;i++)
			{
				if(Integer.parseInt(ch[i])<0)
				{
					throw new NegativeNumberExeption("Negative numbers not allowed");
				}
				if(Integer.parseInt(ch[i])<1000)
				{
					tot+=Integer.parseInt(ch[i]);	
				}
				
			}
		}
		
		return tot;
	}
}
