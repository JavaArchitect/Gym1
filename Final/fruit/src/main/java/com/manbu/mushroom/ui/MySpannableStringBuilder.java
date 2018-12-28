package com.manbu.mushroom.ui;

import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;

public class MySpannableStringBuilder{
	
	public SpannableStringBuilder setText(String str,String tr){
		SpannableStringBuilder style = new SpannableStringBuilder(str);
		style.setSpan(new  StyleSpan(Typeface.BOLD), 0, str.length(), Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
		
		return style;
	}

}
