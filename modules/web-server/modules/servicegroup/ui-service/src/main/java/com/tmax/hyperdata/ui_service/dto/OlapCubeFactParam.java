	
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
public class OlapCubeFactParam extends DataObject {
	private static final String DTO_LOGICAL_NAME = "OlapCubeFactParam";
	
	public String getDtoLogicalName() {
		return DTO_LOGICAL_NAME;
	}
	
	private static final long serialVersionUID= 1L;
	
	public OlapCubeFactParam() {
			super();
			
	}	 
	
	private boolean isModified = false;

	/**
	 * LogicalName : cubeId
	 * Comments    : 
	 */		

	private int cubeId;
	
		
	
	private boolean cubeId_invalidation = false;
	
	public void setInvalidationCubeId(boolean invalidation) { 
		this.cubeId_invalidation = invalidation;
	}
	
	public boolean isInvalidationCubeId() {
		return this.cubeId_invalidation;
	}
	
	private boolean cubeId_modified = false;
	

	public boolean isModifiedCubeId() {
		return this.cubeId_modified;
	}
	
	public void unModifiedCubeId() {
		this.cubeId_modified = false;
	}

	public int getCubeId() {
		return cubeId;
	}
	public void setCubeId(int cubeId) {
		this.cubeId = cubeId;
		this.cubeId_modified = true;
		this.isModified = true;
	}
	
	public void setCubeId(Integer cubeId) {
		if( cubeId == null) {
			this.cubeId = 0;
		} else{
			this.cubeId = cubeId.intValue();
		}
		this.cubeId_modified = true;
		this.isModified = true;
	}
	public void setCubeId(String cubeId) {
		if  (cubeId==null || cubeId.length() == 0) {
			this.cubeId = 0;
		} else {
			this.cubeId = Integer.parseInt(cubeId);
		}
		this.cubeId_modified = true;
		this.isModified = true;
	}		

	/**
	 * LogicalName : selFactTableId
	 * Comments    : 
	 */		

	private int selFactTableId;
	
		
	
	private boolean selFactTableId_invalidation = false;
	
	public void setInvalidationSelFactTableId(boolean invalidation) { 
		this.selFactTableId_invalidation = invalidation;
	}
	
	public boolean isInvalidationSelFactTableId() {
		return this.selFactTableId_invalidation;
	}
	
	private boolean selFactTableId_modified = false;
	

	public boolean isModifiedSelFactTableId() {
		return this.selFactTableId_modified;
	}
	
	public void unModifiedSelFactTableId() {
		this.selFactTableId_modified = false;
	}

	public int getSelFactTableId() {
		return selFactTableId;
	}
	public void setSelFactTableId(int selFactTableId) {
		this.selFactTableId = selFactTableId;
		this.selFactTableId_modified = true;
		this.isModified = true;
	}
	
	public void setSelFactTableId(Integer selFactTableId) {
		if( selFactTableId == null) {
			this.selFactTableId = 0;
		} else{
			this.selFactTableId = selFactTableId.intValue();
		}
		this.selFactTableId_modified = true;
		this.isModified = true;
	}
	public void setSelFactTableId(String selFactTableId) {
		if  (selFactTableId==null || selFactTableId.length() == 0) {
			this.selFactTableId = 0;
		} else {
			this.selFactTableId = Integer.parseInt(selFactTableId);
		}
		this.selFactTableId_modified = true;
		this.isModified = true;
	}		

	/**
	 * LogicalName : selFactTableName
	 * Comments    : 
	 */		

	private String selFactTableName = EMPTY_STRING;
	
			
	private boolean selFactTableName_nullable = false;
	
	public boolean isNullableSelFactTableName() {
		return this.selFactTableName_nullable;
	}	
	
	private boolean selFactTableName_invalidation = false;
	
	public void setInvalidationSelFactTableName(boolean invalidation) { 
		this.selFactTableName_invalidation = invalidation;
	}
	
	public boolean isInvalidationSelFactTableName() {
		return this.selFactTableName_invalidation;
	}
	
	private boolean selFactTableName_modified = false;
	

	public boolean isModifiedSelFactTableName() {
		return this.selFactTableName_modified;
	}
	
	public void unModifiedSelFactTableName() {
		this.selFactTableName_modified = false;
	}

	public String getSelFactTableName() {
		return selFactTableName;
	}
	public String getNvlSelFactTableName() {
		if(getSelFactTableName() == null) {
			return  EMPTY_STRING;
		} else {
			return getSelFactTableName();
		}
	}
	public void setSelFactTableName(String selFactTableName) {
		if(selFactTableName == null) {
			this.selFactTableName  = EMPTY_STRING;
		} else {
			this.selFactTableName = selFactTableName;
		}
		this.selFactTableName_modified = true;
		this.isModified = true;
	}	
			

