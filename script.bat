cd framework/src

javac -d . annotation/*.java 
javac -d . etu1868/framework/servlet/*.java 
javac -d . etu1868/framework/*.java 
javac -d . utilitaire/*.java 

cd ../

jar cvf framework.jar -C src/ . 

copy "framework.jar" "E:\Workspace\Web Dynamique\Sprint 5\test framework\WEB-INF\lib"

cd ../


cd test framework/WEB-INF/classes/

javac -cp "../lib/framework.jar" -d . classe/*.java
javac -cp "../lib/framework.jar" -d . use/*.java

cd ../../

jar cvf testFramework.war *

copy "testFramework.war" "C:\Program Files\Apache Software Foundation\Tomcat 10.0\webapps"

cd ../



