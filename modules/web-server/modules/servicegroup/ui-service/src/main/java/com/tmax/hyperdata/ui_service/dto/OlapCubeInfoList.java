	
package com.tmax.hyperdata.ui_service.dto;

import java.io.IOException;
import java.util.List;

import java.util.ArrayList;

import java.util.Map;

import com.tmax.promapper.engine.dto.record.common.FieldProperty;
import com.tmax.promapper.engine.dto.record.common.FieldPropertyFactory;
import com.tmax.proobject.model.exception.FieldNotFoundException;

import com.tmax.proobject.model.dataobject.DataObject;




import com.tmax.hyperdata.ui_service.dto.OlapCubeInfo;




@com.tmax.proobject.core.DataObject
public class OlapCubeInfoList extends DataObject {
	private static final String DTO_LOGICAL_NAME = "OlapCubeInfoList";
	
	public String getDtoLogicalName() {
		return DTO_LOGICAL_NAME;
	}
	
	private static final long serialVersionUID= 1L;
	
	public OlapCubeInfoList() {
			super();
			
	}	 
	
	private boolean isModified = false;

	/**
	 * LogicalName : olapCubeInfoList
	 * Comments    : 
	 */
	private List<com.tmax.hyperdata.ui_service.dto.OlapCubeInfo> olapCubeInfoList = new ArrayList<com.tmax.hyperdata.ui_service.dto.OlapCubeInfo>(9999);
	
	public List<com.tmax.hyperdata.ui_service.dto.OlapCubeInfo> getOlapCubeInfoListList() {
		return olapCubeInfoList;
	}
	private boolean olapCubeInfoList_invalidation = false;
	
	public void setInvalidationOlapCubeInfoList(boolean invalidation) { 
		this.olapCubeInfoList_invalidation = invalidation;
	}
	
	public boolean isInvalidationOlapCubeInfoList() {
		return this.olapCubeInfoList_invalidation;
	}
	
	private boolean olapCubeInfoList_modified = false;
	
	public boolean isModifiedOlapCubeInfoList() {
		if(this.olapCubeInfoList_modified) return true;
		for(int index=0; index < this.sizeOlapCubeInfoList(); index++) {
			if(this.getOlapCubeInfoList(index).isModified()) return true;
		}
		return false;
	}
	
	public void unModifiedOlapCubeInfoList() {
		this.olapCubeInfoList_modified = false;
	}
	
	public void clearOlapCubeInfoList() {
		olapCubeInfoList.clear();
		this.olapCubeInfoList_modified = false;
	}
	
	public void ensureCapacityOlapCubeInfoList(int minCapacity) {
		((ArrayList<com.tmax.hyperdata.ui_service.dto.OlapCubeInfo>)olapCubeInfoList).ensureCapacity( minCapacity );	
	}	
	public void createOlapCubeInfoList(int _size) {
		((ArrayList<com.tmax.hyperdata.ui_service.dto.OlapCubeInfo>)olapCubeInfoList).ensureCapacity(_size);
		for(int i = olapCubeInfoList.size(); i < _size; i++) {
			olapCubeInfoList.add( new com.tmax.hyperdata.ui_service.dto.OlapCubeInfo());
			this.olapCubeInfoList_modified = true;
		}
	}
	public OlapCubeInfoList fillOlapCubeInfoList(int _index) {
		ensureCapacityOlapCubeInfoList(_index+1);
		for (int i = sizeOlapCubeInfoList(); i <  _index + 1; i++) {
			this.olapCubeInfoList.add(i, new com.tmax.hyperdata.ui_service.dto.OlapCubeInfo());
			this.olapCubeInfoList_modified = true;
		}
		return this;
	}
	
	public int sizeOlapCubeInfoList() {
		return olapCubeInfoList.size();
	}
	
