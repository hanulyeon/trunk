#!/bin/bash

## @Description
## script for Update servicegroup.xml for PO, Update JARs for PO, Reboot ProObject7 Server

#########################################################################
######################## SET JEUS ID, JEUS PW ###########################
JEUS_ID="jeus" #JEUS administrator ID
JEUS_PW="jeus" #JEUS administrator password
JEUS_PO_WEB_SERVER_NAME="ProObject7"
#########################################################################


#CHECK SCRIPT EXECUTION OPTION
while test $# != 0; do
    arg=$1
    case "$arg" in
        -s|--serverName)
            shift
            JUES_PO_WEB_SERVER_NAME="$1"
            echo "TARGET SERVER_NAME : $JUES_PO_WEB_SERVER_NAME"
            ;;
        *)
            echo "Invalid option '$arg'"
            exit 1
            ;;
    esac
    shift
done


echo "------------------------------------------------------"
echo "                 CHECK EVN VARs ...                   "
echo "------------------------------------------------------"
#CHECK ENV VARs
if [ -n "$HD_HOME" ]; then
    HD_HOME=$HD_HOME
    echo "HD_HOME: $HD_HOME"
else
    HD_HOME=$(pwd)/../../..
    echo "HD_HOME: $HD_HOME"
    #echo "HD_HOME not found"; exit
fi

if [ -n "$PROOBJECT_HOME" ]; then
    PROOBJECT_HOME=$PROOBJECT_HOME
    echo "PROOBJECT_HOME is $PROOBJECT_HOME"
else
    echo "PO_HOME not found"; exit
fi

#SET WEB_SERVER_HOME
HD_WS_HOME=$HD_HOME/modules/web-server

#SET VERSION
VERSION=1.0

#SET JAR NAME
COMMON="hyperdata-common-"$VERSION".jar"
UI_SERVICE="hyperdata-ui-service-"$VERSION".jar"
UI_SERVICE_DTO="hyperdata-ui-service-dto-"$VERSION".jar"

#SET CONFIG NAME
UI_SERVICE_SERVICEGROUP_CONFIG="servicegroup.xml"

#SET PO PATHs
PO_COMMON_PATH="$PROOBJECT_HOME/application/common/lib"
PO_UI_SERVICE_PATH="$PROOBJECT_HOME/application/servicegroup/ui-service"
PO_UI_SERVICE_DTO_PATH="$PROOBJECT_HOME/application/servicegroup/ui-service/dto"
PO_UI_SERVICE_SERVICEGROUP_CONFIG_PATH="$PO_UI_SERVICE_PATH/config"

#SET WEB_SERVER PATH
COMMON_PATH="$HD_WS_HOME/modules/common"
UI_SERVICE_PATH="$HD_WS_HOME/modules/servicegroup/ui-service"
UI_SERVICE_SERVICEGROUP_CONFIG_PATH="$HD_WS_HOME/modules/servicegroup/ui-service/config"

echo "------------------------------------------------------"
echo "                  JAR UPDATING ...                    "
echo "------------------------------------------------------"

echo "[$COMMON]"
cp $COMMON_PATH/target/dist/* $PO_COMMON_PATH/$COMMON && echo "... success" || (echo "... fail"; exit)

echo "[$UI_SERVICE]"
cp $UI_SERVICE_PATH/target/dist/* $PO_UI_SERVICE_PATH/$UI_SERVICE && echo "... success" || (echo "... fail"; exit)

echo "[$UI_SERVICE_DTO]"
cp $UI_SERVICE_PATH/target/dist/* $PO_UI_SERVICE_DTO_PATH/$UI_SERVICE_DTO && echo "... success" || (echo "... fail"; exit)

echo "------------------------------------------------------"
echo "                  Config UPDATING...                  "
echo "------------------------------------------------------"

echo "[UI-SERVICE $UI_SERVICE_CONFIG]"
cp $UI_SERVICE_SERVICEGROUP_CONFIG_PATH/$UI_SERVICE_SERVICEGROUP_CONFIG $PO_UI_SERVICE_SERVICEGROUP_CONFIG_PATH/$UI_SERVICE_SERVICEGROUP_CONFIG && echo "... success" || (echo "... fail"; exit)


#JEUS BOOT CHECK
## JEUS_HOME
echo "checking JEUS_HOME..."
if [ -n "$JEUS_HOME" ]; then
    JEUS_HOME=$JEUS_HOME
    echo "JEUS_HOME: $JEUS_HOME"
else
    echo "\$JEUS_HOME not found"; exit
fi

fn_check_status_node_manager(){
    echo "checking NodeManager..."
    pid=$(jps | grep -w NodemanagerBootstrapper| awk '{print $1}')
    if [ -z $pid ]; then
        cd $JEUS_HOME/bin
        ./startNodeManager &
    else
        echo "JEUS 8 NodeManager (RUNNING, pid:"$pid")"
    fi
}


echo "------------------------------------------------------"
echo "           reboot JEUS PO WEB SERVER...               "
echo "------------------------------------------------------"

fn_check_status_node_manager

# BOOT PO WEB SERVER
$JEUS_HOME/bin/jeusadmin -u $JEUS_ID -p $JEUS_PW << EOF 
stop-server $JEUS_PO_WEB_SERVER_NAME
EOF

$JEUS_HOME/bin/jeusadmin -u $JEUS_ID -p $JEUS_PW << EOF 
start-server $JEUS_PO_WEB_SERVER_NAME
EOF

cd $HD_WS_HOME




