package yes.n.noes.func;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class AddPCDialog extends DialogFragment implements OnClickListener {

	public interface OnAddPCListener {
		public void AddPC(String value);
	}

	private static OnAddPCListener listener;

	public static AddPCDialog newInstance(int title) {
		AddPCDialog frag = new AddPCDialog();
		return frag;
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		AlertDialog.Builder di = new AlertDialog.Builder(getActivity());
		
		LayoutInflater inflater;
		inflater.infla;
		
		di.setTitle("Add Yes or No");
		di.setVi
		di.setPositiveButton("add", this);
		
		return null;

	}

	public void onClick(DialogInterface dialog, int button) {
		dialog.dismiss();

		if (button == DialogInterface.BUTTON_POSITIVE) {
			listener.AddCat();
		}

	}

	static void SetOnAddListener(OnAddListener listener) {
		AddDialog.listener = listener;
	}

	@Override
	public void onClick(DialogInterface dialog, int which) {
		// TODO Auto-generated method stub
		
	}
}
