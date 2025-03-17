package com.epf;

import java.io.FileInputStream;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.epf.persistance.Persistance;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;

public class Main {
    public static void main(String[] args) {
        String rootPath = "C:\\Ecole\\EPF 4ème année\\Semestre 8\\Langage Java\\TP\\TP 4\\src\\main\\resources\\";
        String appConfigPath = rootPath + "app.properties";

        System.out.println(String.format("\033cPath : %s\n", appConfigPath));

        Properties appProps = new Properties();
        try {
            appProps.load(new FileInputStream(appConfigPath));
        } catch (Exception e) {
            System.out.println(e);
        }

        String motDePasse = appProps.getProperty("mdp");
        String user = appProps.getProperty("usr");
        System.out.println(String.format("User : %s\nMot de Passe : %s\n    ", motDePasse, user));





        Logger root = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME); // pour enlever les messages de debug dans le terminal
        root.setLevel(Level.ERROR);

        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Persistance.class)) {
            JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
            
            String sql = "Show Tables"; 
            List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
            
            for (Map<String, Object> row : rows) {
                System.out.println(row);
            }
        }







        // String url = "jdbc:mysql://localhost:3306/pvz";
        // String username = "root";
        // String password = "";
        // try {
        //     Class.forName("com.mysql.cj.jdbc.Driver");

        //     Connection connection = DriverManager.getConnection(url, username, password);

        //     Statement statement = connection.createStatement();

        //     ResultSet resultSet = statement.executeQuery("SELECT * FROM zombie");

        //     while (resultSet.next()) {
        //         System.out.println(resultSet.getString("nom") + resultSet.getInt("point_de_vie"));
        //     }

        //     connection.close();
    
        // } catch (Exception e) {
        //     System.out.println(e);
        // }
    }
}
