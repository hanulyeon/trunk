	
package com.tmax.hyperdata.ui_service.dto;

import java.io.IOException;
import java.util.List;

import java.util.ArrayList;

import java.util.Map;

import com.tmax.promapper.engine.dto.record.common.FieldProperty;
import com.tmax.promapper.engine.dto.record.common.FieldPropertyFactory;
import com.tmax.proobject.model.exception.FieldNotFoundException;

import com.tmax.proobject.model.dataobject.DataObject;




import com.tmax.hyperdata.ui_service.dto.OlapCubeFactParam;




@com.tmax.proobject.core.DataObject
public class OlapCubeFactParamList extends DataObject {
	private static final String DTO_LOGICAL_NAME = "OlapCubeFactParamList";
	
	public String getDtoLogicalName() {
		return DTO_LOGICAL_NAME;
	}
	
	private static final long serialVersionUID= 1L;
	
	public OlapCubeFactParamList() {
			super();
			
	}	 
	
	private boolean isModified = false;

	/**
	 * LogicalName : olapCubeFactParamList
	 * Comments    : 
	 */
	private List<com.tmax.hyperdata.ui_service.dto.OlapCubeFactParam> olapCubeFactParamList = new ArrayList<com.tmax.hyperdata.ui_service.dto.OlapCubeFactParam>(9999);
	
	public List<com.tmax.hyperdata.ui_service.dto.OlapCubeFactParam> getOlapCubeFactParamListList() {
		return olapCubeFactParamList;
	}
	private boolean olapCubeFactParamList_invalidation = false;
	
	public void setInvalidationOlapCubeFactParamList(boolean invalidation) { 
		this.olapCubeFactParamList_invalidation = invalidation;
	}
	
	public boolean isInvalidationOlapCubeFactParamList() {
		return this.olapCubeFactParamList_invalidation;
	}
	
	private boolean olapCubeFactParamList_modified = false;
	
	public boolean isModifiedOlapCubeFactParamList() {
		if(this.olapCubeFactParamList_modified) return true;
		for(int index=0; index < this.sizeOlapCubeFactParamList(); index++) {
			if(this.getOlapCubeFactParamList(index).isModified()) return true;
		}
		return false;
	}
	
	public void unModifiedOlapCubeFactParamList() {
		this.olapCubeFactParamList_modified = false;
	}
	
	public void clearOlapCubeFactParamList() {
		olapCubeFactParamList.clear();
		this.olapCubeFactParamList_modified = false;
	}
	
	public void ensureCapacityOlapCubeFactParamList(int minCapacity) {
		((ArrayList<com.tmax.hyperdata.ui_service.dto.OlapCubeFactParam>)olapCubeFactParamList).ensureCapacity( minCapacity );	
	}	
	public void createOlapCubeFactParamList(int _size) {
		((ArrayList<com.tmax.hyperdata.ui_service.dto.OlapCubeFactParam>)olapCubeFactParamList).ensureCapacity(_size);
		for(int i = olapCubeFactParamList.size(); i < _size; i++) {
			olapCubeFactParamList.add( new com.tmax.hyperdata.ui_service.dto.OlapCubeFactParam());
			this.olapCubeFactParamList_modified = true;
		}
	}
	public OlapCubeFactParamList fillOlapCubeFactParamList(int _index) {
		ensureCapacityOlapCubeFactParamList(_index+1);
		for (int i = sizeOlapCubeFactParamList(); i <  _index + 1; i++) {
			this.olapCubeFactParamList.add(i, new com.tmax.hyperdata.ui_service.dto.OlapCubeFactParam());
			this.olapCubeFactParamList_modified = true;
		}
		return this;
	}
	
	public int sizeOlapCubeFactParamList() {
		return olapCubeFactParamList.size();
	}
	
