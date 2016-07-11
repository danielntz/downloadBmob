package com.example.jsontools;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.nihao.download.Location;

public class JSONToolsPackage {
     
	    private static final String TAG = null;

		public   JSONToolsPackage(){
	    	  
	      }
	
	     //��װ����JSON(����keyֵ)
	      public  String   createJson() throws JSONException{
	    	   
	    	          String   json;
	    	          JSONObject   jsonobject = new JSONObject();
	    	          JSONObject   jsontostring = new JSONObject();
	    	          jsonobject.put("name", "С��");
	    	          jsonobject.put("sex", "��");
	    	          jsonobject.put("age", 25);
	    	          jsontostring.put("Person", jsonobject);     //������jsonǰ����һ��keyֵ
	    	          Log.i(TAG, jsontostring.toString());
	    	          return  jsontostring.toString();
	    	     
	      }
	
	    //��װJSON����(����keyֵ)
	         public  String   createJsons() throws JSONException{
	        	     
	    	          JSONArray     jsonarray   = new JSONArray();
	    	          JSONObject   jsontostring = new JSONObject();
	    	          for(int i = 0 ; i < 5 ;i++){     //��װ5��json������һ������
	    	         JSONObject   jsonobject = new JSONObject();  
	    	          jsonobject.put("name", "С��" + i);
	    	          jsonobject.put("sex", "��" + i );
	    	          jsonobject.put("age", 25 + i);
	    	          jsonarray.put(jsonobject);
	    	          }
	    	          jsontostring.put("Person", jsonarray);     //������jsonǰ����һ��keyֵ
	    	          Log.i(TAG, jsontostring.toString());
	    	          return  jsontostring.toString();
	         }
	
	     //��װ����JSON(������keyֵ)
	         public  String   createJsonnokey() throws JSONException{
		    	   
   	          String   json;
   	          JSONObject   jsonobject = new JSONObject();
   	          JSONObject   jsontostring = new JSONObject();
   	          jsonobject.put("name", "С��");
   	          jsonobject.put("latitude", 345.454);
   	          jsonobject.put("longtitude", 25.23432);
   	          Log.i(TAG, jsonobject.toString());
   	          return jsonobject.toString();
   	     
     }
	    //��װJSON����(������keyֵ)
	         public  String   createJsonsnokey() throws JSONException{
	        	      String   json;
	    	          JSONArray     jsonarray   = new JSONArray();
	    	          JSONObject   jsontostring = new JSONObject();
	    	          for(int i = 0 ; i < 5 ;i++){     //��װ5��json������һ������
	    	         JSONObject   jsonobject = new JSONObject();  
	    	          jsonobject.put("name", "С��" + i);
	    	          jsonobject.put("sex", "��" + i );
	    	          jsonobject.put("age", 25 + i);
	    	          jsonarray.put(jsonobject);
	    	          }
	    	      Log.i(TAG, jsonarray.toString());
	    	      return  jsonarray.toString();
	         }
	   //��תjson����(������bmob������)
	          public  String createJsonsnokeybmob (List<Location> bmob) throws JSONException{
	        	      
	        	      String json;
	        	      JSONArray  array  = new JSONArray();
	        	      JSONObject  object = new JSONObject();
	        	      for(int i = 0 ;  i < bmob.size() ; i ++){
	        	    	      JSONObject  newobject = new JSONObject();
	        	    	      newobject.put("name", bmob.get(i).getOld_name());
	        	    	      newobject.put("latitude", bmob.get(i).getLatitude());
	        	    	      newobject.put("longtitude", bmob.get(i).getLongtitude());
	        	    	      array.put(newobject);
	        	      }
	        	  
	        	  
	        	  return array.toString();
	          }
}
