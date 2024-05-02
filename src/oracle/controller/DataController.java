
package oracle.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import oracle.Connection.DatabaseConnection;

public class DataController {

    public DataController() {
    }
    public void populateData(String Querries,JTable table){
        try {
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            model.setRowCount(0);
        DatabaseConnection connection = new DatabaseConnection();
        Connection con = connection.getCConnection();
        String sql = "SELECT * FROM reports WHERE ExamName = ?";
        
        PreparedStatement p = con.prepareStatement(sql);
        p.setString(1, Querries);
        ResultSet rs = p.executeQuery();
            while (rs.next()) {                
                Vector <Object>v = new Vector<>();
                for (int i = 0; i < 30; i++) {
                   v.add(rs.getInt("ReportId"));
                   v.add(rs.getString("UserName"));
                   v.add(rs.getString("ExamName"));
                   v.add(rs.getDate("ExamDate"));
                   v.add(rs.getInt("TotalQuestions"));
                   v.add(rs.getInt("CorrectAnswers"));
                   v.add(rs.getDouble("Score"));
                }
                model.addRow(v);
            }
        
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
}
