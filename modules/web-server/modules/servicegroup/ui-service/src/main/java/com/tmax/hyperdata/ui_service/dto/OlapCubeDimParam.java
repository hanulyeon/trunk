	
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
public class OlapCubeDimParam extends DataObject {
	private static final String DTO_LOGICAL_NAME = "OlapCubeDimParam";
	
	public String getDtoLogicalName() {
		return DTO_LOGICAL_NAME;
	}
	
	private static final long serialVersionUID= 1L;
	
	public OlapCubeDimParam() {
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
	 * LogicalName : selDimTableId
	 * Comments    : 
	 */		

	private int selDimTableId;
	
		
	
	private boolean selDimTableId_invalidation = false;
	
	public void setInvalidationSelDimTableId(boolean invalidation) { 
		this.selDimTableId_invalidation = invalidation;
	}
	
	public boolean isInvalidationSelDimTableId() {
		return this.selDimTableId_invalidation;
	}
	
	private boolean selDimTableId_modified = false;
	

	public boolean isModifiedSelDimTableId() {
		return this.selDimTableId_modified;
	}
	
	public void unModifiedSelDimTableId() {
		this.selDimTableId_modified = false;
	}

	public int getSelDimTableId() {
		return selDimTableId;
	}
	public void setSelDimTableId(int selDimTableId) {
		this.selDimTableId = selDimTableId;
		this.selDimTableId_modified = true;
		this.isModified = true;
	}
	
	public void setSelDimTableId(Integer selDimTableId) {
		if( selDimTableId == null) {
			this.selDimTableId = 0;
		} else{
			this.selDimTableId = selDimTableId.intValue();
		}
		this.selDimTableId_modified = true;
		this.isModified = true;
	}
	public void setSelDimTableId(String selDimTableId) {
		if  (selDimTableId==null || selDimTableId.length() == 0) {
			this.selDimTableId = 0;
		} else {
			this.selDimTableId = Integer.parseInt(selDimTableId);
		}
		this.selDimTableId_modified = true;
		this.isModified = true;
	}		

	/**
	 * LogicalName : selDimTableName
	 * Comments    : 
	 */		

	private String selDimTableName = EMPTY_STRING;
	
			
	private boolean selDimTableName_nullable = false;
	
	public boolean isNullableSelDimTableName() {
		return this.selDimTableName_nullable;
	}	
	
	private boolean selDimTableName_invalidation = false;
	
	public void setInvalidationSelDimTableName(boolean invalidation) { 
		this.selDimTableName_invalidation = invalidation;
	}
	
	public boolean isInvalidationSelDimTableName() {
		return this.selDimTableName_invalidation;
	}
	
	private boolean selDimTableName_modified = false;
	

	public boolean isModifiedSelDimTableName() {
		return this.selDimTableName_modified;
	}
	
	public void unModifiedSelDimTableName() {
		this.selDimTableName_modified = false;
	}

	public String getSelDimTableName() {
		return selDimTableName;
	}
	public String getNvlSelDimTableName() {
		if(getSelDimTableName() == null) {
			return  EMPTY_STRING;
		} else {
			return getSelDimTableName();
		}
	}
	public void setSelDimTableName(String selDimTableName) {
		if(selDimTableName == null) {
			this.selDimTableName  = EMPTY_STRING;
		} else {
			this.selDimTableName = selDimTableName;
		}
		this.selDimTableName_modified = true;
		this.isModified = true;
	}	
			

	/**
	 * LogicalName : selDimTableColName
	 * Comments    : 
	 */		

	private String selDimTableColName = EMPTY_STRING;
	
			
	private boolean selDimTableColName_nullable = false;
	
	public boolean isNullableSelDimTableColName() {
		return this.selDimTableColName_nullable;
	}	
	
	private boolean selDimTableColName_invalidation = false;
	
	public void setInvalidationSelDimTableColName(boolean invalidation) { 
		this.selDimTableColName_invalidation = invalidation;
	}
	
	public boolean isInvalidationSelDimTableColName() {
		return this.selDimTableColName_invalidation;
	}
	
	private boolean selDimTableColName_modified = false;
	

	public boolean isModifiedSelDimTableColName() {
		return this.selDimTableColName_modified;
	}
	
	public void unModifiedSelDimTableColName() {
		this.selDimTableColName_modified = false;
	}

	public String getSelDimTableColName() {
		return selDimTableColName;
	}
	public String getNvlSelDimTableColName() {
		if(getSelDimTableColName() == null) {
			return  EMPTY_STRING;
		} else {
			return getSelDimTableColName();
		}
	}
	public void setSelDimTableColName(String selDimTableColName) {
		if(selDimTableColName == null) {
			this.selDimTableColName  = EMPTY_STRING;
		} else {
			this.selDimTableColName = selDimTableColName;
		}
		this.selDimTableColName_modified = true;
		this.isModified = true;
	}	
			

	/**
	 * LogicalName : selDimTableColType
	 * Comments    : 
	 */		

	private String selDimTableColType = EMPTY_STRING;
	
			
	private boolean selDimTableColType_nullable = false;
	
	public boolean isNullableSelDimTableColType() {
		return this.selDimTableColType_nullable;
	}	
	
	private boolean selDimTableColType_invalidation = false;
	
	public void setInvalidationSelDimTableColType(boolean invalidation) { 
		this.selDimTableColType_invalidation = invalidation;
	}
	
	public boolean isInvalidationSelDimTableColType() {
		return this.selDimTableColType_invalidation;
	}
	
	private boolean selDimTableColType_modified = false;
	

	public boolean isModifiedSelDimTableColType() {
		return this.selDimTableColType_modified;
	}
	
	public void unModifiedSelDimTableColType() {
		this.selDimTableColType_modified = false;
	}

	public String getSelDimTableColType() {
		return selDimTableColType;
	}
	public String getNvlSelDimTableColType() {
		if(getSelDimTableColType() == null) {
			return  EMPTY_STRING;
		} else {
			return getSelDimTableColType();
		}
	}
	public void setSelDimTableColType(String selDimTableColType) {
		if(selDimTableColType == null) {
			this.selDimTableColType  = EMPTY_STRING;
		} else {
			this.selDimTableColType = selDimTableColType;
		}
		this.selDimTableColType_modified = true;
		this.isModified = true;
	}	
			

	@Override
	public void clearAllIsModified() {
		this.cubeId_modified = false;
		this.selDimTableId_modified = false;
		this.selDimTableName_modified = false;
		this.selDimTableColName_modified = false;
		this.selDimTableColType_modified = false;
		this.isModified = false;
	}
	
	@Override
	public List<String> getIsModifiedField() {
		List<String> modifiedFields = new ArrayList<>();
		if(this.cubeId_modified == true)
			modifiedFields.add("cubeId");
		if(this.selDimTableId_modified == true)
			modifiedFields.add("selDimTableId");
		if(this.selDimTableName_modified == true)
			modifiedFields.add("selDimTableName");
		if(this.selDimTableColName_modified == true)
			modifiedFields.add("selDimTableColName");
		if(this.selDimTableColType_modified == true)
			modifiedFields.add("selDimTableColType");
		return modifiedFields;
	}
	
	@Override
	public boolean isModified() {
	    return isModified;
	} 
	public Object clone() {
		OlapCubeDimParam copyObj = new OlapCubeDimParam();	
		copyObj.clone(this);
		return copyObj;
	}
	public void clone(DataObject _olapCubeDimParam) {
		if(this == _olapCubeDimParam) return;
		OlapCubeDimParam __olapCubeDimParam = (OlapCubeDimParam) _olapCubeDimParam;
		
		this.setCubeId(__olapCubeDimParam.getCubeId());
		this.setSelDimTableId(__olapCubeDimParam.getSelDimTableId());
		this.setSelDimTableName(__olapCubeDimParam.getSelDimTableName());
		this.setSelDimTableColName(__olapCubeDimParam.getSelDimTableColName());
		this.setSelDimTableColType(__olapCubeDimParam.getSelDimTableColType());
		
	}

	public String toString() {
		StringBuilder buffer = new StringBuilder();
				
		buffer.append("cubeId : ").append(cubeId).append("\n");				
		buffer.append("selDimTableId : ").append(selDimTableId).append("\n");				
		buffer.append("selDimTableName : ").append(selDimTableName).append("\n");				
		buffer.append("selDimTableColName : ").append(selDimTableColName).append("\n");				
		buffer.append("selDimTableColType : ").append(selDimTableColType).append("\n");		
		return buffer.toString();
	}
	private static final Map<String,FieldProperty> fieldPropertyMap;
	
	static {
		fieldPropertyMap = new java.util.LinkedHashMap<String,FieldProperty>(5);
		fieldPropertyMap.put("cubeId"
							, FieldPropertyFactory.getFieldProperty( "cubeId","", "", "", false, false, false,  FieldProperty.TYPE_PRIMITIVE_INT, 10 , -1, null, null));		
		fieldPropertyMap.put("selDimTableId"
							, FieldPropertyFactory.getFieldProperty( "selDimTableId","", "", "", false, false, false,  FieldProperty.TYPE_PRIMITIVE_INT, 10 , -1, null, null));		
		fieldPropertyMap.put("selDimTableName"
							, FieldPropertyFactory.getFieldProperty( "selDimTableName","", "", "", false, false, false,  FieldProperty.TYPE_OBJECT_STRING, 255 , -1, null, null));		
		fieldPropertyMap.put("selDimTableColName"
							, FieldPropertyFactory.getFieldProperty( "selDimTableColName","", "", "", false, false, false,  FieldProperty.TYPE_OBJECT_STRING, 255 , -1, null, null));		
		fieldPropertyMap.put("selDimTableColType"
							, FieldPropertyFactory.getFieldProperty( "selDimTableColType","", "", "", false, false, false,  FieldProperty.TYPE_OBJECT_STRING, 255 , -1, null, null));		
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
			case "selDimTableId" : return getSelDimTableId();
			case "selDimTableName" : return getSelDimTableName();
			case "selDimTableColName" : return getSelDimTableColName();
			case "selDimTableColType" : return getSelDimTableColType();
			default : throw new FieldNotFoundException(fieldName);		
		}
	}




