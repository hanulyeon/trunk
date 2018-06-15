	
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




import com.tmax.hyperdata.ui_service.dto.OlapCubeInfoMsgJson;


public class OlapCubeInfoListMsgJson extends Message {	

	public byte[] marshal(DataObject obj) throws Exception {			
		com.tmax.hyperdata.ui_service.dto.OlapCubeInfoList _OlapCubeInfoList = (com.tmax.hyperdata.ui_service.dto.OlapCubeInfoList)obj;
		
		if(_OlapCubeInfoList == null)
			return null;
		
		BufferedWriter bw = null;
		JsonWriter jw = null;
		
		try{
		    
    		ByteArrayOutputStream out = new ByteArrayOutputStream(); 
    		bw = new BufferedWriter( new OutputStreamWriter( out , this.encoding ) );        
    		jw = new JsonWriter( bw );
           	jw.beginObject();

    		marshal( _OlapCubeInfoList, jw);
    		jw.endObject();
    		jw.close();
    		return out.toByteArray();
    		    	    		
		} finally{
		    if( jw != null ) jw.close();
		    if( bw != null ) bw.close();
		}								
	}
	
	
	public void marshal(com.tmax.hyperdata.ui_service.dto.OlapCubeInfoList _OlapCubeInfoList, JsonWriter writer )throws Exception{
	           
	
	
		writer.name("olapCubeInfoList"); 
						    					
		com.tmax.hyperdata.ui_service.dto.OlapCubeInfoMsgJson __olapCubeInfoList = new com.tmax.hyperdata.ui_service.dto.OlapCubeInfoMsgJson();					
		writer.beginArray();					
		for(int i = 0; i < _OlapCubeInfoList.sizeOlapCubeInfoList(); i++) {
			if(_OlapCubeInfoList.getOlapCubeInfoListList().get(i) != null) {
				writer.beginObject();
				__olapCubeInfoList.marshal((com.tmax.hyperdata.ui_service.dto.OlapCubeInfo)_OlapCubeInfoList.getOlapCubeInfoList(i), writer);
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
		
		com.tmax.hyperdata.ui_service.dto.OlapCubeInfoList _OlapCubeInfoList = new com.tmax.hyperdata.ui_service.dto.OlapCubeInfoList();
		BufferedReader reader = null;
		JsonReader jr = null;
		
		if( bytes.length <= 0)
			return new com.tmax.hyperdata.ui_service.dto.OlapCubeInfoList();
		
		try{
		reader = new BufferedReader( new InputStreamReader( new ByteArrayInputStream(bytes), this.encoding));		       
		jr = new JsonReader( reader );                
		jr.beginObject();
             


				_OlapCubeInfoList = (com.tmax.hyperdata.ui_service.dto.OlapCubeInfoList)unmarshal( jr,  _OlapCubeInfoList);
     
             
		jr.endObject();
		jr.close();
			
		}finally{
		   	if( jr != null ) jr.close();
		    if( reader != null ) reader.close();
		}
		                       
        return _OlapCubeInfoList;
	}
	
	
	// For PO7
	public DataObject unmarshal(byte[] bytes, DataObject dto) throws Exception {
		
		com.tmax.hyperdata.ui_service.dto.OlapCubeInfoList _OlapCubeInfoList = (com.tmax.hyperdata.ui_service.dto.OlapCubeInfoList) dto;
		BufferedReader reader = null;
		JsonReader jr = null;
		
		if( bytes.length <= 0)
			return new com.tmax.hyperdata.ui_service.dto.OlapCubeInfoList();
		
		try{
			reader = new BufferedReader( new InputStreamReader( new ByteArrayInputStream(bytes), this.encoding));		       
			jr = new JsonReader( reader );                
			jr.beginObject();


					_OlapCubeInfoList = (com.tmax.hyperdata.ui_service.dto.OlapCubeInfoList)unmarshal( jr,  _OlapCubeInfoList);
         
		         
			jr.endObject();
			jr.close();
				
		}finally{
		   	if( jr != null ) jr.close();
		    if( reader != null ) reader.close();
		}
		                       
	    return _OlapCubeInfoList;
	}
		
		 
	public DataObject unmarshal(JsonReader reader, com.tmax.hyperdata.ui_service.dto.OlapCubeInfoList dto) throws Exception{

		while( reader.hasNext() ){
			String name = reader.nextName();			
			setField(dto, reader, name);
       	 }
		 
		 dto.clearAllIsModified();
		 
       	 return dto;
	}
		 
	protected void setField(com.tmax.hyperdata.ui_service.dto.OlapCubeInfoList dto, JsonReader reader, String name) throws Exception{				
		
		switch(name) {		
		case "olapCubeInfoList" :
		{
			reader.beginArray();
			com.tmax.hyperdata.ui_service.dto.OlapCubeInfoMsgJson __olapCubeInfoList = new com.tmax.hyperdata.ui_service.dto.OlapCubeInfoMsgJson();
			while( reader.hasNext() ){	
				com.tmax.hyperdata.ui_service.dto.OlapCubeInfo ___OlapCubeInfo = new com.tmax.hyperdata.ui_service.dto.OlapCubeInfo();	
				reader.beginObject();
				dto.getOlapCubeInfoListList().add((com.tmax.hyperdata.ui_service.dto.OlapCubeInfo)__olapCubeInfoList.unmarshal( reader, ___OlapCubeInfo ));
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
