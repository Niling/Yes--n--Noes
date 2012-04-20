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
package yes.n.noes.fragment;

import java.util.ArrayList;

import yes.n.noes.ItemActivity;
import yes.n.noes.data.Category;
import yes.n.noes.database.Database;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class YesNNoesFragment extends ListFragment implements
		OnItemClickListener {

	Database db;
	ArrayAdapter<String> adapter;
	ArrayList<Category> categories;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		// Now create a new list adapter bound to the cursor.
		// SimpleListAdapter is designed for binding to a Cursor.
		adapter = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, new ArrayList<String>(0));

		// Bind to our new adapter.
		setListAdapter(adapter);
		getListView().setOnItemClickListener(this);

		update();
	}

	public void update() {
		if (!adapter.isEmpty()) {
			adapter.clear();
		}
		db = new Database(getActivity().getApplicationContext());
		db.openDatabase();
		categories = db.getCategories();

		if (categories == null) {
			return;
		}

		for (Category loop : categories) {
			adapter.add(loop.getName());
		}

		adapter.notifyDataSetChanged();

	}

	public void onItemClick(AdapterView<?> parent, View v, int pos, long arg3) {

		int value = 0;
		Category temp = categories.get(pos);
		Intent intent = new Intent(getActivity().getApplicationContext(),
				ItemActivity.class);

		value = temp.getId();
		intent.putExtra("cato", value);
		startActivity(intent);
//öoasdasasdsa
	}

}
