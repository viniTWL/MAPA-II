package br.edu.unicesumar.connection;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    public static Connection getConn(){

        DataSource dataSource = configureDataSource();

        try{
            Connection connection = dataSource.getConnection();
            if(connection == null){
                return connection;
            }
            else{
                return connection;
            }

        }catch (SQLException exception){
            JOptionPane.showMessageDialog(null, "Erro ao conectar no banco de dados.");
        }
        return null;
    }

    private static DataSource configureDataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setServerName("localhost");
        dataSource.setPort(3306);
        dataSource.setDatabaseName("mapa");
        dataSource.setUser("root");
        dataSource.setPassword("root123");
        return dataSource;
    }
}
