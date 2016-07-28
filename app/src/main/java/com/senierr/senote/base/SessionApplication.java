package com.senierr.senote.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;

import java.util.ArrayList;
import java.util.List;

public class SessionApplication extends Application{

	private static Context context;
	private static SessionApplication application;
	// activity队列栈
	private static List<Activity> activities = new ArrayList<Activity>();

	@Override
	public void onCreate() {
		super.onCreate();
		context = getApplicationContext();
		application = this;
        // Fresco初始化
        ImagePipelineConfig config = ImagePipelineConfig.newBuilder(application)
                .setDownsampleEnabled(true) // 支持多种图片格式
                .build();
        Fresco.initialize(application, config);
	}

	public static SessionApplication getInstance() {
        return application;
    }

	/**
	 * 获取全局上下文
	 * @return
	 */
	public Context getContext() {
		return context;
	}

	/***** Activity管理 start ****/
	public void addActivity(Activity activity) {
		activities.add(activity);
	}

	public void removeActivity(Activity activity) {
		activities.remove(activity);
	}

	public void finishAll() {
		for (Activity activity : activities) {
			if (!activity.isFinishing()) {
				activity.finish();
			}
		}
	}
	/***** Activity管理 end ****/

}
