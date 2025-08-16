public class Student extends Person {

    private int numCourses = 0;
    private String[] courses = new String[30];
    private int[] grades = new int[30];

    public Student(String name, String address) {
        super(name, address);

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name must not be null or blank");
        }
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("Address must not be null or blank");
        }
    }

    public void addCourseGrade(String course, int grade) {
        if (course == null || course.isBlank()) {
            throw new IllegalArgumentException("Course name must not be null or blank");
        }
        if (numCourses >= courses.length) {
            throw new IllegalStateException("Cannot add more courses");
        }
        if (grade < 0 || grade > 100) {
            throw new IllegalArgumentException("Grade must be between 0 and 100");
        }
        courses[numCourses] = course;
        grades[numCourses] = grade;
        numCourses++;
    }

    public void printGrades() {
        for (int i = 0; i < numCourses; i++) {
            System.out.println(courses[i] + ": " + grades[i]);
        }
    }

    public double getAverageGrade() {
        if (numCourses == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < numCourses; i++) {
            sum += grades[i];
        }
        return (double) sum / numCourses;
    }

    @Override
    public String toString() {
        return "Student: " + super.toString();
    }
}