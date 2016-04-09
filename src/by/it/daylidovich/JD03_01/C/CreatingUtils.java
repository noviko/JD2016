package by.it.daylidovich.JD03_01.C;

import java.sql.SQLException;
import java.sql.Statement;

public class CreatingUtils {
    public static void createTable(Statement statement) throws SQLException {

        statement.executeUpdate("CREATE TABLE it-academy.role_d (\n" +
                "id INT NOT NULL AUTO_INCREMENT,\n" +
                "Role VARCHAR(50) NOT NULL,\n" +
                "PRIMARY KEY (id))\n" +
                "ENGINE = InnoDB\n" +
                "DEFAULT CHARACTER SET = utf8;\n");

        statement.executeUpdate("CREATE TABLE it-academy.countries_d (\n" +
                "id INT AUTO_INCREMENT,\n" +
                "Country VARCHAR(50) NOT NULL,\n" +
                "PRIMARY KEY (id))\n" +
                "ENGINE = InnoDB\n" +
                "DEFAULT CHARACTER SET = utf8;\n");

        statement.executeUpdate("CREATE TABLE it-academy.transport_d (\n" +
                "id INT AUTO_INCREMENT,\n" +
                "Transport VARCHAR(50) NOT NULL,\n" +
                "PRIMARY KEY (id))\n" +
                "ENGINE = InnoDB\n" +
                "DEFAULT CHARACTER SET = utf8;\n");

        statement.executeUpdate("CREATE TABLE it-academy.type_tour_d (\n" +
                "id INT AUTO_INCREMENT,\n" +
                "Type_tour VARCHAR(50) NOT NULL,\n" +
                "PRIMARY KEY (id))\n" +
                "ENGINE = InnoDB\n" +
                "DEFAULT CHARACTER SET = utf8;\n");

        statement.executeUpdate("CREATE TABLE it-academy.type_hotel_d (\n" +
                "id INT AUTO_INCREMENT,\n" +
                "Type_hotel VARCHAR(50) NOT NULL,\n" +
                "PRIMARY KEY (id))\n" +
                "ENGINE = InnoDB\n" +
                "DEFAULT CHARACTER SET = utf8;\n");

        statement.executeUpdate("CREATE TABLE it-academy.food_complex_d (\n" +
                "id INT AUTO_INCREMENT,\n" +
                "Food_complex VARCHAR(50) NOT NULL,\n" +
                "PRIMARY KEY (id))\n" +
                "ENGINE = InnoDB\n" +
                "DEFAULT CHARACTER SET = utf8;\n");

        statement.executeUpdate("CREATE TABLE it-academy.users_d (\n" +
                "id INT AUTO_INCREMENT,\n" +
                "Name VARCHAR(50) NOT NULL,\n" +
                "Surname VARCHAR(50) NOT NULL,\n" +
                "Email VARCHAR(50) NULL,\n" +
                "Login VARCHAR(50) NOT NULL,\n" +
                "Password VARCHAR(50) NOT NULL,\n" +
                "FK_role INT NOT NULL,\n" +
                "  PRIMARY KEY (id),\n" +
                "  INDEX FK_role_idx (id ASC),\n" +
                "  CONSTRAINT FK_role\n" +
                "    FOREIGN KEY (FK_role)\n" +
                "    REFERENCES it-academy.role_d (id)\n" +
                "    ON DELETE CASCADE\n" +
                "    ON UPDATE CASCADE)\n" +
                "ENGINE = InnoDB\n" +
                "DEFAULT CHARACTER SET = utf8;\n");

        statement.executeUpdate("CREATE TABLE it-academy.tours_d (\n" +
                "id INT AUTO_INCREMENT,\n" +
                "FK_country int(3) NOT NULL,\n" +
                "FK_type_tour int(1) NOT NULL,\n" +
                "FK_transport int(1) NOT NULL,\n" +
                "FK_type_hotel int(1) NOT NULL,\n" +
                "FK_food_complex int(1) NOT NULL,\n" +
                "Cost int NOT NULL,\n" +
                "Discount int NOT NULL,\n" +
                "  PRIMARY KEY (id),\n" +
                "  INDEX FK_country_idx (id ASC),\n" +
                "  INDEX FK_type_tour_idx (id ASC),\n" +
                "  INDEX FK_transport_idx (id ASC),\n" +
                "  INDEX FK_type_hotel_idx (id ASC),\n" +
                "  INDEX FK_food_complex_idx (id ASC),\n" +
                "  CONSTRAINT FK_country\n" +
                "    FOREIGN KEY (FK_country)\n" +
                "    REFERENCES it-academy.countries_d (id)\n" +
                "    ON DELETE CASCADE\n" +
                "    ON UPDATE CASCADE)\n" +
                "  CONSTRAINT FK_type_tour\n" +
                "    FOREIGN KEY (FK_type_tour)\n" +
                "    REFERENCES it-academy.type_tour_d (id)\n" +
                "    ON DELETE CASCADE\n" +
                "    ON UPDATE CASCADE)\n" +
                "  CONSTRAINT FK_transport\n" +
                "    FOREIGN KEY (FK_transport)\n" +
                "    REFERENCES it-academy.transport_d (id)\n" +
                "    ON DELETE CASCADE\n" +
                "    ON UPDATE CASCADE)\n" +
                "  CONSTRAINT FK_type_hotel\n" +
                "    FOREIGN KEY (FK_type_hotel)\n" +
                "    REFERENCES it-academy.type_hotel_d (id)\n" +
                "    ON DELETE CASCADE\n" +
                "    ON UPDATE CASCADE)\n" +
                "  CONSTRAINT FK_food_complex\n" +
                "    FOREIGN KEY (FK_food_complex)\n" +
                "    REFERENCES it-academy.food_complex_d (id)\n" +
                "    ON DELETE CASCADE\n" +
                "    ON UPDATE CASCADE)\n" +
                "ENGINE = InnoDB\n" +
                "DEFAULT CHARACTER SET = utf8;\n");

            statement.executeUpdate("CREATE TABLE it-academy.type_action_d (\n" +
                    "id INT AUTO_INCREMENT,\n" +
                    "Type_action VARCHAR(50) NOT NULL,\n" +
                    "PRIMARY KEY (id))\n" +
                    "ENGINE = InnoDB\n" +
                    "DEFAULT CHARACTER SET = utf8;\n");

            statement.executeUpdate("CREATE TABLE it-academy.action_d (\n" +
                    "id INT AUTO_INCREMENT,\n" +
                    "FK_action int(3) NOT NULL,\n" +
                    "FK_user int(3) NOT NULL,\n" +
                    "FK_tour int(3) NOT NULL,\n" +
                    "  PRIMARY KEY (id),\n" +
                    "  INDEX FK_action_idx (id ASC),\n" +
                    "  INDEX FK_user_idx (id ASC),\n" +
                    "  INDEX FK_tour_idx (id ASC),\n" +
                    "  CONSTRAINT FK_action\n" +
                    "    FOREIGN KEY (FK_action)\n" +
                    "    REFERENCES it-academy.type_action_d (id)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "  CONSTRAINT FK_user\n" +
                    "    FOREIGN KEY (FK_user)\n" +
                    "    REFERENCES it-academy.users_d (id)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "  CONSTRAINT FK_tour\n" +
                    "    FOREIGN KEY (FK_tour)\n" +
                    "    REFERENCES it-academy.tours_d (id)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB\n" +
                    "DEFAULT CHARACTER SET = utf8;\n");
    }

