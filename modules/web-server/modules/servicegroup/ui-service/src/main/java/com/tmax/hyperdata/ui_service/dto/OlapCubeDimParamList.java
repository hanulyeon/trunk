	
package com.tmax.hyperdata.ui_service.dto;

import java.io.IOException;
import java.util.List;

import java.util.ArrayList;

import java.util.Map;

import com.tmax.promapper.engine.dto.record.common.FieldProperty;
import com.tmax.promapper.engine.dto.record.common.FieldPropertyFactory;
import com.tmax.proobject.model.exception.FieldNotFoundException;

import com.tmax.proobject.model.dataobject.DataObject;




import com.tmax.hyperdata.ui_service.dto.OlapCubeDimParam;




@com.tmax.proobject.core.DataObject
public class OlapCubeDimParamList extends DataObject {
	private static final String DTO_LOGICAL_NAME = "OlapCubeDimParamList";
	
	public String getDtoLogicalName() {
		return DTO_LOGICAL_NAME;
	}
	
	private static final long serialVersionUID= 1L;
	
	public OlapCubeDimParamList() {
			super();
			
	}	 
	
	private boolean isModified = false;

	/**
	 * LogicalName : olapCubeDimParamList
	 * Comments    : 
	 */
	private List<com.tmax.hyperdata.ui_service.dto.OlapCubeDimParam> olapCubeDimParamList = new ArrayList<com.tmax.hyperdata.ui_service.dto.OlapCubeDimParam>(9999);
	
	public List<com.tmax.hyperdata.ui_service.dto.OlapCubeDimParam> getOlapCubeDimParamListList() {
		return olapCubeDimParamList;
	}
	private boolean olapCubeDimParamList_invalidation = false;
	
	public void setInvalidationOlapCubeDimParamList(boolean invalidation) { 
		this.olapCubeDimParamList_invalidation = invalidation;
	}
	
	public boolean isInvalidationOlapCubeDimParamList() {
		return this.olapCubeDimParamList_invalidation;
	}
	
	private boolean olapCubeDimParamList_modified = false;
	
	public boolean isModifiedOlapCubeDimParamList() {
		if(this.olapCubeDimParamList_modified) return true;
		for(int index=0; index < this.sizeOlapCubeDimParamList(); index++) {
			if(this.getOlapCubeDimParamList(index).isModified()) return true;
		}
		return false;
	}
	
	public void unModifiedOlapCubeDimParamList() {
		this.olapCubeDimParamList_modified = false;
	}
	
	public void clearOlapCubeDimParamList() {
		olapCubeDimParamList.clear();
		this.olapCubeDimParamList_modified = false;
	}
	
	public void ensureCapacityOlapCubeDimParamList(int minCapacity) {
		((ArrayList<com.tmax.hyperdata.ui_service.dto.OlapCubeDimParam>)olapCubeDimParamList).ensureCapacity( minCapacity );	
	}	
	public void createOlapCubeDimParamList(int _size) {
		((ArrayList<com.tmax.hyperdata.ui_service.dto.OlapCubeDimParam>)olapCubeDimParamList).ensureCapacity(_size);
		for(int i = olapCubeDimParamList.size(); i < _size; i++) {
			olapCubeDimParamList.add( new com.tmax.hyperdata.ui_service.dto.OlapCubeDimParam());
			this.olapCubeDimParamList_modified = true;
		}
	}
	public OlapCubeDimParamList fillOlapCubeDimParamList(int _index) {
		ensureCapacityOlapCubeDimParamList(_index+1);
		for (int i = sizeOlapCubeDimParamList(); i <  _index + 1; i++) {
			this.olapCubeDimParamList.add(i, new com.tmax.hyperdata.ui_service.dto.OlapCubeDimParam());
			this.olapCubeDimParamList_modified = true;
		}
		return this;
	}
	
	public int sizeOlapCubeDimParamList() {
		return olapCubeDimParamList.size();
	}
	
