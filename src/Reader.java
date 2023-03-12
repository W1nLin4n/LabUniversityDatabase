/*
 *  Program made by Artem Hrechka
 *
 *  Reader_v1.3, a simple reader to
 *  read ints, doubles, strings and
 *  chars from console and files
 *
 */

import java.io.*;

public class Reader {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static String readLine(){
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int readInt(){
        int res = 0;
        boolean correctInput = false;
        while(!correctInput){
            try {
                String line = readLine();
                res = Integer.parseInt(line);
                correctInput = true;
            }catch (Exception e){
                System.out.print("Incorrect input. Try again: ");
            }
        }
        return res;
    }

    public static int readInt(int low, int high){
        int res = 0;
        boolean correctInput = false;
        while(!correctInput){
            res = readInt();
            if(res >= low && res <= high)
                correctInput = true;
            else
                System.out.print("Incorrect input. Try again: ");
        }
        return res;
    }

    public static double readDouble(){
        double res = 0;
        boolean correctInput = false;
        while(!correctInput){
            try {
                String line = readLine();
                res = Double.parseDouble(line);
                correctInput = true;
            }catch (Exception e){
                System.out.print("Incorrect input. Try again: ");
            }
        }
        return res;
    }

    public static char readChar(){
        try {
            return br.readLine().charAt(0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void setFile(File file){
        try {
            br = new BufferedReader(new FileReader(file));
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public static void resetToConsole(){
        br = new BufferedReader(new InputStreamReader(System.in));
    }

}