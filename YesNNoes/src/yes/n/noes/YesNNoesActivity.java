package yes.n.noes;

import java.util.ArrayList;

import yes.n.noes.data.Category;
import yes.n.noes.database.Database;
import yes.n.noes.func.AddDialog;
import yes.n.noes.func.AddDialog.OnAddListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.Toast;

public class YesNNoesActivity extends MenuActivity implements
		OnItemClickListener,OnAddListener {

	Database db;
	ArrayAdapter<String> adapter;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Now create a new list adapter bound to the cursor.
		// SimpleListAdapter is designed for binding to a Cursor.
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, new ArrayList<String>(0));

		// Bind to our new adapter.
		setListAdapter(adapter);
		getListView().setOnItemClickListener(this);
		
		update();

	}
	
	private void update() {
		if(!adapter.isEmpty()) {
			adapter.clear();
		}
		db=new Database(getApplicationContext());
		db.openDatabase();
		ArrayList<Category> categorys= db.getCategories();
	
		for(Category loop:categorys){
			 adapter.add(loop.getName());
		}
		
		adapter.notifyDataSetChanged();
		
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
		

		    // Create the fragment and show it as a dialog.
		    DialogFragment newFragment = AddDialog.newInstance();
		    newFragment.show(, tag);
	
		db=new Database(getApplicationContext());
		db.openDatabase();
		db.insertCategory(null);
		
		
	}

	public void AddCat(String addCat) {
		Category cat=new Category(0);
		cat.setName(addCat);
		db=new Database(getApplicationContext());
		db.openDatabase();
		db.insertCategory(cat);
		db.close();
		update();
		
	}

}