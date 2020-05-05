/*
 * Copyright 2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.mddarr.authentication.producers;


import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;
import java.util.*;

//import kafka.streams.interactive.query.avro.PlayEvent;

public class PurchaseEventProducer {

	public static void main(String... args) throws Exception {
		initProductsDB();
//		populateTopics();
	}

	private static void initProductsDB() {

		Statement stmt = null;
		Connection c = null;
		String row;
		String[] columns;
		UUID uuid;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager
					.getConnection("jdbc:postgresql://localhost:5433/productdb",
							"postgres", "postgres");
			BufferedReader br = new BufferedReader(new FileReader("stack/db/prods.csv"));
			while((row = br .readLine()) != null) {
				uuid = UUID.randomUUID();
				columns = row.split(",");
				stmt = c.createStatement();
				String sql = String.format("INSERT INTO product_entity (\"id\",\"brand\",\"imageurl\", \"name\",\"price\",\"quantity\") "
						+ "VALUES ('%s', '%s', '%s','%s', '%d','%d' );",uuid.toString(), columns[0], columns[3], columns[1], Long.parseLong(columns[2]), 10);
				stmt.executeUpdate(sql);
//				template1.sendDefault(uuid.toString(),new Product(uuid.toString(),columns[0], columns[1], Long.parseLong(columns[2])));
				System.out.println(columns[0]);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
		}
	}
}