	/**
	 * LogicalName : selFactTableColName
	 * Comments    : 
	 */		

	private String selFactTableColName = EMPTY_STRING;
	
			
	private boolean selFactTableColName_nullable = false;
	
	public boolean isNullableSelFactTableColName() {
		return this.selFactTableColName_nullable;
	}	
	
	private boolean selFactTableColName_invalidation = false;
	
	public void setInvalidationSelFactTableColName(boolean invalidation) { 
		this.selFactTableColName_invalidation = invalidation;
	}
	
	public boolean isInvalidationSelFactTableColName() {
		return this.selFactTableColName_invalidation;
	}
	
	private boolean selFactTableColName_modified = false;
	

	public boolean isModifiedSelFactTableColName() {
		return this.selFactTableColName_modified;
	}
	
	public void unModifiedSelFactTableColName() {
		this.selFactTableColName_modified = false;
	}

	public String getSelFactTableColName() {
		return selFactTableColName;
	}
	public String getNvlSelFactTableColName() {
		if(getSelFactTableColName() == null) {
			return  EMPTY_STRING;
		} else {
			return getSelFactTableColName();
		}
	}
	public void setSelFactTableColName(String selFactTableColName) {
		if(selFactTableColName == null) {
			this.selFactTableColName  = EMPTY_STRING;
		} else {
			this.selFactTableColName = selFactTableColName;
		}
		this.selFactTableColName_modified = true;
		this.isModified = true;
	}	
			

	/**
	 * LogicalName : selFactTableColType
	 * Comments    : 
	 */		

	private String selFactTableColType = EMPTY_STRING;
	
			
	private boolean selFactTableColType_nullable = false;
	
	public boolean isNullableSelFactTableColType() {
		return this.selFactTableColType_nullable;
	}	
	
	private boolean selFactTableColType_invalidation = false;
	
	public void setInvalidationSelFactTableColType(boolean invalidation) { 
		this.selFactTableColType_invalidation = invalidation;
	}
	
	public boolean isInvalidationSelFactTableColType() {
		return this.selFactTableColType_invalidation;
	}
	
	private boolean selFactTableColType_modified = false;
	

	public boolean isModifiedSelFactTableColType() {
		return this.selFactTableColType_modified;
	}
	
	public void unModifiedSelFactTableColType() {
		this.selFactTableColType_modified = false;
	}

	public String getSelFactTableColType() {
		return selFactTableColType;
	}
	public String getNvlSelFactTableColType() {
		if(getSelFactTableColType() == null) {
			return  EMPTY_STRING;
		} else {
			return getSelFactTableColType();
		}
	}
	public void setSelFactTableColType(String selFactTableColType) {
		if(selFactTableColType == null) {
			this.selFactTableColType  = EMPTY_STRING;
		} else {
			this.selFactTableColType = selFactTableColType;
		}
		this.selFactTableColType_modified = true;
		this.isModified = true;
	}	
			

	@Override
	public void clearAllIsModified() {
		this.cubeId_modified = false;
		this.selFactTableId_modified = false;
		this.selFactTableName_modified = false;
		this.selFactTableColName_modified = false;
		this.selFactTableColType_modified = false;
		this.isModified = false;
	}
	
	@Override
	public List<String> getIsModifiedField() {
		List<String> modifiedFields = new ArrayList<>();
		if(this.cubeId_modified == true)
			modifiedFields.add("cubeId");
		if(this.selFactTableId_modified == true)
			modifiedFields.add("selFactTableId");
		if(this.selFactTableName_modified == true)
			modifiedFields.add("selFactTableName");
		if(this.selFactTableColName_modified == true)
			modifiedFields.add("selFactTableColName");
		if(this.selFactTableColType_modified == true)
			modifiedFields.add("selFactTableColType");
		return modifiedFields;
	}
	
	@Override
	public boolean isModified() {
	    return isModified;
	} 
	public Object clone() {
		OlapCubeFactParam copyObj = new OlapCubeFactParam();	
		copyObj.clone(this);
		return copyObj;
	}
	public void clone(DataObject _olapCubeFactParam) {
		if(this == _olapCubeFactParam) return;
		OlapCubeFactParam __olapCubeFactParam = (OlapCubeFactParam) _olapCubeFactParam;
		
		this.setCubeId(__olapCubeFactParam.getCubeId());
		this.setSelFactTableId(__olapCubeFactParam.getSelFactTableId());
		this.setSelFactTableName(__olapCubeFactParam.getSelFactTableName());
		this.setSelFactTableColName(__olapCubeFactParam.getSelFactTableColName());
		this.setSelFactTableColType(__olapCubeFactParam.getSelFactTableColType());
		
	}

