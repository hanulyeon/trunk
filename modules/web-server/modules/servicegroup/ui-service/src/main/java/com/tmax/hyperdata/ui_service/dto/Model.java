	
package com.tmax.hyperdata.ui_service.dto;

import java.io.IOException;
import java.util.List;

import java.util.ArrayList;

import java.util.Map;

import com.tmax.promapper.engine.dto.record.common.FieldProperty;
import com.tmax.promapper.engine.dto.record.common.FieldPropertyFactory;
import com.tmax.proobject.model.exception.FieldNotFoundException;

import com.tmax.proobject.model.dataobject.DataObject;




import java.sql.Timestamp;




@com.tmax.proobject.core.DataObject
public class Model extends DataObject {
	private static final String DTO_LOGICAL_NAME = "Model";
	
	public String getDtoLogicalName() {
		return DTO_LOGICAL_NAME;
	}
	
	private static final long serialVersionUID= 1L;
	
	public Model() {
			super();
			
	}	 
	
	private boolean isModified = false;

	/**
	 * LogicalName : id
	 * Comments    : 
	 */		

	private String id = EMPTY_STRING;
	
			
	private boolean id_nullable = false;
	
	public boolean isNullableId() {
		return this.id_nullable;
	}	
	
	private boolean id_invalidation = false;
	
	public void setInvalidationId(boolean invalidation) { 
		this.id_invalidation = invalidation;
	}
	
	public boolean isInvalidationId() {
		return this.id_invalidation;
	}
	
	private boolean id_modified = false;
	

	public boolean isModifiedId() {
		return this.id_modified;
	}
	
	public void unModifiedId() {
		this.id_modified = false;
	}

	public String getId() {
		return id;
	}
	public String getNvlId() {
		if(getId() == null) {
			return  EMPTY_STRING;
		} else {
			return getId();
		}
	}
	public void setId(String id) {
		if(id == null) {
			this.id  = EMPTY_STRING;
		} else {
			this.id = id;
		}
		this.id_modified = true;
		this.isModified = true;
	}	
			

	/**
	 * LogicalName : name
	 * Comments    : 
	 */		

	private String name = EMPTY_STRING;
	
			
	private boolean name_nullable = false;
	
	public boolean isNullableName() {
		return this.name_nullable;
	}	
	
	private boolean name_invalidation = false;
	
	public void setInvalidationName(boolean invalidation) { 
		this.name_invalidation = invalidation;
	}
	
	public boolean isInvalidationName() {
		return this.name_invalidation;
	}
	
	private boolean name_modified = false;
	

	public boolean isModifiedName() {
		return this.name_modified;
	}
	
	public void unModifiedName() {
		this.name_modified = false;
	}

	public String getName() {
		return name;
	}
	public String getNvlName() {
		if(getName() == null) {
			return  EMPTY_STRING;
		} else {
			return getName();
		}
	}
	public void setName(String name) {
		if(name == null) {
			this.name  = EMPTY_STRING;
		} else {
			this.name = name;
		}
		this.name_modified = true;
		this.isModified = true;
	}	
			

	/**
	 * LogicalName : author
	 * Comments    : 
	 */		

	private String author = EMPTY_STRING;
	
			
	private boolean author_nullable = false;
	
	public boolean isNullableAuthor() {
		return this.author_nullable;
	}	
	
	private boolean author_invalidation = false;
	
	public void setInvalidationAuthor(boolean invalidation) { 
		this.author_invalidation = invalidation;
	}
	
	public boolean isInvalidationAuthor() {
		return this.author_invalidation;
	}
	
	private boolean author_modified = false;
	

	public boolean isModifiedAuthor() {
		return this.author_modified;
	}
	
	public void unModifiedAuthor() {
		this.author_modified = false;
	}

	public String getAuthor() {
		return author;
	}
	public String getNvlAuthor() {
		if(getAuthor() == null) {
			return  EMPTY_STRING;
		} else {
			return getAuthor();
		}
	}
	public void setAuthor(String author) {
		if(author == null) {
			this.author  = EMPTY_STRING;
		} else {
			this.author = author;
		}
		this.author_modified = true;
		this.isModified = true;
	}	
			

	/**
	 * LogicalName : status
	 * Comments    : 
	 */		

	private String status = EMPTY_STRING;
	
			
	private boolean status_nullable = false;
	
	public boolean isNullableStatus() {
		return this.status_nullable;
	}	
	
	private boolean status_invalidation = false;
	
	public void setInvalidationStatus(boolean invalidation) { 
		this.status_invalidation = invalidation;
	}
	
