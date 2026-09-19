import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
class B4
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        while (true) 
        { 
            System.out.println("\n==== Student Management System ====");   
            System.out.println("1. Add Students");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Marks"); 
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if(choice == 6)
            {
                System.out.println("Program exited");
                break;
            }

            if(choice == 1)
            {
                System.out.print("Enter ID: ");
                int id = sc.nextInt();

                sc.nextLine();

                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Marks: ");
                int marks = sc.nextInt();


                try
                {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "14022005");
                    String sql = "INSERT INTO student VALUES (?, ?, ?)";
                    PreparedStatement pstmt = con.prepareStatement(sql);

                    pstmt.setInt(1, id);
                    pstmt.setString(2, name);
                    pstmt.setInt(3, marks);

                    int row = pstmt.executeUpdate();

                    System.out.println("Student added: " + row);

                    pstmt.close();
                    con.close();

                }
                catch(SQLException e)
                {
                    System.out.println("Error: " + e.getMessage());
                }
            }

            if(choice == 2)
            {
                try
                {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "14022005");
                    String sql = "SELECT * FROM student";

                    PreparedStatement pstmt = con.prepareStatement(sql);
                    ResultSet rs = pstmt.executeQuery();

                    while(rs.next())
                    {
                        System.out.println("ID: " + rs.getInt("id") + " " + "Name: " + rs.getString("name") + " " + "Marks: " + rs.getInt("marks"));
                    }
                    rs.close();
                    pstmt.close();
                    con.close();
                }
                catch(SQLException e)
                {
                    System.out.println("Error: " + e.getMessage());
                }
            }

            if(choice == 3)
            {
                System.out.print("Enter ID to search: ");

                int id = sc.nextInt();

                try
                {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "14022005");
                    String sql = "SELECT *FROM student WHERE id = ?";
                    PreparedStatement pstmt = con.prepareStatement(sql);
                    pstmt.setInt(1, id);
                    ResultSet rs = pstmt.executeQuery();

                    if(rs.next())
                    {
                        System.out.print("ID: " + rs.getInt("id") + " " + "Name: " + rs.getString("name") + " " + "Marks: " + rs.getInt("marks"));
                    }
                    else
                    {
                        System.out.println("Student not found");
                    }

                    rs.close();
                    pstmt.close();
                    con.close();
                }
                catch(SQLException e)
                {
                    System.out.println("Error: " + e.getMessage());
                }
            }

            if(choice == 4)
            {
                System.out.print("Enter ID: ");
                int id = sc.nextInt();

                System.out.print("Enter new marks: ");
                int marks = sc.nextInt();

                try
                {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "14022005");
                    String sql = "UPDATE student SET marks = ? WHERE id = ?";

                    PreparedStatement pstmt = con.prepareStatement(sql);

                    pstmt.setInt(1, marks);
                    pstmt.setInt(2, id);

                    int rows = pstmt.executeUpdate();

                    System.out.println("Rows updated: " + rows);

                    pstmt.close();
                    con.close();
                }
                catch(SQLException e)
                {
                    System.out.println("Error: " + e.getMessage());
                }
            }


            if(choice == 5)
            {
                System.out.print("Enter ID to delete: ");
                int id = sc.nextInt();

                try
                {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "14022005");
                    String sql = "DELETE FROM student WHERE id = ?";

                    PreparedStatement pstmt = con.prepareStatement(sql);

                    pstmt.setInt(1, id);
                    int rows = pstmt.executeUpdate();
                    System.out.println("Row deleted: " + rows);
                    pstmt.close();
                    con.close();
                }
                catch(SQLException e)
                {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }

        sc.close();

    }
}