	public void set(String fieldName, Object arg) throws FieldNotFoundException {
		switch(fieldName) {
			case "cubeId" : setCubeId((Integer)arg);break;
			case "selDimTableId" : setSelDimTableId((Integer)arg);break;
			case "selDimTableName" : setSelDimTableName((String)arg);break;
			case "selDimTableColName" : setSelDimTableColName((String)arg);break;
			case "selDimTableColType" : setSelDimTableColType((String)arg);break;
			default : throw new FieldNotFoundException(fieldName);		
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if ((obj instanceof OlapCubeDimParam) == false) return false;
		OlapCubeDimParam _OlapCubeDimParam = (OlapCubeDimParam) obj;				
		if(cubeId != _OlapCubeDimParam.getCubeId()) return false; 								
		if(selDimTableId != _OlapCubeDimParam.getSelDimTableId()) return false; 									
		if(selDimTableName == null) {
			if(_OlapCubeDimParam.getSelDimTableName() != null)
				return false;
		} else if(!selDimTableName.equals(_OlapCubeDimParam.getSelDimTableName()))
			return false;					
		if(selDimTableColName == null) {
			if(_OlapCubeDimParam.getSelDimTableColName() != null)
				return false;
		} else if(!selDimTableColName.equals(_OlapCubeDimParam.getSelDimTableColName()))
			return false;					
		if(selDimTableColType == null) {
			if(_OlapCubeDimParam.getSelDimTableColType() != null)
				return false;
		} else if(!selDimTableColType.equals(_OlapCubeDimParam.getSelDimTableColType()))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		int prime = 31;
		int result = 1;
		result = prime * result + cubeId;
		result = prime * result + selDimTableId;					
		result = prime * result + ((selDimTableName == null) ? 0 : selDimTableName.hashCode());													
		result = prime * result + ((selDimTableColName == null) ? 0 : selDimTableColName.hashCode());													
		result = prime * result + ((selDimTableColType == null) ? 0 : selDimTableColType.hashCode());								
		return result;
	}
	
	private void writeObject(java.io.ObjectOutputStream stream)throws IOException {
		stream.defaultWriteObject();
	}
	
	
}
