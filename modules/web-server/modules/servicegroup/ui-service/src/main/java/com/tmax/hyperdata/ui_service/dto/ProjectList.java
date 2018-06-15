	
package com.tmax.hyperdata.ui_service.dto;

import java.io.IOException;
import java.util.List;

import java.util.ArrayList;

import java.util.Map;

import com.tmax.promapper.engine.dto.record.common.FieldProperty;
import com.tmax.promapper.engine.dto.record.common.FieldPropertyFactory;
import com.tmax.proobject.model.exception.FieldNotFoundException;

import com.tmax.proobject.model.dataobject.DataObject;




import com.tmax.hyperdata.ui_service.dto.Project;




@com.tmax.proobject.core.DataObject
public class ProjectList extends DataObject {
	private static final String DTO_LOGICAL_NAME = "ProjectList";
	
	public String getDtoLogicalName() {
		return DTO_LOGICAL_NAME;
	}
	
	private static final long serialVersionUID= 1L;
	
	public ProjectList() {
			super();
			
	}	 
	
	private boolean isModified = false;

	/**
	 * LogicalName : project
	 * Comments    : 
	 */
	private List<com.tmax.hyperdata.ui_service.dto.Project> project = new ArrayList<com.tmax.hyperdata.ui_service.dto.Project>(2);
	
	public List<com.tmax.hyperdata.ui_service.dto.Project> getProjectList() {
		return project;
	}
	private boolean project_invalidation = false;
	
	public void setInvalidationProject(boolean invalidation) { 
		this.project_invalidation = invalidation;
	}
	
	public boolean isInvalidationProject() {
		return this.project_invalidation;
	}
	
	private boolean project_modified = false;
	
	public boolean isModifiedProject() {
		if(this.project_modified) return true;
		for(int index=0; index < this.sizeProject(); index++) {
			if(this.getProject(index).isModified()) return true;
		}
		return false;
	}
	
	public void unModifiedProject() {
		this.project_modified = false;
	}
	
	public void clearProject() {
		project.clear();
		this.project_modified = false;
	}
	
	public void ensureCapacityProject(int minCapacity) {
		((ArrayList<com.tmax.hyperdata.ui_service.dto.Project>)project).ensureCapacity( minCapacity );	
	}	
	public void createProject(int _size) {
		((ArrayList<com.tmax.hyperdata.ui_service.dto.Project>)project).ensureCapacity(_size);
		for(int i = project.size(); i < _size; i++) {
			project.add( new com.tmax.hyperdata.ui_service.dto.Project());
			this.project_modified = true;
		}
	}
	public ProjectList fillProject(int _index) {
		ensureCapacityProject(_index+1);
		for (int i = sizeProject(); i <  _index + 1; i++) {
			this.project.add(i, new com.tmax.hyperdata.ui_service.dto.Project());
			this.project_modified = true;
		}
		return this;
	}
	
	public int sizeProject() {
		return project.size();
	}
	
	public com.tmax.hyperdata.ui_service.dto.Project[] getProject() {	
		return (com.tmax.hyperdata.ui_service.dto.Project[])project.toArray(new com.tmax.hyperdata.ui_service.dto.Project[project.size()]);
		}
	public com.tmax.hyperdata.ui_service.dto.Project getProject(int _index) {
		return (com.tmax.hyperdata.ui_service.dto.Project)project.get(_index);
	}
	public void setProject(List<com.tmax.hyperdata.ui_service.dto.Project> project) {
		this.project.clear();
		if(project == null) {
			return;
		} else {
			for(int i = 0, n=project.size(); i < n; i++) {
				if( project.get(i) == null ) {
					this.project.add( new com.tmax.hyperdata.ui_service.dto.Project());					
				}
				else {
					this.project.add(project.get(i));
				}
			}
		}
		this.project_modified = true;
		this.isModified = true;
	}
	
	public void setProject(com.tmax.hyperdata.ui_service.dto.Project[] project) {
		this.project.clear();
		if(project == null) {
			return;
		} else {
			((ArrayList<com.tmax.hyperdata.ui_service.dto.Project>)this.project).ensureCapacity(project.length);
			for(int i = 0, n=project.length; i < n; i++) {
				if( project[i] == null ) {
					this.project.add( new com.tmax.hyperdata.ui_service.dto.Project());					
				}
				else {
					this.project.add(project[i]);
				}
			}
		}
		this.project_modified = true;
		this.isModified = true;
	}
	public void setProject(int _index, com.tmax.hyperdata.ui_service.dto.Project project) {
		if(project == null) {
			this.project.set(_index,  new com.tmax.hyperdata.ui_service.dto.Project());
		} else {
			this.project.set(_index, project);
		}
		this.project_modified = true;
		this.isModified = true;
	}				
		
