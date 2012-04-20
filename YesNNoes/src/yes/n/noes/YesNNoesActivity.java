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

public class YesNNoesActivity extends MenuActivity {
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_yesnnoes);

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

}