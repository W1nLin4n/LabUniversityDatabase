
    import java.util.ArrayList;
import java.util.List;

    public class Main {
        public static void main(String[] args) {
            System.out.println("MENU\n1)Edit faculty.\n2)Edit department.");
            System.out.println("\n3)Edit students.\n4)Edit teachers.");
            int option =Reader.readInt(1,4);
            switch (option){
                case 1 :
                    System.out.println("1)Add faculty.\n2)Edit faculty\n3)Delete faculty.");
                    int mode =Reader.readInt(1,3);
                    switch (mode){
                        case 1:System.out.println("Enter the name of faculty:");
                        String facultyName=Reader.readLine();
                        break;
                        case 2:System.out.println("Choose the faculty to edit:");


                        case 3:System.out.println("Choose the faculty to delete:");
                    }
                    break;
                case 2:
                    System.out.println("1)Add department.\n2)Edit department\n3)Delete department.");
                    mode =Reader.readInt(1,3);
                    switch (mode){
                        case 1:System.out.println("Enter the name of department:");
                        case 2:System.out.println("Choose the department to edit:");
                        case 3:System.out.println("Choose the department to delete:");
                    }
                    break;
                case 3:
                    System.out.println("1)Add student.\n2)Edit student\n3)Delete student.\n4)Get students.\n5)Find student.");
                    mode =Reader.readInt(1,5);
                    switch (mode){
                        case 1:System.out.println("Enter the name of student:");
                            System.out.println("Enter the age of student:");
                            System.out.println("Enter the department of student:");
                            System.out.println("Enter the group of student:");
                            System.out.println("Enter the year of study of student:");
                            break;
                        case 2:System.out.println("Choose the student to edit:");
                        case 3:System.out.println("Choose the student to delete:");
                        case 4:System.out.println("Choose the way of getting list:\n1)By alphabetical order.\n2)By year of study.");
                        int way=Reader.readInt(1,2);
                        switch (way){
                            case 1:
                            case 2:
                        }
                        case 5:System.out.println("Enter the name of student:");
                    }
                    break;
                case 4:
                    System.out.println("1)Add teacher.\n2)Edit teacher\n3)Delete teacher.\n4)Get list of teachers by alphabetical order.\n5)Find teacher.");
                    mode =Reader.readInt(1,4);
                    mode =Reader.readInt(1,5);
                    switch (mode){
                        case 1:System.out.println("Enter the name of teacher:");
                            System.out.println("Enter the age of teacher:");
                            System.out.println("Enter the department of teacher:");
                            break;
                        case 2:System.out.println("Choose the teacher to edit:");
                        case 3:System.out.println("Choose the teacher to delete:");
                        case 4:
                        case 5:System.out.println("Enter the name of teacher:");
                    }
                    break;






    }

    }

}
