package com.example.payback;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class NetworkActivity extends Activity {
	int userPics[] = {R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher};
	static String netwArray[] = {"Keagan","Tiff","Wes","Ashley"};
	int iG;
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_network);
        final Activity thisActivity = this;
        
        TextView plus = (TextView)findViewById(R.id.plusButton);
        plus.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(thisActivity, AddBudActivity.class);
                //intent.putExtra(EXTRA_MESSAGE,)
                startActivity(intent);
			}
        	
        });
        
        
		for (int i=0; i<netwArray.length; i++){
			iG = i;
			LinearLayout ll = new LinearLayout(this);
			
			ll.setOrientation(LinearLayout.HORIZONTAL);
			ll.setBackgroundResource(R.drawable.thumbtackpaper);
			ll.setPadding(75, 0, 0, 0);

			
			userImageView profView = new userImageView(this,netwArray[i]);
			profView.setImageResource(userPics[0]);
			profView.setClickable(true);
			profView.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	Toast t = Toast.makeText(thisActivity, "friend!", Toast.LENGTH_SHORT);
	                t.show();
	                Intent intent = new Intent(thisActivity, UserTransActivity.class);
	                intent.putExtra(EXTRA_MESSAGE, ((userImageView)v).getUser());
	                startActivity(intent);
	            }
	        });
			
			TextView nameView = new TextView(this);
			nameView.setText(netwArray[i]);
			nameView.setTextSize(25);
			nameView.setPadding(30, 30, 30, 30);
			
			ll.addView(profView);
			ll.addView(nameView);
			
			LinearLayout transList = (LinearLayout)findViewById(R.id.scroll_list1);
	        transList.addView(ll);
			
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_network, menu);
		return true;
	}

}
