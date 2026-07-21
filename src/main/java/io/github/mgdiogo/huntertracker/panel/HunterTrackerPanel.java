package io.github.mgdiogo.huntertracker.panel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.shadowlabel.JShadowedLabel;

public class HunterTrackerPanel extends PluginPanel
{
    private final JLabel statusValue = createValueLabel("Idle");
    private final JLabel hunterLevelValue = createValueLabel("--");
    private final JLabel hunterXpValue = createValueLabel("--");
    private final JLabel xpToNextLevelValue = createValueLabel("--");
    private final JLabel targetCreatureValue = createValueLabel("None selected");
    private final JLabel catchesValue = createValueLabel("0");
    private final JLabel xpGainedValue = createValueLabel("0");
    private final JLabel xpPerHourValue = createValueLabel("--");
    private final JLabel etaValue = createValueLabel("--");

    public HunterTrackerPanel()
    {
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setBackground(ColorScheme.DARK_GRAY_COLOR);

        content.add(createHeader());
        content.add(Box.createRigidArea(new Dimension(0, 10)));
        content.add(createStatusSection());
        content.add(Box.createRigidArea(new Dimension(0, 8)));
        content.add(createHunterSection());
        content.add(Box.createRigidArea(new Dimension(0, 8)));
        content.add(createTargetSection());
        content.add(Box.createRigidArea(new Dimension(0, 8)));
        content.add(createSessionSection());
        content.add(Box.createVerticalGlue());

        add(content, BorderLayout.NORTH);
    }

    private JPanel createHeader()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(ColorScheme.DARK_GRAY_COLOR);
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JShadowedLabel title = new JShadowedLabel("Hunter Tracker");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel version = new JLabel("Version 0.1.0");
        version.setForeground(ColorScheme.LIGHT_GRAY_COLOR);
        version.setAlignmentX(Component.CENTER_ALIGNMENT);
        version.setHorizontalAlignment(SwingConstants.CENTER);

        panel.add(title);
        panel.add(Box.createRigidArea(new Dimension(0, 3)));
        panel.add(version);

        return panel;
    }

    private JPanel createStatusSection()
    {
        JPanel section = createSection("Status");
        section.add(createSingleValueRow(statusValue));

        return section;
    }

    private JPanel createSection(String title)
    {
        JPanel section = new JPanel();
        section.setLayout(new BoxLayout(section, BoxLayout.Y_AXIS));
        section.setBackground(ColorScheme.DARKER_GRAY_COLOR);
        section.setBorder(new EmptyBorder(8, 8, 8, 8));
        section.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel titleLabel = new JLabel(title);
        titleLabel.setForeground(ColorScheme.BRAND_ORANGE);
        titleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        section.add(titleLabel);
        section.add(Box.createRigidArea(new Dimension(0, 5)));

        return section;
    }

    private JPanel createRow(String name, JLabel valueLabel)
    {
        JPanel row = new JPanel(new BorderLayout());
        row.setBackground(ColorScheme.DARKER_GRAY_COLOR);
        row.setAlignmentX(Component.LEFT_ALIGNMENT);
        row.setMaximumSize(new Dimension(Integer.MAX_VALUE, 22));

        JLabel nameLabel = new JLabel(name);
        nameLabel.setForeground(ColorScheme.LIGHT_GRAY_COLOR);

        valueLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        row.add(nameLabel, BorderLayout.WEST);
        row.add(valueLabel, BorderLayout.EAST);

        return row;
    }

    private JPanel createSingleValueRow(JLabel valueLabel)
    {
        JPanel row = new JPanel(new BorderLayout());
        row.setBackground(ColorScheme.DARKER_GRAY_COLOR);
        row.setAlignmentX(Component.LEFT_ALIGNMENT);
        row.setMaximumSize(new Dimension(Integer.MAX_VALUE, 22));

        valueLabel.setHorizontalAlignment(SwingConstants.LEFT);
        row.add(valueLabel, BorderLayout.WEST);

        return row;
    }

    private JPanel createHunterSection()
    {
        JPanel section = createSection("Hunter");
        section.add(createRow("Level", hunterLevelValue));
        section.add(createRow("XP", hunterXpValue));
        section.add(createRow("XP to next", xpToNextLevelValue));
        return section;
    }

    private JPanel createTargetSection()
    {
        JPanel section = createSection("Target");
        section.add(createRow("Creature", targetCreatureValue));
        return section;
    }

    private JPanel createSessionSection()
    {
        JPanel section = createSection("Session");
        section.add(createRow("Catches", catchesValue));
        section.add(createRow("XP gained", xpGainedValue));
        section.add(createRow("XP/hr", xpPerHourValue));
        section.add(createRow("ETA", etaValue));
        return section;
    }

    private static JLabel createValueLabel(String text)
    {
        return new JLabel(text);
    }
}
