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
package yes.n.noes;

import yes.n.noes.data.Category;
import yes.n.noes.database.Database;
import yes.n.noes.fragment.YesNNoesFragment;
import yes.n.noes.func.AddDialog;
import yes.n.noes.func.AddDialog.OnAddListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;

public class YesNNoesActivity extends MenuActivity implements OnAddListener {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_yesnnoes);
		AddDialog.SetOnAddListener(this);

	}

	@Override
	public void menuAdd() {

		// Create the fragment and show it as a dialog.
		DialogFragment newFragment = AddDialog.newInstance();
		
		
			newFragment.show(getSupportFragmentManager(), "ADD_DIALOG");
		


	}

	public void AddCat(String addCat) {
		Database db = new Database(getApplicationContext());
		Category cat = new Category(0);
		cat.setName(addCat);
		db = new Database(getApplicationContext());
		db.openDatabase();
		db.insertCategory(cat);
		db.close();

		FragmentManager fManager = getSupportFragmentManager();
		YesNNoesFragment fragment = (YesNNoesFragment) fManager
				.findFragmentById(R.id.fragment_yesnnoes);

		if (fragment != null) {
			fragment.update();
		}
	}
}