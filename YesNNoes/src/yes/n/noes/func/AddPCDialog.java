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
<<<<<<< HEAD
 *******************************************************************************/
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
