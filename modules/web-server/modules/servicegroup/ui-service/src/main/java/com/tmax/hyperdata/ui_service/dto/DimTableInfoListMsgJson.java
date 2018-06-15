	
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




import com.tmax.hyperdata.ui_service.dto.DimTableInfoMsgJson;


public class DimTableInfoListMsgJson extends Message {	

	public byte[] marshal(DataObject obj) throws Exception {			
		com.tmax.hyperdata.ui_service.dto.DimTableInfoList _DimTableInfoList = (com.tmax.hyperdata.ui_service.dto.DimTableInfoList)obj;
		
		if(_DimTableInfoList == null)
			return null;
		
		BufferedWriter bw = null;
		JsonWriter jw = null;
		
		try{
		    
    		ByteArrayOutputStream out = new ByteArrayOutputStream(); 
    		bw = new BufferedWriter( new OutputStreamWriter( out , this.encoding ) );        
    		jw = new JsonWriter( bw );
           	jw.beginObject();

    		marshal( _DimTableInfoList, jw);
    		jw.endObject();
    		jw.close();
    		return out.toByteArray();
    		    	    		
		} finally{
		    if( jw != null ) jw.close();
		    if( bw != null ) bw.close();
		}								
	}
	
	
	public void marshal(com.tmax.hyperdata.ui_service.dto.DimTableInfoList _DimTableInfoList, JsonWriter writer )throws Exception{
	           
	
	
		writer.name("dimTableInfoList"); 
						    					
		com.tmax.hyperdata.ui_service.dto.DimTableInfoMsgJson __dimTableInfoList = new com.tmax.hyperdata.ui_service.dto.DimTableInfoMsgJson();					
		writer.beginArray();					
		for(int i = 0; i < _DimTableInfoList.sizeDimTableInfoList(); i++) {
			if(_DimTableInfoList.getDimTableInfoListList().get(i) != null) {
				writer.beginObject();
				__dimTableInfoList.marshal((com.tmax.hyperdata.ui_service.dto.DimTableInfo)_DimTableInfoList.getDimTableInfoList(i), writer);
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
		
		com.tmax.hyperdata.ui_service.dto.DimTableInfoList _DimTableInfoList = new com.tmax.hyperdata.ui_service.dto.DimTableInfoList();
		BufferedReader reader = null;
		JsonReader jr = null;
		
		if( bytes.length <= 0)
			return new com.tmax.hyperdata.ui_service.dto.DimTableInfoList();
		
		try{
		reader = new BufferedReader( new InputStreamReader( new ByteArrayInputStream(bytes), this.encoding));		       
		jr = new JsonReader( reader );                
		jr.beginObject();
             


				_DimTableInfoList = (com.tmax.hyperdata.ui_service.dto.DimTableInfoList)unmarshal( jr,  _DimTableInfoList);
     
             
		jr.endObject();
		jr.close();
			
		}finally{
		   	if( jr != null ) jr.close();
		    if( reader != null ) reader.close();
		}
		                       
        return _DimTableInfoList;
	}
	
	
	// For PO7
	public DataObject unmarshal(byte[] bytes, DataObject dto) throws Exception {
		
		com.tmax.hyperdata.ui_service.dto.DimTableInfoList _DimTableInfoList = (com.tmax.hyperdata.ui_service.dto.DimTableInfoList) dto;
		BufferedReader reader = null;
		JsonReader jr = null;
		
		if( bytes.length <= 0)
			return new com.tmax.hyperdata.ui_service.dto.DimTableInfoList();
		
		try{
			reader = new BufferedReader( new InputStreamReader( new ByteArrayInputStream(bytes), this.encoding));		       
			jr = new JsonReader( reader );                
			jr.beginObject();


					_DimTableInfoList = (com.tmax.hyperdata.ui_service.dto.DimTableInfoList)unmarshal( jr,  _DimTableInfoList);
         
		         
			jr.endObject();
			jr.close();
				
		}finally{
		   	if( jr != null ) jr.close();
		    if( reader != null ) reader.close();
		}
		                       
	    return _DimTableInfoList;
	}
		
		 
	public DataObject unmarshal(JsonReader reader, com.tmax.hyperdata.ui_service.dto.DimTableInfoList dto) throws Exception{

		while( reader.hasNext() ){
			String name = reader.nextName();			
			setField(dto, reader, name);
       	 }
		 
		 dto.clearAllIsModified();
		 
       	 return dto;
	}
		 
	protected void setField(com.tmax.hyperdata.ui_service.dto.DimTableInfoList dto, JsonReader reader, String name) throws Exception{				
		
		switch(name) {		
		case "dimTableInfoList" :
		{
			reader.beginArray();
			com.tmax.hyperdata.ui_service.dto.DimTableInfoMsgJson __dimTableInfoList = new com.tmax.hyperdata.ui_service.dto.DimTableInfoMsgJson();
			while( reader.hasNext() ){	
				com.tmax.hyperdata.ui_service.dto.DimTableInfo ___DimTableInfo = new com.tmax.hyperdata.ui_service.dto.DimTableInfo();	
				reader.beginObject();
				dto.getDimTableInfoListList().add((com.tmax.hyperdata.ui_service.dto.DimTableInfo)__dimTableInfoList.unmarshal( reader, ___DimTableInfo ));
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
