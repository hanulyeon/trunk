	
package com.tmax.flowengine.adapter.dto;
import com.tmax.promapper.engine.base.Message;
import com.tmax.proobject.model.dataobject.DataObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.w3c.dom.Node;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;






public class AdapterInfoMsgJson extends Message {	

	public byte[] marshal(DataObject obj) throws Exception {			
		com.tmax.flowengine.adapter.dto.AdapterInfo _AdapterInfo = (com.tmax.flowengine.adapter.dto.AdapterInfo)obj;
		
		if(_AdapterInfo == null)
			return null;
		
		BufferedWriter bw = null;
		JsonWriter jw = null;
		
		try{
		    
    		ByteArrayOutputStream out = new ByteArrayOutputStream(); 
    		bw = new BufferedWriter( new OutputStreamWriter( out , this.encoding ) );        
    		jw = new JsonWriter( bw );
           	jw.beginObject();

    		marshal( _AdapterInfo, jw);
    		jw.endObject();
    		jw.close();
    		return out.toByteArray();
    		    	    		
		} finally{
		    if( jw != null ) jw.close();
		    if( bw != null ) bw.close();
		}								
	}
	
	
	public void marshal(com.tmax.flowengine.adapter.dto.AdapterInfo _AdapterInfo, JsonWriter writer )throws Exception{
	           
		
		writer.name("id"); 
		writer.value(_AdapterInfo.getId());
		
	
		if (_AdapterInfo.getName() != null) {
			writer.name("name"); 
			writer.value(_AdapterInfo.getName());
		}
	
		
	
		if (_AdapterInfo.getType() != null) {
			writer.name("type"); 
			writer.value(_AdapterInfo.getType());
		}
	
								  					
	}

	/**
     * do not use
     */
  	public void marshal(DataObject dataobject, Node node) throws Exception {          
  	}

  	public String removeNullChar(String charString) {
    		if( charString == null )
    			return "";
    		
			StringBuffer sb = new StringBuffer();
			for (int i = 0 ; i<charString.length(); i++) {
				if(charString.charAt(i) == (char)0) {
					sb.append("");
				} else {
					sb.append(charString.charAt(i));
				}
			}
			return sb.toString();
  	}
	
	public DataObject unmarshal(byte[] bytes, int i) throws Exception {
		
		com.tmax.flowengine.adapter.dto.AdapterInfo _AdapterInfo = new com.tmax.flowengine.adapter.dto.AdapterInfo();
		BufferedReader reader = null;
		JsonReader jr = null;
		
		if( bytes.length <= 0)
			return new com.tmax.flowengine.adapter.dto.AdapterInfo();
		
		try{
		reader = new BufferedReader( new InputStreamReader( new ByteArrayInputStream(bytes), this.encoding));		       
		jr = new JsonReader( reader );                
		jr.beginObject();
             


				_AdapterInfo = (com.tmax.flowengine.adapter.dto.AdapterInfo)unmarshal( jr,  _AdapterInfo);
     
             
		jr.endObject();
		jr.close();
			
		}finally{
		   	if( jr != null ) jr.close();
		    if( reader != null ) reader.close();
		}
		                       
        return _AdapterInfo;
	}
	
	
	// For PO7
	public DataObject unmarshal(byte[] bytes, DataObject dto) throws Exception {
		
		com.tmax.flowengine.adapter.dto.AdapterInfo _AdapterInfo = (com.tmax.flowengine.adapter.dto.AdapterInfo) dto;
		BufferedReader reader = null;
		JsonReader jr = null;
		
		if( bytes.length <= 0)
			return new com.tmax.flowengine.adapter.dto.AdapterInfo();
		
		try{
			reader = new BufferedReader( new InputStreamReader( new ByteArrayInputStream(bytes), this.encoding));		       
			jr = new JsonReader( reader );                
			jr.beginObject();


					_AdapterInfo = (com.tmax.flowengine.adapter.dto.AdapterInfo)unmarshal( jr,  _AdapterInfo);
         
		         
			jr.endObject();
			jr.close();
				
		}finally{
		   	if( jr != null ) jr.close();
		    if( reader != null ) reader.close();
		}
		                       
	    return _AdapterInfo;
	}
		
		 
	public DataObject unmarshal(JsonReader reader, com.tmax.flowengine.adapter.dto.AdapterInfo dto) throws Exception{

		while( reader.hasNext() ){
			String name = reader.nextName();			
			setField(dto, reader, name);
       	 }
		 
		 dto.clearAllIsModified();
		 
       	 return dto;
	}
		 
	protected void setField(com.tmax.flowengine.adapter.dto.AdapterInfo dto, JsonReader reader, String name) throws Exception{				
		
		switch(name) {		
	
		case "id" :
		{	
			dto.setId( reader.nextLong());									
			break;
		}	
	
			
	
		case "name" :
		{	
			dto.setName( reader.nextString());									
			break;
		}	
	
			
	
		case "type" :
		{	
			dto.setType( reader.nextString());									
			break;
		}	
	
		
		default :
			reader.skipValue();
			break;
		}
	}
		 
    /**
     * do not use
     */
	public int unmarshal(byte[] bytes, int i, DataObject dataobject){
		return -1;
	}
	
	/**
     * do not use
     */
	public DataObject unmarshal(Node node) throws Exception {
		return null;
	}
    
 	
}

