package io.github.mgdiogo.huntertracker;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor(
	name = "Hunter Tracker"
)
public class HunterTrackerPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private HunterTrackerConfig config;

	@Override
	protected void startUp() throws Exception
	{
		log.debug("Hunter Tracker started!");
	}

	@Override
	protected void shutDown() throws Exception
	{
		log.debug("Hunter Tracker stopped!");
	}

	@Provides
	HunterTrackerConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(HunterTrackerConfig.class);
	}
}
