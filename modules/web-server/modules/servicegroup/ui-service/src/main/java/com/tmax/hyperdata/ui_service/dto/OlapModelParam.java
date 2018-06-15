	
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
public class OlapModelParam extends DataObject {
	private static final String DTO_LOGICAL_NAME = "OlapModelParam";
	
	public String getDtoLogicalName() {
		return DTO_LOGICAL_NAME;
	}
	
	private static final long serialVersionUID= 1L;
	
	public OlapModelParam() {
			super();
			
	}	 
	
	private boolean isModified = false;

	/**
	 * LogicalName : modelId
	 * Comments    : 
	 */		

	private int modelId;
	
		
	
	private boolean modelId_invalidation = false;
	
	public void setInvalidationModelId(boolean invalidation) { 
		this.modelId_invalidation = invalidation;
	}
	
	public boolean isInvalidationModelId() {
		return this.modelId_invalidation;
	}
	
	private boolean modelId_modified = false;
	

	public boolean isModifiedModelId() {
		return this.modelId_modified;
	}
	
	public void unModifiedModelId() {
		this.modelId_modified = false;
	}

	public int getModelId() {
		return modelId;
	}
	public void setModelId(int modelId) {
		this.modelId = modelId;
		this.modelId_modified = true;
		this.isModified = true;
	}
	
	public void setModelId(Integer modelId) {
		if( modelId == null) {
			this.modelId = 0;
		} else{
			this.modelId = modelId.intValue();
		}
		this.modelId_modified = true;
		this.isModified = true;
	}
	public void setModelId(String modelId) {
		if  (modelId==null || modelId.length() == 0) {
			this.modelId = 0;
		} else {
			this.modelId = Integer.parseInt(modelId);
		}
		this.modelId_modified = true;
		this.isModified = true;
	}		

	/**
	 * LogicalName : refFactTableId
	 * Comments    : 
	 */		

	private int refFactTableId;
	
		
	
	private boolean refFactTableId_invalidation = false;
	
	public void setInvalidationRefFactTableId(boolean invalidation) { 
		this.refFactTableId_invalidation = invalidation;
	}
	
	public boolean isInvalidationRefFactTableId() {
		return this.refFactTableId_invalidation;
	}
	
	private boolean refFactTableId_modified = false;
	

	public boolean isModifiedRefFactTableId() {
		return this.refFactTableId_modified;
	}
	
	public void unModifiedRefFactTableId() {
		this.refFactTableId_modified = false;
	}

	public int getRefFactTableId() {
		return refFactTableId;
	}
	public void setRefFactTableId(int refFactTableId) {
		this.refFactTableId = refFactTableId;
		this.refFactTableId_modified = true;
		this.isModified = true;
	}
	
	public void setRefFactTableId(Integer refFactTableId) {
		if( refFactTableId == null) {
			this.refFactTableId = 0;
		} else{
			this.refFactTableId = refFactTableId.intValue();
		}
		this.refFactTableId_modified = true;
		this.isModified = true;
	}
	public void setRefFactTableId(String refFactTableId) {
		if  (refFactTableId==null || refFactTableId.length() == 0) {
			this.refFactTableId = 0;
		} else {
			this.refFactTableId = Integer.parseInt(refFactTableId);
		}
		this.refFactTableId_modified = true;
		this.isModified = true;
	}		

	/**
	 * LogicalName : refFactTableName
	 * Comments    : 
	 */		

	private String refFactTableName = EMPTY_STRING;
	
			
	private boolean refFactTableName_nullable = false;
	
	public boolean isNullableRefFactTableName() {
		return this.refFactTableName_nullable;
	}	
	
	private boolean refFactTableName_invalidation = false;
	
	public void setInvalidationRefFactTableName(boolean invalidation) { 
		this.refFactTableName_invalidation = invalidation;
	}
	
	public boolean isInvalidationRefFactTableName() {
		return this.refFactTableName_invalidation;
	}
	
