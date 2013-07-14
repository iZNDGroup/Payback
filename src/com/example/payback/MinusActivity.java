package com.example.payback;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MinusActivity extends Activity {

	EditText transName;
	EditText otherName;
	Activity thisActivity;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_minus);
		transName = (EditText)findViewById(R.id.inTransName2);
		otherName = (EditText)findViewById(R.id.inOtherPerson2);
		thisActivity= this;
		
		Button submit = (Button)findViewById(R.id.sub3);
		submit.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String stuff[][] = new String[TransactionsActivity.transArray.length-1][3];
				boolean found = false;
				for(int i = 0;i<stuff.length+1;i++){
					if(TransactionsActivity.transArray[i][0].equals(otherName.getText().toString().trim())&&TransactionsActivity.transArray[i][1].equals(transName.getText().toString())){
						
					}else{
						if(!found){
							stuff[i][0] = TransactionsActivity.transArray[i][0];
							stuff[i][1] = TransactionsActivity.transArray[i][1];
							stuff[i][2] = TransactionsActivity.transArray[i][2];
						}else{
							stuff[i-1][0] = TransactionsActivity.transArray[i][0];
							stuff[i-1][1] = TransactionsActivity.transArray[i][1];
							stuff[i-1][2] = TransactionsActivity.transArray[i][2];
						
						}
					}
				}
				TransactionsActivity.transArray = stuff;
				
				Intent intent = new Intent(thisActivity, HomeActivity.class);
                startActivity(intent);
			}
			
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_minus, menu);
		return true;
	}

}
