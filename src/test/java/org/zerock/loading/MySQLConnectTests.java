package org.zerock.loading;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class MySQLConnectTests {
	
	@Test
	public void testConnect() throws Exception {
		
		//MySQL 5.6 ������ com.mysql.jdbc.Driver
		//MySQL 6 over �� com.mysql.cj.jdbc.Driver
		Class<?> clz = Class.forName("com.mysql.cj.jdbc.Driver");
		log.info(clz);
		//URL , ����� ID, PW
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://10.10.10.149:3306/bitdb?serverTimezone=Asia/Seoul&useSSL=false",
				"bit04",
				"bit04");
		
		log.info(con);
		con.close();
	}
}
