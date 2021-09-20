import java.util.*;
import java.sql.*;
public class MainClass{
    public static void main(String[] args) throws Exception {
      Signup objSig=new Signup();
      Login objLog=new Login();
      Scanner sc=new Scanner(System.in);
      int value=0;
      System.out.println(">>>====>>>>>>WELCOME TO BETA BANKING<<<<<<====<<<"+"\n"+"====>Choose and Press the Options to Start Banking<===="+"\n"+"1:---->Signup"+"\n"+"2:---->Login"+"\n"+"3:---->Exit");
      String MyPass="root";
      String uname="root";
      value=sc.nextInt();
      switch(value){
          case 1:objSig.SignupMethod(uname,MyPass);
          break;
          case 2:{
            objLog.LoginMethod(uname, MyPass);
            }
          break;
          case 3:exit();
          break;
          default: {
          System.out.println("Please Enter a Number from the list Given");
          main(null);
          }
      }
    }
  public static void exit(){
      System.exit(0);
  }
  
}
