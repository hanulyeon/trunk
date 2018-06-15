package com.tmax.flowengine.adapter;

import java.net.SocketAddress;
import java.util.HashMap;
import java.util.Map;

import com.tmax.flowengine.adapter.channel.AdapterChannelEventHandler;
import com.tmax.flowengine.meta.flowgraph.activity.AdapterType;

public class AdapterChannelRepository {
    private String                                          application;
    private AdapterType                                     type;
    private Map<SocketAddress,  AdapterChannelEventHandler> channels        = new HashMap<>();
    private Map<String,         AdapterChannelEventHandler> channelNameMap  = new HashMap<>();
    
    
    public AdapterChannelRepository(String application, AdapterType type) {
        this.application    = application;
        this.type           = type;
    }
    
    @Override
    public String toString() {
        return "[AdapterChannels - " + application + " : " + type.toString() + "]\r\n" + channels.toString();
    }
    
    public void addAdapterChannel(AdapterChannelEventHandler handler) {
        if(channelNameMap.get(handler.getName()) != null) {
            throw new RuntimeException("ADAPTER " + handler.getName() + " IS ALREADY EXIST!");
        }
        channels.put(handler.getRemoteAddress(), handler);
        channelNameMap.put(handler.getName(), handler);
    }
    
    public AdapterChannelEventHandler removeAdapterChannel(SocketAddress address) {
        AdapterChannelEventHandler  handler = getAdapterChannel(address);
        return removeAdapterChannel(handler);
    }
    
    public AdapterChannelEventHandler removeAdapterChannel(String adpaterChannelName) {
        AdapterChannelEventHandler  handler = getAdapterChannel(adpaterChannelName);
        return removeAdapterChannel(handler);
    }
    
    public AdapterChannelEventHandler removeAdapterChannel(AdapterChannelEventHandler handler) {
        if(handler != null) {
            channels.remove(handler.getRemoteAddress());
            return channelNameMap.remove(handler.getName());
        }
        return null;
    }

    public AdapterChannelEventHandler getAdapterChannel(SocketAddress address) {
        return channels.get(address);
    }

    public AdapterChannelEventHandler getAdapterChannel(String adapterChannelName) {
        return channelNameMap.get(adapterChannelName);
    }
}
