import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Faculty> faculties;

    public University(File input){
        faculties = new ArrayList<>();
        FileParser.readUniversityData(input, this);
    }

    public University(){
        faculties = new ArrayList<>();
    }

    /**
     * This method should add new faculty to university(must be unique by name)
     * @param faculty New faculty
     */
    public void addFaculty(Faculty faculty){
        faculties.add(faculty);
    }

    /**
     * This method should delete a faculty from university
     * @param faculty Faculty to delete
     */
    public void deleteFaculty(Faculty faculty){
        faculties.remove(faculty);
    }

    /**
     * This method should edit a faculty from university
     * @param oldFaculty Faculty to edit
     * @param newFaculty Parameters to change in faculty
     */
    public void editFaculty(Faculty oldFaculty, Faculty newFaculty){
        oldFaculty.setName(newFaculty.getName());
    }

    /**
     * This method should add new faculty to university(must be unique by name)
     * @param facultyName Name of faculty to add
     */
    public void addFaculty(String facultyName){
        if(Select.facultyByName(faculties, facultyName) == null)
            addFaculty(new Faculty(facultyName));
        else
            System.out.println("Faculty with this name already exists");
    }

    /**
     * This method should delete a faculty from university
     * @param facultyName Name of faculty to delete
     */
    public void deleteFaculty(String facultyName){
        Faculty faculty = Select.facultyByName(faculties, facultyName);
        if(faculty != null)
            deleteFaculty(faculty);
        else
            System.out.println("There is no faculty with this name");
    }

    /**
     * This method should edit a faculty from university
     * @param oldFacultyName Name of faculty to edit
     * @param newFacultyName New name of faculty
     */
    public void editFaculty(String oldFacultyName, String newFacultyName){
        if(Select.facultyByName(faculties, oldFacultyName) != null)
            if(Select.facultyByName(faculties, newFacultyName) == null || oldFacultyName.equals(newFacultyName))
                editFaculty(Select.facultyByName(faculties, oldFacultyName), new Faculty(newFacultyName));
            else
                System.out.println("Can't change the name because it's not unique");
        else
            System.out.println("There is no faculty with this name");
    }

    /**
     * This method should add new department to university(must be unique by name)
     * @param departmentName Name of department to add
     * @param facultyName Name of faculty to which department should be added
     */
    public void addDepartment(String departmentName, String facultyName){
        if(Select.departmentByName(getDepartments(), departmentName) == null)
            if(Select.facultyByName(faculties, facultyName) != null)
                Select.facultyByName(faculties, facultyName).addDepartment(new Department(departmentName));
            else
                System.out.println("There is no faculty with this name");
        else
            System.out.println("Department with this name already exists");
    }

    /**
     * This method should delete a department from university
     * @param departmentName Name of department to delete
     */
    public void deleteDepartment(String departmentName){
        Department department = Select.departmentByName(getDepartments(), departmentName);
        if(department != null)
            department.getFaculty().deleteDepartment(department);
        else
            System.out.println("There is no department with this name");
    }

    /**
     * This method should edit a department from this faculty
     * @param oldDepartmentName Name of department to edit
     * @param newDepartmentName New name of department
     */
    public void editDepartment(String oldDepartmentName, String newDepartmentName){
        if(Select.departmentByName(getDepartments(), oldDepartmentName) != null)
            if(Select.departmentByName(getDepartments(), newDepartmentName) == null || oldDepartmentName.equals(newDepartmentName))
                Select.departmentByName(getDepartments(), oldDepartmentName).getFaculty().editDepartment(Select.departmentByName(getDepartments(), oldDepartmentName), new Department(newDepartmentName));
            else
                System.out.println("Can't change the name because it's not unique");
        else
            System.out.println("There is no department with this name");
    }

    /**
     * This method should add new student to university(must be unique by name)
     * @param studentName Name of student to be added
     * @param studentAge Age of student to be added
     * @param departmentName Name of department to which student should be added
     * @param studentYear Year of study of student to be added
     * @param studentGroup Group of student to be added
     */
    public void addStudent(String studentName, int studentAge, String departmentName, int studentYear, String studentGroup){
        if(Select.studentByName(getStudents(), studentName) == null)
            if(Select.departmentByName(getDepartments(), departmentName) != null)
                Select.departmentByName(getDepartments(), departmentName).addStudent(new Student(studentName, studentAge, studentYear, studentGroup));
            else
                System.out.println("There is no department with this name");
        else
            System.out.println("Student with this name already exists");
    }

    /**
     * This method should delete a student from university
     * @param studentName Name of student to delete
     */
    public void deleteStudent(String studentName){
        Student student = Select.studentByName(getStudents(), studentName);
        if(student != null)
            student.getDepartment().deleteStudent(student);
        else
            System.out.println("There is no student with this name");
    }

    /**
     * This method should edit a student from university
     * @param oldStudentName Name of student to edit
     * @param newStudentName New name of student
     * @param newStudentAge New age of student
     * @param newStudentYear New year of study of student
     * @param newStudentGroup New group of student
     */
    public void editStudent(String oldStudentName, String newStudentName, int newStudentAge, int newStudentYear, String newStudentGroup){
        if(Select.studentByName(getStudents(), oldStudentName) != null)
            if(Select.studentByName(getStudents(), newStudentName) == null || oldStudentName.equals(newStudentName))
                Select.studentByName(getStudents(), oldStudentName).getDepartment().editStudent(Select.studentByName(getStudents(), oldStudentName), new Student(newStudentName, newStudentAge, newStudentYear, newStudentGroup));
            else
                System.out.println("Can't change the name because it's not unique");
        else
            System.out.println("There is no student with this name");
    }

    /**
     * This method should add new teacher to university(must be unique by name)
     * @param teacherName Name of teacher to be added
     * @param teacherAge Age of teacher to be added
     * @param departmentName Name of department to which teacher should be added
     */
    public void addTeacher(String teacherName, int teacherAge, String departmentName){
        if(Select.teacherByName(getTeachers(), teacherName) == null)
            if(Select.departmentByName(getDepartments(), departmentName) != null)
                Select.departmentByName(getDepartments(), departmentName).addTeacher(new Teacher(teacherName, teacherAge));
            else
                System.out.println("There is no department with this name");
        else
            System.out.println("Student with this name already exists");
    }

    /**
     * This method should delete a teacher from university
     * @param teacherName Name of teacher to delete
     */
    public void deleteTeacher(String teacherName){
        Teacher teacher = Select.teacherByName(getTeachers(), teacherName);
        if(teacher != null)
            teacher.getDepartment().deleteTeacher(teacher);
        else
            System.out.println("There is no teacher with this name");
    }

    /**
     * This method should edit a teacher from university
     * @param oldTeacherName Name of teacher to edit
     * @param newTeacherName New name of teacher
     * @param newTeacherAge New age of teacher
     */
    public void editTeacher(String oldTeacherName, String newTeacherName, int newTeacherAge){
        if(Select.teacherByName(getTeachers(), oldTeacherName) != null)
            if(Select.teacherByName(getTeachers(), newTeacherName) == null || oldTeacherName.equals(newTeacherName))
                Select.teacherByName(getTeachers(), oldTeacherName).getDepartment().editTeacher(Select.teacherByName(getTeachers(), oldTeacherName), new Teacher(newTeacherName, newTeacherAge));
            else
                System.out.println("Can't change the name because it's not unique");
        else
            System.out.println("There is no teacher with this name");
    }

    /**
     * Get all faculties
     * @return all faculties
     */
    public List<Faculty> getFaculties(){
        return faculties;
    }

    /**
     * Get all departments
     * @return all departments
     */
    public List<Department> getDepartments(){
        List<Department> result = new ArrayList<>();
        for(Faculty faculty : faculties){
            result.addAll(faculty.getDepartments());
        }
        return result;
    }

    /**
     * Get all students in university
     * @return all students
     */
    public List<Student> getStudents(){
        List<Student> result = new ArrayList<>();
        List<Department> departments = getDepartments();
        for(Department department : departments){
            result.addAll(department.getStudents());
        }
        return result;
    }

    /**
     * Get all teachers in university
     * @return all teachers
     */
    public List<Teacher> getTeachers(){
        List<Teacher> result = new ArrayList<>();
        List<Department> departments = getDepartments();
        for(Department department : departments){
            result.addAll(department.getTeachers());
        }
        return result;
    }

}