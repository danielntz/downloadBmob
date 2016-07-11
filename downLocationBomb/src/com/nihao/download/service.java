package com.nihao.download;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

import com.example.file.FileOperation;
import com.example.jsontools.JSONToolsAnalysis;
import com.example.sqlite.LocationDao;
import com.example.sqlite.LocationSQLite;
import com.nihao.download.MainActivity.read;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Button;
import android.widget.Toast;

public class service  extends Service{
   
	
	protected static final String TAG = null;
	 private   String   ID;
 	 private   Button    uploadLocation;
 	 private   LocationSQLite   locationopenhelper = null;
 	 LocationDao      dao = null;    //对数据库进行各种操作
 	 private     int    hole_key = 0;       //主键
 	 private   Button    huoquall;
 	 private  List<Location>  filedatabefore= new ArrayList<Location>();  //先前读的
 	 private List<Location>  filedataafeter = new ArrayList<Location>();    //之后读的
 	 private  Boolean    flag  = true;           //第一次读
 	 private  int   sizebefore ;                              //先前的长度
 	 private  int   sizeafter  = 0;
 	 private  int   sizebemiddle;
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		
		return null;
	}
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		Bmob.initialize(this,"13197bceaa649971f7f0655de655885e");
		//new Thread(new read()).start();
	    
	   //  Toast.makeText(getApplicationContext(), "sdf", 0).show();
		findalldata();
	}

		 //查询表中所有数据，最多可显示1000组数据(bmob)
		public  void   findalldata(){
		        BmobQuery<Location> query = new BmobQuery<Location>();
		        query.findObjects(this	, new FindListener<Location>() {
					
					@Override
					public void onSuccess(List<Location> arg0) {
						// TODO Auto-generated method stub
						   Toast.makeText(getApplicationContext(), "获取成功共" + arg0.size() , 0).show();
						   try {
							new FileOperation().WriteFiledownload("sdcard/download.txt",arg0);    //把读取的数据写入文件
					    
						   } catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						   
									}
					
					@Override
					public void onError(int arg0, String arg1) {
						// TODO Auto-generated method stub
						Toast.makeText(getApplicationContext(), "查询失败", 0).show();
					}
				});
		}
	
	 public void onStart(Intent intent, int startId) {
		 
		 
	 };
}
