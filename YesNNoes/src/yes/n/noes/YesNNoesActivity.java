package yes.n.noes;

import yes.n.noes.database.Database;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.Toast;

public class YesNNoesActivity extends MenuActivity implements
		OnItemClickListener {

	Database db;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Now create a new list adapter bound to the cursor.
		// SimpleListAdapter is designed for binding to a Cursor.
		ListAdapter adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, getlistItems());

		// Bind to our new adapter.
		setListAdapter(adapter);
		getListView().setOnItemClickListener(this);

	}

	private String[] getlistItems() {

		String[] lol = { "hej", "lol", "ROLF" };

		return lol;
	}

	public void onItemClick(AdapterView<?> parent, View v, int pos, long arg3) {

		Toast.makeText(this, "pressed" + pos, Toast.LENGTH_SHORT).show();

		// Intent intent= new Intent(this,Item_Activity.class);
		// int value=0;
		//
		//
		// intent.putExtra("cato", value);
		// startActivity(intent);

	}
	
	@Override
	public void menuAdd() {
		db=new Database(getApplicationContext());
		db.openDatabase();
		db.insertCategory(null);
		
	}

}