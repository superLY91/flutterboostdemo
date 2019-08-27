package com.example.flutterboostdemo.flutter;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.example.flutterboostdemo.MainActivity;
import com.taobao.idlefish.flutterboost.Debuger;
import com.taobao.idlefish.flutterboost.FlutterBoostPlugin;
import com.taobao.idlefish.flutterboost.interfaces.IPlatform;

import java.util.Map;

import io.flutter.view.FlutterMain;

public class FlutterMediator {

    public static void init(final Application app) {
        // 此处必须启动初始化，主要是载入Flutter引擎文件
        FlutterMain.startInitialization(app);

        FlutterBoostPlugin.init(new IPlatform() {
            @Override
            public Application getApplication() {
                return app;
            }

            /**
             * 获取应用入口的Activity,这个Activity在应用交互期间应该是一直在栈底的
             * @return
             */
            @Override
            public Activity getMainActivity() {
                if (MainActivity.sRef != null) {
                    return MainActivity.sRef.get();
                }
                return null;
            }

            @Override
            public boolean isDebug() {
                return true;
            }

            /**
             * 如果flutter想打开一个本地页面，将会回调这个方法，页面参数将会拼接在url中
             *
             * 例如：sample://nativePage?aaa=bbb
             *
             * 参数就是类似 aaa=bbb 这样的键值对
             *
             * @param context
             * @param url
             * @param requestCode
             * @return
             */
            @Override
            public boolean startActivity(Context context, String url, int requestCode) {
                Debuger.log("startActivity url=" + url);
                return PageRouter.openPageByUrl(context, url, requestCode);
            }

            @Override
            public Map getSettings() {
                return null;
            }
        });
    }

}