	public boolean isInvalidationStatus() {
		return this.status_invalidation;
	}
	
	private boolean status_modified = false;
	

	public boolean isModifiedStatus() {
		return this.status_modified;
	}
	
	public void unModifiedStatus() {
		this.status_modified = false;
	}

	public String getStatus() {
		return status;
	}
	public String getNvlStatus() {
		if(getStatus() == null) {
			return  EMPTY_STRING;
		} else {
			return getStatus();
		}
	}
	public void setStatus(String status) {
		if(status == null) {
			this.status  = EMPTY_STRING;
		} else {
			this.status = status;
		}
		this.status_modified = true;
		this.isModified = true;
	}	
			

	/**
	 * LogicalName : lastEdited
	 * Comments    : 
	 */		

	private Timestamp lastEdited = null;
	
		
	
	private boolean lastEdited_invalidation = false;
	
	public void setInvalidationLastEdited(boolean invalidation) { 
		this.lastEdited_invalidation = invalidation;
	}
	
	public boolean isInvalidationLastEdited() {
		return this.lastEdited_invalidation;
	}
	
	private boolean lastEdited_modified = false;
	

	public boolean isModifiedLastEdited() {
		return this.lastEdited_modified;
	}
	
	public void unModifiedLastEdited() {
		this.lastEdited_modified = false;
	}

	public Timestamp getLastEdited() {
		return lastEdited;
	}			
	public java.util.Date getLastEditedDate() {
		if(lastEdited == null)
			return null;
		java.util.Date _lastEdited = new java.util.Date(lastEdited.getTime());
		return _lastEdited;
	}

	public String getLastEditedString() {
		if(this.lastEdited == null)
			return null;
		java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy.MM.dd HH.mm.ss");
        String _lastEdited = df.format(this.lastEdited);
        
        return _lastEdited;
	}
	public void setLastEdited(Timestamp lastEdited) {
		this.lastEdited = lastEdited;
		this.lastEdited_modified = true;
		this.isModified = true;
	}
	
	public void setLastEdited(java.util.Date lastEdited) {
		if(lastEdited == null) {
			this.lastEdited = null;
		} else{
			this.lastEdited = new Timestamp(lastEdited.getTime());
		}
		this.lastEdited_modified = true;
		this.isModified = true;		
	}
	
	public void setLastEdited(long lastEdited) {
		this.lastEdited = new Timestamp(lastEdited);
		this.lastEdited_modified = true;
		this.isModified = true;
	}		

	/**
	 * LogicalName : projectId
	 * Comments    : 
	 */		

	private String projectId = EMPTY_STRING;
	
			
	private boolean projectId_nullable = false;
	
	public boolean isNullableProjectId() {
		return this.projectId_nullable;
	}	
	
	private boolean projectId_invalidation = false;
	
	public void setInvalidationProjectId(boolean invalidation) { 
		this.projectId_invalidation = invalidation;
	}
	
	public boolean isInvalidationProjectId() {
		return this.projectId_invalidation;
	}
	
	private boolean projectId_modified = false;
	

	public boolean isModifiedProjectId() {
		return this.projectId_modified;
	}
	
	public void unModifiedProjectId() {
		this.projectId_modified = false;
	}

	public String getProjectId() {
		return projectId;
	}
	public String getNvlProjectId() {
		if(getProjectId() == null) {
			return  EMPTY_STRING;
		} else {
			return getProjectId();
		}
	}
	public void setProjectId(String projectId) {
		if(projectId == null) {
			this.projectId  = EMPTY_STRING;
		} else {
			this.projectId = projectId;
		}
		this.projectId_modified = true;
		this.isModified = true;
	}	
			

	/**
	 * LogicalName : description
	 * Comments    : 
	 */		

	private String description = EMPTY_STRING;
	
			
	private boolean description_nullable = false;
	
	public boolean isNullableDescription() {
		return this.description_nullable;
	}	
	
	private boolean description_invalidation = false;
	
	public void setInvalidationDescription(boolean invalidation) { 
		this.description_invalidation = invalidation;
	}
	
	public boolean isInvalidationDescription() {
		return this.description_invalidation;
	}
	
	private boolean description_modified = false;
	

	public boolean isModifiedDescription() {
		return this.description_modified;
	}
	
	public void unModifiedDescription() {
		this.description_modified = false;
	}

