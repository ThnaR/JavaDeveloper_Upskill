public class Teacher extends Person {

    private int numCourses = 0;
    private String[] courses = new String[5];

    public Teacher(String name, String address) {
        super(name, address);
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name must not be null or blank");
        }
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("Address must not be null or blank");
        }

    }

    public boolean addCourse(String course) {
        if (course == null || course.isBlank()) {
            throw new IllegalArgumentException("Course name must not be null or blank");
        }
        for (int i = 0; i < numCourses; i++) {
            if (courses[i].equals(course)) {
                return false;
            }
        }
        if (numCourses < courses.length) {
            courses[numCourses] = course;
            numCourses++;
            return true;
        }
        return false;
    }

    public boolean removeCourse(String course) {
        for (int i = 0; i < numCourses; i++) {
            if (courses[i].equals(course)) {
                for (int j = i; j < numCourses - 1; j++) {
                    courses[j] = courses[j + 1];
                }
                courses[numCourses - 1] = null;
                numCourses--;
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Teacher: " + super.toString();
    }
}