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

import java.util.ArrayList;

import yes.n.noes.data.Category;
import yes.n.noes.data.ProsCons;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Database {

	private DatabaseHelper db;
	private SQLiteDatabase dbLink;
	private final Context context;

	public Database(Context context) {
		this.context = context;

	}

	/**
	 * Opens database connection
	 */
	public void openDatabase() {
		db = new DatabaseHelper(context);
		dbLink = db.getWritableDatabase();
	}

	/**
	 * Closes database connection
	 */
	public void close() {
		if (dbLink.isOpen()) {
			dbLink.close();
		}

		db.close();
	}

	/**
	 * Gets all categories
	 * 
	 * @return
	 */
	public ArrayList<Category> getCategories() {
		Cursor results = dbLink.query(DatabaseHelper.MAIN_TABLE, null, null,
				null, null, null, null);

		if (!results.moveToFirst()) {
			return null;
		}

		ArrayList<Category> categories = new ArrayList<Category>(
				results.getCount());

		while (!results.isAfterLast()) {
			Category tmp = new Category(results.getInt(0));
			tmp.setName(results.getString(1));

			categories.add(tmp);

			results.moveToNext();
		}

		return categories;
	}

	/**
	 * Fetches all pros and cons from the database.
	 * 
	 * @param category
	 *            wich category?
	 * @return
	 */
	public ArrayList<ProsCons> getProsCons(Category category) {
		Cursor results = dbLink.query(DatabaseHelper.LIST_TABLE, null,
				"category=?", new String[] { category.getName() }, null, null,
				null);

		if (!results.moveToFirst()) {
			return null;
		}

		ArrayList<ProsCons> prosConsList = new ArrayList<ProsCons>(
				results.getCount());

		while (!results.moveToFirst()) {
			ProsCons tmp = new ProsCons(results.getInt(0), results.getInt(1));
			tmp.setState(results.getInt(2) > 0);
			tmp.setName(results.getString(3));
			tmp.setComment(results.getString(4));
			tmp.setDate(results.getString(5));

			prosConsList.add(tmp);

			results.moveToNext();
		}

		return prosConsList;
	}

	/**
	 * Inserts a category into main table
	 * 
	 * @param category
	 * @return
	 */
	public boolean insertCategory(Category category) {
		ContentValues values = new ContentValues();
		values.put("name", category.getName());

		return dbLink.insert(DatabaseHelper.MAIN_TABLE, null, values) > 0;
	}

	/**
	 * Inserts ProsCons into database.
	 * 
	 * @param pc
	 * @return
	 */
	public boolean insertProsCons(ProsCons pc) {
		ContentValues values = new ContentValues();
		values.put("categoryId", pc.getCategoryId());
		values.put("state", pc.getState() ? 1 : 0);
		values.put("name", pc.getName());
		values.put("comment", pc.getComment());
		values.put("date", pc.getDate());

		return dbLink.insert(DatabaseHelper.LIST_TABLE, null, values) > 0;
	}

	/**
	 * Delets a category
	 * 
	 * @param category
	 * @return
	 */
	public boolean deleteCategory(Category category) {
		return dbLink.delete(DatabaseHelper.MAIN_TABLE, "_id=?",
				new String[] { String.valueOf(category.getId()) }) > 0;

	}

	/**
	 * Delete ProsCons
	 * 
	 * @param pc
	 * @return
	 */
	public boolean deleteProsCons(ProsCons pc) {
		return dbLink.delete(DatabaseHelper.LIST_TABLE, "_id=?",
				new String[] { String.valueOf(pc.getId()) }) > 0;
	}

	/**
	 * Deletes all categories for a certain category.
	 * 
	 * @param category
	 * @return
	 */
	public boolean deleteAllProsConsForCategory(Category category) {
		return dbLink.delete(DatabaseHelper.LIST_TABLE, "categoryId=?",
				new String[] { String.valueOf(category.getId()) }) > 0;
	}
}
