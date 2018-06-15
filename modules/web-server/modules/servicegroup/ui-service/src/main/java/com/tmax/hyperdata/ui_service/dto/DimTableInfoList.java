	
package com.tmax.hyperdata.ui_service.dto;

import java.io.IOException;
import java.util.List;

import java.util.ArrayList;

import java.util.Map;

import com.tmax.promapper.engine.dto.record.common.FieldProperty;
import com.tmax.promapper.engine.dto.record.common.FieldPropertyFactory;
import com.tmax.proobject.model.exception.FieldNotFoundException;

import com.tmax.proobject.model.dataobject.DataObject;




import com.tmax.hyperdata.ui_service.dto.DimTableInfo;




@com.tmax.proobject.core.DataObject
public class DimTableInfoList extends DataObject {
	private static final String DTO_LOGICAL_NAME = "DimTableInfoList";
	
	public String getDtoLogicalName() {
		return DTO_LOGICAL_NAME;
	}
	
	private static final long serialVersionUID= 1L;
	
	public DimTableInfoList() {
			super();
			
	}	 
	
	private boolean isModified = false;

	/**
	 * LogicalName : dimTableInfoList
	 * Comments    : 
	 */
	private List<com.tmax.hyperdata.ui_service.dto.DimTableInfo> dimTableInfoList = new ArrayList<com.tmax.hyperdata.ui_service.dto.DimTableInfo>(9999);
	
	public List<com.tmax.hyperdata.ui_service.dto.DimTableInfo> getDimTableInfoListList() {
		return dimTableInfoList;
	}
	private boolean dimTableInfoList_invalidation = false;
	
	public void setInvalidationDimTableInfoList(boolean invalidation) { 
		this.dimTableInfoList_invalidation = invalidation;
	}
	
	public boolean isInvalidationDimTableInfoList() {
		return this.dimTableInfoList_invalidation;
	}
	
	private boolean dimTableInfoList_modified = false;
	
	public boolean isModifiedDimTableInfoList() {
		if(this.dimTableInfoList_modified) return true;
		for(int index=0; index < this.sizeDimTableInfoList(); index++) {
			if(this.getDimTableInfoList(index).isModified()) return true;
		}
		return false;
	}
	
	public void unModifiedDimTableInfoList() {
		this.dimTableInfoList_modified = false;
	}
	
	public void clearDimTableInfoList() {
		dimTableInfoList.clear();
		this.dimTableInfoList_modified = false;
	}
	
	public void ensureCapacityDimTableInfoList(int minCapacity) {
		((ArrayList<com.tmax.hyperdata.ui_service.dto.DimTableInfo>)dimTableInfoList).ensureCapacity( minCapacity );	
	}	
	public void createDimTableInfoList(int _size) {
		((ArrayList<com.tmax.hyperdata.ui_service.dto.DimTableInfo>)dimTableInfoList).ensureCapacity(_size);
		for(int i = dimTableInfoList.size(); i < _size; i++) {
			dimTableInfoList.add( new com.tmax.hyperdata.ui_service.dto.DimTableInfo());
			this.dimTableInfoList_modified = true;
		}
	}
	public DimTableInfoList fillDimTableInfoList(int _index) {
		ensureCapacityDimTableInfoList(_index+1);
		for (int i = sizeDimTableInfoList(); i <  _index + 1; i++) {
			this.dimTableInfoList.add(i, new com.tmax.hyperdata.ui_service.dto.DimTableInfo());
			this.dimTableInfoList_modified = true;
		}
		return this;
	}
	
	public int sizeDimTableInfoList() {
		return dimTableInfoList.size();
	}
	
	public com.tmax.hyperdata.ui_service.dto.DimTableInfo[] getDimTableInfoList() {	
		return (com.tmax.hyperdata.ui_service.dto.DimTableInfo[])dimTableInfoList.toArray(new com.tmax.hyperdata.ui_service.dto.DimTableInfo[dimTableInfoList.size()]);
		}
	public com.tmax.hyperdata.ui_service.dto.DimTableInfo getDimTableInfoList(int _index) {
		return (com.tmax.hyperdata.ui_service.dto.DimTableInfo)dimTableInfoList.get(_index);
	}
	public void setDimTableInfoList(List<com.tmax.hyperdata.ui_service.dto.DimTableInfo> dimTableInfoList) {
		this.dimTableInfoList.clear();
		if(dimTableInfoList == null) {
			return;
		} else {
			for(int i = 0, n=dimTableInfoList.size(); i < n; i++) {
				if( dimTableInfoList.get(i) == null ) {
					this.dimTableInfoList.add( new com.tmax.hyperdata.ui_service.dto.DimTableInfo());					
				}
				else {
					this.dimTableInfoList.add(dimTableInfoList.get(i));
				}
			}
		}
		this.dimTableInfoList_modified = true;
		this.isModified = true;
	}
	
	public void setDimTableInfoList(com.tmax.hyperdata.ui_service.dto.DimTableInfo[] dimTableInfoList) {
		this.dimTableInfoList.clear();
		if(dimTableInfoList == null) {
			return;
		} else {
			((ArrayList<com.tmax.hyperdata.ui_service.dto.DimTableInfo>)this.dimTableInfoList).ensureCapacity(dimTableInfoList.length);
			for(int i = 0, n=dimTableInfoList.length; i < n; i++) {
				if( dimTableInfoList[i] == null ) {
					this.dimTableInfoList.add( new com.tmax.hyperdata.ui_service.dto.DimTableInfo());					
				}
				else {
					this.dimTableInfoList.add(dimTableInfoList[i]);
				}
			}
		}
		this.dimTableInfoList_modified = true;
		this.isModified = true;
	}
	public void setDimTableInfoList(int _index, com.tmax.hyperdata.ui_service.dto.DimTableInfo dimTableInfoList) {
		if(dimTableInfoList == null) {
			this.dimTableInfoList.set(_index,  new com.tmax.hyperdata.ui_service.dto.DimTableInfo());
		} else {
			this.dimTableInfoList.set(_index, dimTableInfoList);
		}
		this.dimTableInfoList_modified = true;
		this.isModified = true;
	}				
		
