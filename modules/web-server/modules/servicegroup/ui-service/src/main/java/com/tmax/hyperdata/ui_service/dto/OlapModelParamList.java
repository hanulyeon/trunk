	
package com.tmax.hyperdata.ui_service.dto;

import java.io.IOException;
import java.util.List;

import java.util.ArrayList;

import java.util.Map;

import com.tmax.promapper.engine.dto.record.common.FieldProperty;
import com.tmax.promapper.engine.dto.record.common.FieldPropertyFactory;
import com.tmax.proobject.model.exception.FieldNotFoundException;

import com.tmax.proobject.model.dataobject.DataObject;




import com.tmax.hyperdata.ui_service.dto.OlapModelParam;




@com.tmax.proobject.core.DataObject
public class OlapModelParamList extends DataObject {
	private static final String DTO_LOGICAL_NAME = "OlapModelParamList";
	
	public String getDtoLogicalName() {
		return DTO_LOGICAL_NAME;
	}
	
	private static final long serialVersionUID= 1L;
	
	public OlapModelParamList() {
			super();
			
	}	 
	
	private boolean isModified = false;

	/**
	 * LogicalName : olapModelParamList
	 * Comments    : 
	 */		

	private com.tmax.hyperdata.ui_service.dto.OlapModelParam olapModelParamList = new com.tmax.hyperdata.ui_service.dto.OlapModelParam();
	
		
	
	private boolean olapModelParamList_invalidation = false;
	
	public void setInvalidationOlapModelParamList(boolean invalidation) { 
		this.olapModelParamList_invalidation = invalidation;
	}
	
	public boolean isInvalidationOlapModelParamList() {
		return this.olapModelParamList_invalidation;
	}
	
	private boolean olapModelParamList_modified = false;
	

	public boolean isModifiedOlapModelParamList() {
		if(this.olapModelParamList_modified) return true;
		if(olapModelParamList.isModified()) return true;
		return false;
	}
	
	public void unModifiedOlapModelParamList() {
		this.olapModelParamList_modified = false;
	}

	public com.tmax.hyperdata.ui_service.dto.OlapModelParam getOlapModelParamList() {
		return olapModelParamList;
	}
	public void setOlapModelParamList(com.tmax.hyperdata.ui_service.dto.OlapModelParam olapModelParamList) {
		if(olapModelParamList == null) {
			this.olapModelParamList  = new com.tmax.hyperdata.ui_service.dto.OlapModelParam();
		} else {
			this.olapModelParamList = olapModelParamList;
		}
		this.olapModelParamList_modified = true;
		this.isModified = true;
	}	
			

	@Override
	public void clearAllIsModified() {
		this.olapModelParamList_modified = false;
		this.isModified = false;
	}
	
	@Override
	public List<String> getIsModifiedField() {
		List<String> modifiedFields = new ArrayList<>();
		if(this.olapModelParamList_modified == true)
			modifiedFields.add("olapModelParamList");
		return modifiedFields;
	}
	
	@Override
	public boolean isModified() {
	    return isModified;
	} 
	public Object clone() {
		OlapModelParamList copyObj = new OlapModelParamList();	
		copyObj.clone(this);
		return copyObj;
	}
	public void clone(DataObject _olapModelParamList) {
		if(this == _olapModelParamList) return;
		OlapModelParamList __olapModelParamList = (OlapModelParamList) _olapModelParamList;
		
		this.setOlapModelParamList((com.tmax.hyperdata.ui_service.dto.OlapModelParam)__olapModelParamList.getOlapModelParamList().clone());
		
	}

	public String toString() {
		StringBuilder buffer = new StringBuilder();
				
		buffer.append("olapModelParamList : ").append(olapModelParamList).append("\n");		
		return buffer.toString();
	}
	private static final Map<String,FieldProperty> fieldPropertyMap;
	
	static {
		fieldPropertyMap = new java.util.LinkedHashMap<String,FieldProperty>(1);
		fieldPropertyMap.put("olapModelParamList"
							, FieldPropertyFactory.getFieldProperty( "olapModelParamList","", "", "", false, false, false, FieldProperty.TYPE_ABSTRACT_INCLUDE, -1, -1, null, "com.tmax.hyperdata.ui_service.dto.OlapModelParam"));		
	}

	public Map<String,FieldProperty> getFieldPropertyMap() {
		return fieldPropertyMap;
	}
	
	public static Map<String,FieldProperty> getFieldPropertyMapByStatic() {
		return fieldPropertyMap;
	}	

	public Object get(String fieldName) throws FieldNotFoundException {
		switch(fieldName) {
			case "olapModelParamList" : return getOlapModelParamList();
			default : throw new FieldNotFoundException(fieldName);		
		}
	}




	public void set(String fieldName, Object arg) throws FieldNotFoundException {
		switch(fieldName) {
			case "olapModelParamList" : setOlapModelParamList((com.tmax.hyperdata.ui_service.dto.OlapModelParam)arg);break;
			default : throw new FieldNotFoundException(fieldName);		
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if ((obj instanceof OlapModelParamList) == false) return false;
		OlapModelParamList _OlapModelParamList = (OlapModelParamList) obj;			
		if(!this.getOlapModelParamList().equals(_OlapModelParamList.getOlapModelParamList())) return false;			
		return true;
	}

	@Override
	public int hashCode() {
		int prime = 31;
		int result = 1;			
		result = prime * result + olapModelParamList.hashCode();			
		return result;
	}
	
	private void writeObject(java.io.ObjectOutputStream stream)throws IOException {
		stream.defaultWriteObject();
	}
	
	
}
