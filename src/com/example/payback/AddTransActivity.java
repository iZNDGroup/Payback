package com.example.payback;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AddTransActivity extends Activity {

	EditText transName;
	EditText otherName;
	EditText amount;
	Activity thisActivity;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_trans);
		thisActivity =this;
		
		transName = (EditText)findViewById(R.id.inTransName);
		otherName = (EditText)findViewById(R.id.inOtherPerson);
		amount = (EditText)findViewById(R.id.inAmount);
		
		Button submit = (Button)findViewById(R.id.sub2);
		submit.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String stuff[][] = new String[TransactionsActivity.transArray.length+1][3];
				for(int i = 0;i<stuff.length-1;i++){
					stuff[i][0] = TransactionsActivity.transArray[i][0];
					stuff[i][1] = TransactionsActivity.transArray[i][1];
					stuff[i][2] = TransactionsActivity.transArray[i][2];
				}
				stuff[TransactionsActivity.transArray.length][0]= otherName.getText().toString();
				stuff[TransactionsActivity.transArray.length][1]= transName.getText().toString();
				stuff[TransactionsActivity.transArray.length][2]= amount.getText().toString();
				TransactionsActivity.transArray = stuff;
				
				Intent intent = new Intent(thisActivity, HomeActivity.class);
                startActivity(intent);
			}
			
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_add_trans, menu);
		return true;
	}

}
