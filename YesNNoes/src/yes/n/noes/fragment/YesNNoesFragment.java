package yes.n.noes.fragment;

import java.util.ArrayList;

import yes.n.noes.data.Category;
import yes.n.noes.database.Database;
import yes.n.noes.func.AddDialog.OnAddListener;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class YesNNoesFragment extends ListFragment implements
		OnItemClickListener, OnAddListener {

	Database db;
	ArrayAdapter<String> adapter;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		// Now create a new list adapter bound to the cursor.
		// SimpleListAdapter is designed for binding to a Cursor.
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, new ArrayList<String>(0));

		// Bind to our new adapter.
		setListAdapter(adapter);
		getListView().setOnItemClickListener(this);

		update();
	}

	private void update() {
		if (!adapter.isEmpty()) {
			adapter.clear();
		}
		db = new Database(getActivity().getApplicationContext());
		db.openDatabase();
		ArrayList<Category> categorys = db.getCategories();

		for (Category loop : categorys) {
			adapter.add(loop.getName());
		}

		adapter.notifyDataSetChanged();

	}

	public void AddCat(String addCat) {
		Category cat = new Category(0);
		cat.setName(addCat);
		db = new Database(getActivity().getApplicationContext());
		db.openDatabase();
		db.insertCategory(cat);
		db.close();
		update();

	}

	public void onItemClick(AdapterView<?> parent, View v, int pos, long arg3) {

		Toast.makeText(getActivity().getApplicationContext(), "pressed" + pos,
				Toast.LENGTH_SHORT).show();

		// Intent intent= new Intent(this,Item_Activity.class);
		// int value=0;
		//
		//
		// intent.putExtra("cato", value);
		// startActivity(intent);

	}

}
