	
package com.tmax.hyperdata.ui_service.dto;

import java.io.IOException;
import java.util.List;

import java.util.ArrayList;

import java.util.Map;

import com.tmax.promapper.engine.dto.record.common.FieldProperty;
import com.tmax.promapper.engine.dto.record.common.FieldPropertyFactory;
import com.tmax.proobject.model.exception.FieldNotFoundException;

import com.tmax.proobject.model.dataobject.DataObject;




import com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParam;




@com.tmax.proobject.core.DataObject
public class OlapCubeMeasureParamList extends DataObject {
	private static final String DTO_LOGICAL_NAME = "OlapCubeMeasureParamList";
	
	public String getDtoLogicalName() {
		return DTO_LOGICAL_NAME;
	}
	
	private static final long serialVersionUID= 1L;
	
	public OlapCubeMeasureParamList() {
			super();
			
	}	 
	
	private boolean isModified = false;

	/**
	 * LogicalName : olapCubeMeasureParamList
	 * Comments    : 
	 */
	private List<com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParam> olapCubeMeasureParamList = new ArrayList<com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParam>(9999);
	
	public List<com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParam> getOlapCubeMeasureParamListList() {
		return olapCubeMeasureParamList;
	}
	private boolean olapCubeMeasureParamList_invalidation = false;
	
	public void setInvalidationOlapCubeMeasureParamList(boolean invalidation) { 
		this.olapCubeMeasureParamList_invalidation = invalidation;
	}
	
	public boolean isInvalidationOlapCubeMeasureParamList() {
		return this.olapCubeMeasureParamList_invalidation;
	}
	
	private boolean olapCubeMeasureParamList_modified = false;
	
	public boolean isModifiedOlapCubeMeasureParamList() {
		if(this.olapCubeMeasureParamList_modified) return true;
		for(int index=0; index < this.sizeOlapCubeMeasureParamList(); index++) {
			if(this.getOlapCubeMeasureParamList(index).isModified()) return true;
		}
		return false;
	}
	
	public void unModifiedOlapCubeMeasureParamList() {
		this.olapCubeMeasureParamList_modified = false;
	}
	
	public void clearOlapCubeMeasureParamList() {
		olapCubeMeasureParamList.clear();
		this.olapCubeMeasureParamList_modified = false;
	}
	
	public void ensureCapacityOlapCubeMeasureParamList(int minCapacity) {
		((ArrayList<com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParam>)olapCubeMeasureParamList).ensureCapacity( minCapacity );	
	}	
	public void createOlapCubeMeasureParamList(int _size) {
		((ArrayList<com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParam>)olapCubeMeasureParamList).ensureCapacity(_size);
		for(int i = olapCubeMeasureParamList.size(); i < _size; i++) {
			olapCubeMeasureParamList.add( new com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParam());
			this.olapCubeMeasureParamList_modified = true;
		}
	}
	public OlapCubeMeasureParamList fillOlapCubeMeasureParamList(int _index) {
		ensureCapacityOlapCubeMeasureParamList(_index+1);
		for (int i = sizeOlapCubeMeasureParamList(); i <  _index + 1; i++) {
			this.olapCubeMeasureParamList.add(i, new com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParam());
			this.olapCubeMeasureParamList_modified = true;
		}
		return this;
	}
	
	public int sizeOlapCubeMeasureParamList() {
		return olapCubeMeasureParamList.size();
	}
	
	public com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParam[] getOlapCubeMeasureParamList() {	
		return (com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParam[])olapCubeMeasureParamList.toArray(new com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParam[olapCubeMeasureParamList.size()]);
		}
	public com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParam getOlapCubeMeasureParamList(int _index) {
		return (com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParam)olapCubeMeasureParamList.get(_index);
	}
	public void setOlapCubeMeasureParamList(List<com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParam> olapCubeMeasureParamList) {
		this.olapCubeMeasureParamList.clear();
		if(olapCubeMeasureParamList == null) {
			return;
		} else {
			for(int i = 0, n=olapCubeMeasureParamList.size(); i < n; i++) {
				if( olapCubeMeasureParamList.get(i) == null ) {
					this.olapCubeMeasureParamList.add( new com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParam());					
				}
				else {
					this.olapCubeMeasureParamList.add(olapCubeMeasureParamList.get(i));
				}
			}
		}
		this.olapCubeMeasureParamList_modified = true;
		this.isModified = true;
	}
	
	public void setOlapCubeMeasureParamList(com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParam[] olapCubeMeasureParamList) {
		this.olapCubeMeasureParamList.clear();
		if(olapCubeMeasureParamList == null) {
			return;
		} else {
			((ArrayList<com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParam>)this.olapCubeMeasureParamList).ensureCapacity(olapCubeMeasureParamList.length);
			for(int i = 0, n=olapCubeMeasureParamList.length; i < n; i++) {
				if( olapCubeMeasureParamList[i] == null ) {
					this.olapCubeMeasureParamList.add( new com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParam());					
				}
				else {
					this.olapCubeMeasureParamList.add(olapCubeMeasureParamList[i]);
				}
			}
		}
		this.olapCubeMeasureParamList_modified = true;
		this.isModified = true;
	}
	public void setOlapCubeMeasureParamList(int _index, com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParam olapCubeMeasureParamList) {
		if(olapCubeMeasureParamList == null) {
			this.olapCubeMeasureParamList.set(_index,  new com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParam());
		} else {
			this.olapCubeMeasureParamList.set(_index, olapCubeMeasureParamList);
		}
		this.olapCubeMeasureParamList_modified = true;
		this.isModified = true;
	}				
		
