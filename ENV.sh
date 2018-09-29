#!/usr/bin/env bash

JDK="/home/pulpo/herramientas/jdk/jdk1.8.0_162"
MAVEN="/home/pulpo/herramientas/maven/apache-maven-3.5.0"

# JAVA
JAVA_HOME=$JDK
PATH=$JAVA_HOME/bin:$PATH

# Maven
MAVEN_HOME=$MAVEN
PATH=$MAVEN_HOME/bin:$PATH

# PS1
YELLOW='\e[33m'
DEFAULT='\e[39m'
PS1="$YELLOW(DyASC)$DEFAULT $PS1"

# Source additional script
ADDITIONAL_SCRIPT='.envrc'
if [[ -f $ADDITIONAL_SCRIPT ]]; then
    . $ADDITIONAL_SCRIPT
fi
