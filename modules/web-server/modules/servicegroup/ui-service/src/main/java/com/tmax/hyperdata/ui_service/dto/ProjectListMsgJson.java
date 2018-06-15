	
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




import com.tmax.hyperdata.ui_service.dto.ProjectMsgJson;


public class ProjectListMsgJson extends Message {	

	public byte[] marshal(DataObject obj) throws Exception {			
		com.tmax.hyperdata.ui_service.dto.ProjectList _ProjectList = (com.tmax.hyperdata.ui_service.dto.ProjectList)obj;
		
		if(_ProjectList == null)
			return null;
		
		BufferedWriter bw = null;
		JsonWriter jw = null;
		
		try{
		    
    		ByteArrayOutputStream out = new ByteArrayOutputStream(); 
    		bw = new BufferedWriter( new OutputStreamWriter( out , this.encoding ) );        
    		jw = new JsonWriter( bw );
           	jw.beginObject();

    		marshal( _ProjectList, jw);
    		jw.endObject();
    		jw.close();
    		return out.toByteArray();
    		    	    		
		} finally{
		    if( jw != null ) jw.close();
		    if( bw != null ) bw.close();
		}								
	}
	
	
	public void marshal(com.tmax.hyperdata.ui_service.dto.ProjectList _ProjectList, JsonWriter writer )throws Exception{
	           
	
	
		writer.name("project"); 
						    					
		com.tmax.hyperdata.ui_service.dto.ProjectMsgJson __project = new com.tmax.hyperdata.ui_service.dto.ProjectMsgJson();					
		writer.beginArray();					
		for(int i = 0; i < _ProjectList.sizeProject(); i++) {
			if(_ProjectList.getProjectList().get(i) != null) {
				writer.beginObject();
				__project.marshal((com.tmax.hyperdata.ui_service.dto.Project)_ProjectList.getProject(i), writer);
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
		
		com.tmax.hyperdata.ui_service.dto.ProjectList _ProjectList = new com.tmax.hyperdata.ui_service.dto.ProjectList();
		BufferedReader reader = null;
		JsonReader jr = null;
		
		if( bytes.length <= 0)
			return new com.tmax.hyperdata.ui_service.dto.ProjectList();
		
		try{
		reader = new BufferedReader( new InputStreamReader( new ByteArrayInputStream(bytes), this.encoding));		       
		jr = new JsonReader( reader );                
		jr.beginObject();
             


				_ProjectList = (com.tmax.hyperdata.ui_service.dto.ProjectList)unmarshal( jr,  _ProjectList);
     
             
		jr.endObject();
		jr.close();
			
		}finally{
		   	if( jr != null ) jr.close();
		    if( reader != null ) reader.close();
		}
		                       
        return _ProjectList;
	}
	
	
	// For PO7
	public DataObject unmarshal(byte[] bytes, DataObject dto) throws Exception {
		
		com.tmax.hyperdata.ui_service.dto.ProjectList _ProjectList = (com.tmax.hyperdata.ui_service.dto.ProjectList) dto;
		BufferedReader reader = null;
		JsonReader jr = null;
		
		if( bytes.length <= 0)
			return new com.tmax.hyperdata.ui_service.dto.ProjectList();
		
		try{
			reader = new BufferedReader( new InputStreamReader( new ByteArrayInputStream(bytes), this.encoding));		       
			jr = new JsonReader( reader );                
			jr.beginObject();


					_ProjectList = (com.tmax.hyperdata.ui_service.dto.ProjectList)unmarshal( jr,  _ProjectList);
         
		         
			jr.endObject();
			jr.close();
				
		}finally{
		   	if( jr != null ) jr.close();
		    if( reader != null ) reader.close();
		}
		                       
	    return _ProjectList;
	}
		
		 
	public DataObject unmarshal(JsonReader reader, com.tmax.hyperdata.ui_service.dto.ProjectList dto) throws Exception{

		while( reader.hasNext() ){
			String name = reader.nextName();			
			setField(dto, reader, name);
       	 }
		 
		 dto.clearAllIsModified();
		 
       	 return dto;
	}
		 
	protected void setField(com.tmax.hyperdata.ui_service.dto.ProjectList dto, JsonReader reader, String name) throws Exception{				
		
		switch(name) {		
		case "project" :
		{
			reader.beginArray();
			com.tmax.hyperdata.ui_service.dto.ProjectMsgJson __project = new com.tmax.hyperdata.ui_service.dto.ProjectMsgJson();
			while( reader.hasNext() ){	
				com.tmax.hyperdata.ui_service.dto.Project ___Project = new com.tmax.hyperdata.ui_service.dto.Project();	
				reader.beginObject();
				dto.getProjectList().add((com.tmax.hyperdata.ui_service.dto.Project)__project.unmarshal( reader, ___Project ));
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
