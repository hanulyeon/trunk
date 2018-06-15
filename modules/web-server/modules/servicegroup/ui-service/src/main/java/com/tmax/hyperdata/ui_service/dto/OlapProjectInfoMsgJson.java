	
package com.tmax.hyperdata.ui_service.dto;
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




import java.sql.Timestamp;


public class OlapProjectInfoMsgJson extends Message {	

	public byte[] marshal(DataObject obj) throws Exception {			
		com.tmax.hyperdata.ui_service.dto.OlapProjectInfo _OlapProjectInfo = (com.tmax.hyperdata.ui_service.dto.OlapProjectInfo)obj;
		
		if(_OlapProjectInfo == null)
			return null;
		
		BufferedWriter bw = null;
		JsonWriter jw = null;
		
		try{
		    
    		ByteArrayOutputStream out = new ByteArrayOutputStream(); 
    		bw = new BufferedWriter( new OutputStreamWriter( out , this.encoding ) );        
    		jw = new JsonWriter( bw );
           	jw.beginObject();

    		marshal( _OlapProjectInfo, jw);
    		jw.endObject();
    		jw.close();
    		return out.toByteArray();
    		    	    		
		} finally{
		    if( jw != null ) jw.close();
		    if( bw != null ) bw.close();
		}								
	}
	
	
	public void marshal(com.tmax.hyperdata.ui_service.dto.OlapProjectInfo _OlapProjectInfo, JsonWriter writer )throws Exception{
	           
		
	
		if (_OlapProjectInfo.getName() != null) {
			writer.name("name"); 
			writer.value(_OlapProjectInfo.getName());
		}
	
		
		writer.name("id"); 
		writer.value(_OlapProjectInfo.getId());
		
	
		if (_OlapProjectInfo.getAuthor() != null) {
			writer.name("author"); 
			writer.value(_OlapProjectInfo.getAuthor());
		}
	
	
	
		java.text.SimpleDateFormat df = null;								
	
		if (_OlapProjectInfo.getLastEdited() != null) {
			writer.name("lastEdited"); 

			df = new java.text.SimpleDateFormat("yyyy.MM.dd HH.mm.ss");		
			writer.value(df.format(_OlapProjectInfo.getLastEdited()));
		}
		
	
		if (_OlapProjectInfo.getContents() != null) {
			writer.name("contents"); 
			writer.value(_OlapProjectInfo.getContents());
		}
	
		
	
		if (_OlapProjectInfo.getDescription() != null) {
			writer.name("description"); 
			writer.value(_OlapProjectInfo.getDescription());
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
		
		com.tmax.hyperdata.ui_service.dto.OlapProjectInfo _OlapProjectInfo = new com.tmax.hyperdata.ui_service.dto.OlapProjectInfo();
		BufferedReader reader = null;
		JsonReader jr = null;
		
		if( bytes.length <= 0)
			return new com.tmax.hyperdata.ui_service.dto.OlapProjectInfo();
		
		try{
		reader = new BufferedReader( new InputStreamReader( new ByteArrayInputStream(bytes), this.encoding));		       
		jr = new JsonReader( reader );                
		jr.beginObject();
             


				_OlapProjectInfo = (com.tmax.hyperdata.ui_service.dto.OlapProjectInfo)unmarshal( jr,  _OlapProjectInfo);
     
             
		jr.endObject();
		jr.close();
			
		}finally{
		   	if( jr != null ) jr.close();
		    if( reader != null ) reader.close();
		}
		                       
        return _OlapProjectInfo;
	}
	
	
	// For PO7
	public DataObject unmarshal(byte[] bytes, DataObject dto) throws Exception {
		
		com.tmax.hyperdata.ui_service.dto.OlapProjectInfo _OlapProjectInfo = (com.tmax.hyperdata.ui_service.dto.OlapProjectInfo) dto;
		BufferedReader reader = null;
		JsonReader jr = null;
		
		if( bytes.length <= 0)
			return new com.tmax.hyperdata.ui_service.dto.OlapProjectInfo();
		
		try{
			reader = new BufferedReader( new InputStreamReader( new ByteArrayInputStream(bytes), this.encoding));		       
			jr = new JsonReader( reader );                
			jr.beginObject();


					_OlapProjectInfo = (com.tmax.hyperdata.ui_service.dto.OlapProjectInfo)unmarshal( jr,  _OlapProjectInfo);
         
		         
			jr.endObject();
			jr.close();
				
		}finally{
		   	if( jr != null ) jr.close();
		    if( reader != null ) reader.close();
		}
		                       
	    return _OlapProjectInfo;
	}
		
		 
	public DataObject unmarshal(JsonReader reader, com.tmax.hyperdata.ui_service.dto.OlapProjectInfo dto) throws Exception{

		while( reader.hasNext() ){
			String name = reader.nextName();			
			setField(dto, reader, name);
       	 }
		 
		 dto.clearAllIsModified();
		 
       	 return dto;
	}
		 
	protected void setField(com.tmax.hyperdata.ui_service.dto.OlapProjectInfo dto, JsonReader reader, String name) throws Exception{				
		
		switch(name) {		
	
		case "name" :
		{	
			dto.setName( reader.nextString());									
			break;
		}	
	
			
	
		case "id" :
		{	
			dto.setId( reader.nextInt());									
			break;
		}	
	
			
	
		case "author" :
		{	
			dto.setAuthor( reader.nextString());									
			break;
		}	
	
			
	
		case "lastEdited" :
		{	
			dto.setLastEdited( new java.text.SimpleDateFormat("yyyy.MM.dd HH.mm.ss").parse(reader.nextString().trim()));									
			break;
		}	
	
			
	
		case "contents" :
		{	
			dto.setContents( reader.nextString());									
			break;
		}	
	
			
	
		case "description" :
		{	
			dto.setDescription( reader.nextString());									
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