	public String toString() {
		StringBuilder buffer = new StringBuilder();
				
		buffer.append("cubeId : ").append(cubeId).append("\n");				
		buffer.append("selFactTableId : ").append(selFactTableId).append("\n");				
		buffer.append("selFactTableName : ").append(selFactTableName).append("\n");				
		buffer.append("selFactTableColName : ").append(selFactTableColName).append("\n");				
		buffer.append("selFactTableColType : ").append(selFactTableColType).append("\n");		
		return buffer.toString();
	}
	private static final Map<String,FieldProperty> fieldPropertyMap;
	
	static {
		fieldPropertyMap = new java.util.LinkedHashMap<String,FieldProperty>(5);
		fieldPropertyMap.put("cubeId"
							, FieldPropertyFactory.getFieldProperty( "cubeId","", "", "", false, false, false,  FieldProperty.TYPE_PRIMITIVE_INT, 10 , -1, null, null));		
		fieldPropertyMap.put("selFactTableId"
							, FieldPropertyFactory.getFieldProperty( "selFactTableId","", "", "", false, false, false,  FieldProperty.TYPE_PRIMITIVE_INT, 10 , -1, null, null));		
		fieldPropertyMap.put("selFactTableName"
							, FieldPropertyFactory.getFieldProperty( "selFactTableName","", "", "", false, false, false,  FieldProperty.TYPE_OBJECT_STRING, 255 , -1, null, null));		
		fieldPropertyMap.put("selFactTableColName"
							, FieldPropertyFactory.getFieldProperty( "selFactTableColName","", "", "", false, false, false,  FieldProperty.TYPE_OBJECT_STRING, 255 , -1, null, null));		
		fieldPropertyMap.put("selFactTableColType"
							, FieldPropertyFactory.getFieldProperty( "selFactTableColType","", "", "", false, false, false,  FieldProperty.TYPE_OBJECT_STRING, 255 , -1, null, null));		
	}

	public Map<String,FieldProperty> getFieldPropertyMap() {
		return fieldPropertyMap;
	}
	
	public static Map<String,FieldProperty> getFieldPropertyMapByStatic() {
		return fieldPropertyMap;
	}	

	public Object get(String fieldName) throws FieldNotFoundException {
		switch(fieldName) {
			case "cubeId" : return getCubeId();
			case "selFactTableId" : return getSelFactTableId();
			case "selFactTableName" : return getSelFactTableName();
			case "selFactTableColName" : return getSelFactTableColName();
			case "selFactTableColType" : return getSelFactTableColType();
			default : throw new FieldNotFoundException(fieldName);		
		}
	}




	public void set(String fieldName, Object arg) throws FieldNotFoundException {
		switch(fieldName) {
			case "cubeId" : setCubeId((Integer)arg);break;
			case "selFactTableId" : setSelFactTableId((Integer)arg);break;
			case "selFactTableName" : setSelFactTableName((String)arg);break;
			case "selFactTableColName" : setSelFactTableColName((String)arg);break;
			case "selFactTableColType" : setSelFactTableColType((String)arg);break;
			default : throw new FieldNotFoundException(fieldName);		
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if ((obj instanceof OlapCubeFactParam) == false) return false;
		OlapCubeFactParam _OlapCubeFactParam = (OlapCubeFactParam) obj;				
		if(cubeId != _OlapCubeFactParam.getCubeId()) return false; 								
		if(selFactTableId != _OlapCubeFactParam.getSelFactTableId()) return false; 									
		if(selFactTableName == null) {
			if(_OlapCubeFactParam.getSelFactTableName() != null)
				return false;
		} else if(!selFactTableName.equals(_OlapCubeFactParam.getSelFactTableName()))
			return false;					
		if(selFactTableColName == null) {
			if(_OlapCubeFactParam.getSelFactTableColName() != null)
				return false;
		} else if(!selFactTableColName.equals(_OlapCubeFactParam.getSelFactTableColName()))
			return false;					
		if(selFactTableColType == null) {
			if(_OlapCubeFactParam.getSelFactTableColType() != null)
				return false;
		} else if(!selFactTableColType.equals(_OlapCubeFactParam.getSelFactTableColType()))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		int prime = 31;
		int result = 1;
		result = prime * result + cubeId;
		result = prime * result + selFactTableId;					
		result = prime * result + ((selFactTableName == null) ? 0 : selFactTableName.hashCode());													
		result = prime * result + ((selFactTableColName == null) ? 0 : selFactTableColName.hashCode());													
		result = prime * result + ((selFactTableColType == null) ? 0 : selFactTableColType.hashCode());								
		return result;
	}
	
	private void writeObject(java.io.ObjectOutputStream stream)throws IOException {
		stream.defaultWriteObject();
	}
	
	
}
