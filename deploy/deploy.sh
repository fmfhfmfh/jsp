 D:\A_TeachingMaterial\6.JspSpring\workspace\jsp\deploy\deploy.sh

 cd /d/A_TeachingMaterial/6.JspSpring/deploy/jsp
 
 git pull
 
 패키지 초기화
 mvn clean
 
 패키지생성
 mvn package
 
 파일명 변경
 mv ./target/jsp-0.0.1-SNAPSHOT.war ./target/jsp.war
 
 서버 종료
 /d/B_Util/5.ApacheTomcat/apache-tomcat-7.0.73-windows-x64/apache-tomcat-7.0.73/bin/shutdown.sh
 
 rm /d/B_Util/5.ApacheTomcat/apache-tomcat-7.0.73-windows-x64/apache-tomcat-7.0.73/webapps/jsp.war

 rm -rf /d/B_Util/5.ApacheTomcat/apache-tomcat-7.0.73-windows-x64/apache-tomcat-7.0.73/webapps/jsp
 
 cp ./target/jsp.war /d/B_Util/5.ApacheTomcat/apache-tomcat-7.0.73-windows-x64/apache-tomcat-7.0.73/webapps
 
 /d/B_Util/5.ApacheTomcat/apache-tomcat-7.0.73-windows-x64/apache-tomcat-7.0.73/bin/startup.sh
 