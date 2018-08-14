package qasir.test.com;

import android.app.Application;
import android.content.Context;

/**
 * Created by Asad.
 */
public class MainApplication extends Application {

    private static final int TIMEOUT_MS = 10000; // 15second


    public static final String TAG = MainApplication.class.getSimpleName();

    private static MainApplication sApp;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

    }

    @Override
    public void onCreate() {
        super.onCreate();

        RetrofitUtil.init(this);

        sApp = this;
    }

    public static MainApplication getApp() {
        return sApp;
    }
}
