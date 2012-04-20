package yes.n.noes;

import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MenuActivity extends FragmentActivity {

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle item selection
		switch (item.getItemId()) {
		case R.id.add:
			menuAdd();
			return true;
		case R.id.help:
			menuHelp();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
	
	public void menuAdd() {
		
	}
	
	public void menuHelp() {
		
	}

}
