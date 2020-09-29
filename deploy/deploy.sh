D:\A_TeachingMaterial\6.JspSpring\workspace\jsp\deploy\deploy.sh 

deploy.shell package

 cd /d/A_TeachingMaterial/6.JspSpring/deploy/jsp/
 git pull 
 
 mvn clean	mvn 
 mvn package mvn 
 
 mv ./target/jsp-0.0.1-SNAPSHOT.war ./target/jsp.war 
/d/B_Util/5.ApacheTomcat/apache-tomcat-7.0.73/bin/shutdown.sh 
 
 rm /d/B_Util/5.ApacheTomcat/apache-tomcat-7.0.73/webapps/jsp.war 
 rm -rf /d/B_Util/5.ApacheTomcat/apache-tomcat-7.0.73/webapps/jsp 
  
 cp ./target/jsp.war /d/B_Util/5.ApacheTomcat/apache-tomcat-7.0.73/webapps 
 /d/B_Util/5.ApacheTomcat/apache-tomcat-7.0.73/bin/startup.sh