	public com.tmax.hyperdata.ui_service.dto.OlapCubeFactParam[] getOlapCubeFactParamList() {	
		return (com.tmax.hyperdata.ui_service.dto.OlapCubeFactParam[])olapCubeFactParamList.toArray(new com.tmax.hyperdata.ui_service.dto.OlapCubeFactParam[olapCubeFactParamList.size()]);
		}
	public com.tmax.hyperdata.ui_service.dto.OlapCubeFactParam getOlapCubeFactParamList(int _index) {
		return (com.tmax.hyperdata.ui_service.dto.OlapCubeFactParam)olapCubeFactParamList.get(_index);
	}
	public void setOlapCubeFactParamList(List<com.tmax.hyperdata.ui_service.dto.OlapCubeFactParam> olapCubeFactParamList) {
		this.olapCubeFactParamList.clear();
		if(olapCubeFactParamList == null) {
			return;
		} else {
			for(int i = 0, n=olapCubeFactParamList.size(); i < n; i++) {
				if( olapCubeFactParamList.get(i) == null ) {
					this.olapCubeFactParamList.add( new com.tmax.hyperdata.ui_service.dto.OlapCubeFactParam());					
				}
				else {
					this.olapCubeFactParamList.add(olapCubeFactParamList.get(i));
				}
			}
		}
		this.olapCubeFactParamList_modified = true;
		this.isModified = true;
	}
	
	public void setOlapCubeFactParamList(com.tmax.hyperdata.ui_service.dto.OlapCubeFactParam[] olapCubeFactParamList) {
		this.olapCubeFactParamList.clear();
		if(olapCubeFactParamList == null) {
			return;
		} else {
			((ArrayList<com.tmax.hyperdata.ui_service.dto.OlapCubeFactParam>)this.olapCubeFactParamList).ensureCapacity(olapCubeFactParamList.length);
			for(int i = 0, n=olapCubeFactParamList.length; i < n; i++) {
				if( olapCubeFactParamList[i] == null ) {
					this.olapCubeFactParamList.add( new com.tmax.hyperdata.ui_service.dto.OlapCubeFactParam());					
				}
				else {
					this.olapCubeFactParamList.add(olapCubeFactParamList[i]);
				}
			}
		}
		this.olapCubeFactParamList_modified = true;
		this.isModified = true;
	}
	public void setOlapCubeFactParamList(int _index, com.tmax.hyperdata.ui_service.dto.OlapCubeFactParam olapCubeFactParamList) {
		if(olapCubeFactParamList == null) {
			this.olapCubeFactParamList.set(_index,  new com.tmax.hyperdata.ui_service.dto.OlapCubeFactParam());
		} else {
			this.olapCubeFactParamList.set(_index, olapCubeFactParamList);
		}
		this.olapCubeFactParamList_modified = true;
		this.isModified = true;
	}				
		
	public void addOlapCubeFactParamList(int _index, com.tmax.hyperdata.ui_service.dto.OlapCubeFactParam olapCubeFactParamList) {
		if(olapCubeFactParamList == null) {
			this.olapCubeFactParamList.add(_index,  new com.tmax.hyperdata.ui_service.dto.OlapCubeFactParam());
		} else {
			this.olapCubeFactParamList.add(_index, olapCubeFactParamList);
		}
		this.olapCubeFactParamList_modified = true;
		this.isModified = true;
	}
	public void addOlapCubeFactParamList(com.tmax.hyperdata.ui_service.dto.OlapCubeFactParam olapCubeFactParamList) {
		if(olapCubeFactParamList == null) {
			this.olapCubeFactParamList.add( new com.tmax.hyperdata.ui_service.dto.OlapCubeFactParam());
		} else {
			this.olapCubeFactParamList.add(olapCubeFactParamList);
		}
		this.olapCubeFactParamList_modified = true;
		this.isModified = true;
	}
	public com.tmax.hyperdata.ui_service.dto.OlapCubeFactParam removeOlapCubeFactParamList(int _index) {
		this.olapCubeFactParamList_modified = true;
		this.isModified = true;
		return (com.tmax.hyperdata.ui_service.dto.OlapCubeFactParam)this.olapCubeFactParamList.remove(_index);
	}

