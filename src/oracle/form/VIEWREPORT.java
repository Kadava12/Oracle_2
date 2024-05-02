package oracle.form;





import oracle.function.ExamReport;
import oracle.items.CourseItem;
import oracle.items.ExamItem;
import oracle.model.ModelData;



public class VIEWREPORT extends javax.swing.JPanel {

   
    
 
    public VIEWREPORT() {
        initComponents();
        
    }
      public void addItem(ModelData data){
          ExamItem item = new ExamItem();
          item.setData(data);
          panelItem.add(item);
          repaint();
          revalidate();
      }
        public void courseItem(ModelData data){
          CourseItem item = new CourseItem();
          item.setData(data);
          coursedataItem.add(item);
          repaint();
          revalidate();
      }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelItem = new oracle.swing.PanelItem();
        jScrollPane2 = new javax.swing.JScrollPane();
        coursedataItem = new oracle.swing.PanelItem();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(51, 51, 51));
        setEnabled(false);
        setPreferredSize(new java.awt.Dimension(587, 400));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Course Name:");

        jScrollPane1.setViewportView(panelItem);

        jScrollPane2.setViewportView(coursedataItem);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public oracle.swing.PanelItem coursedataItem;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public oracle.swing.PanelItem panelItem;
    // End of variables declaration//GEN-END:variables
}

