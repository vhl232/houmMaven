import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;

public class Main {
    private static class  User {
        String name;
        String fam;
        int data;

        public User() {
        }

        public User(String name, String fam, int data) {
            this.name = name;
            this.fam = fam;
            this.data = data;
        }
    }
    public static String stroca="1";
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        String creatTable = "CREATE TABLE  IF NOT EXISTS `data_base`.`new_table` (\n" +
                "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `imya` VARCHAR(45) NULL,\n" +
                "  `familii` VARCHAR(45) NULL,\n" +
                "  `dataRoghdeniya` INT NULL,\n" +
                "  PRIMARY KEY (`id`));\n";

        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data_base","root","1111");

        if(con != null){
            System.out.println("connected");
        }
        else return;
        Statement stm = con.createStatement();
        stm.execute(creatTable);


        BufferedReader chtenie = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<User> a = new ArrayList<User>();
        while (true){
            User user = new User();
            System.out.println("Vvedite imya:");
            user.name = chtenie.readLine();
            //a.add(stroca);
            if(user.name.equals("")){
                break;
            }
            System.out.println("Vevedite fam:");
            user.fam = chtenie.readLine();
            if(user.fam.equals("")){
                break;
            }
            System.out.println("Data roghdeniya:");

            String s = chtenie.readLine();
            if(s.equals("")){
                break;
            }
            user.data = Integer.parseInt(s);
            a.add(user);
        }
        String addUser = "INSERT INTO `data_base`.`new_table` " +
                "(`imya`, `familii`, `dataRoghdeniya`) VALUES ('%s', '%s', '%d');\n";

        for (int i = 0; i <a.size(); i++) {
            User u = a.get(i);
            //System.out.println();
            stm.execute(String.format(addUser,u.name,u.fam,u.data));

        }
        String raspech = " SELECT * FROM data_base.new_table;";


        print(stm.executeQuery(raspech));





        }
    private static void print(ResultSet set) throws SQLException {
        System.out.println("Printing results:");
        ResultSetMetaData rsmd = set.getMetaData();

        int columnsNumber = rsmd.getColumnCount();
        for (int i = 1; i <= columnsNumber; i++) {
            System.out.print("\t" + rsmd.getColumnName(i));
        }
        System.out.println();
        while (set.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i == 3 || i == 4) System.out.print("\t");
                String columnValue = set.getString(i);
                System.out.print("\t" + columnValue );
            }
            System.out.println("");
        }
    }



}
