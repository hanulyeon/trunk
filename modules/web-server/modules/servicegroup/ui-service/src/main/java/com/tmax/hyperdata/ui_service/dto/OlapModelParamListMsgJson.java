	
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




import com.tmax.hyperdata.ui_service.dto.OlapModelParamMsgJson;


public class OlapModelParamListMsgJson extends Message {	

	public byte[] marshal(DataObject obj) throws Exception {			
		com.tmax.hyperdata.ui_service.dto.OlapModelParamList _OlapModelParamList = (com.tmax.hyperdata.ui_service.dto.OlapModelParamList)obj;
		
		if(_OlapModelParamList == null)
			return null;
		
		BufferedWriter bw = null;
		JsonWriter jw = null;
		
		try{
		    
    		ByteArrayOutputStream out = new ByteArrayOutputStream(); 
    		bw = new BufferedWriter( new OutputStreamWriter( out , this.encoding ) );        
    		jw = new JsonWriter( bw );
           	jw.beginObject();

    		marshal( _OlapModelParamList, jw);
    		jw.endObject();
    		jw.close();
    		return out.toByteArray();
    		    	    		
		} finally{
		    if( jw != null ) jw.close();
		    if( bw != null ) bw.close();
		}								
	}
	
	
	public void marshal(com.tmax.hyperdata.ui_service.dto.OlapModelParamList _OlapModelParamList, JsonWriter writer )throws Exception{
	           
	
		com.tmax.hyperdata.ui_service.dto.OlapModelParamMsgJson __olapModelParamList = new com.tmax.hyperdata.ui_service.dto.OlapModelParamMsgJson();					
			if(_OlapModelParamList.getOlapModelParamList() != null) {
				writer.name("olapModelParamList"); 
				writer.beginObject();
				__olapModelParamList.marshal((com.tmax.hyperdata.ui_service.dto.OlapModelParam)_OlapModelParamList.getOlapModelParamList(), writer);
				writer.endObject();
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
		
		com.tmax.hyperdata.ui_service.dto.OlapModelParamList _OlapModelParamList = new com.tmax.hyperdata.ui_service.dto.OlapModelParamList();
		BufferedReader reader = null;
		JsonReader jr = null;
		
		if( bytes.length <= 0)
			return new com.tmax.hyperdata.ui_service.dto.OlapModelParamList();
		
		try{
		reader = new BufferedReader( new InputStreamReader( new ByteArrayInputStream(bytes), this.encoding));		       
		jr = new JsonReader( reader );                
		jr.beginObject();
             


				_OlapModelParamList = (com.tmax.hyperdata.ui_service.dto.OlapModelParamList)unmarshal( jr,  _OlapModelParamList);
     
             
		jr.endObject();
		jr.close();
			
		}finally{
		   	if( jr != null ) jr.close();
		    if( reader != null ) reader.close();
		}
		                       
        return _OlapModelParamList;
	}
	
	
	// For PO7
	public DataObject unmarshal(byte[] bytes, DataObject dto) throws Exception {
		
		com.tmax.hyperdata.ui_service.dto.OlapModelParamList _OlapModelParamList = (com.tmax.hyperdata.ui_service.dto.OlapModelParamList) dto;
		BufferedReader reader = null;
		JsonReader jr = null;
		
		if( bytes.length <= 0)
			return new com.tmax.hyperdata.ui_service.dto.OlapModelParamList();
		
		try{
			reader = new BufferedReader( new InputStreamReader( new ByteArrayInputStream(bytes), this.encoding));		       
			jr = new JsonReader( reader );                
			jr.beginObject();


					_OlapModelParamList = (com.tmax.hyperdata.ui_service.dto.OlapModelParamList)unmarshal( jr,  _OlapModelParamList);
         
		         
			jr.endObject();
			jr.close();
				
		}finally{
		   	if( jr != null ) jr.close();
		    if( reader != null ) reader.close();
		}
		                       
	    return _OlapModelParamList;
	}
		
		 
	public DataObject unmarshal(JsonReader reader, com.tmax.hyperdata.ui_service.dto.OlapModelParamList dto) throws Exception{

		while( reader.hasNext() ){
			String name = reader.nextName();			
			setField(dto, reader, name);
       	 }
		 
		 dto.clearAllIsModified();
		 
       	 return dto;
	}
		 
	protected void setField(com.tmax.hyperdata.ui_service.dto.OlapModelParamList dto, JsonReader reader, String name) throws Exception{				
		
		switch(name) {		
	
		case "olapModelParamList" :
		{	
			com.tmax.hyperdata.ui_service.dto.OlapModelParamMsgJson __olapModelParamList = new com.tmax.hyperdata.ui_service.dto.OlapModelParamMsgJson();
	
			com.tmax.hyperdata.ui_service.dto.OlapModelParam ___OlapModelParam = new com.tmax.hyperdata.ui_service.dto.OlapModelParam();	
	
			reader.beginObject();
			dto.setOlapModelParamList((com.tmax.hyperdata.ui_service.dto.OlapModelParam)__olapModelParamList.unmarshal( reader, ___OlapModelParam ));
			reader.endObject();
	

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
