
package oracle.model;

public class ModelData {

   
    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getExamName() {
        return examName;
    }

   
    public void setExamName(String examName) {
        this.examName = examName;
    }

    public ModelData() {
    }

    public ModelData(String examName) {
        this.examName = examName;
    }
    
    private String examName;
    private String courseID;
}
