	
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


public class ModelMsgJson extends Message {	

	public byte[] marshal(DataObject obj) throws Exception {			
		com.tmax.hyperdata.ui_service.dto.Model _Model = (com.tmax.hyperdata.ui_service.dto.Model)obj;
		
		if(_Model == null)
			return null;
		
		BufferedWriter bw = null;
		JsonWriter jw = null;
		
		try{
		    
    		ByteArrayOutputStream out = new ByteArrayOutputStream(); 
    		bw = new BufferedWriter( new OutputStreamWriter( out , this.encoding ) );        
    		jw = new JsonWriter( bw );
           	jw.beginObject();

    		marshal( _Model, jw);
    		jw.endObject();
    		jw.close();
    		return out.toByteArray();
    		    	    		
		} finally{
		    if( jw != null ) jw.close();
		    if( bw != null ) bw.close();
		}								
	}
	
	
	public void marshal(com.tmax.hyperdata.ui_service.dto.Model _Model, JsonWriter writer )throws Exception{
	           
		
	
		if (_Model.getId() != null) {
			writer.name("id"); 
			writer.value(_Model.getId());
		}
	
		
	
		if (_Model.getName() != null) {
			writer.name("name"); 
			writer.value(_Model.getName());
		}
	
		
	
		if (_Model.getAuthor() != null) {
			writer.name("author"); 
			writer.value(_Model.getAuthor());
		}
	
		
	
		if (_Model.getStatus() != null) {
			writer.name("status"); 
			writer.value(_Model.getStatus());
		}
	
	
	
		java.text.SimpleDateFormat df = null;								
	
		if (_Model.getLastEdited() != null) {
			writer.name("lastEdited"); 

			df = new java.text.SimpleDateFormat("yyyy.MM.dd HH.mm.ss");		
			writer.value(df.format(_Model.getLastEdited()));
		}
		
	
		if (_Model.getProjectId() != null) {
			writer.name("projectId"); 
			writer.value(_Model.getProjectId());
		}
	
		
	
		if (_Model.getDescription() != null) {
			writer.name("description"); 
			writer.value(_Model.getDescription());
		}
	
		
	
		if (_Model.getFlowId() != null) {
			writer.name("flowId"); 
			writer.value(_Model.getFlowId());
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
		
		com.tmax.hyperdata.ui_service.dto.Model _Model = new com.tmax.hyperdata.ui_service.dto.Model();
		BufferedReader reader = null;
		JsonReader jr = null;
		
		if( bytes.length <= 0)
			return new com.tmax.hyperdata.ui_service.dto.Model();
		
		try{
		reader = new BufferedReader( new InputStreamReader( new ByteArrayInputStream(bytes), this.encoding));		       
		jr = new JsonReader( reader );                
		jr.beginObject();
             


				_Model = (com.tmax.hyperdata.ui_service.dto.Model)unmarshal( jr,  _Model);
     
             
		jr.endObject();
		jr.close();
			
		}finally{
		   	if( jr != null ) jr.close();
		    if( reader != null ) reader.close();
		}
		                       
        return _Model;
	}
	
	
	// For PO7
	public DataObject unmarshal(byte[] bytes, DataObject dto) throws Exception {
		
		com.tmax.hyperdata.ui_service.dto.Model _Model = (com.tmax.hyperdata.ui_service.dto.Model) dto;
		BufferedReader reader = null;
		JsonReader jr = null;
		
		if( bytes.length <= 0)
			return new com.tmax.hyperdata.ui_service.dto.Model();
		
		try{
			reader = new BufferedReader( new InputStreamReader( new ByteArrayInputStream(bytes), this.encoding));		       
			jr = new JsonReader( reader );                
			jr.beginObject();


					_Model = (com.tmax.hyperdata.ui_service.dto.Model)unmarshal( jr,  _Model);
         
		         
			jr.endObject();
			jr.close();
				
		}finally{
		   	if( jr != null ) jr.close();
		    if( reader != null ) reader.close();
		}
		                       
	    return _Model;
	}
		
		 
	public DataObject unmarshal(JsonReader reader, com.tmax.hyperdata.ui_service.dto.Model dto) throws Exception{

		while( reader.hasNext() ){
			String name = reader.nextName();			
			setField(dto, reader, name);
       	 }
		 
		 dto.clearAllIsModified();
		 
       	 return dto;
	}
		 
	protected void setField(com.tmax.hyperdata.ui_service.dto.Model dto, JsonReader reader, String name) throws Exception{				
		
		switch(name) {		
	
		case "id" :
		{	
			dto.setId( reader.nextString());									
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
	
			
	
		case "status" :
		{	
			dto.setStatus( reader.nextString());									
			break;
		}	
	
			
	
		case "lastEdited" :
		{	
			dto.setLastEdited( new java.text.SimpleDateFormat("yyyy.MM.dd HH.mm.ss").parse(reader.nextString().trim()));									
			break;
		}	
	
			
	
		case "projectId" :
		{	
			dto.setProjectId( reader.nextString());									
			break;
		}	
	
			
	
		case "description" :
		{	
			dto.setDescription( reader.nextString());									
			break;
		}	
	
			
	
		case "flowId" :
		{	
			dto.setFlowId( reader.nextString());									
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
