	
package com.tmax.hyperdata.ui_service.dto;

import java.io.IOException;
import java.util.List;

import java.util.ArrayList;

import java.util.Map;

import com.tmax.promapper.engine.dto.record.common.FieldProperty;
import com.tmax.promapper.engine.dto.record.common.FieldPropertyFactory;
import com.tmax.proobject.model.exception.FieldNotFoundException;

import com.tmax.proobject.model.dataobject.DataObject;




import com.tmax.hyperdata.ui_service.dto.OlapProjectInfo;




@com.tmax.proobject.core.DataObject
public class OlapProjectInfoList extends DataObject {
	private static final String DTO_LOGICAL_NAME = "OlapProjectInfoList";
	
	public String getDtoLogicalName() {
		return DTO_LOGICAL_NAME;
	}
	
	private static final long serialVersionUID= 1L;
	
	public OlapProjectInfoList() {
			super();
			
	}	 
	
	private boolean isModified = false;

	/**
	 * LogicalName : olapProjectInfoList
	 * Comments    : 
	 */
	private List<com.tmax.hyperdata.ui_service.dto.OlapProjectInfo> olapProjectInfoList = new ArrayList<com.tmax.hyperdata.ui_service.dto.OlapProjectInfo>(9999);
	
	public List<com.tmax.hyperdata.ui_service.dto.OlapProjectInfo> getOlapProjectInfoListList() {
		return olapProjectInfoList;
	}
	private boolean olapProjectInfoList_invalidation = false;
	
	public void setInvalidationOlapProjectInfoList(boolean invalidation) { 
		this.olapProjectInfoList_invalidation = invalidation;
	}
	
	public boolean isInvalidationOlapProjectInfoList() {
		return this.olapProjectInfoList_invalidation;
	}
	
	private boolean olapProjectInfoList_modified = false;
	
	public boolean isModifiedOlapProjectInfoList() {
		if(this.olapProjectInfoList_modified) return true;
		for(int index=0; index < this.sizeOlapProjectInfoList(); index++) {
			if(this.getOlapProjectInfoList(index).isModified()) return true;
		}
		return false;
	}
	
	public void unModifiedOlapProjectInfoList() {
		this.olapProjectInfoList_modified = false;
	}
	
	public void clearOlapProjectInfoList() {
		olapProjectInfoList.clear();
		this.olapProjectInfoList_modified = false;
	}
	
	public void ensureCapacityOlapProjectInfoList(int minCapacity) {
		((ArrayList<com.tmax.hyperdata.ui_service.dto.OlapProjectInfo>)olapProjectInfoList).ensureCapacity( minCapacity );	
	}	
	public void createOlapProjectInfoList(int _size) {
		((ArrayList<com.tmax.hyperdata.ui_service.dto.OlapProjectInfo>)olapProjectInfoList).ensureCapacity(_size);
		for(int i = olapProjectInfoList.size(); i < _size; i++) {
			olapProjectInfoList.add( new com.tmax.hyperdata.ui_service.dto.OlapProjectInfo());
			this.olapProjectInfoList_modified = true;
		}
	}
	public OlapProjectInfoList fillOlapProjectInfoList(int _index) {
		ensureCapacityOlapProjectInfoList(_index+1);
		for (int i = sizeOlapProjectInfoList(); i <  _index + 1; i++) {
			this.olapProjectInfoList.add(i, new com.tmax.hyperdata.ui_service.dto.OlapProjectInfo());
			this.olapProjectInfoList_modified = true;
		}
		return this;
	}
	
	public int sizeOlapProjectInfoList() {
		return olapProjectInfoList.size();
	}
	
	public com.tmax.hyperdata.ui_service.dto.OlapProjectInfo[] getOlapProjectInfoList() {	
		return (com.tmax.hyperdata.ui_service.dto.OlapProjectInfo[])olapProjectInfoList.toArray(new com.tmax.hyperdata.ui_service.dto.OlapProjectInfo[olapProjectInfoList.size()]);
		}
	public com.tmax.hyperdata.ui_service.dto.OlapProjectInfo getOlapProjectInfoList(int _index) {
		return (com.tmax.hyperdata.ui_service.dto.OlapProjectInfo)olapProjectInfoList.get(_index);
	}
	public void setOlapProjectInfoList(List<com.tmax.hyperdata.ui_service.dto.OlapProjectInfo> olapProjectInfoList) {
		this.olapProjectInfoList.clear();
		if(olapProjectInfoList == null) {
			return;
		} else {
			for(int i = 0, n=olapProjectInfoList.size(); i < n; i++) {
				if( olapProjectInfoList.get(i) == null ) {
					this.olapProjectInfoList.add( new com.tmax.hyperdata.ui_service.dto.OlapProjectInfo());					
				}
				else {
					this.olapProjectInfoList.add(olapProjectInfoList.get(i));
				}
			}
		}
		this.olapProjectInfoList_modified = true;
		this.isModified = true;
	}
	
	public void setOlapProjectInfoList(com.tmax.hyperdata.ui_service.dto.OlapProjectInfo[] olapProjectInfoList) {
		this.olapProjectInfoList.clear();
		if(olapProjectInfoList == null) {
			return;
		} else {
			((ArrayList<com.tmax.hyperdata.ui_service.dto.OlapProjectInfo>)this.olapProjectInfoList).ensureCapacity(olapProjectInfoList.length);
			for(int i = 0, n=olapProjectInfoList.length; i < n; i++) {
				if( olapProjectInfoList[i] == null ) {
					this.olapProjectInfoList.add( new com.tmax.hyperdata.ui_service.dto.OlapProjectInfo());					
				}
				else {
					this.olapProjectInfoList.add(olapProjectInfoList[i]);
				}
			}
		}
		this.olapProjectInfoList_modified = true;
		this.isModified = true;
	}
	public void setOlapProjectInfoList(int _index, com.tmax.hyperdata.ui_service.dto.OlapProjectInfo olapProjectInfoList) {
		if(olapProjectInfoList == null) {
			this.olapProjectInfoList.set(_index,  new com.tmax.hyperdata.ui_service.dto.OlapProjectInfo());
		} else {
			this.olapProjectInfoList.set(_index, olapProjectInfoList);
		}
		this.olapProjectInfoList_modified = true;
		this.isModified = true;
	}				
		
