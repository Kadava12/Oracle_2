 package oracle.Connection;



import oracle.form.*;
import oracle.function.Exam;
import oracle.function.Exam1;
import oracle.function.ExamReport;
import oracle.function.Question;
import oracle.function.UserInfo;


import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.*;

class DBManager {
    private static final String DBDriver = "com.mysql.cj.jdbc.Driver";
    private static final String DBUrl = "jdbc:mysql://localhost:3306/exam";
    private static final String DBUser = "root";
    private static final String DBPassword = "123456789";
    static {
        try {
            Class.forName(DBDriver);
        } catch (Exception ex) {
           System.out.println(ex);
        }
    }
    
    
    // method for  save the usere's data in the database.
     public static boolean registerUser(String fname,String userid,String passwd,String userType)
    {
        boolean flag =false;
        try
        {
            Connection con = DriverManager.getConnection(DBUrl,DBUser,DBPassword);
            PreparedStatement st1 = con.prepareStatement("Select * from Users where UserId=?");
            st1.setString(1,userid);
            ResultSet rs = st1.executeQuery();
            if(rs.next())
            {
                flag=false;
            }
            else
            {
            PreparedStatement st = con.prepareStatement("Insert into users(UserId,passwd,UserType,Name)values(?,?,?,?)");
            st.setString(1,userid);
            st.setString(2,passwd);
            st.setString(3,userType);
            st.setString(4,fname);
          
            st.executeUpdate();        
            
            st.close();
            con.close();
            flag=true;
            }
        } catch (Exception ex) {
        } 
        return flag;
    } 
          
               
    
