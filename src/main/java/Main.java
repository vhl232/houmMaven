import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static String stroca="1";
    public static void main(String[] args) throws IOException {

        BufferedReader chtenie = new BufferedReader(new InputStreamReader(System.in));

        ArrayList a = new ArrayList();
        while (stroca.length()!= 0){
            System.out.println("Vvedite imya:");
            stroca = chtenie.readLine();
            a.add(stroca);
            System.out.println("Vevedite fam:");
            stroca = chtenie.readLine();
            a.add(stroca);
            System.out.println("Data roghdeniya:");
            stroca = chtenie.readLine();
            a.add(stroca);
        }
        for (int i = 0; i <a.size() ; i++) {
            System.out.println(a.get(i));
        }



    }
}