	private boolean refFactTableName_modified = false;
	

	public boolean isModifiedRefFactTableName() {
		return this.refFactTableName_modified;
	}
	
	public void unModifiedRefFactTableName() {
		this.refFactTableName_modified = false;
	}

	public String getRefFactTableName() {
		return refFactTableName;
	}
	public String getNvlRefFactTableName() {
		if(getRefFactTableName() == null) {
			return  EMPTY_STRING;
		} else {
			return getRefFactTableName();
		}
	}
	public void setRefFactTableName(String refFactTableName) {
		if(refFactTableName == null) {
			this.refFactTableName  = EMPTY_STRING;
		} else {
			this.refFactTableName = refFactTableName;
		}
		this.refFactTableName_modified = true;
		this.isModified = true;
	}	
			

	/**
	 * LogicalName : refFactTableColName
	 * Comments    : 
	 */		

	private String refFactTableColName = EMPTY_STRING;
	
			
	private boolean refFactTableColName_nullable = false;
	
	public boolean isNullableRefFactTableColName() {
		return this.refFactTableColName_nullable;
	}	
	
	private boolean refFactTableColName_invalidation = false;
	
	public void setInvalidationRefFactTableColName(boolean invalidation) { 
		this.refFactTableColName_invalidation = invalidation;
	}
	
	public boolean isInvalidationRefFactTableColName() {
		return this.refFactTableColName_invalidation;
	}
	
	private boolean refFactTableColName_modified = false;
	

	public boolean isModifiedRefFactTableColName() {
		return this.refFactTableColName_modified;
	}
	
	public void unModifiedRefFactTableColName() {
		this.refFactTableColName_modified = false;
	}

	public String getRefFactTableColName() {
		return refFactTableColName;
	}
	public String getNvlRefFactTableColName() {
		if(getRefFactTableColName() == null) {
			return  EMPTY_STRING;
		} else {
			return getRefFactTableColName();
		}
	}
	public void setRefFactTableColName(String refFactTableColName) {
		if(refFactTableColName == null) {
			this.refFactTableColName  = EMPTY_STRING;
		} else {
			this.refFactTableColName = refFactTableColName;
		}
		this.refFactTableColName_modified = true;
		this.isModified = true;
	}	
			

	/**
	 * LogicalName : refFactTableColType
	 * Comments    : 
	 */		

	private String refFactTableColType = EMPTY_STRING;
	
			
	private boolean refFactTableColType_nullable = false;
	
	public boolean isNullableRefFactTableColType() {
		return this.refFactTableColType_nullable;
	}	
	
	private boolean refFactTableColType_invalidation = false;
	
	public void setInvalidationRefFactTableColType(boolean invalidation) { 
		this.refFactTableColType_invalidation = invalidation;
	}
	
	public boolean isInvalidationRefFactTableColType() {
		return this.refFactTableColType_invalidation;
	}
	
	private boolean refFactTableColType_modified = false;
	

	public boolean isModifiedRefFactTableColType() {
		return this.refFactTableColType_modified;
	}
	
	public void unModifiedRefFactTableColType() {
		this.refFactTableColType_modified = false;
	}

	public String getRefFactTableColType() {
		return refFactTableColType;
	}
	public String getNvlRefFactTableColType() {
		if(getRefFactTableColType() == null) {
			return  EMPTY_STRING;
		} else {
			return getRefFactTableColType();
		}
	}
	public void setRefFactTableColType(String refFactTableColType) {
		if(refFactTableColType == null) {
			this.refFactTableColType  = EMPTY_STRING;
		} else {
			this.refFactTableColType = refFactTableColType;
		}
		this.refFactTableColType_modified = true;
		this.isModified = true;
	}	
			

	/**
	 * LogicalName : refDimTableId
	 * Comments    : 
	 */		

	private int refDimTableId;
	
		
	
	private boolean refDimTableId_invalidation = false;
	
