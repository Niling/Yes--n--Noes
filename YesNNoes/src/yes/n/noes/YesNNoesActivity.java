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