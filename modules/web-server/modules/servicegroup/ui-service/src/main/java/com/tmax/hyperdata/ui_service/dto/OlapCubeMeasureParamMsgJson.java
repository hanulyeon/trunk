	
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






public class OlapCubeMeasureParamMsgJson extends Message {	

	public byte[] marshal(DataObject obj) throws Exception {			
		com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParam _OlapCubeMeasureParam = (com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParam)obj;
		
		if(_OlapCubeMeasureParam == null)
			return null;
		
		BufferedWriter bw = null;
		JsonWriter jw = null;
		
		try{
		    
    		ByteArrayOutputStream out = new ByteArrayOutputStream(); 
    		bw = new BufferedWriter( new OutputStreamWriter( out , this.encoding ) );        
    		jw = new JsonWriter( bw );
           	jw.beginObject();

    		marshal( _OlapCubeMeasureParam, jw);
    		jw.endObject();
    		jw.close();
    		return out.toByteArray();
    		    	    		
		} finally{
		    if( jw != null ) jw.close();
		    if( bw != null ) bw.close();
		}								
	}
	
	
	public void marshal(com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParam _OlapCubeMeasureParam, JsonWriter writer )throws Exception{
	           
		
		writer.name("cubeId"); 
		writer.value(_OlapCubeMeasureParam.getCubeId());
		
		writer.name("selFactTableId"); 
		writer.value(_OlapCubeMeasureParam.getSelFactTableId());
		
	
		if (_OlapCubeMeasureParam.getSelMeasureColName() != null) {
			writer.name("selMeasureColName"); 
			writer.value(_OlapCubeMeasureParam.getSelMeasureColName());
		}
	
		
	
		if (_OlapCubeMeasureParam.getSelMeasureColValue() != null) {
			writer.name("selMeasureColValue"); 
			writer.value(_OlapCubeMeasureParam.getSelMeasureColValue());
		}
	
		
	
		if (_OlapCubeMeasureParam.getSelMeasureColType() != null) {
			writer.name("selMeasureColType"); 
			writer.value(_OlapCubeMeasureParam.getSelMeasureColType());
		}
	
		
	
		if (_OlapCubeMeasureParam.getSelMeasureColExpresion() != null) {
			writer.name("selMeasureColExpresion"); 
			writer.value(_OlapCubeMeasureParam.getSelMeasureColExpresion());
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
		
		com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParam _OlapCubeMeasureParam = new com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParam();
		BufferedReader reader = null;
		JsonReader jr = null;
		
		if( bytes.length <= 0)
			return new com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParam();
		
		try{
		reader = new BufferedReader( new InputStreamReader( new ByteArrayInputStream(bytes), this.encoding));		       
		jr = new JsonReader( reader );                
		jr.beginObject();
             


				_OlapCubeMeasureParam = (com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParam)unmarshal( jr,  _OlapCubeMeasureParam);
     
             
		jr.endObject();
		jr.close();
			
		}finally{
		   	if( jr != null ) jr.close();
		    if( reader != null ) reader.close();
		}
		                       
        return _OlapCubeMeasureParam;
	}
	
	
	// For PO7
	public DataObject unmarshal(byte[] bytes, DataObject dto) throws Exception {
		
		com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParam _OlapCubeMeasureParam = (com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParam) dto;
		BufferedReader reader = null;
		JsonReader jr = null;
		
		if( bytes.length <= 0)
			return new com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParam();
		
		try{
			reader = new BufferedReader( new InputStreamReader( new ByteArrayInputStream(bytes), this.encoding));		       
			jr = new JsonReader( reader );                
			jr.beginObject();


					_OlapCubeMeasureParam = (com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParam)unmarshal( jr,  _OlapCubeMeasureParam);
         
		         
			jr.endObject();
			jr.close();
				
		}finally{
		   	if( jr != null ) jr.close();
		    if( reader != null ) reader.close();
		}
		                       
	    return _OlapCubeMeasureParam;
	}
		
		 
	public DataObject unmarshal(JsonReader reader, com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParam dto) throws Exception{

		while( reader.hasNext() ){
			String name = reader.nextName();			
			setField(dto, reader, name);
       	 }
		 
		 dto.clearAllIsModified();
		 
       	 return dto;
	}
		 
	protected void setField(com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParam dto, JsonReader reader, String name) throws Exception{				
		
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
	
			
	
		case "selMeasureColName" :
		{	
			dto.setSelMeasureColName( reader.nextString());									
			break;
		}	
	
			
	
		case "selMeasureColValue" :
		{	
			dto.setSelMeasureColValue( reader.nextString());									
			break;
		}	
	
			
	
		case "selMeasureColType" :
		{	
			dto.setSelMeasureColType( reader.nextString());									
			break;
		}	
	
			
	
		case "selMeasureColExpresion" :
		{	
			dto.setSelMeasureColExpresion( reader.nextString());									
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
