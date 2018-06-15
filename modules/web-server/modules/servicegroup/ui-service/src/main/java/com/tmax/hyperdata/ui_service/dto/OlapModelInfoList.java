	
package com.tmax.hyperdata.ui_service.dto;

import java.io.IOException;
import java.util.List;

import java.util.ArrayList;

import java.util.Map;

import com.tmax.promapper.engine.dto.record.common.FieldProperty;
import com.tmax.promapper.engine.dto.record.common.FieldPropertyFactory;
import com.tmax.proobject.model.exception.FieldNotFoundException;

import com.tmax.proobject.model.dataobject.DataObject;




import com.tmax.hyperdata.ui_service.dto.OlapModelInfo;




@com.tmax.proobject.core.DataObject
public class OlapModelInfoList extends DataObject {
	private static final String DTO_LOGICAL_NAME = "OlapModelInfoList";
	
	public String getDtoLogicalName() {
		return DTO_LOGICAL_NAME;
	}
	
	private static final long serialVersionUID= 1L;
	
	public OlapModelInfoList() {
			super();
			
	}	 
	
	private boolean isModified = false;

	/**
	 * LogicalName : olapModelInfoList
	 * Comments    : 
	 */
	private List<com.tmax.hyperdata.ui_service.dto.OlapModelInfo> olapModelInfoList = new ArrayList<com.tmax.hyperdata.ui_service.dto.OlapModelInfo>(9999);
	
	public List<com.tmax.hyperdata.ui_service.dto.OlapModelInfo> getOlapModelInfoListList() {
		return olapModelInfoList;
	}
	private boolean olapModelInfoList_invalidation = false;
	
	public void setInvalidationOlapModelInfoList(boolean invalidation) { 
		this.olapModelInfoList_invalidation = invalidation;
	}
	
	public boolean isInvalidationOlapModelInfoList() {
		return this.olapModelInfoList_invalidation;
	}
	
	private boolean olapModelInfoList_modified = false;
	
	public boolean isModifiedOlapModelInfoList() {
		if(this.olapModelInfoList_modified) return true;
		for(int index=0; index < this.sizeOlapModelInfoList(); index++) {
			if(this.getOlapModelInfoList(index).isModified()) return true;
		}
		return false;
	}
	
	public void unModifiedOlapModelInfoList() {
		this.olapModelInfoList_modified = false;
	}
	
	public void clearOlapModelInfoList() {
		olapModelInfoList.clear();
		this.olapModelInfoList_modified = false;
	}
	
	public void ensureCapacityOlapModelInfoList(int minCapacity) {
		((ArrayList<com.tmax.hyperdata.ui_service.dto.OlapModelInfo>)olapModelInfoList).ensureCapacity( minCapacity );	
	}	
	public void createOlapModelInfoList(int _size) {
		((ArrayList<com.tmax.hyperdata.ui_service.dto.OlapModelInfo>)olapModelInfoList).ensureCapacity(_size);
		for(int i = olapModelInfoList.size(); i < _size; i++) {
			olapModelInfoList.add( new com.tmax.hyperdata.ui_service.dto.OlapModelInfo());
			this.olapModelInfoList_modified = true;
		}
	}
	public OlapModelInfoList fillOlapModelInfoList(int _index) {
		ensureCapacityOlapModelInfoList(_index+1);
		for (int i = sizeOlapModelInfoList(); i <  _index + 1; i++) {
			this.olapModelInfoList.add(i, new com.tmax.hyperdata.ui_service.dto.OlapModelInfo());
			this.olapModelInfoList_modified = true;
		}
		return this;
	}
	
	public int sizeOlapModelInfoList() {
		return olapModelInfoList.size();
	}
	
	public com.tmax.hyperdata.ui_service.dto.OlapModelInfo[] getOlapModelInfoList() {	
		return (com.tmax.hyperdata.ui_service.dto.OlapModelInfo[])olapModelInfoList.toArray(new com.tmax.hyperdata.ui_service.dto.OlapModelInfo[olapModelInfoList.size()]);
		}
	public com.tmax.hyperdata.ui_service.dto.OlapModelInfo getOlapModelInfoList(int _index) {
		return (com.tmax.hyperdata.ui_service.dto.OlapModelInfo)olapModelInfoList.get(_index);
	}
	public void setOlapModelInfoList(List<com.tmax.hyperdata.ui_service.dto.OlapModelInfo> olapModelInfoList) {
		this.olapModelInfoList.clear();
		if(olapModelInfoList == null) {
			return;
		} else {
			for(int i = 0, n=olapModelInfoList.size(); i < n; i++) {
				if( olapModelInfoList.get(i) == null ) {
					this.olapModelInfoList.add( new com.tmax.hyperdata.ui_service.dto.OlapModelInfo());					
				}
				else {
					this.olapModelInfoList.add(olapModelInfoList.get(i));
				}
			}
		}
		this.olapModelInfoList_modified = true;
		this.isModified = true;
	}
	
	public void setOlapModelInfoList(com.tmax.hyperdata.ui_service.dto.OlapModelInfo[] olapModelInfoList) {
		this.olapModelInfoList.clear();
		if(olapModelInfoList == null) {
			return;
		} else {
			((ArrayList<com.tmax.hyperdata.ui_service.dto.OlapModelInfo>)this.olapModelInfoList).ensureCapacity(olapModelInfoList.length);
			for(int i = 0, n=olapModelInfoList.length; i < n; i++) {
				if( olapModelInfoList[i] == null ) {
					this.olapModelInfoList.add( new com.tmax.hyperdata.ui_service.dto.OlapModelInfo());					
				}
				else {
					this.olapModelInfoList.add(olapModelInfoList[i]);
				}
			}
		}
		this.olapModelInfoList_modified = true;
		this.isModified = true;
	}
	public void setOlapModelInfoList(int _index, com.tmax.hyperdata.ui_service.dto.OlapModelInfo olapModelInfoList) {
		if(olapModelInfoList == null) {
			this.olapModelInfoList.set(_index,  new com.tmax.hyperdata.ui_service.dto.OlapModelInfo());
		} else {
			this.olapModelInfoList.set(_index, olapModelInfoList);
		}
		this.olapModelInfoList_modified = true;
		this.isModified = true;
	}				
		
