package yes.n.noes;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;


public class YesNNoesActivity extends ListActivity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        

        String[] lol={"hej","då"};
        // Now create a new list adapter bound to the cursor.
        // SimpleListAdapter is designed for binding to a Cursor.
        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,lol);

           

        // Bind to our new adapter.
        setListAdapter(adapter);
    }
}