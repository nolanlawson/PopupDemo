package com.nolanlawson.popupdemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.PopupWindow;

public class PopupDemoActivity extends Activity implements OnClickListener {
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button button1 = (Button) findViewById(android.R.id.button1);
        Button button2 = (Button) findViewById(android.R.id.button2);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

	@Override
	public void onClick(View anchorView) {
		
		PopupWindow window = PopupHelper.newBasicPopupWindow(this);
		
		LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		View popupView = inflater.inflate(R.layout.popup, null);
		
		window.setContentView(popupView);
		int totalHeight = getWindowManager().getDefaultDisplay().getHeight();
		int[] location = new int[2];
		anchorView.getLocationOnScreen(location);
		
		if (location[1] < (totalHeight / 2.0)) {
			// top half of screen
			window.setAnimationStyle(R.style.Animations_PopDownMenuRight);
			window.showAsDropDown(anchorView);
		} else { // bottom half
			PopupHelper.showLikeQuickAction(window, popupView, anchorView, getWindowManager(), 0, 0);
		}
		
	}
}