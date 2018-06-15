	
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
public class OlapCubeMeasureParam extends DataObject {
	private static final String DTO_LOGICAL_NAME = "OlapCubeMeasureParam";
	
	public String getDtoLogicalName() {
		return DTO_LOGICAL_NAME;
	}
	
	private static final long serialVersionUID= 1L;
	
	public OlapCubeMeasureParam() {
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
	 * LogicalName : selMeasureColName
	 * Comments    : 
	 */		

	private String selMeasureColName = EMPTY_STRING;
	
			
	private boolean selMeasureColName_nullable = false;
	
	public boolean isNullableSelMeasureColName() {
		return this.selMeasureColName_nullable;
	}	
	
	private boolean selMeasureColName_invalidation = false;
	
	public void setInvalidationSelMeasureColName(boolean invalidation) { 
		this.selMeasureColName_invalidation = invalidation;
	}
	
	public boolean isInvalidationSelMeasureColName() {
		return this.selMeasureColName_invalidation;
	}
	
	private boolean selMeasureColName_modified = false;
	

	public boolean isModifiedSelMeasureColName() {
		return this.selMeasureColName_modified;
	}
	
	public void unModifiedSelMeasureColName() {
		this.selMeasureColName_modified = false;
	}

	public String getSelMeasureColName() {
		return selMeasureColName;
	}
	public String getNvlSelMeasureColName() {
		if(getSelMeasureColName() == null) {
			return  EMPTY_STRING;
		} else {
			return getSelMeasureColName();
		}
	}
	public void setSelMeasureColName(String selMeasureColName) {
		if(selMeasureColName == null) {
			this.selMeasureColName  = EMPTY_STRING;
		} else {
			this.selMeasureColName = selMeasureColName;
		}
		this.selMeasureColName_modified = true;
		this.isModified = true;
	}	
			

	/**
	 * LogicalName : selMeasureColValue
	 * Comments    : 
	 */		

	private String selMeasureColValue = EMPTY_STRING;
	
			
	private boolean selMeasureColValue_nullable = false;
	
	public boolean isNullableSelMeasureColValue() {
		return this.selMeasureColValue_nullable;
	}	
	
	private boolean selMeasureColValue_invalidation = false;
	
	public void setInvalidationSelMeasureColValue(boolean invalidation) { 
		this.selMeasureColValue_invalidation = invalidation;
	}
	
	public boolean isInvalidationSelMeasureColValue() {
		return this.selMeasureColValue_invalidation;
	}
	
	private boolean selMeasureColValue_modified = false;
	

	public boolean isModifiedSelMeasureColValue() {
		return this.selMeasureColValue_modified;
	}
	
	public void unModifiedSelMeasureColValue() {
		this.selMeasureColValue_modified = false;
	}

	public String getSelMeasureColValue() {
		return selMeasureColValue;
	}
	public String getNvlSelMeasureColValue() {
		if(getSelMeasureColValue() == null) {
			return  EMPTY_STRING;
		} else {
			return getSelMeasureColValue();
		}
	}
	public void setSelMeasureColValue(String selMeasureColValue) {
		if(selMeasureColValue == null) {
			this.selMeasureColValue  = EMPTY_STRING;
		} else {
			this.selMeasureColValue = selMeasureColValue;
		}
		this.selMeasureColValue_modified = true;
		this.isModified = true;
	}	
			

	/**
	 * LogicalName : selMeasureColType
	 * Comments    : 
	 */		

	private String selMeasureColType = EMPTY_STRING;
	
			
	private boolean selMeasureColType_nullable = false;
	
	public boolean isNullableSelMeasureColType() {
		return this.selMeasureColType_nullable;
	}	
	
	private boolean selMeasureColType_invalidation = false;
	
	public void setInvalidationSelMeasureColType(boolean invalidation) { 
		this.selMeasureColType_invalidation = invalidation;
	}
	
	public boolean isInvalidationSelMeasureColType() {
		return this.selMeasureColType_invalidation;
	}
	
	private boolean selMeasureColType_modified = false;
	

	public boolean isModifiedSelMeasureColType() {
		return this.selMeasureColType_modified;
	}
	
	public void unModifiedSelMeasureColType() {
		this.selMeasureColType_modified = false;
	}

	public String getSelMeasureColType() {
		return selMeasureColType;
	}
	public String getNvlSelMeasureColType() {
		if(getSelMeasureColType() == null) {
			return  EMPTY_STRING;
		} else {
			return getSelMeasureColType();
		}
	}
	public void setSelMeasureColType(String selMeasureColType) {
		if(selMeasureColType == null) {
			this.selMeasureColType  = EMPTY_STRING;
		} else {
			this.selMeasureColType = selMeasureColType;
		}
		this.selMeasureColType_modified = true;
		this.isModified = true;
	}	
			

	/**
	 * LogicalName : selMeasureColExpresion
	 * Comments    : 
	 */		

	private String selMeasureColExpresion = EMPTY_STRING;
	
			
	private boolean selMeasureColExpresion_nullable = false;
	
	public boolean isNullableSelMeasureColExpresion() {
		return this.selMeasureColExpresion_nullable;
	}	
	
	private boolean selMeasureColExpresion_invalidation = false;
	
	public void setInvalidationSelMeasureColExpresion(boolean invalidation) { 
		this.selMeasureColExpresion_invalidation = invalidation;
	}
	
	public boolean isInvalidationSelMeasureColExpresion() {
		return this.selMeasureColExpresion_invalidation;
	}
	
	private boolean selMeasureColExpresion_modified = false;
	

	public boolean isModifiedSelMeasureColExpresion() {
		return this.selMeasureColExpresion_modified;
	}
	
	public void unModifiedSelMeasureColExpresion() {
		this.selMeasureColExpresion_modified = false;
	}

	public String getSelMeasureColExpresion() {
		return selMeasureColExpresion;
	}
	public String getNvlSelMeasureColExpresion() {
		if(getSelMeasureColExpresion() == null) {
			return  EMPTY_STRING;
		} else {
			return getSelMeasureColExpresion();
		}
	}
	public void setSelMeasureColExpresion(String selMeasureColExpresion) {
		if(selMeasureColExpresion == null) {
			this.selMeasureColExpresion  = EMPTY_STRING;
		} else {
			this.selMeasureColExpresion = selMeasureColExpresion;
		}
		this.selMeasureColExpresion_modified = true;
		this.isModified = true;
	}	
			

	@Override
	public void clearAllIsModified() {
		this.cubeId_modified = false;
		this.selFactTableId_modified = false;
		this.selMeasureColName_modified = false;
		this.selMeasureColValue_modified = false;
		this.selMeasureColType_modified = false;
		this.selMeasureColExpresion_modified = false;
		this.isModified = false;
	}
	
	@Override
	public List<String> getIsModifiedField() {
		List<String> modifiedFields = new ArrayList<>();
		if(this.cubeId_modified == true)
			modifiedFields.add("cubeId");
		if(this.selFactTableId_modified == true)
			modifiedFields.add("selFactTableId");
		if(this.selMeasureColName_modified == true)
			modifiedFields.add("selMeasureColName");
		if(this.selMeasureColValue_modified == true)
			modifiedFields.add("selMeasureColValue");
		if(this.selMeasureColType_modified == true)
			modifiedFields.add("selMeasureColType");
		if(this.selMeasureColExpresion_modified == true)
			modifiedFields.add("selMeasureColExpresion");
		return modifiedFields;
	}
	
	@Override
	public boolean isModified() {
	    return isModified;
	} 
	public Object clone() {
		OlapCubeMeasureParam copyObj = new OlapCubeMeasureParam();	
		copyObj.clone(this);
		return copyObj;
	}
	public void clone(DataObject _olapCubeMeasureParam) {
		if(this == _olapCubeMeasureParam) return;
		OlapCubeMeasureParam __olapCubeMeasureParam = (OlapCubeMeasureParam) _olapCubeMeasureParam;
		
		this.setCubeId(__olapCubeMeasureParam.getCubeId());
		this.setSelFactTableId(__olapCubeMeasureParam.getSelFactTableId());
		this.setSelMeasureColName(__olapCubeMeasureParam.getSelMeasureColName());
		this.setSelMeasureColValue(__olapCubeMeasureParam.getSelMeasureColValue());
		this.setSelMeasureColType(__olapCubeMeasureParam.getSelMeasureColType());
		this.setSelMeasureColExpresion(__olapCubeMeasureParam.getSelMeasureColExpresion());
		
	}

	public String toString() {
		StringBuilder buffer = new StringBuilder();
				
		buffer.append("cubeId : ").append(cubeId).append("\n");				
		buffer.append("selFactTableId : ").append(selFactTableId).append("\n");				
		buffer.append("selMeasureColName : ").append(selMeasureColName).append("\n");				
		buffer.append("selMeasureColValue : ").append(selMeasureColValue).append("\n");				
		buffer.append("selMeasureColType : ").append(selMeasureColType).append("\n");				
		buffer.append("selMeasureColExpresion : ").append(selMeasureColExpresion).append("\n");		
		return buffer.toString();
	}
	private static final Map<String,FieldProperty> fieldPropertyMap;
	
	static {
		fieldPropertyMap = new java.util.LinkedHashMap<String,FieldProperty>(6);
		fieldPropertyMap.put("cubeId"
							, FieldPropertyFactory.getFieldProperty( "cubeId","", "", "", false, false, false,  FieldProperty.TYPE_PRIMITIVE_INT, 10 , -1, null, null));		
		fieldPropertyMap.put("selFactTableId"
							, FieldPropertyFactory.getFieldProperty( "selFactTableId","", "", "", false, false, false,  FieldProperty.TYPE_PRIMITIVE_INT, 10 , -1, null, null));		
		fieldPropertyMap.put("selMeasureColName"
							, FieldPropertyFactory.getFieldProperty( "selMeasureColName","", "", "", false, false, false,  FieldProperty.TYPE_OBJECT_STRING, 255 , -1, null, null));		
		fieldPropertyMap.put("selMeasureColValue"
							, FieldPropertyFactory.getFieldProperty( "selMeasureColValue","", "", "", false, false, false,  FieldProperty.TYPE_OBJECT_STRING, 255 , -1, null, null));		
		fieldPropertyMap.put("selMeasureColType"
							, FieldPropertyFactory.getFieldProperty( "selMeasureColType","", "", "", false, false, false,  FieldProperty.TYPE_OBJECT_STRING, 255 , -1, null, null));		
		fieldPropertyMap.put("selMeasureColExpresion"
							, FieldPropertyFactory.getFieldProperty( "selMeasureColExpresion","", "", "", false, false, false,  FieldProperty.TYPE_OBJECT_STRING, 255 , -1, null, null));		
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
			case "selMeasureColName" : return getSelMeasureColName();
			case "selMeasureColValue" : return getSelMeasureColValue();
			case "selMeasureColType" : return getSelMeasureColType();
			case "selMeasureColExpresion" : return getSelMeasureColExpresion();
			default : throw new FieldNotFoundException(fieldName);		
		}
	}