	public void addDimTableInfoList(int _index, com.tmax.hyperdata.ui_service.dto.DimTableInfo dimTableInfoList) {
		if(dimTableInfoList == null) {
			this.dimTableInfoList.add(_index,  new com.tmax.hyperdata.ui_service.dto.DimTableInfo());
		} else {
			this.dimTableInfoList.add(_index, dimTableInfoList);
		}
		this.dimTableInfoList_modified = true;
		this.isModified = true;
	}
	public void addDimTableInfoList(com.tmax.hyperdata.ui_service.dto.DimTableInfo dimTableInfoList) {
		if(dimTableInfoList == null) {
			this.dimTableInfoList.add( new com.tmax.hyperdata.ui_service.dto.DimTableInfo());
		} else {
			this.dimTableInfoList.add(dimTableInfoList);
		}
		this.dimTableInfoList_modified = true;
		this.isModified = true;
	}
	public com.tmax.hyperdata.ui_service.dto.DimTableInfo removeDimTableInfoList(int _index) {
		this.dimTableInfoList_modified = true;
		this.isModified = true;
		return (com.tmax.hyperdata.ui_service.dto.DimTableInfo)this.dimTableInfoList.remove(_index);
	}

	@Override
	public void clearAllIsModified() {
		this.dimTableInfoList_modified = false;
		this.isModified = false;
	}
	
	@Override
	public List<String> getIsModifiedField() {
		List<String> modifiedFields = new ArrayList<>();
		if(this.dimTableInfoList_modified == true)
			modifiedFields.add("dimTableInfoList");
		return modifiedFields;
	}
	
	@Override
	public boolean isModified() {
	    return isModified;
	} 
	public Object clone() {
		DimTableInfoList copyObj = new DimTableInfoList();	
		copyObj.clone(this);
		return copyObj;
	}
	public void clone(DataObject _dimTableInfoList) {
		if(this == _dimTableInfoList) return;
		DimTableInfoList __dimTableInfoList = (DimTableInfoList) _dimTableInfoList;
		
		this.clearDimTableInfoList();
		for (int index = 0; index < __dimTableInfoList.sizeDimTableInfoList(); index++) {
			this.addDimTableInfoList(index, (com.tmax.hyperdata.ui_service.dto.DimTableInfo)__dimTableInfoList.getDimTableInfoList(index).clone());		
		}
		
	}

	public String toString() {
		StringBuilder buffer = new StringBuilder();
		
		buffer.append("dimTableInfoList [");
		for (int index = 0; index < sizeDimTableInfoList(); index++) {
			buffer.append("(").append(index).append(") : ").append(getDimTableInfoList(index)).append(" ");
		}
		buffer.append("]");
		buffer.append("\n");
		return buffer.toString();
	}
	private static final Map<String,FieldProperty> fieldPropertyMap;
	
	static {
		fieldPropertyMap = new java.util.LinkedHashMap<String,FieldProperty>(1);
		fieldPropertyMap.put("dimTableInfoList"
							, FieldPropertyFactory.getFieldProperty( "dimTableInfoList","", "", "", false, false, false, FieldProperty.TYPE_ABSTRACT_INCLUDE, -1, -1, "9999" , "com.tmax.hyperdata.ui_service.dto.DimTableInfo"));		
	}

	public Map<String,FieldProperty> getFieldPropertyMap() {
		return fieldPropertyMap;
	}
	
	public static Map<String,FieldProperty> getFieldPropertyMapByStatic() {
		return fieldPropertyMap;
	}	

	public Object get(String fieldName) throws FieldNotFoundException {
		switch(fieldName) {
			case "dimTableInfoList" : return getDimTableInfoListList();
			default : throw new FieldNotFoundException(fieldName);		
		}
	}




	public void set(String fieldName, Object arg) throws FieldNotFoundException {
		switch(fieldName) {
			case "dimTableInfoList" : setDimTableInfoList((List<com.tmax.hyperdata.ui_service.dto.DimTableInfo>)arg);break;
			default : throw new FieldNotFoundException(fieldName);		
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if ((obj instanceof DimTableInfoList) == false) return false;
		DimTableInfoList _DimTableInfoList = (DimTableInfoList) obj;
		if(dimTableInfoList.size() != _DimTableInfoList.sizeDimTableInfoList()) return false;
		else {
			for(int i = 0, n = dimTableInfoList.size(); i < n; i++ ){ 
				if(!this.getDimTableInfoList(i).equals(_DimTableInfoList.getDimTableInfoList(i))) return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		int prime = 31;
		int result = 1;

		for(int i=0, n=this.dimTableInfoList.size(); i<n; i++ ){ 
			result = prime * result + this.getDimTableInfoList(i).hashCode();
		}
		return result;
	}
	
	private void writeObject(java.io.ObjectOutputStream stream)throws IOException {
		stream.defaultWriteObject();
	}
	
	
}