	public void setInvalidationRefDimTableId(boolean invalidation) { 
		this.refDimTableId_invalidation = invalidation;
	}
	
	public boolean isInvalidationRefDimTableId() {
		return this.refDimTableId_invalidation;
	}
	
	private boolean refDimTableId_modified = false;
	

	public boolean isModifiedRefDimTableId() {
		return this.refDimTableId_modified;
	}
	
	public void unModifiedRefDimTableId() {
		this.refDimTableId_modified = false;
	}

	public int getRefDimTableId() {
		return refDimTableId;
	}
	public void setRefDimTableId(int refDimTableId) {
		this.refDimTableId = refDimTableId;
		this.refDimTableId_modified = true;
		this.isModified = true;
	}
	
	public void setRefDimTableId(Integer refDimTableId) {
		if( refDimTableId == null) {
			this.refDimTableId = 0;
		} else{
			this.refDimTableId = refDimTableId.intValue();
		}
		this.refDimTableId_modified = true;
		this.isModified = true;
	}
	public void setRefDimTableId(String refDimTableId) {
		if  (refDimTableId==null || refDimTableId.length() == 0) {
			this.refDimTableId = 0;
		} else {
			this.refDimTableId = Integer.parseInt(refDimTableId);
		}
		this.refDimTableId_modified = true;
		this.isModified = true;
	}		

	/**
	 * LogicalName : refDimTableName
	 * Comments    : 
	 */		

	private String refDimTableName = EMPTY_STRING;
	
			
	private boolean refDimTableName_nullable = false;
	
	public boolean isNullableRefDimTableName() {
		return this.refDimTableName_nullable;
	}	
	
	private boolean refDimTableName_invalidation = false;
	
	public void setInvalidationRefDimTableName(boolean invalidation) { 
		this.refDimTableName_invalidation = invalidation;
	}
	
	public boolean isInvalidationRefDimTableName() {
		return this.refDimTableName_invalidation;
	}
	
	private boolean refDimTableName_modified = false;
	

	public boolean isModifiedRefDimTableName() {
		return this.refDimTableName_modified;
	}
	
	public void unModifiedRefDimTableName() {
		this.refDimTableName_modified = false;
	}

	public String getRefDimTableName() {
		return refDimTableName;
	}
	public String getNvlRefDimTableName() {
		if(getRefDimTableName() == null) {
			return  EMPTY_STRING;
		} else {
			return getRefDimTableName();
		}
	}
	public void setRefDimTableName(String refDimTableName) {
		if(refDimTableName == null) {
			this.refDimTableName  = EMPTY_STRING;
		} else {
			this.refDimTableName = refDimTableName;
		}
		this.refDimTableName_modified = true;
		this.isModified = true;
	}	
			

	/**
	 * LogicalName : refDimTableColName
	 * Comments    : 
	 */		

	private String refDimTableColName = EMPTY_STRING;
	
			
	private boolean refDimTableColName_nullable = false;
	
	public boolean isNullableRefDimTableColName() {
		return this.refDimTableColName_nullable;
	}	
	
	private boolean refDimTableColName_invalidation = false;
	
	public void setInvalidationRefDimTableColName(boolean invalidation) { 
		this.refDimTableColName_invalidation = invalidation;
	}
	
	public boolean isInvalidationRefDimTableColName() {
		return this.refDimTableColName_invalidation;
	}
	
	private boolean refDimTableColName_modified = false;
	

	public boolean isModifiedRefDimTableColName() {
		return this.refDimTableColName_modified;
	}
	
	public void unModifiedRefDimTableColName() {
		this.refDimTableColName_modified = false;
	}

	public String getRefDimTableColName() {
		return refDimTableColName;
	}
	public String getNvlRefDimTableColName() {
		if(getRefDimTableColName() == null) {
			return  EMPTY_STRING;
		} else {
			return getRefDimTableColName();
		}
	}
	public void setRefDimTableColName(String refDimTableColName) {
		if(refDimTableColName == null) {
			this.refDimTableColName  = EMPTY_STRING;
		} else {
			this.refDimTableColName = refDimTableColName;
		}
		this.refDimTableColName_modified = true;
		this.isModified = true;
	}	
			

