	
package com.tmax.hyperdata.ui_service.dto;

import java.io.IOException;
import java.util.List;

import java.util.ArrayList;

import java.util.Map;

import com.tmax.promapper.engine.dto.record.common.FieldProperty;
import com.tmax.promapper.engine.dto.record.common.FieldPropertyFactory;
import com.tmax.proobject.model.exception.FieldNotFoundException;

import com.tmax.proobject.model.dataobject.DataObject;




import com.tmax.hyperdata.ui_service.dto.FactTableInfo;




@com.tmax.proobject.core.DataObject
public class FactTableInfoList extends DataObject {
	private static final String DTO_LOGICAL_NAME = "FactTableInfoList";
	
	public String getDtoLogicalName() {
		return DTO_LOGICAL_NAME;
	}
	
	private static final long serialVersionUID= 1L;
	
	public FactTableInfoList() {
			super();
			
	}	 
	
	private boolean isModified = false;

	/**
	 * LogicalName : factTableInfoList
	 * Comments    : 
	 */
	private List<com.tmax.hyperdata.ui_service.dto.FactTableInfo> factTableInfoList = new ArrayList<com.tmax.hyperdata.ui_service.dto.FactTableInfo>(9999);
	
	public List<com.tmax.hyperdata.ui_service.dto.FactTableInfo> getFactTableInfoListList() {
		return factTableInfoList;
	}
	private boolean factTableInfoList_invalidation = false;
	
	public void setInvalidationFactTableInfoList(boolean invalidation) { 
		this.factTableInfoList_invalidation = invalidation;
	}
	
	public boolean isInvalidationFactTableInfoList() {
		return this.factTableInfoList_invalidation;
	}
	
	private boolean factTableInfoList_modified = false;
	
	public boolean isModifiedFactTableInfoList() {
		if(this.factTableInfoList_modified) return true;
		for(int index=0; index < this.sizeFactTableInfoList(); index++) {
			if(this.getFactTableInfoList(index).isModified()) return true;
		}
		return false;
	}
	
	public void unModifiedFactTableInfoList() {
		this.factTableInfoList_modified = false;
	}
	
	public void clearFactTableInfoList() {
		factTableInfoList.clear();
		this.factTableInfoList_modified = false;
	}
	
	public void ensureCapacityFactTableInfoList(int minCapacity) {
		((ArrayList<com.tmax.hyperdata.ui_service.dto.FactTableInfo>)factTableInfoList).ensureCapacity( minCapacity );	
	}	
	public void createFactTableInfoList(int _size) {
		((ArrayList<com.tmax.hyperdata.ui_service.dto.FactTableInfo>)factTableInfoList).ensureCapacity(_size);
		for(int i = factTableInfoList.size(); i < _size; i++) {
			factTableInfoList.add( new com.tmax.hyperdata.ui_service.dto.FactTableInfo());
			this.factTableInfoList_modified = true;
		}
	}
	public FactTableInfoList fillFactTableInfoList(int _index) {
		ensureCapacityFactTableInfoList(_index+1);
		for (int i = sizeFactTableInfoList(); i <  _index + 1; i++) {
			this.factTableInfoList.add(i, new com.tmax.hyperdata.ui_service.dto.FactTableInfo());
			this.factTableInfoList_modified = true;
		}
		return this;
	}
	
	public int sizeFactTableInfoList() {
		return factTableInfoList.size();
	}
	
	public com.tmax.hyperdata.ui_service.dto.FactTableInfo[] getFactTableInfoList() {	
		return (com.tmax.hyperdata.ui_service.dto.FactTableInfo[])factTableInfoList.toArray(new com.tmax.hyperdata.ui_service.dto.FactTableInfo[factTableInfoList.size()]);
		}
	public com.tmax.hyperdata.ui_service.dto.FactTableInfo getFactTableInfoList(int _index) {
		return (com.tmax.hyperdata.ui_service.dto.FactTableInfo)factTableInfoList.get(_index);
	}
	public void setFactTableInfoList(List<com.tmax.hyperdata.ui_service.dto.FactTableInfo> factTableInfoList) {
		this.factTableInfoList.clear();
		if(factTableInfoList == null) {
			return;
		} else {
			for(int i = 0, n=factTableInfoList.size(); i < n; i++) {
				if( factTableInfoList.get(i) == null ) {
					this.factTableInfoList.add( new com.tmax.hyperdata.ui_service.dto.FactTableInfo());					
				}
				else {
					this.factTableInfoList.add(factTableInfoList.get(i));
				}
			}
		}
		this.factTableInfoList_modified = true;
		this.isModified = true;
	}
	
	public void setFactTableInfoList(com.tmax.hyperdata.ui_service.dto.FactTableInfo[] factTableInfoList) {
		this.factTableInfoList.clear();
		if(factTableInfoList == null) {
			return;
		} else {
			((ArrayList<com.tmax.hyperdata.ui_service.dto.FactTableInfo>)this.factTableInfoList).ensureCapacity(factTableInfoList.length);
			for(int i = 0, n=factTableInfoList.length; i < n; i++) {
				if( factTableInfoList[i] == null ) {
					this.factTableInfoList.add( new com.tmax.hyperdata.ui_service.dto.FactTableInfo());					
				}
				else {
					this.factTableInfoList.add(factTableInfoList[i]);
				}
			}
		}
		this.factTableInfoList_modified = true;
		this.isModified = true;
	}
	public void setFactTableInfoList(int _index, com.tmax.hyperdata.ui_service.dto.FactTableInfo factTableInfoList) {
		if(factTableInfoList == null) {
			this.factTableInfoList.set(_index,  new com.tmax.hyperdata.ui_service.dto.FactTableInfo());
		} else {
			this.factTableInfoList.set(_index, factTableInfoList);
		}
		this.factTableInfoList_modified = true;
		this.isModified = true;
	}				
		