	public String getDescription() {
		return description;
	}
	public String getNvlDescription() {
		if(getDescription() == null) {
			return  EMPTY_STRING;
		} else {
			return getDescription();
		}
	}
	public void setDescription(String description) {
		if(description == null) {
			this.description  = EMPTY_STRING;
		} else {
			this.description = description;
		}
		this.description_modified = true;
		this.isModified = true;
	}	
			

	/**
	 * LogicalName : flowId
	 * Comments    : 
	 */		

	private String flowId = EMPTY_STRING;
	
			
	private boolean flowId_nullable = false;
	
	public boolean isNullableFlowId() {
		return this.flowId_nullable;
	}	
	
	private boolean flowId_invalidation = false;
	
	public void setInvalidationFlowId(boolean invalidation) { 
		this.flowId_invalidation = invalidation;
	}
	
	public boolean isInvalidationFlowId() {
		return this.flowId_invalidation;
	}
	
	private boolean flowId_modified = false;
	

	public boolean isModifiedFlowId() {
		return this.flowId_modified;
	}
	
	public void unModifiedFlowId() {
		this.flowId_modified = false;
	}

	public String getFlowId() {
		return flowId;
	}
	public String getNvlFlowId() {
		if(getFlowId() == null) {
			return  EMPTY_STRING;
		} else {
			return getFlowId();
		}
	}
	public void setFlowId(String flowId) {
		if(flowId == null) {
			this.flowId  = EMPTY_STRING;
		} else {
			this.flowId = flowId;
		}
		this.flowId_modified = true;
		this.isModified = true;
	}	
			

	@Override
	public void clearAllIsModified() {
		this.id_modified = false;
		this.name_modified = false;
		this.author_modified = false;
		this.status_modified = false;
		this.lastEdited_modified = false;
		this.projectId_modified = false;
		this.description_modified = false;
		this.flowId_modified = false;
		this.isModified = false;
	}
	
	@Override
	public List<String> getIsModifiedField() {
		List<String> modifiedFields = new ArrayList<>();
		if(this.id_modified == true)
			modifiedFields.add("id");
		if(this.name_modified == true)
			modifiedFields.add("name");
		if(this.author_modified == true)
			modifiedFields.add("author");
		if(this.status_modified == true)
			modifiedFields.add("status");
		if(this.lastEdited_modified == true)
			modifiedFields.add("lastEdited");
		if(this.projectId_modified == true)
			modifiedFields.add("projectId");
		if(this.description_modified == true)
			modifiedFields.add("description");
		if(this.flowId_modified == true)
			modifiedFields.add("flowId");
		return modifiedFields;
	}
	
	@Override
	public boolean isModified() {
	    return isModified;
	} 
	public Object clone() {
		Model copyObj = new Model();	
		copyObj.clone(this);
		return copyObj;
	}
	public void clone(DataObject _model) {
		if(this == _model) return;
		Model __model = (Model) _model;
		
		this.setId(__model.getId());
		this.setName(__model.getName());
		this.setAuthor(__model.getAuthor());
		this.setStatus(__model.getStatus());
		this.setLastEdited(__model.getLastEdited());
		this.setProjectId(__model.getProjectId());
		this.setDescription(__model.getDescription());
		this.setFlowId(__model.getFlowId());
		
	}

	public String toString() {
		StringBuilder buffer = new StringBuilder();
				
		buffer.append("id : ").append(id).append("\n");				
		buffer.append("name : ").append(name).append("\n");				
		buffer.append("author : ").append(author).append("\n");				
		buffer.append("status : ").append(status).append("\n");				
		buffer.append("lastEdited : ").append(lastEdited).append("\n");				
		buffer.append("projectId : ").append(projectId).append("\n");				
		buffer.append("description : ").append(description).append("\n");				
		buffer.append("flowId : ").append(flowId).append("\n");		
		return buffer.toString();
	}
	private static final Map<String,FieldProperty> fieldPropertyMap;
	
