import java.util.ArrayList;

public class StudentList {
    private String name;
    private String address;
    private ArrayList<String> courses; // วิชา
    private ArrayList<Integer> grades; // คะแนน

    /*
     * Constructor for the student class.
     * Validation of input data
     */
    public StudentList(String name, String address) {
        // Validation of input name
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name must not be null or blank.");
        }
        // Validation of input address
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("Address must not be null or blank.");
        }

        this.name = name;
        this.address = address;
        this.courses = new ArrayList<>();
        this.grades = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        // Validation of input address
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("Address must not be null or blank.");
        }
        this.address = address;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("%s(%s)", name, address);
    }

    /*
     * Adds a new course and grade.
     * 
     * @param course the course name.
     * 
     * @param grade the grade(0-100).
     */
    public void addCourseGrade(String course, int grade) {
        // Add validation for the course and grade
        // Validation of input course
        if (course == null || course.isBlank()) {
            System.out.println("Error:Course must not be null or blank.");
            return;
        }
        // Validation of input grade
        if (grade < 0 || grade > 100) {
            System.out.println("Error:Grade must must be between 0 and 100.");
            return;
        }
        //Check if the course limit is reached
        if(courses.size() >= 30){
            System.out.println("Cannot add more than 30 courses.");
            return;
        }

        this.courses.add(course);
        this.grades.add(grade);
    }

    //Print all the courses and grades in a formatted string.
    public void printGrades(){
        System.out.print(this.name+" ");
        for(int i=0; i<courses.size(); i++){
            System.out.print(courses.get(i) + ":" + grades.get(i));
            if(i < courses.size() -1)
                System.out.print(", ");
        }
        System.out.println();
    }

    /*
     * Calculates the average grade for all courses.
     * @return the average grade, or 0.0 if no course are added.
     */
    public double getAverageGrade(){
        if(courses.isEmpty()) return 0.0;
        int sum=0;
        //using foreach
        for (int _grade:grades) {
            sum += _grade;
        }

        return (double)sum/courses.size();
    }
}
