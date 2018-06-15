	
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




import com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParamMsgJson;


public class OlapCubeMeasureParamListMsgJson extends Message {	

	public byte[] marshal(DataObject obj) throws Exception {			
		com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParamList _OlapCubeMeasureParamList = (com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParamList)obj;
		
		if(_OlapCubeMeasureParamList == null)
			return null;
		
		BufferedWriter bw = null;
		JsonWriter jw = null;
		
		try{
		    
    		ByteArrayOutputStream out = new ByteArrayOutputStream(); 
    		bw = new BufferedWriter( new OutputStreamWriter( out , this.encoding ) );        
    		jw = new JsonWriter( bw );
           	jw.beginObject();

    		marshal( _OlapCubeMeasureParamList, jw);
    		jw.endObject();
    		jw.close();
    		return out.toByteArray();
    		    	    		
		} finally{
		    if( jw != null ) jw.close();
		    if( bw != null ) bw.close();
		}								
	}
	
	
	public void marshal(com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParamList _OlapCubeMeasureParamList, JsonWriter writer )throws Exception{
	           
	
	
		writer.name("olapCubeMeasureParamList"); 
						    					
		com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParamMsgJson __olapCubeMeasureParamList = new com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParamMsgJson();					
		writer.beginArray();					
		for(int i = 0; i < _OlapCubeMeasureParamList.sizeOlapCubeMeasureParamList(); i++) {
			if(_OlapCubeMeasureParamList.getOlapCubeMeasureParamListList().get(i) != null) {
				writer.beginObject();
				__olapCubeMeasureParamList.marshal((com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParam)_OlapCubeMeasureParamList.getOlapCubeMeasureParamList(i), writer);
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
		
		com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParamList _OlapCubeMeasureParamList = new com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParamList();
		BufferedReader reader = null;
		JsonReader jr = null;
		
		if( bytes.length <= 0)
			return new com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParamList();
		
		try{
		reader = new BufferedReader( new InputStreamReader( new ByteArrayInputStream(bytes), this.encoding));		       
		jr = new JsonReader( reader );                
		jr.beginObject();
             


				_OlapCubeMeasureParamList = (com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParamList)unmarshal( jr,  _OlapCubeMeasureParamList);
     
             
		jr.endObject();
		jr.close();
			
		}finally{
		   	if( jr != null ) jr.close();
		    if( reader != null ) reader.close();
		}
		                       
        return _OlapCubeMeasureParamList;
	}
	
	
	// For PO7
	public DataObject unmarshal(byte[] bytes, DataObject dto) throws Exception {
		
		com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParamList _OlapCubeMeasureParamList = (com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParamList) dto;
		BufferedReader reader = null;
		JsonReader jr = null;
		
		if( bytes.length <= 0)
			return new com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParamList();
		
		try{
			reader = new BufferedReader( new InputStreamReader( new ByteArrayInputStream(bytes), this.encoding));		       
			jr = new JsonReader( reader );                
			jr.beginObject();


					_OlapCubeMeasureParamList = (com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParamList)unmarshal( jr,  _OlapCubeMeasureParamList);
         
		         
			jr.endObject();
			jr.close();
				
		}finally{
		   	if( jr != null ) jr.close();
		    if( reader != null ) reader.close();
		}
		                       
	    return _OlapCubeMeasureParamList;
	}
		
		 
	public DataObject unmarshal(JsonReader reader, com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParamList dto) throws Exception{

		while( reader.hasNext() ){
			String name = reader.nextName();			
			setField(dto, reader, name);
       	 }
		 
		 dto.clearAllIsModified();
		 
       	 return dto;
	}
		 
	protected void setField(com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParamList dto, JsonReader reader, String name) throws Exception{				
		
		switch(name) {		
		case "olapCubeMeasureParamList" :
		{
			reader.beginArray();
			com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParamMsgJson __olapCubeMeasureParamList = new com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParamMsgJson();
			while( reader.hasNext() ){	
				com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParam ___OlapCubeMeasureParam = new com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParam();	
				reader.beginObject();
				dto.getOlapCubeMeasureParamListList().add((com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParam)__olapCubeMeasureParamList.unmarshal( reader, ___OlapCubeMeasureParam ));
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
