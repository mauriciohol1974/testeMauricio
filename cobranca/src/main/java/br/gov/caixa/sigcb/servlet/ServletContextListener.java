package br.gov.caixa.sigcb.servlet;

import javax.servlet.ServletContextEvent;

import org.apache.log4j.xml.DOMConfigurator;

import br.com.politec.sao.util.ServiceLocator;
import br.com.politec.sao.util.WrappingException;
import br.gov.caixa.sigcb.util.LogUtilSigcb;

public class ServletContextListener implements
        javax.servlet.ServletContextListener {

    public void contextInitialized(ServletContextEvent arg0) {

        // Carrega as configurações do log4j
        try {
            String configFile = ServiceLocator.getInstance()
                    .getString("java:comp/env/configLog4J");
            DOMConfigurator.configure(configFile);
        } catch (WrappingException we) {
            System.out.println("LogUtilSigcb: Nao foi possivel encontrar arquivo de configuracao log4j");
        }

        LogUtilSigcb.info("ServletContextListener.contextInitialized(ServletContextEvent arg0)");

    }

    public void contextDestroyed(ServletContextEvent arg0) {

        LogUtilSigcb.info("ServletContextListener.contextDestroyed(ServletContextEvent arg0)");

    }

}