    public static void deleteTable(Statement statement) throws SQLException {
        statement.executeUpdate("DROP TABLE role_d");
        statement.executeUpdate("DROP TABLE countries_d");
        statement.executeUpdate("DROP TABLE transport_d");
        statement.executeUpdate("DROP TABLE type_tour_d");
        statement.executeUpdate("DROP TABLE type_hotel_d");
        statement.executeUpdate("DROP TABLE food_complex_d");
        statement.executeUpdate("DROP TABLE users_d");
        statement.executeUpdate("DROP TABLE tours_d");
        statement.executeUpdate("DROP TABLE type_action_d");
        statement.executeUpdate("DROP TABLE action_d");
    }

    public static void insertDataToTables(Statement statement) throws SQLException {
        statement.executeUpdate("insert into role(Role)\n" +
                "values ('administrator'),\n" +
                "('user')");

        statement.executeUpdate("insert into transport(Transport)\n" +
                "values\n" +
                "('aircraft'),\n" +
                "('water transport'),\n" +
                "('railway transport'),\n" +
                "('bus'),\n" +
                "('without transport')");

        statement.executeUpdate("insert into type_tour(Type_tour)\n" +
                "values\n" +
                "('relaxing'),\n" +
                "('travaling'),\n" +
                "('shopping')");

        statement.executeUpdate("insert into type_hotel(Type_hotel)\n" +
                "values\n" +
                "('3'),\n" +
                "('3+'),\n" +
                "('4'),\n" +
                "('4+'),\n" +
                "('5'),\n" +
                "('5+')");

        statement.executeUpdate("insert into food_complex(Food_complex)\n" +
                "values\n" +
                "('bed and breakfast'),\n" +
                "('breakfast and dinner'),\n" +
                "('breakfast lunch and dinner'),\n" +
                "('all inclusive'),\n" +
                "('without food')");

        statement.executeUpdate("insert into countries(Country)\n" +
                "values\n" +
                "('Egypt'),\n" +
                "('Spain'),\n" +
                "('Italy'),\n" +
                "('Montenegro'),\n" +
                "('Bulgaria')");

        statement.executeUpdate("insert into users(Name, Surname, Email, Login, Password, FK_Role)\n" +
                "values\n" +
                "('Dmitry', 'Dailidovich', 'dmitry.dailidovich@gmail.com', 'Dolf23', '123', 1),\n" +
                "('Ivan', 'Ivanov', 'Ivan.Ivanov@mail.ru', 'Ivan93', '1111', 2),\n" +
                "('Anastasia', 'Poleschyk', 'nastia95@inbox.ru', 'Nastenka', '2306' , 2)");

        statement.executeUpdate("insert into type_action_d(Type_action)\n" +
                "('Discount')\n" +
                "('Reserve')");
    }
}
