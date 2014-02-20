/*
 * Copyright (C) 2014 Team OCtOS
 * Warning: Tentacles may sting!
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.oct.tentacles.quicksettings;

import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import android.provider.Settings;
import android.os.UserHandle;

import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;

public class NotificationDrawer extends SettingsPreferenceFragment implements
        Preference.OnPreferenceChangeListener {
    private static final String TAG = "NotificationDrawer";

    private static final String PRE_COLLAPSE_PANEL = "collapse_panel";

    private CheckBoxPreference mCollapsePanel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.notification_drawer);
        PreferenceScreen prefScreen = getPreferenceScreen();
    }


    public boolean onPreferenceChange(Preference preference, Object objValue) {
        if (preference == mCollapsePanel) {
            Settings.System.putIntForUser(getContentResolver(),
                    Settings.System.QS_COLLAPSE_PANEL,
                    (Boolean) objValue ? 1 : 0, UserHandle.USER_CURRENT);
            return true;
        }

        return false;
    }
}
