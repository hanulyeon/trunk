package com.tmax.hyperdata.ui_service.dto;
	


import java.io.IOException;
import java.util.List;

import java.util.ArrayList;

import java.util.Map;

import com.tmax.promapper.engine.dto.record.common.FieldProperty;
import com.tmax.promapper.engine.dto.record.common.FieldPropertyFactory;
import com.tmax.proobject.model.exception.FieldNotFoundException;
import com.tmax.proobject.core.exception.ProObjectRuntimeException;
import com.tmax.proobject.core.constant.ProObjectExceptionCode;

import com.tmax.proobject.model.dataobject.DataObject;








@com.tmax.proobject.core.DataObject
public class Empty extends DataObject {
	private static final String DTO_LOGICAL_NAME = "empty";
	
	public String getDtoLogicalName() {
		return DTO_LOGICAL_NAME;
	}
	
	private static final long serialVersionUID= 1L;
	
	public Empty() {
			super();
			
	}	 
	
	private boolean isModified = false;

	/**
	 * LogicalName : message
	 * Comments    : 
	 */		

	private String message = EMPTY_STRING;
	
			
	private boolean message_nullable = false;
	
	public boolean isNullableMessage() {
		return this.message_nullable;
	}	
	
	private boolean message_invalidation = false;
	
	public void setInvalidationMessage(boolean invalidation) { 
		this.message_invalidation = invalidation;
	}
	
	public boolean isInvalidationMessage() {
		return this.message_invalidation;
	}
	
	private boolean message_modified = false;
	

	public boolean isModifiedMessage() {
		return this.message_modified;
	}
	
	public void unModifiedMessage() {
		this.message_modified = false;
	}

	public String getMessage() {
		return message;
	}
	public String getNvlMessage() {
		if(getMessage() == null) {
			return  EMPTY_STRING;
		} else {
			return getMessage();
		}
	}
	public void setMessage(String message) {
		if(message == null) {
			this.message  = EMPTY_STRING;
		} else {
			this.message = message;
		}
		this.message_modified = true;
		this.isModified = true;
	}	
			

	@Override
	public void clearAllIsModified() {
		this.message_modified = false;
		this.isModified = false;
	}
	
	@Override
	public List<String> getIsModifiedField() {
		List<String> modifiedFields = new ArrayList<>();
		if(this.message_modified == true)
			modifiedFields.add("message");
		return modifiedFields;
	}
	
	@Override
	public boolean isModified() {
	    return isModified;
	} 
	public Object clone() {
		Empty copyObj = new Empty();	
		copyObj.clone(this);
		return copyObj;
	}
	public void clone(DataObject _empty) {
		if(this == _empty) return;
		Empty __empty = (Empty) _empty;
		
		this.setMessage(__empty.getMessage());
		
	}

	public String toString() {
		StringBuilder buffer = new StringBuilder();
				
		buffer.append("message : ").append(message).append("\n");		
		return buffer.toString();
	}
	private static final Map<String,FieldProperty> fieldPropertyMap;
	
	static {
		fieldPropertyMap = new java.util.LinkedHashMap<String,FieldProperty>(1);
		fieldPropertyMap.put("message"
							, FieldPropertyFactory.getFieldProperty( "message","", "", "", false, false, false,  FieldProperty.TYPE_OBJECT_STRING, 512 , -1, null, null));		
	}

	public Map<String,FieldProperty> getFieldPropertyMap() {
		return fieldPropertyMap;
	}
	
	public static Map<String,FieldProperty> getFieldPropertyMapByStatic() {
		return fieldPropertyMap;
	}	

	public Object get(String fieldName) throws FieldNotFoundException {
		switch(fieldName) {
			case "message" : return getMessage();
			default : throw new FieldNotFoundException(fieldName);		
		}
	}




	public void set(String fieldName, Object arg) throws FieldNotFoundException {
		switch(fieldName) {
			case "message" : setMessage((String)arg);break;
			default : throw new FieldNotFoundException(fieldName);		
		}
	}
	

	public boolean equals(Empty obj) {
		if (obj == this) return true;					
		if(this.message != null ? !this.message.equals(obj.getMessage()) : obj.getMessage() != null) return false; 					
		return true;
	}
	private void writeObject(java.io.ObjectOutputStream stream)throws IOException {
		stream.defaultWriteObject();
	}
	
	
}