	public void addOlapProjectInfoList(int _index, com.tmax.hyperdata.ui_service.dto.OlapProjectInfo olapProjectInfoList) {
		if(olapProjectInfoList == null) {
			this.olapProjectInfoList.add(_index,  new com.tmax.hyperdata.ui_service.dto.OlapProjectInfo());
		} else {
			this.olapProjectInfoList.add(_index, olapProjectInfoList);
		}
		this.olapProjectInfoList_modified = true;
		this.isModified = true;
	}
	public void addOlapProjectInfoList(com.tmax.hyperdata.ui_service.dto.OlapProjectInfo olapProjectInfoList) {
		if(olapProjectInfoList == null) {
			this.olapProjectInfoList.add( new com.tmax.hyperdata.ui_service.dto.OlapProjectInfo());
		} else {
			this.olapProjectInfoList.add(olapProjectInfoList);
		}
		this.olapProjectInfoList_modified = true;
		this.isModified = true;
	}
	public com.tmax.hyperdata.ui_service.dto.OlapProjectInfo removeOlapProjectInfoList(int _index) {
		this.olapProjectInfoList_modified = true;
		this.isModified = true;
		return (com.tmax.hyperdata.ui_service.dto.OlapProjectInfo)this.olapProjectInfoList.remove(_index);
	}

	@Override
	public void clearAllIsModified() {
		this.olapProjectInfoList_modified = false;
		this.isModified = false;
	}
	
	@Override
	public List<String> getIsModifiedField() {
		List<String> modifiedFields = new ArrayList<>();
		if(this.olapProjectInfoList_modified == true)
			modifiedFields.add("olapProjectInfoList");
		return modifiedFields;
	}
	
	@Override
	public boolean isModified() {
	    return isModified;
	} 
	public Object clone() {
		OlapProjectInfoList copyObj = new OlapProjectInfoList();	
		copyObj.clone(this);
		return copyObj;
	}
	public void clone(DataObject _olapProjectInfoList) {
		if(this == _olapProjectInfoList) return;
		OlapProjectInfoList __olapProjectInfoList = (OlapProjectInfoList) _olapProjectInfoList;
		
		this.clearOlapProjectInfoList();
		for (int index = 0; index < __olapProjectInfoList.sizeOlapProjectInfoList(); index++) {
			this.addOlapProjectInfoList(index, (com.tmax.hyperdata.ui_service.dto.OlapProjectInfo)__olapProjectInfoList.getOlapProjectInfoList(index).clone());		
		}
		
	}

	public String toString() {
		StringBuilder buffer = new StringBuilder();
		
		buffer.append("olapProjectInfoList [");
		for (int index = 0; index < sizeOlapProjectInfoList(); index++) {
			buffer.append("(").append(index).append(") : ").append(getOlapProjectInfoList(index)).append(" ");
		}
		buffer.append("]");
		buffer.append("\n");
		return buffer.toString();
	}
	private static final Map<String,FieldProperty> fieldPropertyMap;
	
	static {
		fieldPropertyMap = new java.util.LinkedHashMap<String,FieldProperty>(1);
		fieldPropertyMap.put("olapProjectInfoList"
							, FieldPropertyFactory.getFieldProperty( "olapProjectInfoList","", "", "", false, false, false, FieldProperty.TYPE_ABSTRACT_INCLUDE, -1, -1, "9999" , "com.tmax.hyperdata.ui_service.dto.OlapProjectInfo"));		
	}

	public Map<String,FieldProperty> getFieldPropertyMap() {
		return fieldPropertyMap;
	}
	
	public static Map<String,FieldProperty> getFieldPropertyMapByStatic() {
		return fieldPropertyMap;
	}	

	public Object get(String fieldName) throws FieldNotFoundException {
		switch(fieldName) {
			case "olapProjectInfoList" : return getOlapProjectInfoListList();
			default : throw new FieldNotFoundException(fieldName);		
		}
	}




	public void set(String fieldName, Object arg) throws FieldNotFoundException {
		switch(fieldName) {
			case "olapProjectInfoList" : setOlapProjectInfoList((List<com.tmax.hyperdata.ui_service.dto.OlapProjectInfo>)arg);break;
			default : throw new FieldNotFoundException(fieldName);		
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if ((obj instanceof OlapProjectInfoList) == false) return false;
		OlapProjectInfoList _OlapProjectInfoList = (OlapProjectInfoList) obj;
		if(olapProjectInfoList.size() != _OlapProjectInfoList.sizeOlapProjectInfoList()) return false;
		else {
			for(int i = 0, n = olapProjectInfoList.size(); i < n; i++ ){ 
				if(!this.getOlapProjectInfoList(i).equals(_OlapProjectInfoList.getOlapProjectInfoList(i))) return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		int prime = 31;
		int result = 1;

		for(int i=0, n=this.olapProjectInfoList.size(); i<n; i++ ){ 
			result = prime * result + this.getOlapProjectInfoList(i).hashCode();
		}
		return result;
	}
	
	private void writeObject(java.io.ObjectOutputStream stream)throws IOException {
		stream.defaultWriteObject();
	}
	
	
}