	public com.tmax.hyperdata.ui_service.dto.OlapCubeDimParam[] getOlapCubeDimParamList() {	
		return (com.tmax.hyperdata.ui_service.dto.OlapCubeDimParam[])olapCubeDimParamList.toArray(new com.tmax.hyperdata.ui_service.dto.OlapCubeDimParam[olapCubeDimParamList.size()]);
		}
	public com.tmax.hyperdata.ui_service.dto.OlapCubeDimParam getOlapCubeDimParamList(int _index) {
		return (com.tmax.hyperdata.ui_service.dto.OlapCubeDimParam)olapCubeDimParamList.get(_index);
	}
	public void setOlapCubeDimParamList(List<com.tmax.hyperdata.ui_service.dto.OlapCubeDimParam> olapCubeDimParamList) {
		this.olapCubeDimParamList.clear();
		if(olapCubeDimParamList == null) {
			return;
		} else {
			for(int i = 0, n=olapCubeDimParamList.size(); i < n; i++) {
				if( olapCubeDimParamList.get(i) == null ) {
					this.olapCubeDimParamList.add( new com.tmax.hyperdata.ui_service.dto.OlapCubeDimParam());					
				}
				else {
					this.olapCubeDimParamList.add(olapCubeDimParamList.get(i));
				}
			}
		}
		this.olapCubeDimParamList_modified = true;
		this.isModified = true;
	}
	
	public void setOlapCubeDimParamList(com.tmax.hyperdata.ui_service.dto.OlapCubeDimParam[] olapCubeDimParamList) {
		this.olapCubeDimParamList.clear();
		if(olapCubeDimParamList == null) {
			return;
		} else {
			((ArrayList<com.tmax.hyperdata.ui_service.dto.OlapCubeDimParam>)this.olapCubeDimParamList).ensureCapacity(olapCubeDimParamList.length);
			for(int i = 0, n=olapCubeDimParamList.length; i < n; i++) {
				if( olapCubeDimParamList[i] == null ) {
					this.olapCubeDimParamList.add( new com.tmax.hyperdata.ui_service.dto.OlapCubeDimParam());					
				}
				else {
					this.olapCubeDimParamList.add(olapCubeDimParamList[i]);
				}
			}
		}
		this.olapCubeDimParamList_modified = true;
		this.isModified = true;
	}
	public void setOlapCubeDimParamList(int _index, com.tmax.hyperdata.ui_service.dto.OlapCubeDimParam olapCubeDimParamList) {
		if(olapCubeDimParamList == null) {
			this.olapCubeDimParamList.set(_index,  new com.tmax.hyperdata.ui_service.dto.OlapCubeDimParam());
		} else {
			this.olapCubeDimParamList.set(_index, olapCubeDimParamList);
		}
		this.olapCubeDimParamList_modified = true;
		this.isModified = true;
	}				
		
	public void addOlapCubeDimParamList(int _index, com.tmax.hyperdata.ui_service.dto.OlapCubeDimParam olapCubeDimParamList) {
		if(olapCubeDimParamList == null) {
			this.olapCubeDimParamList.add(_index,  new com.tmax.hyperdata.ui_service.dto.OlapCubeDimParam());
		} else {
			this.olapCubeDimParamList.add(_index, olapCubeDimParamList);
		}
		this.olapCubeDimParamList_modified = true;
		this.isModified = true;
	}
	public void addOlapCubeDimParamList(com.tmax.hyperdata.ui_service.dto.OlapCubeDimParam olapCubeDimParamList) {
		if(olapCubeDimParamList == null) {
			this.olapCubeDimParamList.add( new com.tmax.hyperdata.ui_service.dto.OlapCubeDimParam());
		} else {
			this.olapCubeDimParamList.add(olapCubeDimParamList);
		}
		this.olapCubeDimParamList_modified = true;
		this.isModified = true;
	}
	public com.tmax.hyperdata.ui_service.dto.OlapCubeDimParam removeOlapCubeDimParamList(int _index) {
		this.olapCubeDimParamList_modified = true;
		this.isModified = true;
		return (com.tmax.hyperdata.ui_service.dto.OlapCubeDimParam)this.olapCubeDimParamList.remove(_index);
	}

