import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
class Passanger implements Serializable {
    long aadhar,phone;
    String Name,Dob,email_id,address;
    public Passanger(String Name,String Dob,String email_id, long aadhar, long phone,String address)
    {
        this.aadhar=aadhar;
        this.Name=Name;
        this.Dob=Dob;
        this.email_id=email_id;
        this.phone=phone;
        this.address=address;
    }
    public String toString()
	{
		return "\nPassanger Details :" + "\nAadhar no.: " + this.aadhar + "\nName: " + this.Name + "\nDOB: " + 
				this.Dob + "\nContact No: " + this.phone + "\nEmail-id: " + this.email_id +"\n Address:" + this.address;
	} 
   void Display_Details(ArrayList<Passanger> al)
	{
		System.out.println("\n--------------Passanger List---------------\n");
		System.out.println(String.format("%-20s%-20s%-20s%-20s%-30s%-30s","Name","DOB","Aadhar No.","Contact-no","Email-Id","Address"));
		for(Passanger p : al)
		{
			System.out.println(String.format("%-20s%-20s%-20s%-20s%-30s%-30s",p.Name,p.Dob,p.aadhar,p.phone,p.email_id,p.address));
		}
	}
	int check_aadhar(long aadhar,ArrayList<Passanger> al){
        int i1=0;
					for(Passanger p: al)
					{
						if(aadhar == p.aadhar)
						{
							i1++;
						}
					}
					return i1;
    }
 void Search_Passanger(long aadhar,ArrayList<Passanger> al){
        int i=0;
					for(Passanger p: al)
					{
						if(aadhar == p.aadhar)
						{
							System.out.println(p+"\n");
							i++;
						}
					}
					if(i == 0)
					{
						System.out.println("\nPassanger Details are not available!!");
					}
    }
 void Delete_Passanger(long aadhar,ArrayList<Passanger> al){
        int k=0;
					try{
					for(Passanger p: al)
					{
						if(aadhar == p.aadhar)
						{
								al.remove(p);
								Display_Details(al);
								k++;
						}
					}
					if(k == 0)
					{
						System.out.println("\nEmployee Details are not available, Please enter a valid ID!!");
					}
					}
					catch(Exception e1){
						System.out.println(e1);
					}

    }
	static int Check_Date(String Date){
		SimpleDateFormat sdfrmt = new SimpleDateFormat("dd-MM-yyyy");
			if (Date.trim().equals(""))
		{
			return 1;
		}
		   else{
			sdfrmt.setLenient(false);
		   }
		   try
			{
				Date javaDate = sdfrmt.parse(Date); 
			}
			catch (ParseException e)
			{
				System.out.println(Date+" is Invalid Date format");
				return 0;
			}
			return 1;
	
		}
void Modify_Passanger(long aadhar,ArrayList<Passanger> al){

        Scanner sc1=new Scanner(System.in);
        int j=0;
					for(Passanger p: al)
					{
						if(aadhar == p.aadhar)
						{	
							j++;
						do{Scanner scc=new Scanner(System.in);
							int ch1 =0;
							System.out.println("\nEDIT Passanger Details :\n" +
												"1). Aadhar no.\n" +
												"2). Name\n" +
												"3). DOB\n" +
												"4). Contact No.\n" +
												"5). Email-ID\n" +
                                                "6).Address\n"+
												"7). GO BACK\n");
							System.out.println("Enter your choice : ");
							ch1 = sc1.nextInt();
							switch(ch1)
							{
							case 1: System.out.println("\nEnter new Aadhar no.:");
									p.aadhar =scc.nextLong();
									System.out.println(p+"\n");
									break;
							
							case 2: System.out.println("Enter new Passanger Name:");
									p.Name =scc.nextLine();
									System.out.println(p+"\n");
									break;
									
							case 3: System.out.println("Enter new DOB:");
									p.Dob =scc.nextLine();
									int f3=Check_Date(p.Dob);
									if(f3==0){break;}
									System.out.println(p+"\n");
									break;
									
							case 4: System.out.println("Enter new Passanger Contact No. :");
									p.phone =scc.nextLong();
									System.out.println(p+"\n");
									break;
									
							case 5: System.out.println("Enter new Passanger Email-ID :");
									p.email_id =scc.nextLine();
									System.out.println(p+"\n");
									break;
									
							case 6:System.out.println("Enter new Passanger Address:");
                                   p.address =scc.nextLine();
                                   System.out.println(p+"\n");
                                   break;
                            case 7:j++;
								   break;
									
							default : System.out.println("\nEnter a correct choice from the List :");
										break;
							
							}
							}
						while(j==1);
						}
					}
					if(j == 0)
					{
						System.out.println("\nPassanger Details are not available!!");
					}
					//sc1.close();
    }               
}          
class Flight implements Serializable{
	double Num;
    String FName,From,To,Time,Date;
    public Flight(String FName,double Num,String From, String To,String Time,String Date)
    {
        this.FName=FName;
        this.Num=Num;
        this.From=From;
        this.To=To;
        this.Time=Time;
		this.Date=Date;
    }
    public String toString()
	{
		return "\nFlight Details :" + "\nFlight Name: " + this.FName + "\nFlight No.: " + this.Num + "\nDeparture From: " + 
				this.From + "\nDestination: " + this.To + "\nTimings: " + this.Time +"\nDate:" + this.Date;
	} 
	int check_Flight_Num(double Num2,ArrayList<Flight> a2){
        int i1=0;
					for(Flight f : a2)
					{
						if(Num2 == f.Num)
						{
							i1++;
						}
					}
					return i1;
    }
    void Display_Flight(ArrayList<Flight> a2)
	{
		System.out.println("\n--------------Flight List---------------\n");
		System.out.println(String.format("%-25s%-15s%-20s%-20s%-15s%-15s","Flight Name","Flight Number","From","To","Departure","Date"));
		for(Flight f : a2)
		{
			System.out.println(String.format("%-25s%-15s%-20s%-20s%-15s%-15s",f.FName,f.Num,f.From,f.To,f.Time,f.Date));
		}
	}
	void Search_Flight(double Num,ArrayList<Flight> a2){
        int i=0;
					for(Flight f: a2)
					{
						if(Num == f.Num)
						{
							System.out.println(f+"\n");
							i++;
						}
					}
					if(i == 0)
					{
						System.out.println("\nFlight not available!!");
					}
    }
    void Delete_Flight(double Num,ArrayList<Flight> a2){
        int k=0;
					try{
					for(Flight f: a2)
					{
						if(Num == f.Num)
						{
								a2.remove(f);
								Display_Flight(a2);
								k++;
						}
					}
					if(k == 0)
					{
						System.out.println("\nEmployee Details are not available, Please enter a valid ID!!");
					}
					}
					catch(Exception e1){
						System.out.println(e1);
					}

    }
       
}	
class Reservation implements Serializable{
	long Ticket_no,Passport_no,aadhar;
	String Class, Mode_type,FName,From,To,Time,Date,status,Name;
	int n ;
	float fare;
public Reservation(long Ticket_no, String Class,String Mode_type,String FName,String From,String To,String Time,String Date,long Passport_no,long aadhar,String status,String Name,float fare){
	this.Ticket_no=Ticket_no;
	this.Class=Class;
	this.Mode_type=Mode_type;
	this.FName=FName;
	this.From=From;
	this.To=To;
	this.Time=Time;
	this.Date=Date;
	this.Passport_no=Passport_no;
	this.aadhar=aadhar;
	this.status=status;
	this.Name=Name;
	this.fare=fare;
}
public String toString()
	{
		return "\nReservation Details :" + "\nTicket No.: " + this.Ticket_no + "\nClass : " + this.Class+ "\nDomestic or International: " + 
				this.Mode_type+ "\nfare: " + this.fare + "\nStatus: " + this.status; 
	} 			
void Book_Ticket(ArrayList<Reservation> a3){
	long s1_aadhar;
	double Num1;
	ArrayList<Passanger> al = new ArrayList<Passanger>();
	File fi = null;
	FileInputStream fis = null;
	ObjectInputStream ois = null;
	FileOutputStream fos = null;

	ObjectOutputStream oos =null;
	Passanger p1 =new Passanger("", "", "", 0, 0, "");
	Scanner sc=new Scanner(System.in);

try{
		
	fi = new File("passanger.txt");
	if(fi.exists())
	{
		fis = new FileInputStream(fi);
		ois = new ObjectInputStream(fis);
		al = (ArrayList<Passanger>)ois.readObject();
	}
	
}
catch(Exception e1){
	System.out.println(e1);
}	

	p1.Display_Details(al);
	System.out.println("Enter Aadhar no. of the Passanger To be booked:\n");
	s1_aadhar=sc.nextLong();
	int i=0;
					for(Passanger p: al)
					{
						if(s1_aadhar == p.aadhar)
						{
						Scanner sc4= new Scanner(System.in);
						ArrayList<Flight> a2 = new ArrayList<Flight>();
						File fil = null;
						FileInputStream fis1 = null;
						ObjectInputStream ois1 = null;
						FileOutputStream fos1 = null;
						ObjectOutputStream oos1 =null;
						Flight f1=new Flight(" ",0," "," "," ", "");
					try{
							
						fil = new File("Flight.txt");
						if(fil.exists())
						{
							fis1 = new FileInputStream(fil);

							ois1 = new ObjectInputStream(fis1);
							a2 = (ArrayList<Flight>)ois1.readObject();
						}
						
					}
					catch(Exception e1){
						System.out.println(e1);
					}
					i++;
					f1.Display_Flight(a2);
					System.out.println("Enter Flight no.To be booked:\n");
                 	Num1=sc.nextDouble();
					int j=0;
					for(Flight f: a2)
					{
						if(Num1 == f.Num)
						{	
						System.out.println("\nEnter the following details to BOOK TICKET:\n");
								System.out.println("Enter Ticket No.:");
								Ticket_no= sc.nextLong();
								System.out.println("1). Economy\n" +
								                  "2).First Class\n" +
								                "3).Bussiness Class\n");
								System.out.println("Enter Seat Class:");
								n=sc.nextInt();
								fare=5000;
								switch(n){
									case 1: Class="Economy";
									break;
									case 2: Class="First Class";
									fare=fare*2;
									break;
									case 3: Class="Bussiness Class";
									fare=fare*3;
									break;
									default:System.out.println("Invalid Input");

											
								}
								System.out.println("Enter Domsetic / International");
								Mode_type= sc.next();
								System.out.println("Enter Ticket Status:");
								status=sc.next();
								System.out.println("Enter Passport No.:");
								Passport_no= sc.nextLong();
								if(countDig(Passport_no)!=8)
								{System.out.println("Enter valid Passport no.");
									  j++;
							          break;}
								System.out.println("Passanger Name:"+p.Name);
								a3.add(new Reservation(Ticket_no,Class,Mode_type,f.FName,f.From,f.To,f.Time,f.Date,Passport_no,p.aadhar,status,p.Name,fare));
								Reservation r =new Reservation(Ticket_no,Class,Mode_type,f.FName,f.From,f.To,f.Time,f.Date,Passport_no,p.aadhar,status,p.Name,fare); 
								System.out.println(r+"\n");
								System.out.println("Booking Complete");
								j++;
								}

						}
					if(j==0)
					{
						System.out.println("\nFlight not available!!");
						Book_Ticket(a3);
					}	
					try {
						fos1 = new FileOutputStream(fil);
						oos1 = new ObjectOutputStream(fos1);
						oos1.writeObject(a2);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					catch(Exception e2){
						e2.printStackTrace();
					}
					finally{
						try {
							fis1.close();
							ois1.close();
							fos1.close();
							oos1.close();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}	
					}
					//sc4.close();

						}
					
					if(i == 0)
					{
						System.out.println("\nPassanger Details are not available!!");
						Book_Ticket(a3);
					}
					try {
						fos = new FileOutputStream(fi);
						oos = new ObjectOutputStream(fos);
						oos.writeObject(al);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					catch(Exception e2){
						e2.printStackTrace();
					}
					finally{
						try {
							fis.close();
							ois.close();
							fos.close();
							oos.close();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
	}										//sc.close();
	
					
void Cancel_Ticket(long Ticket_no,ArrayList<Reservation> a3){        
	int k=0;
	try{
	for(Reservation r: a3)
	{
		if(Ticket_no == r.Ticket_no)
		{
				a3.remove(r);
				Display_Booking(a3);
				k++;
		}
	}
	if(k == 0)
	{
		System.out.println("\nTicket no. not available, Please enter a valid No.!!");
	}
	}
	catch(Exception e1){
		System.out.println(e1);
	}

}
void Display_Booking(ArrayList<Reservation> a3){
	System.out.println("\n--------------Booking List---------------\n");
		System.out.println(String.format("%-20s%-20s%-20s%-20s%-30s%-30s","Ticket No.","Class","Dom/Int.","Flight Name","Passanger Name","Ticket Status"));
		for(Reservation r : a3)
		{
			System.out.println(String.format("%-20s%-20s%-20s%-20s%-30s%-30s",r.Ticket_no,r.Class,r.Mode_type,r.FName,r.Name,r.status));
		}
}	
static int countDig(long n)
{
String str = Long.toString(n);
int size =str.length();
return size;
}



}

public class Airline_Reservation{
	static int Check_Date(String Date){
	SimpleDateFormat sdfrmt = new SimpleDateFormat("dd-MM-yyyy");
		if (Date.trim().equals(""))
	{
	    return 1;
	}
	   else{
		sdfrmt.setLenient(false);
	   }
	   try
	    {
	        Date javaDate = sdfrmt.parse(Date); 
	    }
		catch (ParseException e)
	    {
	        System.out.println(Date+" is Invalid Date format");
	        return 0;
	    }
		return 1;
	}
	static int countDig(long n)
{
String str = Long.toString(n);
int size =str.length();
return size;
}
public static boolean isTimeValid(String value) {
    try {
        String[] time = value.split(":");
        return  Integer.parseInt(time[0]) < 24 && Integer.parseInt(time[1]) < 60;
    } catch (Exception e) {
        return false;
    }
}
	public static void main(String args[])
	{
		int k1=0,ch1,ch,k3=0,ch4;
		Scanner scn= new Scanner(System.in);
			while(k1==0){
				System.out.println("\n*********Airline Reservation**********\n");
					System.out.println("1). Passanger Operation\n" +
										"2). Flight Operation\n" +
										"3). Reservation Operation\n" +
										"4). EXIT\n");
					System.out.println("Enter your choice : ");
					ch = scn.nextInt();  
					switch(ch)
					{
						case 1:int k=0;
							long aadhar,phone,s_aadhar;
							String Name,Dob,email_id,address;
							Scanner sc= new Scanner(System.in);
							ArrayList<Passanger> al = new ArrayList<Passanger>();
							File fi = null;
							FileInputStream fis = null;
							ObjectInputStream ois = null;
							FileOutputStream fos = null;
							ObjectOutputStream oos =null;
						try{
								
							fi = new File("passanger.txt");
							if(fi.exists())
							{
								fis = new FileInputStream(fi);
								ois = new ObjectInputStream(fis);
								al = (ArrayList<Passanger>)ois.readObject();
							}
							
						}
						catch(Exception e1){
							System.out.println(e1);
						}
						while(k==0){
							System.out.println("\n*********Passanger Details Management System**********\n");
								System.out.println("1). Add Passanger Details\n" +
													"2). Search for Passanger\n" +
													"3). Modify Passanger details\n" +
													"4). Delete Passanger Details\n" +
													"5). Display Passanger Details\n" +
													"6). EXIT\n");
								System.out.println("Enter your choice : ");
								ch1 = sc.nextInt(); 
								Passanger p =new Passanger("", "", "", 0, 0, ""); 
								switch(ch1)
								{
								case 1:
								System.out.println("\nEnter the following details to ADD list:\n");
								System.out.println("Enter Name:");
								Name = sc.next();
								System.out.println("Enter DOB(dd-mm-yyyy):");
								Dob=sc.next();
								int f=Check_Date(Dob);
								if(f==0)
								{	System.out.println("The Date Entered is Invalid");
									break;}
								System.out.println("Enter Email ID:");
								email_id= sc.next();
								System.out.println("Enter Phone no.:");
								phone=sc.nextLong();
								if(countDig(phone)!=10)
								{break;
																	
							}	
								System.out.println("Enter Aadhar No.:");
								aadhar=sc.nextLong();
								if(countDig(aadhar)==12)
								{int v=p.check_aadhar(aadhar, al);
									if(v==1)
									{
										System.out.println("Aadhar already exists:");
										break;
									}}
								else{System.out.println("Invalid aadhar");
																	break;
							}	
								
								System.out.println("Enter adderss:");
								address=sc.next();
									al.add(new Passanger(Name, Dob, email_id,aadhar, phone,address));
									Passanger p1 =new Passanger(Name, Dob, email_id, aadhar, phone,address); 
									System.out.println(p1+"\n");
									break;
								case 2:
								System.out.println("Enter Aadhar of the Passanger to be Searched");
								s_aadhar=sc.nextLong();
								p.Search_Passanger(s_aadhar, al);       
								break;
								case 3:
								System.out.println("Enter Aadhar of the Passanger to be Modified");
								s_aadhar=sc.nextLong();
								p.Modify_Passanger(s_aadhar, al); 
								break;
								case 4:
								System.out.println("Enter Aadhar of the Passanger to be Deleted");
								s_aadhar=sc.nextLong();
								p.Delete_Passanger(s_aadhar, al);       
								break;  
								case 5:p.Display_Details(al);
									   break;
								case 6:
								try {
									fos = new FileOutputStream(fi);
									oos = new ObjectOutputStream(fos);
									oos.writeObject(al);
								} catch (IOException e1) {
									e1.printStackTrace();
								}
								catch(Exception e2){
									e2.printStackTrace();
								}
								finally{
									try {
										fis.close();
										ois.close();
										fos.close();
										oos.close();
									} catch (Exception e1) {
										e1.printStackTrace();
									}
								}
								k++;    
								break;  
								
							}
							
											
											
						
						} 
						       
						        break;
						case 2:	 int k2=0;
						double Num,s_Num;
						String FName,From,To,Time,Date;
						Scanner sc4= new Scanner(System.in);
						ArrayList<Flight> a2 = new ArrayList<Flight>();
						File fil = null;
						FileInputStream fis1 = null;
						ObjectInputStream ois1 = null;
						FileOutputStream fos1 = null;
						ObjectOutputStream oos1 =null;
					 try{
							
						fil = new File("Flight.txt");
						if(fil.exists())
						{
							fis1 = new FileInputStream(fil);
							ois1 = new ObjectInputStream(fis1);
							a2 = (ArrayList<Flight>)ois1.readObject();
						}
						
					}
					catch(Exception e1){
						System.out.println(e1);
					}
					while(k2==0){
						System.out.println("\n*********Flight System Management **********\n");
						System.out.println("1). Add Flight Details\n" +
											"2). Search for Flight\n" +
											"3). Delete Flight\n" +
											"4). Display All Flight Details\n" +
											"5). EXIT\n");
						System.out.println("Enter your choice : ");
						int ch2 = sc4.nextInt();  
						Flight f=new Flight("",0,"","","","");
						switch(ch2)
						{
							case 1: 
							System.out.println("\nEnter the following details to ADD Flight:\n");
							System.out.println("Enter Flight Name:");
							FName = sc4.next();
							System.out.println("Enter Flight Number:");
							Num=sc4.nextDouble();
							int v1=f.check_Flight_Num(Num, a2);
								if(v1==1)
								{
									System.out.println("Flight already exists:");
									break;
								}
							System.out.println("Enter Departure From:");
							From= sc4.next();
							System.out.println("Enter Destination.:");
							To=sc4.next();
							System.out.println("Enter Departure Time:");
							Time=sc4.next();
							if(isTimeValid(Time)==false)
							{System.out.println("Time entered is Invalid");
								break;}
							System.out.println("Enter Date:");
							Date=sc4.next();
							int f5=Check_Date(Date);
							if(f5==0)
							{	System.out.println("Date Entered is invalid");
								break;
							}

							a2.add(new Flight(FName, Num, From,To, Time,Date));
							Flight f1=new Flight(FName,Num,From,To,Time,Date);
							System.out.println(f1+"\n");
							break;
							case 2:
							System.out.println("Enter the Flight Number to be Searched:");
							s_Num=sc4.nextDouble();
							f.Search_Flight(s_Num, a2);
							break;
							case 3:
							System.out.println("Enter the Flight Number to be Deleted:");
							s_Num=sc4.nextDouble();
							f.Delete_Flight(s_Num, a2);
							break;
							case 4:
							f.Display_Flight(a2);
							break;
							case 5:
							try {
								fos1 = new FileOutputStream(fil);
								oos1 = new ObjectOutputStream(fos1);
								oos1.writeObject(a2);
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							catch(Exception e2){
								e2.printStackTrace();
							}
							finally{
								try {
									fis1.close();
									ois1.close();
									fos1.close();
									oos1.close();
								} catch (Exception e1) {
									e1.printStackTrace();
								}
							}

							k2++;    
							break;  
						}	
						;

					}
					break;
					case 3:
					ArrayList<Reservation> a3 = new ArrayList<Reservation>();
					File fi2 = null;
					FileInputStream fis2 = null;
					ObjectInputStream ois2 = null;
					FileOutputStream fos2 = null;
					ObjectOutputStream oos2 =null;
					try{
						
						fi2 = new File("Reservation.txt");
						if(fi2.exists())
						{
							fis2 = new FileInputStream(fi2);
							ois2 = new ObjectInputStream(fis2);
							a3 = (ArrayList<Reservation>)ois2.readObject();
						}
						
					}
					catch(Exception e1){
						System.out.println(e1);
					}
					Reservation r=new Reservation(0,"","","","","","","",0,0,"","",0);
					while(k3==0){
						System.out.println("\n*********Ticket Management **********\n");
						System.out.println("1). Book a Ticket \n 2). Cancel a Ticket\n 3). Display All Tickets\n 4). EXIT\n");
						System.out.println("Enter your choice : ");
						Scanner sc5=new Scanner(System.in);
						ch4 = sc5.nextInt();  
						switch(ch4)
						{case 1:r.Book_Ticket(a3);
							    break;
						 case 2:
						        System.out.println("Enter the Ticket No. to be Cancelled:");
								long Ticket_no1=scn.nextLong();
								r.Cancel_Ticket(Ticket_no1,a3);
								break;
						case 3:r.Display_Booking(a3);
								break;
						case 4:
								try {
									fos2= new FileOutputStream(fi2);
									oos2 = new ObjectOutputStream(fos2);
									oos2.writeObject(a3);
								} catch (IOException e1) {
									e1.printStackTrace();
								}
								catch(Exception e2){
									e2.printStackTrace();
								}
								finally{
									try {
										fis2.close();
										ois2.close();
										fos2.close();
										oos2.close();
									} catch (Exception e1) {
										e1.printStackTrace();
									}
								k3++;
								break;		
						}
						//sc5.close();
					}
				}
				case 4: k1++;
						break;
			}	
			//scn.close();
	}
  }
}
