	
package com.tmax.hyperdata.ui_service.dto;

import java.io.IOException;
import java.util.List;

import java.util.ArrayList;

import java.util.Map;

import com.tmax.promapper.engine.dto.record.common.FieldProperty;
import com.tmax.promapper.engine.dto.record.common.FieldPropertyFactory;
import com.tmax.proobject.model.exception.FieldNotFoundException;

import com.tmax.proobject.model.dataobject.DataObject;








@com.tmax.proobject.core.DataObject
public class FactTableInfo extends DataObject {
	private static final String DTO_LOGICAL_NAME = "FactTableInfo";
	
	public String getDtoLogicalName() {
		return DTO_LOGICAL_NAME;
	}
	
	private static final long serialVersionUID= 1L;
	
	public FactTableInfo() {
			super();
			
	}	 
	
	private boolean isModified = false;

	/**
	 * LogicalName : factTableId
	 * Comments    : 
	 */		

	private int factTableId;
	
		
	
	private boolean factTableId_invalidation = false;
	
	public void setInvalidationFactTableId(boolean invalidation) { 
		this.factTableId_invalidation = invalidation;
	}
	
	public boolean isInvalidationFactTableId() {
		return this.factTableId_invalidation;
	}
	
	private boolean factTableId_modified = false;
	

	public boolean isModifiedFactTableId() {
		return this.factTableId_modified;
	}
	
	public void unModifiedFactTableId() {
		this.factTableId_modified = false;
	}

	public int getFactTableId() {
		return factTableId;
	}
	public void setFactTableId(int factTableId) {
		this.factTableId = factTableId;
		this.factTableId_modified = true;
		this.isModified = true;
	}
	
	public void setFactTableId(Integer factTableId) {
		if( factTableId == null) {
			this.factTableId = 0;
		} else{
			this.factTableId = factTableId.intValue();
		}
		this.factTableId_modified = true;
		this.isModified = true;
	}
	public void setFactTableId(String factTableId) {
		if  (factTableId==null || factTableId.length() == 0) {
			this.factTableId = 0;
		} else {
			this.factTableId = Integer.parseInt(factTableId);
		}
		this.factTableId_modified = true;
		this.isModified = true;
	}		

	/**
	 * LogicalName : factTableName
	 * Comments    : 
	 */		

	private String factTableName = EMPTY_STRING;
	
			
	private boolean factTableName_nullable = false;
	
	public boolean isNullableFactTableName() {
		return this.factTableName_nullable;
	}	
	
	private boolean factTableName_invalidation = false;
	
	public void setInvalidationFactTableName(boolean invalidation) { 
		this.factTableName_invalidation = invalidation;
	}
	
	public boolean isInvalidationFactTableName() {
		return this.factTableName_invalidation;
	}
	
	private boolean factTableName_modified = false;
	

	public boolean isModifiedFactTableName() {
		return this.factTableName_modified;
	}
	
	public void unModifiedFactTableName() {
		this.factTableName_modified = false;
	}

	public String getFactTableName() {
		return factTableName;
	}
	public String getNvlFactTableName() {
		if(getFactTableName() == null) {
			return  EMPTY_STRING;
		} else {
			return getFactTableName();
		}
	}
	public void setFactTableName(String factTableName) {
		if(factTableName == null) {
			this.factTableName  = EMPTY_STRING;
		} else {
			this.factTableName = factTableName;
		}
		this.factTableName_modified = true;
		this.isModified = true;
	}	
			

	/**
	 * LogicalName : factTableColName
	 * Comments    : 
	 */		

	private String factTableColName = EMPTY_STRING;
	
			
	private boolean factTableColName_nullable = false;
	
	public boolean isNullableFactTableColName() {
		return this.factTableColName_nullable;
	}	
	
	private boolean factTableColName_invalidation = false;
	
	public void setInvalidationFactTableColName(boolean invalidation) { 
		this.factTableColName_invalidation = invalidation;
	}
	
	public boolean isInvalidationFactTableColName() {
		return this.factTableColName_invalidation;
	}
	
	private boolean factTableColName_modified = false;
	

	public boolean isModifiedFactTableColName() {
		return this.factTableColName_modified;
	}
	
	public void unModifiedFactTableColName() {
		this.factTableColName_modified = false;
	}

	public String getFactTableColName() {
		return factTableColName;
	}
	public String getNvlFactTableColName() {
		if(getFactTableColName() == null) {
			return  EMPTY_STRING;
		} else {
			return getFactTableColName();
		}
	}
	public void setFactTableColName(String factTableColName) {
		if(factTableColName == null) {
			this.factTableColName  = EMPTY_STRING;
		} else {
			this.factTableColName = factTableColName;
		}
		this.factTableColName_modified = true;
		this.isModified = true;
	}	
			

	/**
	 * LogicalName : factTableColType
	 * Comments    : 
	 */		

	private String factTableColType = EMPTY_STRING;
	
			
	private boolean factTableColType_nullable = false;
	
	public boolean isNullableFactTableColType() {
		return this.factTableColType_nullable;
	}	
	
	private boolean factTableColType_invalidation = false;
	
	public void setInvalidationFactTableColType(boolean invalidation) { 
		this.factTableColType_invalidation = invalidation;
	}
	
	public boolean isInvalidationFactTableColType() {
		return this.factTableColType_invalidation;
	}
	
	private boolean factTableColType_modified = false;
	

	public boolean isModifiedFactTableColType() {
		return this.factTableColType_modified;
	}
	
	public void unModifiedFactTableColType() {
		this.factTableColType_modified = false;
	}

