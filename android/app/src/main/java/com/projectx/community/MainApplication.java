package com.projectx.community;
import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDex;

import com.facebook.react.PackageList;
import com.facebook.hermes.reactexecutor.HermesExecutorFactory;
import com.facebook.react.bridge.JavaScriptExecutorFactory;
import com.facebook.react.ReactApplication;
import com.oblador.vectoricons.VectorIconsPackage;
import com.horcrux.svg.SvgPackage;
import com.oblador.vectoricons.VectorIconsPackage;
import com.dooboolab.RNIap.RNIapPackage;
import com.zxcpoiu.incallmanager.InCallManagerPackage;
import com.reactnativecommunity.webview.RNCWebViewPackage;
import com.geektime.rnonesignalandroid.ReactNativeOneSignalPackage;
import com.facebook.react.bridge.JSIModulePackage;
import com.swmansion.reanimated.ReanimatedJSIModulePackage;
import com.projectx.community.BuildConfig;
import com.brentvatne.react.ReactVideoPackage;
import io.invertase.firebase.app.ReactNativeFirebaseAppPackage;

import io.invertase.firebase.analytics.ReactNativeFirebaseAnalyticsPackage;
import com.reactlibrary.RNPaypalPackage;
import org.devio.rn.splashscreen.SplashScreenReactPackage;
import com.reactnative.ivpusic.imagepicker.PickerPackage;
import com.swmansion.gesturehandler.react.RNGestureHandlerPackage;
import com.rt2zz.reactnativecontacts.ReactNativeContacts;
import com.dieam.reactnativepushnotification.ReactNativePushNotificationPackage;
import com.gettipsi.stripe.StripeReactPackage;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.soloader.SoLoader;
import java.lang.reflect.InvocationTargetException;
import com.imagepicker.ImagePickerPackage;
import com.airbnb.android.react.maps.MapsPackage;
import com.oney.WebRTCModule.WebRTCModulePackage;
// import com.giphyreactnativesdk.GiphyReactNativeSdkPackage;

import java.util.List;
import java.util.Arrays;

public class MainApplication extends Application implements ReactApplication {
  private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
    @Override
    public boolean getUseDeveloperSupport() {
      return BuildConfig.DEBUG;
    }

    @Override
    protected List<ReactPackage> getPackages() {
      @SuppressWarnings("UnnecessaryLocalVariable")
      List<ReactPackage> packages = new PackageList(this).getPackages();
      // Packages that cannot be autolinked yet can be added manually here, for example:
      packages.add(new StripeReactPackage());
      packages.add(new ReactVideoPackage());
      // packages.add(new GiphyReactNativeSdkPackage());
      return packages;
    }

    // @Override
    // protected  String getJSBundleFile() {
    //   return CodePush.getJSBundleFile();
    // }

    @Override
    protected String getJSMainModuleName() {
      return "index";
    }
    @Override
    protected JSIModulePackage getJSIModulePackage() {
      return new ReanimatedJSIModulePackage(); // <- add
    }
  };


  @Override
  public ReactNativeHost getReactNativeHost() {
    return mReactNativeHost;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    SoLoader.init(this, /* native exopackage */ false);
    // initializeFlipper(this); // Remove this line if you don't want Flipper enabled

  }

  @Override
  public void attachBaseContext(Context base) {
      super.attachBaseContext(base);
      MultiDex.install(this);
  }
    /**
   * Loads Flipper in React Native templates.
   *
   * @param context
   */
  private static void initializeFlipper(Context context) {
    if (BuildConfig.DEBUG) {
      try {
        /*
          We use reflection here to pick up the class that initializes Flipper,
        since Flipper library is not available in release mode
        */
        Class<?> aClass = Class.forName("com.facebook.flipper.ReactNativeFlipper");
        aClass.getMethod("initializeFlipper", Context.class).invoke(null, context);
      } catch (ClassNotFoundException e) {
        e.printStackTrace();
      } catch (NoSuchMethodException e) {
        e.printStackTrace();
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      } catch (InvocationTargetException e) {
        e.printStackTrace();
      }
    }
  }
}
