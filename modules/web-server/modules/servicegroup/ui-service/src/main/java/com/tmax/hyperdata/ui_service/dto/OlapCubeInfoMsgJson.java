	
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


public class OlapCubeInfoMsgJson extends Message {	

	public byte[] marshal(DataObject obj) throws Exception {			
		com.tmax.hyperdata.ui_service.dto.OlapCubeInfo _OlapCubeInfo = (com.tmax.hyperdata.ui_service.dto.OlapCubeInfo)obj;
		
		if(_OlapCubeInfo == null)
			return null;
		
		BufferedWriter bw = null;
		JsonWriter jw = null;
		
		try{
		    
    		ByteArrayOutputStream out = new ByteArrayOutputStream(); 
    		bw = new BufferedWriter( new OutputStreamWriter( out , this.encoding ) );        
    		jw = new JsonWriter( bw );
           	jw.beginObject();

    		marshal( _OlapCubeInfo, jw);
    		jw.endObject();
    		jw.close();
    		return out.toByteArray();
    		    	    		
		} finally{
		    if( jw != null ) jw.close();
		    if( bw != null ) bw.close();
		}								
	}
	
	
	public void marshal(com.tmax.hyperdata.ui_service.dto.OlapCubeInfo _OlapCubeInfo, JsonWriter writer )throws Exception{
	           
		
		writer.name("id"); 
		writer.value(_OlapCubeInfo.getId());
		
	
		if (_OlapCubeInfo.getName() != null) {
			writer.name("name"); 
			writer.value(_OlapCubeInfo.getName());
		}
	
		
	
		if (_OlapCubeInfo.getAuthor() != null) {
			writer.name("author"); 
			writer.value(_OlapCubeInfo.getAuthor());
		}
	
	
	
		java.text.SimpleDateFormat df = null;								
	
		if (_OlapCubeInfo.getLastEdited() != null) {
			writer.name("lastEdited"); 

			df = new java.text.SimpleDateFormat("yyyy.MM.dd HH.mm.ss");		
			writer.value(df.format(_OlapCubeInfo.getLastEdited()));
		}
		
		writer.name("modelId"); 
		writer.value(_OlapCubeInfo.getModelId());
		
	
		if (_OlapCubeInfo.getContents() != null) {
			writer.name("contents"); 
			writer.value(_OlapCubeInfo.getContents());
		}
	
		
	
		if (_OlapCubeInfo.getDescription() != null) {
			writer.name("description"); 
			writer.value(_OlapCubeInfo.getDescription());
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
		
		com.tmax.hyperdata.ui_service.dto.OlapCubeInfo _OlapCubeInfo = new com.tmax.hyperdata.ui_service.dto.OlapCubeInfo();
		BufferedReader reader = null;
		JsonReader jr = null;
		
		if( bytes.length <= 0)
			return new com.tmax.hyperdata.ui_service.dto.OlapCubeInfo();
		
		try{
		reader = new BufferedReader( new InputStreamReader( new ByteArrayInputStream(bytes), this.encoding));		       
		jr = new JsonReader( reader );                
		jr.beginObject();
             


				_OlapCubeInfo = (com.tmax.hyperdata.ui_service.dto.OlapCubeInfo)unmarshal( jr,  _OlapCubeInfo);
     
             
		jr.endObject();
		jr.close();
			
		}finally{
		   	if( jr != null ) jr.close();
		    if( reader != null ) reader.close();
		}
		                       
        return _OlapCubeInfo;
	}
	
	
	// For PO7
	public DataObject unmarshal(byte[] bytes, DataObject dto) throws Exception {
		
		com.tmax.hyperdata.ui_service.dto.OlapCubeInfo _OlapCubeInfo = (com.tmax.hyperdata.ui_service.dto.OlapCubeInfo) dto;
		BufferedReader reader = null;
		JsonReader jr = null;
		
		if( bytes.length <= 0)
			return new com.tmax.hyperdata.ui_service.dto.OlapCubeInfo();
		
		try{
			reader = new BufferedReader( new InputStreamReader( new ByteArrayInputStream(bytes), this.encoding));		       
			jr = new JsonReader( reader );                
			jr.beginObject();


					_OlapCubeInfo = (com.tmax.hyperdata.ui_service.dto.OlapCubeInfo)unmarshal( jr,  _OlapCubeInfo);
         
		         
			jr.endObject();
			jr.close();
				
		}finally{
		   	if( jr != null ) jr.close();
		    if( reader != null ) reader.close();
		}
		                       
	    return _OlapCubeInfo;
	}
		
		 
	public DataObject unmarshal(JsonReader reader, com.tmax.hyperdata.ui_service.dto.OlapCubeInfo dto) throws Exception{

		while( reader.hasNext() ){
			String name = reader.nextName();			
			setField(dto, reader, name);
       	 }
		 
		 dto.clearAllIsModified();
		 
       	 return dto;
	}
		 
	protected void setField(com.tmax.hyperdata.ui_service.dto.OlapCubeInfo dto, JsonReader reader, String name) throws Exception{				
		
		switch(name) {		
	
		case "id" :
		{	
			dto.setId( reader.nextInt());									
			break;
		}	
	
			
	
		case "name" :
		{	
			dto.setName( reader.nextString());									
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
	
			
	
		case "modelId" :
		{	
			dto.setModelId( reader.nextInt());									
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
