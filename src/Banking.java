import java.util.*;
import java.sql.*;
public class Banking{
   static int Id;
   static String username;
   static String password;
  Scanner sc=new Scanner(System.in);

   Banking(int id,String jdbcuser,String jdbcpass){
       this.Id=id;
       this.username=jdbcuser;
       this.password=jdbcpass;
   }
    public void StartBanking() throws Exception{
       System.out.println(">>>====>>>>>>WELCOME TO BETA BANKING<<<<<<====<<<"+"\n"+"====>Choose and Press the Options to Start Banking<===="+"\n"+"1:---->Deposite Money"+"\n"+"2:---->Withdraw Money"+"\n"+"3:---->Exit"+"\n"+"4:---->Check Statement");
        int value=sc.nextInt();
      switch(value){
          case 1:Deposite();
          break;
          case 2:Withdraw();
          break;
          case 3:exit();
          break;
          case 4:Check();
          break;
          default: {
          System.out.println("Please Enter a Number from the list Given");
          StartBanking();
          }
      }
    }
    //////////////////////////////////////
    public void Deposite() throws Exception{
       System.out.println("Enter The amount to Deposite");
              int amount=sc.nextInt(); 
        Class.forName("com.mysql.cj.jdbc.Driver");
      //Getting the connection
      String url="jdbc:mysql://localhost:3306/banksystem";
      Connection con = DriverManager.getConnection(url, username, password);
      System.out.println("Connection established......");
      //Creating a Statement object
      Statement stmt = con.createStatement();
     String query2="Select Total_Amount from signup_table where Number ="+"'"+Id+"'";
     ResultSet rs2 = stmt.executeQuery(query2);
     rs2.next();
     int Recieved_Amount=rs2.getInt("Total_Amount");
     int Balance=Recieved_Amount+amount;
     String query1="Update signup_table set Total_Amount="+Balance+","+"Last_Deposit="+amount+" where Number="+Id;
     stmt.executeUpdate(query1);
     System.out.print("==========Account Updates==========");
     StartBanking();

    }
    /////////////////////////////////
    public  void Withdraw() throws Exception{
        System.out.println("Enter The amount to Withdraw");
        int amount=sc.nextInt(); 
  Class.forName("com.mysql.cj.jdbc.Driver");
//Getting the connection
String url="jdbc:mysql://localhost:3306/banksystem";
Connection con = DriverManager.getConnection(url, username, password);
System.out.println("Connection established......");
//Creating a Statement object
Statement stmt = con.createStatement();
String query2="Select Total_Amount from signup_table where Number ="+"'"+Id+"'";
ResultSet rs2 = stmt.executeQuery(query2);
rs2.next();
int Recieved_Amount=rs2.getInt("Total_Amount");
int Balance=Recieved_Amount-amount;
String query1="Update signup_table set Total_Amount="+Balance+","+"Last_Withdraw="+amount+" where Number="+Id;
stmt.executeUpdate(query1);
System.out.print("==========Account Updates==========");
StartBanking();

    }
    public void exit(){
        System.exit(0);
    }

    ///////////////////////////////

    public  void Check() throws Exception{
  Class.forName("com.mysql.cj.jdbc.Driver");
//Getting the connection
String url="jdbc:mysql://localhost:3306/banksystem";
Connection con = DriverManager.getConnection(url, username, password);
System.out.println("Fetching Information Please Wait......\n\n");
//Creating a Statement object
Statement stmt = con.createStatement();
String query2="Select Name,Address,Username,Phone,Email,Total_Amount,Last_Deposit,Last_Withdraw from signup_table where Number ="+"'"+Id+"'";
ResultSet rs2 = stmt.executeQuery(query2);
rs2.next();
String name=rs2.getString("Name");
String Add=rs2.getString("Address");
String Uname=rs2.getString("Username");
long phone=rs2.getLong("Phone");
String Email=rs2.getString("Email");
int TAmount=rs2.getInt("Total_Amount");
int DAmount=rs2.getInt("Last_Deposit");
int WAmount=rs2.getInt("Last_Withdraw");

System.out.println("The Name of this Acount Holder is :"+name+"\n"+"The Address is :"+Add+"\n"+"The Username is :"+Uname+"\n"+"Phone Number is :"+phone+"\n"+"Email address is :"+Email+"\n"+"======================="+"\n"+"TOTAL BALANCE ::: Rs"+TAmount+"\n"+"LAST DEPOSIT AMOUNT  Rs:::"+DAmount+"\n"+"LAST WITHDRAW AMOUNT ::: Rs"+WAmount);

System.out.print("Do you want to Start Banking Again ? \n Press True or False \n");
Boolean ch=sc.nextBoolean();

if(ch==true){
    StartBanking();
}
else{
    System.exit(0);
}
    }

    }
