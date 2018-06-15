	
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




import com.tmax.hyperdata.ui_service.dto.OlapCubeDimParamMsgJson;


public class OlapCubeDimParamListMsgJson extends Message {	

	public byte[] marshal(DataObject obj) throws Exception {			
		com.tmax.hyperdata.ui_service.dto.OlapCubeDimParamList _OlapCubeDimParamList = (com.tmax.hyperdata.ui_service.dto.OlapCubeDimParamList)obj;
		
		if(_OlapCubeDimParamList == null)
			return null;
		
		BufferedWriter bw = null;
		JsonWriter jw = null;
		
		try{
		    
    		ByteArrayOutputStream out = new ByteArrayOutputStream(); 
    		bw = new BufferedWriter( new OutputStreamWriter( out , this.encoding ) );        
    		jw = new JsonWriter( bw );
           	jw.beginObject();

    		marshal( _OlapCubeDimParamList, jw);
    		jw.endObject();
    		jw.close();
    		return out.toByteArray();
    		    	    		
		} finally{
		    if( jw != null ) jw.close();
		    if( bw != null ) bw.close();
		}								
	}
	
	
	public void marshal(com.tmax.hyperdata.ui_service.dto.OlapCubeDimParamList _OlapCubeDimParamList, JsonWriter writer )throws Exception{
	           
	
	
		writer.name("olapCubeDimParamList"); 
						    					
		com.tmax.hyperdata.ui_service.dto.OlapCubeDimParamMsgJson __olapCubeDimParamList = new com.tmax.hyperdata.ui_service.dto.OlapCubeDimParamMsgJson();					
		writer.beginArray();					
		for(int i = 0; i < _OlapCubeDimParamList.sizeOlapCubeDimParamList(); i++) {
			if(_OlapCubeDimParamList.getOlapCubeDimParamListList().get(i) != null) {
				writer.beginObject();
				__olapCubeDimParamList.marshal((com.tmax.hyperdata.ui_service.dto.OlapCubeDimParam)_OlapCubeDimParamList.getOlapCubeDimParamList(i), writer);
				writer.endObject();
			}
		}
		writer.endArray();							  					
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
		
		com.tmax.hyperdata.ui_service.dto.OlapCubeDimParamList _OlapCubeDimParamList = new com.tmax.hyperdata.ui_service.dto.OlapCubeDimParamList();
		BufferedReader reader = null;
		JsonReader jr = null;
		
		if( bytes.length <= 0)
			return new com.tmax.hyperdata.ui_service.dto.OlapCubeDimParamList();
		
		try{
		reader = new BufferedReader( new InputStreamReader( new ByteArrayInputStream(bytes), this.encoding));		       
		jr = new JsonReader( reader );                
		jr.beginObject();
             


				_OlapCubeDimParamList = (com.tmax.hyperdata.ui_service.dto.OlapCubeDimParamList)unmarshal( jr,  _OlapCubeDimParamList);
     
             
		jr.endObject();
		jr.close();
			
		}finally{
		   	if( jr != null ) jr.close();
		    if( reader != null ) reader.close();
		}
		                       
        return _OlapCubeDimParamList;
	}
	
	
	// For PO7
	public DataObject unmarshal(byte[] bytes, DataObject dto) throws Exception {
		
		com.tmax.hyperdata.ui_service.dto.OlapCubeDimParamList _OlapCubeDimParamList = (com.tmax.hyperdata.ui_service.dto.OlapCubeDimParamList) dto;
		BufferedReader reader = null;
		JsonReader jr = null;
		
		if( bytes.length <= 0)
			return new com.tmax.hyperdata.ui_service.dto.OlapCubeDimParamList();
		
		try{
			reader = new BufferedReader( new InputStreamReader( new ByteArrayInputStream(bytes), this.encoding));		       
			jr = new JsonReader( reader );                
			jr.beginObject();


					_OlapCubeDimParamList = (com.tmax.hyperdata.ui_service.dto.OlapCubeDimParamList)unmarshal( jr,  _OlapCubeDimParamList);
         
		         
			jr.endObject();
			jr.close();
				
		}finally{
		   	if( jr != null ) jr.close();
		    if( reader != null ) reader.close();
		}
		                       
	    return _OlapCubeDimParamList;
	}
		
		 
	public DataObject unmarshal(JsonReader reader, com.tmax.hyperdata.ui_service.dto.OlapCubeDimParamList dto) throws Exception{

		while( reader.hasNext() ){
			String name = reader.nextName();			
			setField(dto, reader, name);
       	 }
		 
		 dto.clearAllIsModified();
		 
       	 return dto;
	}
		 
	protected void setField(com.tmax.hyperdata.ui_service.dto.OlapCubeDimParamList dto, JsonReader reader, String name) throws Exception{				
		
		switch(name) {		
		case "olapCubeDimParamList" :
		{
			reader.beginArray();
			com.tmax.hyperdata.ui_service.dto.OlapCubeDimParamMsgJson __olapCubeDimParamList = new com.tmax.hyperdata.ui_service.dto.OlapCubeDimParamMsgJson();
			while( reader.hasNext() ){	
				com.tmax.hyperdata.ui_service.dto.OlapCubeDimParam ___OlapCubeDimParam = new com.tmax.hyperdata.ui_service.dto.OlapCubeDimParam();	
				reader.beginObject();
				dto.getOlapCubeDimParamListList().add((com.tmax.hyperdata.ui_service.dto.OlapCubeDimParam)__olapCubeDimParamList.unmarshal( reader, ___OlapCubeDimParam ));
				reader.endObject();
			}
			reader.endArray();
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
