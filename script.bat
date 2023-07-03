cd Framework/src
javac -d . annotation/*.java
javac -d . utilitaire/*.java
javac -d . etu1868/framework/*.java
javac -d . etu1868/framework/servlet/*.java
cd ../../
jar cvf Framework.jar -C Framework/src/ .
copy "Framework.jar" "Test_Framework/WEB-INF/lib/"
cd "Test_Framework/WEB-INF/classes/"
javac -cp "../lib/Framework.jar" -d . model/*.java
cd ../../
jar cvf Test_Framework.war *
copy "Test_Framework.war" "C:\Program Files\Apache Software Foundation\Tomcat 10.0\webapps"
cd ../


