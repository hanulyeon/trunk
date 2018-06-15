	
package com.tmax.hyperdata.ui_service.dto;

import java.io.IOException;
import java.util.List;

import java.util.ArrayList;

import java.util.Map;

import com.tmax.promapper.engine.dto.record.common.FieldProperty;
import com.tmax.promapper.engine.dto.record.common.FieldPropertyFactory;
import com.tmax.proobject.model.exception.FieldNotFoundException;

import com.tmax.proobject.model.dataobject.DataObject;




import com.tmax.hyperdata.ui_service.dto.Model;




@com.tmax.proobject.core.DataObject
public class ModelList extends DataObject {
	private static final String DTO_LOGICAL_NAME = "ModelList";
	
	public String getDtoLogicalName() {
		return DTO_LOGICAL_NAME;
	}
	
	private static final long serialVersionUID= 1L;
	
	public ModelList() {
			super();
			
	}	 
	
	private boolean isModified = false;

	/**
	 * LogicalName : model
	 * Comments    : 
	 */
	private List<com.tmax.hyperdata.ui_service.dto.Model> model = new ArrayList<com.tmax.hyperdata.ui_service.dto.Model>(2);
	
	public List<com.tmax.hyperdata.ui_service.dto.Model> getModelList() {
		return model;
	}
	private boolean model_invalidation = false;
	
	public void setInvalidationModel(boolean invalidation) { 
		this.model_invalidation = invalidation;
	}
	
	public boolean isInvalidationModel() {
		return this.model_invalidation;
	}
	
	private boolean model_modified = false;
	
	public boolean isModifiedModel() {
		if(this.model_modified) return true;
		for(int index=0; index < this.sizeModel(); index++) {
			if(this.getModel(index).isModified()) return true;
		}
		return false;
	}
	
	public void unModifiedModel() {
		this.model_modified = false;
	}
	
	public void clearModel() {
		model.clear();
		this.model_modified = false;
	}
	
	public void ensureCapacityModel(int minCapacity) {
		((ArrayList<com.tmax.hyperdata.ui_service.dto.Model>)model).ensureCapacity( minCapacity );	
	}	
	public void createModel(int _size) {
		((ArrayList<com.tmax.hyperdata.ui_service.dto.Model>)model).ensureCapacity(_size);
		for(int i = model.size(); i < _size; i++) {
			model.add( new com.tmax.hyperdata.ui_service.dto.Model());
			this.model_modified = true;
		}
	}
	public ModelList fillModel(int _index) {
		ensureCapacityModel(_index+1);
		for (int i = sizeModel(); i <  _index + 1; i++) {
			this.model.add(i, new com.tmax.hyperdata.ui_service.dto.Model());
			this.model_modified = true;
		}
		return this;
	}
	
	public int sizeModel() {
		return model.size();
	}
	
	public com.tmax.hyperdata.ui_service.dto.Model[] getModel() {	
		return (com.tmax.hyperdata.ui_service.dto.Model[])model.toArray(new com.tmax.hyperdata.ui_service.dto.Model[model.size()]);
		}
	public com.tmax.hyperdata.ui_service.dto.Model getModel(int _index) {
		return (com.tmax.hyperdata.ui_service.dto.Model)model.get(_index);
	}
	public void setModel(List<com.tmax.hyperdata.ui_service.dto.Model> model) {
		this.model.clear();
		if(model == null) {
			return;
		} else {
			for(int i = 0, n=model.size(); i < n; i++) {
				if( model.get(i) == null ) {
					this.model.add( new com.tmax.hyperdata.ui_service.dto.Model());					
				}
				else {
					this.model.add(model.get(i));
				}
			}
		}
		this.model_modified = true;
		this.isModified = true;
	}
	
	public void setModel(com.tmax.hyperdata.ui_service.dto.Model[] model) {
		this.model.clear();
		if(model == null) {
			return;
		} else {
			((ArrayList<com.tmax.hyperdata.ui_service.dto.Model>)this.model).ensureCapacity(model.length);
			for(int i = 0, n=model.length; i < n; i++) {
				if( model[i] == null ) {
					this.model.add( new com.tmax.hyperdata.ui_service.dto.Model());					
				}
				else {
					this.model.add(model[i]);
				}
			}
		}
		this.model_modified = true;
		this.isModified = true;
	}
	public void setModel(int _index, com.tmax.hyperdata.ui_service.dto.Model model) {
		if(model == null) {
			this.model.set(_index,  new com.tmax.hyperdata.ui_service.dto.Model());
		} else {
			this.model.set(_index, model);
		}
		this.model_modified = true;
		this.isModified = true;
	}				
		