	static {
		fieldPropertyMap = new java.util.LinkedHashMap<String,FieldProperty>(8);
		fieldPropertyMap.put("id"
							, FieldPropertyFactory.getFieldProperty( "id","", "", "", false, false, false,  FieldProperty.TYPE_OBJECT_STRING, 255 , -1, null, null));		
		fieldPropertyMap.put("name"
							, FieldPropertyFactory.getFieldProperty( "name","", "", "", false, false, false,  FieldProperty.TYPE_OBJECT_STRING, 255 , -1, null, null));		
		fieldPropertyMap.put("author"
							, FieldPropertyFactory.getFieldProperty( "author","", "", "", false, false, false,  FieldProperty.TYPE_OBJECT_STRING, 255 , -1, null, null));		
		fieldPropertyMap.put("status"
							, FieldPropertyFactory.getFieldProperty( "status","", "", "", false, false, false,  FieldProperty.TYPE_OBJECT_STRING, 255 , -1, null, null));		
			fieldPropertyMap.put("lastEdited"
							, FieldPropertyFactory.getFieldProperty( "lastEdited","", "", "", false, false, false,  FieldProperty.TYPE_OBJECT_TIMESTAMP, 255 , -1, null, null));		
		fieldPropertyMap.put("projectId"
							, FieldPropertyFactory.getFieldProperty( "projectId","", "", "", false, false, false,  FieldProperty.TYPE_OBJECT_STRING, 255 , -1, null, null));		
		fieldPropertyMap.put("description"
							, FieldPropertyFactory.getFieldProperty( "description","", "", "", false, false, false,  FieldProperty.TYPE_OBJECT_STRING, 4000 , -1, null, null));		
		fieldPropertyMap.put("flowId"
							, FieldPropertyFactory.getFieldProperty( "flowId","", "", "", false, false, false,  FieldProperty.TYPE_OBJECT_STRING, 4000 , -1, null, null));		
	}

	public Map<String,FieldProperty> getFieldPropertyMap() {
		return fieldPropertyMap;
	}
	
	public static Map<String,FieldProperty> getFieldPropertyMapByStatic() {
		return fieldPropertyMap;
	}	

	public Object get(String fieldName) throws FieldNotFoundException {
		switch(fieldName) {
			case "id" : return getId();
			case "name" : return getName();
			case "author" : return getAuthor();
			case "status" : return getStatus();
			case "lastEdited" : return getLastEdited();
			case "projectId" : return getProjectId();
			case "description" : return getDescription();
			case "flowId" : return getFlowId();
			default : throw new FieldNotFoundException(fieldName);		
		}
	}




	public void set(String fieldName, Object arg) throws FieldNotFoundException {
		switch(fieldName) {
			case "id" : setId((String)arg);break;
			case "name" : setName((String)arg);break;
			case "author" : setAuthor((String)arg);break;
			case "status" : setStatus((String)arg);break;
			case "lastEdited" : setLastEdited((Timestamp)arg);break;
			case "projectId" : setProjectId((String)arg);break;
			case "description" : setDescription((String)arg);break;
			case "flowId" : setFlowId((String)arg);break;
			default : throw new FieldNotFoundException(fieldName);		
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if ((obj instanceof Model) == false) return false;
		Model _Model = (Model) obj;					
		if(id == null) {
			if(_Model.getId() != null)
				return false;
		} else if(!id.equals(_Model.getId()))
			return false;					
		if(name == null) {
			if(_Model.getName() != null)
				return false;
		} else if(!name.equals(_Model.getName()))
			return false;					
		if(author == null) {
			if(_Model.getAuthor() != null)
				return false;
		} else if(!author.equals(_Model.getAuthor()))
			return false;					
		if(status == null) {
			if(_Model.getStatus() != null)
				return false;
		} else if(!status.equals(_Model.getStatus()))
			return false;					
		if(lastEdited == null) {
			if(_Model.getLastEdited() != null)
				return false;
		} else if(!lastEdited.equals(_Model.getLastEdited()))
			return false;					
		if(projectId == null) {
			if(_Model.getProjectId() != null)
				return false;
		} else if(!projectId.equals(_Model.getProjectId()))
			return false;					
		if(description == null) {
			if(_Model.getDescription() != null)
				return false;
		} else if(!description.equals(_Model.getDescription()))
			return false;					
		if(flowId == null) {
			if(_Model.getFlowId() != null)
				return false;
		} else if(!flowId.equals(_Model.getFlowId()))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		int prime = 31;
		int result = 1;					
		result = prime * result + ((id == null) ? 0 : id.hashCode());													
		result = prime * result + ((name == null) ? 0 : name.hashCode());													
		result = prime * result + ((author == null) ? 0 : author.hashCode());													
		result = prime * result + ((status == null) ? 0 : status.hashCode());													
		result = prime * result + ((lastEdited == null) ? 0 : lastEdited.hashCode());													
		result = prime * result + ((projectId == null) ? 0 : projectId.hashCode());													
		result = prime * result + ((description == null) ? 0 : description.hashCode());													
		result = prime * result + ((flowId == null) ? 0 : flowId.hashCode());								
		return result;
	}
	
	private void writeObject(java.io.ObjectOutputStream stream)throws IOException {
		stream.defaultWriteObject();
	}
	
	
}