	public void addOlapModelInfoList(int _index, com.tmax.hyperdata.ui_service.dto.OlapModelInfo olapModelInfoList) {
		if(olapModelInfoList == null) {
			this.olapModelInfoList.add(_index,  new com.tmax.hyperdata.ui_service.dto.OlapModelInfo());
		} else {
			this.olapModelInfoList.add(_index, olapModelInfoList);
		}
		this.olapModelInfoList_modified = true;
		this.isModified = true;
	}
	public void addOlapModelInfoList(com.tmax.hyperdata.ui_service.dto.OlapModelInfo olapModelInfoList) {
		if(olapModelInfoList == null) {
			this.olapModelInfoList.add( new com.tmax.hyperdata.ui_service.dto.OlapModelInfo());
		} else {
			this.olapModelInfoList.add(olapModelInfoList);
		}
		this.olapModelInfoList_modified = true;
		this.isModified = true;
	}
	public com.tmax.hyperdata.ui_service.dto.OlapModelInfo removeOlapModelInfoList(int _index) {
		this.olapModelInfoList_modified = true;
		this.isModified = true;
		return (com.tmax.hyperdata.ui_service.dto.OlapModelInfo)this.olapModelInfoList.remove(_index);
	}

	@Override
	public void clearAllIsModified() {
		this.olapModelInfoList_modified = false;
		this.isModified = false;
	}
	
	@Override
	public List<String> getIsModifiedField() {
		List<String> modifiedFields = new ArrayList<>();
		if(this.olapModelInfoList_modified == true)
			modifiedFields.add("olapModelInfoList");
		return modifiedFields;
	}
	
	@Override
	public boolean isModified() {
	    return isModified;
	} 
	public Object clone() {
		OlapModelInfoList copyObj = new OlapModelInfoList();	
		copyObj.clone(this);
		return copyObj;
	}
	public void clone(DataObject _olapModelInfoList) {
		if(this == _olapModelInfoList) return;
		OlapModelInfoList __olapModelInfoList = (OlapModelInfoList) _olapModelInfoList;
		
		this.clearOlapModelInfoList();
		for (int index = 0; index < __olapModelInfoList.sizeOlapModelInfoList(); index++) {
			this.addOlapModelInfoList(index, (com.tmax.hyperdata.ui_service.dto.OlapModelInfo)__olapModelInfoList.getOlapModelInfoList(index).clone());		
		}
		
	}

	public String toString() {
		StringBuilder buffer = new StringBuilder();
		
		buffer.append("olapModelInfoList [");
		for (int index = 0; index < sizeOlapModelInfoList(); index++) {
			buffer.append("(").append(index).append(") : ").append(getOlapModelInfoList(index)).append(" ");
		}
		buffer.append("]");
		buffer.append("\n");
		return buffer.toString();
	}
	private static final Map<String,FieldProperty> fieldPropertyMap;
	
	static {
		fieldPropertyMap = new java.util.LinkedHashMap<String,FieldProperty>(1);
		fieldPropertyMap.put("olapModelInfoList"
							, FieldPropertyFactory.getFieldProperty( "olapModelInfoList","", "", "", false, false, false, FieldProperty.TYPE_ABSTRACT_INCLUDE, -1, -1, "9999" , "com.tmax.hyperdata.ui_service.dto.OlapModelInfo"));		
	}

	public Map<String,FieldProperty> getFieldPropertyMap() {
		return fieldPropertyMap;
	}
	
	public static Map<String,FieldProperty> getFieldPropertyMapByStatic() {
		return fieldPropertyMap;
	}	

	public Object get(String fieldName) throws FieldNotFoundException {
		switch(fieldName) {
			case "olapModelInfoList" : return getOlapModelInfoListList();
			default : throw new FieldNotFoundException(fieldName);		
		}
	}




	public void set(String fieldName, Object arg) throws FieldNotFoundException {
		switch(fieldName) {
			case "olapModelInfoList" : setOlapModelInfoList((List<com.tmax.hyperdata.ui_service.dto.OlapModelInfo>)arg);break;
			default : throw new FieldNotFoundException(fieldName);		
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if ((obj instanceof OlapModelInfoList) == false) return false;
		OlapModelInfoList _OlapModelInfoList = (OlapModelInfoList) obj;
		if(olapModelInfoList.size() != _OlapModelInfoList.sizeOlapModelInfoList()) return false;
		else {
			for(int i = 0, n = olapModelInfoList.size(); i < n; i++ ){ 
				if(!this.getOlapModelInfoList(i).equals(_OlapModelInfoList.getOlapModelInfoList(i))) return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		int prime = 31;
		int result = 1;

		for(int i=0, n=this.olapModelInfoList.size(); i<n; i++ ){ 
			result = prime * result + this.getOlapModelInfoList(i).hashCode();
		}
		return result;
	}
	
	private void writeObject(java.io.ObjectOutputStream stream)throws IOException {
		stream.defaultWriteObject();
	}
	
	
}