	public String getFactTableColType() {
		return factTableColType;
	}
	public String getNvlFactTableColType() {
		if(getFactTableColType() == null) {
			return  EMPTY_STRING;
		} else {
			return getFactTableColType();
		}
	}
	public void setFactTableColType(String factTableColType) {
		if(factTableColType == null) {
			this.factTableColType  = EMPTY_STRING;
		} else {
			this.factTableColType = factTableColType;
		}
		this.factTableColType_modified = true;
		this.isModified = true;
	}	
			

	@Override
	public void clearAllIsModified() {
		this.factTableId_modified = false;
		this.factTableName_modified = false;
		this.factTableColName_modified = false;
		this.factTableColType_modified = false;
		this.isModified = false;
	}
	
	@Override
	public List<String> getIsModifiedField() {
		List<String> modifiedFields = new ArrayList<>();
		if(this.factTableId_modified == true)
			modifiedFields.add("factTableId");
		if(this.factTableName_modified == true)
			modifiedFields.add("factTableName");
		if(this.factTableColName_modified == true)
			modifiedFields.add("factTableColName");
		if(this.factTableColType_modified == true)
			modifiedFields.add("factTableColType");
		return modifiedFields;
	}
	
	@Override
	public boolean isModified() {
	    return isModified;
	} 
	public Object clone() {
		FactTableInfo copyObj = new FactTableInfo();	
		copyObj.clone(this);
		return copyObj;
	}
	public void clone(DataObject _factTableInfo) {
		if(this == _factTableInfo) return;
		FactTableInfo __factTableInfo = (FactTableInfo) _factTableInfo;
		
		this.setFactTableId(__factTableInfo.getFactTableId());
		this.setFactTableName(__factTableInfo.getFactTableName());
		this.setFactTableColName(__factTableInfo.getFactTableColName());
		this.setFactTableColType(__factTableInfo.getFactTableColType());
		
	}

	public String toString() {
		StringBuilder buffer = new StringBuilder();
				
		buffer.append("factTableId : ").append(factTableId).append("\n");				
		buffer.append("factTableName : ").append(factTableName).append("\n");				
		buffer.append("factTableColName : ").append(factTableColName).append("\n");				
		buffer.append("factTableColType : ").append(factTableColType).append("\n");		
		return buffer.toString();
	}
	private static final Map<String,FieldProperty> fieldPropertyMap;
	
	static {
		fieldPropertyMap = new java.util.LinkedHashMap<String,FieldProperty>(4);
		fieldPropertyMap.put("factTableId"
							, FieldPropertyFactory.getFieldProperty( "factTableId","", "", "", false, false, false,  FieldProperty.TYPE_PRIMITIVE_INT, 10 , -1, null, null));		
		fieldPropertyMap.put("factTableName"
							, FieldPropertyFactory.getFieldProperty( "factTableName","", "", "", false, false, false,  FieldProperty.TYPE_OBJECT_STRING, 255 , -1, null, null));		
		fieldPropertyMap.put("factTableColName"
							, FieldPropertyFactory.getFieldProperty( "factTableColName","", "", "", false, false, false,  FieldProperty.TYPE_OBJECT_STRING, 255 , -1, null, null));		
		fieldPropertyMap.put("factTableColType"
							, FieldPropertyFactory.getFieldProperty( "factTableColType","", "", "", false, false, false,  FieldProperty.TYPE_OBJECT_STRING, 255 , -1, null, null));		
	}

	public Map<String,FieldProperty> getFieldPropertyMap() {
		return fieldPropertyMap;
	}
	
	public static Map<String,FieldProperty> getFieldPropertyMapByStatic() {
		return fieldPropertyMap;
	}	

	public Object get(String fieldName) throws FieldNotFoundException {
		switch(fieldName) {
			case "factTableId" : return getFactTableId();
			case "factTableName" : return getFactTableName();
			case "factTableColName" : return getFactTableColName();
			case "factTableColType" : return getFactTableColType();
			default : throw new FieldNotFoundException(fieldName);		
		}
	}




	public void set(String fieldName, Object arg) throws FieldNotFoundException {
		switch(fieldName) {
			case "factTableId" : setFactTableId((Integer)arg);break;
			case "factTableName" : setFactTableName((String)arg);break;
			case "factTableColName" : setFactTableColName((String)arg);break;
			case "factTableColType" : setFactTableColType((String)arg);break;
			default : throw new FieldNotFoundException(fieldName);		
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if ((obj instanceof FactTableInfo) == false) return false;
		FactTableInfo _FactTableInfo = (FactTableInfo) obj;				
		if(factTableId != _FactTableInfo.getFactTableId()) return false; 									
		if(factTableName == null) {
			if(_FactTableInfo.getFactTableName() != null)
				return false;
		} else if(!factTableName.equals(_FactTableInfo.getFactTableName()))
			return false;					
		if(factTableColName == null) {
			if(_FactTableInfo.getFactTableColName() != null)
				return false;
		} else if(!factTableColName.equals(_FactTableInfo.getFactTableColName()))
			return false;					
		if(factTableColType == null) {
			if(_FactTableInfo.getFactTableColType() != null)
				return false;
		} else if(!factTableColType.equals(_FactTableInfo.getFactTableColType()))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		int prime = 31;
		int result = 1;
		result = prime * result + factTableId;					
		result = prime * result + ((factTableName == null) ? 0 : factTableName.hashCode());													
		result = prime * result + ((factTableColName == null) ? 0 : factTableColName.hashCode());													
		result = prime * result + ((factTableColType == null) ? 0 : factTableColType.hashCode());								
		return result;
	}
	
	private void writeObject(java.io.ObjectOutputStream stream)throws IOException {
		stream.defaultWriteObject();
	}
	
	
}
