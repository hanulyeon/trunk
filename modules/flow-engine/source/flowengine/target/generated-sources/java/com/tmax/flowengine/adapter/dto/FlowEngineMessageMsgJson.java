	
package com.tmax.flowengine.adapter.dto;
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






public class FlowEngineMessageMsgJson extends Message {	

	public byte[] marshal(DataObject obj) throws Exception {			
		com.tmax.flowengine.adapter.dto.FlowEngineMessage _FlowEngineMessage = (com.tmax.flowengine.adapter.dto.FlowEngineMessage)obj;
		
		if(_FlowEngineMessage == null)
			return null;
		
		BufferedWriter bw = null;
		JsonWriter jw = null;
		
		try{
		    
    		ByteArrayOutputStream out = new ByteArrayOutputStream(); 
    		bw = new BufferedWriter( new OutputStreamWriter( out , this.encoding ) );        
    		jw = new JsonWriter( bw );
           	jw.beginObject();

    		marshal( _FlowEngineMessage, jw);
    		jw.endObject();
    		jw.close();
    		return out.toByteArray();
    		    	    		
		} finally{
		    if( jw != null ) jw.close();
		    if( bw != null ) bw.close();
		}								
	}
	
	
	public void marshal(com.tmax.flowengine.adapter.dto.FlowEngineMessage _FlowEngineMessage, JsonWriter writer )throws Exception{
	           
		
		writer.name("guid"); 
		writer.value(_FlowEngineMessage.getGuid());
		
		writer.name("sessionId"); 
		writer.value(_FlowEngineMessage.getSessionId());
		
		writer.name("flowId"); 
		writer.value(_FlowEngineMessage.getFlowId());
		
		writer.name("sync"); 
		writer.value(_FlowEngineMessage.getSync());
		
	
		if (_FlowEngineMessage.getMessage() != null) {
			writer.name("message"); 
			writer.value(_FlowEngineMessage.getMessage());
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
		
		com.tmax.flowengine.adapter.dto.FlowEngineMessage _FlowEngineMessage = new com.tmax.flowengine.adapter.dto.FlowEngineMessage();
		BufferedReader reader = null;
		JsonReader jr = null;
		
		if( bytes.length <= 0)
			return new com.tmax.flowengine.adapter.dto.FlowEngineMessage();
		
		try{
		reader = new BufferedReader( new InputStreamReader( new ByteArrayInputStream(bytes), this.encoding));		       
		jr = new JsonReader( reader );                
		jr.beginObject();
             


				_FlowEngineMessage = (com.tmax.flowengine.adapter.dto.FlowEngineMessage)unmarshal( jr,  _FlowEngineMessage);
     
             
		jr.endObject();
		jr.close();
			
		}finally{
		   	if( jr != null ) jr.close();
		    if( reader != null ) reader.close();
		}
		                       
        return _FlowEngineMessage;
	}
	
	
	// For PO7
	public DataObject unmarshal(byte[] bytes, DataObject dto) throws Exception {
		
		com.tmax.flowengine.adapter.dto.FlowEngineMessage _FlowEngineMessage = (com.tmax.flowengine.adapter.dto.FlowEngineMessage) dto;
		BufferedReader reader = null;
		JsonReader jr = null;
		
		if( bytes.length <= 0)
			return new com.tmax.flowengine.adapter.dto.FlowEngineMessage();
		
		try{
			reader = new BufferedReader( new InputStreamReader( new ByteArrayInputStream(bytes), this.encoding));		       
			jr = new JsonReader( reader );                
			jr.beginObject();


					_FlowEngineMessage = (com.tmax.flowengine.adapter.dto.FlowEngineMessage)unmarshal( jr,  _FlowEngineMessage);
         
		         
			jr.endObject();
			jr.close();
				
		}finally{
		   	if( jr != null ) jr.close();
		    if( reader != null ) reader.close();
		}
		                       
	    return _FlowEngineMessage;
	}
		
		 
	public DataObject unmarshal(JsonReader reader, com.tmax.flowengine.adapter.dto.FlowEngineMessage dto) throws Exception{

		while( reader.hasNext() ){
			String name = reader.nextName();			
			setField(dto, reader, name);
       	 }
		 
		 dto.clearAllIsModified();
		 
       	 return dto;
	}
		 
	protected void setField(com.tmax.flowengine.adapter.dto.FlowEngineMessage dto, JsonReader reader, String name) throws Exception{				
		
		switch(name) {		
	
		case "guid" :
		{	
			dto.setGuid( reader.nextLong());									
			break;
		}	
	
			
	
		case "sessionId" :
		{	
			dto.setSessionId( reader.nextLong());									
			break;
		}	
	
			
	
		case "flowId" :
		{	
			dto.setFlowId( reader.nextLong());									
			break;
		}	
	
			
	
		case "sync" :
		{	
			dto.setSync( reader.nextBoolean());									
			break;
		}	
	
			
	
		case "message" :
		{	
			dto.setMessage( reader.nextString());									
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

