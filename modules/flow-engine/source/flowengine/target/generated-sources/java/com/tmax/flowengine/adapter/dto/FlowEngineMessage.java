	
package com.tmax.flowengine.adapter.dto;

import java.io.IOException;
import java.util.List;

import java.util.ArrayList;

import java.util.Map;

import com.tmax.promapper.engine.dto.record.common.FieldProperty;
import com.tmax.promapper.engine.dto.record.common.FieldPropertyFactory;
import com.tmax.proobject.model.exception.FieldNotFoundException;

import com.tmax.proobject.model.dataobject.DataObject;








@com.tmax.proobject.core.DataObject
public class FlowEngineMessage extends DataObject {
	private static final String DTO_LOGICAL_NAME = "FlowEngineMessage";
	
	public String getDtoLogicalName() {
		return DTO_LOGICAL_NAME;
	}
	
	private static final long serialVersionUID= 1L;
	
	public FlowEngineMessage() {
			super();
			
	}	 
	
	private boolean isModified = false;

	/**
	 * LogicalName : guid
	 * Comments    : 
	 */		

	private long guid;
	
		
	
	private boolean guid_invalidation = false;
	
	public void setInvalidationGuid(boolean invalidation) { 
		this.guid_invalidation = invalidation;
	}
	
	public boolean isInvalidationGuid() {
		return this.guid_invalidation;
	}
	
	private boolean guid_modified = false;
	

	public boolean isModifiedGuid() {
		return this.guid_modified;
	}
	
	public void unModifiedGuid() {
		this.guid_modified = false;
	}

	public long getGuid() {
		return guid;
	}
	public void setGuid(long guid) {
		this.guid = guid;
		this.guid_modified = true;
		this.isModified = true;
	}
	
	public void setGuid(Long guid) {
		if(guid == null) {
			this.guid = 0;
		} else {
			this.guid = guid.longValue();
		}
		this.guid_modified = true;
		this.isModified = true;
	}
	public void setGuid(String guid) {
		if(guid == null || guid.length() == 0) {
			this.guid = 0;
		} else {
			this.guid = Long.parseLong( guid);
		}
		this.guid_modified = true;
		this.isModified = true;
	}			

	/**
	 * LogicalName : sessionId
	 * Comments    : 
	 */		

	private long sessionId;
	
		
	
	private boolean sessionId_invalidation = false;
	
	public void setInvalidationSessionId(boolean invalidation) { 
		this.sessionId_invalidation = invalidation;
	}
	
	public boolean isInvalidationSessionId() {
		return this.sessionId_invalidation;
	}
	
	private boolean sessionId_modified = false;
	

	public boolean isModifiedSessionId() {
		return this.sessionId_modified;
	}
	
	public void unModifiedSessionId() {
		this.sessionId_modified = false;
	}

	public long getSessionId() {
		return sessionId;
	}
	public void setSessionId(long sessionId) {
		this.sessionId = sessionId;
		this.sessionId_modified = true;
		this.isModified = true;
	}
	
	public void setSessionId(Long sessionId) {
		if(sessionId == null) {
			this.sessionId = 0;
		} else {
			this.sessionId = sessionId.longValue();
		}
		this.sessionId_modified = true;
		this.isModified = true;
	}
	public void setSessionId(String sessionId) {
		if(sessionId == null || sessionId.length() == 0) {
			this.sessionId = 0;
		} else {
			this.sessionId = Long.parseLong( sessionId);
		}
		this.sessionId_modified = true;
		this.isModified = true;
	}			

	/**
	 * LogicalName : flowId
	 * Comments    : 
	 */		

	private long flowId;
	
		
	
	private boolean flowId_invalidation = false;
	
	public void setInvalidationFlowId(boolean invalidation) { 
		this.flowId_invalidation = invalidation;
	}
	
	public boolean isInvalidationFlowId() {
		return this.flowId_invalidation;
	}
	
	private boolean flowId_modified = false;
	

	public boolean isModifiedFlowId() {
		return this.flowId_modified;
	}
	
	public void unModifiedFlowId() {
		this.flowId_modified = false;
	}

	public long getFlowId() {
		return flowId;
	}
	public void setFlowId(long flowId) {
		this.flowId = flowId;
		this.flowId_modified = true;
		this.isModified = true;
	}
	
	public void setFlowId(Long flowId) {
		if(flowId == null) {
			this.flowId = 0;
		} else {
			this.flowId = flowId.longValue();
		}
		this.flowId_modified = true;
		this.isModified = true;
	}
	public void setFlowId(String flowId) {
		if(flowId == null || flowId.length() == 0) {
			this.flowId = 0;
		} else {
			this.flowId = Long.parseLong( flowId);
		}
		this.flowId_modified = true;
		this.isModified = true;
	}			

	/**
	 * LogicalName : sync
	 * Comments    : 
	 */		

	private boolean sync;
	
		
	
	private boolean sync_invalidation = false;
	
	public void setInvalidationSync(boolean invalidation) { 
		this.sync_invalidation = invalidation;
	}
	
	public boolean isInvalidationSync() {
		return this.sync_invalidation;
	}
	
	private boolean sync_modified = false;
	

	public boolean isModifiedSync() {
		return this.sync_modified;
	}
	
	public void unModifiedSync() {
		this.sync_modified = false;
	}

	public boolean getSync() {
		return sync;
	}
	public void setSync(boolean sync) {
		this.sync = sync;
		this.sync_modified = true;
		this.isModified = true;
	}
	
