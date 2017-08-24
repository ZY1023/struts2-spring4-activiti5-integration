package com.informatics.dev.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.informatics.dev.model.Person;
import com.informatics.dev.model.PersonRecord;

public class PersonDAO {
	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_CONNECTION = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static final String DB_USER = "activitidb";
	private static final String DB_PASSWORD = "activitidb";

	private static Connection getDBConnection() {
		Connection dbConnection = null;
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
			return dbConnection;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return dbConnection;
	}

	public void addPerson(Person person) throws SQLException {
		Connection dbConnection = getDBConnection();
		Statement statement = dbConnection.createStatement();
		statement.executeUpdate("insert into person values (person_seq.nextval,'"
						+ person.getUserName() + "'," + person.getAge() + ",'"
						+ person.getEmail() + "','"+person.getUserName()+"')");

	}

	public List<PersonRecord> getPendingTasks() {
		List<PersonRecord> personRecords = new ArrayList<>();
		try {
			Connection dbConnection = getDBConnection();
			Statement statement = dbConnection.createStatement();
			ResultSet resultSet = statement.executeQuery(""
					+"select  pers.username, " 
					+"pers.age, " 
			        +"pers.email, " 
			        +"pers.businesskey, " 
			        +"act.task_id " 
					+"from ( "
					+"        select exc.business_key_,tsk.id_ task_id " 
					+"        from ACT_RU_EXECUTION exc,ACT_RU_TASK tsk "
					+"        where exc.proc_def_id_ = tsk.proc_def_id_ "
					+"        and exc.act_id_ = 'personUserTask') act , person pers "
					+"where   act.business_key_ = pers.businesskey");
			while (resultSet.next()) {
				Person person = new Person();
				person.setUserName(resultSet.getString("username"));
				person.setAge(Integer.valueOf(resultSet.getString("age")));
				person.setEmail(resultSet.getString("email"));
				personRecords.add(new PersonRecord(person, resultSet.getString("task_id"), resultSet.getString("businesskey")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return personRecords;
	}

	

}
