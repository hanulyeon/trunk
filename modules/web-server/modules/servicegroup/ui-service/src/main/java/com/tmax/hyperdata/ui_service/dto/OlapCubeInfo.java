	
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
public class OlapCubeInfo extends DataObject {
	private static final String DTO_LOGICAL_NAME = "OlapCubeInfo";
	
	public String getDtoLogicalName() {
		return DTO_LOGICAL_NAME;
	}
	
	private static final long serialVersionUID= 1L;
	
	public OlapCubeInfo() {
			super();
			
	}	 
	
	private boolean isModified = false;

	/**
	 * LogicalName : id
	 * Comments    : 
	 */		

	private int id;
	
		
	
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

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
		this.id_modified = true;
		this.isModified = true;
	}
	
	public void setId(Integer id) {
		if( id == null) {
			this.id = 0;
		} else{
			this.id = id.intValue();
		}
		this.id_modified = true;
		this.isModified = true;
	}
	public void setId(String id) {
		if  (id==null || id.length() == 0) {
			this.id = 0;
		} else {
			this.id = Integer.parseInt(id);
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
	 * LogicalName : modelId
	 * Comments    : 
	 */		

	private int modelId;
	
		
	
	private boolean modelId_invalidation = false;
	
	public void setInvalidationModelId(boolean invalidation) { 
		this.modelId_invalidation = invalidation;
	}
	
	public boolean isInvalidationModelId() {
		return this.modelId_invalidation;
	}
	
	private boolean modelId_modified = false;
	

	public boolean isModifiedModelId() {
		return this.modelId_modified;
	}
	
	public void unModifiedModelId() {
		this.modelId_modified = false;
	}

	public int getModelId() {
		return modelId;
	}
	public void setModelId(int modelId) {
		this.modelId = modelId;
		this.modelId_modified = true;
		this.isModified = true;
	}
	
	public void setModelId(Integer modelId) {
		if( modelId == null) {
			this.modelId = 0;
		} else{
			this.modelId = modelId.intValue();
		}
		this.modelId_modified = true;
		this.isModified = true;
	}
	public void setModelId(String modelId) {
		if  (modelId==null || modelId.length() == 0) {
			this.modelId = 0;
		} else {
			this.modelId = Integer.parseInt(modelId);
		}
		this.modelId_modified = true;
		this.isModified = true;
	}		

	/**
	 * LogicalName : contents
	 * Comments    : 
	 */		

	private String contents = EMPTY_STRING;
	
			
	private boolean contents_nullable = false;
	
	public boolean isNullableContents() {
		return this.contents_nullable;
	}	
	
	private boolean contents_invalidation = false;
	
	public void setInvalidationContents(boolean invalidation) { 
		this.contents_invalidation = invalidation;
	}
	
	public boolean isInvalidationContents() {
		return this.contents_invalidation;
	}
	
	private boolean contents_modified = false;
	

	public boolean isModifiedContents() {
		return this.contents_modified;
	}
	
	public void unModifiedContents() {
		this.contents_modified = false;
	}

	public String getContents() {
		return contents;
	}
	public String getNvlContents() {
		if(getContents() == null) {
			return  EMPTY_STRING;
		} else {
			return getContents();
		}
	}
	public void setContents(String contents) {
		if(contents == null) {
			this.contents  = EMPTY_STRING;
		} else {
			this.contents = contents;
		}
		this.contents_modified = true;
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
			

	@Override
	public void clearAllIsModified() {
		this.id_modified = false;
		this.name_modified = false;
		this.author_modified = false;
		this.lastEdited_modified = false;
		this.modelId_modified = false;
		this.contents_modified = false;
		this.description_modified = false;
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
		if(this.lastEdited_modified == true)
			modifiedFields.add("lastEdited");
		if(this.modelId_modified == true)
			modifiedFields.add("modelId");
		if(this.contents_modified == true)
			modifiedFields.add("contents");
		if(this.description_modified == true)
			modifiedFields.add("description");
		return modifiedFields;
	}
	
	@Override
	public boolean isModified() {
	    return isModified;
	} 
	public Object clone() {
		OlapCubeInfo copyObj = new OlapCubeInfo();	
		copyObj.clone(this);
		return copyObj;
	}
	public void clone(DataObject _olapCubeInfo) {
		if(this == _olapCubeInfo) return;
		OlapCubeInfo __olapCubeInfo = (OlapCubeInfo) _olapCubeInfo;
		
		this.setId(__olapCubeInfo.getId());
		this.setName(__olapCubeInfo.getName());
		this.setAuthor(__olapCubeInfo.getAuthor());
		this.setLastEdited(__olapCubeInfo.getLastEdited());
		this.setModelId(__olapCubeInfo.getModelId());
		this.setContents(__olapCubeInfo.getContents());
		this.setDescription(__olapCubeInfo.getDescription());
		
	}

	public String toString() {
		StringBuilder buffer = new StringBuilder();
				
		buffer.append("id : ").append(id).append("\n");				
		buffer.append("name : ").append(name).append("\n");				
		buffer.append("author : ").append(author).append("\n");				
		buffer.append("lastEdited : ").append(lastEdited).append("\n");				
		buffer.append("modelId : ").append(modelId).append("\n");				
		buffer.append("contents : ").append(contents).append("\n");				
		buffer.append("description : ").append(description).append("\n");		
		return buffer.toString();
	}
	private static final Map<String,FieldProperty> fieldPropertyMap;
	
	static {
		fieldPropertyMap = new java.util.LinkedHashMap<String,FieldProperty>(7);
		fieldPropertyMap.put("id"
							, FieldPropertyFactory.getFieldProperty( "id","", "", "", false, false, false,  FieldProperty.TYPE_PRIMITIVE_INT, 10 , -1, null, null));		
		fieldPropertyMap.put("name"
							, FieldPropertyFactory.getFieldProperty( "name","", "", "", false, false, false,  FieldProperty.TYPE_OBJECT_STRING, 255 , -1, null, null));		
		fieldPropertyMap.put("author"
							, FieldPropertyFactory.getFieldProperty( "author","", "", "", false, false, false,  FieldProperty.TYPE_OBJECT_STRING, 255 , -1, null, null));		
			fieldPropertyMap.put("lastEdited"
							, FieldPropertyFactory.getFieldProperty( "lastEdited","", "", "", false, false, false,  FieldProperty.TYPE_OBJECT_TIMESTAMP, 255 , -1, null, null));		
		fieldPropertyMap.put("modelId"
							, FieldPropertyFactory.getFieldProperty( "modelId","", "", "", false, false, false,  FieldProperty.TYPE_PRIMITIVE_INT, 10 , -1, null, null));		
		fieldPropertyMap.put("contents"
							, FieldPropertyFactory.getFieldProperty( "contents","", "", "", false, false, false,  FieldProperty.TYPE_OBJECT_STRING, 4000 , -1, null, null));		
		fieldPropertyMap.put("description"
							, FieldPropertyFactory.getFieldProperty( "description","", "", "", false, false, false,  FieldProperty.TYPE_OBJECT_STRING, 4000 , -1, null, null));		
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
			case "lastEdited" : return getLastEdited();
			case "modelId" : return getModelId();
			case "contents" : return getContents();
			case "description" : return getDescription();
			default : throw new FieldNotFoundException(fieldName);		
		}
	}




	public void set(String fieldName, Object arg) throws FieldNotFoundException {
		switch(fieldName) {
			case "id" : setId((Integer)arg);break;
			case "name" : setName((String)arg);break;
			case "author" : setAuthor((String)arg);break;
			case "lastEdited" : setLastEdited((Timestamp)arg);break;
			case "modelId" : setModelId((Integer)arg);break;
			case "contents" : setContents((String)arg);break;
			case "description" : setDescription((String)arg);break;
			default : throw new FieldNotFoundException(fieldName);		
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if ((obj instanceof OlapCubeInfo) == false) return false;
		OlapCubeInfo _OlapCubeInfo = (OlapCubeInfo) obj;				
		if(id != _OlapCubeInfo.getId()) return false; 									
		if(name == null) {
			if(_OlapCubeInfo.getName() != null)
				return false;
		} else if(!name.equals(_OlapCubeInfo.getName()))
			return false;					
		if(author == null) {
			if(_OlapCubeInfo.getAuthor() != null)
				return false;
		} else if(!author.equals(_OlapCubeInfo.getAuthor()))
			return false;					
		if(lastEdited == null) {
			if(_OlapCubeInfo.getLastEdited() != null)
				return false;
		} else if(!lastEdited.equals(_OlapCubeInfo.getLastEdited()))
			return false;				
		if(modelId != _OlapCubeInfo.getModelId()) return false; 									
		if(contents == null) {
			if(_OlapCubeInfo.getContents() != null)
				return false;
		} else if(!contents.equals(_OlapCubeInfo.getContents()))
			return false;					
		if(description == null) {
			if(_OlapCubeInfo.getDescription() != null)
				return false;
		} else if(!description.equals(_OlapCubeInfo.getDescription()))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		int prime = 31;
		int result = 1;
		result = prime * result + id;					
		result = prime * result + ((name == null) ? 0 : name.hashCode());													
		result = prime * result + ((author == null) ? 0 : author.hashCode());													
		result = prime * result + ((lastEdited == null) ? 0 : lastEdited.hashCode());								
		result = prime * result + modelId;					
		result = prime * result + ((contents == null) ? 0 : contents.hashCode());													
		result = prime * result + ((description == null) ? 0 : description.hashCode());								
		return result;
	}
	
	private void writeObject(java.io.ObjectOutputStream stream)throws IOException {
		stream.defaultWriteObject();
	}
	
	
}
