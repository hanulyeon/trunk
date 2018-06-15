	
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
public class DimTableInfo extends DataObject {
	private static final String DTO_LOGICAL_NAME = "DimTableInfo";
	
	public String getDtoLogicalName() {
		return DTO_LOGICAL_NAME;
	}
	
	private static final long serialVersionUID= 1L;
	
	public DimTableInfo() {
			super();
			
	}	 
	
	private boolean isModified = false;

	/**
	 * LogicalName : dimTableId
	 * Comments    : 
	 */		

	private int dimTableId;
	
		
	
	private boolean dimTableId_invalidation = false;
	
	public void setInvalidationDimTableId(boolean invalidation) { 
		this.dimTableId_invalidation = invalidation;
	}
	
	public boolean isInvalidationDimTableId() {
		return this.dimTableId_invalidation;
	}
	
	private boolean dimTableId_modified = false;
	

	public boolean isModifiedDimTableId() {
		return this.dimTableId_modified;
	}
	
	public void unModifiedDimTableId() {
		this.dimTableId_modified = false;
	}

	public int getDimTableId() {
		return dimTableId;
	}
	public void setDimTableId(int dimTableId) {
		this.dimTableId = dimTableId;
		this.dimTableId_modified = true;
		this.isModified = true;
	}
	
	public void setDimTableId(Integer dimTableId) {
		if( dimTableId == null) {
			this.dimTableId = 0;
		} else{
			this.dimTableId = dimTableId.intValue();
		}
		this.dimTableId_modified = true;
		this.isModified = true;
	}
	public void setDimTableId(String dimTableId) {
		if  (dimTableId==null || dimTableId.length() == 0) {
			this.dimTableId = 0;
		} else {
			this.dimTableId = Integer.parseInt(dimTableId);
		}
		this.dimTableId_modified = true;
		this.isModified = true;
	}		

	/**
	 * LogicalName : dimTableName
	 * Comments    : 
	 */		

	private String dimTableName = EMPTY_STRING;
	
			
	private boolean dimTableName_nullable = false;
	
	public boolean isNullableDimTableName() {
		return this.dimTableName_nullable;
	}	
	
	private boolean dimTableName_invalidation = false;
	
	public void setInvalidationDimTableName(boolean invalidation) { 
		this.dimTableName_invalidation = invalidation;
	}
	
	public boolean isInvalidationDimTableName() {
		return this.dimTableName_invalidation;
	}
	
	private boolean dimTableName_modified = false;
	

	public boolean isModifiedDimTableName() {
		return this.dimTableName_modified;
	}
	
	public void unModifiedDimTableName() {
		this.dimTableName_modified = false;
	}

	public String getDimTableName() {
		return dimTableName;
	}
	public String getNvlDimTableName() {
		if(getDimTableName() == null) {
			return  EMPTY_STRING;
		} else {
			return getDimTableName();
		}
	}
	public void setDimTableName(String dimTableName) {
		if(dimTableName == null) {
			this.dimTableName  = EMPTY_STRING;
		} else {
			this.dimTableName = dimTableName;
		}
		this.dimTableName_modified = true;
		this.isModified = true;
	}	
			

	/**
	 * LogicalName : dimTableColName
	 * Comments    : 
	 */		

	private String dimTableColName = EMPTY_STRING;
	
			
	private boolean dimTableColName_nullable = false;
	
	public boolean isNullableDimTableColName() {
		return this.dimTableColName_nullable;
	}	
	
	private boolean dimTableColName_invalidation = false;
	
	public void setInvalidationDimTableColName(boolean invalidation) { 
		this.dimTableColName_invalidation = invalidation;
	}
	
	public boolean isInvalidationDimTableColName() {
		return this.dimTableColName_invalidation;
	}
	
	private boolean dimTableColName_modified = false;
	

	public boolean isModifiedDimTableColName() {
		return this.dimTableColName_modified;
	}
	
	public void unModifiedDimTableColName() {
		this.dimTableColName_modified = false;
	}

	public String getDimTableColName() {
		return dimTableColName;
	}
	public String getNvlDimTableColName() {
		if(getDimTableColName() == null) {
			return  EMPTY_STRING;
		} else {
			return getDimTableColName();
		}
	}
	public void setDimTableColName(String dimTableColName) {
		if(dimTableColName == null) {
			this.dimTableColName  = EMPTY_STRING;
		} else {
			this.dimTableColName = dimTableColName;
		}
		this.dimTableColName_modified = true;
		this.isModified = true;
	}	
			

	/**
	 * LogicalName : dimTableColType
	 * Comments    : 
	 */		

	private String dimTableColType = EMPTY_STRING;
	
			
	private boolean dimTableColType_nullable = false;
	
	public boolean isNullableDimTableColType() {
		return this.dimTableColType_nullable;
	}	
	
	private boolean dimTableColType_invalidation = false;
	
	public void setInvalidationDimTableColType(boolean invalidation) { 
		this.dimTableColType_invalidation = invalidation;
	}
	
	public boolean isInvalidationDimTableColType() {
		return this.dimTableColType_invalidation;
	}
	
	private boolean dimTableColType_modified = false;
	

	public boolean isModifiedDimTableColType() {
		return this.dimTableColType_modified;
	}
	
	public void unModifiedDimTableColType() {
		this.dimTableColType_modified = false;
	}

	public String getDimTableColType() {
		return dimTableColType;
	}
	public String getNvlDimTableColType() {
		if(getDimTableColType() == null) {
			return  EMPTY_STRING;
		} else {
			return getDimTableColType();
		}
	}
	public void setDimTableColType(String dimTableColType) {
		if(dimTableColType == null) {
			this.dimTableColType  = EMPTY_STRING;
		} else {
			this.dimTableColType = dimTableColType;
		}
		this.dimTableColType_modified = true;
		this.isModified = true;
	}	
			