	/**
	 * LogicalName : refDimTableColType
	 * Comments    : 
	 */		

	private String refDimTableColType = EMPTY_STRING;
	
			
	private boolean refDimTableColType_nullable = false;
	
	public boolean isNullableRefDimTableColType() {
		return this.refDimTableColType_nullable;
	}	
	
	private boolean refDimTableColType_invalidation = false;
	
	public void setInvalidationRefDimTableColType(boolean invalidation) { 
		this.refDimTableColType_invalidation = invalidation;
	}
	
	public boolean isInvalidationRefDimTableColType() {
		return this.refDimTableColType_invalidation;
	}
	
	private boolean refDimTableColType_modified = false;
	

	public boolean isModifiedRefDimTableColType() {
		return this.refDimTableColType_modified;
	}
	
	public void unModifiedRefDimTableColType() {
		this.refDimTableColType_modified = false;
	}

	public String getRefDimTableColType() {
		return refDimTableColType;
	}
	public String getNvlRefDimTableColType() {
		if(getRefDimTableColType() == null) {
			return  EMPTY_STRING;
		} else {
			return getRefDimTableColType();
		}
	}
	public void setRefDimTableColType(String refDimTableColType) {
		if(refDimTableColType == null) {
			this.refDimTableColType  = EMPTY_STRING;
		} else {
			this.refDimTableColType = refDimTableColType;
		}
		this.refDimTableColType_modified = true;
		this.isModified = true;
	}	
			

	@Override
	public void clearAllIsModified() {
		this.modelId_modified = false;
		this.refFactTableId_modified = false;
		this.refFactTableName_modified = false;
		this.refFactTableColName_modified = false;
		this.refFactTableColType_modified = false;
		this.refDimTableId_modified = false;
		this.refDimTableName_modified = false;
		this.refDimTableColName_modified = false;
		this.refDimTableColType_modified = false;
		this.isModified = false;
	}
	
	@Override
	public List<String> getIsModifiedField() {
		List<String> modifiedFields = new ArrayList<>();
		if(this.modelId_modified == true)
			modifiedFields.add("modelId");
		if(this.refFactTableId_modified == true)
			modifiedFields.add("refFactTableId");
		if(this.refFactTableName_modified == true)
			modifiedFields.add("refFactTableName");
		if(this.refFactTableColName_modified == true)
			modifiedFields.add("refFactTableColName");
		if(this.refFactTableColType_modified == true)
			modifiedFields.add("refFactTableColType");
		if(this.refDimTableId_modified == true)
			modifiedFields.add("refDimTableId");
		if(this.refDimTableName_modified == true)
			modifiedFields.add("refDimTableName");
		if(this.refDimTableColName_modified == true)
			modifiedFields.add("refDimTableColName");
		if(this.refDimTableColType_modified == true)
			modifiedFields.add("refDimTableColType");
		return modifiedFields;
	}
	
	@Override
	public boolean isModified() {
	    return isModified;
	} 
	public Object clone() {
		OlapModelParam copyObj = new OlapModelParam();	
		copyObj.clone(this);
		return copyObj;
	}
	public void clone(DataObject _olapModelParam) {
		if(this == _olapModelParam) return;
		OlapModelParam __olapModelParam = (OlapModelParam) _olapModelParam;
		
		this.setModelId(__olapModelParam.getModelId());
		this.setRefFactTableId(__olapModelParam.getRefFactTableId());
		this.setRefFactTableName(__olapModelParam.getRefFactTableName());
		this.setRefFactTableColName(__olapModelParam.getRefFactTableColName());
		this.setRefFactTableColType(__olapModelParam.getRefFactTableColType());
		this.setRefDimTableId(__olapModelParam.getRefDimTableId());
		this.setRefDimTableName(__olapModelParam.getRefDimTableName());
		this.setRefDimTableColName(__olapModelParam.getRefDimTableColName());
		this.setRefDimTableColType(__olapModelParam.getRefDimTableColType());
		
	}

