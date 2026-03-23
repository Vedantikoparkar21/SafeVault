FROM tomcat:10.0

RUN rm -rf /usr/local/tomcat/webapps/*

COPY SafeVault.war /usr/local/tomcat/webapps/ROOT.war