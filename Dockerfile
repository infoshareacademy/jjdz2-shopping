FROM jboss/wildfly:10.1.0.Final

ADD target/ROOT.war /opt/jboss/wildfly/standalone/deployments/