	public void setSync(Boolean sync) {
		if(sync == null) {
			this.sync = false;
		} else {
			this.sync = sync.booleanValue();
		}
		this.sync_modified = true;
		this.isModified = true;
	}		

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
		this.guid_modified = false;
		this.sessionId_modified = false;
		this.flowId_modified = false;
		this.sync_modified = false;
		this.message_modified = false;
		this.isModified = false;
	}
	
	@Override
	public List<String> getIsModifiedField() {
		List<String> modifiedFields = new ArrayList<>();
		if(this.guid_modified == true)
			modifiedFields.add("guid");
		if(this.sessionId_modified == true)
			modifiedFields.add("sessionId");
		if(this.flowId_modified == true)
			modifiedFields.add("flowId");
		if(this.sync_modified == true)
			modifiedFields.add("sync");
		if(this.message_modified == true)
			modifiedFields.add("message");
		return modifiedFields;
	}
	
	@Override
	public boolean isModified() {
	    return isModified;
	} 
	public Object clone() {
		FlowEngineMessage copyObj = new FlowEngineMessage();	
		copyObj.clone(this);
		return copyObj;
	}
	public void clone(DataObject _flowEngineMessage) {
		if(this == _flowEngineMessage) return;
		FlowEngineMessage __flowEngineMessage = (FlowEngineMessage) _flowEngineMessage;
		
		this.setGuid(__flowEngineMessage.getGuid());
		this.setSessionId(__flowEngineMessage.getSessionId());
		this.setFlowId(__flowEngineMessage.getFlowId());
		this.setSync(__flowEngineMessage.getSync());
		this.setMessage(__flowEngineMessage.getMessage());
		
	}

	public String toString() {
		StringBuilder buffer = new StringBuilder();
				
		buffer.append("guid : ").append(guid).append("\n");				
		buffer.append("sessionId : ").append(sessionId).append("\n");				
		buffer.append("flowId : ").append(flowId).append("\n");				
		buffer.append("sync : ").append(sync).append("\n");				
		buffer.append("message : ").append(message).append("\n");		
		return buffer.toString();
	}
	private static final Map<String,FieldProperty> fieldPropertyMap;
	
	static {
		fieldPropertyMap = new java.util.LinkedHashMap<String,FieldProperty>(5);
		fieldPropertyMap.put("guid"
							, FieldPropertyFactory.getFieldProperty( "guid",FieldProperty.TYPE_PRIMITIVE_LONG, 16 , -1, null, null));		
		fieldPropertyMap.put("sessionId"
							, FieldPropertyFactory.getFieldProperty( "sessionId",FieldProperty.TYPE_PRIMITIVE_LONG, 16 , -1, null, null));		
		fieldPropertyMap.put("flowId"
							, FieldPropertyFactory.getFieldProperty( "flowId",FieldProperty.TYPE_PRIMITIVE_LONG, 16 , -1, null, null));		
		fieldPropertyMap.put("sync"
							, FieldPropertyFactory.getFieldProperty( "sync",FieldProperty.TYPE_PRIMITIVE_BOOLEAN, 1 , -1, null, null));		
		fieldPropertyMap.put("message"
							, FieldPropertyFactory.getFieldProperty( "message",FieldProperty.TYPE_OBJECT_STRING, 16 , -1, null, null));		
	}

	public Map<String,FieldProperty> getFieldPropertyMap() {
		return fieldPropertyMap;
	}
	
	public static Map<String,FieldProperty> getFieldPropertyMapByStatic() {
		return fieldPropertyMap;
	}	

	public Object get(String fieldName) throws FieldNotFoundException {
		switch(fieldName) {
			case "guid" : return getGuid();
			case "sessionId" : return getSessionId();
			case "flowId" : return getFlowId();
			case "sync" : return getSync();
			case "message" : return getMessage();
			default : throw new FieldNotFoundException(fieldName);		
		}
	}




	public void set(String fieldName, Object arg) throws FieldNotFoundException {
		switch(fieldName) {
			case "guid" : setGuid((Long)arg);break;
			case "sessionId" : setSessionId((Long)arg);break;
			case "flowId" : setFlowId((Long)arg);break;
			case "sync" : setSync((Boolean)arg);break;
			case "message" : setMessage((String)arg);break;
			default : throw new FieldNotFoundException(fieldName);		
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if ((obj instanceof FlowEngineMessage) == false) return false;
		FlowEngineMessage _FlowEngineMessage = (FlowEngineMessage) obj;				
		if(this.guid != _FlowEngineMessage.getGuid()) return false; 								
		if(this.sessionId != _FlowEngineMessage.getSessionId()) return false; 								
		if(this.flowId != _FlowEngineMessage.getFlowId()) return false; 								
		if(this.sync != _FlowEngineMessage.getSync()) return false; 									
		if(this.message != null ? !this.message.equals(_FlowEngineMessage.getMessage()) : _FlowEngineMessage.getMessage() != null) return false; 					
		return true;
	}

	@Override
	public int hashCode() {
		int prime = 31;
		int result = 1;
		result = prime * result + (int)(guid^(guid >>> 32));
		result = prime * result + (int)(sessionId^(sessionId >>> 32));
		result = prime * result + (int)(flowId^(flowId >>> 32));
		result = prime * result + (sync ? 1:0);					
		result = prime * result + ((message == null) ? 0 : message.hashCode());								
		return result;
	}
	
	private void writeObject(java.io.ObjectOutputStream stream)throws IOException {
		stream.defaultWriteObject();
	}
	
	
}

