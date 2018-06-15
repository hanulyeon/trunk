	
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






public class OlapCubeFactParamMsgJson extends Message {	

	public byte[] marshal(DataObject obj) throws Exception {			
		com.tmax.hyperdata.ui_service.dto.OlapCubeFactParam _OlapCubeFactParam = (com.tmax.hyperdata.ui_service.dto.OlapCubeFactParam)obj;
		
		if(_OlapCubeFactParam == null)
			return null;
		
		BufferedWriter bw = null;
		JsonWriter jw = null;
		
		try{
		    
    		ByteArrayOutputStream out = new ByteArrayOutputStream(); 
    		bw = new BufferedWriter( new OutputStreamWriter( out , this.encoding ) );        
    		jw = new JsonWriter( bw );
           	jw.beginObject();

    		marshal( _OlapCubeFactParam, jw);
    		jw.endObject();
    		jw.close();
    		return out.toByteArray();
    		    	    		
		} finally{
		    if( jw != null ) jw.close();
		    if( bw != null ) bw.close();
		}								
	}
	
	
	public void marshal(com.tmax.hyperdata.ui_service.dto.OlapCubeFactParam _OlapCubeFactParam, JsonWriter writer )throws Exception{
	           
		
		writer.name("cubeId"); 
		writer.value(_OlapCubeFactParam.getCubeId());
		
		writer.name("selFactTableId"); 
		writer.value(_OlapCubeFactParam.getSelFactTableId());
		
	
		if (_OlapCubeFactParam.getSelFactTableName() != null) {
			writer.name("selFactTableName"); 
			writer.value(_OlapCubeFactParam.getSelFactTableName());
		}
	
		
	
		if (_OlapCubeFactParam.getSelFactTableColName() != null) {
			writer.name("selFactTableColName"); 
			writer.value(_OlapCubeFactParam.getSelFactTableColName());
		}
	
		
	
		if (_OlapCubeFactParam.getSelFactTableColType() != null) {
			writer.name("selFactTableColType"); 
			writer.value(_OlapCubeFactParam.getSelFactTableColType());
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
		
		com.tmax.hyperdata.ui_service.dto.OlapCubeFactParam _OlapCubeFactParam = new com.tmax.hyperdata.ui_service.dto.OlapCubeFactParam();
		BufferedReader reader = null;
		JsonReader jr = null;
		
		if( bytes.length <= 0)
			return new com.tmax.hyperdata.ui_service.dto.OlapCubeFactParam();
		
		try{
		reader = new BufferedReader( new InputStreamReader( new ByteArrayInputStream(bytes), this.encoding));		       
		jr = new JsonReader( reader );                
		jr.beginObject();
             


				_OlapCubeFactParam = (com.tmax.hyperdata.ui_service.dto.OlapCubeFactParam)unmarshal( jr,  _OlapCubeFactParam);
     
             
		jr.endObject();
		jr.close();
			
		}finally{
		   	if( jr != null ) jr.close();
		    if( reader != null ) reader.close();
		}
		                       
        return _OlapCubeFactParam;
	}
	
	
	// For PO7
	public DataObject unmarshal(byte[] bytes, DataObject dto) throws Exception {
		
		com.tmax.hyperdata.ui_service.dto.OlapCubeFactParam _OlapCubeFactParam = (com.tmax.hyperdata.ui_service.dto.OlapCubeFactParam) dto;
		BufferedReader reader = null;
		JsonReader jr = null;
		
		if( bytes.length <= 0)
			return new com.tmax.hyperdata.ui_service.dto.OlapCubeFactParam();
		
		try{
			reader = new BufferedReader( new InputStreamReader( new ByteArrayInputStream(bytes), this.encoding));		       
			jr = new JsonReader( reader );                
			jr.beginObject();


					_OlapCubeFactParam = (com.tmax.hyperdata.ui_service.dto.OlapCubeFactParam)unmarshal( jr,  _OlapCubeFactParam);
         
		         
			jr.endObject();
			jr.close();
				
		}finally{
		   	if( jr != null ) jr.close();
		    if( reader != null ) reader.close();
		}
		                       
	    return _OlapCubeFactParam;
	}
		
		 
	public DataObject unmarshal(JsonReader reader, com.tmax.hyperdata.ui_service.dto.OlapCubeFactParam dto) throws Exception{

		while( reader.hasNext() ){
			String name = reader.nextName();			
			setField(dto, reader, name);
       	 }
		 
		 dto.clearAllIsModified();
		 
       	 return dto;
	}
		 
	protected void setField(com.tmax.hyperdata.ui_service.dto.OlapCubeFactParam dto, JsonReader reader, String name) throws Exception{				
		
		switch(name) {		
	
		case "cubeId" :
		{	
			dto.setCubeId( reader.nextInt());									
			break;
		}	
	
			
	
		case "selFactTableId" :
		{	
			dto.setSelFactTableId( reader.nextInt());									
			break;
		}	
	
			
	
		case "selFactTableName" :
		{	
			dto.setSelFactTableName( reader.nextString());									
			break;
		}	
	
			
	
		case "selFactTableColName" :
		{	
			dto.setSelFactTableColName( reader.nextString());									
			break;
		}	
	
			
	
		case "selFactTableColType" :
		{	
			dto.setSelFactTableColType( reader.nextString());									
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
