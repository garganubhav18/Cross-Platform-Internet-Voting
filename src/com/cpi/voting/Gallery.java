package com.cpi.voting;





import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

 
public class Gallery extends ActionBarActivity implements OnItemClickListener  {
 
	private DrawerLayout drawerLayout;
	private ListView listView;
	private String[] options;
	private ActionBarDrawerToggle drawerListener;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
 
        options=getResources().getStringArray(R.array.options);
        listView=(ListView) findViewById(R.id.drawerList);
        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, options));
        listView.setOnItemClickListener(this);
        drawerLayout=(DrawerLayout) findViewById(R.id.drawerLayout);
        drawerListener = new ActionBarDrawerToggle(this, drawerLayout,R.drawable.ic_drawer1,R.string.drawer_open,R.string.drawer_close);
        drawerLayout.setDrawerListener(drawerListener);
        getActionBar().setHomeButtonEnabled(true);
        getActionBar().setDisplayHomeAsUpEnabled(true);
         
    }

	public void onConfigurationChanged(Configuration newConfig){
    	super.onConfigurationChanged(newConfig);
    	drawerListener.onConfigurationChanged(newConfig);
    }
	protected void onPostCreate(Bundle savedInstanceState)
	{
		super.onPostCreate(savedInstanceState);
		drawerListener.syncState();
	}



	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		if(drawerListener.onOptionsItemSelected(item))
        {
        	return true;
        }
    	int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
	}

	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		// TODO Auto-generated method stub
				//Toast.makeText(this, options[position], Toast.LENGTH_SHORT).show();
				selectItem(position);

				// TODO Auto-generated method stub
				if(position==0)
				{
					//Toast.makeText(this, options[position], Toast.LENGTH_LONG).show();
					Intent intent= new Intent(Gallery.this,MainActivity.class);
					Gallery.this.startActivity(intent);
					selectItem(position);
					finish();
				}
				if(position==1)
				{
					//Toast.makeText(this, options[position], Toast.LENGTH_LONG).show();
					Intent intent= new Intent(Gallery.this,About.class);
					Gallery.this.startActivity(intent);
					selectItem(position);
					finish();
				}
				
				if(position==3)
				{
					//Toast.makeText(this, options[position], Toast.LENGTH_LONG).show();
					Intent intent= new Intent(Gallery.this,Priv.class);
					Gallery.this.startActivity(intent);
					selectItem(position);
					finish();
					
				}
				if(position==4)
				{
					//Toast.makeText(this, options[position], Toast.LENGTH_LONG).show();
					Intent intent= new Intent(Gallery.this,Faq.class);
					Gallery.this.startActivity(intent);
					selectItem(position);
					finish();
					
				}
				if(position==5)
				{
					//Toast.makeText(this, options[position], Toast.LENGTH_LONG).show();
					Intent intent= new Intent(Gallery.this,Contact.class);
					Gallery.this.startActivity(intent);
					selectItem(position);
					finish();
		   		}
				
				/*if(position==7)
				{
					selectItem(position);
					//Toast.makeText(this, options[position]+" is selected", Toast.LENGTH_LONG).show();
					
					dbhses infosesi =new dbhses(About.this);
		     		//String[] data= new String[10];
		     		infosesi.open();
		     		//data = info.getData();
		     		//info.close();
		     	
		     		infosesi.deleteEntry();
		         	        infosesi.close();
		        
		         	        
		          	       try{MainActivity.fa.finish();}
		          	      catch(Exception e){}
		          	      try{
		             	       AndroidGridLayoutActivity1.fa.finish();
		             	      }catch(Exception e){}
		             	      try{AndroidGridLayoutActivity2.fa.finish();}
		             	      catch(Exception e){}
		    	         	    try{AndroidGridLayoutActivity3.fa.finish();}
		    	         	   catch(Exception e){}
		    	         	   try{AndroidGridLayoutActivity4.fa.finish();}
		    	         	  catch(Exception e){}
					finish();
		            System.exit(0);
		   		}*/
	}
	private void selectItem(int position) {
		// TODO Auto-generated method stub
		listView.setItemChecked(position, true);
		setTitle(options[position]);
	}
	public void setTitle(String title)
	{
		getActionBar().setTitle(title);
	}

}


