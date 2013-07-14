package com.example.payback;


import android.content.Context;
import android.widget.ImageView;

public class userImageView extends ImageView{
	String user;
	public userImageView(Context context, String u) {
		super(context);
		user = u;
		// TODO Auto-generated constructor stub
	}
	public String getUser(){
		return user;
	}

}
