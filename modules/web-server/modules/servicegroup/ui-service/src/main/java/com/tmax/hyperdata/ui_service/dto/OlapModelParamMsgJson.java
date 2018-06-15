	
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






public class OlapModelParamMsgJson extends Message {	

	public byte[] marshal(DataObject obj) throws Exception {			
		com.tmax.hyperdata.ui_service.dto.OlapModelParam _OlapModelParam = (com.tmax.hyperdata.ui_service.dto.OlapModelParam)obj;
		
		if(_OlapModelParam == null)
			return null;
		
		BufferedWriter bw = null;
		JsonWriter jw = null;
		
		try{
		    
    		ByteArrayOutputStream out = new ByteArrayOutputStream(); 
    		bw = new BufferedWriter( new OutputStreamWriter( out , this.encoding ) );        
    		jw = new JsonWriter( bw );
           	jw.beginObject();

    		marshal( _OlapModelParam, jw);
    		jw.endObject();
    		jw.close();
    		return out.toByteArray();
    		    	    		
		} finally{
		    if( jw != null ) jw.close();
		    if( bw != null ) bw.close();
		}								
	}
	
	
	public void marshal(com.tmax.hyperdata.ui_service.dto.OlapModelParam _OlapModelParam, JsonWriter writer )throws Exception{
	           
		
		writer.name("modelId"); 
		writer.value(_OlapModelParam.getModelId());
		
		writer.name("refFactTableId"); 
		writer.value(_OlapModelParam.getRefFactTableId());
		
	
		if (_OlapModelParam.getRefFactTableName() != null) {
			writer.name("refFactTableName"); 
			writer.value(_OlapModelParam.getRefFactTableName());
		}
	
		
	
		if (_OlapModelParam.getRefFactTableColName() != null) {
			writer.name("refFactTableColName"); 
			writer.value(_OlapModelParam.getRefFactTableColName());
		}
	
		
	
		if (_OlapModelParam.getRefFactTableColType() != null) {
			writer.name("refFactTableColType"); 
			writer.value(_OlapModelParam.getRefFactTableColType());
		}
	
		
		writer.name("refDimTableId"); 
		writer.value(_OlapModelParam.getRefDimTableId());
		
	
		if (_OlapModelParam.getRefDimTableName() != null) {
			writer.name("refDimTableName"); 
			writer.value(_OlapModelParam.getRefDimTableName());
		}
	
		
	
		if (_OlapModelParam.getRefDimTableColName() != null) {
			writer.name("refDimTableColName"); 
			writer.value(_OlapModelParam.getRefDimTableColName());
		}
	
		
	
		if (_OlapModelParam.getRefDimTableColType() != null) {
			writer.name("refDimTableColType"); 
			writer.value(_OlapModelParam.getRefDimTableColType());
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
		
		com.tmax.hyperdata.ui_service.dto.OlapModelParam _OlapModelParam = new com.tmax.hyperdata.ui_service.dto.OlapModelParam();
		BufferedReader reader = null;
		JsonReader jr = null;
		
		if( bytes.length <= 0)
			return new com.tmax.hyperdata.ui_service.dto.OlapModelParam();
		
		try{
		reader = new BufferedReader( new InputStreamReader( new ByteArrayInputStream(bytes), this.encoding));		       
		jr = new JsonReader( reader );                
		jr.beginObject();
             


				_OlapModelParam = (com.tmax.hyperdata.ui_service.dto.OlapModelParam)unmarshal( jr,  _OlapModelParam);
     
             
		jr.endObject();
		jr.close();
			
		}finally{
		   	if( jr != null ) jr.close();
		    if( reader != null ) reader.close();
		}
		                       
        return _OlapModelParam;
	}
	
	
	// For PO7
	public DataObject unmarshal(byte[] bytes, DataObject dto) throws Exception {
		
		com.tmax.hyperdata.ui_service.dto.OlapModelParam _OlapModelParam = (com.tmax.hyperdata.ui_service.dto.OlapModelParam) dto;
		BufferedReader reader = null;
		JsonReader jr = null;
		
		if( bytes.length <= 0)
			return new com.tmax.hyperdata.ui_service.dto.OlapModelParam();
		
		try{
			reader = new BufferedReader( new InputStreamReader( new ByteArrayInputStream(bytes), this.encoding));		       
			jr = new JsonReader( reader );                
			jr.beginObject();


					_OlapModelParam = (com.tmax.hyperdata.ui_service.dto.OlapModelParam)unmarshal( jr,  _OlapModelParam);
         
		         
			jr.endObject();
			jr.close();
				
		}finally{
		   	if( jr != null ) jr.close();
		    if( reader != null ) reader.close();
		}
		                       
	    return _OlapModelParam;
	}
		
		 
	public DataObject unmarshal(JsonReader reader, com.tmax.hyperdata.ui_service.dto.OlapModelParam dto) throws Exception{

		while( reader.hasNext() ){
			String name = reader.nextName();			
			setField(dto, reader, name);
       	 }
		 
		 dto.clearAllIsModified();
		 
       	 return dto;
	}
		 
	protected void setField(com.tmax.hyperdata.ui_service.dto.OlapModelParam dto, JsonReader reader, String name) throws Exception{				
		
		switch(name) {		
	
		case "modelId" :
		{	
			dto.setModelId( reader.nextInt());									
			break;
		}	
	
			
	
		case "refFactTableId" :
		{	
			dto.setRefFactTableId( reader.nextInt());									
			break;
		}	
	
			
	
		case "refFactTableName" :
		{	
			dto.setRefFactTableName( reader.nextString());									
			break;
		}	
	
			
	
		case "refFactTableColName" :
		{	
			dto.setRefFactTableColName( reader.nextString());									
			break;
		}	
	
			
	
		case "refFactTableColType" :
		{	
			dto.setRefFactTableColType( reader.nextString());									
			break;
		}	
	
			
	
		case "refDimTableId" :
		{	
			dto.setRefDimTableId( reader.nextInt());									
			break;
		}	
	
			
	
		case "refDimTableName" :
		{	
			dto.setRefDimTableName( reader.nextString());									
			break;
		}	
	
			
	
		case "refDimTableColName" :
		{	
			dto.setRefDimTableColName( reader.nextString());									
			break;
		}	
	
			
	
		case "refDimTableColType" :
		{	
			dto.setRefDimTableColType( reader.nextString());									
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
