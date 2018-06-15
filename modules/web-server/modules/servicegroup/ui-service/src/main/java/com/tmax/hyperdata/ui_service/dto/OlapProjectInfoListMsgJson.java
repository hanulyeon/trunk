	
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




import com.tmax.hyperdata.ui_service.dto.OlapProjectInfoMsgJson;


public class OlapProjectInfoListMsgJson extends Message {	

	public byte[] marshal(DataObject obj) throws Exception {			
		com.tmax.hyperdata.ui_service.dto.OlapProjectInfoList _OlapProjectInfoList = (com.tmax.hyperdata.ui_service.dto.OlapProjectInfoList)obj;
		
		if(_OlapProjectInfoList == null)
			return null;
		
		BufferedWriter bw = null;
		JsonWriter jw = null;
		
		try{
		    
    		ByteArrayOutputStream out = new ByteArrayOutputStream(); 
    		bw = new BufferedWriter( new OutputStreamWriter( out , this.encoding ) );        
    		jw = new JsonWriter( bw );
           	jw.beginObject();

    		marshal( _OlapProjectInfoList, jw);
    		jw.endObject();
    		jw.close();
    		return out.toByteArray();
    		    	    		
		} finally{
		    if( jw != null ) jw.close();
		    if( bw != null ) bw.close();
		}								
	}
	
	
	public void marshal(com.tmax.hyperdata.ui_service.dto.OlapProjectInfoList _OlapProjectInfoList, JsonWriter writer )throws Exception{
	           
	
	
		writer.name("olapProjectInfoList"); 
						    					
		com.tmax.hyperdata.ui_service.dto.OlapProjectInfoMsgJson __olapProjectInfoList = new com.tmax.hyperdata.ui_service.dto.OlapProjectInfoMsgJson();					
		writer.beginArray();					
		for(int i = 0; i < _OlapProjectInfoList.sizeOlapProjectInfoList(); i++) {
			if(_OlapProjectInfoList.getOlapProjectInfoListList().get(i) != null) {
				writer.beginObject();
				__olapProjectInfoList.marshal((com.tmax.hyperdata.ui_service.dto.OlapProjectInfo)_OlapProjectInfoList.getOlapProjectInfoList(i), writer);
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
		
		com.tmax.hyperdata.ui_service.dto.OlapProjectInfoList _OlapProjectInfoList = new com.tmax.hyperdata.ui_service.dto.OlapProjectInfoList();
		BufferedReader reader = null;
		JsonReader jr = null;
		
		if( bytes.length <= 0)
			return new com.tmax.hyperdata.ui_service.dto.OlapProjectInfoList();
		
		try{
		reader = new BufferedReader( new InputStreamReader( new ByteArrayInputStream(bytes), this.encoding));		       
		jr = new JsonReader( reader );                
		jr.beginObject();
             


				_OlapProjectInfoList = (com.tmax.hyperdata.ui_service.dto.OlapProjectInfoList)unmarshal( jr,  _OlapProjectInfoList);
     
             
		jr.endObject();
		jr.close();
			
		}finally{
		   	if( jr != null ) jr.close();
		    if( reader != null ) reader.close();
		}
		                       
        return _OlapProjectInfoList;
	}
	
	
	// For PO7
	public DataObject unmarshal(byte[] bytes, DataObject dto) throws Exception {
		
		com.tmax.hyperdata.ui_service.dto.OlapProjectInfoList _OlapProjectInfoList = (com.tmax.hyperdata.ui_service.dto.OlapProjectInfoList) dto;
		BufferedReader reader = null;
		JsonReader jr = null;
		
		if( bytes.length <= 0)
			return new com.tmax.hyperdata.ui_service.dto.OlapProjectInfoList();
		
		try{
			reader = new BufferedReader( new InputStreamReader( new ByteArrayInputStream(bytes), this.encoding));		       
			jr = new JsonReader( reader );                
			jr.beginObject();


					_OlapProjectInfoList = (com.tmax.hyperdata.ui_service.dto.OlapProjectInfoList)unmarshal( jr,  _OlapProjectInfoList);
         
		         
			jr.endObject();
			jr.close();
				
		}finally{
		   	if( jr != null ) jr.close();
		    if( reader != null ) reader.close();
		}
		                       
	    return _OlapProjectInfoList;
	}
		
		 
	public DataObject unmarshal(JsonReader reader, com.tmax.hyperdata.ui_service.dto.OlapProjectInfoList dto) throws Exception{

		while( reader.hasNext() ){
			String name = reader.nextName();			
			setField(dto, reader, name);
       	 }
		 
		 dto.clearAllIsModified();
		 
       	 return dto;
	}
		 
	protected void setField(com.tmax.hyperdata.ui_service.dto.OlapProjectInfoList dto, JsonReader reader, String name) throws Exception{				
		
		switch(name) {		
		case "olapProjectInfoList" :
		{
			reader.beginArray();
			com.tmax.hyperdata.ui_service.dto.OlapProjectInfoMsgJson __olapProjectInfoList = new com.tmax.hyperdata.ui_service.dto.OlapProjectInfoMsgJson();
			while( reader.hasNext() ){	
				com.tmax.hyperdata.ui_service.dto.OlapProjectInfo ___OlapProjectInfo = new com.tmax.hyperdata.ui_service.dto.OlapProjectInfo();	
				reader.beginObject();
				dto.getOlapProjectInfoListList().add((com.tmax.hyperdata.ui_service.dto.OlapProjectInfo)__olapProjectInfoList.unmarshal( reader, ___OlapProjectInfo ));
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
