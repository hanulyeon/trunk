	
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




import com.tmax.hyperdata.ui_service.dto.OlapModelInfoMsgJson;


public class OlapModelInfoListMsgJson extends Message {	

	public byte[] marshal(DataObject obj) throws Exception {			
		com.tmax.hyperdata.ui_service.dto.OlapModelInfoList _OlapModelInfoList = (com.tmax.hyperdata.ui_service.dto.OlapModelInfoList)obj;
		
		if(_OlapModelInfoList == null)
			return null;
		
		BufferedWriter bw = null;
		JsonWriter jw = null;
		
		try{
		    
    		ByteArrayOutputStream out = new ByteArrayOutputStream(); 
    		bw = new BufferedWriter( new OutputStreamWriter( out , this.encoding ) );        
    		jw = new JsonWriter( bw );
           	jw.beginObject();

    		marshal( _OlapModelInfoList, jw);
    		jw.endObject();
    		jw.close();
    		return out.toByteArray();
    		    	    		
		} finally{
		    if( jw != null ) jw.close();
		    if( bw != null ) bw.close();
		}								
	}
	
	
	public void marshal(com.tmax.hyperdata.ui_service.dto.OlapModelInfoList _OlapModelInfoList, JsonWriter writer )throws Exception{
	           
	
	
		writer.name("olapModelInfoList"); 
						    					
		com.tmax.hyperdata.ui_service.dto.OlapModelInfoMsgJson __olapModelInfoList = new com.tmax.hyperdata.ui_service.dto.OlapModelInfoMsgJson();					
		writer.beginArray();					
		for(int i = 0; i < _OlapModelInfoList.sizeOlapModelInfoList(); i++) {
			if(_OlapModelInfoList.getOlapModelInfoListList().get(i) != null) {
				writer.beginObject();
				__olapModelInfoList.marshal((com.tmax.hyperdata.ui_service.dto.OlapModelInfo)_OlapModelInfoList.getOlapModelInfoList(i), writer);
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
		
		com.tmax.hyperdata.ui_service.dto.OlapModelInfoList _OlapModelInfoList = new com.tmax.hyperdata.ui_service.dto.OlapModelInfoList();
		BufferedReader reader = null;
		JsonReader jr = null;
		
		if( bytes.length <= 0)
			return new com.tmax.hyperdata.ui_service.dto.OlapModelInfoList();
		
		try{
		reader = new BufferedReader( new InputStreamReader( new ByteArrayInputStream(bytes), this.encoding));		       
		jr = new JsonReader( reader );                
		jr.beginObject();
             


				_OlapModelInfoList = (com.tmax.hyperdata.ui_service.dto.OlapModelInfoList)unmarshal( jr,  _OlapModelInfoList);
     
             
		jr.endObject();
		jr.close();
			
		}finally{
		   	if( jr != null ) jr.close();
		    if( reader != null ) reader.close();
		}
		                       
        return _OlapModelInfoList;
	}
	
	
	// For PO7
	public DataObject unmarshal(byte[] bytes, DataObject dto) throws Exception {
		
		com.tmax.hyperdata.ui_service.dto.OlapModelInfoList _OlapModelInfoList = (com.tmax.hyperdata.ui_service.dto.OlapModelInfoList) dto;
		BufferedReader reader = null;
		JsonReader jr = null;
		
		if( bytes.length <= 0)
			return new com.tmax.hyperdata.ui_service.dto.OlapModelInfoList();
		
		try{
			reader = new BufferedReader( new InputStreamReader( new ByteArrayInputStream(bytes), this.encoding));		       
			jr = new JsonReader( reader );                
			jr.beginObject();


					_OlapModelInfoList = (com.tmax.hyperdata.ui_service.dto.OlapModelInfoList)unmarshal( jr,  _OlapModelInfoList);
         
		         
			jr.endObject();
			jr.close();
				
		}finally{
		   	if( jr != null ) jr.close();
		    if( reader != null ) reader.close();
		}
		                       
	    return _OlapModelInfoList;
	}
		
		 
	public DataObject unmarshal(JsonReader reader, com.tmax.hyperdata.ui_service.dto.OlapModelInfoList dto) throws Exception{

		while( reader.hasNext() ){
			String name = reader.nextName();			
			setField(dto, reader, name);
       	 }
		 
		 dto.clearAllIsModified();
		 
       	 return dto;
	}
		 
	protected void setField(com.tmax.hyperdata.ui_service.dto.OlapModelInfoList dto, JsonReader reader, String name) throws Exception{				
		
		switch(name) {		
		case "olapModelInfoList" :
		{
			reader.beginArray();
			com.tmax.hyperdata.ui_service.dto.OlapModelInfoMsgJson __olapModelInfoList = new com.tmax.hyperdata.ui_service.dto.OlapModelInfoMsgJson();
			while( reader.hasNext() ){	
				com.tmax.hyperdata.ui_service.dto.OlapModelInfo ___OlapModelInfo = new com.tmax.hyperdata.ui_service.dto.OlapModelInfo();	
				reader.beginObject();
				dto.getOlapModelInfoListList().add((com.tmax.hyperdata.ui_service.dto.OlapModelInfo)__olapModelInfoList.unmarshal( reader, ___OlapModelInfo ));
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
