
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
                        case 1:
                        case 2:
                        case 3:
                    }
                    break;
                case 2:
                    System.out.println("1)Add department.\n2)Edit department\n3)Delete department.");
                    mode =Reader.readInt(1,3);
                    switch (mode){
                        case 1:
                        case 2:
                        case 3:
                    }
                case 3:
                    System.out.println("1)Add student.\n2)Edit student\n3)Delete student.\nSort students.");
                    mode =Reader.readInt(1,3);
                    switch (mode){
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                    }
                case 4:
                    System.out.println("1)Add teacher.\n2)Edit teacher\n3)Delete teacher.\nSort teachers.");
                    mode =Reader.readInt(1,3);
                    switch (mode){
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                    }





    }

    }

}
