package org.example.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {

    // Hàm khởi tạo cơ sở dữ liệu khi ứng dụng được khởi chạy
    public static void initializeDatabase() {
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) {
            System.out.println("Failed to connect to the database, unable to initialize.");
            return;
        }

        try (Statement statement = connection.createStatement()) {

            // 1. Kiểm tra và tạo bảng 'users' nếu chưa tồn tại
            if (!doesTableExist(connection, "USERS")) {
                createUsersTable(statement); // Tạo bảng users
                System.out.println("Table 'USERS' was created successfully.");
                createUserSequenceAndTrigger(statement); // Tạo Sequence và Trigger cho 'users'
            }

            // Thêm dữ liệu mặc định vào bảng 'users'
            if (isTableEmpty(statement, "USERS")) {
                insertDefaultUser(statement);
                System.out.println("Default user added to 'USERS' table.");
            }

            // 2. Kiểm tra và tạo bảng 'product' nếu chưa tồn tại
            if (!doesTableExist(connection, "PRODUCT")) {
                createProductsTable(statement); // Tạo bảng product
                System.out.println("Table 'PRODUCT' was created successfully.");
                createProductSequenceAndTrigger(statement); // Tạo Sequence và Trigger cho 'product'
            }

            // Thêm dữ liệu mặc định vào bảng 'product'
            if (isTableEmpty(statement, "PRODUCT")) {
                insertDefaultProducts(statement);
                System.out.println("Default products added to 'PRODUCT' table.");
            }

        } catch (SQLException e) {
            System.out.println("Error during database initialization: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }
    }

    // Tạo bảng 'users'
    private static void createUsersTable(Statement statement) throws SQLException {
        String createTableSQL = "CREATE TABLE USERS ("
                + "ID INTEGER NOT NULL, "
                + "USERNAME VARCHAR2(100) NOT NULL, "
                + "EMAIL VARCHAR2(100) UNIQUE NOT NULL, "
                + "PASSWORD VARCHAR2(255) NOT NULL, "
                + "CONSTRAINT USERS_PK PRIMARY KEY (ID)"
                + ")";
        statement.execute(createTableSQL);
    }

    // Tạo Sequence và Trigger cho bảng 'users'
    private static void createUserSequenceAndTrigger(Statement statement) throws SQLException {
        String createSequence = "CREATE SEQUENCE USER_SEQ START WITH 1 INCREMENT BY 1";
        statement.execute(createSequence);

        String createTrigger = "CREATE OR REPLACE TRIGGER USER_TRIGGER "
                + "BEFORE INSERT ON USERS "
                + "FOR EACH ROW "
                + "BEGIN "
                + "SELECT USER_SEQ.NEXTVAL INTO :NEW.ID FROM DUAL; "
                + "END;";
        statement.execute(createTrigger);
    }

    // Thêm dữ liệu mặc định vào bảng 'users'
    private static void insertDefaultUser(Statement statement) throws SQLException {
        String insertUserSQL = "INSERT INTO USERS (USERNAME, EMAIL, PASSWORD) "
                + "VALUES ('Admin', 'admin@example.com', 'admin123')";
        statement.execute(insertUserSQL);
    }

    // Tạo bảng 'product'
    private static void createProductsTable(Statement statement) throws SQLException {
        String createTableSQL = "CREATE TABLE PRODUCT ("
                + "ID INTEGER NOT NULL, "
                + "NAME VARCHAR2(150) NOT NULL, "
                + "DESCRIPTION CLOB, "
                + "PRICE NUMBER(10, 2) NOT NULL, "
                + "CONSTRAINT PRODUCT_PK PRIMARY KEY (ID)"
                + ")";
        statement.execute(createTableSQL);
    }

    // Tạo Sequence và Trigger cho bảng 'product'
    private static void createProductSequenceAndTrigger(Statement statement) throws SQLException {
        String createSequence = "CREATE SEQUENCE PRODUCT_SEQ START WITH 1 INCREMENT BY 1";
        statement.execute(createSequence);

        String createTrigger = "CREATE OR REPLACE TRIGGER PRODUCT_TRIGGER "
                + "BEFORE INSERT ON PRODUCT "
                + "FOR EACH ROW "
                + "BEGIN "
                + "SELECT PRODUCT_SEQ.NEXTVAL INTO :NEW.ID FROM DUAL; "
                + "END;";
        statement.execute(createTrigger);
    }

    // Thêm dữ liệu mặc định vào bảng 'product'
    private static void insertDefaultProducts(Statement statement) throws SQLException {
        String insertProductsSQL = "INSERT ALL "
                + "INTO PRODUCT (NAME, DESCRIPTION, PRICE) VALUES ('Product A', 'Description of Product A', 10.50) "
                + "INTO PRODUCT (NAME, DESCRIPTION, PRICE) VALUES ('Product B', 'Description of Product B', 20.00) "
                + "INTO PRODUCT (NAME, DESCRIPTION, PRICE) VALUES ('Product C', 'Description of Product C', 15.75) "
                + "SELECT * FROM DUAL";
        statement.execute(insertProductsSQL);
    }

    // Kiểm tra nếu bảng đã tồn tại trong cơ sở dữ liệu
    private static boolean doesTableExist(Connection connection, String tableName) throws SQLException {
        try (ResultSet resultSet = connection.getMetaData().getTables(null, null, tableName.toUpperCase(), null)) {
            return resultSet.next();
        }
    }

    // Kiểm tra nếu bảng trống
    private static boolean isTableEmpty(Statement statement, String tableName) throws SQLException {
        String query = "SELECT COUNT(*) FROM " + tableName;
        try (ResultSet resultSet = statement.executeQuery(query)) {
            return resultSet.next() && resultSet.getInt(1) == 0;
        }
    }

    // Hàm main để kiểm tra
    public static void main(String[] args) {
        initializeDatabase();
    }
}