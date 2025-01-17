package com.example.frontflix;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.StrictMode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseManager {
    private DatabaseHelper dbHelper;
    private SQLiteDatabase database;

    public DatabaseManager(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public void open() {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public long addUser(String email, String senha) {
        ContentValues values = new ContentValues();
        values.put("email", email);
        values.put("senha", senha);

        return database.insert("pessoas", null, values);
    }

    public boolean authenticateUser(String email, String senha) {
        String[] columns = {"id"};
        String selection = "email = ? AND senha = ?";
        String[] selectionArgs = {email, senha};
        Cursor cursor = database.query("pessoas", columns, selection, selectionArgs, null, null, null);
        boolean authenticated = cursor.getCount() > 0;
        cursor.close();
        return authenticated;
    }

    public Cursor getUser(String email) {
        String[] columns = {"id", "email", "senha"};
        String selection = "email = ?";
        String[] selectionArgs = {email};

        return database.query("pessoas", columns, selection, selectionArgs, null, null, null);
    }
}



//public class DatabaseManager {
//    private SQLiteDatabase database;
//
//    public DatabaseManager(Context context) {
//        database = new DatabaseHelper(context).getWritableDatabase();
//    }
//
//    public boolean addUser(String email, String senha) {
//        ContentValues values = new ContentValues();
//        values.put(DatabaseHelper.COLUMN_EMAIL, email);
//        values.put(DatabaseHelper.COLUMN_SENHA, senha);
//
//        long result = database.insert(DatabaseHelper.TABLE_USERS, null, values);
//        return result != -1;
//    }
//
//    public boolean authenticateUser(String email, String senha) {
//        String[] columns = {DatabaseHelper.COLUMN_EMAIL};
//        String selection = DatabaseHelper.COLUMN_EMAIL + " = ? AND " + DatabaseHelper.COLUMN_SENHA + " = ?";
//        String[] selectionArgs = {email, senha};
//
//        Cursor cursor = database.query(DatabaseHelper.TABLE_USERS, columns, selection, selectionArgs, null, null, null);
//        boolean authenticated = cursor.getCount() > 0;
//        cursor.close();
//        return authenticated;
//    }
//}

//public class DatabaseManager {
//
//    private static final String URL = "jdbc:mysql://your_database_host:3306/your_database_name"; //aqui muda host e nome do database
//    private static final String USER = "your_database_user"; // bota o user aqui
//    private static final String PASSWORD = "your_database_password";// bota a senha aqui
//
//    public DatabaseManager() {
//        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
//        StrictMode.setThreadPolicy(policy);
//    }
//
//    private Connection getConnection() throws SQLException {
//        return DriverManager.getConnection(URL, USER, PASSWORD);
//    }
//
//    public void addPerson(String email, String senha) {
//        String query = "INSERT INTO pessoas (email, senha) VALUES (?, ?)";
//        try (Connection conn = getConnection();
//             PreparedStatement stmt = conn.prepareStatement(query)) {
//            stmt.setString(1, email);
//            stmt.setString(2, senha);
//            stmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void addFavorite(int pessoaId, int filmeId) {
//        String query = "INSERT INTO favoritos (pessoa_id, filme_id) VALUES (?, ?)";
//        try (Connection conn = getConnection();
//             PreparedStatement stmt = conn.prepareStatement(query)) {
//            stmt.setInt(1, pessoaId);
//            stmt.setInt(2, filmeId);
//            stmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void removeFavorite(int pessoaId, int filmeId) {
//        String query = "DELETE FROM favoritos WHERE pessoa_id = ? AND filme_id = ?";
//        try (Connection conn = getConnection();
//             PreparedStatement stmt = conn.prepareStatement(query)) {
//            stmt.setInt(1, pessoaId);
//            stmt.setInt(2, filmeId);
//            stmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public List<Integer> getFavorites(int pessoaId) {
//        List<Integer> favorites = new ArrayList<>();
//        String query = "SELECT filme_id FROM favoritos WHERE pessoa_id = ?";
//        try (Connection conn = getConnection();
//             PreparedStatement stmt = conn.prepareStatement(query)) {
//            stmt.setInt(1, pessoaId);
//            try (ResultSet rs = stmt.executeQuery()) {
//                while (rs.next()) {
//                    favorites.add(rs.getInt("filme_id"));
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return favorites;
//    }
//}
