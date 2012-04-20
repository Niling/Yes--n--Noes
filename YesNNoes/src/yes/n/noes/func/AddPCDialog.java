package yes.n.noes.func;

import android.support.v4.app.DialogFragment;

public class AddPCDialog extends DialogFragment {
EditText ed;
	
	public interface OnAddListener{
		public void AddCat(String value);
	}
	
	private static OnAddListener listener;

	
	public static AddDialog newInstance(int title) {
		AddDialog frag = new AddDialog();
		Bundle args = new Bundle();
		args.putInt("title", title);
		frag.setArguments(args);
		return frag;
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		AlertDialog.Builder di = new AlertDialog.Builder(getActivity());
		ed=new EditText();
		
		di.setTitle("Add Category");
		di.setView(view)
		di.setPositiveButton("add", this);
		
		return null;

	}

	public void onClick(DialogInterface dialog, int button) {
		dialog.dismiss();
		
		if(button == DialogInterface.BUTTON_POSITIVE) {
			listener.AddCat();
		}
		
		
	}
	
	static void SetOnAddListener(OnAddListener listener){
		AddDialog.listener=listener;
	}
}
