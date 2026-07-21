package io.github.mgdiogo.huntertracker;

import com.google.inject.Provides;
import javax.inject.Inject;

import io.github.mgdiogo.huntertracker.panel.HunterTrackerPanel;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.util.ImageUtil;
import java.awt.image.BufferedImage;

@Slf4j
@PluginDescriptor(
	name = "Hunter Tracker"
)
public class HunterTrackerPlugin extends Plugin
{
	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	private HunterTrackerConfig config;

	private HunterTrackerPanel panel;
	private NavigationButton navigationButton;

	@Override
	protected void startUp() throws Exception
	{
		log.debug("Hunter Tracker started!");

		panel = new HunterTrackerPanel();

		navigationButton = NavigationButton.builder()
				.tooltip("Hunter Tracker")
				.icon(loadIcon())
				.priority(5)
				.panel(panel)
				.build();

		clientToolbar.addNavigation(navigationButton);
	}

	@Override
	protected void shutDown() throws Exception
	{
		log.debug("Hunter Tracker stopped!");

		clientToolbar.removeNavigation(navigationButton);

		navigationButton = null;
		panel = null;
	}

	@Provides
	HunterTrackerConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(HunterTrackerConfig.class);
	}

	private BufferedImage loadIcon() {
		return ImageUtil.loadImageResource(getClass(), "/huntertracker.png");
	}
}