	public void set(String fieldName, Object arg) throws FieldNotFoundException {
		switch(fieldName) {
			case "cubeId" : setCubeId((Integer)arg);break;
			case "selFactTableId" : setSelFactTableId((Integer)arg);break;
			case "selMeasureColName" : setSelMeasureColName((String)arg);break;
			case "selMeasureColValue" : setSelMeasureColValue((String)arg);break;
			case "selMeasureColType" : setSelMeasureColType((String)arg);break;
			case "selMeasureColExpresion" : setSelMeasureColExpresion((String)arg);break;
			default : throw new FieldNotFoundException(fieldName);		
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if ((obj instanceof OlapCubeMeasureParam) == false) return false;
		OlapCubeMeasureParam _OlapCubeMeasureParam = (OlapCubeMeasureParam) obj;				
		if(cubeId != _OlapCubeMeasureParam.getCubeId()) return false; 								
		if(selFactTableId != _OlapCubeMeasureParam.getSelFactTableId()) return false; 									
		if(selMeasureColName == null) {
			if(_OlapCubeMeasureParam.getSelMeasureColName() != null)
				return false;
		} else if(!selMeasureColName.equals(_OlapCubeMeasureParam.getSelMeasureColName()))
			return false;					
		if(selMeasureColValue == null) {
			if(_OlapCubeMeasureParam.getSelMeasureColValue() != null)
				return false;
		} else if(!selMeasureColValue.equals(_OlapCubeMeasureParam.getSelMeasureColValue()))
			return false;					
		if(selMeasureColType == null) {
			if(_OlapCubeMeasureParam.getSelMeasureColType() != null)
				return false;
		} else if(!selMeasureColType.equals(_OlapCubeMeasureParam.getSelMeasureColType()))
			return false;					
		if(selMeasureColExpresion == null) {
			if(_OlapCubeMeasureParam.getSelMeasureColExpresion() != null)
				return false;
		} else if(!selMeasureColExpresion.equals(_OlapCubeMeasureParam.getSelMeasureColExpresion()))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		int prime = 31;
		int result = 1;
		result = prime * result + cubeId;
		result = prime * result + selFactTableId;					
		result = prime * result + ((selMeasureColName == null) ? 0 : selMeasureColName.hashCode());													
		result = prime * result + ((selMeasureColValue == null) ? 0 : selMeasureColValue.hashCode());													
		result = prime * result + ((selMeasureColType == null) ? 0 : selMeasureColType.hashCode());													
		result = prime * result + ((selMeasureColExpresion == null) ? 0 : selMeasureColExpresion.hashCode());								
		return result;
	}
	
	private void writeObject(java.io.ObjectOutputStream stream)throws IOException {
		stream.defaultWriteObject();
	}
	
	
}
