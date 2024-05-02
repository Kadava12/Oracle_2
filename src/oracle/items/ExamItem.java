
package oracle.items;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import oracle.Connection.DatabaseConnection;
import oracle.Connection.PopupData;
import oracle.controller.DataController;
import oracle.form.DASH;
import oracle.form.VIEWREPORT;
import oracle.model.ModelData;
import raven.glasspanepopup.GlassPanePopup;


public class ExamItem extends javax.swing.JPanel {

   
    public void setData(ModelData data) {
        this.data = data;
        ExamBtn.setText(data.getExamName());
        courseID.setText(data.getCourseID());
    }
   private DataController dataController;
   private PopupData pd;
   private VIEWREPORT viewreport;
  
    public ExamItem() {
        initComponents();
        pd = new PopupData();
        dataController = new DataController();
        viewreport = new VIEWREPORT();
    }
public void courseData(){
    try {
        DatabaseConnection connection = new DatabaseConnection();
        Connection con = connection.getCConnection();
        String sql = "SELECT * FROM exams WHERE CourseId = ?";
          
        PreparedStatement p = con.prepareStatement(sql);
        int dataset = Integer.parseInt(ExamBtn.getText());
        p.setInt(1, dataset);
        viewreport.coursedataItem.removeAll();
        viewreport.repaint();
        viewreport.revalidate();
        ResultSet rs = p.executeQuery();
        while (rs.next()) {
            ModelData item = new ModelData(rs.getString("ExamName"));
            viewreport.courseItem(item);
        }
        con.close(); // Close the connection
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    private ModelData data;
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ExamBtn = new javax.swing.JButton();
        courseID = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        ExamBtn.setText("123");
        ExamBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExamBtnActionPerformed(evt);
            }
        });

        courseID.setText("CourseId");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ExamBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(courseID)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ExamBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(courseID)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ExamBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExamBtnActionPerformed
     
    }//GEN-LAST:event_ExamBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton ExamBtn;
    public javax.swing.JLabel courseID;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