	public String toString() {
		StringBuilder buffer = new StringBuilder();
				
		buffer.append("modelId : ").append(modelId).append("\n");				
		buffer.append("refFactTableId : ").append(refFactTableId).append("\n");				
		buffer.append("refFactTableName : ").append(refFactTableName).append("\n");				
		buffer.append("refFactTableColName : ").append(refFactTableColName).append("\n");				
		buffer.append("refFactTableColType : ").append(refFactTableColType).append("\n");				
		buffer.append("refDimTableId : ").append(refDimTableId).append("\n");				
		buffer.append("refDimTableName : ").append(refDimTableName).append("\n");				
		buffer.append("refDimTableColName : ").append(refDimTableColName).append("\n");				
		buffer.append("refDimTableColType : ").append(refDimTableColType).append("\n");		
		return buffer.toString();
	}
	private static final Map<String,FieldProperty> fieldPropertyMap;
	
	static {
		fieldPropertyMap = new java.util.LinkedHashMap<String,FieldProperty>(9);
		fieldPropertyMap.put("modelId"
							, FieldPropertyFactory.getFieldProperty( "modelId","", "", "", false, false, false,  FieldProperty.TYPE_PRIMITIVE_INT, 10 , -1, null, null));		
		fieldPropertyMap.put("refFactTableId"
							, FieldPropertyFactory.getFieldProperty( "refFactTableId","", "", "", false, false, false,  FieldProperty.TYPE_PRIMITIVE_INT, 10 , -1, null, null));		
		fieldPropertyMap.put("refFactTableName"
							, FieldPropertyFactory.getFieldProperty( "refFactTableName","", "", "", false, false, false,  FieldProperty.TYPE_OBJECT_STRING, 255 , -1, null, null));		
		fieldPropertyMap.put("refFactTableColName"
							, FieldPropertyFactory.getFieldProperty( "refFactTableColName","", "", "", false, false, false,  FieldProperty.TYPE_OBJECT_STRING, 255 , -1, null, null));		
		fieldPropertyMap.put("refFactTableColType"
							, FieldPropertyFactory.getFieldProperty( "refFactTableColType","", "", "", false, false, false,  FieldProperty.TYPE_OBJECT_STRING, 255 , -1, null, null));		
		fieldPropertyMap.put("refDimTableId"
							, FieldPropertyFactory.getFieldProperty( "refDimTableId","", "", "", false, false, false,  FieldProperty.TYPE_PRIMITIVE_INT, 10 , -1, null, null));		
		fieldPropertyMap.put("refDimTableName"
							, FieldPropertyFactory.getFieldProperty( "refDimTableName","", "", "", false, false, false,  FieldProperty.TYPE_OBJECT_STRING, 255 , -1, null, null));		
		fieldPropertyMap.put("refDimTableColName"
							, FieldPropertyFactory.getFieldProperty( "refDimTableColName","", "", "", false, false, false,  FieldProperty.TYPE_OBJECT_STRING, 255 , -1, null, null));		
		fieldPropertyMap.put("refDimTableColType"
							, FieldPropertyFactory.getFieldProperty( "refDimTableColType","", "", "", false, false, false,  FieldProperty.TYPE_OBJECT_STRING, 255 , -1, null, null));		
	}

	public Map<String,FieldProperty> getFieldPropertyMap() {
		return fieldPropertyMap;
	}
	
	public static Map<String,FieldProperty> getFieldPropertyMapByStatic() {
		return fieldPropertyMap;
	}	

