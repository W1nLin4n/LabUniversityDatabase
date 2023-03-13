import java.io.File;

public class FileParser {

    public static void readUniversityData(File input, University university){
        Reader.setFile(input);
        String line;
        int lineOffset;

        // Faculties
        line = Reader.readLine();
        assert(line.equals("Faculty"));
        line = Reader.readLine();

        while(!line.isEmpty()){
            lineOffset = 0;
            String facultyName = parseNextParam(line, lineOffset);

            university.addFaculty(facultyName);
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

            university.addDepartment(departmentName, facultyName);
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

            university.addStudent(studentName, studentAge, departmentName, studentYear, studentGroup);
        }

        // Teachers
        line = Reader.readLine();
        assert(line.equals("Teacher"));
        line = Reader.readLine();

        while(!line.isEmpty()){
            lineOffset = 0;
            String teacherName = parseNextParam(line, lineOffset);
            lineOffset = skipParam(line, lineOffset);

            int teacherAge = Integer.parseInt(parseNextParam(line, lineOffset));
            lineOffset = skipParam(line, lineOffset);

            String departmentName = parseNextParam(line, lineOffset);

            university.addTeacher(teacherName, teacherAge, departmentName);
        }
        Reader.resetToConsole();
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
