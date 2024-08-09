package com.labs.digital.aval.demoMobile.runner;
import com.labs.digital.aval.demoMobile.exception.LambdatestException;
import com.lambdatest.tunnel.Tunnel;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;
import org.openqa.selenium.JavascriptExecutor;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TunnelLambdatest {
    private TunnelLambdatest() {}

   static EnvironmentVariables vars = SystemEnvironmentVariables.createEnvironmentVariables();
    private static Tunnel tunnel;
    static boolean  excet = false;


    public  static void starTunnel() {


        EnvironmentVariables vars = SystemEnvironmentVariables.createEnvironmentVariables();
        if (vars.activeEnvironments().stream().iterator().next().contains("lambdatest") && !excet) {
                try {
                    tunnel = new Tunnel();

                    HashMap<String, String> confTunnel = new HashMap<>();
                    confTunnel.put("user", EnvironmentSpecificConfiguration.from(vars).getProperty("appium.user"));
                    confTunnel.put("key", EnvironmentSpecificConfiguration.from(vars).getProperty("appium.accessKey"));
                    String tunnelName = EnvironmentSpecificConfiguration.from(vars).getProperty("appium.tunnelName");
                    confTunnel.put("tunnelName", tunnelName);
                    excet = tunnel.start(confTunnel);
                    Logger.getAnonymousLogger().log(Level.INFO, "Se inicia el tunnel: {0}", tunnelName);

                } catch (Exception e) {
                    throw new LambdatestException();
                }

        }
    }
    public static void stopTunnel()  {

       try {
           if(tunnel != null) {
               tunnel.stopTunnel();
               Logger.getAnonymousLogger().info("Se apaga el tunnel");
           }
       }catch (Exception e)
       {
           throw new LambdatestException();
       }
    }

    public static void updateStatusAndNameCase(String item, String itenname) {

        if (vars.activeEnvironments().stream().iterator().next().contains("lambdatest")&& Boolean.parseBoolean(EnvironmentSpecificConfiguration.from(vars).getProperty("isFarmExecution"))) {
                ((JavascriptExecutor) Serenity.getDriver()).executeScript(item + itenname);

        }
    }
}