   // method for authentication of user.
   public static boolean authenticateUser(String userId, String passwd) {
        boolean flag = false;
        try {
            Connection con = DriverManager.getConnection(DBUrl,DBUser,DBPassword);
            PreparedStatement st = con.prepareStatement("Select * from Users where UserId=? and Passwd=?");
            st.setString(1,userId);
            st.setString(2,passwd);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                flag=true;
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return flag;
    }  
   
   //method for getting the information about user from database...
   public static UserInfo getUserInfo(String userId) {
        UserInfo info = null;
        try {
            Connection con = DriverManager.getConnection(DBUrl,DBUser,DBPassword);
            PreparedStatement st = con.prepareStatement("Select * from Users where UserId=?");
            st.setString(1,userId);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                info = new UserInfo();
                info.setUserId(rs.getString(1));
                info.setPasswd(rs.getString(2));
                info.setUserType(rs.getString(3));
                info.setName(rs.getString(4));
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return info;
    }
   
   //method for getting exams from database..
    public static ArrayList<Exam> getAllExams() {
        ArrayList<Exam> list = new ArrayList<Exam>();
        try {
            Connection con = DriverManager.getConnection(DBUrl,DBUser,DBPassword);
            PreparedStatement st = con.prepareStatement("Select * from Exams");
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Exam e = new Exam();
                e.setExamId(rs.getInt(1));
                e.setExamName(rs.getString(2));
                e.setDescription(rs.getString(3));
                e.setNumberOfQuestions(rs.getInt(4));
                e.setDuration(rs.getInt(5));
                list.add(e);
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception ex) {
        }
        return list;
    } 
    
    // method for genrateing question paper according to selected exam
    public static ArrayList<Question> generateQuestionPaper(Exam exam){
        ArrayList<Question> list = new ArrayList<>(exam.getNumberOfQuestions());
        try {
            Connection con = DriverManager.getConnection(DBUrl,DBUser,DBPassword);
            PreparedStatement st = con.prepareStatement("Select * from Questions where ExamId=?");
            st.setInt(1,exam.getExamId());
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Question q = new Question();
                q.setQuestion(rs.getString("Question"));
                q.setOptionA(rs.getString("OptionA"));
                q.setOptionB(rs.getString("OptionB"));
                q.setOptionC(rs.getString("OptionC"));
                q.setOptionD(rs.getString("OptionD"));
                q.setAnswer(rs.getString("Answer"));
                list.add(q);
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception ex) {
        } 
        Collections.shuffle(list);
        list.trimToSize();
        return list;
    }
    
    // method for  save the usere's performance report on database
    public static boolean saveReport(ExamReport report){
        boolean flag=false;
        try {
            Connection con = DriverManager.getConnection(DBUrl,DBUser,DBPassword);
            PreparedStatement st = con.prepareStatement("Insert into reports(UserName,ExamName,ExamDate,TotalQuestions,CorrectAnswers,Score)values(?,?,?,?,?,?)");
            st.setString(1,report.getUserName());
            st.setString(2,report.getExamName());
            java.sql.Date date = new java.sql.Date(new java.util.Date().getTime());
            st.setDate(3,date);
            st.setInt(4, report.getTotalQuestions());
            st.setInt(5, report.getCorrect());
            st.setDouble(6, report.getScore());
            st.executeUpdate();
            st.close();
            con.close();
            flag=true;
        } catch (Exception ex) {
        } 
        return flag;
    } 
    
    // method for view all the user's test report.
    public static ArrayList<ExamReport> getAllReports() {
        ArrayList<ExamReport> list = new ArrayList<ExamReport>();
        try {
            Connection con = DriverManager.getConnection(DBUrl,DBUser,DBPassword);
            PreparedStatement st = con.prepareStatement("Select * from Reports");
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                ExamReport r = new ExamReport();
                r.setUserName(rs.getString(2));
                r.setExamName(rs.getString(3));
                Date d = rs.getDate(4);
                r.setExamDate(getDate(d));
                r.setTotalQuestions(rs.getInt(5));
                r.setAttempted(rs.getInt(6));
                r.setScore(rs.getDouble(7));
                list.add(r);
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception ex) {
        }
        return list;
    }  
    private static String getDate(Date d){
        java.util.Date doe = new java.util.Date(d.getTime());
        SimpleDateFormat fmt = new SimpleDateFormat("dd-MMMM-yyyy");
        String str = fmt.format(doe);
        return str;
    }

    public static boolean addExam(String ExamId, String ExamName, String Description, String Question, String Duration) {
        
      boolean flag =false;
        try
        {
            Connection con = DriverManager.getConnection(DBUrl,DBUser,DBPassword);
            PreparedStatement st1 = con.prepareStatement("Select * from exams where ExamId=?");
            st1.setString(1,ExamId);
            ResultSet rs = st1.executeQuery();
            if(rs.next())
            {
                flag=false;
            }
            else
            {
            PreparedStatement st = con.prepareStatement("Insert into exams values(?,?,?,?,?)");
            st.setString(1,ExamId);
            st.setString(2,ExamName);
            st.setString(3,Description);
            st.setString(4,Question);
            st.setString(5,Duration);
          
            st.executeUpdate();        
            
            st.close();
            con.close();
            flag=true;
            }
        } catch (Exception ex) {
        } 
        return flag;
    }

    public static boolean addQuestion(String QuestionId, String Question, String OptionA, String OptionB, String OptionC, String OptionD, String Answer, String ExamId) {
          boolean flag =false;
        try
        {
            Connection con = DriverManager.getConnection(DBUrl,DBUser,DBPassword);
            PreparedStatement st1 = con.prepareStatement("Select * from exams where ExamId=? ");
            st1.setString(1,ExamId);
            ResultSet rs = st1.executeQuery();
            if(rs.next())
            {
             PreparedStatement st = con.prepareStatement("Insert into questions values(?,?,?,?,?,?,?,?)");
            st.setString(1,QuestionId);
            st.setString(2,Question);
            st.setString(3,OptionA);
            st.setString(4,OptionB);
            st.setString(5,OptionC);
            st.setString(6,OptionD);
            st.setString(7,Answer);
            st.setString(8,ExamId);
            st.executeUpdate();  
            flag=true;
            st.close();
            con.close();
            }
            else
            {
               flag=false;
            }
        } catch (Exception ex) {
        } 
        return flag;
    }

    public static UserInfo getData(String name) {
        UserInfo s = null;
        try {
            Connection con = DriverManager.getConnection(DBUrl,DBUser,DBPassword);
            PreparedStatement st = con.prepareStatement("Select * from users where UserId=?");
            st.setString(1,name);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                s = new UserInfo();
                s.setPasswd(rs.getString(2));
                s.setUserType(rs.getString(3));
                s.setName(rs.getString(4));
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception ex) {
        }
        return s;
    }

    public static int updateStudent(UserInfo s) {
     int x = 0;
        try {
            Connection con = DriverManager.getConnection(DBUrl,DBUser,DBPassword);
            PreparedStatement st = con.prepareStatement("update users set passwd=? where userid=?");
            st.setString(1,s.getPasswd());
            st.setString(2,s.getUserId());
            x = st.executeUpdate();
            con.close();
        } catch (Exception ex) {
        }
        return x;
    }

  public static int deleteStudent(String userId, String passwd) {
           int x=0;
        try {
            Connection con = DriverManager.getConnection(DBUrl,DBUser,DBPassword);
            PreparedStatement st = con.prepareStatement("Delete from users where UserId=?and passwd=?");
            st.setString(1,userId);
            st.setString(2,passwd);
            x = st.executeUpdate();
            con.close();
        } catch (Exception ex) {
        }
        return x;
  }

   public  static int update1(Exam1 s) {
     int x=0;
        try {
            Connection con = DriverManager.getConnection(DBUrl,DBUser,DBPassword);
            PreparedStatement st = con.prepareStatement("update exams set NumberOfQuestions=?,Duration=? where ExamId=?");
            st.setString(1,s.getQuestion());
            st.setString(2,s.getDuration());
            st.setString(3,s.getExamId());
            x = st.executeUpdate();
            con.close();
        } catch (Exception ex) {
        }
        return x;
    }
        
    }

        
    
        
    
    




    
      
 

 