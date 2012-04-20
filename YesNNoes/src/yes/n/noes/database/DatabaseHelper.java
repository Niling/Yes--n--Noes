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
				+ " (_id INTEGER PRIMARY KEY AUTOINCREMENT, category TEXT, state TEXT, name TEXT, comment TEXT, date TEXT);");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + MAIN_TABLE + "");
		db.execSQL("DROP TABLE IF EXISTS " + LIST_TABLE + "");

		onCreate(db);
	}

}
