D:\A_TeachingMaterial\6.JspSpring\workspace\jsp\deploy\deploy.sh //참고만 실행 x

deploy.shell만 실행하면 git에서 다운을받고 package하고 파일이름 바꾸고 톰캣실행 복사 정지 다시실행

 cd/d/A_TeachingMaterial/6.JspSpring/deploy/jsp/
 git pull //최신화
 
 mvn clean	mvn 다지우기
 mvn package mvn 경로 생성
 
 mv ./target/jsp-0.0.1-SNAPSHOT.war ./target/jsp.war 이름 바꾸기
/d/B_Util/5.ApacheTomcat/apache-tomcat-7.0.73/bin/shutdown.sh 서버 끄기
 
 rm /d/B_Util/5.ApacheTomcat/apache-tomcat-7.0.73/webapps/jsp.war 
 rm -rf /d/B_Util/5.ApacheTomcat/apache-tomcat-7.0.73/webapps/jsp //폴더 지우기
  
 cp ./target/jsp.war /d/B_Util/5.ApacheTomcat/apache-tomcat-7.0.73/webapps 폴더에 있는거 복사하기
 /d/B_Util/5.ApacheTomcat/apache-tomcat-7.0.73/bin/startup.sh