	public Object get(String fieldName) throws FieldNotFoundException {
		switch(fieldName) {
			case "modelId" : return getModelId();
			case "refFactTableId" : return getRefFactTableId();
			case "refFactTableName" : return getRefFactTableName();
			case "refFactTableColName" : return getRefFactTableColName();
			case "refFactTableColType" : return getRefFactTableColType();
			case "refDimTableId" : return getRefDimTableId();
			case "refDimTableName" : return getRefDimTableName();
			case "refDimTableColName" : return getRefDimTableColName();
			case "refDimTableColType" : return getRefDimTableColType();
			default : throw new FieldNotFoundException(fieldName);		
		}
	}




	public void set(String fieldName, Object arg) throws FieldNotFoundException {
		switch(fieldName) {
			case "modelId" : setModelId((Integer)arg);break;
			case "refFactTableId" : setRefFactTableId((Integer)arg);break;
			case "refFactTableName" : setRefFactTableName((String)arg);break;
			case "refFactTableColName" : setRefFactTableColName((String)arg);break;
			case "refFactTableColType" : setRefFactTableColType((String)arg);break;
			case "refDimTableId" : setRefDimTableId((Integer)arg);break;
			case "refDimTableName" : setRefDimTableName((String)arg);break;
			case "refDimTableColName" : setRefDimTableColName((String)arg);break;
			case "refDimTableColType" : setRefDimTableColType((String)arg);break;
			default : throw new FieldNotFoundException(fieldName);		
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if ((obj instanceof OlapModelParam) == false) return false;
		OlapModelParam _OlapModelParam = (OlapModelParam) obj;				
		if(modelId != _OlapModelParam.getModelId()) return false; 								
		if(refFactTableId != _OlapModelParam.getRefFactTableId()) return false; 									
		if(refFactTableName == null) {
			if(_OlapModelParam.getRefFactTableName() != null)
				return false;
		} else if(!refFactTableName.equals(_OlapModelParam.getRefFactTableName()))
			return false;					
		if(refFactTableColName == null) {
			if(_OlapModelParam.getRefFactTableColName() != null)
				return false;
		} else if(!refFactTableColName.equals(_OlapModelParam.getRefFactTableColName()))
			return false;					
		if(refFactTableColType == null) {
			if(_OlapModelParam.getRefFactTableColType() != null)
				return false;
		} else if(!refFactTableColType.equals(_OlapModelParam.getRefFactTableColType()))
			return false;				
		if(refDimTableId != _OlapModelParam.getRefDimTableId()) return false; 									
		if(refDimTableName == null) {
			if(_OlapModelParam.getRefDimTableName() != null)
				return false;
		} else if(!refDimTableName.equals(_OlapModelParam.getRefDimTableName()))
			return false;					
		if(refDimTableColName == null) {
			if(_OlapModelParam.getRefDimTableColName() != null)
				return false;
		} else if(!refDimTableColName.equals(_OlapModelParam.getRefDimTableColName()))
			return false;					
		if(refDimTableColType == null) {
			if(_OlapModelParam.getRefDimTableColType() != null)
				return false;
		} else if(!refDimTableColType.equals(_OlapModelParam.getRefDimTableColType()))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		int prime = 31;
		int result = 1;
		result = prime * result + modelId;
		result = prime * result + refFactTableId;					
		result = prime * result + ((refFactTableName == null) ? 0 : refFactTableName.hashCode());													
		result = prime * result + ((refFactTableColName == null) ? 0 : refFactTableColName.hashCode());													
		result = prime * result + ((refFactTableColType == null) ? 0 : refFactTableColType.hashCode());								
		result = prime * result + refDimTableId;					
		result = prime * result + ((refDimTableName == null) ? 0 : refDimTableName.hashCode());													
		result = prime * result + ((refDimTableColName == null) ? 0 : refDimTableColName.hashCode());													
		result = prime * result + ((refDimTableColType == null) ? 0 : refDimTableColType.hashCode());								
		return result;
	}
	
	private void writeObject(java.io.ObjectOutputStream stream)throws IOException {
		stream.defaultWriteObject();
	}
	
	
}