	public void addFactTableInfoList(int _index, com.tmax.hyperdata.ui_service.dto.FactTableInfo factTableInfoList) {
		if(factTableInfoList == null) {
			this.factTableInfoList.add(_index,  new com.tmax.hyperdata.ui_service.dto.FactTableInfo());
		} else {
			this.factTableInfoList.add(_index, factTableInfoList);
		}
		this.factTableInfoList_modified = true;
		this.isModified = true;
	}
	public void addFactTableInfoList(com.tmax.hyperdata.ui_service.dto.FactTableInfo factTableInfoList) {
		if(factTableInfoList == null) {
			this.factTableInfoList.add( new com.tmax.hyperdata.ui_service.dto.FactTableInfo());
		} else {
			this.factTableInfoList.add(factTableInfoList);
		}
		this.factTableInfoList_modified = true;
		this.isModified = true;
	}
	public com.tmax.hyperdata.ui_service.dto.FactTableInfo removeFactTableInfoList(int _index) {
		this.factTableInfoList_modified = true;
		this.isModified = true;
		return (com.tmax.hyperdata.ui_service.dto.FactTableInfo)this.factTableInfoList.remove(_index);
	}

	@Override
	public void clearAllIsModified() {
		this.factTableInfoList_modified = false;
		this.isModified = false;
	}
	
	@Override
	public List<String> getIsModifiedField() {
		List<String> modifiedFields = new ArrayList<>();
		if(this.factTableInfoList_modified == true)
			modifiedFields.add("factTableInfoList");
		return modifiedFields;
	}
	
	@Override
	public boolean isModified() {
	    return isModified;
	} 
	public Object clone() {
		FactTableInfoList copyObj = new FactTableInfoList();	
		copyObj.clone(this);
		return copyObj;
	}
	public void clone(DataObject _factTableInfoList) {
		if(this == _factTableInfoList) return;
		FactTableInfoList __factTableInfoList = (FactTableInfoList) _factTableInfoList;
		
		this.clearFactTableInfoList();
		for (int index = 0; index < __factTableInfoList.sizeFactTableInfoList(); index++) {
			this.addFactTableInfoList(index, (com.tmax.hyperdata.ui_service.dto.FactTableInfo)__factTableInfoList.getFactTableInfoList(index).clone());		
		}
		
	}

	public String toString() {
		StringBuilder buffer = new StringBuilder();
		
		buffer.append("factTableInfoList [");
		for (int index = 0; index < sizeFactTableInfoList(); index++) {
			buffer.append("(").append(index).append(") : ").append(getFactTableInfoList(index)).append(" ");
		}
		buffer.append("]");
		buffer.append("\n");
		return buffer.toString();
	}
	private static final Map<String,FieldProperty> fieldPropertyMap;
	
	static {
		fieldPropertyMap = new java.util.LinkedHashMap<String,FieldProperty>(1);
		fieldPropertyMap.put("factTableInfoList"
							, FieldPropertyFactory.getFieldProperty( "factTableInfoList","", "", "", false, false, false, FieldProperty.TYPE_ABSTRACT_INCLUDE, -1, -1, "9999" , "com.tmax.hyperdata.ui_service.dto.FactTableInfo"));		
	}

	public Map<String,FieldProperty> getFieldPropertyMap() {
		return fieldPropertyMap;
	}
	
	public static Map<String,FieldProperty> getFieldPropertyMapByStatic() {
		return fieldPropertyMap;
	}	

	public Object get(String fieldName) throws FieldNotFoundException {
		switch(fieldName) {
			case "factTableInfoList" : return getFactTableInfoListList();
			default : throw new FieldNotFoundException(fieldName);		
		}
	}




	public void set(String fieldName, Object arg) throws FieldNotFoundException {
		switch(fieldName) {
			case "factTableInfoList" : setFactTableInfoList((List<com.tmax.hyperdata.ui_service.dto.FactTableInfo>)arg);break;
			default : throw new FieldNotFoundException(fieldName);		
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if ((obj instanceof FactTableInfoList) == false) return false;
		FactTableInfoList _FactTableInfoList = (FactTableInfoList) obj;
		if(factTableInfoList.size() != _FactTableInfoList.sizeFactTableInfoList()) return false;
		else {
			for(int i = 0, n = factTableInfoList.size(); i < n; i++ ){ 
				if(!this.getFactTableInfoList(i).equals(_FactTableInfoList.getFactTableInfoList(i))) return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		int prime = 31;
		int result = 1;

		for(int i=0, n=this.factTableInfoList.size(); i<n; i++ ){ 
			result = prime * result + this.getFactTableInfoList(i).hashCode();
		}
		return result;
	}
	
	private void writeObject(java.io.ObjectOutputStream stream)throws IOException {
		stream.defaultWriteObject();
	}
	
	
}