	@Override
	public void clearAllIsModified() {
		this.olapCubeFactParamList_modified = false;
		this.isModified = false;
	}
	
	@Override
	public List<String> getIsModifiedField() {
		List<String> modifiedFields = new ArrayList<>();
		if(this.olapCubeFactParamList_modified == true)
			modifiedFields.add("olapCubeFactParamList");
		return modifiedFields;
	}
	
	@Override
	public boolean isModified() {
	    return isModified;
	} 
	public Object clone() {
		OlapCubeFactParamList copyObj = new OlapCubeFactParamList();	
		copyObj.clone(this);
		return copyObj;
	}
	public void clone(DataObject _olapCubeFactParamList) {
		if(this == _olapCubeFactParamList) return;
		OlapCubeFactParamList __olapCubeFactParamList = (OlapCubeFactParamList) _olapCubeFactParamList;
		
		this.clearOlapCubeFactParamList();
		for (int index = 0; index < __olapCubeFactParamList.sizeOlapCubeFactParamList(); index++) {
			this.addOlapCubeFactParamList(index, (com.tmax.hyperdata.ui_service.dto.OlapCubeFactParam)__olapCubeFactParamList.getOlapCubeFactParamList(index).clone());		
		}
		
	}

	public String toString() {
		StringBuilder buffer = new StringBuilder();
		
		buffer.append("olapCubeFactParamList [");
		for (int index = 0; index < sizeOlapCubeFactParamList(); index++) {
			buffer.append("(").append(index).append(") : ").append(getOlapCubeFactParamList(index)).append(" ");
		}
		buffer.append("]");
		buffer.append("\n");
		return buffer.toString();
	}
	private static final Map<String,FieldProperty> fieldPropertyMap;
	
	static {
		fieldPropertyMap = new java.util.LinkedHashMap<String,FieldProperty>(1);
		fieldPropertyMap.put("olapCubeFactParamList"
							, FieldPropertyFactory.getFieldProperty( "olapCubeFactParamList","", "", "", false, false, false, FieldProperty.TYPE_ABSTRACT_INCLUDE, -1, -1, "9999" , "com.tmax.hyperdata.ui_service.dto.OlapCubeFactParam"));		
	}

	public Map<String,FieldProperty> getFieldPropertyMap() {
		return fieldPropertyMap;
	}
	
	public static Map<String,FieldProperty> getFieldPropertyMapByStatic() {
		return fieldPropertyMap;
	}	

	public Object get(String fieldName) throws FieldNotFoundException {
		switch(fieldName) {
			case "olapCubeFactParamList" : return getOlapCubeFactParamListList();
			default : throw new FieldNotFoundException(fieldName);		
		}
	}




	public void set(String fieldName, Object arg) throws FieldNotFoundException {
		switch(fieldName) {
			case "olapCubeFactParamList" : setOlapCubeFactParamList((List<com.tmax.hyperdata.ui_service.dto.OlapCubeFactParam>)arg);break;
			default : throw new FieldNotFoundException(fieldName);		
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if ((obj instanceof OlapCubeFactParamList) == false) return false;
		OlapCubeFactParamList _OlapCubeFactParamList = (OlapCubeFactParamList) obj;
		if(olapCubeFactParamList.size() != _OlapCubeFactParamList.sizeOlapCubeFactParamList()) return false;
		else {
			for(int i = 0, n = olapCubeFactParamList.size(); i < n; i++ ){ 
				if(!this.getOlapCubeFactParamList(i).equals(_OlapCubeFactParamList.getOlapCubeFactParamList(i))) return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		int prime = 31;
		int result = 1;

		for(int i=0, n=this.olapCubeFactParamList.size(); i<n; i++ ){ 
			result = prime * result + this.getOlapCubeFactParamList(i).hashCode();
		}
		return result;
	}
	
	private void writeObject(java.io.ObjectOutputStream stream)throws IOException {
		stream.defaultWriteObject();
	}
	
	
}
