package raExample.util;

import java.sql.*;

public class JDBCExample1 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/quanlythuvien";
        String user = "root";
        String password = "123456";

        try {
            // Tải Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Thiết lập Kết Nối
            Connection connection = DriverManager.getConnection(url, user, password);

            // Tạo đối tượng Statement
            Statement statement = connection.createStatement();

            // Thực thi truy vấn
            ResultSet resultSet = statement.executeQuery("SELECT * FROM book");

            // Lấy metadata từ ResultSet
            ResultSetMetaData metaData = resultSet.getMetaData();

            // Lấy số lượng cột trong ResultSet
            int columnCount = metaData.getColumnCount();

            // In tên các cột
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(metaData.getColumnName(i) + "\t");
            }
            System.out.println();

            // In dữ liệu từ ResultSet
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(resultSet.getString(i) + "\t");
                }
                System.out.println();
            }

            // Đóng kết nối
            resultSet.close();
            statement.close();
            connection.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
