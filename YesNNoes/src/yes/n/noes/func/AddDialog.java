package yes.n.noes.func;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.EditText;

public class AddDialog extends DialogFragment implements OnClickListener {

	EditText ed;

	public interface OnAddListener {
		public void AddCat(String value);
	}

	private static OnAddListener listener;

	public static AddDialog newInstance() {
		AddDialog frag = new AddDialog();
		return frag;
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		AlertDialog.Builder di = new AlertDialog.Builder(getActivity());
		ed = new EditText(getActivity());

		di.setTitle("Add Category");
		di.setView(ed);
		di.setPositiveButton("add", this);
		di.setNegativeButton("cancel", this);

		return di.create();

	}

	public void onClick(DialogInterface dialog, int button) {
		dialog.dismiss();

		if (button == DialogInterface.BUTTON_POSITIVE) {
			listener.AddCat(ed.getText().toString());
		}

	}

	public static void SetOnAddListener(OnAddListener listener) {
		AddDialog.listener = listener;
	}
}