	public com.tmax.hyperdata.ui_service.dto.OlapCubeInfo[] getOlapCubeInfoList() {	
		return (com.tmax.hyperdata.ui_service.dto.OlapCubeInfo[])olapCubeInfoList.toArray(new com.tmax.hyperdata.ui_service.dto.OlapCubeInfo[olapCubeInfoList.size()]);
		}
	public com.tmax.hyperdata.ui_service.dto.OlapCubeInfo getOlapCubeInfoList(int _index) {
		return (com.tmax.hyperdata.ui_service.dto.OlapCubeInfo)olapCubeInfoList.get(_index);
	}
	public void setOlapCubeInfoList(List<com.tmax.hyperdata.ui_service.dto.OlapCubeInfo> olapCubeInfoList) {
		this.olapCubeInfoList.clear();
		if(olapCubeInfoList == null) {
			return;
		} else {
			for(int i = 0, n=olapCubeInfoList.size(); i < n; i++) {
				if( olapCubeInfoList.get(i) == null ) {
					this.olapCubeInfoList.add( new com.tmax.hyperdata.ui_service.dto.OlapCubeInfo());					
				}
				else {
					this.olapCubeInfoList.add(olapCubeInfoList.get(i));
				}
			}
		}
		this.olapCubeInfoList_modified = true;
		this.isModified = true;
	}
	
	public void setOlapCubeInfoList(com.tmax.hyperdata.ui_service.dto.OlapCubeInfo[] olapCubeInfoList) {
		this.olapCubeInfoList.clear();
		if(olapCubeInfoList == null) {
			return;
		} else {
			((ArrayList<com.tmax.hyperdata.ui_service.dto.OlapCubeInfo>)this.olapCubeInfoList).ensureCapacity(olapCubeInfoList.length);
			for(int i = 0, n=olapCubeInfoList.length; i < n; i++) {
				if( olapCubeInfoList[i] == null ) {
					this.olapCubeInfoList.add( new com.tmax.hyperdata.ui_service.dto.OlapCubeInfo());					
				}
				else {
					this.olapCubeInfoList.add(olapCubeInfoList[i]);
				}
			}
		}
		this.olapCubeInfoList_modified = true;
		this.isModified = true;
	}
	public void setOlapCubeInfoList(int _index, com.tmax.hyperdata.ui_service.dto.OlapCubeInfo olapCubeInfoList) {
		if(olapCubeInfoList == null) {
			this.olapCubeInfoList.set(_index,  new com.tmax.hyperdata.ui_service.dto.OlapCubeInfo());
		} else {
			this.olapCubeInfoList.set(_index, olapCubeInfoList);
		}
		this.olapCubeInfoList_modified = true;
		this.isModified = true;
	}				
		
	public void addOlapCubeInfoList(int _index, com.tmax.hyperdata.ui_service.dto.OlapCubeInfo olapCubeInfoList) {
		if(olapCubeInfoList == null) {
			this.olapCubeInfoList.add(_index,  new com.tmax.hyperdata.ui_service.dto.OlapCubeInfo());
		} else {
			this.olapCubeInfoList.add(_index, olapCubeInfoList);
		}
		this.olapCubeInfoList_modified = true;
		this.isModified = true;
	}
	public void addOlapCubeInfoList(com.tmax.hyperdata.ui_service.dto.OlapCubeInfo olapCubeInfoList) {
		if(olapCubeInfoList == null) {
			this.olapCubeInfoList.add( new com.tmax.hyperdata.ui_service.dto.OlapCubeInfo());
		} else {
			this.olapCubeInfoList.add(olapCubeInfoList);
		}
		this.olapCubeInfoList_modified = true;
		this.isModified = true;
	}
	public com.tmax.hyperdata.ui_service.dto.OlapCubeInfo removeOlapCubeInfoList(int _index) {
		this.olapCubeInfoList_modified = true;
		this.isModified = true;
		return (com.tmax.hyperdata.ui_service.dto.OlapCubeInfo)this.olapCubeInfoList.remove(_index);
	}

