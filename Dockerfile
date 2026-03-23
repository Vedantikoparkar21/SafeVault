FROM tomcat:10.0

COPY SafeVault.war /usr/local/tomcat/webapps/

EXPOSE 8080