	@Override
	public void clearAllIsModified() {
		this.dimTableId_modified = false;
		this.dimTableName_modified = false;
		this.dimTableColName_modified = false;
		this.dimTableColType_modified = false;
		this.isModified = false;
	}
	
	@Override
	public List<String> getIsModifiedField() {
		List<String> modifiedFields = new ArrayList<>();
		if(this.dimTableId_modified == true)
			modifiedFields.add("dimTableId");
		if(this.dimTableName_modified == true)
			modifiedFields.add("dimTableName");
		if(this.dimTableColName_modified == true)
			modifiedFields.add("dimTableColName");
		if(this.dimTableColType_modified == true)
			modifiedFields.add("dimTableColType");
		return modifiedFields;
	}
	
	@Override
	public boolean isModified() {
	    return isModified;
	} 
	public Object clone() {
		DimTableInfo copyObj = new DimTableInfo();	
		copyObj.clone(this);
		return copyObj;
	}
	public void clone(DataObject _dimTableInfo) {
		if(this == _dimTableInfo) return;
		DimTableInfo __dimTableInfo = (DimTableInfo) _dimTableInfo;
		
		this.setDimTableId(__dimTableInfo.getDimTableId());
		this.setDimTableName(__dimTableInfo.getDimTableName());
		this.setDimTableColName(__dimTableInfo.getDimTableColName());
		this.setDimTableColType(__dimTableInfo.getDimTableColType());
		
	}

	public String toString() {
		StringBuilder buffer = new StringBuilder();
				
		buffer.append("dimTableId : ").append(dimTableId).append("\n");				
		buffer.append("dimTableName : ").append(dimTableName).append("\n");				
		buffer.append("dimTableColName : ").append(dimTableColName).append("\n");				
		buffer.append("dimTableColType : ").append(dimTableColType).append("\n");		
		return buffer.toString();
	}
	private static final Map<String,FieldProperty> fieldPropertyMap;
	
	static {
		fieldPropertyMap = new java.util.LinkedHashMap<String,FieldProperty>(4);
		fieldPropertyMap.put("dimTableId"
							, FieldPropertyFactory.getFieldProperty( "dimTableId","", "", "", false, false, false,  FieldProperty.TYPE_PRIMITIVE_INT, 10 , -1, null, null));		
		fieldPropertyMap.put("dimTableName"
							, FieldPropertyFactory.getFieldProperty( "dimTableName","", "", "", false, false, false,  FieldProperty.TYPE_OBJECT_STRING, 255 , -1, null, null));		
		fieldPropertyMap.put("dimTableColName"
							, FieldPropertyFactory.getFieldProperty( "dimTableColName","", "", "", false, false, false,  FieldProperty.TYPE_OBJECT_STRING, 255 , -1, null, null));		
		fieldPropertyMap.put("dimTableColType"
							, FieldPropertyFactory.getFieldProperty( "dimTableColType","", "", "", false, false, false,  FieldProperty.TYPE_OBJECT_STRING, 255 , -1, null, null));		
	}

	public Map<String,FieldProperty> getFieldPropertyMap() {
		return fieldPropertyMap;
	}
	
	public static Map<String,FieldProperty> getFieldPropertyMapByStatic() {
		return fieldPropertyMap;
	}	

	public Object get(String fieldName) throws FieldNotFoundException {
		switch(fieldName) {
			case "dimTableId" : return getDimTableId();
			case "dimTableName" : return getDimTableName();
			case "dimTableColName" : return getDimTableColName();
			case "dimTableColType" : return getDimTableColType();
			default : throw new FieldNotFoundException(fieldName);		
		}
	}




	public void set(String fieldName, Object arg) throws FieldNotFoundException {
		switch(fieldName) {
			case "dimTableId" : setDimTableId((Integer)arg);break;
			case "dimTableName" : setDimTableName((String)arg);break;
			case "dimTableColName" : setDimTableColName((String)arg);break;
			case "dimTableColType" : setDimTableColType((String)arg);break;
			default : throw new FieldNotFoundException(fieldName);		
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if ((obj instanceof DimTableInfo) == false) return false;
		DimTableInfo _DimTableInfo = (DimTableInfo) obj;				
		if(dimTableId != _DimTableInfo.getDimTableId()) return false; 									
		if(dimTableName == null) {
			if(_DimTableInfo.getDimTableName() != null)
				return false;
		} else if(!dimTableName.equals(_DimTableInfo.getDimTableName()))
			return false;					
		if(dimTableColName == null) {
			if(_DimTableInfo.getDimTableColName() != null)
				return false;
		} else if(!dimTableColName.equals(_DimTableInfo.getDimTableColName()))
			return false;					
		if(dimTableColType == null) {
			if(_DimTableInfo.getDimTableColType() != null)
				return false;
		} else if(!dimTableColType.equals(_DimTableInfo.getDimTableColType()))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		int prime = 31;
		int result = 1;
		result = prime * result + dimTableId;					
		result = prime * result + ((dimTableName == null) ? 0 : dimTableName.hashCode());													
		result = prime * result + ((dimTableColName == null) ? 0 : dimTableColName.hashCode());													
		result = prime * result + ((dimTableColType == null) ? 0 : dimTableColType.hashCode());								
		return result;
	}
	
	private void writeObject(java.io.ObjectOutputStream stream)throws IOException {
		stream.defaultWriteObject();
	}
	
	
}
