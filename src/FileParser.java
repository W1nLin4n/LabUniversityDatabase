public class FileParser {

    public static void readUniversityData(University university){
        String line;
        int lineOffset;

        // Faculties
        line = Reader.readLine();
        assert(line.equals("Faculty"));
        line = Reader.readLine();

        while(!line.isEmpty()){
            lineOffset = 0;
            String facultyName = parseNextParam(line, lineOffset);

            university.addFaculty(new Faculty(facultyName));
        }


        // Departments
        line = Reader.readLine();
        assert(line.equals("Department"));
        line = Reader.readLine();

        while(!line.isEmpty()){
            lineOffset = 0;
            String departmentName = parseNextParam(line, lineOffset);
            lineOffset = skipParam(line, lineOffset);

            String facultyName = parseNextParam(line, lineOffset);

            Select.facultyByName(university.getFaculties(), facultyName).addDepartment(new Department(departmentName));
        }

        // Students
        line = Reader.readLine();
        assert(line.equals("Student"));
        line = Reader.readLine();

        while(!line.isEmpty()){
            lineOffset = 0;
            String studentName = parseNextParam(line, lineOffset);
            lineOffset = skipParam(line, lineOffset);

            int studentAge = Integer.parseInt(parseNextParam(line, lineOffset));
            lineOffset = skipParam(line, lineOffset);

            String departmentName = parseNextParam(line, lineOffset);
            lineOffset = skipParam(line, lineOffset);

            int studentYear = Integer.parseInt(parseNextParam(line, lineOffset));
            lineOffset = skipParam(line, lineOffset);

            String studentGroup = parseNextParam(line, lineOffset);

            Select.departmentByName(university.getDepartments(), departmentName).addStudent(new Student(studentName, studentAge, studentYear, studentGroup));
        }

        // Teachers
        line = Reader.readLine();
        assert(line.equals("Teacher"));
        line = Reader.readLine();

        while(!line.isEmpty()){
            lineOffset = 0;
            String studentName = parseNextParam(line, lineOffset);
            lineOffset = skipParam(line, lineOffset);

            int studentAge = Integer.parseInt(parseNextParam(line, lineOffset));
            lineOffset = skipParam(line, lineOffset);

            String departmentName = parseNextParam(line, lineOffset);

            Select.departmentByName(university.getDepartments(), departmentName).addTeacher(new Teacher(studentName, studentAge));
        }
    }

    private static String parseNextParam(String line, int offset){
        String result = "";
        while(offset < line.length() && line.charAt(offset) != ','){
            result += line.charAt(offset);
            offset++;
        }
        return result;
    }

    private static int skipParam(String line, int offset){
        while(offset < line.length() && line.charAt(offset) != ','){
            offset++;
        }
        return ++offset;
    }

}
