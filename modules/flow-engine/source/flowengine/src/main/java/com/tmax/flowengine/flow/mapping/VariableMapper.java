package com.tmax.flowengine.flow.mapping;

import com.tmax.flowengine.flow.FlowContext;
import com.tmax.flowengine.meta.flowgraph.ContextField;
import com.tmax.flowengine.meta.flowgraph.ContextParameter;
import com.tmax.promapper.engine.base.Message;
import com.tmax.proobject.core.config.ProObject;
import com.tmax.proobject.core.constant.ProObjectExceptionCode;
import com.tmax.proobject.core.exception.ProObjectRuntimeException;
import com.tmax.proobject.engine.application.ApplicationManager;
import com.tmax.proobject.model.dataobject.DataObject;
import com.tmax.proobject.model.promapper.ProMapperMessageType;
import com.tmax.proobject.util.StringUtil;
import com.tmax.proobject.util.concurrency.ProObjectThread;

public class VariableMapper {
    public static DataObject mapToDataObject(FlowContext context, ContextParameter contextParameter) {
        if(StringUtil.isNotEmpty(contextParameter.getDto())) {
            try {
                String      application         = ProObjectThread.getApplication();
                long        globalDeployVersion = ProObject.getGlobalDeployVersion();
                ClassLoader classLoader         = ApplicationManager.getManager(application).getClassLoader(globalDeployVersion).getDataObjectClassLoader();
                Class<?>    clazz               = classLoader.loadClass(contextParameter.getDto());
                DataObject  dataObject          = (DataObject)clazz.newInstance();
                
                for(ContextField field : contextParameter.getField()) {
                    dataObject.set(field.getDtoField(), context.get(field.getName()));
                }
                return dataObject;
            } catch (Throwable e) {
                throw new ProObjectRuntimeException(ProObjectExceptionCode.RUNTIME_OBJECT_CLASS_NOT_FOUND);
            }
        }
        
        return null;
    }
    
    public static DataObject mapFromDataObject(byte[] message, FlowContext context, ContextParameter contextParameter) throws Throwable {
        if(StringUtil.isNotEmpty(contextParameter.getDto())) {
            String      application         = ProObjectThread.getApplication();
            long        globalDeployVersion = ProObject.getGlobalDeployVersion();
            ClassLoader classLoader         = ApplicationManager.getManager(application).getClassLoader(globalDeployVersion).getDataObjectClassLoader();
            Class<?>    clazz               = classLoader.loadClass(contextParameter.getDto() + ProMapperMessageType.JSON.getMessageSuffix());
            Message     dataObjectMsg       = (Message)clazz.newInstance();
            DataObject  dataObject          = dataObjectMsg.unmarshal(message);
            
            for(ContextField field : contextParameter.getField()) {
                context.put(field.getName(), dataObject.get(field.getDtoField()));
            }
            
            return dataObject;
        }
        
        return null;
    }
}
