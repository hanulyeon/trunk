	
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
public class AdapterInfo extends DataObject {
	private static final String DTO_LOGICAL_NAME = "AdapterInfo";
	
	public String getDtoLogicalName() {
		return DTO_LOGICAL_NAME;
	}
	
	private static final long serialVersionUID= 1L;
	
	public AdapterInfo() {
			super();
			
	}	 
	
	private boolean isModified = false;

	/**
	 * LogicalName : id
	 * Comments    : 
	 */		

	private long id;
	
		
	
	private boolean id_invalidation = false;
	
	public void setInvalidationId(boolean invalidation) { 
		this.id_invalidation = invalidation;
	}
	
	public boolean isInvalidationId() {
		return this.id_invalidation;
	}
	
	private boolean id_modified = false;
	

	public boolean isModifiedId() {
		return this.id_modified;
	}
	
	public void unModifiedId() {
		this.id_modified = false;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
		this.id_modified = true;
		this.isModified = true;
	}
	
	public void setId(Long id) {
		if(id == null) {
			this.id = 0;
		} else {
			this.id = id.longValue();
		}
		this.id_modified = true;
		this.isModified = true;
	}
	public void setId(String id) {
		if(id == null || id.length() == 0) {
			this.id = 0;
		} else {
			this.id = Long.parseLong( id);
		}
		this.id_modified = true;
		this.isModified = true;
	}			

	/**
	 * LogicalName : name
	 * Comments    : 
	 */		

	private String name = EMPTY_STRING;
	
			
	private boolean name_nullable = false;
	
	public boolean isNullableName() {
		return this.name_nullable;
	}	
	
	private boolean name_invalidation = false;
	
	public void setInvalidationName(boolean invalidation) { 
		this.name_invalidation = invalidation;
	}
	
	public boolean isInvalidationName() {
		return this.name_invalidation;
	}
	
	private boolean name_modified = false;
	

	public boolean isModifiedName() {
		return this.name_modified;
	}
	
	public void unModifiedName() {
		this.name_modified = false;
	}

	public String getName() {
		return name;
	}
	public String getNvlName() {
		if(getName() == null) {
			return  EMPTY_STRING;
		} else {
			return getName();
		}
	}
	public void setName(String name) {
		if(name == null) {
			this.name  = EMPTY_STRING;
		} else {
			this.name = name;
		}
		this.name_modified = true;
		this.isModified = true;
	}	
			

	/**
	 * LogicalName : type
	 * Comments    : 
	 */		

	private String type = EMPTY_STRING;
	
			
	private boolean type_nullable = false;
	
	public boolean isNullableType() {
		return this.type_nullable;
	}	
	
	private boolean type_invalidation = false;
	
	public void setInvalidationType(boolean invalidation) { 
		this.type_invalidation = invalidation;
	}
	
	public boolean isInvalidationType() {
		return this.type_invalidation;
	}
	
	private boolean type_modified = false;
	

	public boolean isModifiedType() {
		return this.type_modified;
	}
	
	public void unModifiedType() {
		this.type_modified = false;
	}

	public String getType() {
		return type;
	}
	public String getNvlType() {
		if(getType() == null) {
			return  EMPTY_STRING;
		} else {
			return getType();
		}
	}
	public void setType(String type) {
		if(type == null) {
			this.type  = EMPTY_STRING;
		} else {
			this.type = type;
		}
		this.type_modified = true;
		this.isModified = true;
	}	
			

	@Override
	public void clearAllIsModified() {
		this.id_modified = false;
		this.name_modified = false;
		this.type_modified = false;
		this.isModified = false;
	}
	
	@Override
	public List<String> getIsModifiedField() {
		List<String> modifiedFields = new ArrayList<>();
		if(this.id_modified == true)
			modifiedFields.add("id");
		if(this.name_modified == true)
			modifiedFields.add("name");
		if(this.type_modified == true)
			modifiedFields.add("type");
		return modifiedFields;
	}
	
	@Override
	public boolean isModified() {
	    return isModified;
	} 
	public Object clone() {
		AdapterInfo copyObj = new AdapterInfo();	
		copyObj.clone(this);
		return copyObj;
	}
	public void clone(DataObject _adapterInfo) {
		if(this == _adapterInfo) return;
		AdapterInfo __adapterInfo = (AdapterInfo) _adapterInfo;
		
		this.setId(__adapterInfo.getId());
		this.setName(__adapterInfo.getName());
		this.setType(__adapterInfo.getType());
		
	}

	public String toString() {
		StringBuilder buffer = new StringBuilder();
				
		buffer.append("id : ").append(id).append("\n");				
		buffer.append("name : ").append(name).append("\n");				
		buffer.append("type : ").append(type).append("\n");		
		return buffer.toString();
	}
	private static final Map<String,FieldProperty> fieldPropertyMap;
	
	static {
		fieldPropertyMap = new java.util.LinkedHashMap<String,FieldProperty>(3);
		fieldPropertyMap.put("id"
							, FieldPropertyFactory.getFieldProperty( "id",FieldProperty.TYPE_PRIMITIVE_LONG, 16 , -1, null, null));		
		fieldPropertyMap.put("name"
							, FieldPropertyFactory.getFieldProperty( "name",FieldProperty.TYPE_OBJECT_STRING, 16 , -1, null, null));		
		fieldPropertyMap.put("type"
							, FieldPropertyFactory.getFieldProperty( "type",FieldProperty.TYPE_OBJECT_STRING, 16 , -1, null, null));		
	}

	public Map<String,FieldProperty> getFieldPropertyMap() {
		return fieldPropertyMap;
	}
	
	public static Map<String,FieldProperty> getFieldPropertyMapByStatic() {
		return fieldPropertyMap;
	}	

	public Object get(String fieldName) throws FieldNotFoundException {
		switch(fieldName) {
			case "id" : return getId();
			case "name" : return getName();
			case "type" : return getType();
			default : throw new FieldNotFoundException(fieldName);		
		}
	}




	public void set(String fieldName, Object arg) throws FieldNotFoundException {
		switch(fieldName) {
			case "id" : setId((Long)arg);break;
			case "name" : setName((String)arg);break;
			case "type" : setType((String)arg);break;
			default : throw new FieldNotFoundException(fieldName);		
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if ((obj instanceof AdapterInfo) == false) return false;
		AdapterInfo _AdapterInfo = (AdapterInfo) obj;				
		if(this.id != _AdapterInfo.getId()) return false; 									
		if(this.name != null ? !this.name.equals(_AdapterInfo.getName()) : _AdapterInfo.getName() != null) return false; 										
		if(this.type != null ? !this.type.equals(_AdapterInfo.getType()) : _AdapterInfo.getType() != null) return false; 					
		return true;
	}

	@Override
	public int hashCode() {
		int prime = 31;
		int result = 1;
		result = prime * result + (int)(id^(id >>> 32));					
		result = prime * result + ((name == null) ? 0 : name.hashCode());													
		result = prime * result + ((type == null) ? 0 : type.hashCode());								
		return result;
	}
	
	private void writeObject(java.io.ObjectOutputStream stream)throws IOException {
		stream.defaultWriteObject();
	}
	
	
}

