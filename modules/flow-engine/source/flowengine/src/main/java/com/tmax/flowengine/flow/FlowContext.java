package com.tmax.flowengine.flow;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tmax.flowengine.manager.FlowEngineManager;
import com.tmax.flowengine.meta.flow.context.FlowContextMeta;
import com.tmax.flowengine.meta.flow.context.FlowVariable;
import com.tmax.flowengine.meta.flow.context.FlowVariableContainer;
import com.tmax.flowengine.meta.flow.context.FlowVariableType;
import com.tmax.proobject.util.StringUtil;

public class FlowContext extends HashMap<String, Object> {
    private static final long serialVersionUID = 0xBEEF;
    
    
    
    
    
    private FlowContext() {
    }

    public FlowContext(FlowContextMeta meta) {
        if(meta != null) {
            initObject(this, meta.getVariables());
        }
    }
    
    private void initObject(Map<String, Object> target, FlowVariableContainer variables) {
        if(variables != null) {
            initVariable(target, variables.getVariable());
        }
    }
    
    private void initVariable(Map<String, Object> target, List<FlowVariable> variables) {
        try {
            for(FlowVariable variable : variables) {
                FlowVariableType    type            = variable.getType();
                String              defaultValue    = variable.getDefault();
                switch(type) {
                    case BIG_DECIMAL :
                        target.put(variable.getName(), new BigDecimal(defaultValue));
                        break;
                    case BIG_INTEGER :
                        target.put(variable.getName(), new BigInteger(defaultValue));
                        break;
                    case BOOLEAN :
                        target.put(variable.getName(), new Boolean(defaultValue));
                        break;
                    case BYTE :
                        target.put(variable.getName(), new Byte(defaultValue));
                        break;
                    case FLOAT :
                        target.put(variable.getName(), new Float(defaultValue));
                        break;
                    case DOUBLE :
                        target.put(variable.getName(), new Double(defaultValue));
                        break;
                    case DATE :
                        // * TODO : DATE 처리를 진행하시면 됩니다 (~'_')~
                        break;
                    case INT :
                        target.put(variable.getName(), new Integer(defaultValue));
                        break;
                    case LONG :
                        target.put(variable.getName(), new Long(defaultValue));
                        break;
                    case SHORT :
                        target.put(variable.getName(), new Short(defaultValue));
                        break;
                    case STRING :
                        target.put(variable.getName(), defaultValue);
                        break;
                    case TIMESTAMP :
                        break;
                    case OBJECT :
                    {
                        FlowContext childObject = new FlowContext();
                        target.put(variable.getName(), childObject);
                        initObject(childObject, variable.getVariable());
                        break;
                    }
                    case USER_DEFINED :
                    {
                        Object object = FlowEngineManager.getManager().getClassLoader().loadClass(variable.getUserDefinedClass()).newInstance();
                        target.put(variable.getName(), object);
                        break;
                    }
                    default :
                        throw new RuntimeException("INVALID VARIABLE TYPE!");
                }
            }
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public Object put(String key, Object value) {
        if(key.contains(".")) {
            FlowContext targetContext   = this;
            String[]    fields          = StringUtil.split(key, ".");
            String      finalField      = fields[fields.length-1];
            
            for(int i=0; i<fields.length-1; i++) {
                String objectFieldName  = fields[i];
                targetContext           = (FlowContext)targetContext.get(objectFieldName);
            }
            return targetContext.put(finalField, value);
        }
        
        return super.put(key, value);
    }
    
    @Override
    public Object get(Object key) {
        String keyName = key.toString();
        
        if(keyName.contains(".")) {
            FlowContext targetContext   = this;
            String[]    fields          = StringUtil.split(keyName, ".");
            String      finalField      = fields[fields.length-1];
            
            for(int i=0; i<fields.length-1; i++) {
                String objectFieldName  = fields[i];
                targetContext   = (FlowContext)targetContext.get(objectFieldName);
            }
            return targetContext.get(finalField);
        }
        
        return super.get(keyName);
    }
}
