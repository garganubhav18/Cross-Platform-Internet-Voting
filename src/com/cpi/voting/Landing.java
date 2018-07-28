package com.cpi.voting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
 
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
 
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
 
public class Landing extends ListActivity {
 
    // Progress Dialog
    private ProgressDialog pDialog;
 
    // Creating JSON Parser object
    JSONParser jParser = new JSONParser();
 
    ArrayList<HashMap<String, String>> nameList;
 
    // url to get all products list
    private static String url_ = "http://www.cpivoting.cpanel.byethost8.com/mobile/candidate_select.php";
    public static String detail[][]=new String[100][8]; 
    // JSON Node names
    private static int check=0;
    private static final String TAG_CNAME = "Cname";
    private static final String TAG_PARTY_NAME = "Pname";
    private static final String TAG_EDU = "Edu";
    private static final String TAG_PAST = "Past";
    private static final String TAG_ASSETS = "Assets";
    private static final String TAG_GEN = "Gen";
    private static final String TAG_AREA = "Area";
    private static final String TAG_SYMBOL = "Symbol";
    public static int pos=-1;
    JSONArray response = null;
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
 
        // Hashmap for ListView
        nameList = new ArrayList<HashMap<String, String>>();
 
        
        
        
        // Loading products in Background Thread
        new LoadAll().execute();
 
        // Get listview
        ListView lv = getListView();
       //lv.setOnItemClickListener(null);
       lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
           pos=position;
           Intent in=new Intent(Landing.this,Det.class);
           startActivity(in);
        	   
        	   
           }
       }
       );
   
       

       
 
    }
 
  
 
    /**
     * Background Async Task to Load all product by making HTTP Request
     * */
    class LoadAll extends AsyncTask<String, String, String> {
 
        /**
         * Before starting background thread Show Progress Dialog
         * */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(Landing.this);
            pDialog.setMessage("Loading . Please wait...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }
 
        /**
         * getting All products from url
         * */
        protected String doInBackground(String... args) {
            // Building Parameters
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            // getting JSON string from URL
            
            params.add(new BasicNameValuePair("locality", Otp.locality));
            
            
            
            
            try {
            	JSONObject json = jParser.makeHttpRequest(url_, "POST", params);
                    response = json.getJSONArray("data");
 
                 
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject c = response.getJSONObject(i);
                        
                        // Storing each json item in variable
                        String cname = c.getString(TAG_CNAME);
                        detail[i][0]=cname;
                        String party_name = c.getString(TAG_PARTY_NAME);
                        detail[i][1]=party_name;
                        String education = c.getString(TAG_EDU);
                        detail[i][2]=education;
                        String past_charges = c.getString(TAG_PAST);
                        detail[i][3]=past_charges;
                        String assets = c.getString(TAG_ASSETS);
                        detail[i][4]=assets;
                        String general_detail = c.getString(TAG_GEN);
                        detail[i][5]=general_detail;
                        String area = c.getString(TAG_AREA);
                        detail[i][6]=area;
                        String symbol = c.getString(TAG_SYMBOL);
                        detail[i][7]=symbol;
                        
  
                        // creating new HashMap
                        HashMap<String, String> map = new HashMap<String, String>();
 
                        // adding each child node to HashMap key => value
                        map.put(TAG_CNAME, cname);
                        map.put(TAG_PARTY_NAME, party_name);
 
                        // adding HashList to ArrayList
                        nameList.add(map);
                    }
                
            } catch (JSONException e) {
                check=1;
            	e.printStackTrace();
            }
            catch(Exception e)
            {
            	check=1;
            }
 
            return null;
        }
 
        /**
         * After completing background task Dismiss the progress dialog
         * **/
        protected void onPostExecute(String file_url) {
            // dismiss the dialog after getting all products
            pDialog.dismiss();
            // updating UI from Background Thread
            
            runOnUiThread(new Runnable() {
                public void run() {
                	if(check==1)
                	{
                		Toast.makeText(Landing.this, "Check Your Connection",Toast.LENGTH_LONG).show();
                		
                	}
                	else
                	{
                    /**
                     * Updating parsed JSON data into ListView
                     * */
                    ListAdapter adapter = new SimpleAdapter(
                           Landing.this, nameList,
                            R.layout.list_item, new String[] {
                                    TAG_CNAME,TAG_PARTY_NAME},
                            new int[] { R.id.unames, R.id.uroll});
                    // updating listview
                    setListAdapter(adapter);
                	}
                }
            });
 
        }
 
    }
}