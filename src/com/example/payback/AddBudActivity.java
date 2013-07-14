package com.example.payback;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AddBudActivity extends Activity {
	Activity thisActivity;
	EditText uIn;
	Button submit;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_bud);
		thisActivity = this;
		
		uIn = (EditText)findViewById(R.id.userInputing);
		submit = (Button)findViewById(R.id.sub);
		submit.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String stuff[] = new String[NetworkActivity.netwArray.length+1];
				for(int i = 0;i<NetworkActivity.netwArray.length;i++){
					stuff[i] = NetworkActivity.netwArray[i];
				}
				stuff[NetworkActivity.netwArray.length] = uIn.getText().toString();
				NetworkActivity.netwArray = stuff;
				
				Intent intent = new Intent(thisActivity, HomeActivity.class);
                //intent.putExtra(EXTRA_MESSAGE,)
                startActivity(intent);
			}
			
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_add_bud, menu);
		return true;
	}

}
