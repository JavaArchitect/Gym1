package com.manbu.mushroom.activity;


import com.hanks.htextview.HTextView;
import com.hanks.htextview.HTextViewType;
import com.manbu.mushroom.R;
import com.manbu.mushroom.bean.MyUser;
import com.manbu.mushroom.common.BaseActivity;
import com.manbu.mushroom.ui.FlyTxtView;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.view.View;


@SuppressLint("HandlerLeak")
public class SplashActivity extends BaseActivity {
	private static final int GOTO_LOGIN = 100;
	private HTextView hTextView;

	public void setContentView() {
		setContentView(R.layout.splash_activity);
	}

	@Override
	public void initViews() {
		// TODO Auto-generated method stub
//		flytxtview = (FlyTxtView) findViewById(R.id.fly_txt);

		hTextView = (HTextView) findViewById(R.id.splash_action_text);
		hTextView.setAnimateType(HTextViewType.TYPER);
		hTextView.animateText("为您提供最好的服务");
	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub
//		showFlyTxet();
		
		Handler mHandler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				switch (msg.what) {
				case GOTO_LOGIN:
					goTOLogin();
					break;
				}
			}
		};
		mHandler.sendEmptyMessageDelayed(GOTO_LOGIN, 2000);
	}


	/**
	 * 
	* @Title: goTOLogin
	* @Description: TODO 跳转到登录界面
	* @return void    返回类型
	* @throws
	 */
	public void goTOLogin() {
		MyUser myUser = getUser();
		if (myUser != null) {
			Intent intent = new Intent(SplashActivity.this, MainActivity.class);
			intent.putExtra("selectPage",2);
			startActivity(intent);
			this.finish();
		} else {
			Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
			intent.putExtra("title", "登录");
			startActivity(intent);
			this.finish();
		}

	}

	/**
	 *
	 * @Title: showFlyTxet
	 * @Description: TODO(飞入文字的相关设置，大小、颜色、内容)
	 * @return void    返回类型
	 * @throws
	 */
	@Override
	public void initListeners() {

	}

	@Override
	public void onClick(View v) {

	}
}
