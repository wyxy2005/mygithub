//package mobileann.mafamily.utils;
//
//import android.app.Activity;
//
//import com.mofind.android.base.L;
//import com.qq.e.ads.interstitial.AbstractInterstitialADListener;
//import com.qq.e.ads.interstitial.InterstitialAD;
//
//public class ADUtilsInterstitialAD {
//	
//	
//	private InterstitialAD iad;
//	
//	public ADUtilsInterstitialAD(Activity activity, String appid, String interpostid) {
//		iad = new InterstitialAD(activity, ADUtils.APPID, ADUtils.InterteristalPosID_MainMapActivity);
//	}
//	/** 显示广告 */
//	public void showAD() {
//		L.i("ad", "ADUtils#showAD");
//		iad.setADListener(new AbstractInterstitialADListener() {
//
//			@Override
//			public void onNoAD(int arg0) {
//				L.i("ad", "ADUtils#onNoAD");
//			}
//
//			@Override
//			public void onADReceive() {
//				L.i("ad", "ADUtils#onADReceive");
//				iad.show();
//			}
//		});
//		iad.loadAD();
//	}
//	
//	
//}
