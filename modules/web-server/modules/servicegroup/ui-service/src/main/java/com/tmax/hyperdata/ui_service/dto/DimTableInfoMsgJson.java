	
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






public class DimTableInfoMsgJson extends Message {	

	public byte[] marshal(DataObject obj) throws Exception {			
		com.tmax.hyperdata.ui_service.dto.DimTableInfo _DimTableInfo = (com.tmax.hyperdata.ui_service.dto.DimTableInfo)obj;
		
		if(_DimTableInfo == null)
			return null;
		
		BufferedWriter bw = null;
		JsonWriter jw = null;
		
		try{
		    
    		ByteArrayOutputStream out = new ByteArrayOutputStream(); 
    		bw = new BufferedWriter( new OutputStreamWriter( out , this.encoding ) );        
    		jw = new JsonWriter( bw );
           	jw.beginObject();

    		marshal( _DimTableInfo, jw);
    		jw.endObject();
    		jw.close();
    		return out.toByteArray();
    		    	    		
		} finally{
		    if( jw != null ) jw.close();
		    if( bw != null ) bw.close();
		}								
	}
	
	
	public void marshal(com.tmax.hyperdata.ui_service.dto.DimTableInfo _DimTableInfo, JsonWriter writer )throws Exception{
	           
		
		writer.name("dimTableId"); 
		writer.value(_DimTableInfo.getDimTableId());
		
	
		if (_DimTableInfo.getDimTableName() != null) {
			writer.name("dimTableName"); 
			writer.value(_DimTableInfo.getDimTableName());
		}
	
		
	
		if (_DimTableInfo.getDimTableColName() != null) {
			writer.name("dimTableColName"); 
			writer.value(_DimTableInfo.getDimTableColName());
		}
	
		
	
		if (_DimTableInfo.getDimTableColType() != null) {
			writer.name("dimTableColType"); 
			writer.value(_DimTableInfo.getDimTableColType());
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
		
		com.tmax.hyperdata.ui_service.dto.DimTableInfo _DimTableInfo = new com.tmax.hyperdata.ui_service.dto.DimTableInfo();
		BufferedReader reader = null;
		JsonReader jr = null;
		
		if( bytes.length <= 0)
			return new com.tmax.hyperdata.ui_service.dto.DimTableInfo();
		
		try{
		reader = new BufferedReader( new InputStreamReader( new ByteArrayInputStream(bytes), this.encoding));		       
		jr = new JsonReader( reader );                
		jr.beginObject();
             


				_DimTableInfo = (com.tmax.hyperdata.ui_service.dto.DimTableInfo)unmarshal( jr,  _DimTableInfo);
     
             
		jr.endObject();
		jr.close();
			
		}finally{
		   	if( jr != null ) jr.close();
		    if( reader != null ) reader.close();
		}
		                       
        return _DimTableInfo;
	}
	
	
	// For PO7
	public DataObject unmarshal(byte[] bytes, DataObject dto) throws Exception {
		
		com.tmax.hyperdata.ui_service.dto.DimTableInfo _DimTableInfo = (com.tmax.hyperdata.ui_service.dto.DimTableInfo) dto;
		BufferedReader reader = null;
		JsonReader jr = null;
		
		if( bytes.length <= 0)
			return new com.tmax.hyperdata.ui_service.dto.DimTableInfo();
		
		try{
			reader = new BufferedReader( new InputStreamReader( new ByteArrayInputStream(bytes), this.encoding));		       
			jr = new JsonReader( reader );                
			jr.beginObject();


					_DimTableInfo = (com.tmax.hyperdata.ui_service.dto.DimTableInfo)unmarshal( jr,  _DimTableInfo);
         
		         
			jr.endObject();
			jr.close();
				
		}finally{
		   	if( jr != null ) jr.close();
		    if( reader != null ) reader.close();
		}
		                       
	    return _DimTableInfo;
	}
		
		 
	public DataObject unmarshal(JsonReader reader, com.tmax.hyperdata.ui_service.dto.DimTableInfo dto) throws Exception{

		while( reader.hasNext() ){
			String name = reader.nextName();			
			setField(dto, reader, name);
       	 }
		 
		 dto.clearAllIsModified();
		 
       	 return dto;
	}
		 
	protected void setField(com.tmax.hyperdata.ui_service.dto.DimTableInfo dto, JsonReader reader, String name) throws Exception{				
		
		switch(name) {		
	
		case "dimTableId" :
		{	
			dto.setDimTableId( reader.nextInt());									
			break;
		}	
	
			
	
		case "dimTableName" :
		{	
			dto.setDimTableName( reader.nextString());									
			break;
		}	
	
			
	
		case "dimTableColName" :
		{	
			dto.setDimTableColName( reader.nextString());									
			break;
		}	
	
			
	
		case "dimTableColType" :
		{	
			dto.setDimTableColType( reader.nextString());									
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
