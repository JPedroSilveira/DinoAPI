package br.ufrgs.inf.pet.dinoapi.constants;

public class UserSettingsConstants {
    public final static int LANGUAGE_MAX = 50;
    public final static int LANGUAGE_MIN = 1;
    public final static String LANGUAGE_SIZE_MESSAGE = "language should be between "+LANGUAGE_MIN+" and " + LANGUAGE_MAX + " characters";
    public final static String LANGUAGE_NULL_MESSAGE = "language cannot be null";

    public final static String COLOR_THEME__NULL_MESSAGE = "colorTheme cannot be null.";

    public final static String FONT_SIZE__NULL_MESSAGE = "fontSize cannot be null.";

    public final static String INVALID_COLOR_THEME = "invalid colorTheme";

    public final static String INVALID_FONT_SIZE = "invalid fontSize";

    public final static String INCLUDE_ESSENTIAL_CONTACT_NULL_MESSAGE = "includeEssentialContact cannot be null";

    public final static String DECLINE_GOOGLE_CONTACTS_NULL_MESSAGE = "declineGoogleContacts cannot be null";

    public final static String SETTINGS_STEP_NULL_MESSAGE = "settingsStep cannot be null";

    public final static String FIRST_SETTINGS_DONE_NULL_MESSAGE = "firstSettingsDone cannot be null";
}