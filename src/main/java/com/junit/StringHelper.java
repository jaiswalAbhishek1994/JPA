package com.junit;

public class StringHelper {
	
	public String stringHelper(String s){
		if(s.length()<=2){
			s.replaceAll("A", "");
		}else{
			s=s.substring(0, 2).replaceAll("A", "")+s.substring(2);
		}
		return s;
	}
	
	public boolean fistAndLastAreSme(String s){
		if(s.length()<=1){
			return false;
		}else if(s.substring(0, 2).equals(s.substring(s.length()-2))){
			return true;
		}else{
			return false;
		}
	}
	
	
	public  static void main(String args[]) {
		String s="A";
		boolean res=new StringHelper().fistAndLastAreSme(s);
		System.out.println(res);
	}
}
