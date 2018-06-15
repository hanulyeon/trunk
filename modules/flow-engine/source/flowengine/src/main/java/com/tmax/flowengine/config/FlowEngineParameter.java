package com.tmax.flowengine.config;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.Map;

import com.tmax.proobject.core.config.Changed;
import com.tmax.proobject.core.config.ParameterBuilder;
import com.tmax.proobject.core.config.ParameterMessageBundle;
import com.tmax.proobject.core.config.ProObjectParameter;

public class FlowEngineParameter extends ProObjectParameter {
    private static final long serialVersionUID = -3206369446855147453L;
    
    
    public static enum FlowEngineParameterKey implements ParameterKey {
        @Deprecated //사용 중지된 Property
        APPLICATION_DEPRECATED(
                new ParameterBuilder("APPLICATION_DEPRECATED")),
        
        @Changed(recommend="RECOMMEND_PROPERTY")//변경 추천시
        FLOWENGINE_CHANGED(
                new ParameterBuilder("FLOWENGINE_CHANGED")),
        
        FLOWENGINE_DATA_ARRAY_RIGHT(//Value가 한정된 경우
                new ParameterBuilder("FLOWENGINE_DATA_ARRAY_RIGHT")
                .addDataArray(new String[]{"A", "B", "C"})),
        
        FLOWENGINE_DATA_RANGE_RIGHT(//Value의 범위 지정(min, max, step)-int만 지원
                new ParameterBuilder("FLOWENGINE_DATA_RANGE_RIGHT")
                .addDataRange("10", "100", "10")),
        
        FLOWENGINE_HIDDEN(//사용자에게 감춰야하는 설정- 로그에 안나옴.
                new ParameterBuilder("FLOWENGINE_HIDDEN")
                .addHiddenKey(true)),
        /**
         *  <h1>[Configuration Information]</h1>
         *  <ul>
         *      <li><b>Key</b> : FLOWENGINE_ADAPTER_READ_BUFFER_SIZE</li>
         *      <li><b>Dynamic</b> : false</li>
         *      <li><b>Default</b> : 4096 (4KB)</li>
         *      <li><b>Value Range</b> : Positive Integer (Unit : Byte)</li>
         *      <li><b>Configured by</b> : FlowEngine Manager</li>
         *  </ul>
         *  <h1><b>[Description]</b></h1>
         *  FlowEngine 에서 사용하는 Adapter 의 기본 Read Buffer 의 크기를 지정합니다.
         */
        FLOWENGINE_ADAPTER_READ_BUFFER_SIZE(
                new ParameterBuilder("FLOWENGINE_ADAPTER_READ_BUFFER_SIZE")
                .addDefaultValue("4096")),
        /**
         *  <h1>[Configuration Information]</h1>
         *  <ul>
         *      <li><b>Key</b> : FLOWENGINE_ADAPTER_WRITE_BUFFER_SIZE</li>
         *      <li><b>Dynamic</b> : false</li>
         *      <li><b>Default</b> : 4096 (4KB)</li>
         *      <li><b>Value Range</b> : Positive Integer (Unit : Byte)</li>
         *      <li><b>Configured by</b> : FlowEngine Manager</li>
         *  </ul>
         *  <h1><b>[Description]</b></h1>
         *  FlowEngine 에서 사용하는 Adapter 의 기본 Write Buffer 의 크기를 지정합니다.
         */
        FLOWENGINE_ADAPTER_WRITE_BUFFER_SIZE(
                new ParameterBuilder("FLOWENGINE_ADAPTER_WRITE_BUFFER_SIZE")
                .addDefaultValue("4096"));
        
        
        private String key;
        private String defaultValue;
        private String[] dataArray;
        private Map<String, String> dataRangeMap;
        private ParameterBuilder builder;
        
        
        private FlowEngineParameterKey(ParameterBuilder builder) {
            this.key = builder.getKey();
            this.defaultValue = builder.getDefaultValue();
            this.dataArray = builder.getDataArray();
            this.dataRangeMap = builder.getDataRangeMap();
            this.builder = builder;
        }
        
        @Override
        public String getKey() {
            return key;
        }
        
        @Override
        public String getKey(String ... arguments) {
            String value = MessageFormat.format(key, (Object[])arguments);
            return value;
        }
        
        @Override
        public String getDefaultValue() {
            return defaultValue;
        }

        @Override
        public boolean hasDefaultValue() {
            return defaultValue != null;
        }

        @Override
        public String getDescription(ParameterKey key) {
            return ParameterMessageBundle.getMessage(key.toString());
        }

        @Override
        public String getDescription(ParameterKey key, Locale locale) {
            return ParameterMessageBundle.getMessage(key.toString(), locale);
        }

        @Override
        public String[] getDataArray() {
            return this.dataArray;
        }

        @Override
        public Map<String, String> getDataRangeMap() {
            return this.dataRangeMap;
        }

        @Override
        public ParameterBuilder getParameterBuilder() {
            return this.builder;
        }
    }
    
    
    
    
    
    public FlowEngineParameter(String parameterPath) {
        super(parameterPath);
    }
        
    public int getAdapterReadBufferSize() {
        String value = getProperty(FlowEngineParameterKey.FLOWENGINE_ADAPTER_READ_BUFFER_SIZE);
        return Integer.parseInt(value);
    }

    public int getAdapterWriteBufferSize() {
        String value = getProperty(FlowEngineParameterKey.FLOWENGINE_ADAPTER_WRITE_BUFFER_SIZE);
        return Integer.parseInt(value);
    }
}
