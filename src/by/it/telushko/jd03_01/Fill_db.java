package by.it.telushko.jd03_01;

import by.it.telushko.jd01.jd01_02.InOut;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

public class Fill_db {
    public static void fill_db(){
        try (Connection connection= DriverManager.getConnection (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement()) {

            String create_db="CREATE DATABASE IF NOT EXISTS `it_academy` ;";

            String create_accounts="CREATE TABLE IF NOT EXISTS`it_academy`.`accounts` ( `id` INT(8) NOT NULL AUTO_INCREMENT , `name` VARCHAR(45) NOT NULL ,`login` VARCHAR(45) NOT NULL ,`password` VARCHAR(45) NOT NULL ,`role` INT(2) NOT NULL , `email` VARCHAR(45) NOT NULL ,`phone` VARCHAR(45) NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;";
            String create_feedback="CREATE TABLE IF NOT EXISTS`it_academy`.`fk_feedback` ( `id` INT NOT NULL AUTO_INCREMENT , `feedback` VARCHAR(45) NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;";
            String create_status="CREATE TABLE IF NOT EXISTS`it_academy`.`fk_status` ( `id` INT NOT NULL AUTO_INCREMENT , `status` VARCHAR(45) NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;";
            String create_roles="CREATE TABLE IF NOT EXISTS`it_academy`.`fk_roles` ( `id` INT NOT NULL AUTO_INCREMENT , `role` VARCHAR(45) NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;";
            String create_vehicles="CREATE TABLE IF NOT EXISTS`it_academy`.`fk_vehicles` ( `id` INT(8) NOT NULL AUTO_INCREMENT , `brand` VARCHAR(45) NOT NULL , `model` VARCHAR(45) NOT NULL , `year` INT(4) NOT NULL , `owner` INT(8) NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;";
            String create_orders="CREATE TABLE IF NOT EXISTS`it_academy`.`orders` ( `id` INT(8) NOT NULL AUTO_INCREMENT , `vehicle` INT(8) NOT NULL , `status` INT(8) NOT NULL , `type` INT(8) NOT NULL , `feedback` INT(8) NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB; ";
            String create_types="CREATE TABLE IF NOT EXISTS`it_academy`.`fk_order_types` ( `id` INT(8) NOT NULL AUTO_INCREMENT , `order_type` VARCHAR(120) NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;";

            statement.execute(create_db);
            statement.executeUpdate(create_accounts);
            statement.executeUpdate(create_roles);
            statement.executeUpdate(create_vehicles);
            statement.executeUpdate(create_orders);
            statement.executeUpdate(create_types);
            statement.executeUpdate(create_status);
            statement.executeUpdate(create_feedback);

            statement.executeUpdate("INSERT INTO it_academy.accounts(name,login,password,role,email,phone) values ('Vladimir','lgn123','psswrd123',1,'vladimir@gmail.com','+375297570513')");
            statement.executeUpdate("INSERT INTO it_academy.accounts(name,login,password,role,email,phone) values ('Sergey','lgn456','psswrd456',2,'sergey@gmail.com','+375291057763')");
            statement.executeUpdate("INSERT INTO it_academy.accounts(name,login,password,role,email,phone) values ('Andrey','lgn789','psswrd789',2,'andrey@gmail.com','+375297040827')");

            statement.executeUpdate("INSERT INTO it_academy.fk_roles(role) values ('administrator')");
            statement.executeUpdate("INSERT INTO it_academy.fk_roles(role) values ('client')");

            statement.executeUpdate("INSERT INTO it_academy.fk_feedback(feedback) values ('bad')");
            statement.executeUpdate("INSERT INTO it_academy.fk_feedback(feedback) values ('normal')");
            statement.executeUpdate("INSERT INTO it_academy.fk_feedback(feedback) values ('good')");
            statement.executeUpdate("INSERT INTO it_academy.fk_feedback(feedback) values ('perfect')");

            statement.executeUpdate("INSERT INTO it_academy.fk_status(status) values ('placed')");
            statement.executeUpdate("INSERT INTO it_academy.fk_status(status) values ('accepted')");
            statement.executeUpdate("INSERT INTO it_academy.fk_status(status) values ('in_progress')");
            statement.executeUpdate("INSERT INTO it_academy.fk_status(status) values ('closed')");

            statement.executeUpdate("INSERT INTO it_academy.fk_order_types(order_type) values ('change engine oil')");
            statement.executeUpdate("INSERT INTO it_academy.fk_order_types(order_type) values ('change gearbox oil')");
            statement.executeUpdate("INSERT INTO it_academy.fk_order_types(order_type) values ('replace air filer ')");
            statement.executeUpdate("INSERT INTO it_academy.fk_order_types(order_type) values ('diagnose')");
            statement.executeUpdate("INSERT INTO it_academy.fk_order_types(order_type) values ('wash outside')");
            statement.executeUpdate("INSERT INTO it_academy.fk_order_types(order_type) values ('clean interior')");
            statement.executeUpdate("INSERT INTO it_academy.fk_order_types(order_type) values ('fill washer liquid')");

            HashMap <Integer,String> roles = new HashMap<>();
            ResultSet resultSet = statement.executeQuery("select * from it_academy.fk_roles;");
            while(resultSet.next()){
                int fk_role = resultSet.getInt("id");
                String fk_roleName = resultSet.getString("role");
                roles.put(resultSet.getInt("id"),resultSet.getString("role"));
            }
            resultSet =statement.executeQuery("select * from it_academy.accounts;");
            while (resultSet.next()){

                String fk_roleName=roles.get(resultSet.getInt("role"));

                String out = resultSet.getString("name")+" "+fk_roleName;
                System.out.println(out);
            }

            System.out.println("База даннных создана и заполнена служебной информацией(роли людей, виды работ, отзывов и т.д\nвведите что угодно и БД будет удалена)");
            InOut.consoleLineInput();
            statement.executeUpdate("DROP DATABASE it_academy");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