	public void addProject(int _index, com.tmax.hyperdata.ui_service.dto.Project project) {
		if(project == null) {
			this.project.add(_index,  new com.tmax.hyperdata.ui_service.dto.Project());
		} else {
			this.project.add(_index, project);
		}
		this.project_modified = true;
		this.isModified = true;
	}
	public void addProject(com.tmax.hyperdata.ui_service.dto.Project project) {
		if(project == null) {
			this.project.add( new com.tmax.hyperdata.ui_service.dto.Project());
		} else {
			this.project.add(project);
		}
		this.project_modified = true;
		this.isModified = true;
	}
	public com.tmax.hyperdata.ui_service.dto.Project removeProject(int _index) {
		this.project_modified = true;
		this.isModified = true;
		return (com.tmax.hyperdata.ui_service.dto.Project)this.project.remove(_index);
	}

	@Override
	public void clearAllIsModified() {
		this.project_modified = false;
		this.isModified = false;
	}
	
	@Override
	public List<String> getIsModifiedField() {
		List<String> modifiedFields = new ArrayList<>();
		if(this.project_modified == true)
			modifiedFields.add("project");
		return modifiedFields;
	}
	
	@Override
	public boolean isModified() {
	    return isModified;
	} 
	public Object clone() {
		ProjectList copyObj = new ProjectList();	
		copyObj.clone(this);
		return copyObj;
	}
	public void clone(DataObject _projectList) {
		if(this == _projectList) return;
		ProjectList __projectList = (ProjectList) _projectList;
		
		this.clearProject();
		for (int index = 0; index < __projectList.sizeProject(); index++) {
			this.addProject(index, (com.tmax.hyperdata.ui_service.dto.Project)__projectList.getProject(index).clone());		
		}
		
	}

	public String toString() {
		StringBuilder buffer = new StringBuilder();
		
		buffer.append("project [");
		for (int index = 0; index < sizeProject(); index++) {
			buffer.append("(").append(index).append(") : ").append(getProject(index)).append(" ");
		}
		buffer.append("]");
		buffer.append("\n");
		return buffer.toString();
	}
	private static final Map<String,FieldProperty> fieldPropertyMap;
	
	static {
		fieldPropertyMap = new java.util.LinkedHashMap<String,FieldProperty>(1);
		fieldPropertyMap.put("project"
							, FieldPropertyFactory.getFieldProperty( "project","", "", "", false, false, false, FieldProperty.TYPE_ABSTRACT_INCLUDE, 30 , -1, "2" , "com.tmax.hyperdata.ui_service.dto.Project"));		
	}

	public Map<String,FieldProperty> getFieldPropertyMap() {
		return fieldPropertyMap;
	}
	
	public static Map<String,FieldProperty> getFieldPropertyMapByStatic() {
		return fieldPropertyMap;
	}	

	public Object get(String fieldName) throws FieldNotFoundException {
		switch(fieldName) {
			case "project" : return getProjectList();
			default : throw new FieldNotFoundException(fieldName);		
		}
	}




	public void set(String fieldName, Object arg) throws FieldNotFoundException {
		switch(fieldName) {
			case "project" : setProject((List<com.tmax.hyperdata.ui_service.dto.Project>)arg);break;
			default : throw new FieldNotFoundException(fieldName);		
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if ((obj instanceof ProjectList) == false) return false;
		ProjectList _ProjectList = (ProjectList) obj;
		if(project.size() != _ProjectList.sizeProject()) return false;
		else {
			for(int i = 0, n = project.size(); i < n; i++ ){ 
				if(!this.getProject(i).equals(_ProjectList.getProject(i))) return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		int prime = 31;
		int result = 1;

		for(int i=0, n=this.project.size(); i<n; i++ ){ 
			result = prime * result + this.getProject(i).hashCode();
		}
		return result;
	}
	
	private void writeObject(java.io.ObjectOutputStream stream)throws IOException {
		stream.defaultWriteObject();
	}
	
	
}
