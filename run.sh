#!/bin/bash

javac -classpath "src:lib/sqlite-jdbc-3.23.1.jar" src/hellosqlite3/HelloSQLite3.java
java -classpath "src:lib/sqlite-jdbc-3.23.1.jar" hellosqlite3.HelloSQLite3
