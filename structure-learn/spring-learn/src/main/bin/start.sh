#!/bin/sh
#
# ---------------------------------------------------------------------
# Java Application startup script.
# ---------------------------------------------------------------------
#

#UNAME=`which uname`
#CURRENT_USER=`whoami`
#REQUIRED_USER=admin
#if [ "$REQUIRED_USER" != "$CURRENT_USER" ]; then
#  echo "Ops. This application must run as user: $REQUIRED_USER , not $CURRENT_USER . Please check your login USER (cmd: whoami)."
#  exit 1
#fi

# ---------------------------------------------------------------------
# Ensure workspace location installed & Locate a JDK installation directory
# ---------------------------------------------------------------------
SCRIPT_LOCATION=$0
cd "`dirname "$SCRIPT_LOCATION"`"
BIN_HOME=`pwd`
WORKSPACE_HOME=`dirname "$BIN_HOME"`
cd "$OLDPWD"

JAVA_BIN=`which java`
if ! [ -x "$(command -v $JAVA_BIN)" ]; then
  echo "No JAVA command found. Please validate environment variable points to valid JDK installation."
  exit 1
fi
echo "java path:$JAVA_BIN"

JAVA_VERSION=$("$JAVA_BIN" -version 2>&1 >/dev/null | grep 'version' | awk '{print $3}')
echo "Java version is : $JAVA_VERSION"
if [[ "$JAVA_VERSION" > "1.7" ]]; then
        echo "Ok, Java version higher than 1.7"
    else
        echo "Ops, Java version too low."
        exit 1
fi

VM_OPTION="$SGM_OPTS -Xms2560m -Xmx3768m -Xss256M -XX:+UseParallelGC"
CLASSPATH="$WORKSPACE_HOME/conf:$WORKSPACE_HOME/lib/*:$HADOOP_CONF_DIR/*:$HADOOP_HOME/share/hadoop/common/lib/*:$HADOOP_HOME/share/hadoop/common/*:$HADOOP_HOME/share/hadoop/hdfs/lib/*:$HADOOP_HOME/share/hadoop/hdfs/*:$HADOOP_HOME/share/hadoop/yarn/lib/*:$HADOOP_HOME/share/hadoop/yarn/*:$HADOOP_HOME/share/hadoop/mapreduce/lib/*:$HADOOP_HOME/share/hadoop/mapreduce/*:$HADOOP_HOME/share/hadoop/tools/lib/*"

if [ "$1" == "--debug" ]; then
    VM_OPTION="$VM_OPTION -agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=8000"
else
    shift
fi
# ---------------------------------------------------------------------
# Run the APP.
# ---------------------------------------------------------------------
"$JAVA_BIN" \
  -classpath "$CLASSPATH" \
  ${VM_OPTION} \
  "-Djb.vmOptionsFile=$VM_OPTIONS_FILE" \
  com.jd.bdp.adhoc.SyncJobApplication \
  "$@" \
  >> "${WORKSPACE_HOME}/logs/system-$1.out" 2>&1 &
