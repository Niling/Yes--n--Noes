package yes.n.noes.database;

import java.util.ArrayList;

import yes.n.noes.data.Category;
import yes.n.noes.data.ProsCons;

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

	public void openDatabase() {
		db = new DatabaseHelper(context);
		dbLink = db.getWritableDatabase();
	}

	public void close() {
		if (dbLink.isOpen()) {
			dbLink.close();
		}

		db.close();
	}

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

	public ArrayList<ProsCons> getProsCons(Category category) {
		Cursor results = dbLink.query(DatabaseHelper.LIST_TABLE, null,
				"category=?", new String[] { category.getName() }, null, null,
				null);
		
		if(!results.moveToFirst()) {
			return null;
		}
		
		ArrayList<ProsCons> prosConsList = new ArrayList<ProsCons>(results.getCount());
		
		while(!results.moveToFirst()) {
			ProsCons tmp = new ProsCons(results.getInt(0), results.getString(1), results.getString(2));
			tmp.setName(results.getString(3));
			tmp.setComment(results.getString(4));
			tmp.setDate(results.getString(5));
			
			prosConsList.add(tmp);
			
			results.moveToNext();
		}
		
		return prosConsList;
	}

}
