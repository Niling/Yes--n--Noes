/*******************************************************************************
 *  Copyright 2012 Niklas Ekman and Marcus Ling
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *******************************************************************************/
package yes.n.noes.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Databas klass.
 * 
 * @author Niklas
 * 
 */
public class DatabaseHelper extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "yesnnoes.db";
	private static final int DATABASE_VERSION = 1;

	public static final String MAIN_TABLE = "category";
	public static final String LIST_TABLE = "list";

	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// Main
		db.execSQL("CREATE TABLE " + MAIN_TABLE
				+ " (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT);");

		// List
		db.execSQL("CREATE TABLE "
				+ LIST_TABLE
				+ " (_id INTEGER PRIMARY KEY AUTOINCREMENT, categoryId INTEGER, state INTEGER, name TEXT, comment TEXT, date TEXT);");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + MAIN_TABLE + "");
		db.execSQL("DROP TABLE IF EXISTS " + LIST_TABLE + "");

		onCreate(db);
	}

}
