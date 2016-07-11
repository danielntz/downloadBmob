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
 	 LocationDao      dao = null;    //�����ݿ���и��ֲ���
 	 private     int    hole_key = 0;       //����
 	 private   Button    huoquall;
 	 private  List<Location>  filedatabefore= new ArrayList<Location>();  //��ǰ����
 	 private List<Location>  filedataafeter = new ArrayList<Location>();    //֮�����
 	 private  Boolean    flag  = true;           //��һ�ζ�
 	 private  int   sizebefore ;                              //��ǰ�ĳ���
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

		 //��ѯ�����������ݣ�������ʾ1000������(bmob)
		public  void   findalldata(){
		        BmobQuery<Location> query = new BmobQuery<Location>();
		        query.findObjects(this	, new FindListener<Location>() {
					
					@Override
					public void onSuccess(List<Location> arg0) {
						// TODO Auto-generated method stub
						   Toast.makeText(getApplicationContext(), "��ȡ�ɹ���" + arg0.size() , 0).show();
						   try {
							new FileOperation().WriteFiledownload("sdcard/download.txt",arg0);    //�Ѷ�ȡ������д���ļ�
					    
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
						Toast.makeText(getApplicationContext(), "��ѯʧ��", 0).show();
					}
				});
		}
	
	 public void onStart(Intent intent, int startId) {
		 
		 
	 };
}
