package mobileann.mafamily.utils;


import mobileann.mafamily.act.main.FS;

import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.mofind.android.base.L;
import com.mofind.android.net.HttpUtils;
import com.mofind.android.net.JSONParser;
import com.mofind.android.net.HttpUtils.HttpResultCallback;
import com.qq.e.ads.interstitial.AbstractInterstitialADListener;
import com.qq.e.ads.interstitial.InterstitialAD;
import com.qq.e.comm.managers.GDTADManager;

public class ADUtils{
	
	//**腾讯-广点通***********************************
	private static ADUtils instance = null;
	public static final String APPID = "1104879424";
	public static final String BannerPosID = "4050400600048383";
	public static final String APPWallPosID = "3020702630555559";
	public static final String SplashPosID = "3030606650854533";
	//----ADRIAN-------
	public static final String InterteristalPosID_MainEyeFragment = "9030302682455808";
//	public static final String InterteristalPosID_APPDetail = "1060109600159793"; // 没有用
	public static final String InterteristalPosID_APPDetail2 = "7080309622260083";  // 应用详情界面
	public static final String InterteristalPosID_MainMapActivity = "9010609602754861"; // 地图主界面
	public static final String InterteristalPosID_LocationTrackActivity = "3040000662255812"; // 足迹界面
	public static final String InterteristalPosID_LocationTrackListActivity = "3040702692550844"; // 足迹列表界面
	public static final String InterteristalPosID_LocationTrackListDetailActivity = "8000704622254836"; // 足迹详情界面
	
	//**百度-广告联盟*********************************
	public static final String BAIDU_AD_API_KEY = "Lqj2RVOjSD3xGWYzVIGGFujqS8A7VK9y";
	/**主界面-横幅*/
	public static final String BAIDU_MAINEYE_HORI_ID = "DBCc1BgHyDMpMxSEDa5yzbWV"; //推广位
	/**应用详情界面*/
	public static final String BAIDU_DETAILS_VERT_ID = "Eks0G2YK1pc0xI3GDEuKICWh"; //推广位
	/**地图定位界面*/
	public static final String BAIDU_LOCATION_VERT_ID = "zdK9KDGdTbvS2SZuSkcsXn8V"; //推广位
	/**足迹点界面*/
	public static final String BAIDU_TRACK_VERT_ID = "NCfowmI1vrFTcPOwnRFAmer5"; //推广位
	/**足迹列表界面*/
	public static final String BAIDU_TRACKLIST_VERT_ID = "vqF0ypXc3GGn7vCEHXE7vqBR"; //推广位
	/**足迹详情界面*/
	public static final String BAIDU_TRACKDETAIL_VERT_ID = "zbWaOp8nCXylFmIdj1SmjqK5"; //推广位
	
//	public static ADUtils getInstance() {
//		if (instance == null) {
//			instance = new ADUtils();
//		}
//		return instance;
//	}
//	
//	/**从服务器获取, 是否要显示广告 @ADRIAN.2015.10.20*/
//	public static void getIsShowAD(){
//		final String version=PhoneInfoUtils.getVersionCode(FS.getInstance());
//		final String channel=PhoneInfoUtils.getVersionChannel(FS.getInstance());
//		HttpUtils.startHttpGet(URLUtils.URL_TASK_GET+version+"_"+channel+"_ad", new HttpResultCallback() {
//
//			@Override
//			public void result(String url, boolean isResult, String jsonStr) {
//				if(isResult){
//					String json=TripleDESUtil.CBCDecode(version,channel, jsonStr);
//					if(TextUtils.isEmpty(json)){
//						SPUtils.setIsShowAD(true);
//					}else{
//						JSONObject jo = JSONParser.getJSONObject(json);
//						String status=JSONParser.getString(jo, "status");
//						if(TextUtils.isEmpty(status)){
//							String view=JSONParser.getString(jo, "view");
//							if(("true".equals(view))){
//								SPUtils.setIsShowAD(true);
//							}else{
//								SPUtils.setIsShowAD(false);
//							}
//						}else{
//							SPUtils.setIsShowAD(false);
//						}
//
//					}
//				}
//			}
//		});
//	}

}
