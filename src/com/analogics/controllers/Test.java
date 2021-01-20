package com.analogics.controllers;


	/**
	 * @param args
	 */
	public class Test{  
		   int division(int a, int b) {  
			int t = a/b;
			return t;
		   }  
		   public static void main(String args[]){  
			   Test obj = new Test();
			try{
			   System.out.println(obj.division(15,0));  
			}
			catch(Exception e){
			   System.out.println(e.getMessage());
			}
		   }  
		}

