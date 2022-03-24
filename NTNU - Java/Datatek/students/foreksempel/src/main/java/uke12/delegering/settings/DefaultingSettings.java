package uke12.delegering.settings;

public class DefaultingSettings implements ISettings {

	private ISettings userSettings = new MapSettings();
	private ISettings defaultSettings = new MapSettings();

	public DefaultingSettings(ISettings defaultSettings) {
		this.defaultSettings = defaultSettings;
	}

	@Override
	public boolean hasSetting(final String s) {
		return userSettings.hasSetting(s) || defaultSettings.hasSetting(s);
	}

	@Override
	public Object getSetting(final String s) {
		if (userSettings.hasSetting(s)) {
			return userSettings.getSetting(s);
		}
		if (defaultSettings != null) {
			return defaultSettings.getSetting(s);
		}
		return null;
	}

	@Override
	public void updateSetting(final String s, final Object o) {
		userSettings.updateSetting(s, o);
	}

	//

	public static void main(final String[] args) {

		// HUSK KLASSEDIAGRAM UNDER
		ISettings installationSettings = new MapSettings();
		ISettings d2 = new DefaultingSettings(installationSettings);
		ISettings appSettings = new DefaultingSettings(d2);

		installationSettings.updateSetting("theme", "light");
		installationSettings.updateSetting("font", "times new roman");
		installationSettings.updateSetting("fullscreen", "yes");
		System.out.println("\nupdating installationSettings");
		System.out.println("Font: "+appSettings.getSetting("font"));
		System.out.println("Theme: "+appSettings.getSetting("theme"));
		System.out.println("Fullscreen: "+appSettings.getSetting("fullscreen"));

		System.out.println("\nupdating workspaceSettings");
		d2.updateSetting("font", "default, comic sans");
		System.out.println("Font: "+appSettings.getSetting("font"));
		System.out.println("Theme: "+appSettings.getSetting("theme"));
		System.out.println("Fullscreen: "+appSettings.getSetting("fullscreen"));

		System.out.println("\nupdating projectSettings");
		appSettings.updateSetting("theme", "dark");
		System.out.println("Font: "+appSettings.getSetting("font"));
		System.out.println("Theme: "+appSettings.getSetting("theme"));
		System.out.println("Fullscreen: "+appSettings.getSetting("fullscreen"));
	}

		/*
	 * @startuml
	 * object "appSettings: DefaultingSettings" as appSettings
	 * object "projectSettings: MapSettings" as project
	 * object "map1: Map" as map1
	 * object "ds2: DefaultingSettings" as ds2
	 * object "workspaceSettings: MapSettings" as workspace
	 * object "map2: Map" as map2
	 * object "installationSettings: MapSettings" as installation
	 * object "map3: Map" as map3
	 * appSettings -down-> project: settings
	 * project -down-> map1: settings
	 * appSettings -down-> ds2: defaultSettings
	 * ds2 -down-> workspace: settings
	 * workspace -down-> map2: settings
	 * ds2 -down-> installation: defaultSettings
	 * installation -down-> map3: settings
	 * @enduml
	 */

}
