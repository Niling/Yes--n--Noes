package yes.n.noes.func;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class AddDialog extends DialogFragment {

	public static AddDialog newInstance(int title) {
		AddDialog frag = new AddDialog();
		Bundle args = new Bundle();
		args.putInt("title", title);
		frag.setArguments(args);
		return frag;
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {

		
		
		return null;

	}
}
