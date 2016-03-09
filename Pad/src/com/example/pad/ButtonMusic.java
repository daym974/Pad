package com.example.pad;

import android.content.Context;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ButtonMusic extends android.widget.Button {

	private Button button;
	private int refSon;
	
	public ButtonMusic(Button button, int refSon) {
		super(null);
		this.button = button;
		this.refSon = refSon;
	}

	public int getRefSon() {
		return refSon;
	}

	public void setRefSon(int refSon) {
		this.refSon = refSon;
	}
	

}
