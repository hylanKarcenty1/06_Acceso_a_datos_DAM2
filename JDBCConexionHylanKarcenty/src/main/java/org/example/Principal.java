package org.example;

import java.io.IOException;
import java.sql.*;

/**
 * Hello world!
 *
 */
public class Principal {
    public static void main( String[] args ) throws SQLException {

        //Conectamos nuestro programa con la BBDD
        String user = "root";
        String pass = "1234";
        String url = "jdbc:mysql://localhost:3308/dam_api";

            Connection conn = DriverManager.getConnection(url,user,pass);
            System.out.println("Conexión correcta");



        //Preparamos la sentencia
        Statement sentencia = conn.createStatement();

        String sql1 = """
        SELECT * FROM alumnos
        """;

        ResultSet cursor    = sentencia.executeQuery(sql1);

        while (cursor.next()) {
            String nombre = cursor.getString("nombre");
            String email = cursor.getString("email");
            System.out.println(nombre + " - " + email);
        }

    }
}
