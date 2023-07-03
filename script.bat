cd framework/src

javac -d . annotation/*.java 
javac -d . etu1868/framework/servlet/*.java 
javac -d . etu1868/framework/*.java 
javac -d . etu1868/framework/servlet/*.java
javac -d . utilitaire/*.java 

cd ../

jar cvf framework.jar -C src/ . 

copy "framework.jar" "E:\Workspace\Web Dynamique\Sprint 6\test framework\WEB-INF\lib"

cd ../


cd test framework/WEB-INF/classes/

javac -cp "../lib/framework.jar" -d . model/*.java
javac -cp "../lib/framework.jar" -d . use/*.java

cd ../../

jar cvf test_Framework.war *

copy "test_Framework.war" "C:\Program Files\Apache Software Foundation\Tomcat 10.0\webapps"

cd ../



