package com.example.payback;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class UserTransActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_trans);
		Intent intent = getIntent();
		String userName = intent.getStringExtra(NetworkActivity.EXTRA_MESSAGE);
		
		double sum =0;
		for(int i=0; i<TransactionsActivity.transArray.length; i++){
			if(TransactionsActivity.transArray[i][0].equals(userName)){
				String current[] = TransactionsActivity.transArray[i];
				LinearLayout ll = new LinearLayout(this);
				
				ll.setOrientation(LinearLayout.HORIZONTAL);
				ll.setBackgroundResource(R.drawable.thumbtackpaper);
				ll.setPadding(75, 30, 0, 0);

				
				TextView userView = new TextView(this);
				userView.setText(current[0]);
				userView.setTextSize(15);
				userView.setPadding(5, 5, 5, 5);
				userView.setBackgroundResource(R.drawable.textborder3);

				
				TextView nameView = new TextView(this);
				nameView.setText(current[1]);
				nameView.setTextSize(15);
				nameView.setPadding(5, 5, 5, 5);
				nameView.setBackgroundResource(R.drawable.textborder3);

				
				TextView amountView = new TextView(this);
				amountView.setBackgroundResource(R.drawable.textborder3);
				double amount = Double.parseDouble(current[2]);

				if(amount > 0)
					amountView.setText("Lent: "+amount);
				else
					amountView.setText("Borrowed: "+Math.abs(amount));

				amountView.setTextSize(15);
				amountView.setPadding(5, 5, 5, 5);
				
				ll.addView(userView);
				ll.addView(nameView);
				ll.addView(amountView);
				ll.setVisibility(LinearLayout.VISIBLE);
				
		        LinearLayout transList = (LinearLayout)findViewById(R.id.scroll_list2);
		        transList.addView(ll);
		        
				sum += Double.parseDouble(TransactionsActivity.transArray[i][2]);

			}
		}
		TextView bal = (TextView)findViewById(R.id.balance);
		bal.setText("Balance:  $"+sum);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_user_trans, menu);
		return true;
	}

}