	@Override
	public void clearAllIsModified() {
		this.olapCubeInfoList_modified = false;
		this.isModified = false;
	}
	
	@Override
	public List<String> getIsModifiedField() {
		List<String> modifiedFields = new ArrayList<>();
		if(this.olapCubeInfoList_modified == true)
			modifiedFields.add("olapCubeInfoList");
		return modifiedFields;
	}
	
	@Override
	public boolean isModified() {
	    return isModified;
	} 
	public Object clone() {
		OlapCubeInfoList copyObj = new OlapCubeInfoList();	
		copyObj.clone(this);
		return copyObj;
	}
	public void clone(DataObject _olapCubeInfoList) {
		if(this == _olapCubeInfoList) return;
		OlapCubeInfoList __olapCubeInfoList = (OlapCubeInfoList) _olapCubeInfoList;
		
		this.clearOlapCubeInfoList();
		for (int index = 0; index < __olapCubeInfoList.sizeOlapCubeInfoList(); index++) {
			this.addOlapCubeInfoList(index, (com.tmax.hyperdata.ui_service.dto.OlapCubeInfo)__olapCubeInfoList.getOlapCubeInfoList(index).clone());		
		}
		
	}

	public String toString() {
		StringBuilder buffer = new StringBuilder();
		
		buffer.append("olapCubeInfoList [");
		for (int index = 0; index < sizeOlapCubeInfoList(); index++) {
			buffer.append("(").append(index).append(") : ").append(getOlapCubeInfoList(index)).append(" ");
		}
		buffer.append("]");
		buffer.append("\n");
		return buffer.toString();
	}
	private static final Map<String,FieldProperty> fieldPropertyMap;
	
	static {
		fieldPropertyMap = new java.util.LinkedHashMap<String,FieldProperty>(1);
		fieldPropertyMap.put("olapCubeInfoList"
							, FieldPropertyFactory.getFieldProperty( "olapCubeInfoList","", "", "", false, false, false, FieldProperty.TYPE_ABSTRACT_INCLUDE, -1, -1, "9999" , "com.tmax.hyperdata.ui_service.dto.OlapCubeInfo"));		
	}

	public Map<String,FieldProperty> getFieldPropertyMap() {
		return fieldPropertyMap;
	}
	
	public static Map<String,FieldProperty> getFieldPropertyMapByStatic() {
		return fieldPropertyMap;
	}	

	public Object get(String fieldName) throws FieldNotFoundException {
		switch(fieldName) {
			case "olapCubeInfoList" : return getOlapCubeInfoListList();
			default : throw new FieldNotFoundException(fieldName);		
		}
	}




	public void set(String fieldName, Object arg) throws FieldNotFoundException {
		switch(fieldName) {
			case "olapCubeInfoList" : setOlapCubeInfoList((List<com.tmax.hyperdata.ui_service.dto.OlapCubeInfo>)arg);break;
			default : throw new FieldNotFoundException(fieldName);		
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if ((obj instanceof OlapCubeInfoList) == false) return false;
		OlapCubeInfoList _OlapCubeInfoList = (OlapCubeInfoList) obj;
		if(olapCubeInfoList.size() != _OlapCubeInfoList.sizeOlapCubeInfoList()) return false;
		else {
			for(int i = 0, n = olapCubeInfoList.size(); i < n; i++ ){ 
				if(!this.getOlapCubeInfoList(i).equals(_OlapCubeInfoList.getOlapCubeInfoList(i))) return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		int prime = 31;
		int result = 1;

		for(int i=0, n=this.olapCubeInfoList.size(); i<n; i++ ){ 
			result = prime * result + this.getOlapCubeInfoList(i).hashCode();
		}
		return result;
	}
	
	private void writeObject(java.io.ObjectOutputStream stream)throws IOException {
		stream.defaultWriteObject();
	}
	
	
}
