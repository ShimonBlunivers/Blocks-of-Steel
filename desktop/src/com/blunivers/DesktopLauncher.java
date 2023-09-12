package com.blunivers;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.blunivers.source.GamePanel;
import com.blunivers.source.config.Settings;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
   public static void main (String[] arg) {
      Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
      config.setTitle("Blocks of Steel");
      config.setWindowedMode(Settings.screenWidth, Settings.screenHeight);
      config.useVsync(true);
      config.setForegroundFPS(Settings.FPS);
      config.setWindowIcon("icon.png");

      new Lwjgl3Application(new GamePanel(), config);
   }
}
