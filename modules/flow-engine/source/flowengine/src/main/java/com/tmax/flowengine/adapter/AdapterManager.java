package com.tmax.flowengine.adapter;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tmax.flowengine.adapter.channel.AdapterAcceptHandler;
import com.tmax.flowengine.adapter.channel.AdapterChannelEventHandler;
import com.tmax.flowengine.manager.FlowEngineManager;
import com.tmax.flowengine.meta.flowgraph.activity.AdapterType;
import com.tmax.proobject.config.channel.ChannelAcceptHandlerConfig;
import com.tmax.proobject.config.channel.ServerChannel;
import com.tmax.proobject.model.channelevent.ChannelHandlable;
import com.tmax.proobject.network.manager.ChannelManager;
import com.tmax.proobject.network.manager.application.ApplicationChannelManager;
import com.tmax.proobject.util.concurrency.ProObjectThread;

public class AdapterManager {
    public static void registerAdapter(AdapterType adapterType, AdapterChannelEventHandler handler) {
        AdapterManager manager = FlowEngineManager.getManager(ProObjectThread.getApplication()).getAdapterManager();
        manager.addAdapterHandler(adapterType, handler);
    }
    
    public static void unregisterAdapter(AdapterChannelEventHandler handler) {
        AdapterManager manager = FlowEngineManager.getManager(ProObjectThread.getApplication()).getAdapterManager();
        manager.removeAdapterHandler(handler);
    }
    
    public static AdapterChannelEventHandler getAdapter(AdapterType adapterType, String ip, int port) {
        AdapterManager      manager = FlowEngineManager.getManager(ProObjectThread.getApplication()).getAdapterManager();
        return manager.getAdapterHandler(adapterType, ip, port);
    }

    public static ChannelHandlable getAdapter(AdapterType adapterType, String name) {
        AdapterManager      manager = FlowEngineManager.getManager(ProObjectThread.getApplication()).getAdapterManager();
        return manager.getAdapterHandler(adapterType, name);
    }
    
    
    
    
    
    private String                                      application         = null;
    private int                                         port                = -1;
    private Map<AdapterType, AdapterChannelRepository>  adapters            = new HashMap<>();
    private Map<AdapterType, Integer>                   adapterLoadBalancer = new HashMap<>();
    
    
    public AdapterManager(String application, int port) {
        this.application    = application;
        this.port           = port;
        
        if(port > 0) {
            ApplicationChannelManager   channelManager  = ChannelManager.getProviderChannelManager().getApplicationChannelManager(application);
            ChannelAcceptHandlerConfig  accepter        = new ChannelAcceptHandlerConfig();
            accepter.setName(AdapterAcceptHandler.class.getSimpleName());
            accepter.setClassName(AdapterAcceptHandler.class.getName());
            channelManager.addChannelAcceptHandlerConfig(accepter);
            
            List<ServerChannel> serverChannels  = channelManager.getChannelConfig().getServerChannel();
            ServerChannel       accepterChannel = new ServerChannel();
            accepterChannel.setAcceptHandler(AdapterAcceptHandler.class.getSimpleName());
            accepterChannel.setPort(port);
            serverChannels.add(accepterChannel);
        }
    }
    
    public void addAdapterHandler(AdapterType adapterType, AdapterChannelEventHandler handler) {
        AdapterChannelRepository    repository  = adapters.get(adapterType);
        if(repository == null) {
            repository  = new AdapterChannelRepository(getApplication(), adapterType);
            
            adapters.put(adapterType, repository);
            adapterLoadBalancer.put(adapterType, 0);
        }
        repository.addAdapterChannel(handler);
    }

    public AdapterChannelEventHandler removeAdapterHandler(AdapterChannelEventHandler handler) {
        AdapterChannelRepository    repository  = adapters.get(handler.getType());
        if(repository != null) {
            return repository.removeAdapterChannel(handler);            
        }
        return null;
    }
    
    public AdapterChannelEventHandler getAdapterHandler(AdapterType adapterType, String ip, int port) {
        AdapterChannelRepository    repository  = adapters.get(adapterType);
        InetSocketAddress           address     = new InetSocketAddress(ip, port);
        if(repository == null) {
            repository  = new AdapterChannelRepository(getApplication(), adapterType);
            adapters.put(adapterType, repository);
        }
        
        AdapterChannelEventHandler handler =  repository.getAdapterChannel(address);
        return handler;
    }
    
    private AdapterChannelEventHandler getAdapterHandler(AdapterType adapterType, String name) {
        AdapterChannelRepository    repository  = adapters.get(adapterType);
        if(repository == null) {
            repository  = new AdapterChannelRepository(getApplication(), adapterType);
            adapters.put(adapterType, repository);
        }
        
        AdapterChannelEventHandler handler =  repository.getAdapterChannel(name);
        return handler;
    }
    
    public String getApplication() {
        return application;
    }
    
    public int getPort() {
        return port;
    }
}