	@Override
	public void clearAllIsModified() {
		this.olapCubeDimParamList_modified = false;
		this.isModified = false;
	}
	
	@Override
	public List<String> getIsModifiedField() {
		List<String> modifiedFields = new ArrayList<>();
		if(this.olapCubeDimParamList_modified == true)
			modifiedFields.add("olapCubeDimParamList");
		return modifiedFields;
	}
	
	@Override
	public boolean isModified() {
	    return isModified;
	} 
	public Object clone() {
		OlapCubeDimParamList copyObj = new OlapCubeDimParamList();	
		copyObj.clone(this);
		return copyObj;
	}
	public void clone(DataObject _olapCubeDimParamList) {
		if(this == _olapCubeDimParamList) return;
		OlapCubeDimParamList __olapCubeDimParamList = (OlapCubeDimParamList) _olapCubeDimParamList;
		
		this.clearOlapCubeDimParamList();
		for (int index = 0; index < __olapCubeDimParamList.sizeOlapCubeDimParamList(); index++) {
			this.addOlapCubeDimParamList(index, (com.tmax.hyperdata.ui_service.dto.OlapCubeDimParam)__olapCubeDimParamList.getOlapCubeDimParamList(index).clone());		
		}
		
	}

	public String toString() {
		StringBuilder buffer = new StringBuilder();
		
		buffer.append("olapCubeDimParamList [");
		for (int index = 0; index < sizeOlapCubeDimParamList(); index++) {
			buffer.append("(").append(index).append(") : ").append(getOlapCubeDimParamList(index)).append(" ");
		}
		buffer.append("]");
		buffer.append("\n");
		return buffer.toString();
	}
	private static final Map<String,FieldProperty> fieldPropertyMap;
	
	static {
		fieldPropertyMap = new java.util.LinkedHashMap<String,FieldProperty>(1);
		fieldPropertyMap.put("olapCubeDimParamList"
							, FieldPropertyFactory.getFieldProperty( "olapCubeDimParamList","", "", "", false, false, false, FieldProperty.TYPE_ABSTRACT_INCLUDE, -1, -1, "9999" , "com.tmax.hyperdata.ui_service.dto.OlapCubeDimParam"));		
	}

	public Map<String,FieldProperty> getFieldPropertyMap() {
		return fieldPropertyMap;
	}
	
	public static Map<String,FieldProperty> getFieldPropertyMapByStatic() {
		return fieldPropertyMap;
	}	

	public Object get(String fieldName) throws FieldNotFoundException {
		switch(fieldName) {
			case "olapCubeDimParamList" : return getOlapCubeDimParamListList();
			default : throw new FieldNotFoundException(fieldName);		
		}
	}




	public void set(String fieldName, Object arg) throws FieldNotFoundException {
		switch(fieldName) {
			case "olapCubeDimParamList" : setOlapCubeDimParamList((List<com.tmax.hyperdata.ui_service.dto.OlapCubeDimParam>)arg);break;
			default : throw new FieldNotFoundException(fieldName);		
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if ((obj instanceof OlapCubeDimParamList) == false) return false;
		OlapCubeDimParamList _OlapCubeDimParamList = (OlapCubeDimParamList) obj;
		if(olapCubeDimParamList.size() != _OlapCubeDimParamList.sizeOlapCubeDimParamList()) return false;
		else {
			for(int i = 0, n = olapCubeDimParamList.size(); i < n; i++ ){ 
				if(!this.getOlapCubeDimParamList(i).equals(_OlapCubeDimParamList.getOlapCubeDimParamList(i))) return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		int prime = 31;
		int result = 1;

		for(int i=0, n=this.olapCubeDimParamList.size(); i<n; i++ ){ 
			result = prime * result + this.getOlapCubeDimParamList(i).hashCode();
		}
		return result;
	}
	
	private void writeObject(java.io.ObjectOutputStream stream)throws IOException {
		stream.defaultWriteObject();
	}
	
	
}