	public void addOlapCubeMeasureParamList(int _index, com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParam olapCubeMeasureParamList) {
		if(olapCubeMeasureParamList == null) {
			this.olapCubeMeasureParamList.add(_index,  new com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParam());
		} else {
			this.olapCubeMeasureParamList.add(_index, olapCubeMeasureParamList);
		}
		this.olapCubeMeasureParamList_modified = true;
		this.isModified = true;
	}
	public void addOlapCubeMeasureParamList(com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParam olapCubeMeasureParamList) {
		if(olapCubeMeasureParamList == null) {
			this.olapCubeMeasureParamList.add( new com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParam());
		} else {
			this.olapCubeMeasureParamList.add(olapCubeMeasureParamList);
		}
		this.olapCubeMeasureParamList_modified = true;
		this.isModified = true;
	}
	public com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParam removeOlapCubeMeasureParamList(int _index) {
		this.olapCubeMeasureParamList_modified = true;
		this.isModified = true;
		return (com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParam)this.olapCubeMeasureParamList.remove(_index);
	}

	@Override
	public void clearAllIsModified() {
		this.olapCubeMeasureParamList_modified = false;
		this.isModified = false;
	}
	
	@Override
	public List<String> getIsModifiedField() {
		List<String> modifiedFields = new ArrayList<>();
		if(this.olapCubeMeasureParamList_modified == true)
			modifiedFields.add("olapCubeMeasureParamList");
		return modifiedFields;
	}
	
	@Override
	public boolean isModified() {
	    return isModified;
	} 
	public Object clone() {
		OlapCubeMeasureParamList copyObj = new OlapCubeMeasureParamList();	
		copyObj.clone(this);
		return copyObj;
	}
	public void clone(DataObject _olapCubeMeasureParamList) {
		if(this == _olapCubeMeasureParamList) return;
		OlapCubeMeasureParamList __olapCubeMeasureParamList = (OlapCubeMeasureParamList) _olapCubeMeasureParamList;
		
		this.clearOlapCubeMeasureParamList();
		for (int index = 0; index < __olapCubeMeasureParamList.sizeOlapCubeMeasureParamList(); index++) {
			this.addOlapCubeMeasureParamList(index, (com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParam)__olapCubeMeasureParamList.getOlapCubeMeasureParamList(index).clone());		
		}
		
	}

	public String toString() {
		StringBuilder buffer = new StringBuilder();
		
		buffer.append("olapCubeMeasureParamList [");
		for (int index = 0; index < sizeOlapCubeMeasureParamList(); index++) {
			buffer.append("(").append(index).append(") : ").append(getOlapCubeMeasureParamList(index)).append(" ");
		}
		buffer.append("]");
		buffer.append("\n");
		return buffer.toString();
	}
	private static final Map<String,FieldProperty> fieldPropertyMap;
	
	static {
		fieldPropertyMap = new java.util.LinkedHashMap<String,FieldProperty>(1);
		fieldPropertyMap.put("olapCubeMeasureParamList"
							, FieldPropertyFactory.getFieldProperty( "olapCubeMeasureParamList","", "", "", false, false, false, FieldProperty.TYPE_ABSTRACT_INCLUDE, -1, -1, "9999" , "com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParam"));		
	}

	public Map<String,FieldProperty> getFieldPropertyMap() {
		return fieldPropertyMap;
	}
	
	public static Map<String,FieldProperty> getFieldPropertyMapByStatic() {
		return fieldPropertyMap;
	}	

	public Object get(String fieldName) throws FieldNotFoundException {
		switch(fieldName) {
			case "olapCubeMeasureParamList" : return getOlapCubeMeasureParamListList();
			default : throw new FieldNotFoundException(fieldName);		
		}
	}




	public void set(String fieldName, Object arg) throws FieldNotFoundException {
		switch(fieldName) {
			case "olapCubeMeasureParamList" : setOlapCubeMeasureParamList((List<com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParam>)arg);break;
			default : throw new FieldNotFoundException(fieldName);		
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if ((obj instanceof OlapCubeMeasureParamList) == false) return false;
		OlapCubeMeasureParamList _OlapCubeMeasureParamList = (OlapCubeMeasureParamList) obj;
		if(olapCubeMeasureParamList.size() != _OlapCubeMeasureParamList.sizeOlapCubeMeasureParamList()) return false;
		else {
			for(int i = 0, n = olapCubeMeasureParamList.size(); i < n; i++ ){ 
				if(!this.getOlapCubeMeasureParamList(i).equals(_OlapCubeMeasureParamList.getOlapCubeMeasureParamList(i))) return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		int prime = 31;
		int result = 1;

		for(int i=0, n=this.olapCubeMeasureParamList.size(); i<n; i++ ){ 
			result = prime * result + this.getOlapCubeMeasureParamList(i).hashCode();
		}
		return result;
	}
	
	private void writeObject(java.io.ObjectOutputStream stream)throws IOException {
		stream.defaultWriteObject();
	}
	
	
}
