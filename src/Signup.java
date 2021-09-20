import java.util.*;
import java.sql.*;
public class Signup extends MainClass{
    String Name;
    String Address;
    String Username;
    String Password;
    String Email;
    long PhoneNumber;
public void SignupMethod(String uname,String MyPass)throws Exception{
    Scanner sc=new Scanner(System.in);
      System.out.println(">>>====>>>>>>Please Enter Your  Information Correctly<<<<<<====<<<");
      System.out.print(" Please Enter You Name Here :-");
      String Name=sc.nextLine();
      this.Name=Name;
      System.out.print(" Please Enter You Address Here :-");
      String Address=sc.nextLine();
      this.Address=Address;
      System.out.print(" Please Set You Username Here :-");
      String Username=sc.nextLine();
      this.Username=Username;
      System.out.print(" Please Set You Password Here :-");
      String Password=sc.nextLine();
      this.Password=Password;
      System.out.print(" Please Set You Phone Number Here :-");
      long PhoneNumber=sc.nextLong();
      this.PhoneNumber=PhoneNumber;
      sc.nextLine();
      System.out.print(" Please Set You Email Here :-");
      String Emailid=sc.nextLine();
      this.Email=Emailid;
      System.out.println("Please Wait....");
      Class.forName("com.mysql.cj.jdbc.Driver");
      String url="jdbc:mysql://localhost:3306/banksystem";
      Connection con=DriverManager.getConnection(url,uname,MyPass);
    Statement st=con.createStatement();
    String query="insert into signup_table values"+"("+"'"+Name+"'"+","+"'"+Address+"'"+","+"'"+Username+"'"+","+"'"+Password+"'"+","+PhoneNumber+","+"'"+Email+"'"+","+"default"+","+"default"+","+"default"+","+"default"+")";
    st.executeUpdate(query);
    System.out.println("*****CONGRATULATIONS*****"+"\n"+"You Have Successfully Created Your Account"+"\n"+"==========Happy Banking===========");
    System.out.println("\n");
         System.out.println("\n");
    st.close();
    con.close();
    main(null);
    }  
}