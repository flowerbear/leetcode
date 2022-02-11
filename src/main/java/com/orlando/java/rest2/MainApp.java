package com.orlando.java.rest2;

import org.slf4j.bridge.SLF4JBridgeHandler;
import org.eclipse.jetty.server.Server;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainApp {

  public static final URI BASE_URI = URI.create("http://localhost:8080");

  static {
    Logger.getLogger("").setLevel(Level.FINEST);
    SLF4JBridgeHandler.removeHandlersForRootLogger();
    SLF4JBridgeHandler.install();
  }

  public static Server startHttpServer() {
    final ResourceConfig config = new ResourceConfig();

    config.register(JsonResource.class);

    return JettyHttpContainerFactory.createServer(BASE_URI, config);
  }

  public static void main(String[] args) throws Exception {

    try {
      final Server server = startHttpServer();

      server.start();

      Runtime.getRuntime().addShutdownHook(
        new Thread(() -> {
          try {
            server.stop();
          } catch (Exception e) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, e);
          }
        })
      );

      System.out.println(String.format("Application started.%nStop the application using CTRL+C"));
      Thread.currentThread().join();
    } catch (InterruptedException | IOException e) {
      Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, e);
    }
  }
}
