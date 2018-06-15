<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<ns4:message
    xmlns:ns2="http://www.tmax.co.kr/proobject/resource"
    xmlns:ns3="http://www.tmax.co.kr/proobject/dataobject"
    xmlns:ns4="http://www.tmax.co.kr/proobject/message"
    xmlns:ns5="http://www.tmax.co.kr/proobject/dto"
    xmlns:ns6="http://www.tmax.co.kr/proobject/dbio-config"
    xmlns:ns7="http://www.example.org/externalObjectConfig"
    xmlns:ns8="http://www.tmax.co.kr/proobject/property"
    xmlns:ns9="http://www.tmax.co.kr/proobject/siteConfig"
    resourcePath="com/tmax/flowengine/adapter/dto"
    dtoName="FlowEngineMessage"
    dtoPath="com/tmax/flowengine/adapter/dto"
    logicalName="FlowEngineMessageMsgJson"
    physicalName="FlowEngineMessageMsgJson"
    messageType="JSON"
    trimFlag="RTRIM"
    resourceType="MESSAGE"
>
    <ns4:messageField fieldType="long"      logicalName="guid"          physicalName="guid"         includeMessagePath="" includeMessageName="" length="16" array="" comments="" metaId="" referencedtoName="UnDeployInnerInfo" align="NONE" fill="" decimal="-1" point="true" sign="false" bitmapNo="" delimiter="" handler="" encodeOption="CHAR" attributeTag="" referenceFieldId="" fieldControlTag="" trimFlag="DEFAULT" dateFormat=""/>
    <ns4:messageField fieldType="long"      logicalName="sessionId"     physicalName="sessionId"    includeMessagePath="" includeMessageName="" length="16" array="" comments="" metaId="" referencedtoName="UnDeployInnerInfo" align="NONE" fill="" decimal="-1" point="true" sign="false" bitmapNo="" delimiter="" handler="" encodeOption="CHAR" attributeTag="" referenceFieldId="" fieldControlTag="" trimFlag="DEFAULT" dateFormat=""/>
    <ns4:messageField fieldType="long"      logicalName="flowId"        physicalName="flowId"       includeMessagePath="" includeMessageName="" length="16" array="" comments="" metaId="" referencedtoName="UnDeployInnerInfo" align="NONE" fill="" decimal="-1" point="true" sign="false" bitmapNo="" delimiter="" handler="" encodeOption="CHAR" attributeTag="" referenceFieldId="" fieldControlTag="" trimFlag="DEFAULT" dateFormat=""/>
    <ns4:messageField fieldType="boolean"   logicalName="sync"          physicalName="sync"         includeMessagePath="" includeMessageName="" length="1"  array="" comments="" metaId="" referencedtoName="UnDeployInnerInfo" align="NONE" fill="" decimal="-1" point="true" sign="false" bitmapNo="" delimiter="" handler="" encodeOption="CHAR" attributeTag="" referenceFieldId="" fieldControlTag="" trimFlag="DEFAULT" dateFormat=""/>
    <ns4:messageField fieldType="String"    logicalName="message"       physicalName="message"      includeMessagePath="" includeMessageName="" length="16" array="" comments="" metaId="" referencedtoName="UnDeployInnerInfo" align="NONE" fill="" decimal="-1" point="true" sign="false" bitmapNo="" delimiter="" handler="" encodeOption="CHAR" attributeTag="" referenceFieldId="" fieldControlTag="" trimFlag="DEFAULT" dateFormat=""/>
</ns4:message>