	public void addModel(int _index, com.tmax.hyperdata.ui_service.dto.Model model) {
		if(model == null) {
			this.model.add(_index,  new com.tmax.hyperdata.ui_service.dto.Model());
		} else {
			this.model.add(_index, model);
		}
		this.model_modified = true;
		this.isModified = true;
	}
	public void addModel(com.tmax.hyperdata.ui_service.dto.Model model) {
		if(model == null) {
			this.model.add( new com.tmax.hyperdata.ui_service.dto.Model());
		} else {
			this.model.add(model);
		}
		this.model_modified = true;
		this.isModified = true;
	}
	public com.tmax.hyperdata.ui_service.dto.Model removeModel(int _index) {
		this.model_modified = true;
		this.isModified = true;
		return (com.tmax.hyperdata.ui_service.dto.Model)this.model.remove(_index);
	}

	@Override
	public void clearAllIsModified() {
		this.model_modified = false;
		this.isModified = false;
	}
	
	@Override
	public List<String> getIsModifiedField() {
		List<String> modifiedFields = new ArrayList<>();
		if(this.model_modified == true)
			modifiedFields.add("model");
		return modifiedFields;
	}
	
	@Override
	public boolean isModified() {
	    return isModified;
	} 
	public Object clone() {
		ModelList copyObj = new ModelList();	
		copyObj.clone(this);
		return copyObj;
	}
	public void clone(DataObject _modelList) {
		if(this == _modelList) return;
		ModelList __modelList = (ModelList) _modelList;
		
		this.clearModel();
		for (int index = 0; index < __modelList.sizeModel(); index++) {
			this.addModel(index, (com.tmax.hyperdata.ui_service.dto.Model)__modelList.getModel(index).clone());		
		}
		
	}

	public String toString() {
		StringBuilder buffer = new StringBuilder();
		
		buffer.append("model [");
		for (int index = 0; index < sizeModel(); index++) {
			buffer.append("(").append(index).append(") : ").append(getModel(index)).append(" ");
		}
		buffer.append("]");
		buffer.append("\n");
		return buffer.toString();
	}
	private static final Map<String,FieldProperty> fieldPropertyMap;
	
	static {
		fieldPropertyMap = new java.util.LinkedHashMap<String,FieldProperty>(1);
		fieldPropertyMap.put("model"
							, FieldPropertyFactory.getFieldProperty( "model","", "", "", false, false, false, FieldProperty.TYPE_ABSTRACT_INCLUDE, 30 , -1, "2" , "com.tmax.hyperdata.ui_service.dto.Model"));		
	}

	public Map<String,FieldProperty> getFieldPropertyMap() {
		return fieldPropertyMap;
	}
	
	public static Map<String,FieldProperty> getFieldPropertyMapByStatic() {
		return fieldPropertyMap;
	}	

	public Object get(String fieldName) throws FieldNotFoundException {
		switch(fieldName) {
			case "model" : return getModelList();
			default : throw new FieldNotFoundException(fieldName);		
		}
	}




	public void set(String fieldName, Object arg) throws FieldNotFoundException {
		switch(fieldName) {
			case "model" : setModel((List<com.tmax.hyperdata.ui_service.dto.Model>)arg);break;
			default : throw new FieldNotFoundException(fieldName);		
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if ((obj instanceof ModelList) == false) return false;
		ModelList _ModelList = (ModelList) obj;
		if(model.size() != _ModelList.sizeModel()) return false;
		else {
			for(int i = 0, n = model.size(); i < n; i++ ){ 
				if(!this.getModel(i).equals(_ModelList.getModel(i))) return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		int prime = 31;
		int result = 1;

		for(int i=0, n=this.model.size(); i<n; i++ ){ 
			result = prime * result + this.getModel(i).hashCode();
		}
		return result;
	}
	
	private void writeObject(java.io.ObjectOutputStream stream)throws IOException {
		stream.defaultWriteObject();
	}
	
	
}
