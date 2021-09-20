import java.util.*;
import java.sql.*;
public class Login{
    String Usernamedata;
    String Passworddata;
    public void LoginMethod(String uname,String MyPass) throws Exception{
        Scanner sc=new Scanner(System.in);
       System.out.print("Enter the Username:- ");
        String username=sc.nextLine();
        this.Usernamedata=username;
        System.out.print("Enter Your Password:- ");
        String password=sc.nextLine();
       this.Passworddata=password;
        System.out.println("Please Wait.....");
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/banksystem";
        Connection con=DriverManager.getConnection(url,uname,MyPass);
    Statement st=con.createStatement();
    Statement st2 = con.createStatement();
    String query1="Select Username,Password from signup_table";
    String query2="Select Number from signup_table where Username ="+"'"+Usernamedata+"'";
    
    ResultSet rs=st.executeQuery(query1);
    ResultSet rs2 = st2.executeQuery(query2);
    ResultSetMetaData rsMetaData=rs.getMetaData();
    int columns=rsMetaData.getColumnCount();
List<String> userdata=new ArrayList<>();
List<String> userpass=new ArrayList<>();
String value="";
    while(rs.next()){
        userdata.add(rs.getString("Username"));
        userpass.add(rs.getString("Password"));
         }
         int index1 = userdata.indexOf(Usernamedata);
         int index2=  userpass.indexOf(Passworddata);
    
         if(index1>-1){
             if(index2>-1){
                 if(index1==index2){
                 System.out.println("*******Congratulations You Have Logged into your Account*******");
                 rs2.next();
                 Banking Bank=new Banking(rs2.getInt("Number"),uname,MyPass);
                 Bank.StartBanking();
                 }
                 else
                 {
                    System.out.println("#####Login Faild Please Retry#####");
                    System.out.println("\n");
                    System.out.println("\n");
                      MainClass.main(null);
                 }
             }
             else{
             System.out.println("#####Login Faild Please Retry#####");
             System.out.println("\n");
             System.out.println("\n");
             MainClass.main(null);
            }
         }
         else{
         System.out.println("#####Login Faild Please Retry#####");
         System.out.println("\n");
         System.out.println("\n");
         MainClass.main(null);
         }
         
    st.close();
    con.close();
    
    }
   
    
}
