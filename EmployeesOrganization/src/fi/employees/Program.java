package fi.employees;
import org.fi.utils.LinkedList;
import org.fi.utils.LinkedListException;
import org.fi.utils.Node;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import fi.employees.db.Employee;
import fi.employees.db.Engineer;
import fi.employees.db.Manager;
import fi.employees.db.SalesPerson;



public class Program {

	public static void main(String[] args)  {
		 Scanner  scanner =new Scanner(System.in);
		   
		 // Employee objEmployee [] =new Employee[500];
		 LinkedList<Employee> list = new LinkedList<Employee>();
		   int count=0;
		   int choice=0;
		   int index=0;
		   do
		   {
			   System.out.println("Enter your choice : 1.Add Employee 2.Display 3.Sort 4. Save to file 5.Load from file 6.Exit");
			   
			   choice=scanner.nextInt();
			   switch(choice)
			   { 
			     case 1:
			     {    
			    	 int EmployeeTypeChoice=0;
			     do
			       {	 
			    	 System.out.println("Enter your choice : 1.Manager 2.Engineer 3.Sales Person  4.Exit Main Menu");
			    	 EmployeeTypeChoice=scanner.nextInt();
			    	 switch(EmployeeTypeChoice)
			    	 {
					    	 case 1:
					    	 case 2:
					    	 case 3:
					    	 {
									   System.out.println("Enter the name");
									   String name =scanner.next();
									   System.out.println("Enter the address");
									   String address=scanner.next();
									   System.out.println("Enter the age");
									   int age = scanner.nextInt();
									   System.out.println("Enter gender");
									   String gender=scanner.next();
									   System.out.println("Enter Basic Salary");
									   float basicSalary=scanner.nextFloat();
									   
									   if(EmployeeTypeChoice==1)
									   {
										   System.out.println("Enter hra");
										   float hra=scanner.nextFloat();
										  // objEmployee[count]=new Manager(name,address,age,gender,basicSalary,hra);
										   Manager manager = new Manager(name,age,gender,address,basicSalary,hra);
											list.add(manager);
									   }
									   else if(EmployeeTypeChoice==2)
									   {
										   System.out.println("Enter overtime");
										   float overtime=scanner.nextFloat();
										  // objEmployee[count]=new Engineer(name,address,age,gender,basicSalary,overtime);
											Engineer engineer = new Engineer(name,age,gender,address ,basicSalary,overtime);
											list.add(engineer);
										   
										   
					    	            }
									   else if(EmployeeTypeChoice==3)
									   {
										   System.out.println("Enter commision");
										   float commision=scanner.nextFloat();
										  // objEmployee[count]=new SalesPerson(name,address,age,gender,basicSalary,commision);
										   
										   SalesPerson salesPerson = new SalesPerson(name,age,gender,address,basicSalary,commision);
											list.add(salesPerson);
										   
									   }
									   
			    	            }
			    	          count++;
			    	          break;
					    	  case 4:
					    	  break;
					    }
			    	 
			    	 }while(EmployeeTypeChoice!=4);
			    
			    	
			           }
			       break;
			   case 2:   //Display
			   {		
				   int DisplayChoice=0;   
				   do
			   				{   
				                   System.out.println("Enter your choice : 1.All Employees 2.First Employee 3.Next Employee  4.Previous Employee 5.Last Employee 6.Exit Main Menu");
						    	    DisplayChoice=scanner.nextInt();
						         
			                        
					   
							    
			    	 
							    	 	switch(DisplayChoice)
			    	
							    	 		{
								    	 			case 1://All employee
								    	 			{
								    	 				
								    	 				
								    	 				
			    		   
														/*
														 * for(int iTmp=0;iTmp<count;iTmp++) {
														 * displayEmployee(objEmployee[iTmp]);
														 * System.out.println(objEmployee[iTmp]); }
														 */
								    	 				try {
															  displayEmployee((Employee)list.getFirst());
															while(list.current.next!=null) {
																  displayEmployee((Employee)list.getNext());
															}
														} catch (LinkedListException e) {
															System.out.println(e);
														}
								    	 				
								    	 				
											    	 }
											    	 break;
											    	 case 2://First Employee
											    	 {
															/*
															 * index =0; displayEmployee(objEmployee [index]);
															 */
											    		 
											    		 try {
																displayEmployee((Employee)list.getFirst());
															} catch (LinkedListException e) {
																System.out.println(e);
															}
															  
														   
											    	 }
											    	 break;
											    	 case 3://Next Employee
											    	 {
															/*
															 * index++; displayEmployee(objEmployee[index]);
															 */
											    		 
											    		 try {
																displayEmployee((Employee)list.getNext());
															} catch (LinkedListException e) {
																System.out.println(e);
															}
											    		 
											    	 }
											    	 case 4: //previous Employee
											    	 {
															/*
															 * try { index--; displayEmployee(objEmployee[index]); }
															 * catch(ArrayIndexOutOfBoundsException e) {
															 * e.printStackTrace(); }
															 */
											    		 
											    		 try {
																displayEmployee((Employee)list.getPrevious());
															} catch (LinkedListException e) {
																System.out.println(e);
															}
											    	 }
											    	 break;
											    	 case 5: //Last Employee
											    	 {
															/*
															 * index = count-1; displayEmployee(objEmployee[index]);
															 */
											    		 try {
																displayEmployee((Employee)list.getLast());
															} catch (LinkedListException e) {
																System.out.println(e);
															}
											    		 
											    	 }
											    	 break;
												    	 case 6:
												    	  break;
												 
							    	 		}    	
							    	 		
							}while(DisplayChoice!=6);
			   
			   }
			  	break;	
			   case 3://sort
			     {
			    	 int SortChoice=0;
			    	 do {
						    	  System.out.println("Enter your choice : 1.All Managers  2.All Engineers 3.All Sales Person  4.All Employee Ascending 5.All Employee Descending 6.Exit Main Menu");
						    	  SortChoice=scanner.nextInt();
						    	  
						    	  LinkedList<Employee> tempList = new LinkedList<Employee>();
									
									try {
										tempList.add((Employee)list.getFirst());
										while(list.current.next!=null) {
											tempList.add((Employee)list.getNext());
										}
										tempList = sort(tempList);
									} catch (LinkedListException e) {
										System.out.println(e+"Hence, cannot sort");
									}
						    	  
						    	  
						    	  
						    	  
						    	  switch(SortChoice)
						    	  {
						    	  
						    	    case 1://All Managers
						    	    {
										/*
										 * for(int temp=0;temp<index;temp++) { if(tempArr[temp] instanceof Manager) ;
										 * displayEmployee (tempArr[temp]); }
										 */
						    	    	
						    	    	try {
											for(int iTemp=0;iTemp<list.maxCount;iTemp++) {
												tempList.traverseTo(iTemp);
												if(tempList.getCurrent() instanceof Manager) {
													displayEmployee((Manager)tempList.getCurrent());
												}
											}
										} catch (LinkedListException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
						    	    }
						    	    break;
						    	    case 2://All Engineers
						    	    {

										/*
										 * for(int temp=0;temp<index;temp++) { if(tempArr[temp] instanceof Engineer)
										 * displayEmployee((Engineer)tempArr[temp]); }
										 */	
						    	    	
						    	    	try {
											for(int iTemp=0;iTemp<list.maxCount;iTemp++) {
												tempList.traverseTo(iTemp);
												if(tempList.getCurrent() instanceof Engineer) {
													displayEmployee((Engineer)tempList.getCurrent());
												}
											}
										} catch (LinkedListException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
						    	    }
						    	    break;
						    	    case 3://All sales person
						    	    {
										/*
										 * for(int temp=0;temp<index;temp++) { if(tempArr[temp] instanceof SalesPerson)
										 * displayEmployee((SalesPerson)tempArr[temp]); }
										 */
						    	    	
						    	    	try {
											for(int iTemp=0;iTemp<list.maxCount;iTemp++) {
												tempList.traverseTo(iTemp);
												if(tempList.getCurrent() instanceof SalesPerson) {
													displayEmployee((SalesPerson)tempList.getCurrent());
												}
											}
										} catch (LinkedListException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
						    	    }
						    	    break;
						    	    case 4:
						    	    {
										/*
										 * for(int temp=0;temp<index;temp++) { displayEmployee(tempArr[temp]); }
										 */
						    	    	
						    	    	try {
											for(int iTemp=0;iTemp<list.maxCount;iTemp++) {
												tempList.traverseTo(iTemp);
												displayEmployee((Employee)tempList.getCurrent());
											}
										} catch (LinkedListException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
						    	    }
						    	    break;
						    	    case 5:
						    	    {
										/*
										 * for(int temp=index-1;temp>=0;temp--) { displayEmployee(tempArr[temp]); }
										 */
						    	    	
						    	    	try {
											for(int iTemp=list.maxCount-1;iTemp>=0;iTemp--) {
												tempList.traverseTo(iTemp);
												displayEmployee((Employee)tempList.getCurrent());
											}
										} catch (LinkedListException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
						    	    }
						    	    break;
						    	    case 6:
						    	    	
						    	  }
			    	 }while(SortChoice!=6);    	  
			     }
			   break;
			   case 4://save
			   {
				   
				      FileOutputStream fos = null;
					  
					  ObjectOutputStream oos = null;
					  
					  
					  try {
						  
						    fos = new FileOutputStream("E:\\Acts-Delhi\\Employee.txt");
						    
						    oos = new ObjectOutputStream(fos); 
						    oos.writeObject(list.getFirst());
						    Employee objEmpl = (Employee)list.getFirst();
							while(list!=null) 
							{
								oos.writeObject(list.getNext());
								objEmpl = (Employee) list.getNext();
							}
						}
					  catch (Exception e)
					        {
						     	System.out.println(e);
							}
					  finally
					  {
						  
						  try {
							  
							  if(oos!=null)
								  oos.close();
							  if(fos!=null)
								  fos.close();
							
						  }
						  catch(IOException e)
						  {
							  e.printStackTrace();
						  }
						  
						  
					  }
			    }
			    
	   
			   
			   break;
			   case 5://load
			   {
				  
				    FileInputStream fis = null;

					ObjectInputStream ois = null;
					

			try {
					fis = new FileInputStream("E:\\Acts-Delhi\\Employee.txt");
	
					
						ois =  new ObjectInputStream(fis);
			

					
					
							try {
								while (true) 
								   {
									   Object data = ois.readObject();
										//list.add((Employee)data);
									   Employee objEmpl = (Employee)data;
									   System.out.println(objEmpl.getName());
										System.out.println(objEmpl.getAddress());
										System.out.println(objEmpl.getAge());
										System.out.println(objEmpl.getGender());
										System.out.println(objEmpl.getBasicSalary());
									
										if(data instanceof Manager)
											System.out.println(((Manager)data).getHra());
										
										else if(data instanceof Engineer)
											System.out.println(((Engineer)data).getOvertime());
										
										if(data instanceof SalesPerson)
											System.out.println(((SalesPerson)data).getCommision());
										
										
								
						             }
							     }
						catch (EOFException e) 
						{
                                 
							System.out.println("eof exception");
						} catch (ClassNotFoundException e) 
						{
							System.out.println("class cast Exception");
						} catch (IOException e) {

							System.out.println("I/O Exception");
						} 
						finally {
									try {
			
										if (ois != null)
											ois.close();
										if (fis != null)
											fis.close();

									   }
									catch (IOException e) 
									{
		
										System.out.println(e);
									}
						}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			   }
			   break;
			   }
			
		   }while(choice!=6);
	
		   
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	





     public static Employee[] sort(Employee[] arr) {
		
		Employee varRef;
		
		for(int iTemp=0;iTemp<arr.length-1;iTemp++) {
			for(int i=iTemp+1;i<arr.length;i++) {
				if((arr[iTemp].getName().compareToIgnoreCase(arr[i].getName()))>0) {
					varRef = arr[iTemp];
					arr[iTemp] = arr[i];
					arr[i] = varRef;
				}
			}
		}
		return arr;
	}










	public static void displayEmployee(Employee objEmployee)
	{
		   System.out.println(" Name :"+objEmployee.getName());
		   System.out.println("Address :"+objEmployee.getAddress());
		   System.out.println("Age :"+objEmployee.getAge());
		   System.out.println("Gender :"+objEmployee.getGender());
		   System.out.println("Basic Salary :"+objEmployee.getBasicSalary());
		  
		  
		   
		   if(objEmployee instanceof Manager)
		   {
			    Manager mg= (Manager)objEmployee;
			   
			   System.out.println("HRA :"+mg.getHra());
			  
		   }
		   else if(objEmployee instanceof Engineer)
		   {
			   Engineer er= (Engineer)objEmployee;
			   System.out.println("Overtime :"+er.getOvertime());
		   }
		   if(objEmployee instanceof SalesPerson)
		   {
			   SalesPerson sp= (SalesPerson)objEmployee;
			   System.out.println("Commission :"+sp.getCommision());
			 }
	}

public static LinkedList<Employee> sort(LinkedList<Employee> list) {
		
		Node<Employee> current = list.start;
		Node<Employee> index = null;
		
		if(list.start==null) {
			return null;
		}else {
			while(current!=null) {
				Employee emp1 = (Employee)current.data;
				index = current.next;
				while(index!=null) {
					Employee emp2 = (Employee)index.data;
					if(emp1.getName().compareToIgnoreCase(emp2.getName())>0) {
						current.data= emp2;
						index.data=emp1;
						emp1 = emp2;
					}
					index = index.next;
				}
				current = current.next;
			}
		}
		return list;
	}
	
	
}
